package com.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.exception.ExpiredTokenException;
import com.app.exception.InvalidTokenException;
import com.app.exception.PasswordMismatchException;
import com.app.exception.UserNotFoundException;
import com.app.exception.UserPresentWithThatEmail;
import com.app.model.Token;
import com.app.model.User;
import com.app.repository.TokenRepository;
import com.app.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bcryptencoder;
	private final TokenRepository tokenRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bcryptencoder,TokenRepository tokenRepository) {
		this.userRepository = userRepository;
		this.bcryptencoder = bcryptencoder;
		this.tokenRepository = tokenRepository;
		
	}
	
	@Override
	public User signUp(String name, String email, String password) throws UserPresentWithThatEmail {
		  Optional<User> optionUser = this.userRepository.findUserByEmail(email);
		  if(optionUser.isPresent()) {
			  throw new UserPresentWithThatEmail("user present with that email");
		  }
		  
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		          String encodedPassword = encoder.encode(password);
		  
		  User user = new User();
		  user.setName(name);
		  user.setEmail(email);
		  user.setPassword(encodedPassword);
		  
		  System.out.println("user details : "  + user.getEmail() + ", " + user.getName() +" , " + user.getPassword());
		   
		  return this.userRepository.save(user);		  
		
	}

	@Override
	public Token login(String email, String password) throws Exception {
		//we will send plain text , db contains encode password using matches method we can check both.
		Optional<User> optionUser =this.userRepository.findUserByEmail(email);
		User user =optionUser.orElseThrow(()-> new UserNotFoundException("User not found"));
		
		boolean matches =this.bcryptencoder.matches(password, user.getPassword());
		if(matches) {
			//Issue token
			String value = RandomStringUtils.randomAlphanumeric(128);
			//expires after 30 days
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, 30);
			Date thirtyDaysLater = c.getTime();
			
			Token tok = new Token();
			tok.setUserToken(user);
			tok.setValue(value);
			tok.setActive(true);
			tok.setExpiredAt(thirtyDaysLater);
			
			return this.tokenRepository.save(tok);
			
		}else {
			//throw exception
			throw new PasswordMismatchException("Password is incorrect");
		}	
	}

	@Override
	public Token validateToken(String tokenValue) throws InvalidTokenException,ExpiredTokenException {
		// 1. Fetch the token from db using value(select * from tokens where value={value}
		//2.If token is not present in db, throw exception
		//3. Else check whether the token has expired or not
		//4, If token is expired, then throw Exception
		//5. Else return the token
		Optional<Token> tokenByvalue = this.tokenRepository.findTokenByValue(tokenValue);
		System.out.println(" ccccc : " + tokenValue);
		Token token  =tokenByvalue.orElseThrow(() ->  new InvalidTokenException("Please use a valid token"));
		
		Date expiresAt = token.getExpiredAt();
		Date now = new Date();
		//If now is greater than expires at
		//user might logout then this check is useful
		if(now.after(expiresAt) || !token.isActive()) {
			throw new ExpiredTokenException("Token has expired");
		}
		
		return token;
	}

	@Override
	public void logout(String tokenvalue) throws Exception {
		//1.Fetch token from db
		//2. If token not present, thren return 400
		// 3. else set the isactive to false and return 
		Optional<Token> optionUser = this.tokenRepository.findTokenByValue(tokenvalue);
		Token token  = optionUser.orElseThrow(() ->  new InvalidTokenException("Please use a valid token"));
		
		if(token.isActive()) {
			token.setActive(false);
			this.tokenRepository.save(token);			
		}
		
	}
	

}

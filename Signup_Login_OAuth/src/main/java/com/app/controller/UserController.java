package com.app.controller;

import javax.naming.NameNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDTO;
import com.app.dto.LogoutRequestDTO;
import com.app.dto.SignupRequestDTO;
import com.app.dto.ValidateTokenRequestDTO;
import com.app.exception.EmailNotFoundException;
import com.app.exception.ExpiredTokenException;
import com.app.exception.InvalidTokenException;
import com.app.exception.PasswordNotFoundException;
import com.app.model.Token;
import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> signUp(@RequestBody SignupRequestDTO requestDto) {
		
		try {
			if(requestDto.getName().isEmpty() || requestDto.getName() == null || requestDto.getName().isBlank()) {
				throw new NameNotFoundException("Name doesn't exist");
			}
			if(requestDto.getEmail().isEmpty() || requestDto.getEmail() == null || requestDto.getEmail().isBlank()) {
				throw new EmailNotFoundException("Email doesn't exist");
			}
			if(requestDto.getPassword().isEmpty() || requestDto.getPassword() == null || requestDto.getPassword().isBlank()) {
				throw new PasswordNotFoundException("Password doesn't exist" ); 
			}
			User user =this.userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
					System.out.println("user details" + user.getEmail() +", "+ user.getName()+ ","+user.getPassword());
			return new  ResponseEntity<User>(user, HttpStatusCode.valueOf(201));
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatusCode.valueOf(402));
		}
			
	}
	@PostMapping("/login")
	public ResponseEntity<Token> login(@RequestBody LoginRequestDTO requestDto) {
		
		try {
			//TODO BASIC VALIDATIONS - email ,password should be there otherwise throw 400.
			Token token =this.userService.login(requestDto.getEmail(), requestDto.getPassword());
			return new ResponseEntity<>(token, HttpStatusCode.valueOf(200));
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(400));			
		}
	
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Token> logout(@RequestBody LogoutRequestDTO requestDto) {
		try {
			//TOD0 basic validations
			this.userService.logout(requestDto.getToken());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/validate-token")
	public ResponseEntity<Token> validateToken(@RequestBody ValidateTokenRequestDTO tokenDto) {
		System.out.println("checking   :   "+ tokenDto.getToken());
		try {
			//Todo token value should be non empty
			Token token = this.userService.validateToken(tokenDto.getToken());
			return new ResponseEntity<>(token ,HttpStatusCode.valueOf(200));
		}catch(ExpiredTokenException ete) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(401));
		}catch(InvalidTokenException ite) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(400));
		}
	
	}

}

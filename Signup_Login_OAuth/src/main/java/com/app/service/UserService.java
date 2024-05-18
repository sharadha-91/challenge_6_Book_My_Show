package com.app.service;

import com.app.exception.ExpiredTokenException;
import com.app.exception.InvalidTokenException;
import com.app.exception.UserPresentWithThatEmail;
import com.app.model.Token;
import com.app.model.User;

public interface UserService {

	public User signUp(String name, String email, String password) throws UserPresentWithThatEmail;
	public Token login(String email, String password)throws Exception;
	public Token validateToken(String tokenValue)throws InvalidTokenException,ExpiredTokenException;
	
	public void logout(String token)throws Exception;
}

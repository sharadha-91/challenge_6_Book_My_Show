package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	
	public Optional<Token> findTokenByValue(String value); 

}
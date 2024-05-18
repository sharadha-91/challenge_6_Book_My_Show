package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.exception.UserPresentWithThatEmail;
import com.app.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findUserByEmail(String email)throws UserPresentWithThatEmail;

}

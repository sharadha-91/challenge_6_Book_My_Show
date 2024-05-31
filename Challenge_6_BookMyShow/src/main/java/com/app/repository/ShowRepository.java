package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Show;

public interface ShowRepository extends JpaRepository<Show, Integer>{
	
}

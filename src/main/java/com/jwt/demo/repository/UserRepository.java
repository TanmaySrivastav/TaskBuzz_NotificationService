package com.jwt.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	public Optional<User> findByEmail(String email);
	
	

}

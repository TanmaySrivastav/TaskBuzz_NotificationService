package com.todolistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolistapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

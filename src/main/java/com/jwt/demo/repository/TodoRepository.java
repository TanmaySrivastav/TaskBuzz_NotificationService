package com.jwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.demo.entities.Todo;



public interface TodoRepository extends JpaRepository<Todo,Long>  {

}

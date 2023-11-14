package com.todolistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolistapp.entity.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Long> {

}

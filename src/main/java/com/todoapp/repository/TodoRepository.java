package com.todoapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoapp.entity.Todo;

public interface TodoRepository extends MongoRepository<Todo, String>{

	
	List<Todo> findByTitleContaining(String title);
}

package com.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entity.Todo;
import com.todoapp.repository.TodoRepository;

@Service
public class TodoService {

	
	@Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(String id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).orElse(null);
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setAddTime(todo.getAddTime());
        return todoRepository.save(existingTodo);
    }

    public void deleteTodoById(String id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> searchTodos(String title) {
        return todoRepository.findByTitleContaining(title);
    }
}

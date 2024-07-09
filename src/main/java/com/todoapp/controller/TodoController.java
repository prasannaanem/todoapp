package com.todoapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todoapp.entity.Todo;
import com.todoapp.service.TodoService;

@Controller
public class TodoController {
	
	
	@Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Todo> todoList = todoService.getAllTodos();
        model.addAttribute("todoList", todoList);
        return "index";
    }

    @GetMapping("/new")
    public String showNewTodoForm(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "new_todo";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todo") Todo todo, @RequestParam("addTime") String addTime) {
        todo.setAddTime(LocalDateTime.parse(addTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        todoService.createTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodoForm(@PathVariable("id") String id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit_todo";
    }

    @PostMapping("/update")
    public String updateTodo(@ModelAttribute("todo") Todo todo, @RequestParam("addTime") String addTime) {
        todo.setAddTime(LocalDateTime.parse(addTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        todoService.updateTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") String id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchTodos(@RequestParam("title") String title, Model model) {
        List<Todo> todoList = todoService.searchTodos(title);
        model.addAttribute("todoList", todoList);
        return "index";
    }

}

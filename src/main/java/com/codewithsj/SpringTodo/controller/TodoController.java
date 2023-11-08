package com.codewithsj.SpringTodo.controller;

import com.codewithsj.SpringTodo.model.Todo;
import com.codewithsj.SpringTodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;
   @GetMapping("/todo/all")
    public List<Todo> getAllTodo(){

       return todoRepository.findAll();
    }
    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id){
       return todoRepository.findById(id);
    }
    @PostMapping("/todos")
    public List<Todo> insertTodo(@RequestBody Todo todo){
       return todoRepository.insert(todo);
    }

    @PutMapping("/todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        return todoRepository.update(todo);
    }

    @DeleteMapping("/todo/{id}")
    public List<Todo> deleteTodo(@PathVariable int id){
        return todoRepository.deleteById(id);
    }



}

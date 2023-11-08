package com.codewithsj.SpringTodo.repository;

import com.codewithsj.SpringTodo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Todo> findAll(){
        return jdbcTemplate.query("SELECT * FROM todo",
                new BeanPropertyRowMapper<>(Todo.class));
    }

    public Todo findById(int id){
        return jdbcTemplate.queryForObject("SELECT *FROM todo WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insert(Todo todo){
        jdbcTemplate.update("INSERT INTO todo(id,name,email) VALUES(?,?,?);",
                new Object[]{todo.getId(),todo.getName(),todo.getEmail()});
        return findAll();
    }

    public List<Todo> update(Todo todo) {
        jdbcTemplate.update("UPDATE todo SET name=?,email =? WHERE id=?;",
                new Object[]{todo.getName(),todo.getEmail(),todo.getId()});
        return findAll();



    }

    public List<Todo> deleteById(int id) {
        jdbcTemplate.update("DELETE FROM todo WHERE id=?;",
                new Object[]{id});
        return findAll();


    }
}

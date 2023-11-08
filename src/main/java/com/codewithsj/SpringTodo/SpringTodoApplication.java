package com.codewithsj.SpringTodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTodoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =SpringApplication.run(SpringTodoApplication.class, args);
	}

}

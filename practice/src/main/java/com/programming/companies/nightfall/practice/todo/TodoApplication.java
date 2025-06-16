package com.programming.companies.nightfall.practice.todo;

import com.programming.companies.nightfall.practice.todo.dto.TodoDto;
import com.programming.companies.nightfall.practice.todo.service.TodoService;
import com.programming.companies.nightfall.practice.todo.service.impl.TodoServiceImpl;

public class TodoApplication {

    public static void main(String[] args) {
        TodoService todoService = new TodoServiceImpl();
        try {
            TodoDto t1 = todoService.createTodo("Todo 1", "Todo 1 Description");
            TodoDto t2 = todoService.createTodo("Todo 2", "Todo 2 Description");

            todoService.getTodos().stream().forEach(System.out::println);

            todoService.updateTodo(t1.getId(), null, null, null);

            todoService.deleteTodo(t2.getId());

            todoService.getTodos().stream().forEach(System.out::println);

            todoService.getTodoById(t2.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

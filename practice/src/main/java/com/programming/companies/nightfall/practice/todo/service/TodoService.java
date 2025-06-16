package com.programming.companies.nightfall.practice.todo.service;

import java.util.List;

import com.programming.companies.nightfall.practice.todo.dto.TodoDto;
import com.programming.companies.nightfall.practice.todo.exception.TodoNotFoundException;

public interface TodoService {

    List<TodoDto> getTodos();

    TodoDto getTodoById(long id);

    TodoDto createTodo(String title, String description);

    TodoDto updateTodo(long id, String title, String description, Boolean completed) throws TodoNotFoundException;

    void deleteTodo(long id) throws TodoNotFoundException;
}

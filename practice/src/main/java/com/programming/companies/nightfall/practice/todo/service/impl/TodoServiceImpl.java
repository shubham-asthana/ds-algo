package com.programming.companies.nightfall.practice.todo.service.impl;

import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.practice.todo.dto.TodoDto;
import com.programming.companies.nightfall.practice.todo.exception.TodoNotFoundException;
import com.programming.companies.nightfall.practice.todo.service.TodoService;

public class TodoServiceImpl implements TodoService {

    private final Map<Long, TodoDto> todoStore = new HashMap<>();

    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public synchronized List<TodoDto> getTodos() {
        return todoStore.values().stream().sorted(Comparator.comparingLong(TodoDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public synchronized TodoDto getTodoById(long id) {
        TodoDto todo = todoStore.get(id);
        if (null == todo) {
            throw new TodoNotFoundException(id);
        }
        return todo;
    }

    @Override
    public synchronized TodoDto createTodo(String title, String description) {
        long id = nextId.getAndIncrement();
        TodoDto todoDto = new TodoDto(id, title, description, false, Instant.now(), null);
        todoStore.put(id, todoDto);
        return todoDto;
    }

    @Override
    public synchronized TodoDto updateTodo(long id, String title, String description, Boolean completed)
            throws TodoNotFoundException {
        TodoDto todo = todoStore.get(id);
        if (null == todo) {
            throw new TodoNotFoundException(id);
        }
        if (StringUtils.isNotBlank(title)) {
            todo.setTitle(title);
        }
        if (StringUtils.isNotBlank(description)) {
            todo.setDescription(description);
        }
        if (null != completed) {
            todo.setCompleted(completed);
        }
        todo.setUpdatedAt(Instant.now());
        return todo;
    }

    @Override
    public synchronized void deleteTodo(long id) throws TodoNotFoundException {
        TodoDto todo = todoStore.remove(id);
        if (null == todo) {
            throw new TodoNotFoundException(id);
        }
    }
}

package com.programming.companies.nightfall.practice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.practice.todo.dto.TodoDto;
import com.programming.companies.nightfall.practice.todo.exception.TodoNotFoundException;
import com.programming.companies.nightfall.practice.todo.service.TodoService;
import com.programming.companies.nightfall.practice.todo.service.impl.TodoServiceImpl;

public class TodoServiceTest {

    private TodoService todoService;

    @BeforeEach
    void setup() {
        todoService = new TodoServiceImpl();
    }

    @Test
    void testCreateAndGetTodo() {
        TodoDto todo = todoService.createTodo("Test 1", "Test Description 1");
        assertNotNull(todo);
        assertEquals("Test 1", todo.getTitle());
        assertFalse(todo.isCompleted());

        TodoDto fetched = todoService.getTodoById(todo.getId());
        assertEquals("Test 1", fetched.getTitle());
    }

    @Test
    void testNotFoundTodo() {
        assertThrows(TodoNotFoundException.class, () -> todoService.getTodoById(456L));
    }

    @Test
    void testListTodos() {
        todoService.createTodo("Test 1", "Test Description 1");
        todoService.createTodo("Test 2", "Test Description 2");
        List<TodoDto> list = todoService.getTodos();
        assertEquals(2, list.size());
        assertEquals(1, list.get(0).getId());
        assertEquals(2, list.get(1).getId());
    }

    @Test
    void testDeleteTodo() {
        TodoDto todo = todoService.createTodo("Test 1", "Test Description 1");
        assertEquals(1, todoService.getTodos().size());
        todoService.deleteTodo(todo.getId());
        assertThrows(TodoNotFoundException.class, () -> todoService.getTodoById(456L));
    }

    @Test
    void testUpdateTodo() {
        TodoDto created = todoService.createTodo("Test 1", "Test Description 1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TodoDto updated = todoService.updateTodo(created.getId(), "Test 1 Updated", null, true);
        assertEquals("Test 1 Updated", updated.getTitle());
        assertEquals("Test Description 1", updated.getDescription());
        assertNotNull(updated.getUpdatedAt());
    }
}

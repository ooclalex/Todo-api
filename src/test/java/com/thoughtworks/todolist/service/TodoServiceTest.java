package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.model.Todo;
import com.thoughtworks.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoRepository todoRepository;

    @Test
    void should_return_todo_when_add_todo_given_no_todos() {
        //given
        Todo todo = new Todo("task 1", false);
        when(todoRepository.save(todo)).thenReturn(todo);

        //when
        final Todo actual = todoService.add(todo);

        //then
        assertEquals(todo, actual);
    }

    @Test
    void should_return_all_todos_when_get_all_todos_given_todos() {
        //given
        Todo todo = new Todo("task 1", false);
        final List<Todo> expected = Collections.singletonList(todo);
        todoService.add(todo);
        when(todoRepository.findAll()).thenReturn(expected);

        //when
        final List<Todo> actual = todoService.getAll();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_specific_todo_when_get_todo_given_todo_id() throws Exception {
        //given
        Todo todo = new Todo("task 1", false);
        todoService.add(todo);
        when(todoRepository.findById("1")).thenReturn(java.util.Optional.of(todo));

        //when
        final Todo actual = todoService.get("1");

        //then
        assertEquals(todo, actual);
    }

    @Test
    void should_return_updated_todo_when_update_todo_given_todo_new_todo() throws Exception {
        //given
        Todo oldTodo = new Todo("task 1", false);
        oldTodo.setId("1");

        Todo newTodo = new Todo("task 1", true);
        when(todoRepository.findById("1")).thenReturn(java.util.Optional.of(newTodo));
        when(todoRepository.save(newTodo)).thenReturn(newTodo);

        //when
        final Todo actual = todoService.update(oldTodo.getId(), newTodo);

        //then
        assertEquals(newTodo, actual);
    }
}

package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.dto.TodoRequest;
import com.thoughtworks.todolist.dto.TodoResponse;
import com.thoughtworks.todolist.mapper.TodoMapper;
import com.thoughtworks.todolist.model.Todo;
import com.thoughtworks.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    private final TodoMapper todoMapper;

    public TodoController(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @GetMapping
    public List<TodoResponse> getAll() {
        return todoService.getAll().stream()
                .map(todoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse create(@RequestBody TodoRequest todoRequest) {
        Todo todo = todoService.add(todoMapper.toEntity(todoRequest));
        return todoMapper.toResponse(todo);
    }

    @PutMapping("/{id}")
    public TodoResponse update(@PathVariable String id, @RequestBody Todo todo) throws Exception {
        return todoMapper.toResponse(todoService.update(id, todo));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        todoService.delete(id);
    }
}

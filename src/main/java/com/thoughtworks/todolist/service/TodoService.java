package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.model.Todo;
import com.thoughtworks.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo get(String id) throws Exception {
        return todoRepository.findById(id).orElseThrow(Exception::new);
    }

    public Todo update(String id, Todo newTodo) throws Exception {
        Todo todo = this.get(id);
        todo.setText(newTodo.getText());
        todo.setDone(newTodo.isDone());
        return todoRepository.save(todo);
    }
}

package com.thoughtworks.todolist.model;

public class Todo {
    private String id;
    private String text;
    private boolean done;

    public Todo(String text) {
        this.text = text;
        this.done = false;
    }

    public Todo() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

package com.thoughtworks.todolist.dto;

public class TodoRequest {
    private String text;
    private boolean done;

    public TodoRequest() {

    }

    public TodoRequest(String text, boolean done) {
        this.text = text;
        this.done = done;
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

package com.thoughtworks.todolist.model;

import java.util.List;

public class Todo {
    private String id;
    private String text;
    private boolean done;
    private List<String> tags;

    public Todo(String text, boolean done, List<String> tags) {
        this.text = text;
        this.done = done;
        this.tags = tags;
    }
    public Todo() {

    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

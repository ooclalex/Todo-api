package com.thoughtworks.todolist.dto;

import java.util.List;

public class TodoRequest {
    private String text;
    private boolean done;
    private List<String> tags;

    public TodoRequest() {

    }

    public TodoRequest(String text, boolean done, List<String> tags) {
        this.text = text;
        this.done = done;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

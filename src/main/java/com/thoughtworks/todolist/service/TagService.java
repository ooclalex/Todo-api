package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.model.Tag;
import com.thoughtworks.todolist.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public Tag add(Tag tag) {
        return null;
    }
}

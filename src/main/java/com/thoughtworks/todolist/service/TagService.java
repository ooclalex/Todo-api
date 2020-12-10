package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.model.Tag;
import com.thoughtworks.todolist.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public Tag add(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Tag update(String id, Tag newTag) throws Exception {
        Tag tag = tagRepository.findById(id).orElseThrow(Exception::new);
        tag.setColor(newTag.getColor());
        tag.setContent(newTag.getContent());
        return tagRepository.save(tag);
    }

    public void delete(String s) {
    }
}

package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.model.Tag;
import com.thoughtworks.todolist.model.Todo;
import com.thoughtworks.todolist.repository.TagRepository;
import com.thoughtworks.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @InjectMocks
    private TagService tagService;
    @Mock
    private TagRepository tagRepository;

    @Test
    void should_return_tag_when_add_tag_given_no_tag() {
        //given
        Tag tag = new Tag("content 1", "red");
        when(tagRepository.save(tag)).thenReturn(tag);

        //when
        final Tag actual = tagService.add(tag);

        //then
        assertEquals(tag, actual);
    }
}

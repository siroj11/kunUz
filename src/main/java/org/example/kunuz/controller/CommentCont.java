package org.example.kunuz.controller;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommentCont {
    @Autowired
    CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> getAll() {
        return commentService.read();
    }

    @PostMapping("/comment")
    public Result add(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping("/comment/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        return commentService.update(commentDto, id);
    }

    @DeleteMapping("/comment/{id}")
    public Result remove(@PathVariable Integer id) {
        return commentService.delete(id);
    }
}
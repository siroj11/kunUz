package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ArticleCont {
    @Autowired
    ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getAll() {
        return articleService.read();
    }

    @PostMapping("/article")
    public Result add(@RequestBody ArticleDto articleDto) {
        return articleService.create(articleDto);
    }

    @PutMapping("/article/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ArticleDto articleDto) {
        return articleService.update(articleDto, id);
    }

    @DeleteMapping("/article/{id}")
    public Result remove(@PathVariable Integer id) {
        return articleService.delete(id);
    }
}
package org.example.kunuz.controller;

import org.example.kunuz.dto.ArticleTypeDto;
import org.example.kunuz.model.ArticleType;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ArticleTypeCont {
    @Autowired
    ArticleTypeService articleTypeService;

    @GetMapping("/articletype")
    public List<ArticleType> getAll() {
        return articleTypeService.read();
    }

    @PostMapping("/articletype")
    public Result add(@RequestBody ArticleTypeDto articleTypeDto) {
        return articleTypeService.create(articleTypeDto);
    }

    @PutMapping("/articletype/{id}")
    public Result edit(@RequestBody ArticleTypeDto articleTypeDto,@PathVariable Integer id) {
        return articleTypeService.update(articleTypeDto,id);
    }

    @DeleteMapping("/articletype/{id}")
    public Result remove(@PathVariable Integer id) {
        return articleTypeService.delete(id);
    }
}
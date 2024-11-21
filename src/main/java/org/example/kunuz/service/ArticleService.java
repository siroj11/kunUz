package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ArticleService {
    @Autowired
    ArticleRepo articleRepo;

    public List<Article> read() {
        return articleRepo.findAll();
    }

    public Result create(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setContent(articleDto.getContent());
        article.setShared_Count(articleDto.getShared_Count());
        article.setImageId(articleDto.getImageId());
        article.setRegionId(articleDto.getRegionId());
        article.setCategoryId(articleDto.getCategoryId());
        article.setModeratorId(articleDto.getModeratorId());
        article.setPublisherId(articleDto.getPublisherId());
        article.setStatus(articleDto.getStatus());
        article.setCreated_date(articleDto.getCreated_date());
        article.setPublished_date(articleDto.getPublished_date());
        article.setVisible(articleDto.getVisible());
        article.setView_count(articleDto.getView_count());
        articleRepo.save(article);
        return new Result(true,"Article created successfully");
    }

    public Result update(ArticleDto articleDto,Integer id) {
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle(articleDto.getTitle());
            article.setDescription(articleDto.getDescription());
            article.setContent(articleDto.getContent());
            article.setShared_Count(articleDto.getShared_Count());
            article.setImageId(articleDto.getImageId());
            article.setRegionId(articleDto.getRegionId());
            article.setCategoryId(articleDto.getCategoryId());
            article.setModeratorId(articleDto.getModeratorId());
            article.setPublisherId(articleDto.getPublisherId());
            article.setStatus(articleDto.getStatus());
            article.setCreated_date(articleDto.getCreated_date());
            article.setPublished_date(articleDto.getPublished_date());
            articleRepo.save(article);
            return new Result(true,"Article updated successfully");
        }
        return new Result(false,"Article not found");
    }

    public Result delete(Integer id) {
        articleRepo.deleteById(id);
        return new Result(true,"Article deleted successfully");
    }
}
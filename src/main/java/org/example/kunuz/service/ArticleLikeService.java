package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.model.ArticleLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLikeService {
    @Autowired
    ArticleLikeRepo articleLikeRepo;

    public List<ArticleLike> read() {
        return articleLikeRepo.findAll();
    }

    public Result create(ArticleLikeDto articleLikeDto) {
        ArticleLike articleLike = new ArticleLike();
        articleLike.setCreated_date(articleLikeDto.getCreated_date());
        articleLike.setArticle_id(articleLikeDto.getArticle_id());
        articleLike.setStatus(articleLikeDto.getStatus());
        articleLike.setProfile_id(articleLikeDto.getProfile_id());
        articleLikeRepo.save(articleLike);
        return new Result(true, "Category created successfully");
    }

    public Result update(ArticleLikeDto articleLikeDto, Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = new Category();
            category.setName_en(categoryDto.getName_en());
            category.setName_uz(categoryDto.getName_uz());
            category.setName_ru(categoryDto.getName_ru());
            category.setOrder_number(categoryDto.getOrder_number());
            category.setCreated_date(categoryDto.getCreated_date());
            category.setVisible(categoryDto.getVisible());
            categoryRepo.save(category);
            return new Result(true, "Category updated successfully");
        }
        return new Result(false, "Category not found");
    }

    public Result delete(Integer id) {
        articleLikeRepo.deleteById(id);
        return new Result(true, "Category deleted successfully");
    }
}

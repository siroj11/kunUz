package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.model.ArticleLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return new Result(true, "ArticleLike created successfully");
    }

    public Result update(ArticleLikeDto articleLikeDto, Integer id) {
        Optional<ArticleLike> articleLikeOptional = articleLikeRepo.findById(Long.valueOf(id));
        if (articleLikeOptional.isPresent()) {
            ArticleLike articleLike = articleLikeOptional.get();
            articleLike.setCreated_date(articleLikeDto.getCreated_date());
            articleLike.setArticle_id(articleLikeDto.getArticle_id());
            articleLike.setStatus(articleLikeDto.getStatus());
            articleLike.setProfile_id(articleLikeDto.getProfile_id());
            articleLikeRepo.save(articleLike);
            return new Result(true, "ArticleLike updated successfully");
        }
        return new Result(false, "ArticleLike not found");
    }

    public Result delete(Integer id) {
        articleLikeRepo.deleteById(Long.valueOf(id));
        return new Result(true, "ArticleLike deleted successfully");
    }
}

package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleTypeDto;
import org.example.kunuz.model.ArticleType;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ArticleTypeService {
    @Autowired
    ArticleTypeRepo articleTypeRepo;

    public List<ArticleType> read() {
        return articleTypeRepo.findAll();
    }

    public Result create(ArticleTypeDto articleTypeDto) {
        ArticleType articleType = new ArticleType();
        articleType.setOrder_number(articleTypeDto.getOrder_number());
        articleType.setName_uz(articleTypeDto.getName_uz());
        articleType.setName_ru(articleTypeDto.getName_ru());
        articleType.setName_eng(articleTypeDto.getName_eng());
        articleType.setVisible(articleTypeDto.getVisible());
        articleType.setCreated_date(articleTypeDto.getCreated_date());
        articleTypeRepo.save(articleType);
        return new Result(true,"ArticleType created successfully");
    }

    public Result update(ArticleTypeDto articleTypeDto,Integer id) {
        Optional<ArticleType> optionalArticleType = articleTypeRepo.findById(id);
        if (optionalArticleType.isPresent()) {
            ArticleType articleType = optionalArticleType.get();
            articleType.setOrder_number(articleTypeDto.getOrder_number());
            articleType.setName_uz(articleTypeDto.getName_uz());
            articleType.setName_ru(articleTypeDto.getName_ru());
            articleType.setName_eng(articleTypeDto.getName_eng());
            articleType.setVisible(articleTypeDto.getVisible());
            articleType.setCreated_date(articleTypeDto.getCreated_date());
            articleTypeRepo.save(articleType);
            return new Result(true,"ArticleType updated successfully");
        }
        return new Result(false,"ArticleType not found");
    }

    public Result delete(Integer id) {
        articleTypeRepo.deleteById(id);
        return new Result(true,"ArticleType deleted successfully");
    }
}
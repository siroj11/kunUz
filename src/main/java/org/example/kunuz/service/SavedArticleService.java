package org.example.kunuz.service;

import org.example.kunuz.dto.SavedArticleDto;
import org.example.kunuz.model.Result;
import org.example.kunuz.model.SavedArticle;
import org.example.kunuz.repository.SavedArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {
    @Autowired
    SavedArticleRepo savedArticleRepo;

    public List<SavedArticle> read() {
        return savedArticleRepo.findAll();
    }

    public Result create(SavedArticleDto savedArticleDto) {
        SavedArticle savedArticle = new SavedArticle();
        savedArticle.setArticle_id(savedArticleDto.getArticle_id());
        savedArticle.setCreated_date(savedArticleDto.getCreated_date());
        savedArticle.setProfile_id(savedArticleDto.getProfile_id());
        savedArticleRepo.save(savedArticle);
        return new Result(true, "SavedArticle created successfully");
    }

    public Result update(SavedArticleDto savedArticleDto, Integer id) {
        Optional<SavedArticle> savedArticleOptional = savedArticleRepo.findById(id);
        if (savedArticleOptional.isPresent()) {
            SavedArticle savedArticle = savedArticleOptional.get();
            savedArticle.setArticle_id(savedArticleDto.getArticle_id());
            savedArticle.setProfile_id(savedArticleDto.getProfile_id());
            savedArticle.setCreated_date(savedArticleDto.getCreated_date());
            savedArticleRepo.save(savedArticle);
            return new Result(true, "SavedArticle updated successfully");
        }
        return new Result(false, "SavedArticle not found");
    }

    public Result delete(Integer id) {
        savedArticleRepo.deleteById(id);
        return new Result(true, "SavedArticle deleted successfully");
    }
}

package org.example.kunuz.service;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> read() {
        return categoryRepo.findAll();
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCreated_date(categoryDto.getCreated_date());
        category.setVisible(categoryDto.getVisible());
        category.setName_uz(categoryDto.getName_uz());
        category.setName_ru(categoryDto.getName_ru());
        category.setName_en(categoryDto.getName_en());
        category.setOrder_number(categoryDto.getOrder_number());
        categoryRepo.save(category);
        return new Result(true, "Category created successfully");
    }

    public Result update(CategoryDto categoryDto, Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
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
        categoryRepo.deleteById(id);
        return new Result(true, "Category deleted successfully");
    }
}

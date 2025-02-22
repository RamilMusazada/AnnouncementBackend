package org.example.announcementbackend.service;

import org.example.announcementbackend.dao.CategoryDao;
import org.example.announcementbackend.dto.CategoryDto;
import org.example.announcementbackend.entity.Category;
import org.example.announcementbackend.mapper.CategoryMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao = new CategoryDao();
    private final CategoryMapper categoryMapper = new CategoryMapper();

    @GetMapping
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryDao.findAll();
        return categoryMapper.toDtoList(categories);
    }
}

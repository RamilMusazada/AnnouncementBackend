package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dao.CategoryDao;
import org.example.announcementbackend.dto.CategoryDto;
import org.example.announcementbackend.entity.Category;
import org.example.announcementbackend.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryDao.findAll();
        return categoryMapper.toDtoList(categories);
    }
}

package org.example.announcementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dto.CategoryDto;
import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("api/v1/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }
}

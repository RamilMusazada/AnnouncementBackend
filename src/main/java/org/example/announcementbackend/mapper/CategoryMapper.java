package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.CategoryDto;
import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.entity.Category;
import org.example.announcementbackend.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryMapper {
    public CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
    public List<CategoryDto> toDtoList(List<Category> categoryList) {
        return categoryList.stream()
                .map(this::toDto)
                .toList();
    }
}

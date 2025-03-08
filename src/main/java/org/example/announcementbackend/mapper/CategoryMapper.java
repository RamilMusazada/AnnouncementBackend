package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.CategoryDto;
import org.example.announcementbackend.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    List<CategoryDto> toDtoList(List<Category> categoryList);

}

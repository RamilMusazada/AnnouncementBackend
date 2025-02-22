package org.example.announcementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private long categoryId;
    private String categoryName;
}

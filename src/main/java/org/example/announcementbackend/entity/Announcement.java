package org.example.announcementbackend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Announcement {
    private Long announcementId;
    private String name;
    private String description;
    private Long announcementNumber;
    private Double price;
    private String phoneNumber;
    private String sellerFullName;
    private Boolean delivery;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private City city;
    private Category category;
}

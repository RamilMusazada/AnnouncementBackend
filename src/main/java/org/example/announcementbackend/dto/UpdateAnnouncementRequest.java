package org.example.announcementbackend.dto;

import lombok.Data;

@Data
public class UpdateAnnouncementRequest {
    private String name;
    private String description;
    private Double price;
    private String sellerFullName;
    private Boolean delivery;
}

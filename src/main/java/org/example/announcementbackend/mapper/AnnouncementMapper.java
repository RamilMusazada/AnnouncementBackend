package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.CreateAnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
import org.example.announcementbackend.dto.UpdateAnnouncementRequest;
import org.example.announcementbackend.entity.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    AnnouncementResponse toResponse(Announcement announcement);


    List<AnnouncementResponse> toDtoList(List<Announcement> announcements);

    @Mapping(target = "announcementNumber", expression = "java(generateAnnouncementNumber())")
    @Mapping(source = "cityId", target = "city.cityId")
    @Mapping(source = "categoryId", target = "category.categoryId")
    Announcement toEntity(CreateAnnouncementRequest request);

    Announcement toEntity(Long announcementId, UpdateAnnouncementRequest request);

    default Long generateAnnouncementNumber() {
        double d = Math.random() * 100000000;
        return (long) d;
    }
}

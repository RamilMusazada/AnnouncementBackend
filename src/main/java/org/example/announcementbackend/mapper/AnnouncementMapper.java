package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.AnnouncementDto;
import org.example.announcementbackend.entity.Announcement;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    AnnouncementDto toDto(Announcement announcement);

    List<AnnouncementDto> toDtoList(List<Announcement> announcements);

}

package org.example.announcementbackend.service;

import org.example.announcementbackend.dao.AnnouncementDao;
import org.example.announcementbackend.dto.AnnouncementDto;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.mapper.AnnouncementMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AnnouncementService {
    private final AnnouncementDao announcementDao = new AnnouncementDao();
    private final AnnouncementMapper announcementMapper = new AnnouncementMapper();
    @GetMapping
    public List <AnnouncementDto> getAnnouncements() {
        List<Announcement> announcements = announcementDao.findAll();
        return announcementMapper.toDtoList(announcements);
    }
}

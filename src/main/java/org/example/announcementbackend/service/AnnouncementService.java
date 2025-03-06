package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dao.AnnouncementDao;
import org.example.announcementbackend.dto.AnnouncementDto;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.mapper.AnnouncementMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementDao announcementDao;
    private final AnnouncementMapper announcementMapper;
    @GetMapping
    public List <AnnouncementDto> getAnnouncements() {
        List<Announcement> announcements = announcementDao.findAll();
        return announcementMapper.toDtoList(announcements);
    }
}

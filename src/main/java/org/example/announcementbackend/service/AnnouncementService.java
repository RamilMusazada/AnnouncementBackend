package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dao.AnnouncementDao;
import org.example.announcementbackend.dto.AnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
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
    public List<AnnouncementResponse> getAnnouncements() {
        List<Announcement> announcements = announcementDao.findAll();
        return announcementMapper.toDtoList(announcements);
    }

    public void createAnnouncement(AnnouncementRequest request) {
        Announcement announcement = announcementMapper.toEntity(request);
        announcementDao.create(announcement);
    }
}
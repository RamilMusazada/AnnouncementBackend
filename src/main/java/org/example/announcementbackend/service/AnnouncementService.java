package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.announcementbackend.dao.AnnouncementDao;
import org.example.announcementbackend.dto.CreateAnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
import org.example.announcementbackend.dto.UpdateAnnouncementRequest;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.mapper.AnnouncementMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementDao announcementDao;
    private final AnnouncementMapper announcementMapper;

    @GetMapping
    public List<AnnouncementResponse> getAnnouncements() {
        List<Announcement> announcements = announcementDao.findAll();
        log.info("Announcements found: {}", announcements);
        return announcementMapper.toDtoList(announcements);
    }

    public void createAnnouncement(CreateAnnouncementRequest request) {
        Announcement announcement = announcementMapper.toEntity(request);
        log.info("Announcement create entity: {}", announcement);

        announcementDao.create(announcement);
    }

    public void updateAnnouncement(Long announcementId, UpdateAnnouncementRequest request) {
        Announcement announcement = announcementMapper.toEntity(announcementId, request);
        log.info("Announcement update entity: {}", announcement);

        announcementDao.update(announcement);
    }

    public void deleteAnnouncement(Long announcementId) {

        announcementDao.delete(announcementId);
    }

    public AnnouncementResponse getById(Long announcementId) {
        Announcement announcement = announcementDao.getById(announcementId);
        log.info("Announcement found: {}", announcement);

        return announcementMapper.toResponse(announcement);
    }
}
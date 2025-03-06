package org.example.announcementbackend.controller;

import org.example.announcementbackend.dto.AnnouncementDto;
import org.example.announcementbackend.service.AnnouncementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/announcements")
@RestController
public class AnnouncementController {
    private final AnnouncementService announcementService = new  AnnouncementService();
    @GetMapping
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementService.getAnnouncements();
    }
}

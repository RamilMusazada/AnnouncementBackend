package org.example.announcementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dto.AnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
import org.example.announcementbackend.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/announcements")
@RestController
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping
    public List<AnnouncementResponse> getAllAnnouncements() {
        return announcementService.getAnnouncements();
    }
    @PostMapping
    public void create (@RequestBody AnnouncementRequest request) {
        announcementService.createAnnouncement(request);
    }
}

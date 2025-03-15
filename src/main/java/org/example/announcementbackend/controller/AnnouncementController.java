package org.example.announcementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dto.CreateAnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
import org.example.announcementbackend.dto.UpdateAnnouncementRequest;
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
    public void create (@RequestBody CreateAnnouncementRequest request) {
        announcementService.createAnnouncement(request);
    }
    @PutMapping("/{announcementId}") //path variable
    public void update(@PathVariable("announcementId") Long announcementId,
                       @RequestBody UpdateAnnouncementRequest request) {
        announcementService.updateAnnouncement(announcementId, request);
    }

    @DeleteMapping("/{announcementId}")
    public void delete(@PathVariable("announcementId") Long announcementId) {
        announcementService.deleteAnnouncement(announcementId);
    }

    @GetMapping("/{announcementId}")
    public AnnouncementResponse getById(@PathVariable("announcementId") Long announcementId) {
        return announcementService.getById(announcementId);
    }
}

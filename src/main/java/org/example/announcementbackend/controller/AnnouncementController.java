package org.example.announcementbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.announcementbackend.dto.CreateAnnouncementRequest;
import org.example.announcementbackend.dto.AnnouncementResponse;
import org.example.announcementbackend.dto.UpdateAnnouncementRequest;
import org.example.announcementbackend.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("api/v1/announcements")
@RestController
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping
    public List<AnnouncementResponse> getAllAnnouncements() {
        log.info("Get all announcements API is called");
        return announcementService.getAnnouncements();
    }

    @PostMapping
    public void create(@RequestBody @Valid CreateAnnouncementRequest request) {
        log.info("Create announcement API is called , request : {}", request);
        announcementService.createAnnouncement(request);
    }

    @PutMapping("/{announcementId}") //path variable
    public void update(@PathVariable("announcementId") Long announcementId,
                       @RequestBody UpdateAnnouncementRequest request) {
        log.info("Update announcement API is called, announcementId: {}, request: {}",
                announcementId, request);
        announcementService.updateAnnouncement(announcementId, request);
    }

    @DeleteMapping("/{announcementId}")
    public void delete(@PathVariable("announcementId") Long announcementId) {
        log.info("Delete announcement API is called, announcementId: {}", announcementId);
        announcementService.deleteAnnouncement(announcementId);
    }

    @GetMapping("/{announcementId}")
    public AnnouncementResponse getById(@PathVariable("announcementId") Long announcementId) {
        log.info("Get announcement by ID API is called, announcementId: {}", announcementId);
        return announcementService.getById(announcementId);
    }
}

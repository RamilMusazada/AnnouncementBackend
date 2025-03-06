package org.example.announcementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/cities")
@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    @GetMapping
    public List<CityDto> getCities(){
        return cityService.getCities();
    }
}

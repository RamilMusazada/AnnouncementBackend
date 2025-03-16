package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.announcementbackend.dao.CityDao;
import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.entity.City;
import org.example.announcementbackend.mapper.CityMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityDao cityDao;
    private final CityMapper cityMapper;

    @GetMapping
    public List<CityDto> getCities() {
        log.info("Getting all cities");
        List<City> cities = cityDao.findAll();
        log.info("Cities found : {} ", cities);
        List<CityDto> cityDtoList = cityMapper.toCityDtoList(cities);

        return cityDtoList;
    }
}

package org.example.announcementbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.announcementbackend.dao.CityDao;
import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.entity.City;
import org.example.announcementbackend.mapper.CityMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityDao cityDao;
    private final CityMapper cityMapper;

    @GetMapping
    public List<CityDto> getCities() {
        List<City> cities = cityDao.findAll();
        List<CityDto> cityDtoList = cityMapper.toCityDtoList(cities);

        return cityDtoList;
    }
}

package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.entity.City;

import java.util.ArrayList;
import java.util.List;

public class CityMapper {
    public CityDto toCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setCityId(city.getCityId());
        cityDto.setName(city.getName());
        return cityDto;
    }

    public List <CityDto> toCityDtoList(List<City> cities) {
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City city : cities ){
            CityDto cityDto = new CityDto();
            cityDto.setCityId(city.getCityId());
            cityDto.setName(city.getName());
            cityDtoList.add(cityDto);
        }
        return cityDtoList;
    }
}

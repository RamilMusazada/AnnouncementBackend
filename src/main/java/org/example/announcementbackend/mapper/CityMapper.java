package org.example.announcementbackend.mapper;

import org.example.announcementbackend.dto.CityDto;
import org.example.announcementbackend.entity.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDto toDto(City city);

    List<CityDto> toCityDtoList(List<City> cities);
}

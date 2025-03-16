package org.example.announcementbackend.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.constant.QueryConstants;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.entity.City;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CityDao {
    public List<City> findAll() {
        log.info("Getting cities from DB");
        List<City> cities = new ArrayList<>();
        //try-with-resources
        try (Connection connection = DatabaseConfig.getConnection();) {
            Statement statement = connection.createStatement();
            log.error("Get city list query : {}", QueryConstants.GET_CATEGORY_LIST_QUERY);
            ResultSet resultSet = statement.executeQuery(QueryConstants.GET_CITY_LIST_QUERY);

            while (resultSet.next()) {
                Long id = resultSet.getLong("city_id");
                String name = resultSet.getString("name");
                City city = new City(id, name);
                cities.add(city);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }
}

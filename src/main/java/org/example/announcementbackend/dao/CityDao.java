package org.example.announcementbackend.dao;

import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.constant.QueryConstants;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.entity.City;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CityDao {
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        //try-with-resources
        try(Connection connection = DatabaseConfig.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QueryConstants.GET_CITY_LIST_QUERY);

            while (resultSet.next()) {
                Long id = resultSet.getLong("city_id");
                String name = resultSet.getString("name");
                City city = new City(id, name);
                cities.add(city);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return cities;
    }
}

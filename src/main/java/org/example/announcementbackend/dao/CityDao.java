package org.example.announcementbackend.dao;

import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        //try-with-resources
        try(Connection connection = DatabaseConfig.getConnection();) {
            Statement statement = connection.createStatement();
            String query = "select * from cities";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong("city_id");
                String name = resultSet.getString("city_name");
                City city = new City(id, name);
                cities.add(city);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return cities;
    }
}

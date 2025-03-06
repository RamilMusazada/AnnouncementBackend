package org.example.announcementbackend.dao;

import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.constant.QueryConstants;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.entity.Category;
import org.example.announcementbackend.entity.City;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnnouncementDao {
    public List<Announcement> findAll() {
        List<Announcement> announcements = new ArrayList<Announcement>();

        try (Connection connection = DatabaseConfig.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QueryConstants.GET_ANNOUNCEMENT_LIST_QUERY);
            while (resultSet.next()) {
                Announcement announcement = new Announcement();
                announcement.setAnnouncementId(resultSet.getLong("announcement_id"));
                announcement.setName(resultSet.getString("name"));
                announcement.setDescription(resultSet.getString("description"));
                announcement.setAnnouncementNumber(resultSet.getLong("announcement_number"));
                announcement.setPrice(resultSet.getDouble("price"));
                announcement.setPhoneNumber(resultSet.getString("phone_number"));
                announcement.setSellerFullName(resultSet.getString("seller_full_name"));
                announcement.setDelivery(resultSet.getBoolean("delivery"));

                Timestamp createDate = resultSet.getTimestamp("created_date");
                LocalDateTime createdDateTime = createDate.toLocalDateTime();
                announcement.setCreatedDate(createdDateTime);

                Timestamp modifiedDate = resultSet.getTimestamp("modified_date");
                LocalDateTime modifiedDateTime = modifiedDate.toLocalDateTime();
                announcement.setModifiedDate(modifiedDateTime);

                Long cityId = resultSet.getLong("city_id");
                String cityName = resultSet.getString("city_name");
                City city = new City(cityId, cityName);
                announcement.setCity(city);

                Long categoryId = resultSet.getLong("category_id");
                String categoryName = resultSet.getString("category_name");
                Category category = new Category(categoryId, categoryName);
                announcement.setCategory(category);

                announcements.add(announcement);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return announcements;
    }
}
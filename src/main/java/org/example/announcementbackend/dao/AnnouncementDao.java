package org.example.announcementbackend.dao;

import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.entity.Announcement;
import org.example.announcementbackend.entity.Category;
import org.example.announcementbackend.entity.City;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDao {
    public List<Announcement> findAll() {
        List<Announcement> announcements = new ArrayList<Announcement>();

        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = """
                    SELECT A.announcement_id,
                           A.name,
                           A.description,
                           A.announcement_number,
                           A.price,
                           A.phone_number,
                           A.seller_full_name,
                           A.delivery,
                           A.created_date,
                           A.modified_date,
                           C.city_id,
                           C.name as city_name,
                           ct.category_id,
                           ct.NAME as category_name
                    FROM announcements a
                             LEFT JOIN cities c ON A.city_id = C.city_id
                             LEFT JOIN categories ct ON A.category_id = ct.category_id;
                    """;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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
package org.example.announcementbackend.dao;

import lombok.extern.slf4j.Slf4j;
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
import java.util.Optional;

@Slf4j
@Repository
public class AnnouncementDao {
    public List<Announcement> findAll() {
        List<Announcement> announcements = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection()) {

            Statement statement = connection.createStatement();
            log.info("Get announcement list query  :{} ", QueryConstants.GET_ANNOUNCEMENT_LIST_QUERY);
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
            throw new RuntimeException(e);
        }

        return announcements;
    }

    public void create(Announcement announcement) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            log.info("Create announcement query :{} ", QueryConstants.CREATE_ANNOUNCEMENT_QUERY);
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.CREATE_ANNOUNCEMENT_QUERY);
            preparedStatement.setString(1, announcement.getName());
            preparedStatement.setString(2, announcement.getDescription());
            preparedStatement.setLong(3, announcement.getAnnouncementNumber());
            preparedStatement.setDouble(4, announcement.getPrice());
            preparedStatement.setString(5, announcement.getPhoneNumber());
            preparedStatement.setString(6, announcement.getSellerFullName());
            preparedStatement.setBoolean(7, announcement.getDelivery());
            preparedStatement.setLong(8, announcement.getCity().getCityId());
            preparedStatement.setLong(9, announcement.getCategory().getCategoryId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Announcement announcement) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            log.info("Update announcement query :{} ", QueryConstants.UPDATE_ANNOUNCEMENT_QUERY);
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.UPDATE_ANNOUNCEMENT_QUERY);
            preparedStatement.setString(1, announcement.getName());
            preparedStatement.setString(2, announcement.getDescription());
            preparedStatement.setDouble(3, announcement.getPrice());
            preparedStatement.setString(4, announcement.getSellerFullName());
            preparedStatement.setBoolean(5, announcement.getDelivery());
            preparedStatement.setLong(6, announcement.getAnnouncementId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long announcementId) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            log.info("Delete announcement query :{} ", QueryConstants.DELETE_ANNOUNCEMENT_QUERY);
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.DELETE_ANNOUNCEMENT_QUERY);
            preparedStatement.setLong(1, announcementId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Announcement> findByID(Long announcementId) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            log.info("Get announcement by id query : {}", QueryConstants.GET_ANNOUNCEMENT_BY_ID);
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.GET_ANNOUNCEMENT_BY_ID);
            preparedStatement.setLong(1, announcementId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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

                return Optional.of(announcement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }
}
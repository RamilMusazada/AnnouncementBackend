package org.example.announcementbackend.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.constant.QueryConstants;
import org.example.announcementbackend.entity.Category;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CategoryDao {
    public List<Category> findAll() {
        log.info("Getting categories from DB");
        List<Category> categories = new ArrayList<>();
        //try-with-resources
        try (Connection connection = DatabaseConfig.getConnection()) {
            Statement statement = connection.createStatement();
            log.info("Get category list query : {}", QueryConstants.GET_CATEGORY_LIST_QUERY);
            ResultSet resultSet = statement.executeQuery(QueryConstants.GET_CATEGORY_LIST_QUERY);
            while (resultSet.next()) {
                Long id = resultSet.getLong("category_id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}

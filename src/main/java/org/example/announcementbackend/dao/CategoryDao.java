package org.example.announcementbackend.dao;

import org.example.announcementbackend.config.DatabaseConfig;
import org.example.announcementbackend.entity.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> findAll() {
        List < Category > categories = new ArrayList<>();
        //try-with-resources
        try(Connection connection = DatabaseConfig.getConnection()){
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM categories";
            ResultSet resultSet = statement.executeQuery(query);
            while ( resultSet.next()){
                Long id = resultSet.getLong("category_id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return categories;
    }
}

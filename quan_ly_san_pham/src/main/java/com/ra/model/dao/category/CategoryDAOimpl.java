package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import com.ra.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOimpl implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_CATEGORY()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
                category.setQuantity_product(resultSet.getInt("quantity_product"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        Connection connection = null;
        int check;
        connection = ConnectionDB.openConnection();
        try {
            if (category.getCategoryId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_CREATE_CATEGORY(?)}");
                callableStatement.setString(1, category.getCategoryName());
                check = callableStatement.executeUpdate();
            } else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_CATEGORY(?,?,?,?)}");
                callableStatement.setInt(1, category.getCategoryId());
                callableStatement.setString(2, category.getCategoryName());
                callableStatement.setBoolean(3, category.isStatus());
                callableStatement.setInt(4, category.getQuantity_product());
                check=callableStatement.executeUpdate();
            }
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = null;
        Category category = new Category();
        try {
            connection=ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CATEGORY(?)}");
            callableStatement.setInt(1,integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
                category.setQuantity_product(resultSet.getInt("quantity_product"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }
}

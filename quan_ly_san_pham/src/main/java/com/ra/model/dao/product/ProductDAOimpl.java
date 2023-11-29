package com.ra.model.dao.product;

import com.ra.model.dao.category.CategoryDAOimpl;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDAOimpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_PRODUCT()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                Category category = new CategoryDAOimpl().findById(resultSet.getInt("category_id"));
                product.setCategory(category);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        boolean check = false;
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement1 = connection.prepareCall("{CALL PROC_CREATE_PRODUCT(?,?,?)}");
            callableStatement1.setString(1, product.getProductName());
            callableStatement1.setFloat(2, product.getPrice());
            callableStatement1.setInt(3, product.getCategory().getCategoryId());
            int call1 = callableStatement1.executeUpdate();

            CallableStatement callableStatement2 = connection.prepareCall("{CALL PROC_UPDATE_QUALITY_CATEGORY(?)}");
            callableStatement2.setInt(1, product.getCategory().getCategoryId());
            int call2 = callableStatement2.executeUpdate();

            if (call1 > 0 && call2 > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product findById(Integer integer) {
        Connection connection = null;
        Product product = new Product();
        try {
            connection=ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CATEGORY(?)}");
            callableStatement.setInt(1,integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                Category category = new CategoryDAOimpl().findById(resultSet.getInt("categoryId"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}

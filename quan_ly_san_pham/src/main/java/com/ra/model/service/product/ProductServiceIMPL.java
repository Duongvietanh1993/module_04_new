package com.ra.model.service.product;

import com.ra.model.dao.product.ProductDAO;
import com.ra.model.dao.product.ProductDAOimpl;
import com.ra.model.entity.Product;

import java.util.List;

public class ProductServiceIMPL implements ProductService{
    private ProductDAO productDAO = new ProductDAOimpl();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        return productDAO.saveOrUpdate(product);
    }

    @Override
    public Product findById(Integer integer) {
        return productDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}

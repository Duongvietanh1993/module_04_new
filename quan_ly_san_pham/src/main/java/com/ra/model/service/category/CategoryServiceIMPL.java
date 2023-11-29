package com.ra.model.service.category;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.dao.category.CategoryDAOimpl;
import com.ra.model.entity.Category;

import java.util.List;

public class CategoryServiceIMPL implements CategoryService{
    private CategoryDAO categoryDAO = new CategoryDAOimpl();
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        return categoryDAO.saveOrUpdate(category);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }
}

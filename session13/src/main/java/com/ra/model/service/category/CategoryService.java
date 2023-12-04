package com.ra.model.service.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findByID(Integer id);
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
}

package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.category.CategoryService;
import com.ra.model.service.category.CategoryServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showList(request, response);
        }
        switch (action) {
            case "create":
                response.sendRedirect("views/category/create_category.jsp");
                break;
            case "update":
                break;
            case "delete":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Category category = new Category();
        category.setCategoryName(request.getParameter("name"));
        /*category.setStatus(Boolean.parseBoolean(request.getParameter("status")));*/
        if (request.getParameter("id") != null) {
            category.setCategoryId(Integer.parseInt(request.getParameter("id")));
        }
        if (categoryService.saveOrUpdate(category)) {
            showList(request, response);
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("views/category/category.jsp").forward(request, response);
    }
}
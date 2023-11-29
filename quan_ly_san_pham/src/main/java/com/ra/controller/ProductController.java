package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.category.CategoryService;
import com.ra.model.service.category.CategoryServiceIMPL;
import com.ra.model.service.product.ProductService;
import com.ra.model.service.product.ProductServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductServiceIMPL();
    private CategoryService categoryService = new CategoryServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showList(request, response);
        }else {
            switch (action) {
                case "create":
                    List<Category> categoryList = categoryService.findAll();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("views/product/create_product.jsp").forward(request, response);
                    break;
                case "update":
                    break;
                case "delete":
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Product product = new Product();
        product.setProductName(request.getParameter("productName"));
        String price = request.getParameter("price");
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        Category category =categoryService.findById(Integer.valueOf(request.getParameter("category")));
        product.setCategory(category);
        if (request.getParameter("id") != null) {
            product.setProductId(Integer.valueOf(request.getParameter("id")));
        }
        if (productService.saveOrUpdate(product)){
            showList(request,response);
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("views/product/product.jsp").forward(request, response);
    }
}
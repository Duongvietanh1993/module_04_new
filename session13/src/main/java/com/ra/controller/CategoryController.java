package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String index(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        return "category/index";
    }

    @GetMapping("/category-add")
    public String categoryAdd(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }
    @PostMapping("/create-category")
    public String createCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong!");
        return "redirect:/category";
    }
    @GetMapping("category/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id,Model model){
        Category category = categoryService.findByID(id);
        model.addAttribute("categoryEdit", category);
        return "category/edit";
    }

    @PostMapping("category-update")
    public String categoryUpdate(@ModelAttribute("categoryEdit") Category category,RedirectAttributes redirectAttributes){
        categoryService.saveOrUpdate(category);
        redirectAttributes.addFlashAttribute("mess", "Sua thanh cong!");
        return "redirect:/category";
    }

    @GetMapping("category/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "category/delete";
    }
}

package com.ra.controller;

import com.ra.model.entity.Account;
import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import com.ra.model.service.StudentServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private StudentService studentService = new StudentServiceIMPL();

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("list", students);
        return "student";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "login";
    }

    @RequestMapping("/register")
    public String register() {

        return "register";
    }

   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() {
        return "home";
    }*/

    @RequestMapping(value = "/post-login")
    public String postLogin(@ModelAttribute("account")Account account) {
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
        return "home";
    }
}

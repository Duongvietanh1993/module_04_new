package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.sevice.student.StudentService;
import com.ra.model.sevice.student.StudentServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showList(request, response);
        }
        switch (action) {
            case "create":
                response.sendRedirect("views/add-student.jsp");
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = studentService.findById(id);
                request.setAttribute("update", student);
                request.getRequestDispatcher("views/edit-student.jsp").forward(request,response);
                break;
            case "delete":
                int studentIdDelete = Integer.parseInt(request.getParameter("id"));
                studentService.delete(studentIdDelete);
                showList(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Student student = new Student();
        student.setUserName(request.getParameter("name"));
        student.setUserEmail(request.getParameter("email"));
        student.setUserBirthday(Date.valueOf(request.getParameter("birthday")));
        student.setUserAddress(request.getParameter("address"));
        if (request.getParameter("id") != null) {
            student.setUserId(Integer.parseInt(request.getParameter("id")));
        }
        if (studentService.saveOrUpdate(student)) {
            showList(request, response);
        }
        response.sendRedirect("views/add-student.jsp?err");
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.findAll();
        request.setAttribute("list", studentList);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }
}
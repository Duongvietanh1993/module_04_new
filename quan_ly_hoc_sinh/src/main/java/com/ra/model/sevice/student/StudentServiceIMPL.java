package com.ra.model.sevice.student;

import com.ra.model.dao.student.StudentDAO;
import com.ra.model.dao.student.StudentDAOimpl;
import com.ra.model.entity.Student;

import java.util.List;

public class StudentServiceIMPL implements StudentService {
    private StudentDAO studentDAO = new StudentDAOimpl();

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        return studentDAO.saveOrUpdate(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public void delete(Integer integer) {
        studentDAO.delete(integer);
    }
}

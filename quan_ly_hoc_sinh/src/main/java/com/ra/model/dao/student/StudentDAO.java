package com.ra.model.dao.student;

import com.ra.model.dao.IGenericDAO;
import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDAO extends IGenericDAO<Student,Integer> {
    List<Student> finByName(String name);
}

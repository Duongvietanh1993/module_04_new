package com.ra.model.dao.student;

import com.ra.model.entity.Student;
import com.ra.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOimpl implements StudentDAO {

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setUserId(resultSet.getInt("id"));
                student.setUserName(resultSet.getString("name"));
                student.setUserEmail(resultSet.getString("email"));
                student.setUserBirthday(resultSet.getDate("birthday"));
                student.setUserAddress(resultSet.getString("address"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return students;
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        Connection connection = null;
        int check;
        connection = ConnectionDB.openConnection();

        try {
            if (student.getUserId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_CREATE_STUDENT (?,?,?,?)}");
                callableStatement.setString(1, student.getUserName());
                callableStatement.setString(2, student.getUserEmail());
                callableStatement.setDate(3, student.getUserBirthday());
                callableStatement.setString(4, student.getUserAddress());
                check = callableStatement.executeUpdate();
            } else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_STUDENT(?,?,?,?,?)}");
                callableStatement.setString(1, student.getUserName());
                callableStatement.setString(2, student.getUserEmail());
                callableStatement.setDate(3, student.getUserBirthday());
                callableStatement.setString(4, student.getUserAddress());
                callableStatement.setInt(5, student.getUserId());
                check = callableStatement.executeUpdate();
            }

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Student findById(Integer id) {
        Connection connection = null;
        Student student = new Student();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student WHERE id = ?");
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                student.setUserId(resultSet.getInt("id"));
                student.setUserName(resultSet.getString("name"));
                student.setUserEmail(resultSet.getString("email"));
                student.setUserBirthday(resultSet.getDate("birthday"));
                student.setUserAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return student;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        Student student = new Student();
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_DELETE_STUDENT(?)}");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

    }

    @Override
    public List<Student> finByName(String name) {
        return null;
    }
}

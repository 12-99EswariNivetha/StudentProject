package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.exception.RecordNotfoundException;
import com.student.model.Student;

public class StudentDaoImpl {

    protected Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdetails", "postgres",
                    "root");
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        }
        return connection;
    }

    /**
     * Its addStudent details to database.
     * 
     * @throws SQLException
     */
    public void addStudent(Student student) throws SQLException {
        Connection connection = getConnection();
        final String InsertStudent = "INSERT INTO student(rollno,name,standard,phoneno,emailid,dob,isdeleted) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(InsertStudent);
            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getStandard());
            statement.setLong(4, student.getPhonenumber());
            statement.setString(5, student.getEmailId());
            statement.setDate(6, student.getDate());
            statement.setBoolean(7, false);
            statement.execute();
            System.out.println(statement);
        } catch (SQLException e) {
            System.out.println("values doesnot inserted");
        } finally {
            connection.close();
        }
    }

    /**
     * Its removeStudent details from database.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException
     */
    public void removeStudent(int rollno) throws SQLException {
        Connection connection = getConnection();
        final String removeStudent = "UPDATE student SET isdeleted=? where rollno=?";

        try {
            PreparedStatement statement = connection.prepareStatement(removeStudent);
            statement.setBoolean(1, true);
            statement.setInt(2, rollno);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Id not found");
        } finally {
            connection.close();
        }
    }

    /**
     * Its retrive all Student details from database.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException
     */
    public Map<Integer, Student> getAllStudentfromdb() throws SQLException {
        Connection connection = getConnection();
        final String getstudent = "Select * From student where isdeleted=false ";
        final Map<Integer, Student> Studentlist = new HashMap<Integer, Student>();

        try {
            PreparedStatement statement = connection.prepareStatement(getstudent);
            ResultSet rst = statement.executeQuery();

            while (rst.next()) {
                Student student = new Student(rst.getInt("rollno"), rst.getString("name"), rst.getInt("standard"),
                        rst.getLong("phoneno"), rst.getString("emailid"), rst.getDate("dob"));
                Studentlist.put(student.getRollNo(), student);
            }
        } catch (SQLException e) {
            System.out.println("Id not found");
        } finally {
            connection.close();
        }
        return Studentlist;
    }

    /**
     * Its update Studentdetails in database.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException
     */
    public void updateStudents(Student student) throws SQLException {
        Connection connection = getConnection();

        try {
            if (student.getName() != null) {
                PreparedStatement statement = connection.prepareStatement("UPDATE student SET name=? where rollno=?");
                statement.setString(1, student.getName());
                statement.setInt(2, student.getRollNo());
                statement.executeUpdate();
            } else if (student.getStandard() != 0) {
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE student SET standard=? where rollno=?");
                statement.setInt(1, student.getStandard());
                statement.setInt(2, student.getRollNo());
                statement.executeUpdate();
            } else if (student.getPhonenumber() != 0) {
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE student SET phoneno=? where rollno=?");
                statement.setLong(1, student.getPhonenumber());
                statement.setInt(2, student.getRollNo());
                statement.executeUpdate();
            } else if (student.getEmailId() != null) {
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE student SET emailid=? where rollno=?");
                statement.setString(1, student.getEmailId());
                statement.setInt(2, student.getRollNo());
                statement.executeUpdate();
            } else if (student.getDate() != null) {
                PreparedStatement statement = connection.prepareStatement("UPDATE student SET dob=? where rollno=?");
                statement.setDate(1, student.getDate());
                statement.setInt(2, student.getRollNo());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Id not found");
        } finally {
            connection.close();
        }
    }
}

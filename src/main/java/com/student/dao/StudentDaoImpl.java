package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.student.model.Student;

public class StudentDaoImpl implements StudentDao {
    private static final DataBaseConnection DBCONNECTION = new DataBaseConnection();

    /**
     * It addStudent details to database.
     */
    public void addStudent(Student student) {
        final String InsertStudent = "INSERT INTO student(rollno,name,standard,phoneno,emailid,dob,isdeleted) VALUES (?,?,?,?,?,?,?)";

        try (final Connection connection = DBCONNECTION.getConnection();
                final PreparedStatement statement = connection.prepareStatement(InsertStudent);) {
            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getStandard());
            statement.setLong(4, student.getPhonenumber());
            statement.setString(5, student.getEmailId());
            statement.setDate(6, student.getDate());
            statement.setBoolean(7, false);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Values doesnot inserted");
        }
    }

    /**
     * It removeStudent details from database.
     */
    public void removeStudent(int rollno) {
        final String removeStudent = "UPDATE student SET isdeleted=? where rollno=?";

        try (final Connection connection = DBCONNECTION.getConnection();
                final PreparedStatement statement = connection.prepareStatement(removeStudent);) {
            statement.setBoolean(1, true);
            statement.setInt(2, rollno);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Id not found");
        }
    }

    /**
     * It retrive all Student details from database.
     */
    public Map<Integer, Student> getAllStudentsfromdb() {
        final String getstudent = "Select * From student where isdeleted=false ";
        final Map<Integer, Student> Studentlist = new HashMap<Integer, Student>();
        try (final Connection connection = DBCONNECTION.getConnection();
                final PreparedStatement statement = connection.prepareStatement(getstudent);
                ResultSet rst = statement.executeQuery();) {

            while (rst.next()) {
                Student student = new Student(rst.getInt("rollno"), rst.getString("name"), rst.getInt("standard"),
                        rst.getLong("phoneno"), rst.getString("emailid"), rst.getDate("dob"));
                Studentlist.put(student.getRollNo(), student);
            }
        } catch (SQLException e) {
            System.out.println("Id not found");
        }
        return Studentlist;
    }

    /**
     * It update Studentdetails in database.
     */
    public void updateStudents(Student student) {

        try (final Connection connection = DBCONNECTION.getConnection();) {
            String updateStudent = "update student set";
            boolean update = false;

                if (student.getName()!=null) {
                    updateStudent += " name = '" + student.getName() + "'";
                    update = true;
                }

                if (student.getStandard() != 0) {
                    if (update) {
                        updateStudent += ",";
                    }
                    updateStudent += " standard = " + student.getStandard();
                    update = true;
                }

                if (student.getEmailId()!=null) {
                    if (update) {
                        updateStudent += ",";
                    }
                    updateStudent += " emailid = '" + student.getEmailId() + "'";
                    update = true;
                }

                if (student.getPhonenumber() != 0) {
                    if (update) {
                        updateStudent += ",";
                    }
                    updateStudent += " phoneno = " + student.getPhonenumber();
                    update = true;
                }

            if (student.getDate() != null) {
                updateStudent += " dob = '" + student.getDate() + "'";
                update = true;
            }
            updateStudent += " where rollno = " + student.getRollNo();
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateStudent);
        } catch (SQLException e) {
            System.out.println("Id not found");
        }
    }
}

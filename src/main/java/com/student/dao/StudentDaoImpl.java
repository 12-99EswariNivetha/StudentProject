package com.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.exception.RecordNotfoundException;
import com.student.model.Student;

public class StudentDaoImpl implements StudentDao {
    private static final DataBaseConnection DBCONNECTION = new DataBaseConnection();

    /**
     * It addStudent details to database.
     */
    public void addStudent(final Student student) {
        final String InsertStudent = "INSERT INTO student(rollno, name, standard, phoneno, emailid, dob, isdeleted) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = DBCONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(InsertStudent);) {
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
    public boolean removeStudent(final int rollno) {
        final String removeStudent = "UPDATE student SET isdeleted = ? where rollno = ?";

        try (Connection connection = DBCONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(removeStudent);) {
            statement.setBoolean(1, true);
            statement.setInt(2, rollno);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * It retrive all Student details from database.
     */
    public Map<Integer, Student> getAllStudentsfromdb() {
        final String getstudent = "Select * From student where isdeleted = false ";
        final Map<Integer, Student> Studentlist = new HashMap<Integer, Student>();

        try (Connection connection = DBCONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(getstudent);
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
    public boolean updateStudents(final Student student) {

        try (Connection connection = DBCONNECTION.getConnection();) {
            StringBuilder builder = new StringBuilder();
            String updateStudent = builder.append("update student set").toString();

            boolean update = false;

            if (student.getName() != null) {
                updateStudent = builder.append(" name = '").append(student.getName()).append("'").toString();
                update = true;
            }

            if (student.getStandard() != 0) {
                if (update) {
                    updateStudent = builder.append(",").toString();
                }
                updateStudent = builder.append(" standard = ").append(student.getStandard()).toString();
                update = true;
            }

            if (student.getEmailId() != null) {
                if (update) {
                    updateStudent = builder.append(",").toString();
                }
                updateStudent = builder.append(" emailid = '").append(student.getEmailId()).append("'").toString();
                update = true;
            }

            if (student.getPhonenumber() != 0) {
                if (update) {
                    updateStudent = builder.append(",").toString();
                }
                updateStudent = builder.append(" phoneno = ").append(student.getPhonenumber()).toString();
                update = true;
            }

            if (student.getDate() != null) {
                updateStudent = builder.append(" dob = '").append(student.getDate()).append("'").toString();
                update = true;
            }
            updateStudent = builder.append(" where rollno = ").append(student.getRollNo()).toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateStudent);
            return true;
        } catch (SQLException e) {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * It select Studentdetails in database.
     */
    public Student selectStudent(final int rollno) {
        Student student = null;
        final String getstudent = "Select * From student where rollno=?";

        try (Connection connection = DBCONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(getstudent);) {
            statement.setInt(1, rollno);
            ResultSet rst = statement.executeQuery();

            while (rst.next()) {
                String name = rst.getString(2);
                int standard = rst.getInt(3);
                String emailid = rst.getString(4);
                long phoneno = rst.getLong(5);
                Date dob = rst.getDate(6);

                rst.close();

                student = new Student(rollno, name, standard, phoneno, emailid, dob);
            }
        } catch (SQLException e) {
            System.out.println("Id not found");
        }
        return student;
    }
}

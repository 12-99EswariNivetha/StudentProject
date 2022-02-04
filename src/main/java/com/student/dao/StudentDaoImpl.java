package com.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.exception.CustomException.RecordNotfoundException;
import com.exception.CustomException.IdAlreadyFoundException;
import com.student.model.Student;

public class StudentDaoImpl implements StudentDao {
    private static final DataBaseConnection DBCONNECTION = new DataBaseConnection();

    /**
     * AddStudent details to database.
     */
    public boolean addStudent(final Student student) {
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

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new IdAlreadyFoundException("Id Already Exist");
        }
    }

    /**
     * Remove Student details from database.
     */
    public boolean removeStudent(final int rollno) {
        final String removeStudent = "UPDATE student SET isdeleted = ? where rollno = ?";

        try (Connection connection = DBCONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(removeStudent);) {
            statement.setBoolean(1, true);
            statement.setInt(2, rollno);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Retrive all student details from database.
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
     * Update student details in database.
     */
    public boolean updateStudents(final Student student) {

        try (Connection connection = DBCONNECTION.getConnection();) {
            final StringBuilder queryBuilder = new StringBuilder();
            String updateStudent = queryBuilder.append("update student set").toString();

            boolean hasNextField = false;

            if (student.getName() != null) {
                updateStudent = queryBuilder.append(" name = '").append(student.getName()).append("'").toString();
                hasNextField = true;
            }

            if (student.getStandard() != 0) {
                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                }
                updateStudent = queryBuilder.append(" standard = ").append(student.getStandard()).toString();
                hasNextField = true;
            }

            if (student.getEmailId() != null) {
                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                }
                updateStudent = queryBuilder.append(" emailid = '").append(student.getEmailId()).append("'").toString();
                hasNextField = true;
            }

            if (student.getPhonenumber() != 0) {
                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                }
                updateStudent = queryBuilder.append(" phoneno = ").append(student.getPhonenumber()).toString();
                hasNextField = true;
            }

            if (student.getDate() != null) {
                updateStudent = queryBuilder.append(" dob = '").append(student.getDate()).append("'").toString();
                hasNextField = true;
            }
            updateStudent = queryBuilder.append(" where rollno = ").append(student.getRollNo()).toString();

            Statement statement = connection.createStatement();
            return statement.executeUpdate(updateStudent) > 0;
        } catch (SQLException e) {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Select student detail from database.
     */
    public Student selectStudent(final int rollno) {
        Student student = null;
        final String getstudent = "Select * From student where rollno=?";

        try (final Connection connection = DBCONNECTION.getConnection();
                final PreparedStatement statement = connection.prepareStatement(getstudent);) {
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

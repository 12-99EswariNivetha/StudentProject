package com.student.service;

import java.sql.Date;
import java.sql.SQLException;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    public void addStudent(Student student) throws SQLException;

    public void removeStudent(int rollNo) throws SQLException;

    public void showAllStudents() throws SQLException;

    public void getStudentDetails(int rollNo) throws SQLException;

    public Student updateStudentDetails(Student student) throws SQLException;

    public int rollNoValidation(String rollNo);

    public String nameValidation(String name);

    public int standardValidation(String stand);

    public String emailIdValidation(String emailId);

    public Date dateValidation(String date);

    public long phoneNoValidation(String phoneNo);

}

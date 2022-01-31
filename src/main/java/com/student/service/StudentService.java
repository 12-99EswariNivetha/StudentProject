package com.student.service;

import java.sql.Date;
import java.sql.SQLException;

import com.exception.RecordNotfoundException;
import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    public void addStudent(Student student) throws SQLException, RecordNotfoundException;

    public void removeStudent(int rollNo) throws SQLException, RecordNotfoundException;

    public void showAllStudents() throws SQLException, RecordNotfoundException;

    public void getStudentDetails(int rollNo) throws SQLException, RecordNotfoundException;

    public Student updateStudentDetails(Student student) throws SQLException, RecordNotfoundException;

    public int rollNoValidation(String rollNo);

    public String nameValidation(String name);

    public int standardValidation(String stand);

    public String emailIdValidation(String emailId);

    public Date dateValidation(String date);

    public long phoneNoValidation(String phoneNo);

}

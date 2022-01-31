package com.student.controller;

import java.sql.Date;
import java.sql.SQLException;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImplementation;
import com.student.view.StudentView;

/**
 * Its get response and send request to service.
 */
public class StudentController {
    private StudentService service = new StudentServiceImplementation();

    public void addStudent(int rollNo, Student student) throws SQLException {
        service.addStudent(student);
    }

    public void removeStudent(int rollNo) throws SQLException {
        service.removeStudent(rollNo);
    }

    public void getStudentDetails(int rollNo) throws SQLException {
        service.getStudentDetails(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) throws SQLException {
        StudentView.showValue(service.updateStudentDetails(student));
    }

    public void showAllStudents() throws SQLException {
        service.showAllStudents();
    }

    public long phoneNoValidation(String phoneNo) {
        return service.phoneNoValidation(phoneNo);
    }

    public int rollNoValidation(String rollNo) {
        return service.rollNoValidation(rollNo);
    }

    public String nameValidation(String name) {
        return service.nameValidation(name);
    }

    public int standardValidation(String stand) {
        return service.standardValidation(stand);
    }

    public String emailIdValidation(String emailId) {
        return service.emailIdValidation(emailId);
    }

    public Date dateValidation(String date) {
        return service.dateValidation(date);
    }
}

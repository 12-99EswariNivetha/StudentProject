package com.student.controller;

import java.sql.Date;

import com.exception.RecordNotfoundException;
import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceImplementation2;

/**
 * Its get response and send request to service.
 */
public class StudentController {
    private static final StudentServiceImplementation service = new StudentServiceImplementation();
    private static final StudentServiceImplementation2 service2 = new StudentServiceImplementation2();

    public void addStudent(int rollNo, Student student) {
        service.addStudent(student);
        service2.addStudent(student);
    }

    public void removeStudent(int rollNo) throws RecordNotfoundException {
        service.removeStudent(rollNo);
        service2.removeStudent(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        // StudentView.showValue(service.updateStudentDetails(student));
        service2.updateStudentDetails(student);
    }

    public void showAllStudents() {
        service.showAllStudents();
        service2.ShowAllStudents();
    }

    public void getStudentDetails(int rollNo) {
        service.getStudentDetails(rollNo);
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

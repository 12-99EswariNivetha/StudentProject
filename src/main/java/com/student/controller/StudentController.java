package com.student.controller;

import java.sql.Date;
import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceImplementation2;
import com.student.view.StudentView;

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

    public void removeStudent(int rollNo) {
        service.removeStudent(rollNo);
        service2.removeStudent(rollNo);
    }

    public void getStudentDetails(int rollNo) {
        service.getStudentDetails(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        StudentView.showValue(service.updateStudentDetails(student));
        service2.updateStudentDetails(student);
    }

    public void updateAllStudentDetails(int rollNo, Student student) {
        StudentView.showValue(service.updateAllStudentDetails(student));
        service2.updateAllStudentDetails(student);
    }

    public void showAllStudents() {
        service.showAllStudents();
        service2.getAllStudents();
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

package com.student.controller;

import java.util.Date;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImplementation;

/**
 * Its get response and send request to service.
 */
public class StudentController {
    private StudentService service = new StudentServiceImplementation();

    public void addStudent(int rollNo, Student student) {
        service.addStudent(rollNo, student);
    }

    public void removeStudent(int rollNo) {
        service.removeStudent(rollNo);
    }

    public void getStudentDetails(int rollNo) {
        service.getStudentDetails(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        service.updateStudentDetails(student);
    }

    public void showAllStudents() {
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

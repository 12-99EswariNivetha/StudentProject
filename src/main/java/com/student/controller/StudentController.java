package com.student.controller;

import java.sql.Date;

import com.exception.RecordNotfoundException;
import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceImplementation2;
import com.student.view.StudentView;

/**
 * Its get response and send request to service.
 */
public class StudentController {
    private final StudentServiceImplementation STUDENT_SERVICE = new StudentServiceImplementation();
    private final StudentServiceImplementation2 STUDENT_SERVICEIMPL2 = new StudentServiceImplementation2();

    public void addStudent(int rollNo, Student student) {
        STUDENT_SERVICEIMPL2.addStudent(student);
    }

    public void removeStudent(int rollNo) {
        STUDENT_SERVICEIMPL2.removeStudent(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        StudentView.showValue(STUDENT_SERVICEIMPL2.updateStudentDetails(student));
    }

    public void getStudentDetails(int rollNo) throws RecordNotfoundException {
        StudentView.showValue(STUDENT_SERVICEIMPL2.selectStudent(rollNo));
    }

    public void showAllStudents() {
        STUDENT_SERVICEIMPL2.ShowAllStudents();
    }

    public long phoneNoValidation(String phoneNo) {
        return STUDENT_SERVICE.phoneNoValidation(phoneNo);
    }

    public int rollNoValidation(String rollNo) {
        return STUDENT_SERVICE.rollNoValidation(rollNo);
    }

    public String nameValidation(String name) {
        return STUDENT_SERVICE.nameValidation(name);
    }

    public int standardValidation(String stand) {
        return STUDENT_SERVICE.standardValidation(stand);
    }

    public String emailIdValidation(String emailId) {
        return STUDENT_SERVICE.emailIdValidation(emailId);
    }

    public Date dateValidation(String date) {
        return STUDENT_SERVICE.dateValidation(date);
    }
}

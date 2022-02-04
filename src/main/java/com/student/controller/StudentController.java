package com.student.controller;

import java.sql.Date;

import com.exception.RecordNotfoundException;
import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceVersion2;
import com.student.view.StudentView;

/**
 * Its get response and send request to service.
 */
public class StudentController {
    private final StudentServiceImplementation STUDENT_SERVICE = new StudentServiceImplementation();
    private final StudentServiceVersion2 STUDENT_SERVICE_VERSION2 = new StudentServiceVersion2();

    public void addStudent(int rollNo, Student student) {
        STUDENT_SERVICE_VERSION2.addStudent(student);
    }

    public void removeStudent(int rollNo) {
        STUDENT_SERVICE_VERSION2.removeStudent(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        StudentView.showValue(STUDENT_SERVICE_VERSION2.updateStudentDetails(student));
    }

    public void getStudentDetails(int rollNo) throws RecordNotfoundException {
        StudentView.showValue(STUDENT_SERVICE_VERSION2.selectStudent(rollNo));
    }

    public void showAllStudents() {
        STUDENT_SERVICE_VERSION2.ShowAllStudents();
    }

    public long phoneNoValidation(final String phoneNo) {
        return STUDENT_SERVICE.phoneNoValidation(phoneNo);
    }

    public int rollNoValidation(final String rollNo) {
        return STUDENT_SERVICE.rollNoValidation(rollNo);
    }

    public String nameValidation(final String name) {
        return STUDENT_SERVICE.nameValidation(name);
    }

    public int standardValidation(final String stand) {
        return STUDENT_SERVICE.standardValidation(stand);
    }

    public String emailIdValidation(final String emailId) {
        return STUDENT_SERVICE.emailIdValidation(emailId);
    }

    public Date dateValidation(final String date) {
        return STUDENT_SERVICE.dateValidation(date);
    }
}

package com.student.controller;

import java.sql.Date;
import java.util.Map;

import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceVersion2;
import com.student.view.StudentView;

/**
 * Get response and send request to service.
 */
public class StudentController {
    private final StudentServiceImplementation STUDENT_SERVICE = new StudentServiceImplementation();
    private final StudentServiceVersion2 STUDENT_SERVICE_VERSION2 = new StudentServiceVersion2();

    public boolean addStudent(final int rollNo, final Student student) {
        return STUDENT_SERVICE_VERSION2.addStudent(student);
    }

    public boolean removeStudent(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.removeStudent(rollNo);
    }

    public boolean updateStudentDetails(final int rollNo, final Student student) {
        return STUDENT_SERVICE_VERSION2.updateStudentDetails(student);
    }

    public Map<Integer, Student> showAllStudents() {
        return STUDENT_SERVICE_VERSION2.ShowAllStudents();
    }

    public void SearchStudentDetails(final int rollNo) {
        StudentView.showValue(STUDENT_SERVICE_VERSION2.selectStudent(rollNo));
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

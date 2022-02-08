package com.student.controller;

import java.util.Map;

import com.student.model.Student;
import com.student.service.StudentServiceImplementation;
import com.student.service.StudentServiceVersion2;

/**
 * Get response and send request to service.
 */
public class StudentController {

   // private static final StudentServiceImplementation STUDENT_SERVICE = new StudentServiceImplementation();
    private static final StudentServiceVersion2 STUDENT_SERVICE_VERSION2 = new StudentServiceVersion2();

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

    public Student SearchStudentDetails(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.selectStudent(rollNo);

    }
}

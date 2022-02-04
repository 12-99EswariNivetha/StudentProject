package com.student.service;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    void addStudent(final Student student);

    void removeStudent(final int rollNo);

    void showAllStudents();

    void getStudentDetails(final int rollNo);

    Student updateStudentDetails(final Student student);
}

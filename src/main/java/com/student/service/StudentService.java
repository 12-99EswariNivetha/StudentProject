package com.student.service;

import com.exception.RecordNotfoundException;
import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    void addStudent(Student student);

    void removeStudent(int rollNo) throws RecordNotfoundException;

    void showAllStudents();

    void getStudentDetails(int rollNo);

    Student updateStudentDetails(Student student);
}

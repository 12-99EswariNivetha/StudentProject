package com.student.service;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    void addStudent(Student student);

    void removeStudent(int rollNo);

    void showAllStudents();

    void getStudentDetails(int rollNo);

    Student updateStudentDetails(Student student);
    
    Student updateAllStudentDetails(Student student);

}

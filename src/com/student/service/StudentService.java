package com.student.service;

import java.util.Date;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {

    public Student addStudent(int rollNo, Student student);

    public void removeStudent(int rollNo);

    public void showAllStudents();

    public void getStudentDetails(int rollNo);

    public Student updateStudentDetails(Student student);

    public int rollNoValidation(String rollNo);

    public String nameValidation(String name);

    public int standardValidation(String stand);

    public String emailIdValidation(String emailId);

    public Date dateValidation(String date);

    public long phoneNoValidation(String phoneNo);

}

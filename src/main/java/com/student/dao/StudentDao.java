package com.student.dao;

import java.util.Map;

import com.student.model.Student;

public interface StudentDao {
    boolean addStudent(Student student);

    boolean removeStudent(int rollno);

    Map<Integer, Student> getAllStudentsfromdb();

    boolean updateStudents(Student student);

    Student selectStudent(int rollno);
}

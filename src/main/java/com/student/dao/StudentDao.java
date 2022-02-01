package com.student.dao;

import java.util.Map;

import com.student.model.Student;

public interface StudentDao {

    void addStudent(Student student);

    void removeStudent(int rollno);

    Map<Integer, Student> getAllStudentsfromdb();

    void updateStudents(Student student);

}

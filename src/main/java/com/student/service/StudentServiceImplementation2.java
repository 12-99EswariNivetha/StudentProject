package com.student.service;

import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceImplementation2 {
    private final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    public void addStudent(Student student) {
        STUDENTDAO.addStudent(student);
    }

    public void removeStudent(int rollNo) {
        STUDENTDAO.removeStudent(rollNo);
    }

    public void getAllStudents() {
        System.out.println(STUDENTDAO.getAllStudentsfromdb());
    }

    public Student updateStudentDetails(Student student) {
        STUDENTDAO.updateStudents(student);
        return student;
    }

    public Student updateAllStudentDetails(Student student) {
        STUDENTDAO.updateAllStudents(student);
        return student;
    }
}

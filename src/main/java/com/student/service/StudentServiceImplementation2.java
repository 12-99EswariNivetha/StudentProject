package com.student.service;

import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceImplementation2 {
    private final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    /**
     * It addStudent details to database.
     */
    public void addStudent(Student student) {
        STUDENTDAO.addStudent(student);
    }

    /**
     * It removeStudent details to database.
     */
    public void removeStudent(int rollNo) {
        STUDENTDAO.removeStudent(rollNo);
    }

    /**
     * It getAllStudents details from database.
     */
    public void ShowAllStudents() {
        System.out.println(STUDENTDAO.getAllStudentsfromdb());
    }

    /**
     * It updateStudentdetails to database.
     */
    public Student updateStudentDetails(Student student) {
        STUDENTDAO.updateStudents(student);
        return student;
    }
}
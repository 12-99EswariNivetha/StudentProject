package com.student.service;

import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceImplementation2 {
    private final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    /**
     * It addStudent details to database.
     */
    public void addStudent(Student student) {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(student.getRollNo())) {
            System.out.println("Id Already Exit");
        } else {
            STUDENTDAO.addStudent(student);
        }
    }

    /**
     * It removeStudent details to database.
     */
    public void removeStudent(int rollNo) {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollNo)) {
            STUDENTDAO.removeStudent(rollNo);
            System.out.println("DeletedSuccesfully");
        } else {
            System.out.println("Record Not Found");
        }
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

    public void getStudentDetails(int rollNo) {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollNo)) {
            System.out.println(STUDENTDAO.getAllStudentsfromdb());
        } else {
            System.out.println("Record Not Found");
        }
       
    }
}
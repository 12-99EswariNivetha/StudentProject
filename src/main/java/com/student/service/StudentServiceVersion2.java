package com.student.service;

import java.util.Map;

import com.exception.CustomException.RecordNotfoundException;
import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceVersion2 {
    private final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    /**
     * Adds the student details to database.
     */
    public boolean addStudent(final Student student) {
        return STUDENTDAO.addStudent(student);
    }

    /**
     * Removes the student details from the database.
     */
    public boolean removeStudent(final int rollNo) {
        return STUDENTDAO.removeStudent(rollNo);
    }

    /**
     * Get all students details from database.
     */
    public Map<Integer, Student> ShowAllStudents() {
        return STUDENTDAO.getAllStudentsfromdb();
    }

    /**
     * Update student details to the database.
     */
    public boolean updateStudentDetails(final Student student) {
        return STUDENTDAO.updateStudents(student);
    }

    /**
     * Get values from the database.
     */
    public Student selectStudent(final int rollno) {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollno)) {
            return STUDENTDAO.selectStudent(rollno);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

}
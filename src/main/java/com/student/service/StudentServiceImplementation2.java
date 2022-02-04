package com.student.service;

import com.exception.RecordNotfoundException;
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
        boolean isDeleted = STUDENTDAO.removeStudent(rollNo);

        if (isDeleted) {
            System.out.println("DeletedSuccesfully");
        } else {
            throw new RecordNotfoundException("Record Not Found");
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
        boolean isUpdated = STUDENTDAO.updateStudents(student);

        if (isUpdated) {
            System.out.println("UpdatedSuccesfully");
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }

        return student;
    }

    /**
     * It getvalues from database.
     */
    public Student selectStudent(int rollno) {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollno)) {
            return STUDENTDAO.selectStudent(rollno);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

}
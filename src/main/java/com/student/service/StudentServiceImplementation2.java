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
     * 
     * @throws RecordNotfoundException
     */
    public void removeStudent(int rollNo) throws RecordNotfoundException {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollNo)) {
            STUDENTDAO.removeStudent(rollNo);
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
     * 
     * @throws RecordNotfoundException
     */
    public Student updateStudentDetails(Student student) throws RecordNotfoundException {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(student.getRollNo())) {
            STUDENTDAO.updateStudents(student);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }

        return student;
    }

    /**
     * It getvalues from database.
     * 
     * @throws RecordNotfoundException
     */
    public Student selectStudent(int rollno) throws RecordNotfoundException {

        if (STUDENTDAO.getAllStudentsfromdb().containsKey(rollno)) {
            return STUDENTDAO.selectStudent(rollno);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

}
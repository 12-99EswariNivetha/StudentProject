package com.student.service;

import java.util.Map;
import com.student.exception.CustomException.IdAlreadyFoundException;
import com.student.exception.CustomException.RecordNotfoundException;
import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceVersion2 {

    private static final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

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
        final boolean isRemoved = STUDENTDAO.removeStudent(rollNo);

        if (isRemoved) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Get all students details from database.
     */
    public Map<Integer, Student> ShowAllStudents() {
        final Map<Integer, Student> students = STUDENTDAO.getAllStudentsfromdb();

        if (!students.isEmpty()) {
            return students;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Update student details to the database.
     */
    public boolean updateStudentDetails(final Student student) {
        final boolean isUpdated = STUDENTDAO.updateStudents(student);

        if (isUpdated) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
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

    public boolean CheckRollNo(final int rollNo) {
        final boolean isRollNoPresent = STUDENTDAO.getAllStudentsfromdb().containsKey(rollNo);

        if (!isRollNoPresent) {
            return true;
        }
        throw new IdAlreadyFoundException("The Given RollNo Already Exist in Table.\n Re-Enter RollNo ");

    }
    

    public boolean CheckRollNoUpdate(final int rollNo) {
        final boolean isRollNoPresent = STUDENTDAO.getAllStudentsfromdb().containsKey(rollNo);

        if (isRollNoPresent) {
            return true;
        }
        throw new RecordNotfoundException("Record Not Found");

    }
}
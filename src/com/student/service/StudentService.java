package com.student.service;

import java.util.Map;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {
    /**
     * add the given Details
     *
     * @param rollNo  first parameter is passed as key to add keyvalue to addStudent
     *                method.
     * @param student second parameter is passed as value to add values to
     *                addStudent method.
     */
    public void addStudent(int rollNo, Student student);

    /**
     * remove the detail by using key
     *
     * @param rollNo parameter is passed as key to remove Studentdetails
     */
    public Map<Integer, Student> removeStudent(int rollNo);

    /**
     * This method is used to ShowAllStudent details
     */
    public void showAllStudents();

    /**
     * This method is used to getStudent details
     */
    public void getStudentDetails(int rollNo);

    /**
     * This method is used to updateStudent details
     * 
     * @param rollNo  parameter is passed as key to update Studentdetails
     * @param student second parameter is passed as value to update values to
     *                updateStudentDetails
     */
    public Student updateStudentDetails(int rollNo, Student student);

}

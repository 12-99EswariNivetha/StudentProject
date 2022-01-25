package com.student.service;

import java.util.Date;

import com.student.model.Student;

/**
 * marks StudentsServiceImplementation implements StudentsService
 */

public interface StudentService {
    /**
     * Its add the given Details.
     */
    public void addStudent(int rollNo, Student student);

    /**
     * Its remove the detail by using key.
     */
    public void removeStudent(int rollNo);

    /**
     * Its ShowAllStudent details.
     */
    public void showAllStudents();

    /**
     * Its getStudent details by using key.
     */
    public void getStudentDetails(int rollNo);

    /**
     * Its updateStudent details.
     */
    public Student updateStudentDetails(Student student);
    
    /**
     * For validating rollNo
     */
    public  int rollNoValidation(String rollNo);
    
    /**
     * For validating name
     */
    public  String nameValidation(String name);
    
    /**
     * For validating standard
     */
    public  int standardValidation(String stand);
    

    /**
     * For validating emailId
     */
    public  String emailIdValidation(String emailId);
    
    /**
     * For validating date
     */
    public  Date dateValidation(String date);
    
    /**
     * For validating phoneno
     */
    public  long phoneNoValidation(String phoneNo);

}

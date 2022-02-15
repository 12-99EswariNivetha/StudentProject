package com.student.dao;

import java.util.Map;
import com.student.model.Student;

/**
 * Interface to provide StudentDao Implementation.
 * 
 * @author EswariNivethaVU
 */
public interface StudentDao {
    
    boolean addStudent(Student student);

    boolean removeStudent(int rollno);

    Map<Integer, Student> getAllStudents();

    boolean updateStudents(Student student);

    Student selectStudent(int rollno);
}

package com.student.service;

import java.util.Map;
import com.student.model.Student;

/**
 * Interface to provide StudentService.
 * 
 * @author EswariNivethaVU
 */
public interface StudentService {

    boolean addStudent(final Student student);

    boolean removeStudent(final int rollNo);

    Map<Integer, Student> showAllStudents();

    Student selectStudent(final int rollNo);

    boolean updateStudentDetails(final Student student);
}

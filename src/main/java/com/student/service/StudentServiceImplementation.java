package com.student.service;
import java.util.HashMap;
import java.util.Map;
import com.student.exception.CustomException.IdAlreadyFoundException;
import com.student.exception.CustomException.RecordNotfoundException;
import com.student.model.Student;

/**
 * Service Implementation! StudentServiceImplementation implements
 * StudentService and gives definition to StudentService Created HashMap
 * collection for storing details.
 */

public class StudentServiceImplementation implements StudentService {
    /**
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @see HashMap
     */
    private static final Map<Integer, Student> STUDENTSLIST = new HashMap<Integer, Student>();

    /**
     * Adds the student details
     */
    public boolean addStudent(final Student student) {

        if (STUDENTSLIST.containsKey(student.getRollNo())) {
            throw new IdAlreadyFoundException(" Id already exist");
        } else {
            STUDENTSLIST.put(student.getRollNo(), student);
            return true;
        }
    }

    /**
     * Removes the student details.
     */
    public boolean removeStudent(final int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            STUDENTSLIST.remove(rollNo);
            System.out.println("DeletedSuccesfully");
            return true;
        } else {
            
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Shows all the student details.
     */
    public Map<Integer, Student> showAllStudents() {

        for (Map.Entry<Integer, Student> show : STUDENTSLIST.entrySet()) {
            System.out.println(show);
        }
        return STUDENTSLIST;
    }

    /**
     * Get student details which display studentDetails by given key-value.
     */
    public Student selectStudent(int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            return (STUDENTSLIST.get(rollNo));
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Updates the student details.
     */
    public boolean updateStudentDetails(final Student student) {
        int rollNo = student.getRollNo();

        if (STUDENTSLIST.containsKey(rollNo)) {
            Student getStudent = STUDENTSLIST.get(rollNo);

            if (student.getName() != null) {
                getStudent.setName(student.getName());
            }
            if (student.getStandard() != null) {
                getStudent.setStandard(student.getStandard());
            }
            if (student.getPhonenumber() != 0) {
                getStudent.setPhonenumber(student.getPhonenumber());
            }
            if (student.getEmailId() != null) {
                getStudent.setEmailId(student.getEmailId());
            }
            if (student.getDate() != null) {
                getStudent.setDate(student.getDate());
            }
            return true;
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }
}
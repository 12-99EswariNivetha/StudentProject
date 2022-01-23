package com.student.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.student.model.Student;

/**
 * <h1>Student, Service Implementation! StudentServiceImplementation implements
 * StudentService and gives definition to StudentService Created HashMap
 * collection for storing details.
 */

public class StudentServiceImplementation implements StudentService {
    /**
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @see HashMap
     * @see TreeMap
     * @see Hashtable
     * @see SortedMap
     * @see Collection
     * @see Set
     */
    public static final Map<Integer, Student> STUDENTSLIST = new HashMap<>();

    /**
     * This method is used to addStudent details.
     * 
     * @param rollNo  first parameter is passed as key to add keyvalue to addStudent
     * @param student second parameter is passed as value to add values to
     *                addStudent
     */
    @Override
    public void addStudent(int rollNo, Student student) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println("The given Id already Exit");

        } else {
            STUDENTSLIST.put(rollNo, student);
        }
    }

    /**
     * This method is used to removeStudent details.
     * 
     * @param rollNo parameter is passed as key to remove Studentdetails
     */
    @Override
    public void removeStudent(int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println(STUDENTSLIST.remove(rollNo));
            System.out.println("DeletedSuccesfully");
        } else {
            System.out.println("Record Not Found");
        }
    }

    /**
     * This method is used to ShowAllStudent details which display all
     * StudentDetails
     * 
     * @return No return type
     */
    @Override
    public void showAllStudents() {

        for (Map.Entry<Integer, Student> set : STUDENTSLIST.entrySet()) {
            System.out.println(set);
        }
    }

    /**
     * This method is used to getStudent details which display StudentDetails by
     * given keyvalue
     * 
     * @param rollNo parameter is passed as key to get Studentdetails
     * @return No return type
     */
    @Override
    public void getStudentDetails(int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println(STUDENTSLIST.get(rollNo));
        } else {
            System.out.println("Record Not Found");
        }

    }

    /**
     * This method is used to updateStudent details.
     * 
     * @param rollNo  parameter is passed as key to update Studentdetails
     * @param student second parameter is passed as value to update values to
     *                updateStudentDetails
     * @return Map<Integer, Student> This returns the value of given key which is
     *         updated
     */
    @Override
    public Student updateStudentDetails(int rollNo, Student students) {
        boolean StudentIdFound = false;
        Iterator<Integer> iterator = STUDENTSLIST.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Student student = STUDENTSLIST.get(key);

            if (key == rollNo) {
                if (students.getName() != null) {
                    student.setName(students.getName());
                    StudentIdFound = true;
                    break;
                } else if (students.getStandard() != 0) {
                    student.setStandard(students.getStandard());
                    StudentIdFound = true;
                    break;
                } else if (students.getPhonenumber() != 0) {
                    student.setPhonenumber(students.getPhonenumber());
                    StudentIdFound = true;
                    break;
                } else if (students.getEmailId() != null) {
                    student.setEmailId(students.getEmailId());
                    break;
                } else if (students.getDate() != null) {
                    student.setDate(students.getDate());
                    StudentIdFound = true;
                    break;
                }
            }
        }

        if (!StudentIdFound) {
            System.out.println("Record Not Found");
        } else {
            return students;
        }
        return students;
    }
}
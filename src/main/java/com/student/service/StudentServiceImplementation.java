package com.student.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exception.RecordNotfoundException;
import com.student.dao.StudentDaoImpl;
import com.student.model.Student;
import com.student.view.StudentView;

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
    private static final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    /**
     * Its addStudent details.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException 
     */
    public void addStudent(Student student) throws SQLException, RecordNotfoundException {

        if (STUDENTSLIST.isEmpty()) {
            STUDENTSLIST.putAll(STUDENTDAO.getAllStudentfromdb());
        }
        if (STUDENTSLIST.containsKey(student.getRollNo())) {
            System.out.println("Id is Already Exit");
        } else {
            STUDENTDAO.addStudent(student);
            STUDENTSLIST.put(student.getRollNo(), student);
        }
    }

    /**
     * Its removeStudent details.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException 
     */
    public void removeStudent(int rollNo) throws SQLException, RecordNotfoundException {

        if (STUDENTSLIST.isEmpty()) {
            STUDENTSLIST.putAll(STUDENTDAO.getAllStudentfromdb());
        }
        if (STUDENTSLIST.containsKey(rollNo)) {
            STUDENTSLIST.remove(rollNo);
            STUDENTDAO.removeStudent(rollNo);
            System.out.println("DeletedSuccesfully");
        } else {
            try {
                throw new RecordNotfoundException("Id not found");
            } catch (RecordNotfoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Its ShowAllStudent details which display all StudentDetails
     * 
     * @throws SQLException
     * @throws RecordNotfoundException 
     */
    public void showAllStudents() throws SQLException, RecordNotfoundException {
        System.out.println(STUDENTDAO.getAllStudentfromdb());
    }

    /**
     * Its getStudent details which display StudentDetails by given keyvalue
     * 
     * @throws SQLException
     * @throws RecordNotfoundException 
     */
    public void getStudentDetails(int rollNo) throws SQLException, RecordNotfoundException {

        if (STUDENTSLIST.isEmpty()) {
            STUDENTSLIST.putAll(STUDENTDAO.getAllStudentfromdb());
        }
        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println(STUDENTSLIST.get(rollNo));
        } else {
            System.out.println("id not found");
            try {
                throw new RecordNotfoundException("Id not found");
            } catch (RecordNotfoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Its updateStudent details.
     * 
     * @throws SQLException
     * @throws RecordNotfoundException 
     */
    public Student updateStudentDetails(Student student) throws SQLException, RecordNotfoundException {
        int rollNo = student.getRollNo();

        if (STUDENTSLIST.isEmpty()) {
            STUDENTSLIST.putAll(STUDENTDAO.getAllStudentfromdb());
        }
        if (STUDENTSLIST.containsKey(rollNo)) {
            Student getStudent = STUDENTSLIST.get(rollNo);
            STUDENTDAO.updateStudents(student);

            if (student.getName() != null) {
                getStudent.setName(student.getName());
            } else if (student.getStandard() != 0) {
                getStudent.setStandard(student.getStandard());
            } else if (student.getPhonenumber() != 0) {
                getStudent.setPhonenumber(student.getPhonenumber());
            } else if (student.getEmailId() != null) {
                getStudent.setEmailId(student.getEmailId());
            } else if (student.getDate() != null) {
                getStudent.setDate(student.getDate());
            }
        } else {
            try {
                throw new RecordNotfoundException("Id not found");
            } catch (RecordNotfoundException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    /**
     * Its validate the PhoneNumber.
     */
    public long phoneNoValidation(String phoneNo) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher match = pattern.matcher(phoneNo);

        if (match.find() && match.group().equals(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid PhoneNo :");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * Its to validate the Name.
     */
    public String nameValidation(String name) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]*$");
        Matcher match = pattern.matcher(name);

        if (match.find() && match.group().equals(name)) {
            return name;
        } else {
            System.out.println("Not Valid \n Re-enter a valid Name :");
            return StudentView.getName();
        }
    }

    /**
     * Its validate the rollNo.
     */
    public int rollNoValidation(String rollNo) {
        Pattern pattern = Pattern.compile("[0-9]{3}");
        Matcher match = pattern.matcher(rollNo);

        if (match.find() && match.group().equals(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid RollNo :");
            return StudentView.getRollNo();
        }
    }

    /**
     * Its validate the standard.
     */
    public int standardValidation(String stand) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher match = pattern.matcher(stand);

        if (match.find() && match.group().equals(stand)) {
            return Integer.parseInt(stand);
        } else {
            System.out.println("Not Valid \n Re-enter a valid Standard :");
            return StudentView.getStandard();
        }
    }

    /**
     * Its validate the emailId.
     */
    public String emailIdValidation(String emailId) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher match = pattern.matcher(emailId);

        if (match.find() && match.group().equals(emailId)) {
            return emailId;
        } else {
            System.out.println("Not Valid \n Re-enter a valid MailId :");
            return StudentView.getEmailId();
        }
    }

    /**
     * Its validate the date.
     */
    public Date dateValidation(String date) {

        try {
            LocalDate localdate = LocalDate.parse(date);
            LocalDate currentLocalDate = LocalDate.now();

            if (currentLocalDate.plusDays(1).isAfter(localdate)) {
                return Date.valueOf(localdate);
            }

        } catch (Exception e) {
            System.out.println("Not Valid \n Re-enter a valid Date :");
            return StudentView.getDate();
        }
        return StudentView.getDate();

    }
}
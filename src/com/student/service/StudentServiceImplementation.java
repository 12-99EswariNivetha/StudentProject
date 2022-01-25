package com.student.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final Map<Integer, Student> STUDENTSLIST = new HashMap<>();

    /**
     * Its addStudent details.
     */
    @Override
    public Student addStudent(int rollNo, Student student) {
        
        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println("The given Id already Exit");
        } else {
            STUDENTSLIST.put(rollNo, student);
        }
        return student;
    }

    /**
     * Its removeStudent details.
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
     * Its ShowAllStudent details which display all StudentDetails
     */
    @Override
    public void showAllStudents() {

        for (Map.Entry<Integer, Student> studentEntry : STUDENTSLIST.entrySet()) {
            System.out.println(studentEntry);
        }
    }

    /**
     * Its getStudent details which display StudentDetails by given keyvalue
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
     * Its updateStudent details.
     */
    @Override
    public Student updateStudentDetails(Student student) {
        int rollNo = student.getRollNo();

        if (STUDENTSLIST.containsKey(rollNo)) {
            Student getStudent = STUDENTSLIST.get(rollNo);

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
            System.out.println("Record Not Found");
        }
        return student;
    }

    /**
     * Its validate the PhoneNumber.
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
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
     *  Its validate the emailId.
     */
    @Override
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
    @Override
    public Date dateValidation(String date) {

        try {
            LocalDate localdate = LocalDate.parse(date);
            LocalDate currentLocalDate = LocalDate.now();
            ZoneId systemTimeZone = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime =localdate.atStartOfDay().atZone(systemTimeZone);

            if (currentLocalDate.isAfter(localdate)) {  
                return Date.from(zonedDateTime.toInstant());
            }

        } catch (Exception e) {
            System.out.println("Not Valid \n Re-enter a valid Date :");
            return StudentView.getDate();
        }
        return StudentView.getDate();
    }
}
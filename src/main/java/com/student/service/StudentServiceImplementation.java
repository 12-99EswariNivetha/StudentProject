package com.student.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exception.RecordNotfoundException;
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

    /**
     * Its addStudent details.
     */
    public void addStudent(final Student student) {

        if (STUDENTSLIST.containsKey(student.getRollNo())) {
            System.out.println("Id is Already Exit");
        } else {
            STUDENTSLIST.put(student.getRollNo(), student);
        }
    }

    /**
     * Its removeStudent details.
     * 
     * @throws RecordNotfoundException
     */
    public void removeStudent(final int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            STUDENTSLIST.remove(rollNo);
            System.out.println("DeletedSuccesfully");
        } else {
            System.out.println("Record Not Found");
        }
    }

    /**
     * Its ShowAllStudent details which display all StudentDetails
     */
    public void showAllStudents() {

        for (Map.Entry<Integer, Student> show : STUDENTSLIST.entrySet()) {
            System.out.println(show);
        }
    }

    /**
     * Its getStudent details which display StudentDetails by given keyvalue
     */
    public void getStudentDetails(final int rollNo) {

        if (STUDENTSLIST.containsKey(rollNo)) {
            System.out.println(STUDENTSLIST.get(rollNo));
        } else {
            System.out.println("Record Not Found");
        }
    }

    /**
     * Its updateStudent details.
     */
    public Student updateStudentDetails(final Student student) {
        int rollNo = student.getRollNo();

        if (STUDENTSLIST.containsKey(rollNo)) {
            Student getStudent = STUDENTSLIST.get(rollNo);

            if (student.getName() != null) {
                getStudent.setName(student.getName());
            }
            if (student.getStandard() != 0) {
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
        } else {
            System.out.println("Record Not Found");
        }
        return student;
    }

    /**
     * It validate the PhoneNumber.
     */
    public long phoneNoValidation(final String phoneNo) {
        Pattern phonenoPattern = Pattern.compile("[0-9]{10}");
        Matcher phonenomatcher = phonenoPattern.matcher(phoneNo);

        if (phonenomatcher.find() && phonenomatcher.group().equals(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid PhoneNo :");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * It validate the Name.
     */
    public String nameValidation(final String name) {
        Pattern namepattern = Pattern.compile("[a-zA-Z\\s]*$");
        Matcher namematcher = namepattern.matcher(name);

        if (namematcher.find() && namematcher.group().equals(name)) {
            return name;
        } else {
            System.out.println("Not Valid \n Re-enter a valid Name :");
            return StudentView.getName();
        }
    }

    /**
     * Its validate the rollNo.
     */
    public int rollNoValidation(final String rollNo) {
        Pattern rollNopattern = Pattern.compile("[0-9]{3}");
        Matcher rollNomatcher = rollNopattern.matcher(rollNo);

        if (rollNomatcher.find() && rollNomatcher.group().equals(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid RollNo :");
            return StudentView.getRollNo();
        }
    }

    /**
     * Its validate the standard.
     */
    public int standardValidation(final String stand) {
        Pattern standardpattern = Pattern.compile("[0-9]{1,}");
        Matcher standardmatcher = standardpattern.matcher(stand);

        if (standardmatcher.find() && standardmatcher.group().equals(stand)) {
            return Integer.parseInt(stand);
        } else {
            System.out.println("Not Valid \n Re-enter a valid Standard :");
            return StudentView.getStandard();
        }
    }

    /**
     * Its validate the emailId.
     */
    public String emailIdValidation(final String emailId) {
        Pattern emailidpattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher emailidmatcher = emailidpattern.matcher(emailId);

        if (emailidmatcher.find() && emailidmatcher.group().equals(emailId)) {
            return emailId;
        } else {
            System.out.println("Not Valid \n Re-enter a valid MailId :");
            return StudentView.getEmailId();
        }
    }

    /**
     * Its validate the date.
     */
    public Date dateValidation(final String date) {
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
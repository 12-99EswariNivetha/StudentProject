package com.student.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.student.exception.CustomException.IdAlreadyFoundException;
import com.student.exception.CustomException.RecordNotfoundException;
import com.student.main.StudentMain;
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

    /**
     * Validates the PhoneNumber.
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
     * Validates the Name.
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
     * Validates the RollNo.
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
     * Validates the Standard.
     */
    public String standardValidation(final String stand) {
        int std = Integer.parseInt(stand);
        
        if(std<13 && std >0 || (stand.equals("Pre.K.G")||(stand.equals("L.K.G")||(stand.equals("U.K.G"))))) {
            return stand;
        }else {
            System.out.println("Not Valid \n Re-enter a valid Standard :");
            return StudentView.getStandard();
        
        }
       
    }

    /**
     * Validates the EmailId.
     */
    public String emailIdValidation(final String emailId) {
        Pattern emailidpattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]{2,3}+$");
        Matcher emailidmatcher = emailidpattern.matcher(emailId);

        if (emailidmatcher.find() && emailidmatcher.group().equals(emailId)) {
            return emailId;
        } else {
            System.out.println("Not Valid \n Re-enter a valid MailId :");
            return StudentView.getEmailId();
        }
    }

    /**
     * Validates the Date.
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
    /**
     *  Validates the Choice.
     */
    public static int validateChoice(final String choice) {
        
        if(choice.matches("[1-5]")){
            return Integer.parseInt(choice);
        }else {
            System.out.println("Select Valid Choice Use only [1-5]");
            return validateChoice(StudentMain.SCANNER.next());
        }
    }
}
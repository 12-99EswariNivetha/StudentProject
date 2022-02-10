package com.student.view;

import java.sql.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.student.exception.CustomException;
import com.student.exception.CustomException.RecordNotfoundException;
import com.student.controller.StudentController;
import com.student.model.Student;
import com.student.service.Validation;

/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 */
public class StudentView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Validation VALIDATE = new Validation();
    private static final StudentController STUDENTCONTROLLER = new StudentController();
    private static final Logger logger = Logger.getLogger(StudentView.class);

    /**
     * Get rollno from user.
     */
    public static int getRollNo() {
        System.out.println("Enter the RollNo(Give 3 Digit No):");
        final String rollNo = SCANNER.nextLine();
        final boolean isValid = VALIDATE.rollNoValidation(rollNo);
        
        if (isValid) {
            return Integer.parseInt(rollNo);
        } else {
            logger.error("Not Valid \n Re-enter a valid RollNo :");
            return StudentView.getRollNo();
        }
    }

    /**
     * Get name from user.
     */
    public static String getName() {
        System.out.println("Enter the Name:");
        final String name = SCANNER.nextLine();
        final boolean isValid = VALIDATE.nameValidation(name);
        
        if (isValid) {
            return name;
        } else {
            logger.error("Not Valid \n Re-enter a valid Name :");
            return StudentView.getName();
        }
    }

    /**
     * Get standard from user.
     */
    public static String getStandard() {
        System.out.println("Enter the Standard:");
        final String stand = SCANNER.nextLine();
        final boolean isValid = VALIDATE.standardValidation(stand);
        
        if (isValid) {
            return stand;
        } else {
            logger.error("Not Valid \n Re-enter a valid Standard :");
            return StudentView.getStandard();
        }
    }

    /**
     * Get phoneno from user.
     */
    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        final String phoneNo = SCANNER.nextLine();
        final boolean isValid = VALIDATE.phoneNoValidation(phoneNo);
        
        if (isValid) {
            return Long.parseLong(phoneNo);
        } else {
            logger.error("Not Valid \n Re-enter a valid PhoneNo :");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * Get emailid from user.
     */
    public static String getEmailId() {
        System.out.println("Enter the EmailId:");
        final String emailId = SCANNER.nextLine();
        final boolean isValid = VALIDATE.emailIdValidation(emailId);
        
        if (isValid) {
            return emailId;
        } else {
            logger.error("Not Valid \n Re-enter a valid MailId :");
            return StudentView.getEmailId();
        }
    }

    /**
     * Get date from user.
     */
    public static Date getDate() {

        System.out.println("Enter DoB(yyyy-mm-dd):");
        final String date = SCANNER.nextLine();
        boolean isValid = false;

        try {
            isValid = VALIDATE.dateValidation(date);
        } catch (CustomException e) {
            System.out.println(e);
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            logger.error("Not Valid \n Re-enter a valid Date :");
            return StudentView.getDate();
        }
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {

        try {
            final int rollNo = StudentView.getRollNo();
            final String name = StudentView.getName();
            final String standard = StudentView.getStandard();
            final long phoneNo = StudentView.getPhoneNo();
            final String emailId = StudentView.getEmailId();
            final Date Date = StudentView.getDate();

            final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

            final boolean isInserted = STUDENTCONTROLLER.addStudent(rollNo, student);

            if (isInserted) {
                logger.info("Inserted SuccessFully");
            }
        } catch (CustomException e) {
            logger.error(e);
        }
    }

    /**
     * Display all Students and sends a request to the controller.
     */
    public static void showAllStudents() {

        try {
            System.out.println(STUDENTCONTROLLER.showAllStudents());
        } catch (CustomException e) {
            logger.error(e);
        }

    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {

        try {
            final boolean isRemoved = STUDENTCONTROLLER.removeStudent(StudentView.getRollNo());

            if (isRemoved) {
                logger.info("Deleted SuccessFully");
            }
        } catch (CustomException e) {
            logger.error(e);
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void selectStudent() {

        try {
            logger.info(STUDENTCONTROLLER.SearchStudentDetails(StudentView.getRollNo()));
        } catch (RecordNotfoundException e) {
            logger.error(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {

        try {
            Student student = new Student();

            student.setRollNo(StudentView.getRollNo());
            System.out.println("Do you want to change your name? yes or no ");

            if (("yes").equals(SCANNER.nextLine())) {
                student.setName(StudentView.getName());
            }
            System.out.println("Do you want to change your standard? yes or no");

            if (("yes").equals(SCANNER.nextLine())) {
                student.setStandard(StudentView.getStandard());
            }
            System.out.println("Do you want to change your phoneNo? yes or no");

            if (("yes").equals(SCANNER.nextLine())) {
                student.setPhonenumber(StudentView.getPhoneNo());
            }
            System.out.println("Do you want to change your emailid? yes or no");

            if (("yes").equals(SCANNER.nextLine())) {
                student.setEmailId(StudentView.getEmailId());
            }
            System.out.println("Do you want to change your dob? yes or no");

            if (("yes").equals(SCANNER.nextLine())) {
                student.setDate(StudentView.getDate());
            }

            final boolean isUpdated = STUDENTCONTROLLER.updateStudentDetails(student.getRollNo(), student);

            if (isUpdated) {
                logger.info("Updated SuccessFully");
            }
        } catch (CustomException e) {
            logger.error(e);
        }
    }
}
package com.student.view;

import java.sql.Date;
import java.util.Map.Entry;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.student.exception.CustomException;
import com.student.main.StudentManagement;
import com.student.controller.StudentController;
import com.student.model.Student;

/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 */
public class StudentView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Validation VALIDATOR = new Validation();
    private static final StudentController STUDENTCONTROLLER = new StudentController();
    private static final Logger LOGGER = Logger.getLogger(StudentView.class);

    /**
     * Get rollno from the user.
     */
    public static int getRollNo() {
        LOGGER.info("Enter the RollNo(Give 3 Digit No): \n Press @ To Exit to Main Menu");
        final String rollNo = SCANNER.nextLine().trim();
        StudentView.backToMain(rollNo);

        if (VALIDATOR.validateRollNo(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            LOGGER.warn("InValid RollNo Please Enter a valid RollNo \n Press @ To Exit to Main Menu");
            return StudentView.getRollNo();
        }
    }

    /**
     * Get the name from the user.
     */
    public static String getName() {
        LOGGER.info("Enter the Name:");
        final String name = SCANNER.nextLine().trim();
        StudentView.backToMain(name);

        if (VALIDATOR.validateName(name)) {
            return name;
        } else {
            LOGGER.warn(" InValid Name Please Enter a valid Name \n Press @ To Exit to Main Menu");
            return StudentView.getName();
        }
    }

    /**
     * Get standard from the user.
     */
    public static String getStandard() {
        LOGGER.info("Enter the Standard [PREKG - UKG, 1-12]");
        final String standard = SCANNER.nextLine().trim();
        StudentView.backToMain(standard);

        if (VALIDATOR.validateStandard(standard)) {
            return standard;
        } else {
            LOGGER.warn(" InValid Standard Please Enter a valid Standard  \n Press @ To Exit to Main Menu");
            return StudentView.getStandard();
        }
    }

    /**
     * Get phone no from the user.
     */
    public static long getPhoneNo() {
        LOGGER.info("Enter the PhoneNumber:");
        final String phoneNo = SCANNER.nextLine().trim();
        StudentView.backToMain(phoneNo);

        if (VALIDATOR.validatePhoneNo(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            LOGGER.warn(" InValid PhoneNo Please Enter a valid PhoneNo \n Press @ To Exit to Main Menu");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * Get emailid from the user.
     */
    public static String getEmailId() {
        LOGGER.info("Enter the EmailId:");
        final String emailId = SCANNER.nextLine().trim();
        StudentView.backToMain(emailId);

        if (VALIDATOR.validateEmailId(emailId)) {
            return emailId;
        } else {
            LOGGER.warn("InValid EmailId Please Enter a valid MailId  \n Press @ To Exit to Main Menu");
            return StudentView.getEmailId();
        }
    }

    /**
     * Get a date from the user.
     */
    public static Date getDate() {
        LOGGER.info("Enter Date of Joining(yyyy-mm-dd):");
        final String date = SCANNER.nextLine().trim();
        StudentView.backToMain(date);
        boolean isValid = false;

        try {
            isValid = VALIDATOR.validateDate(date);
        } catch (CustomException e) {
            System.out.println(e);
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            LOGGER.warn("InValid Date Please Enter a valid Date \n Press @ To Exit to Main Menu");
            return StudentView.getDate();
        }
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {
        final int rollNo = StudentView.getRollNo();

        try {
            STUDENTCONTROLLER.checkRollno(rollNo);
        } catch (CustomException e) {
            LOGGER.error(e);
            StudentView.addStudent();
            StudentManagement.selectChoice();
        }
        final String name = StudentView.getName();
        final String standard = StudentView.getStandard();
        final long phoneNo = StudentView.getPhoneNo();
        final String emailId = StudentView.getEmailId();
        final Date Date = StudentView.getDate();

        final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        try {

            if (STUDENTCONTROLLER.addStudent(rollNo, student)) {
                LOGGER.info("Inserted SuccessFully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Display all Students and send a request to the controller.
     */
    public static void showAllStudents() {

        try {
            for (Entry<Integer, Student> entry : STUDENTCONTROLLER.getAllStudents().entrySet()) {
                System.out.println(entry.getValue());
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {

        try {

            if (STUDENTCONTROLLER.removeStudent(StudentView.getRollNo())) {
                LOGGER.info("Deleted SuccessFully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void selectStudent() {

        try {
            LOGGER.info(STUDENTCONTROLLER.searchStudentDetail(StudentView.getRollNo()));
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {
        final String name = "name";
        final String standard = "standard";
        final String phoneNo = "phoneNo";
        final String emailid = "emailId";
        final String date = "date";
        final Student student = new Student();
        final int rollNo = StudentView.getRollNo();

        try {
            STUDENTCONTROLLER.checkRollnoForUpdate(rollNo);
        } catch (CustomException e) {
            LOGGER.error(e);
            StudentView.updateStudent();
            StudentManagement.selectChoice();
        }
        student.setRollNo(rollNo);
        LOGGER.info("Do you want to change your name? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, name);
        LOGGER.info("Do you want to change your standard? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, standard);
        LOGGER.info("Do you want to change your phoneno? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, phoneNo);
        LOGGER.info("Do you want to change your email? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, emailid);
        LOGGER.info("Do you want to change your joiningdate? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, date);

        try {
            if (STUDENTCONTROLLER.updateStudentDetails(rollNo, student)) {
                LOGGER.info("Updated Successfully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Checking next field for update.
     * 
     * @param student
     * @param studentdetail
     * @return
     */
    public static Student updateDetail(final Student student, final String studentdetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = SCANNER.nextLine().trim();
            StudentView.backToMain(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(studentdetail)) {
                    student.setName(StudentView.getName());
                    break;
                } else if ("standard".equalsIgnoreCase(studentdetail)) {
                    student.setStandard(StudentView.getStandard());
                    break;
                } else if ("phoneno".equalsIgnoreCase(studentdetail)) {
                    student.setPhonenumber(StudentView.getPhoneNo());
                    break;
                } else if ("emailId".equalsIgnoreCase(studentdetail)) {
                    student.setEmailId(StudentView.getEmailId());
                    break;
                } else if ("date".equalsIgnoreCase(studentdetail)) {
                    student.setDate(StudentView.getDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.warn("Invalid Option");
                continue;
            }
        }
        return student;
    }

    /**
     * Getting choice from the user.
     */
    public static String getChoice() {
        final String choice = StudentManagement.SCANNER.nextLine().trim();

        if (VALIDATOR.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.info("Please Enter Valid Choice use only [1-6]");
            return StudentView.getChoice();
        }
    }

    /**
     * Back to main menu.
     */
    public static void backToMain(String option) {

        if ("@".equals(option)) {
            StudentManagement.selectChoice();
        }
    }
}
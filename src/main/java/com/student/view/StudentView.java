package com.student.view;

import java.sql.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.student.exception.CustomException;
import com.student.main.StudentMain;
import com.student.controller.StudentController;
import com.student.model.Student;

/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 */
public class StudentView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Validation VALIDATE = new Validation();
    private static final StudentController STUDENTCONTROLLER = new StudentController();
    private static final Logger LOGGER = Logger.getLogger(StudentView.class);

    /**
     * Get rollno from the user.
     */
    public static int getRollNo() {
        LOGGER.info("Enter the RollNo(Give 3 Digit No): \n Press @ To Exit to Main Menu");
        final String rollNo = SCANNER.nextLine().trim();

        if (("@").equals(rollNo)) {
            StudentMain.selectChoice();
        }
        final boolean isValid = VALIDATE.rollNoValidation(rollNo);

        if (isValid) {
            return Integer.parseInt(rollNo);
        } else {
            LOGGER.error("Not Valid Please Enter a valid RollNo \n Press @ To Exit to Main Menu");
            return StudentView.getRollNo();
        }
    }

    /**
     * Get the name from the user.
     */
    public static String getName() {
        LOGGER.info("Enter the Name:");
        final String name = SCANNER.nextLine().trim();

        if (("@").equals(name)) {
            StudentMain.selectChoice();
        }
        final boolean isValid = VALIDATE.nameValidation(name);

        if (isValid) {
            return name;
        } else {
            LOGGER.error("Not Valid Please Enter a valid Name \n Press @ To Exit to Main Menu");
            return StudentView.getName();
        }
    }

    /**
     * Get standard from the user.
     */
    public static String getStandard() {
        LOGGER.info("Enter the Standard:");
        final String stand = SCANNER.nextLine().trim();

        if (("@").equals(stand)) {
            StudentMain.selectChoice();
        }
        final boolean isValid = VALIDATE.standardValidation(stand);

        if (isValid) {
            return stand;
        } else {
            LOGGER.error("Not Valid Please Enter a valid Standard  \n Press @ To Exit to Main Menu");
            return StudentView.getStandard();
        }
    }

    /**
     * Get phone no from the user.
     */
    public static long getPhoneNo() {
        LOGGER.info("Enter the PhoneNumber:");
        final String phoneNo = SCANNER.nextLine().trim();

        if (("@").equals(phoneNo)) {
            StudentMain.selectChoice();
        }
        final boolean isValid = VALIDATE.phoneNoValidation(phoneNo);

        if (isValid) {
            return Long.parseLong(phoneNo);
        } else {
            LOGGER.error("Not Valid Please Enter a valid PhoneNo \n Press @ To Exit to Main Menu");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * Get emailid from the user.
     */
    public static String getEmailId() {
        LOGGER.info("Enter the EmailId:");
        final String emailId = SCANNER.nextLine().trim();

        if (("@").equals(emailId)) {
            StudentMain.selectChoice();
        }
        final boolean isValid = VALIDATE.emailIdValidation(emailId);

        if (isValid) {
            return emailId;
        } else {
            LOGGER.error("Not Valid Please Enter a valid MailId  \n Press @ To Exit to Main Menu");
            return StudentView.getEmailId();
        }
    }

    /**
     * Get a date from the user.
     */
    public static Date getDate() {
        LOGGER.info("Enter Date of Joining(yyyy-mm-dd):");
        final String date = SCANNER.nextLine().trim();

        if (("@").equals(date)) {
            StudentMain.selectChoice();
        }
        boolean isValid = false;

        try {
            isValid = VALIDATE.dateValidation(date);
        } catch (CustomException e) {
            System.out.println(e);
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            LOGGER.error("Not Valid Please Enter a valid Date \n Press @ To Exit to Main Menu");
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
            StudentMain.selectChoice();
        }
        final String name = StudentView.getName();
        final String standard = StudentView.getStandard();
        final long phoneNo = StudentView.getPhoneNo();
        final String emailId = StudentView.getEmailId();
        final Date Date = StudentView.getDate();

        final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        try {
            final boolean isInserted = STUDENTCONTROLLER.addStudent(rollNo, student);

            if (isInserted) {
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
            for (Entry<Integer, Student> entry : STUDENTCONTROLLER.showAllStudents().entrySet()) {
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
            final boolean isRemoved = STUDENTCONTROLLER.removeStudent(StudentView.getRollNo());

            if (isRemoved) {
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
            LOGGER.info(STUDENTCONTROLLER.SearchStudentDetails(StudentView.getRollNo()));
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {
        String name = null;
        String standard = null;
        long phoneNo = 0;
        String emailid = null;
        Date date = null;
        final String choiceYes = "yes";
        final String choiceNo = "no";
        final int rollNo = StudentView.getRollNo();

        try {
            STUDENTCONTROLLER.checkRollnoUpdate(rollNo);
        } catch (CustomException e) {
            LOGGER.error(e);
            StudentView.updateStudent();
            StudentMain.selectChoice();
        }
        LOGGER.info("Do you want to change your name? yes or no \n Press @ To Exit to Main Menu ");

        while (true) {
            String option = SCANNER.nextLine().trim();

            if (("@").equals(option)) {
                StudentMain.selectChoice();
            }

            if (choiceYes.equalsIgnoreCase(option)) {
                name = StudentView.getName();
                break;
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.info("Invalid option Enter yes or no");
                continue;
            }
        }
        LOGGER.info("Do you want to change your standard? yes or no \n Press @ To Exit to Main Menu");

        while (true) {
            String option = SCANNER.nextLine().trim();

            if (("@").equals(option)) {
                StudentMain.selectChoice();
            }

            if (choiceYes.equalsIgnoreCase(option)) {
                standard = StudentView.getStandard();
                break;
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.info("Invalid option Enter yes or no");
                continue;
            }
        }
        LOGGER.info("Do you want to change your phone? yes or no \n Press @ To Exit to Main Menu");

        while (true) {
            String option = SCANNER.nextLine().trim();

            if (("@").equals(option)) {
                StudentMain.selectChoice();
            }

            if ((choiceYes.equalsIgnoreCase(option))) {
                phoneNo = StudentView.getPhoneNo();
                break;
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.info("Invalid option Enter yes or no");
                continue;
            }
        }
        LOGGER.info("Do you want to change your email? yes or no \n Press @ To Exit to Main Menu");

        while (true) {
            String option = SCANNER.nextLine().trim();

            if (("@").equals(option)) {
                StudentMain.selectChoice();
            }

            if (choiceYes.equalsIgnoreCase(option)) {
                emailid = StudentView.getEmailId();
                break;
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.info("Invalid option Enter yes or no");
                continue;
            }
        }
        LOGGER.info("Do you want to change your dob? yes or no \n Press @ To Exit to Main Menu");

        while (true) {
            String option = SCANNER.nextLine().trim();

            if (("@").equals(option)) {
                StudentMain.selectChoice();
            }

            if (choiceYes.equalsIgnoreCase(option)) {
                date = StudentView.getDate();
                break;
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.info("Invalid option Enter yes or no");
                continue;
            }
        }
        final Student student = new Student();

        student.setRollNo(rollNo);
        student.setName(name);
        student.setStandard(standard);
        student.setEmailId(emailid);
        student.setPhonenumber(phoneNo);
        student.setEmailId(emailid);
        student.setDate(date);

        try {

            final boolean isUpdated = STUDENTCONTROLLER.updateStudentDetails(student.getRollNo(), student);

            if (isUpdated) {
                LOGGER.info("Updated SuccessFully");
            }

        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Getting Choice from user.
     */
    public static String getChoice() {
        final String choice = StudentMain.SCANNER.nextLine().trim();
        final boolean isChoiceValid = VALIDATE.validateChoice(choice);

        if (isChoiceValid) {
            return choice;
        } else {
            LOGGER.info("Please Enter Valid Choice use only [1-6]");
            return StudentView.getChoice();
        }

    }
}
package com.student.view;

import java.sql.Date;
import java.util.Map;
import java.util.Scanner;

import com.exception.CustomException;
import com.exception.CustomException.RecordNotfoundException;
import com.student.controller.StudentController;
import com.student.model.Student;

/**
 * <h1>Student, View!</h1> The StudentView program implements an application
 * that simply displays "User input".
 */
public class StudentView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StudentController STUDENTCONTROLLER = new StudentController();

    /**
     * Get rollno from user.
     */
    public static int getRollNo() {
        System.out.println("Enter the RollNo:");
        return STUDENTCONTROLLER.rollNoValidation(SCANNER.nextLine());
    }

    /**
     * Get name from user.
     */
    public static String getName() {
        System.out.println("Enter the Name:");
        return STUDENTCONTROLLER.nameValidation(SCANNER.nextLine());
    }

    /**
     * Get standard from user.
     */
    public static int getStandard() {
        System.out.println("Enter the Standard:");
        return STUDENTCONTROLLER.standardValidation(SCANNER.nextLine());
    }

    /**
     * Get phoneno from user.
     */
    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        return STUDENTCONTROLLER.phoneNoValidation(SCANNER.nextLine());
    }

    /**
     * Get emailid from user.
     */
    public static String getEmailId() {
        System.out.println("Enter the EmailId:");
        return STUDENTCONTROLLER.emailIdValidation(SCANNER.nextLine());
    }

    /**
     * Get date from user.
     */
    public static Date getDate() {
        System.out.println("Enter DoB(yyyy-mm-dd):");
        return STUDENTCONTROLLER.dateValidation(SCANNER.nextLine());
    }

    /**
     * Display the value of student.
     */
    public static void showValue(Student student) {
        System.out.println(student);
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {
        try {
            final int rollNo = StudentView.getRollNo();
            final String name = StudentView.getName();
            final int standard = StudentView.getStandard();
            final long phoneNo = StudentView.getPhoneNo();
            final String emailId = StudentView.getEmailId();
            final Date Date = StudentView.getDate();

            final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

            boolean isInserted = STUDENTCONTROLLER.addStudent(rollNo, student);

            if (isInserted) {
                System.out.println("Inserted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Display all Students and sends a request to the controller.
     */
    public static void showAllStudents() {
        Map<Integer, Student> ShowallStudents = STUDENTCONTROLLER.showAllStudents();
        System.out.println(ShowallStudents);
    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {
        try {
            boolean isRemoved = STUDENTCONTROLLER.removeStudent(StudentView.getRollNo());

            if (isRemoved) {
                System.out.println("Deleted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void getStudentDetail() {
        try {
            StudentView.showValue(STUDENTCONTROLLER.SearchStudentDetails(StudentView.getRollNo()));
        } catch (RecordNotfoundException e) {
            System.out.println(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudents() {
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

            boolean isUpdated = STUDENTCONTROLLER.updateStudentDetails(student.getRollNo(), student);

            if (isUpdated) {
                System.out.println("Updated SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }
}
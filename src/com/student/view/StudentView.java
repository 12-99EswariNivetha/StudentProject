package com.student.view;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentDetailsValidation;

/**
 * <h1>Student, View!</h1> The StudentView program implements an application
 * that simply displays "User input".
 */
public class StudentView {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method is to getRollNo from user
     * 
     * @return int It returns the value of rollno only if its valid otherwise it
     *         call StudentDetailsValidation.rollNoValidation method.
     */
    public static int getRollNo() {
        System.out.println("Enter the RollNo:");
        return StudentDetailsValidation.rollNoValidation(SCANNER.nextLine());
    }

    /**
     * This method is to getName from user
     * 
     * @return String It returns the value of name only if its valid otherwise it
     *         call StudentDetailsValidation.namevalidation method.
     */
    public static String getName() {
        System.out.println("Enter the Name:");
        return StudentDetailsValidation.nameValidation(SCANNER.nextLine());
    }

    /**
     * This method is to getstandard from user
     * 
     * @return int It returns the value of Standard only if its valid otherwise it
     *         call StudentDetailsValidation.standardValidation method.
     */
    public static int getStandard() {
        System.out.println("Enter the Standard:");
        return StudentDetailsValidation.standardValidation(SCANNER.nextLine());
    }

    /**
     * This method is to getPhoneNo from user
     * 
     * @return long It returns the value of phoneNo only if its valid otherwise it
     *         call StudentDetailsValidation.phoneNoValidation method.
     */
    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        return StudentDetailsValidation.phoneNoValidation(SCANNER.nextLine());
    }

    /**
     * This method is to getemailId from user
     * 
     * @return String It returns the value of emailId only if its valid otherwise it
     *         call StudentDetailsValidation.emailIdValidation method.
     */
    public static String getEmailId() {
        System.out.println("Enter the EmailId:");
        return StudentDetailsValidation.emailIdValidation(SCANNER.nextLine());
    }

    /**
     * This method is to getDate from user
     * 
     * @return String It returns the value of date only if its valid otherwise it
     *         call StudentDetailsValidation.dateValidation method.
     */
    public static String getDate() {
        System.out.println("Enter DoB(yyyy-mm-dd):");
        return StudentDetailsValidation.dateValidation(SCANNER.nextLine());
    }

    public static void showUpdateValue(Student student) {
        System.out.println(student);
    }

}
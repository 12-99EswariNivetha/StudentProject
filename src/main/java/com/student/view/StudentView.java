package com.student.view;


import java.sql.Date;
import java.util.Scanner;

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
     * Its getRollNo from user.
     */
    public static int getRollNo() {
        System.out.println("Enter the RollNo:");
        return STUDENTCONTROLLER.rollNoValidation(SCANNER.nextLine());
        
    }

    /**
     * Its getName from user.
     */
    public static String getName() {
        System.out.println("Enter the Name:");
        return STUDENTCONTROLLER.nameValidation(SCANNER.nextLine());
    }

    /**
     * Its getstandard from user
     */
    public static int getStandard() {
        System.out.println("Enter the Standard:");
        return STUDENTCONTROLLER.standardValidation(SCANNER.nextLine());
    }

    /**
     * Its getPhoneNo from user.
     */
    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        return STUDENTCONTROLLER.phoneNoValidation(SCANNER.nextLine());
    }

    /**
     * Its getemailId from user
     */
    public static String getEmailId() {
        System.out.println("Enter the EmailId:");
        return STUDENTCONTROLLER.emailIdValidation(SCANNER.nextLine());
    }

    /**
     * Its getDate from user.
     */
    public static Date getDate() {
        System.out.println("Enter DoB(yyyy-mm-dd):");
        return STUDENTCONTROLLER.dateValidation(SCANNER.nextLine());
    }

    public static void showValue(Student student) {
        System.out.println(student);
    }
}
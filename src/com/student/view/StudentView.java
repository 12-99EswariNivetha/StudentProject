package com.student.view;

import java.util.Map;
import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentDetailsValidation;

/**
 * <h1>Student, View!</h1> The StudentView program implements an application
 * that simply displays "User input".
 */
public class StudentView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getRollNo() {
        System.out.println("Enter the RollNo:");
        return StudentDetailsValidation.rollNoValidation(SCANNER.nextLine());
    }

    public static String getName() {
        System.out.println("Enter the Name:");
        return StudentDetailsValidation.nameValidation(SCANNER.nextLine());
    }

    public static int getStandard() {
        System.out.println("Enter the Standard:");
        return StudentDetailsValidation.standardValidation(SCANNER.nextLine());
    }

    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        return StudentDetailsValidation.phoneNoValidation(SCANNER.nextLine());
    }

    public static String getEmailId() {
        System.out.println("Enter the EmailId:");
        return StudentDetailsValidation.emailIdValidation(SCANNER.nextLine());
    }

    public static String getDate() {
        System.out.println("Enter DoB(yyyy-mm-dd):");
        return StudentDetailsValidation.dateValidation(SCANNER.nextLine());
    }

    public static void showUpdate(Student student) {
        System.out.println(student);
    }
    public static void showallStudents(Map<Integer, Student> student) {
        System.out.println(student);
    }

}

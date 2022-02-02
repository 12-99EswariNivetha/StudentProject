package com.student.main;

import java.sql.Date;
import java.util.Scanner;

import com.exception.RecordNotfoundException;
import com.student.controller.StudentController;
import com.student.model.Student;
import com.student.view.StudentView;

/**
 * <h1>StudentDetails!</h1>
 * 
 * @see java.util.scanner
 * @author EswariNivethaVU
 * @version 17.0.1
 * @since 1.2
 *
 */
public class StudentMain {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static StudentController studentController = new StudentController();

    /**
     * It makes use of crud operation like add, delete, update, get and remove
     * methods
     */
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.SEARCH\nEnter your choice:");
            choice = SCANNER.nextInt();
            switch (choice) {
            case 1:
                StudentMain.addStudent();
                break;
            case 2:
                StudentMain.showAllStudents();
                break;
            case 3:
                StudentMain.removeStudent();
                break;
            case 4:
                StudentMain.updateStudents();
                break;
            case 5:
                StudentMain.getStudentDetail();
                break;
            default:
                System.exit(0);
            }
        } while (choice != 0);
    }

    /**
     * Its addStudent by getting values from view and sending request to controller.
     */
    private static void addStudent() {
        int rollNo = StudentView.getRollNo();
        String name = StudentView.getName();
        int standard = StudentView.getStandard();
        long phoneNo = StudentView.getPhoneNo();
        String emailId = StudentView.getEmailId();
        Date Date = StudentView.getDate();

        Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        studentController.addStudent(rollNo, student);
    }

    /**
     * Its Display all Students and sending request to controller.
     */
    private static void showAllStudents() {
        studentController.showAllStudents();
    }

    /**
     * Its removeStudent by getting key from StudentView and sending request to
     * controller.
     */
    private static void removeStudent() {
        try {
            studentController.removeStudent(StudentView.getRollNo());
        } catch (RecordNotfoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Its getStudent by getting key from StudentView and sending request to
     * controller.
     */
    private static void getStudentDetail() {
        try {
            studentController.getStudentDetails(StudentView.getRollNo());
        } catch (RecordNotfoundException e) {
            System.out.println(e);
        }
    }

    /**
     * It updateStudents detail.
     */
    private static void updateStudents() {
        try {
            Student student = new Student();

            student.setRollNo(StudentView.getRollNo());
            System.out.println("Do you want to change your name?");

            if (SCANNER.next().equals("yes")) {
                student.setName(StudentView.getName());
            }
            System.out.println("Do you want to change your standard?");

            if (SCANNER.next().equals("yes")) {
                student.setStandard(StudentView.getStandard());
            }
            System.out.println("Do you want to change your phoneNo?");

            if (SCANNER.next().equals("yes")) {
                student.setPhonenumber(StudentView.getPhoneNo());
            }
            System.out.println("Do you want to change your emailid?");

            if (SCANNER.next().equals("yes")) {
                student.setEmailId(StudentView.getEmailId());
            }
            System.out.println("Do you want to change your dob?");

            if (SCANNER.next().equals("yes")) {
                student.setDate(StudentView.getDate());
            }

            studentController.updateStudentDetails(student.getRollNo(), student);
        } catch (RecordNotfoundException e) {
            System.out.println(e);
        }
    }

}

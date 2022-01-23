package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.Student;

public class StudentDetails {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static StudentController studentController = new StudentController();
    /**
     * This method is to addStudent by getting values from view and sending request
     * to controller
     * 
     * @return Nothing
     */
    public static void addStudent() {
        int rollNo = StudentView.getRollNo();
        String name=StudentView.getName();
        int standard=StudentView.getStandard();
        long phoneNo=StudentView.getPhoneNo();
        String emailId=StudentView.getEmailId();
        String Date=StudentView.getDate();
        Student student = new Student(rollNo, name, standard, phoneNo,
                emailId,Date);

        studentController.addStudent(rollNo, student);
    }

    /**
     * This method is to Display all Students from StudentView and sending request
     * to controller
     * 
     * @return Nothing
     */
    public static void showAllStudents() {
        studentController.showAllStudents();
    }

    /**
     * This method is to removeStudent by getting key from StudentView and sending
     * request to controller
     * 
     * @return Nothing
     */
    public static void removeStudent() {
        studentController.removeStudent(StudentView.getRollNo());
    }

    /**
     * This method is to getStudent by getting key from StudentView and sending
     * request to controller
     * 
     * @return Nothing
     */
    public static void getStudentDetail() {
        studentController.getStudentDetails(StudentView.getRollNo());
    }

    /**
     * This method is to updateStudent by getting key from StudentView and sending
     * request to controller
     * 
     * @return Nothing
     */
    public static void updateStudent() {
        System.out.println("1.Student Name\n2.Standard\n3.PhoneNumber\n4.EmailId\n5.DoB\n");
        int choice = SCANNER.nextInt();
        switch (choice) {
        case 1:
            updateStudentName(StudentView.getRollNo(), StudentView.getName());
            break;
        case 2:
            updateStudentStand(StudentView.getRollNo(), StudentView.getStandard());
            break;
        case 3:
            updateStudentPhoneNumber(StudentView.getRollNo(), StudentView.getPhoneNo());
            break;
        case 4:
            updateStudentEmailId(StudentView.getRollNo(), StudentView.getEmailId());
        case 5:
            updateStudentDoB(StudentView.getRollNo(), StudentView.getDate());
        }
    }

    private static void updateStudentName(int rollNo, String name) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setName(name);
        studentController.updateStudentDetails(rollNo, student);
    }

    private static void updateStudentStand(int rollNo, int stand) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setStandard(stand);
        studentController.updateStudentDetails(rollNo, student);
    }

    private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setPhonenumber(phoneNumber);
        studentController.updateStudentDetails(rollNo, student);
    }

    private static void updateStudentDoB(int rollNo, String dob) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setDate(dob);
        studentController.updateStudentDetails(rollNo, student);
    }

    private static void updateStudentEmailId(int rollNo, String emailId) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setEmailId(emailId);
        studentController.updateStudentDetails(rollNo, student);
    }


}

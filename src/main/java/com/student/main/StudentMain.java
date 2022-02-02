package com.student.main;

import java.sql.Date;
import java.sql.SQLException;
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
     * 
     * @throws RecordNotfoundException
     */
    public static void main(String[] args) throws RecordNotfoundException {
        int choice;

        do {
            System.out.println("1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.Search\nEnter your choice:");
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
                StudentMain.updateStudent();
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
     * 
     * @throws RecordNotfoundException
     */
    private static void removeStudent() throws RecordNotfoundException {
        studentController.removeStudent(StudentView.getRollNo());
    }

    /**
     * Its getStudent by getting key from StudentView and sending request to
     * controller.
     * 
     * @throws SQLException
     */
    private static void getStudentDetail() {
        studentController.getStudentDetails(StudentView.getRollNo());
    }

    /**
     * Its updateStudent by getting key from StudentView and user can update the
     * particular value by using switchcase.
     */
    private static void updateStudent() {
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
            break;
        case 5:
            updateStudentDoB(StudentView.getRollNo(), StudentView.getDate());
            break;
        }
    }

    /**
     * Its updateStudentName by using rollNo and sending request to controller.
     */
    private static void updateStudentName(int rollNo, String name) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setName(name);
        studentController.updateStudentDetails(rollNo, student);
    }

    /**
     * Its updateStudentStand by using rollNo and sending request to controller.
     */
    private static void updateStudentStand(int rollNo, int stand) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setStandard(stand);
        studentController.updateStudentDetails(rollNo, student);
    }

    /**
     * Its updateStudentPhoneNo by using rollNo and sending request to controller.
     */
    private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setPhonenumber(phoneNumber);
        studentController.updateStudentDetails(rollNo, student);
    }

    /**
     * Its updateStudentDob by using rollNo and sending request to controller.
     */
    private static void updateStudentDoB(int rollNo, Date dob) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setDate(dob);
        studentController.updateStudentDetails(rollNo, student);
    }

    /**
     * Its updateStudentEmailId by using rollNo and sending request to controller.
     */
    private static void updateStudentEmailId(int rollNo, String emailId) {
        Student student = new Student();
        student.setRollNo(rollNo);
        student.setEmailId(emailId);
        studentController.updateStudentDetails(rollNo, student);
    }
}

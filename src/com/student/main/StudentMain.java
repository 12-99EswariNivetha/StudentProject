package com.student.main;

import java.util.Scanner;

import com.student.view.StudentDetails;

/**
 * <h1>StudentDetails!</h1>
 * <p>
 * 
 * @see java.util.scanner
 * @author EswariNivethaVU
 * @version 17.0.1
 * @since 1.2
 *
 */
public class StudentMain {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This is the main method which makes use of addStudent,showAllStudents,
     * removeStudentmethod,updateStudent Method
     * 
     * @param args Unused.
     * 
     * @return Nothing.
     */
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.Search\nEnter your choice:");
            choice = SCANNER.nextInt();
            switch (choice) {
            case 1:
                StudentDetails.addStudent();
                break;
            case 2:
                StudentDetails.showAllStudents();
                break;
            case 3:
                StudentDetails.removeStudent();
                break;
            case 4:
                StudentDetails.updateStudent();
                break;
            case 5:
                StudentDetails.getStudentDetail();
                break;
            default:
                System.exit(0);
            }
        } while (choice != 0);
    }
}

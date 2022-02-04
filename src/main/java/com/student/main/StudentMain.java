package com.student.main;

import java.util.Scanner;
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

    /**
     * Makes use of crud operations like add, delete, update, get and remove methods
     */
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.SEARCH\nEnter your choice:");
            choice = SCANNER.nextInt();

            switch (choice) {
            case 1:
                StudentView.addStudent();
                break;
            case 2:
                StudentView.showAllStudents();
                break;
            case 3:
                StudentView.removeStudent();
                break;
            case 4:
                StudentView.updateStudents();
                break;
            case 5:
                StudentView.getStudentDetail();
                break;
            default:
                SCANNER.close();
                System.exit(0);
            }
        } while (choice != 0);
    }
}

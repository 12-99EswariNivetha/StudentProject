package com.student.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.apache.log4j.PropertyConfigurator;
import com.student.service.Validation;
import com.student.view.StudentView;

/**
 * StudentDetails!
 * 
 * @author EswariNivethaVU
 * @version 17.0.1
 * @since 1.2
 *
 */
public class StudentMain {

    private static final Properties PROPERTIES = new Properties();
    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Makes use of crud operations like add, delete, update, get and remove methods
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PROPERTIES.load(new FileInputStream("log.properties"));
        PropertyConfigurator.configure(PROPERTIES);

        do {
            System.out.println("1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.SEARCH\nEnter your choice:");
            final int choice = Validation.validateChoice(SCANNER.next());

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
                StudentView.updateStudent();
                break;
            case 5:
                StudentView.selectStudent();
                break;
            default:
                SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }
}

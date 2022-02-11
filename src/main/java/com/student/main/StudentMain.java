package com.student.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Makes use of crud operations like add, delete, update, get and remove methods
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream("log.properties"));
        PropertyConfigurator.configure(properties);
        StudentMain.selectChoice();
    }
        
        public static void selectChoice(){

        do {
            final Logger logger = Logger.getLogger(StudentView.class);
            logger.info("STUDENT MANAGEMENT \n1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.SEARCH\n6.Exit\nEnter your choice:");
            final int choice = Integer.parseInt(StudentView.getChoice());

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
            case 6:
                SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }
}

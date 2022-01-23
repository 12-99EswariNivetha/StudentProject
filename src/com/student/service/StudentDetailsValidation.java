package com.student.service;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.student.view.StudentView;

/**
 * <h1>Student, Validation</h1> The StudentDetailsValidation implement program
 * to validate the user details
 */
public class StudentDetailsValidation {
    /**
     * This method is to validate the PhoneNumber if it is valid it is return to
     * studentview.It accept only 10 digitNumber.If any other characters or morethan
     * 10 Number given it call the method again
     * 
     * @param phoneNo one parameter is passed to get the phonenumber validation.
     * 
     * @return long It returns the value of parsed phonenumber.
     */
    public static long phoneNoValidation(String phoneNo) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher match = pattern.matcher(phoneNo);

        if (match.find() && match.group().equals(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid PhoneNo :");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * This method is to validate the Name if it is valid it is return to
     * studentview.It accept only Alphabets.If Integer or any special charachter
     * given it call the method again.
     * 
     * @param name one parameter is passed to get the name validation.
     * 
     * @return string It returns the value of parsed name.
     */
    public static String nameValidation(String name) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]*$");
        Matcher match = pattern.matcher(name);

        if (match.find() && match.group().equals(name)) {
            return name;
        } else {
            System.out.println("Not Valid \n Re-enter a valid Name :");
            return StudentView.getName();
        }
    }

    /**
     * This method is to validate the rollNo if it is valid it is return to
     * studentview.It accept only 3 digitNumber. If any other characters or morethan
     * 3 number given it call the method again
     * 
     * @param rollNo one parameter is passed to get the rollNo validation.
     * 
     * @return int It returns the value of parsed rollNo.
     */
    public static int rollNoValidation(String rollNo) {
        Pattern pattern = Pattern.compile("[0-9]{3}");
        Matcher match = pattern.matcher(rollNo);

        if (match.find() && match.group().equals(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            System.out.println("Not Valid \n Re-enter a valid RollNo :");
            return StudentView.getRollNo();
        }
    }

    /**
     * This method is to validate the standard if it is valid it is return to
     * studentview.It accept only integer. If any other characters or special
     * character given it call the method again
     * 
     * @param standard one parameter is passed to get the standard validation.
     * 
     * @return int It returns the value of parsed standard.
     */
    public static int standardValidation(String stand) {
        Pattern pattern = Pattern.compile("[0-12]{1,}");
        Matcher match = pattern.matcher(stand);

        if (match.find() && match.group().equals(stand)) {
            return Integer.parseInt(stand);
        } else {
            System.out.println("Not Valid \n Re-enter a valid Standard :");
            return StudentView.getStandard();
        }
    }

    /**
     * This method is to validate the emailId if it is valid by given pattern it is
     * return to studentview or it will call the method again.
     * 
     * @param emailId one parameter is passed to get the emailId validation.
     * 
     * @return String It returns the value of parsed emailId.
     */
    public static String emailIdValidation(String emailId) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher match = pattern.matcher(emailId);

        if (match.find() && match.group().equals(emailId)) {
            return emailId;
        } else {
            System.out.println("Not Valid \n Re-enter a valid MailId :");
            return StudentView.getEmailId();
        }
    }

    /**
     * This method is to validate the date if it is valid by given pattern it is
     * return to studentview or it will call the method again.
     * 
     * @param date one parameter is passed to get the date validation.
     * 
     * @return date It returns the value of parsed date.
     */
    public static String dateValidation(String date) {

        try {
            LocalDate dt = LocalDate.parse(date);
            LocalDate todayDate = LocalDate.now();

            if (todayDate.isAfter(dt)) {
                return date;
            }

        } catch (Exception e) {
            System.out.println("Not Valid \n Re-enter a valid Date :");
            return StudentView.getDate();
        }
        return date;
    }
}
package com.student.view;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.student.exception.CustomException.InValidDateException;

public class Validation {

    /**
     * Validates the PhoneNumber.
     */
    public boolean phoneNoValidation(final String phoneNo) {
        Pattern phonenoPattern = Pattern.compile("[6-9]{1}[0-9]{9}");
        Matcher phonenomatcher = phonenoPattern.matcher(phoneNo);

        if (phonenomatcher.find() && phonenomatcher.group().equals(phoneNo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates the Name.
     */
    public boolean nameValidation(final String name) {
        Pattern namepattern = Pattern.compile("[a-zA-Z\\s]*$");
        Matcher namematcher = namepattern.matcher(name);

        if (namematcher.find() && namematcher.group().equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates the RollNo.
     */
    public boolean rollNoValidation(final String rollNo) {
        Pattern rollNopattern = Pattern.compile("[0-9]{3}");
        Matcher rollNomatcher = rollNopattern.matcher(rollNo);

        if (rollNomatcher.find() && rollNomatcher.group().equals(rollNo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates the Standard.
     */
    public boolean standardValidation(final String stand) {

        if ((stand.matches("^([1-9]|1[012])$")) || ("PREKG".equalsIgnoreCase(stand)) || ("LKG".equalsIgnoreCase(stand))
                || ("UKG".equalsIgnoreCase(stand))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates the EmailId.
     */
    public boolean emailIdValidation(final String emailId) {
        Pattern emailidpattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]{2,3}+$");
        Matcher emailidmatcher = emailidpattern.matcher(emailId);

        if (emailidmatcher.find() && emailidmatcher.group().equals(emailId)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates the Date.
     */
    public boolean dateValidation(final String date) {

        try {
            LocalDate localdate = LocalDate.parse(date);
            LocalDate currentLocalDate = LocalDate.now();

            if (currentLocalDate.plusDays(1).isAfter(localdate)) {
                return true;
            }
        } catch (Exception e) {
            throw new InValidDateException("Invalid Date");
        }
        return false;
    }

    /**
     * Validates the Choice.
     */
    public boolean validateChoice(final String choice) {

        if (!choice.matches("[1-6]")) {
            return false;
        } else {
            return true;
        }
    }
}

// File: Student.java
// Student class with get and set methods
package com.student.model;

/**
 * This is a model class to hold Student information
 *
 * @see java.lang.Object
 * @author EswariNivethaVU
 */
public class Student {
    private int rollNo;
    private String name;
    private int standard;
    private long phonenumber;
    private String emailId;
    private String date;

    /**
     * No-argument constructor initializes instance variables to null
     */
    public Student() {
        super();
    }

    /**
     * Creates a Student with the specified name.
     * 
     * @param rollNo      The Student's rollNo.
     * @param name        The Student’s first name.
     * @param standard    The Student’s first standard.
     * @param phonenumber The Student’s first phonenumber.
     * @param emailId     The Student’s first emailId.
     * @param date        The Student’s first date.
     */
    public Student(int rollNo, String name, int standard, long phonenumber, String emailId, String date) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.phonenumber = phonenumber;
        this.emailId = emailId;
        this.date = date;
    }

    /**
     * Gets the Student's rollNo.
     * 
     * @return rollNo int representing the Student's rollNo.
     */
    public int getRollNo() {
        return rollNo;
    }

    /**
     * Sets the Student's rollNo.
     * 
     * @param rollNo int containing the Student's rollNo.
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Gets the Student's name.
     * 
     * @return name string representing the Student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Student's name.
     * 
     * @param name string containing the Student's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Student's Standard.
     * 
     * @return Standard int representing the Student's standard
     */
    public int getStandard() {
        return standard;
    }

    /**
     * Sets the Student's standard.
     * 
     * @param standard int containing the Student's standard.
     */
    public void setStandard(int standard) {
        this.standard = standard;
    }

    /**
     * Gets the Student's PhoneNumber.
     * 
     * @return PhoneNumber long representing the Student's phonenumber
     */
    public long getPhonenumber() {
        return phonenumber;
    }

    /**
     * Sets the Student's PhoneNumber.
     * 
     * @param PhoneNumber long containing the Student's PhoneNumber.
     */
    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Gets the Student's EmailId.
     * 
     * @return EmailId String representing the Student's emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the Student's emailId.
     * 
     * @param emailId string containing the Student's emailId.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the Student's date.
     * 
     * @return date String representing the Student's date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the Student's date.
     * 
     * @param date string containing the Student's date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Convert to standard string format
     * 
     * @return a <code> string </code> representing Student in standard format
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rollNo).append(" ").append(name).append(" ").append(standard).append(" ").append(phonenumber)
                .append(" ").append(emailId).append(" ").append(date);
        return builder.toString();
    }
}

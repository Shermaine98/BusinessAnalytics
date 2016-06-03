/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Geraldine Atayan
 */
public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdate;
    private Date employment;
    private String division;
    private String reason;
    private Date accessDate;
    private String email;
    private String username;
    private String password;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the employment
     */
    public Date getEmployment() {
        return employment;
    }

    /**
     * @param employment the employment to set
     */
    public void setEmployment(Date employment) {
        this.employment = employment;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the accessDate
     */
    public Date getAccessDate() {
        return accessDate;
    }

    /**
     * @param accessDate the accessDate to set
     */
    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public java.sql.Date javaToSQLdate(String date) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthdate = formatter.parse(date);
        java.sql.Date sqlbirthdate = new java.sql.Date(birthdate.getTime());
        return sqlbirthdate;
    }
    
}

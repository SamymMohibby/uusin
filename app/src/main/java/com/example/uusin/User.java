package com.example.uusin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class User implements Serializable { 
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private String degrees;

    public String getName() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public User(String name, String lastname, String email, String major, String degrees) {
        this.firstname = name;
        this.lastname = lastname;
        this.email = email;
        this.major = major;
        this.degrees = degrees; // Tähän on nyt annettu ArrayList<String>
    }


    public String getDegrees() {
        return degrees; // Palauttaa nyt ArrayList<String>, kuten pitääkin
    }}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Student {
    
    private int id; 
    private String name;
    private String email;
    private String contactNo;
    private String subject;
    private String gender;

    public Student() {
    }

    public Student(int id, String name, String email, String contactNo, String subject, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.subject = subject;
        this.gender = gender;
    }

    public Student(String name, String email, String contactNo, String subject, String gender) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.subject = subject;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    
    
    
}

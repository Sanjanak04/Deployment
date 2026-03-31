package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="roll_number")
    private String rollNumber;

    @Column(name="name")
    private String name;

    @Column(name="branch")
    private String branch;

    @Column(name="student_year") // ✅ FIXED
    private int Studentyear;

    public Student(){}

    public Long getId() {
        return id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return Studentyear;
    }

    public void setYear(int year) {
        this.Studentyear = year;
    }
}
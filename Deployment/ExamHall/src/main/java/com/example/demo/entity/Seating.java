package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seating")
public class Seating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seatNumber;

    // ✅ Row & Column (already correct)
    @Column(name = "row_no")
    private int row;

    @Column(name = "col_no")
    private int col;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // ✅ Constructor
    public Seating() {}

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
package com.example.demo.dto;

public class SeatingDTO {

    private String studentName;
    private String rollNumber;
    private String branch;
    private String hallName;
    private int row;
    private int col;
    private int seatNumber;

    public SeatingDTO(){}

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getHallName() { return hallName; }
    public void setHallName(String hallName) { this.hallName = hallName; }

    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }

    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
}
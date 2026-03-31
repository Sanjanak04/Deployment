package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "row_count")
    private int rows;

    @Column(name = "column_count")
    private int columns;

    @Column(name = "capacity")
    private int capacity;

    public Hall() {
    }

    public Long getId() {
        return id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
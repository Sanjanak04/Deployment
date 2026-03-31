package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SeatingDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class SeatingService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private SeatingRepository seatingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // ✅ ALLOCATE SEATS
    @Transactional
    public void allocateSeats() {

        // 1. Delete old seating
        seatingRepository.deleteAll();

        // 2. Reset AUTO INCREMENT
        entityManager.createNativeQuery("ALTER TABLE seating AUTO_INCREMENT = 1")
                     .executeUpdate();

        // 3. Fetch data
        List<Student> students = studentRepository.findAll();
        List<Hall> halls = hallRepository.findAll();

        if (students.isEmpty() || halls.isEmpty()) {
            throw new RuntimeException("Students or Halls data missing");
        }

        int studentIndex = 0;

        // 4. Allocate seats
        for (Hall hall : halls) {

            int rows = hall.getRows();
            int cols = hall.getColumns();

            for (int r = 1; r <= rows; r++) {
                for (int c = 1; c <= cols; c++) {

                    if (studentIndex >= students.size()) break;

                    Student student = students.get(studentIndex);

                    Seating seating = new Seating();
                    seating.setStudent(student);
                    seating.setHall(hall);
                    seating.setRow(r);
                    seating.setCol(c);
                    seating.setSeatNumber((r - 1) * cols + c);

                    seatingRepository.save(seating);

                    studentIndex++;
                }
            }
        }
    }

    // ✅ GET ALL SEATING (REPORT)
    public List<SeatingDTO> getSeatingReport() {

        List<Seating> list = seatingRepository.findAll();

        return list.stream().map(seat -> {
            SeatingDTO dto = new SeatingDTO();

            dto.setStudentName(seat.getStudent().getName());
            dto.setRollNumber(seat.getStudent().getRollNumber());
            dto.setBranch(seat.getStudent().getBranch()); 
            dto.setHallName(seat.getHall().getHallName());
            dto.setRow(seat.getRow());
            dto.setCol(seat.getCol());

            return dto;
        }).toList();
    }

    // ✅ GET BY ROLL NUMBER
    public SeatingDTO getSeatByRollNumber(String rollNumber) {

        Seating seat = seatingRepository.findAll()
                .stream()
                .filter(s -> s.getStudent().getRollNumber().equalsIgnoreCase(rollNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));

        SeatingDTO dto = new SeatingDTO();

        dto.setStudentName(seat.getStudent().getName());
        dto.setRollNumber(seat.getStudent().getRollNumber());
        dto.setBranch(seat.getStudent().getBranch());
        dto.setHallName(seat.getHall().getHallName());
        dto.setRow(seat.getRow());
        dto.setCol(seat.getCol());

        return dto;
    }
}
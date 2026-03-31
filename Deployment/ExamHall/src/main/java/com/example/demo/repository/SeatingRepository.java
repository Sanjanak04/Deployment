package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Seating;

public interface SeatingRepository extends JpaRepository<Seating, Long> {

    List<Seating> findByHallId(Long hallId);

    Optional<Seating> findByStudent_RollNumber(String rollNumber);
}
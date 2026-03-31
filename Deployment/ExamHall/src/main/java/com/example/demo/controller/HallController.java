package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Hall;
import com.example.demo.repository.HallRepository;

@RestController
@RequestMapping("/halls")
@CrossOrigin
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    // Add hall
    @PostMapping
    public Hall addHall(@RequestBody Hall hall){
        return hallRepository.save(hall);
    }
   
    // Get halls
    @GetMapping
    public List<Hall> getHalls(){
        return hallRepository.findAll();
    }
}
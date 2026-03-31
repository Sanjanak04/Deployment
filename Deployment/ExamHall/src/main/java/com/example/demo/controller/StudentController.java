package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ExcelService;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExcelService excelService;

    // Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    
    // Delete student by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    @PostMapping("/upload")
    public String uploadStudents(@RequestParam("file") MultipartFile file){
        try{
            excelService.saveStudentsFromExcel(file.getInputStream());
            return "Excel uploaded successfully";
        }catch(Exception e){
            return "Upload failed";
        }
    
    }
}
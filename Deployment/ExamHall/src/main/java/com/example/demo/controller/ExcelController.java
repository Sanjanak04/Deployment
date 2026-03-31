package com.example.demo.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ExcelService;

@RestController
@RequestMapping("/excel")
@CrossOrigin
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            excelService.saveStudentsFromExcel(is);
            return "File uploaded successfully";
        } catch (Exception e) {
            return "Upload failed: " + e.getMessage();
        }
    }
}
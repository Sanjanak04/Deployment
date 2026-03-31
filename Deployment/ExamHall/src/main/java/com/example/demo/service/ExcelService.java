package com.example.demo.service;

import java.io.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SeatingDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class ExcelService {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ 1️⃣ UPLOAD EXCEL (READ FILE)
    public void saveStudentsFromExcel(InputStream inputStream) throws Exception {

        Workbook workbook = new XSSFWorkbook(inputStream); // ✅ FIXED
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {

            if (row.getRowNum() == 0) continue; // skip header
            if (row.getCell(0) == null) continue;

            Student student = new Student();

            student.setRollNumber(row.getCell(0).toString().trim());
            student.setName(row.getCell(1).toString().trim());
            student.setBranch(row.getCell(2).toString().trim());

            String yearStr = row.getCell(3).toString().trim();
            student.setYear((int) Double.parseDouble(yearStr));

            studentRepository.save(student);
        }

        workbook.close();
    }

    // ✅ 2️⃣ EXPORT EXCEL (DOWNLOAD FILE)
    public ByteArrayInputStream exportToExcel(List<SeatingDTO> list) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Seating");

        int rowNum = 0;

        // Header
        Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Roll");
        header.createCell(2).setCellValue("Branch");
        header.createCell(3).setCellValue("Hall");
        header.createCell(4).setCellValue("Row");
        header.createCell(5).setCellValue("Col");

        // Data
        for (SeatingDTO dto : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(dto.getStudentName());
            row.createCell(1).setCellValue(dto.getRollNumber());
            row.createCell(2).setCellValue(dto.getBranch());
            row.createCell(3).setCellValue(dto.getHallName());
            row.createCell(4).setCellValue(dto.getRow());
            row.createCell(5).setCellValue(dto.getCol());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}    
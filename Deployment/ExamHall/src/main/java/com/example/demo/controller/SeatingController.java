package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.SeatingDTO;
import com.example.demo.service.*;

@RestController
@RequestMapping("/seating")
@CrossOrigin
public class SeatingController {

    @Autowired
    private SeatingService seatingService;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private ExcelService excelService;

    // ✅ Allocate seats
    @PostMapping("/allocate")
    public ResponseEntity<String> allocateSeats() {
        try {
            seatingService.allocateSeats();
            return ResponseEntity.ok("Seats allocated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // ✅ Get all seating
    @GetMapping
    public List<SeatingDTO> getAllSeating() {
        return seatingService.getSeatingReport();
    }
    

    // ✅ Report
    @GetMapping("/report")
    public List<SeatingDTO> getReport() {
        return seatingService.getSeatingReport();
    }

    // ✅ Get by roll number
    @GetMapping("/students/{rollNumber}")
    public ResponseEntity<?> getSeatByRoll(@PathVariable String rollNumber) {
        try {
            SeatingDTO dto = seatingService.getSeatByRollNumber(rollNumber);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No seat found for roll: " + rollNumber);
        }
    }

    // ✅ PDF
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> downloadPdf() {
        byte[] pdf = pdfService.generatePdf(seatingService.getSeatingReport());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=seating.pdf")
                .body(pdf);
    }

    // ✅ Excel
    @GetMapping("/excel")
    public ResponseEntity<byte[]> downloadExcel() throws Exception {
        ByteArrayInputStream in =
                excelService.exportToExcel(seatingService.getSeatingReport());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE,
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=seating.xlsx")
                .body(in.readAllBytes());
    }
}
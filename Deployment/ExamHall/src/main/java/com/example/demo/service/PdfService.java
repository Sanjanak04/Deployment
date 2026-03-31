package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.SeatingDTO;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

@Service
public class PdfService {

    public byte[] generatePdf(List<SeatingDTO> list) {

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Exam Seating Report"));

            Table table = new Table(6);

            table.addCell("Name");
            table.addCell("Roll");
            table.addCell("Branch");
            table.addCell("Hall");
            table.addCell("Row");
            table.addCell("Col");

            for (SeatingDTO dto : list) {
                table.addCell(dto.getStudentName());
                table.addCell(dto.getRollNumber());
                table.addCell(dto.getBranch());
                table.addCell(dto.getHallName());
                table.addCell(String.valueOf(dto.getRow()));
                table.addCell(String.valueOf(dto.getCol()));
            }

            document.add(table);
            document.close();

            return out.toByteArray(); // ✅ IMPORTANT

        } catch (Exception e) {
            e.printStackTrace();
            return null; // fallback
        }
    }
}
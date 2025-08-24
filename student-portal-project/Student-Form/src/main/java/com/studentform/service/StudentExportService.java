package com.studentform.service;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import com.studentform.model.Student;
import com.studentform.repository.StudentRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Service
public class StudentExportService {

    @Autowired
    private StudentRepository studentRepository;

    // Export all students to Excel
    public byte[] exportAllToExcel(List<Student> students) throws Exception {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Students");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");
            header.createCell(3).setCellValue("Phone");
            header.createCell(4).setCellValue("First Choice");
            header.createCell(5).setCellValue("Second Choice");
            header.createCell(6).setCellValue("Third Choice");
            header.createCell(7).setCellValue("Fourth Choice");

            int rowIdx = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getName());
                row.createCell(2).setCellValue(student.getEmail());
                row.createCell(3).setCellValue(student.getPhone());

                Map<String, String> choices = student.getCourseChoices();
                row.createCell(4).setCellValue(choices != null ? choices.getOrDefault("first", "") : "");
                row.createCell(5).setCellValue(choices != null ? choices.getOrDefault("second", "") : "");
                row.createCell(6).setCellValue(choices != null ? choices.getOrDefault("third", "") : "");
                row.createCell(7).setCellValue(choices != null ? choices.getOrDefault("fourth", "") : "");
            }

            workbook.write(out);
            return out.toByteArray();
        }
    }

    // Export single student to Excel
    public byte[] exportToExcel(Student student) throws Exception {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Student");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");
            header.createCell(3).setCellValue("Phone");
            header.createCell(4).setCellValue("First Choice");
            header.createCell(5).setCellValue("Second Choice");
            header.createCell(6).setCellValue("Third Choice");
            header.createCell(7).setCellValue("Fourth Choice");

            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getEmail());
            row.createCell(3).setCellValue(student.getPhone());

            Map<String, String> choices = student.getCourseChoices();
            row.createCell(4).setCellValue(choices != null ? choices.getOrDefault("first", "") : "");
            row.createCell(5).setCellValue(choices != null ? choices.getOrDefault("second", "") : "");
            row.createCell(6).setCellValue(choices != null ? choices.getOrDefault("third", "") : "");
            row.createCell(7).setCellValue(choices != null ? choices.getOrDefault("fourth", "") : "");

            workbook.write(out);
            return out.toByteArray();
        }
    }

    // Export all students to PDF
    public byte[] exportAllToPdf(List<Student> students) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA);

        Paragraph title = new Paragraph("All Students Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);

        // Table with 7 columns (ID, Name, Email, Phone, First Choice, Second Choice, Third Choice, Fourth Choice)
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);

        // Add headers
        table.addCell(new PdfPCell(new Phrase("ID", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Name", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Email", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Phone", headerFont)));
        table.addCell(new PdfPCell(new Phrase("First Choice", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Second Choice", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Third Choice", headerFont)));
        table.addCell(new PdfPCell(new Phrase("Fourth Choice", headerFont)));

        // Add data rows
        for (Student student : students) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(student.getId()), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(student.getName(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(student.getEmail(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(student.getPhone(), bodyFont)));

            Map<String, String> choices = student.getCourseChoices();
            table.addCell(new PdfPCell(new Phrase(choices != null ? choices.getOrDefault("first", "") : "", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(choices != null ? choices.getOrDefault("second", "") : "", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(choices != null ? choices.getOrDefault("third", "") : "", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(choices != null ? choices.getOrDefault("fourth", "") : "", bodyFont)));
        }

        document.add(table);
        document.close();

        return out.toByteArray();
    }

    // Export single student to PDF
    public byte[] exportToPdf(Student student) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

        Paragraph title = new Paragraph("Student Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        table.addCell(new PdfPCell(new Phrase("ID", labelFont)));
        table.addCell(new PdfPCell(new Phrase(String.valueOf(student.getId()), valueFont)));

        table.addCell(new PdfPCell(new Phrase("Name", labelFont)));
        table.addCell(new PdfPCell(new Phrase(student.getName(), valueFont)));

        table.addCell(new PdfPCell(new Phrase("Email", labelFont)));
        table.addCell(new PdfPCell(new Phrase(student.getEmail(), valueFont)));

        table.addCell(new PdfPCell(new Phrase("Phone", labelFont)));
        table.addCell(new PdfPCell(new Phrase(student.getPhone(), valueFont)));

        Map<String, String> choices = student.getCourseChoices();
        if (choices != null) {
            table.addCell(new PdfPCell(new Phrase("First Choice", labelFont)));
            table.addCell(new PdfPCell(new Phrase(choices.getOrDefault("first", ""), valueFont)));

            table.addCell(new PdfPCell(new Phrase("Second Choice", labelFont)));
            table.addCell(new PdfPCell(new Phrase(choices.getOrDefault("second", ""), valueFont)));

            table.addCell(new PdfPCell(new Phrase("Third Choice", labelFont)));
            table.addCell(new PdfPCell(new Phrase(choices.getOrDefault("third", ""), valueFont)));

            table.addCell(new PdfPCell(new Phrase("Fourth Choice", labelFont)));
            table.addCell(new PdfPCell(new Phrase(choices.getOrDefault("fourth", ""), valueFont)));
        }

        document.add(table);
        document.close();

        return out.toByteArray();
    }
}

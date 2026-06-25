package com.cib.report.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class PdfGenerator {

    public String generatePdf(
            String accountNumber) {

        String fileName =
                "statement-" +
                        accountNumber +
                        ".pdf";

        try {

            PDDocument document =
                    new PDDocument();

            PDPage page =
                    new PDPage();

            document.addPage(page);

            PDPageContentStream content =
                    new PDPageContentStream(
                            document,
                            page);

            content.beginText();

            content.setFont(
                    new PDType1Font(
                            Standard14Fonts.FontName.HELVETICA_BOLD),
                    14);

            content.newLineAtOffset(
                    100,
                    700);

            content.showText(
                    "CIB BANK ACCOUNT STATEMENT");

            content.endText();

            content.close();

            document.save(fileName);

            document.close();

            return fileName;

        } catch (Exception ex) {

            throw new RuntimeException(
                    ex.getMessage());
        }
    }
}
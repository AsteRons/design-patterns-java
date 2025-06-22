package com.documentfactory.model;

import com.documentfactory.model.Document;

public class PdfDocument extends Document {


    public PdfDocument(String title, String author) {
        super(title, author);
    }

    @Override
    public void validate() {
        if (content == null || content.length() < 5) {
            throw new IllegalStateException("PdfDocument content too short");
        }
        System.out.println("PdfDocument validated");
    }

    @Override
    public void generateSummary() {
        System.out.println("PdfDocument Summary: " + content.toUpperCase());
    }
}

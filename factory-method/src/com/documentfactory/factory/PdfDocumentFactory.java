package com.documentfactory.factory;

import com.documentfactory.model.Document;
import com.documentfactory.model.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {

    public PdfDocumentFactory(String title, String author, String content) {
        super(title, author, content);
    }

    @Override
    public Document createDocument() {
        PdfDocument doc = new PdfDocument(title, author);
        doc.setContent(content);
        return doc;
    }
}

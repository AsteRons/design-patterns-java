package com.documentfactory;

import com.documentfactory.factory.DocumentFactory;
import com.documentfactory.factory.PdfDocumentFactory;
import com.documentfactory.factory.WordDocumentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    public void importWordFormat(){
        DocumentFactory wordFactory = new WordDocumentFactory("My Word Doc", "Alice", "This is the content of the Word document.");
        wordFactory.processDocument();
    }

    @Test
    public void importPdfFormat(){

        DocumentFactory pdfFactory = new PdfDocumentFactory("Detailed PDF Doc", "Carol", "This PDF document has a sufficiently long content.");
        pdfFactory.processDocument();
    }

    @Test
    public void importPdfFormatTooShort(){

        DocumentFactory pdfFactory = new PdfDocumentFactory("My PDF Doc", "Bob", "Short.");

        Exception exception = assertThrows(IllegalStateException.class, pdfFactory::processDocument);

        assertEquals("PdfDocument content too short", exception.getMessage());
    }
}
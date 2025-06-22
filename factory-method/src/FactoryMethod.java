

import com.documentfactory.factory.DocumentFactory;
import com.documentfactory.factory.PdfDocumentFactory;
import com.documentfactory.factory.WordDocumentFactory;

public class FactoryMethod {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory("My Word Doc", "Alice", "This is the content of the Word document.");
        wordFactory.processDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory("My PDF Doc", "Bob", "Short.");
        try {
            pdfFactory.processDocument();
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }

        DocumentFactory pdfFactory2 = new PdfDocumentFactory("Detailed PDF Doc", "Carol", "This PDF document has a sufficiently long content.");
        pdfFactory2.processDocument();

    }
}
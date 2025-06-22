package com.documentfactory.factory;

import com.documentfactory.model.Document;

public abstract class DocumentFactory {

    protected String title;
    protected String author;
    protected String content;

    public DocumentFactory(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public abstract Document createDocument();

    public void processDocument() {
        Document doc = createDocument();
        doc.validate();
        doc.generateSummary();
        System.out.println("Document created: " + doc);
    }


}

package com.documentfactory.factory;

import com.documentfactory.model.Document;
import com.documentfactory.model.WordDocument;

public class WordDocumentFactory extends DocumentFactory{

    public WordDocumentFactory(String title, String author, String content) {
        super(title, author, content);
    }

    @Override
    public Document createDocument() {
        WordDocument doc = new WordDocument(title, author);
        doc.setContent(content);
        return doc;
    }

}

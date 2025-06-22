package com.documentfactory.model;

import com.documentfactory.model.Document;

public class WordDocument extends Document {

    public WordDocument(String title, String author) {
        super(title, author);
    }

    @Override
    public void validate() {
        if (content == null || content.isEmpty()) {
            throw new IllegalStateException("WordDocument content cannot be empty");
        }
        System.out.println("WordDocument validated");
    }

    @Override
    public void generateSummary() {
        System.out.println("WordDocument Summary: " + (content.length() > 20 ? content.substring(0, 20) + "..." : content));
    }

}

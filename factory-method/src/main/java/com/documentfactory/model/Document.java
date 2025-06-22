package com.documentfactory.model;

public abstract class Document {
    protected String title;
    protected String author;
    protected String content;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract void validate();

    public abstract void generateSummary();

    @Override
    public String toString() {
        return String.format("Document(title='%s', author='%s', content='%s')", title, author, content);
    }

}

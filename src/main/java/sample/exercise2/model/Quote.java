package sample.exercise2.model;

import java.util.UUID;

/**
 * TODO: Please refactor as you see fit.
 */
public class Quote {
    private String id;
    private String author;
    private String text;

    public Quote() {
        this.id = null;
        this.author = null;
        this.text = null;
    }

    public Quote(String author, String text) {
        this(UUID.randomUUID().toString(), author, text);
    }

    public Quote(String id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

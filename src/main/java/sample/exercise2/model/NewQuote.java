package sample.exercise2.model;

/**
 * TODO: Please refactor as you see fit.
 */
public class NewQuote {
    private String author;
    private String text;

    public NewQuote() {
    }

    public NewQuote(String author, String text) {
        this.author = author;
        this.text = text;
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

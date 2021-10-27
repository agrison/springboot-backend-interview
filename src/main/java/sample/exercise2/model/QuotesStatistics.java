package sample.exercise2.model;

/**
 * TODO: Please refactor as you see fit.
 */
public class QuotesStatistics {
    private long number;
    private long authors;
    private long averageWords;
    private long averageCharacters;

    public QuotesStatistics() {
    }

    public QuotesStatistics(long number, long authors, long averageWords, long averageCharacters) {
        this.number = number;
        this.authors = authors;
        this.averageWords = averageWords;
        this.averageCharacters = averageCharacters;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getAuthors() {
        return authors;
    }

    public void setAuthors(long authors) {
        this.authors = authors;
    }

    public long getAverageWords() {
        return averageWords;
    }

    public void setAverageWords(long averageWords) {
        this.averageWords = averageWords;
    }

    public long getAverageCharacters() {
        return averageCharacters;
    }

    public void setAverageCharacters(long averageCharacters) {
        this.averageCharacters = averageCharacters;
    }
}

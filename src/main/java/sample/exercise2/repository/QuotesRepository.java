package sample.exercise2.repository;

import org.springframework.stereotype.Service;
import sample.exercise2.model.Quote;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Please implement missing parts and refactor as you see fit.
 */
@Service
public class QuotesRepository {
    private final List<Quote> allQuotes = new ArrayList<>();

    public QuotesRepository() {
        reset();
    }

    public void reset() {
        allQuotes.clear();
        allQuotes.add(new Quote("Linus Torvalds", "Talk is cheap. Show me the code."));
        allQuotes.add(new Quote("Harold Abelson", "Programs must be written for people to read, and only incidentally for machines to execute."));
        allQuotes.add(new Quote("Rich Hickey", "Design is separating into things that can be composed."));
        allQuotes.add(new Quote("John Woods", "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live."));
        allQuotes.add(new Quote("Kent Beck", "I'm not a great programmer; I'm just a good programmer with great habits."));
        allQuotes.add(new Quote("Rich Hickey", "Programming is not about typing, it's about thinking."));
    }

    public List<Quote> findAll() {
        return allQuotes;
    }

    public ArrayList<Quote> findByAuthor(String search) {
        ArrayList<Quote> quotes = new ArrayList<>();
        for (Quote quote : this.allQuotes) {
            String author = quote.getAuthor();
            if (author.equalsIgnoreCase(search)) {
                quotes.add(new Quote(quote.getId(), quote.getAuthor(), quote.getText()));
            }
        }

        return quotes;
    }

    /**
     * TODO: Please implement.
     */
    public ArrayList<Quote> search(String needle) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * TODO: Please implement.
     */
    public Quote addQuote(String author, String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * TODO: Please implement.
     */
    public boolean removeQuote(String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

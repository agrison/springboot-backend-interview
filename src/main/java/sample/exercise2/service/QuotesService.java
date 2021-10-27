package sample.exercise2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.exercise2.model.Quote;
import sample.exercise2.model.QuotesStatistics;
import sample.exercise2.repository.QuotesRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Please implement missing parts and refactor as you see fit.
 */
@Service
public class QuotesService {
    @Autowired
    QuotesRepository repository;

    public List<Quote> findAll() {
        return repository.findAll();
    }

    public ArrayList<Quote> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public ArrayList<Quote> search(String needle) {
        return repository.search(needle);
    }

    public Quote addQuote(String author, String text) {
        return repository.addQuote(author, text);
    }

    public boolean removeQuote(String id) {
        return repository.removeQuote(id);
    }

    /**
     * TODO: Please implement.
     */
    public QuotesStatistics statistics() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

package sample.exercise2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.exercise2.model.NewQuote;
import sample.exercise2.model.Quote;
import sample.exercise2.model.QuotesStatistics;
import sample.exercise2.service.FizzBuzzService;
import sample.exercise2.service.QuotesService;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Please implement missing parts and refactor as you see fit.
 */
@RestController
public class AppController {
    @Autowired
    QuotesService quotesService;
    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/quotes", method = RequestMethod.GET)
    public List<Quote> list() {
        return quotesService.findAll();
    }

    @RequestMapping(value = "/quotes/statistics", method = RequestMethod.GET)
    public QuotesStatistics statistics() {
        return quotesService.statistics();
    }

    @RequestMapping(value = "/quotes/{author}", method = RequestMethod.GET)
    public ArrayList<Quote> byAuthor(@PathVariable("author") String author) {
        return quotesService.findByAuthor(author);
    }

    @RequestMapping(value = "/quotes/search", method = RequestMethod.GET)
    public ArrayList<Quote> search(@RequestParam("q") String q) {
        return quotesService.search(q);
    }

    /**
     * TODO: Please implement.
     */
    @RequestMapping(value = "/quotes", method = RequestMethod.POST)
    public Object addQuote(@RequestBody NewQuote quote) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * TODO: Please implement.
     */
    @RequestMapping(value = "/quotes/{id}", method = RequestMethod.DELETE)
    public Object deleteQuote(@PathVariable("id") String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequestMapping(value = "/fizz-buzz", method = RequestMethod.GET)
    public String fizzBuzz(@RequestParam("max") Integer max) {
        return fizzBuzzService.fizzBuzz(max);
    }
}
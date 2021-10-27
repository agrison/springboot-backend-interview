# Spring Boot Backend interview exercise

Interviewers: see [Interviewer.md](Interviewer.md)

## Exercise 1

### REST API

You have a REST API located in class `sample.exercise1.api.ApiController`, it has no implementation.

Please tell us what you think about this REST API:

- verbs
- paths
- whatever comes to your mind

Do you think it can be improved, and if so, in which way?

## Exercise 2 

The code is located in `src/main/java/sample/exercise2`, tests are in `src/test/java/sample`.

### API structure

The application uses an in-memory repository to avoid losing time with JPA.

You can use any Java library you want. Vavr and Lombok are already built-in the original `pom.xml`

* `GET /quotes`: List all the quotes.
* `GET /quotes/statistics`: Return some statistics about the code.
* `GET /quotes/{author}`: List all quotes by author.
* `GET /quotes/search?q=foo`: List all quotes by `foo` or talking about `foo`.
* `POST /quotes`: Create a new quote, the backend should check for duplicates before inserting. 
                  In case of duplicate the backend should return a `409 CONFLICT`.
* `DELETE /quotes/{id}`: Remove a quote from the in-memory repository. Should return a `404 NOT FOUND` when no such quote found.

### Refactoring

Please refactor the code to make it better. 
You have full power, you can refactor whatever you want and as you see fit.

Most of the work you have to do is in the `QuotesRepository`, `QuotesService`, `FizzBuzzService` and `AppController` classes.
However, the whole code can be improved in almost all parts.

### Performance

If you take a look at the `sample.exercise2.service.PerformanceService`, it includes two methods which are believed to be naive and slow.
Please make them faster, these can be checked using the test class `sample.PerfTest`.

### Make the tests PASS

Some parts are not implemented and have to be implemented so that the tests are **all green**.

Complete as much as you can during the allotted time 😃

### Bonus

1) Improve performance
2) What if I finally want some JPA?
3) Do you like Vavr? I do like Vavr. How can it improves the code?
4) I want my server to use SSL.
5) Secure both POST & DELETE endpoints with a JWT.

----

Good luck & have fun!

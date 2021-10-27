## About

This is a small fill-in-the-gaps Spring Boot interview exercise I made up to assess parts of a candidate skills.

Feel free to use it.

## How I do use it

I mainly watch the candidate implements part of the exercises. I am not really interested in that the candidate can finish it, but more in how the candidate navigate through the code, and think about how to best implement the missing parts.

Some things I'm looking for the candidate to do:

- First, run the tests to see what is broken and what's not
- Read the tests to understand how the API is supposed to work
- Implement the missing parts, step by step
- Refactor the code along the way, I've put improvable code almost everywhere (I expect this from a more senior candidate)

This part is anecdotal, but since the candidate can use their preferred IDE, I expect the candidate to be fluent, being able to import the maven project, run the tests, know some keyboard shortcuts instead of coding everything with the mouse. *This is not eliminatory at all*, it just adds to my feeling.

## Implementations
 
The goal is to have different implementations (git branches) using :

- Standard Java and Spring
    - Java 8
    - Java 11
    - Java 14
    - Java 17
- Using Vavr
- Replacing the `QuotesRepository` which is using an in-memory collection to standard `JPA` using an in-memory H2
    

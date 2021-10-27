package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sample.exercise2.model.Quote;
import sample.exercise2.repository.QuotesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {
    private static final String QUOTE = "{\"author\": \"Cory House\", " +
            "\"text\": \"Code is like humor. When you have to explain it, it's bad.\"}";
    @Autowired
    MockMvc mockMvc;
    @Autowired
    QuotesRepository repository;
    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void before() {
        repository.reset();
    }

    @Test
    public void testList() throws Exception {
        this.mockMvc.perform(get("/quotes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void testSearch() throws Exception {
        this.mockMvc.perform(get("/quotes/Rich Hickey"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void testStatistics() throws Exception {
        this.mockMvc.perform(get("/quotes/statistics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number", Matchers.equalTo(6)))
                .andExpect(jsonPath("$.authors", Matchers.equalTo(5)))
                .andExpect(jsonPath("$.averageWords", Matchers.equalTo(13)))
                .andExpect(jsonPath("$.averageCharacters", Matchers.equalTo(69)));
    }

    @Test
    public void testSimpleAdd() throws Exception {
        this.mockMvc.perform(post("/quotes")
                .contentType("application/json")
                .content(QUOTE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.author", Matchers.equalTo("Cory House")));

        this.mockMvc.perform(post("/quotes")
                .contentType("application/json")
                .content(QUOTE))
                .andExpect(status().isConflict());
    }

    @Test
    public void testDelete() throws Exception {
        ResultActions action = this.mockMvc.perform(post("/quotes")
                .contentType("application/json")
                .content(QUOTE));

        Quote newQuote = mapper.readValue(action.andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString(), Quote.class);

        this.mockMvc.perform(delete("/quotes/" + newQuote.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUnknownQuote() throws Exception {
        this.mockMvc.perform(delete("/quotes/" + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testComplexAdd() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 1_000; ++i) {
            futures.add(executorService.submit(this::addSampleQuote));
        }
        executorService.shutdown();

        List<Integer> statusCodes = futures.stream()
                .map(f -> Try.of(f::get).getOrElse(-1))
                .collect(Collectors.toList());

        assertEquals("The quote should be added correctly one time only",
                1, statusCodes.stream().filter(status -> status == 201).count());

        assertEquals("The quote should have been refused 999 times out of 1000",
                999, statusCodes.stream().filter(status -> status == 409).count());
    }

    private int addSampleQuote() {
        try {
            ResultActions action = this.mockMvc.perform(post("/quotes")
                    .contentType("application/json")
                    .content(QUOTE));
            return action.andReturn().getResponse().getStatus();
        } catch (Exception e) {
            return -1;
        }
    }

    @Test
    public void testFizzBuzz() throws Exception {
        this.mockMvc.perform(get("/fizz-buzz?max=15"))
                .andExpect(status().isOk())
                .andExpect(content().string("1\n" +
                        "2\n" +
                        "Fizz\n" +
                        "4\n" +
                        "Buzz\n" +
                        "Fizz\n" +
                        "7\n" +
                        "8\n" +
                        "Fizz\n" +
                        "Buzz\n" +
                        "11\n" +
                        "Fizz\n" +
                        "13\n" +
                        "14\n" +
                        "FizzBuzz"));
    }
}
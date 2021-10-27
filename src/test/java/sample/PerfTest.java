package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.exercise2.service.PerformanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfTest {
    @Test
    public void perfTest() {
        PerformanceService service = new PerformanceService();
        long naive = System.currentTimeMillis();
        service.naiveCollectionGet(49_999_999);
        naive = System.currentTimeMillis() - naive;

        long fast = System.currentTimeMillis();
        service.fastCollectionGet(49_999_999);
        fast = System.currentTimeMillis() - fast;

        assertTrue(((double) naive / (double) fast) > 1.5d);
    }

    @Test
    public void perfTest2() {
        List<Integer> input = new ArrayList<>();
        IntStream.rangeClosed(1, 50_000).forEach(input::add);

        PerformanceService service = new PerformanceService();
        long naive = System.currentTimeMillis();
        service.naiveDeduplicate(input);
        naive = System.currentTimeMillis() - naive;

        long fast = System.currentTimeMillis();
        service.fastDeduplicate(input);
        fast = System.currentTimeMillis() - fast;

        assertTrue(((double) naive / (double) fast) > 1.5d);
    }
}
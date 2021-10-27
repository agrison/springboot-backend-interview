package sample.exercise2.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * TODO: Please implement missing parts and refactor as you see fit.
 */
@Service
public class PerformanceService {
    public boolean naiveCollectionGet(int index) {
        List<Integer> coll = new LinkedList<>();
        IntStream.rangeClosed(1, 50_000_000)
                .forEach(coll::add);
        return coll.get(index) != null;
    }

    /**
     * TODO: Please make {@link PerformanceService#naiveCollectionGet(int)} faster in the below method.
     *
     * @see PerformanceService#naiveCollectionGet(int)
     */
    public boolean fastCollectionGet(int index) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public <T> Collection<T> naiveDeduplicate(Collection<T> input) {
        Collection<T> newColl = new ArrayList<>();
        for (T e : input) {
            if (!newColl.contains(e)) {
                newColl.add(e);
            } else {
                // do nothing
            }
        }
        return newColl;
    }

    /**
     * TODO: Please make {@link PerformanceService#naiveDeduplicate(Collection)} faster in the below method.
     *
     * @see PerformanceService#naiveDeduplicate(Collection)
     */
    public <T> Collection<T> fastDeduplicate(Collection<T> input) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}


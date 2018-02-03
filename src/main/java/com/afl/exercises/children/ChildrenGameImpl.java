package com.afl.exercises.children;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ChildrenGameImpl implements ChildrenGame {

    public List<Integer> play(Integer n, Integer k) {

        if (n < 2 || k < 1) {
            throw new IllegalArgumentException("n must be at least 2. k must be at least 1.");
        }

        // List of children ids
        List<Integer> children = IntStream.range(0, n).boxed().collect(toList());
        List<Integer> result = new ArrayList<>();
        int removedId = 0; // Start from the 1st child

        // Keep removing children until there is only 1 left
        while (children.size() > 1) {
            removedId = (removedId + k - 1) % children.size();
            result.add(children.remove(removedId));
        }

        // Add the last child (the winner)
        result.add(children.get(0));

        return result;
    }

}

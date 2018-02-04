package com.afl.exercises.number;

import static com.afl.constants.Constants.NUMBER_BAR;
import static com.afl.constants.Constants.NUMBER_BAZ;
import static com.afl.constants.Constants.NUMBER_FOO;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NumberIteratorImpl implements NumberIterator {

    public List<String> iterate(Integer limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Input must be at least 0");
        }

        Long limitWithBoundary = limit.longValue() + 1;

        // Infinite stream of natural numbers starting from 0
        IntStream natural = IntStream.iterate(0, i -> i + 1);

        return natural
                .limit(limitWithBoundary) // Grab all ints up to the new limit
                .mapToObj(this::convert) // Convert them
                .filter(Optional::isPresent) // Remove any empty values
                .map(Optional::get)
                .collect(toList());

    }

    /**
     * Converts an Integer to its String result according to the rules or Empty
     * if it does not have a result.
     * 
     * When more rules become known this should be pulled out to its own class
     * and use something like a strategy pattern to be more modular/extensible.
     * To do this at this stage is probably premature abstraction.
     * 
     * @param number
     * @return
     */
    private Optional<String> convert(Integer number) {

        // Default to empty
        Optional<String> result = Optional.empty();

        // We must have at least 3 to be divisible by anything >= 3
        if (number < 3) {
            result = Optional.empty();
        } else if (number % 3 == 0 && number % 5 == 0) {
            result = Optional.of(NUMBER_BAZ);
        } else if (number % 3 == 0) {
            result = Optional.of(number + NUMBER_FOO);
        } else if (number % 5 == 0) {
            result = Optional.of(number + NUMBER_BAR);
        }
        return result;
    }

}

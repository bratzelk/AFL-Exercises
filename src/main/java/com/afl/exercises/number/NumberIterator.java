package com.afl.exercises.number;

import java.util.List;

public interface NumberIterator {

    /**
     * 
     * @param limit,
     *            The limit at which to stop iterating (inclusive).
     * @return A list of strings representing each line of output.
     */
    List<String> iterate(Integer limit);
}

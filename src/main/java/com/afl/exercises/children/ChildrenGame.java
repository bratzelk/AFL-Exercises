package com.afl.exercises.children;

import java.util.List;

public interface ChildrenGame {

    /**
     * 
     * @param n
     *            Number of Children, must be > 1
     * @param k
     *            Out number, must be > 0
     * @return The sequence of children as they go out. The last element is the
     *         id of the winning child.
     */
    List<Integer> play(Integer n, Integer k);
}

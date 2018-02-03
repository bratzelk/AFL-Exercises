package com.afl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afl.exercises.children.ChildrenGame;
import com.afl.exercises.children.ChildrenGameImpl;
import com.afl.exercises.number.NumberIterator;
import com.afl.exercises.number.NumberIteratorImpl;

public class ExerciseRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ExerciseRunner.class);

    private ChildrenGame childrenGame;
    private NumberIterator numberIterator;

    public ExerciseRunner() {
        this.childrenGame = new ChildrenGameImpl();
        this.numberIterator = new NumberIteratorImpl();
    }

    public ExerciseRunner(ChildrenGame childrenGame, NumberIterator numberIterator) {
        this.childrenGame = childrenGame;
        this.numberIterator = numberIterator;
    }

    public void runChildrenGame(Integer n, Integer k) {
        LOG.info("Running Children Game with inputs {} {}", n, k);

        List<Integer> result = childrenGame.play(n, k);

        result.forEach(i -> LOG.info("Child id={} is out!", i));
        if (!result.isEmpty()) {
            Integer winner = result.get(result.size() - 1);
            LOG.info("Winner is Child id={}", winner);
        }

    }

    public void runNumberIterator(Integer limit) {
        LOG.info("Running Number Iterator with input {}", limit);

        List<String> result = numberIterator.iterate(limit);

        result.forEach(i -> LOG.info("Output: {}", i));
    }
}

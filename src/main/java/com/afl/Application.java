package com.afl;

import static com.afl.constants.Constants.EXERCISE_CHILDREN;
import static com.afl.constants.Constants.EXERCISE_NUMBER;
import static java.lang.Integer.parseInt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afl.exercises.children.ChildrenGameImpl;
import com.afl.exercises.number.NumberIteratorImpl;

/**
 * A simple command line runner for the AFL Exercises. See README.md for
 * instructions.
 * 
 * By Kim Bratzel 2018
 *
 */
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String USAGE = "Usage: java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar (children|number) n k";

    public static void main(String[] args) {
        ExerciseRunner runner = new ExerciseRunner(new ChildrenGameImpl(), new NumberIteratorImpl());
        run(runner, args);
    }

    /*
     * Extremely oversimplified argument parsing and running.
     */
    public static void run(ExerciseRunner runner, String[] args) {
        LOG.info("*** AFL Exercises Runner ***");
        try {
            if (EXERCISE_CHILDREN.equalsIgnoreCase(args[0])) {
                LOG.info("*** Children's Game ***");
                Integer n = parseInt(args[1]);
                Integer k = parseInt(args[2]);
                runner.runChildrenGame(n, k);
            } else if (EXERCISE_NUMBER.equalsIgnoreCase(args[0])) {
                LOG.info("*** Number Iterator ***");
                Integer limit = parseInt(args[1]);
                runner.runNumberIterator(limit);
            } else {
                LOG.error(USAGE);
            }
        } catch (IllegalArgumentException exception) {
            LOG.error(USAGE);
        }
    }

}

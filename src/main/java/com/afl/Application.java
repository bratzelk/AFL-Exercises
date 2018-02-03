package com.afl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Java app
 *
 */

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String USAGE = "Usage: java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar (children|number) n k";

    public static void main(String[] args) {
        run(args);
    }

    /*
     * Horribly oversimplified argument parsing and running
     */
    public static void run(String[] args) {
        LOG.info("*** AFL Exercises Runner ***");
        ExerciseRunner runner = new ExerciseRunner();

        try {
            if ("children".equalsIgnoreCase(args[0])) {
                Integer n = Integer.parseInt(args[1]);
                Integer k = Integer.parseInt(args[2]);
                runner.runChildrenGame(n, k);
            } else if ("number".equalsIgnoreCase(args[0])) {
                Integer limit = Integer.parseInt(args[1]);
                runner.runNumberIterator(limit);
            } else {
                LOG.error(USAGE);
            }
        } catch (IllegalArgumentException exception) {
            LOG.error(USAGE);
        }
    }

}

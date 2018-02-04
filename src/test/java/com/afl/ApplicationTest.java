package com.afl;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.afl.constants.Constants;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    @Mock
    private ExerciseRunner runner;

    private String[] args;

    @Before
    public void beforeEach() {
        args = new String[3];

        doNothing().when(runner).runChildrenGame(anyInt(), anyInt());
        doNothing().when(runner).runNumberIterator(anyInt());
    }

    @Test
    public void shouldRunChildrenGameWhenValidArgumentsPassedIn() {
        // Given
        args[0] = Constants.EXERCISE_CHILDREN;
        args[1] = "4";
        args[2] = "4";

        Application.run(runner, args);

        verify(runner).runChildrenGame(anyInt(), anyInt());
    }

    @Test
    public void shouldRunNumberIteratorWhenValidArgumentsPassedIn() {
        // Given
        args[0] = Constants.EXERCISE_NUMBER;
        args[1] = "15";

        Application.run(runner, args);

        verify(runner).runNumberIterator(anyInt());
    }

    @Test
    public void shouldNotRunAnythingWhenInvalidArgumentsPassedIn() {
        // Given
        args[0] = "invalid";

        Application.run(runner, args);

        verify(runner, times(0)).runChildrenGame(anyInt(), anyInt());
        verify(runner, times(0)).runNumberIterator(anyInt());
    }

}

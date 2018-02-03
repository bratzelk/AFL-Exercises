package com.afl;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.afl.exercises.children.ChildrenGame;
import com.afl.exercises.number.NumberIterator;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExerciseRunnerTest {

    @Mock
    private ChildrenGame childrenGame;

    @Mock
    private NumberIterator numberIterator;

    private ExerciseRunner unitUnderTest;

    private Integer arg1;
    private Integer arg2;

    @Before
    public void beforeEach() {
        unitUnderTest = new ExerciseRunner(childrenGame, numberIterator);

        when(childrenGame.play(anyInt(), anyInt())).thenReturn(asList(1, 2, 3));
        when(numberIterator.iterate(anyInt())).thenReturn(asList("", ""));
    }

    @Test
    public void shouldRunChildrenGame() {
        arg1 = 77;
        arg2 = 88;

        unitUnderTest.runChildrenGame(arg1, arg2);

        verify(childrenGame).play(arg1, arg2);
    }

    @Test
    public void shouldRunNumberIterator() {
        arg1 = 66;

        unitUnderTest.runNumberIterator(arg1);

        verify(numberIterator).iterate(arg1);
    }
}

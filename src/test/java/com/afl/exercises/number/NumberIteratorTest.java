package com.afl.exercises.number;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NumberIteratorTest {

    private NumberIterator unitUnderTest;
    private Integer limit;
    private List<String> result;

    @Before
    public void beforeEach() {
        unitUnderTest = new NumberIteratorImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnInvalidInput() {
        unitUnderTest.iterate(-1);
    }

    @Test
    public void shouldIterateUpToAndIncludingLimit() {
        // Given
        limit = 15;

        // When
        result = unitUnderTest.iterate(limit);

        // Then should include result on the boundary of the limit
        assertEquals("Result should output for numbers 3,5,6,9,10,12,15", 7, result.size());
    }

    @Test
    public void shouldOutputFoo() {
        // Given
        limit = 3;

        // When
        result = unitUnderTest.iterate(limit);

        // Then
        assertEquals(1, result.size());
        assertEquals("3FOO", result.get(0));
    }

    @Test
    public void shouldOutputBar() {
        // Given
        limit = 5;

        // When
        result = unitUnderTest.iterate(limit);

        // Then
        assertEquals(2, result.size());
        assertEquals("5BAR", result.get(1));
    }

    @Test
    public void shouldOutputBaz() {
        // Given
        limit = 15;

        // When
        result = unitUnderTest.iterate(limit);

        // Then
        assertEquals(7, result.size());
        assertEquals("BAZ", result.get(6));
    }

}

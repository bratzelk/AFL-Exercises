package com.afl.exercises.children;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChildrenGameTest {

    private static final Logger LOG = LoggerFactory.getLogger(ChildrenGameTest.class);

    private ChildrenGame unitUnderTest;
    private Integer n;
    private Integer k;
    private List<Integer> result;

    @Before
    public void beforeEach() {
        unitUnderTest = new ChildrenGameImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeMoreThanOneChildToPlay() {
        // Given only one Child
        n = 1;
        k = 99;

        // When we play
        unitUnderTest.play(n, k);

        // Then should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void kShouldBeAtLeastOneToPlay() {
        // Given k is zero or fewer
        n = 10;
        k = 0;

        // When we play
        unitUnderTest.play(n, k);

        // Then should throw exception
    }

    @Test
    public void shouldRemoveAllChildren() {
        // Given
        n = 2;
        k = 2;

        // When we play
        result = unitUnderTest.play(n, k);

        // Then
        assertEquals("Result should include all children", n.intValue(), result.size());
    }

    @Test
    public void shouldBeKnockedOutInCorrectOrder() {
        // Given
        n = 2;
        k = 2;

        // When we play
        result = unitUnderTest.play(n, k);

        // Then
        assertEquals("ID 1 should be knocked out first", 1, result.get(0).intValue());
        assertEquals("ID 0 should be knocked out last", 0, result.get(1).intValue());
    }

    @Test
    public void shouldBeKnockedOutInCorrectOrder2() {
        // Given
        n = 3;
        k = 5;

        // When we play
        result = unitUnderTest.play(n, k);

        // Then
        assertEquals("ID 1 should be knocked out first", 1, result.get(0).intValue());
        assertEquals("ID 2 should be knocked out second", 2, result.get(1).intValue());
        assertEquals("ID 0 should be knocked out last", 0, result.get(2).intValue());
    }

    @Test
    public void shouldNotHaveDuplicateIds() {
        // Given
        n = 4;
        k = 3;

        // When we play
        result = unitUnderTest.play(n, k);

        // Then
        Set<Integer> set = new HashSet<>(result);
        assertEquals("Should not contain duplicate IDs ", result.size(), set.size());
        assertEquals("Should contain correct number of results ", n.intValue(), set.size());
    }

    @Test
    public void shouldHaveWinnerInLastElement() {
        // Given
        n = 4;
        k = 3;

        // When we play
        result = unitUnderTest.play(n, k);
        Integer last = result.size() - 1;

        // Then
        assertEquals("Winner should have ID ", 0, result.get(last).intValue());
    }

}

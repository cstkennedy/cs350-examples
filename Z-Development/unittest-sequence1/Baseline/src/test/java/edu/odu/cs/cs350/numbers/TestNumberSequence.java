package edu.odu.cs.cs350.numbers;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 *
 * @author Thomas J. Kennedy
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNumberSequence
{
    NumberSequence fromOneByOne;
    NumberSequence fromZeroByTwo;
    NumberSequence fromTenByNegativeSeven;

    @Before
    public void setUp()
    {
        fromOneByOne = new NumberSequence();
        fromZeroByTwo = new NumberSequence(0, 2);

        fromTenByNegativeSeven = new NumberSequence(10, -7);
    }

    @Test
    public void testDefaultConstructor()
    {
        assertThat(fromOneByOne.first(), is(1));
        assertThat(fromOneByOne.step(), is(1));
        assertThat(fromOneByOne.currentLast(), is(1));
        assertThat(fromOneByOne.length(), is(1));

        assertThat(fromOneByOne.toString(), containsString("1"));
    }

    @Test
    public void testSecondConstructor()
    {
        // First sequence
        assertThat(fromZeroByTwo.first(), is(0));
        assertThat(fromZeroByTwo.step(), is(2));
        assertThat(fromZeroByTwo.currentLast(), is(0));
        assertThat(fromZeroByTwo.length(), is(1));

        assertThat(fromZeroByTwo.toString(), containsString("0"));

        // Second sequence
        assertThat(fromTenByNegativeSeven.first(), is(10));
        assertThat(fromTenByNegativeSeven.step(), is(-7));
        assertThat(fromTenByNegativeSeven.currentLast(), is(10));
        assertThat(fromTenByNegativeSeven.length(), is(1));

        assertThat(fromTenByNegativeSeven.toString(), containsString("10"));
    }

    @Test
    public void testNext1by1()
    {
        // Call next a few times
        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(2));

        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(3));

        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(4));

        // Check the final result
        assertThat(fromOneByOne.first(), is(1));
        assertThat(fromOneByOne.step(), is(1));
        assertThat(fromOneByOne.length(), is(4));

        assertThat(fromOneByOne.toString(), containsString("1"));
        assertThat(fromOneByOne.toString(), containsString("2"));
        assertThat(fromOneByOne.toString(), containsString("3"));
        assertThat(fromOneByOne.toString(), containsString("4"));
    }

    @Test
    public void testNext0by2()
    {
        // Call next a few times
        fromZeroByTwo.next();
        assertThat(fromZeroByTwo.currentLast(), is(2));

        fromZeroByTwo.next();
        assertThat(fromZeroByTwo.currentLast(), is(4));

        fromZeroByTwo.next();
        assertThat(fromZeroByTwo.currentLast(), is(6));

        fromZeroByTwo.next();
        assertThat(fromZeroByTwo.currentLast(), is(8));

        // Check the final result
        assertThat(fromZeroByTwo.first(), is(0));
        assertThat(fromZeroByTwo.step(), is(2));
        assertThat(fromZeroByTwo.length(), is(5));

        assertThat(fromZeroByTwo.toString(), containsString("0"));
        assertThat(fromZeroByTwo.toString(), containsString("2"));
        assertThat(fromZeroByTwo.toString(), containsString("4"));
        assertThat(fromZeroByTwo.toString(), containsString("6"));
        assertThat(fromZeroByTwo.toString(), containsString("8"));
    }

    @Test
    public void testNext10byNegative7()
    {
        // Call next a couple times
        fromTenByNegativeSeven.next();
        assertThat(fromTenByNegativeSeven.currentLast(), is(3));

        fromTenByNegativeSeven.next();
        assertThat(fromTenByNegativeSeven.currentLast(), is(-4));


        // Check the final result
        assertThat(fromTenByNegativeSeven.first(), is(10));
        assertThat(fromTenByNegativeSeven.step(), is(-7));
        assertThat(fromTenByNegativeSeven.length(), is(3));

        assertThat(fromTenByNegativeSeven.toString(), containsString("10"));
        assertThat(fromTenByNegativeSeven.toString(), containsString("3"));
        assertThat(fromTenByNegativeSeven.toString(), containsString("-4"));
    }

    // ------------------------Reference - Need to Check------------------------
    // public int first()
    // public int step()
    // public int currentLast()
    // public int length()
    // public String toString()

    /*
     * -----------------------------Closing Remarks-----------------------------
     *
     * 1. What if I added a clone function?
     * 2. Can I improve my tests?
     *   a. methodology
     *   b. size
     *   c. readability
     *   d. D.R.Y - Do not Repeat Yourself (i.e., code duplication)
     * 3. What lessons did we learn?
     */
}

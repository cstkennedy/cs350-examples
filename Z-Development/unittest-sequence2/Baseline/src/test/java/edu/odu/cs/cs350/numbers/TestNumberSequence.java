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

        assertTrue(fromOneByOne.iterator().hasNext());

        // I should be equal to myself
        assertThat(fromOneByOne, equalTo(fromOneByOne));
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

        assertTrue(fromZeroByTwo.iterator().hasNext());

        assertThat(fromTenByNegativeSeven, equalTo(fromTenByNegativeSeven));
        assertThat(fromTenByNegativeSeven, not(equalTo(fromZeroByTwo)));
    }


    @Test
    public void testNext1by1()
    {
        int initialHashCode = fromOneByOne.hashCode();

        // Call next a few times
        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(2));

        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(3));

        fromOneByOne.next();
        assertThat(fromOneByOne.currentLast(), is(4));

        // Focus on the iterator
        Iterator<Integer> it = fromOneByOne.iterator();
        assertThat(it.next().intValue(), is(1));
        assertThat(it.next().intValue(), is(2));
        assertThat(it.next().intValue(), is(3));
        assertThat(it.next().intValue(), is(4));
        assertFalse(it.hasNext());

        // Check the final result
        assertThat(fromOneByOne.first(), is(1));
        assertThat(fromOneByOne.step(), is(1));
        assertThat(fromOneByOne.length(), is(4));

        int finalHashCode = fromOneByOne.hashCode();
        assertThat(initialHashCode, is(not(finalHashCode)));

        assertThat(fromOneByOne.toString(),
                   stringContainsInOrder(Arrays.asList("1", "2", "3", "4")));
    }

    @Test
    public void testNext0by2()
    {
        int initialHashCode = fromZeroByTwo.hashCode();

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

        // Focus on the iterator
        Iterator<Integer> it = fromZeroByTwo.iterator();
        assertThat(it.next().intValue(), is(0));
        assertThat(it.next().intValue(), is(2));
        assertThat(it.next().intValue(), is(4));
        assertThat(it.next().intValue(), is(6));
        assertThat(it.next().intValue(), is(8));
        assertFalse(it.hasNext());

        int finalHashCode = fromZeroByTwo.hashCode();
        assertThat(initialHashCode, is(not(finalHashCode)));

        List<String> expectedStrList = Arrays.asList("0", "2", "4", "6", "8");
        assertThat(fromZeroByTwo.toString(),
                   stringContainsInOrder(expectedStrList));
    }

    @Test
    public void testNext10byNegative7()
    {
        int initialHashCode = fromTenByNegativeSeven.hashCode();

        // Call next a couple times
        fromTenByNegativeSeven.next();
        assertThat(fromTenByNegativeSeven.currentLast(), is(3));

        fromTenByNegativeSeven.next();
        assertThat(fromTenByNegativeSeven.currentLast(), is(-4));

        // Check the final result
        assertThat(fromTenByNegativeSeven.first(), is(10));
        assertThat(fromTenByNegativeSeven.step(), is(-7));
        assertThat(fromTenByNegativeSeven.length(), is(3));

        // Focus on the iterator
        Iterator<Integer> it = fromTenByNegativeSeven.iterator();
        assertThat(it.next().intValue(), is(10));
        assertThat(it.next().intValue(), is(3));
        assertThat(it.next().intValue(), is(-4));
        assertFalse(it.hasNext());

        int finalHashCode = fromTenByNegativeSeven.hashCode();
        assertThat(initialHashCode, is(not(finalHashCode)));

        // toString
        assertThat(fromTenByNegativeSeven.toString(),
                   stringContainsInOrder(Arrays.asList("10", "3", "-4")));
    }

    @Test
    public void testEqualsHashCodeAfterNext()
    {
        NumberSequence original = fromOneByOne;
        NumberSequence copySeq = (NumberSequence) original.clone();

        copySeq.next();
        copySeq.next();
        copySeq.next();

        assertThat(copySeq, not(equalTo(original)));
        assertThat(copySeq.hashCode(), not(equalTo(original.hashCode())));

        original = fromZeroByTwo;
        copySeq = (NumberSequence) original.clone();

        copySeq.next();
        copySeq.next();
        copySeq.next();

        assertThat(copySeq, not(equalTo(original)));
        assertThat(copySeq.hashCode(), not(equalTo(original.hashCode())));

        original = fromTenByNegativeSeven;
        copySeq = (NumberSequence) original.clone();

        copySeq.next();
        copySeq.next();
        copySeq.next();

        assertThat(copySeq, not(equalTo(original)));
        assertThat(copySeq.hashCode(), not(equalTo(original.hashCode())));

    }

    @Test
    public void testClone()
    {
        fromOneByOne.next();
        fromOneByOne.next();
        fromOneByOne.next();

        NumberSequence aCopy = (NumberSequence) fromOneByOne.clone();

        // The original and clone should be the same
        assertThat(aCopy.first(), equalTo(fromOneByOne.first()));
        assertThat(aCopy.step(), equalTo(fromOneByOne.step()));
        assertThat(aCopy.currentLast(), equalTo(fromOneByOne.currentLast()));
        assertThat(aCopy.length(), equalTo(fromOneByOne.length()));

        assertThat(aCopy.hashCode(), equalTo(fromOneByOne.hashCode()));
        assertThat(aCopy, equalTo(fromOneByOne));
        assertThat(aCopy.toString(), equalTo(fromOneByOne.toString()));

        // Focus on the *aCopy* iterator
        Iterator<Integer> it = aCopy.iterator();
        assertThat(it.next().intValue(), is(1));
        assertThat(it.next().intValue(), is(2));
        assertThat(it.next().intValue(), is(3));
        assertThat(it.next().intValue(), is(4));
        assertFalse(it.hasNext());
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

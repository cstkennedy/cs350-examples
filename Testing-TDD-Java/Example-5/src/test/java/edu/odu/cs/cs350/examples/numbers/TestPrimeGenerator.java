package edu.odu.cs.cs350.examples.numbers;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestPrimeGenerator
{
    /**
     * Fixed list of the first 2 known primes.
     */
    static final List<Integer> FIRST_2_PRIMES = Arrays.asList(2, 3);

    /**
     * Fixed list of the first 5 known primes.
     */
    static final List<Integer> FIRST_5_PRIMES = Arrays.asList(2, 3, 5, 7, 11);

    /**
     * A generator that has been inialized with the default constructor.
     */
    PrimeGenerator generator;

    /**
     * A generator seeded with the first 5 prime numbers.
     */
    PrimeGenerator seededWith5;

    @BeforeEach
    public void setUp()
    {
        generator = new PrimeGenerator();
        seededWith5 = new PrimeGenerator(FIRST_5_PRIMES);
    }

    @Test
    public void testDefaultConstructor()
    {
        // public int getLast()
        assertThat(generator.getLast(), is(3));

        // public final List<Integer> getPrimes()
        assertThat(generator.getPrimes(), equalTo(FIRST_2_PRIMES));

        // public int numberOfPrimes()
        assertThat(generator.numberOfPrimes(), is(2));

        // handled later - public boolean equals(Object rhs)
        // handled later - public int hashCode()

        // public String toString()
        assertThat(generator.toString(), containsString("2"));
        assertThat(generator.toString(), containsString("3"));
    }

    @Test
    public void testDefaultConstructorWithIterator()
    {
        // public Iterator<Integer> iterator()
        Iterator<Integer> primeIt = generator.iterator();
        int aPrime = -1;

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(2));

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(3));

        assertThat(primeIt.hasNext(), is(false));
    }

    @Test
    public void testNonDefaultConstructor1()
    {
        PrimeGenerator seededGenerator = seededWith5;

        // public int getLast()
        assertThat(seededGenerator.getLast(), is(11));

        // public final List<Integer> getPrimes()
        assertThat(seededGenerator.getPrimes(), equalTo(FIRST_5_PRIMES));

        // public int numberOfPrimes()
        assertThat(seededGenerator.numberOfPrimes(), is(5));

        // public String toString()
        // A better option - Check for substrings in order
        List<String> primesAsStrings = Arrays.asList("2", "3", "5", "7", "11");
        assertThat(seededGenerator.toString(),
                   stringContainsInOrder(primesAsStrings));
    }

    @Test
    public void testConstructorsWithEquals()
    {
        // public boolean equals(Object rhs)
        assertThat(seededWith5, not(equalTo(generator)));
    }

    @Test
    public void testConstructorsWithHashCode()
    {
        // public int hashCode()
        assertThat(seededWith5.hashCode(), not(equalTo(generator.hashCode())));
    }

    @Test
    public void testNonDefaultConstructor1WithIterator()
    {
        // public Iterator<Integer> iterator()
        Iterator<Integer> primeIt = seededWith5.iterator();
        int aPrime = -1;

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(2));

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(3));

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(5));

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(7));

        aPrime = (primeIt.next()).intValue();
        assertThat(aPrime, is(11));

        assertFalse(primeIt.hasNext());
    }

    @Test
    public void testNext()
    {
        generator.next();
        assertThat(generator.getLast(), is(5));

        generator.next();
        assertThat(generator.getLast(), is(7));

        generator.next();
        assertThat(generator.getLast(), is(11));

        // public final List<Integer> getPrimes()
        assertThat(generator.getPrimes(), equalTo(FIRST_5_PRIMES));
        // ! - mistake in test contains vs equals

        // public Iterator<Integer> iterator() - Causing Problems...
        // int[] expectedPrimes = new int[]{2, 3, 5, 7, 11};
        // Iterator<Integer> it = generator.iterator();

        // for (int expectedPrime : expectedPrimes) {
            // assertTrue(it.hasNext());
            // assertThat(it.next().intValue(), is(expectedPrime));
            // it.next(); // This was the issue!
        // }
        // assertFalse(it.hasNext());

        // public Iterator<Integer> iterator() - Better... Why?
        Iterator<Integer> it = generator.iterator();

        assertTrue(it.hasNext());
        assertThat(it.next().intValue(), is(2));

        assertTrue(it.hasNext());
        assertThat(it.next().intValue(), is(3));

        assertTrue(it.hasNext());
        assertThat(it.next().intValue(), is(5));

        assertTrue(it.hasNext());
        assertThat(it.next().intValue(), is(7));

        assertTrue(it.hasNext());
        assertThat(it.next().intValue(), is(11));

        assertFalse(it.hasNext());

        // public int numberOfPrimes()
        assertThat(generator.numberOfPrimes(), is(5));

        // public boolean equals(Object rhs)
        assertThat(generator, is(equalTo(seededWith5)));

        // public int hashCode()
        assertThat(generator.hashCode(), is(equalTo(seededWith5.hashCode())));

        // public String toString()
        assertThat(generator.toString(), is(equalTo(seededWith5.toString())));
    }

    @Test
    public void testNextFew()
    {
        PrimeGenerator anotherGenerator = new PrimeGenerator();

        anotherGenerator.nextFew(3);
        assertThat(anotherGenerator.getLast(), is(11));

        anotherGenerator.nextFew(2);
        assertThat(anotherGenerator.getLast(), is(17));

        // public final List<Integer> getPrimes()
        List<Integer> expectedPrimes = null;
        expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

        assertThat(anotherGenerator.getPrimes(), equalTo(expectedPrimes));

        // public int numberOfPrimes()
        assertThat(anotherGenerator.numberOfPrimes(), is(7));

        // public boolean equals(Object rhs)
        assertThat(anotherGenerator, not(equalTo(generator)));
        assertThat(anotherGenerator, not(equalTo(seededWith5)));

        // public int hashCode()
        assertThat(anotherGenerator.hashCode(),
                   not(equalTo(generator.hashCode())));

        assertThat(anotherGenerator.hashCode(),
                   not(equalTo(seededWith5.hashCode())));

        // public String toString()
        List<String> expectedStrings = expectedPrimes.stream()
                                                       .map(p -> p.toString())
                                                       .collect(toList());

        assertThat(anotherGenerator.toString(),
                   stringContainsInOrder(expectedStrings));

        // public Iterator<Integer> iterator()
        Iterator<Integer> primeIt = anotherGenerator.iterator();

        assertThat(primeIt.next().intValue(), is(2));
        assertThat(primeIt.next().intValue(), is(3));
        assertThat(primeIt.next().intValue(), is(5));
        assertThat(primeIt.next().intValue(), is(7));
        assertThat(primeIt.next().intValue(), is(11));
        assertThat(primeIt.next().intValue(), is(13));
        assertThat(primeIt.next().intValue(), is(17));

        // There should not be any primes left
        assertThat(primeIt.hasNext(), is(false));
    }

    // Reference - Need to check
    // public int getLast()
    // public final List<Integer> getPrimes()
    // public Iterator<Integer> iterator()
    // public int numberOfPrimes()
    // public boolean equals(Object rhs)
    // public int hashCode()
    // public String toString()
}

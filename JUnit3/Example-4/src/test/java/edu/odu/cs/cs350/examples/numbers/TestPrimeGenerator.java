package edu.odu.cs.cs350.examples.numbers;

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

/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @Before
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

        // public Iterator<Integer> iterator()
        // ????
        // ????

        // public int numberOfPrimes()
        assertThat(generator.numberOfPrimes(), is(2));

        // public boolean equals(Object rhs)
        // public int hashCode()

        // public String toString()
        assertThat(generator.toString(), containsString("2"));
        assertThat(generator.toString(), containsString("3"));
    }

    @Test
    public void testNonDefaultConstructor1()
    {
        PrimeGenerator seededGenerator = seededWith5;

        // public int getLast()
        assertThat(seededGenerator.getLast(), is(11));

        // public final List<Integer> getPrimes()
        assertThat(seededGenerator.getPrimes(), equalTo(FIRST_5_PRIMES));

        // public Iterator<Integer> iterator()
        // ??????
        // ??????
        // ??????

        // public int numberOfPrimes()
        assertThat(seededGenerator.numberOfPrimes(), is(5));

        // public boolean equals(Object rhs)
        // This should be factored out (and tested elsewhere)
        assertThat(generator, not(equalTo(seededWith5)));

        // public int hashCode()
        assertThat(generator.hashCode(), not(equalTo(seededWith5.hashCode())));

        // public String toString()
        assertThat(generator.toString(), containsString("2"));
        assertThat(generator.toString(), containsString("3"));
        assertThat(generator.toString(), containsString("5"));
        assertThat(generator.toString(), containsString("7"));
        assertThat(generator.toString(), containsString("11"));

        // A better option - Check for substrings in order
        List<String> primesAsStrings = Arrays.asList("2", "3", "5", "7", "11");
        assertThat(generator.toString(), stringContainsInOrder(primesAsStrings));
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
        assertThat(generator.getPrimes(), contains(FIRST_5_PRIMES));

        // public Iterator<Integer> iterator()
        // ????
        // ????

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
        PrimeGenerator generator = new PrimeGenerator();

        generator.nextFew(3);
        assertThat(generator.getLast(), is(11));

        // public final List<Integer> getPrimes()
        // public Iterator<Integer> iterator()
        // public int numberOfPrimes()
        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
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

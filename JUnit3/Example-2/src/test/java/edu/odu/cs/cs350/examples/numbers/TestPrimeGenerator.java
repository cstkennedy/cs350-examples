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
    @Before
    public void setUp()
    {
    }

    @Test
    public void testDefaultConstructor()
    {
        PrimeGenerator generator = new PrimeGenerator();

        // public int getLast()
        assertEquals(3, generator.getLast());
        assertThat(generator.getLast(), is(equalTo(3)));
        assertThat(generator.getLast(), equalTo(3));
        assertThat(generator.getLast(), is(3));

        // public final List<Integer> getPrimes()
        // public Iterator<Integer> iterator()
        // public int numberOfPrimes()
        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
    }

    @Test
    public void testNonDefaultConstructor1()
    {
        List<Integer> knownPrimes = Arrays.asList(2, 3, 5, 7, 11);
        PrimeGenerator seededGenerator = new PrimeGenerator(knownPrimes);

        // public int getLast()
        assertThat(seededGenerator.getLast(), is(11));

        // public final List<Integer> getPrimes()
        assertThat(seededGenerator.getPrimes(), contains(knownPrimes.get(0),
                                                         knownPrimes.get(1),
                                                         knownPrimes.get(2),
                                                         knownPrimes.get(3),
                                                         knownPrimes.get(4)));
        // Of Course, there is the lazy method...
        assertThat(seededGenerator.getPrimes(), equalTo(knownPrimes));
        assertEquals(seededGenerator.getPrimes(), knownPrimes);
        assertTrue(seededGenerator.getPrimes().equals(knownPrimes));

        // public Iterator<Integer> iterator()
        // ??????
        // ??????
        // ??????

        // public int numberOfPrimes()

        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
    }

    @Test
    public void testNext()
    {
        PrimeGenerator generator = new PrimeGenerator();

        generator.next();
        assertThat(generator.getLast(), is(5));

        generator.next();
        assertThat(generator.getLast(), is(7));

        // public final List<Integer> getPrimes()
        // public Iterator<Integer> iterator()
        // public int numberOfPrimes()
        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
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

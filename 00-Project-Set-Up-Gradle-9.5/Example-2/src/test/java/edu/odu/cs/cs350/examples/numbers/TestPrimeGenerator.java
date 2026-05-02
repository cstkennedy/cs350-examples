package edu.odu.cs.cs350.examples.numbers;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void testPlaceholder()
    {
        fail("I did not write anything yet");
    }

    //--------------------------------------------------------------------------
    /*
      # Functions to Use in Tests

      public PrimeGenerator()
      public PrimeGenerator(List<Integer> knownPrimes)
      public void next()
      public void nextFew(int toGenerate)
      public int getLast()
      public final List<Integer> getPrimes()
      public Iterator<Integer> iterator()
      public int numberOfPrimes()
      public boolean equals(Object rhs)
      public int hashCode()
      public String toString()
    */
    //--------------------------------------------------------------------------
    /*
      # Mutators vs Accessors

      | **Type** | **Return Type**   | **Function**                              |
      | :------  | :---------------- | :-------------                            |
      | Mutator  | Constructor       | PrimeGenerator()                          |
      | Mutator  | Constructor       | PrimeGenerator(List<Integer> knownPrimes) |
      | Mutator  | void              | next()                                    |
      | Mutator  | void              | nextFew(int toGenerate)                   |
      | Accessor | int               | getLast()                                 |
      | Accessor | List<Integer>     | getPrimes()                               |
      | Accessor | Iterator<Integer> | iterator()                                |
      | Accessor | int               | numberOfPrimes()                          |
      | Accessor | boolean           | equals(Object rhs)                        |
      | Accessor | int               | hashCode()                                |
      | Accessor | String            | toString()                                |
    */

    @Test
    public void testDefaultConstructor()
    {
        fail("TBW");
        // Need to check
        // public int getLast()
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
        fail("TBW");
        // Need to check
        // public int getLast()
        // public final List<Integer> getPrimes()
        // public Iterator<Integer> iterator()
        // public int numberOfPrimes()
        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
    }

    @Test
    public void testNext()
    {
        fail("TBW");
        // Need to check
        // public int getLast()
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
        fail("TBW");
        // Need to check
        // public int getLast()
        // public final List<Integer> getPrimes()
        // public Iterator<Integer> iterator()
        // public int numberOfPrimes()
        // public boolean equals(Object rhs)
        // public int hashCode()
        // public String toString()
    }
}

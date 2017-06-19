package edu.odu.cs.cs350.colorN;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 1 - Does this piece of code perform the operations 
 *     it was designed to perform?
 * 
 * 2 - Does this piece of code do something it was not 
 *     designed to perform?
 * 
 * 1 Test per mutator
 */
public class TestExample{

    @Test
    public void testNumber()
    {
        Example ex = new Example();

        ex.setNumber(5);

        assertEquals(5, ex.getNumber());
    }
}
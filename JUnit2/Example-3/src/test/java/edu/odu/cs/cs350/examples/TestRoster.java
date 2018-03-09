package edu.odu.cs.cs350.examples;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;

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
public class TestRoster {

    @Before
    public void setUp()
    {

    }

    @Test
    public void testDefaultConstructor()
    {      
        fail("Not yet implemented");
    }

    @Test
    public void testNonDefaultConstructor()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSetCourseNum()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSetEnrollLimit()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testEnroll()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testClone()
    {
        fail("Left as an Exercise");
    }


}
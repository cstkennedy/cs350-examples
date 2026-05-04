package edu.odu.cs.cs350.examples;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestRoster {

    @BeforeEach
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

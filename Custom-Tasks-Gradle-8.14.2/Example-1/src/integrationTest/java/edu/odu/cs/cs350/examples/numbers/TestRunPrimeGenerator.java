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
public class TestRunPrimeGenerator
{
    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void testSomething()
    {
        fail("Not Written");
    }
}

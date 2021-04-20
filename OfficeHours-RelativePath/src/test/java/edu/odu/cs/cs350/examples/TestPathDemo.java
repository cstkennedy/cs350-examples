package edu.odu.cs.cs350.examples;

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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

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
public class TestPathDemo
{
    @Before
    public void setUp()
    {
        // Placeholder
    }

    @Test
    public void testRelativePath()
    {
        String[] pathSteps = {"src", "test", "resources", "testProgram1", "KeyboardInput.java"};
        Path path = Paths.get("src", "test", "resources", "testProgram1", "KeyboardInput.java");

        // System.out.println(path.toString());
        // System.out.println(String.join(java.io.File.pathSeparator, pathSteps));
        // assertThat(path.toString(), equalTo(String.join(":", pathSteps)));

        BufferedReader aBuffer = null;

        try {
            aBuffer = new BufferedReader(new FileReader(path.toString()));
        }
        catch (FileNotFoundException exc) {
            fail("File Could Not be Opened");
        }

        try {
            String firstLine = aBuffer.readLine();
            assertThat(firstLine, equalTo("import java.util.Scanner;"));
        }
        catch (IOException exc) {
            fail("File Could Not be Read");
        }


    }
}




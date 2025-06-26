package edu.odu.cs.cs350.examples;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.BufferedReader;
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
@SuppressWarnings({
    "PMD.AtLeastOneConstructor",
    "PMD.JUnitTestContainsTooManyAsserts",
    "PMD.JUnitAssertionsShouldIncludeMessage"
})
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestPathDemo
{
    @BeforeEach
    public void setUp()
    {
        // Placeholder
    }

    @Test
    void testRelativePath()
    {
        // String[] pathSteps = {"src", "test", "resources", "testProgram1", "KeyboardInput.java"};
        final Path path = Paths.get("src", "test", "resources", "testProgram1", "KeyboardInput.java");

        // System.out.println(path.toString());
        // System.out.println(String.join(java.io.File.pathSeparator, pathSteps));
        // assertThat(path.toString(), equalTo(String.join(":", pathSteps)));

        BufferedReader aBuffer = null;

        try {
            aBuffer = Files.newBufferedReader(path);
        }
        catch (FileNotFoundException exc) {
            fail("File Could Not be Opened");
        }
        catch (IOException exc) {
            fail("File Could Not be read");
        }

        try {
            final String firstLine = aBuffer.readLine();
            assertThat(firstLine, equalTo("import java.util.Scanner;"));
        }
        catch (IOException exc) {
            fail("File Could Not be Read");
        }


    }
}




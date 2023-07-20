package edu.odu.cs.cs350.examples;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.IsNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * This is an integration test (by definition).
 *
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestExampleJSONWriter {

    Student john;
    Student tom;
    Student jay;
    Student oscar;

    List<Student> allStudents;

    Roster roster;

    @BeforeEach
    public void setUp()
    {
        john  = new Student("John");
        tom   = new Student("Tom");
        jay   = new Student("Jay");
        oscar = new Student("Oscar");

        allStudents = Arrays.asList(john, tom, jay, oscar);

        roster = new Roster(4, "CS 330");

        for (Student s : allStudents) {
            final boolean enrollResult = roster.enroll(s);
        }
    }

    @Test
    public void testNaiveSerialization()
        throws IOException
    {
        StringWriter sWriter = new StringWriter();
        BufferedWriter buffer = new BufferedWriter(sWriter);
        ExampleJSONWriter writer = new ExampleJSONWriter(roster, buffer);

        writer.demoNaiveSerialization();

        String resultJSON = sWriter.toString();

        // Check basics (e.g., content length)
        assertThat(resultJSON, is(not(nullValue())));
        assertThat(resultJSON.length(), is(greaterThan(0)));

        // Check the actual content (e.g., content and order of content)
        assertThat(
            resultJSON,
            stringContainsInOrder(
                "CS 330",
                "4",
                john.toString(),
                tom.toString(),
                jay.toString(),
                oscar.toString()
            )
        );

        // I am not concerned about the labels (e.g., 'name') since
        // naiveSerialization uses the JSON library defaults
        /*
            # Reference Output
            {
              "courseNum":"CS 330",
              "enrollLimit":4,
              "students":[
                {
                  "name":"John"
                },
                {
                  "name":"Tom"
                },
                {
                  "name":"Jay"
                },
                {
                  "name":"Oscar"
                }
              ]
            }
        */
    }

    @Test
    public void testMapSerialization()
        throws IOException
    {
        StringWriter sWriter = new StringWriter();
        BufferedWriter buffer = new BufferedWriter(sWriter);
        ExampleJSONWriter writer = new ExampleJSONWriter(roster, buffer);

        writer.demoMapSerialization();

        String resultJSON = sWriter.toString();

        // Check basics (e.g., content length)
        assertThat(resultJSON, is(not(nullValue())));
        assertThat(resultJSON.length(), is(greaterThan(0)));

        // Check the actual content (e.g., content and order of content)
        assertThat(
            resultJSON,
            stringContainsInOrder(
                "CS 330",
                ":",
                "[",
                john.toString(),
                tom.toString(),
                jay.toString(),
                oscar.toString(),
                "]",
                "totalStudents",
                "4"
            )
        );

        /*
            # Reference Output
            {
              "CS 330":[
                "John",
                "Tom",
                "Jay",
                "Oscar"
              ],
              "totalStudents":4
            }
        */
    }

    @Test
    public void testMapSerializationNested()
        throws IOException
    {
        StringWriter sWriter = new StringWriter();
        BufferedWriter buffer = new BufferedWriter(sWriter);
        ExampleJSONWriter writer = new ExampleJSONWriter(roster, buffer);

        writer.demoMapSerializationNested();

        String resultJSON = sWriter.toString();

        // Check basics (e.g., content length)
        assertThat(resultJSON, is(not(nullValue())));
        assertThat(resultJSON.length(), is(greaterThan(0)));

        // Check the actual content (e.g., content and order of content)
        assertThat(
            resultJSON,
            stringContainsInOrder(
                "CS 330",
                ":",
                "[",
                "{",
                john.toString(),
                "4.0",
                "}",
                "{",
                tom.toString(),
                "4.0",
                "}",
                "{",
                jay.toString(),
                "4.0",
                "}",
                "{",
                oscar.toString(),
                "4.0",
                "}",
                "]",
                "totalStudents",
                "4"
            )
        );

        /*
            # Reference Output
            {
              "CS 330":[
                {
                  "name":"John",
                  "gpa":4.0
                },
                {
                  "name":"Tom",
                  "gpa":4.0
                },
                {
                  "name":"Jay",
                  "gpa":4.0
                },
                {
                  "name":"Oscar",
                  "gpa":4.0
                }
              ],
              "totalStudents":4
            }
        */
    }
}




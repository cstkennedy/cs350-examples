package edu.odu.cs.cs350.examples;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

public class Driver
{
    /**
     * Generate a small roster for demonstration.
     */
    public static Roster generateRoster()
    {
        Student john  = new Student("John");
        Student tom   = new Student("Tom");
        Student jay   = new Student("Jay");
        Student oscar = new Student("Oscar");

        Student[] allStudents = {john, tom, jay, oscar};

        Roster cs330 = new Roster(4, "CS 330");

        for (Student s : allStudents) {
            final boolean enrollResult = cs330.enroll(s);
        }

        return cs330;
    }

    public static void main(String... args)
        throws IOException
    {
        final Roster roster = generateRoster();
        ExampleJSONWriter writer = new ExampleJSONWriter(roster);

        writer.demoNaiveSerialization();
        System.out.println();
        writer.demoMapSerialization();
        writer.demoMapSerializationNested();
    }
}

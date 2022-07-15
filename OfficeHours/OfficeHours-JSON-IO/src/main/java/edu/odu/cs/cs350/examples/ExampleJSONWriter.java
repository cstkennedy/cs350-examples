package edu.odu.cs.cs350.examples;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import com.cedarsoftware.util.io.*;

class ExampleJSONWriter
{
    /**
     * Generate a small roster for testing.
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

    /**
     * Demonstrate naive serialization. By default every field is output using
     * the variable name.
     */
    public static void demoNaiveSerialization(Roster roster)
    {
        Map args = new HashMap<>();
        args.put(JsonWriter.PRETTY_PRINT, true); // Make the output human readable
        args.put(JsonWriter.TYPE, false); // Hide the type metadata (e.g., Student, Roster)

        String json = JsonWriter.objectToJson(roster, args);

        System.out.println(json);
    }

    /**
     * Demonstrate serialization using extracted data stored in a map.
     */
    public static void demoMapSerialization(Roster roster)
    {
        Map<String, Object> customMap = new HashMap<>();

        List<String> studentNames = new Vector<String>();
        for (Student stu : roster) {
            studentNames.add(stu.getName());
        }

        customMap.put(roster.getCourseNum(), studentNames);
        customMap.put("totalStudents", roster.numEnrolled());

        Map args = new HashMap<>();
        args.put(JsonWriter.PRETTY_PRINT, true); // Make the output human readable
        args.put(JsonWriter.TYPE, false); // Hide the type metadata (e.g., Student, Roster)

        String json = JsonWriter.objectToJson(customMap, args);

        System.out.println(json);
    }

    public static void main(String... args)
    {
        demoNaiveSerialization(generateRoster());
        System.out.println();
        demoMapSerialization(generateRoster());
    }
}

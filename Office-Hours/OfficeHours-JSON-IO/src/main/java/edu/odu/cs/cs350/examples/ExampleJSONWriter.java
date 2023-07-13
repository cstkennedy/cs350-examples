package edu.odu.cs.cs350.examples;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import com.cedarsoftware.util.io.*;

public class ExampleJSONWriter
{
    private Roster roster;
    private BufferedWriter destination;

    /**
     * Default constructor should never be used. "Disable" it by making it
     * private.
     */
    private ExampleJSONWriter()
    {

    }

    /**
     * If no destination is specified default to standard out (System.out).
     *
     * @param src roster to output
     */
    public ExampleJSONWriter(final Roster src)
    {
        this.roster = src;
        this.destination = new BufferedWriter(
            new OutputStreamWriter(System.out)
        );
    }

    /**
     * Output to a specified buffer.
     *
     * @param src roster to output
     * @param buffer location to which data is to be written
     */
    public ExampleJSONWriter(final Roster src, BufferedWriter buffer)
    {
        this.roster = src;
        this.destination = buffer;
    }

    /**
     * Return the roster (data source)
     */
    public Roster getSourceData()
    {
        return this.roster;
    }

    /**
     * Demonstrate naive serialization. By default every field is output using
     * the variable name.
     */
    public void demoNaiveSerialization()
        throws IOException
    {
        Map args = new HashMap<>();
        args.put(JsonWriter.PRETTY_PRINT, true); // Make the output human readable
        args.put(JsonWriter.TYPE, false); // Hide the type metadata (e.g., Student, Roster)

        String json = JsonWriter.objectToJson(roster, args);

        destination.write(json);
        destination.write("\n");
        destination.flush();
    }

    /**
     * Demonstrate serialization using extracted data stored in a map.
     */
    public void demoMapSerialization()
        throws IOException
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

        destination.write(json);
        destination.write("\n");
        destination.flush();
    }

    /**
     * Demonstrate nested serialization using extracted data stored in a map.
     */
    public void demoMapSerializationNested()
        throws IOException
    {
        Map<String, Object> outerLayer = new HashMap<>();

        List<Object> studentEntries = new Vector<>();
        for (Student stu : roster) {
            Map<String, Object> studentEntry = new HashMap<>();

            studentEntry.put("name", stu.getName());
            studentEntry.put("gpa", 4.0);

            studentEntries.add(studentEntry);
        }

        outerLayer.put(roster.getCourseNum(), studentEntries);
        outerLayer.put("totalStudents", roster.numEnrolled());

        Map args = new HashMap<>();
        args.put(JsonWriter.PRETTY_PRINT, true); // Make the output human readable
        args.put(JsonWriter.TYPE, false); // Hide the type metadata (e.g., Student, Roster)

        String json = JsonWriter.objectToJson(outerLayer, args);

        destination.write(json);
        destination.write("\n");
        destination.flush();
    }
}

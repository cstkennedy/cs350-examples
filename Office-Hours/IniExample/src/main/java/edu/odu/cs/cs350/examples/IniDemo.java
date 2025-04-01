package edu.odu.cs.cs350.examples;

import java.util.Map;
import java.util.HashMap;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;

import org.ini4j.Ini;
import org.ini4j.ConfigParser;

/**
 * A demo of ini4j.
 *
 */
public class IniDemo
{
    public static void main(String... args)
        throws IOException
    {
        String filename = args[0];

        examineIniFile(filename);

        // Demo - Print a Map of retrieved settings
        Map<String, String> loadedSettings = loadIniFile(filename);

        for (Map.Entry<String, String> entry : loadedSettings.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Examine an Ini file by printing its sections and options.
     * <p>
     * This function is meant purely for testing and debugging purposes.
     *
     * @param configFilename ini file name (with relative path)
     *
     * @throws IOExecption if the ini file could not be opened
     */
    public static void examineIniFile(String configFilename)
        throws IOException
    {
        ConfigParser iniFile = new ConfigParser();
        iniFile.read(new FileReader(configFilename));

        System.err.println("Ini File Sections:");

        for (String section : iniFile.sections()) {
            System.err.printf("  %s%n", section);
        }

        System.err.println();
        System.err.println("Ini File Options:");

        for (String section : iniFile.sections()) {
            System.err.printf("  %s%n", section);
            try {
                for (String option : iniFile.options(section)) {
                    System.err.printf("    %s%n", option);
                }
            }
            catch (org.ini4j.ConfigParser.NoSectionException exc) {
                // The section does not exist (i.e., something weent wrong and I
                // should handle it.
            }
        }
    }

    /**
     * Load an Ini file as a set of String (name) to String (value) pairs.
     *
     * @param configFilename ini file name (with relative path)
     *
     * @return setting name -> value map/pairs
     *
     * @throws IOException if the ini file could not be opened
     */
    public static Map<String, String> loadIniFile(String configFilename)
        throws IOException
    {
        Ini iniFile = new Ini();
        iniFile.load(new FileReader(configFilename));

        Map<String, String> loadedSettings = new HashMap<String, String>();

        loadedSettings.put("PopCap", iniFile.get("mutant", "populationCap"));
        // int populationCap = Integer.parseInt(ini.get("populationCap"));

        return loadedSettings;
    }
}

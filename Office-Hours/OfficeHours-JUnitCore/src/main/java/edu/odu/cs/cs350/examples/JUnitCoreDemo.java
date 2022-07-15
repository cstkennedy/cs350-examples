package edu.odu.cs.cs350.examples;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import java.io.OutputStream;
// import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Request;
import org.junit.runner.notification.Failure;

import java.util.Arrays;
import java.util.List;

/**
 * This class is a quick demonstration of how to compile a simple Java Program
 * using the javax library.
 */
class JUnitCoreDemo {

    public static final String ARG_ERR_1 = "At least one class file and fully "
                                         + "qualified class name must be"
                                         + "supplied";

    public static final String ARG_ERR_2 = "Each class file must have a fully "
                                         + "accompanying fully qualified class"
                                         + "name";
    /**
     * Java main function.
     *
     * @param args command line arguments. By convention this is usually "args"
     *        in Java.
     */
    public static void main(String... args)
        throws MalformedURLException, ClassNotFoundException
    {
        if (args.length < 2) {
            throw new IllegalArgumentException(ARG_ERR_1);
        }

        if (args.length % 2 != 0) {
            throw new IllegalArgumentException(ARG_ERR_2);
        }

        List<Class> classesToTest = loadClassAndTestClass(args);

        List<String> testsToRun = Arrays.asList("testClone",
                                                "testString",
                                                "testEquals",
                                                "testNext",
                                                "testDefaultConstructor");


        runJUnitTests(classesToTest.get(1), testsToRun);
    }

    /**
     * Take a file and determine the full absolute path.
     *
     * @param fullPath file path to split
     *
     * @return full absolute filepath
     */
    public static Path getAbsolutePath(String fullPath)
    {
        File theFile = new File(fullPath);

        return theFile.getAbsoluteFile().toPath();
    }

    /**
     * Load a Class and its associated Test Class.
     *
     * @param args forwarded command line arguments
     */
     public static List<Class> loadClassAndTestClass(String... args)
        throws MalformedURLException, ClassNotFoundException
     {
        // Assume 4 arguments...
        //   - main class directory, main class name,
        //   - test class directory, test class name

        String mainClassDir = "file:///" + getAbsolutePath(args[0]) + "/";
        String mainClassName = args[1];

        String testClassDir = "file:///" + getAbsolutePath(args[2]) + "/";
        String testClassName = args[3];

        Class mainClass = loadClass(mainClassDir, mainClassName);
        Class testClass = loadClass(testClassDir, testClassName);

        return Arrays.asList(mainClass, testClass);
    }

    /**
     * Load a single Class.
     *
     * @param classDir full path to a directory containing dot class file
     * @param className fully qualified class name
     */
     public static Class loadClass(String classDir, String className)
        throws MalformedURLException, ClassNotFoundException
     {

        URL[] classURLs = new URL[]{new URL(classDir)};
        URLClassLoader classLoader = new URLClassLoader(classURLs);

        System.err.printf("Loading '%s' from '%s'%n", className, classDir);

        Class aClass = classLoader.loadClass(className);

        return aClass;
    }

    /**
     * Run a JUnit Test
     *
     * @param testClass JUnit Test class to run
     * @param testNames one or more test methods to run
     *
     */
    public static void runJUnitTests(Class testClass, List<String> testNames)
    {
        for (String aTestName: testNames) {
            Request request = Request.method(testClass, aTestName);
            Result result = new JUnitCore().run(request);

            boolean testPassed = result.wasSuccessful();


            if (testPassed) {
                System.out.println(aTestName + ": OK");
            }
            else {
                System.out.println(aTestName + ": Failed");

                for (Failure aFailure: result.getFailures()) {
                    System.out.println(aFailure);
                }
            }

            System.out.println();
        }
    }
}

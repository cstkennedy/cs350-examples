package edu.odu.cs.cs350.examples;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import java.io.OutputStream;
// import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;

/**
 * This class is a quick demonstration of how to compile a simple Java Program
 * using the javax library.
 */
class CompileSimpleProgram {
    /**
     * Java main function.
     *
     * @param args command line arguments. By convention this is usually "args"
     *        in Java.
     */
    public static void main(String... args)
    {
        if (args.length != 1) {
            throw new IllegalArgumentException("Exactly one Java source file must be supplied");
        }

        String sourceFilePath = args[0];

        if (compileProgram(sourceFilePath) != 0) {
            System.out.println("Compilation Failed");
            System.exit(1);
        }

        System.out.printf("Compilation Succeeded for %s%n",
                          getAbsolutePath(sourceFilePath));
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
     * Compile a single simple (single source file) Java program.
     *
     * @param sourceFilePath Path to Java source file to compile
     *
     * @return 0 if compilation was successfull, not 0 on failure
     */
    public static int compileProgram(String sourceFilePath)
    {
        Path absolutePath = getAbsolutePath(sourceFilePath);

        return compileProgram(absolutePath.toString(), null, null);
    }

    /**
     * Compile a single simple (single source file) Java program.
     *
     * @param absolutePath absolute path to file to complile
     * @param outStream destination for all "standard out" output
     * @param errStream destination for all "standard error" output
     *
     * @return 0 if compilation was successfull, not 0 on failure
     */
    public static int compileProgram(String absolutePath,
                                     OutputStream outStream,
                                     OutputStream errStream)
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int result = compiler.run(null, outStream, errStream, absolutePath);

        return result;
    }

}

package edu.odu.cs.cs350.examples;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryDriver
{
    public static void main(String[] args)
        throws IOException
    {
        Path pathToExamine = Paths.get(args[0]);
        System.out.println(pathToExamine);

        SimpleDirectoryWalker wlkr = new SimpleDirectoryWalker(pathToExamine);
        wlkr.examineDirectory();

        System.out.println("Files Identified:");
        for (Path file : wlkr.getFileList()) {
            System.out.format("  - %s%n", file);
        }
        System.out.println();

        System.out.println("Directories Identified:");
        for (Path file : wlkr.getDirectoryList()) {
            System.out.format("  - %s%n", file);
        }
    }
}

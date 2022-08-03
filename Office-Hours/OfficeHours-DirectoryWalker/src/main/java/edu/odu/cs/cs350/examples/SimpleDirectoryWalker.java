package edu.odu.cs.cs350.examples;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class SimpleDirectoryWalker
{
    Path directoryToExamine;

    List<Path> allFiles;
    List<Path> allDirectories;

    /**
     * Create a simple Directory Walker that records all directories and files.
     *
     * @param thePath directory to examine
     */
    public SimpleDirectoryWalker(Path thePath)
    {
        this.directoryToExamine = thePath;

        this.allFiles = new ArrayList<>();
        this.allDirectories = new ArrayList<>();
    }

    /**
     * Examine this SimpleDirectoryWalker's specified directory of interest.
     *
     * @thorws IOException if directory could not be read
     */
    public void examineDirectory()
        throws IOException
    {
        Files.walk(this.directoryToExamine)
            .forEach((Path path) -> {
                if (Files.isRegularFile(path)) {
                    this.allFiles.add(path);
                }
                else if (Files.isDirectory(path)) {
                    this.allDirectories.add(path);
                }
            });
    }

    /**
     * Retrieve the list of identified files.
     */
    public List<Path> getFileList()
    {
        return this.allFiles;
    }

    /**
     * Retrieve the list of identified directories.
     */
    public List<Path> getDirectoryList()
    {
        return this.allDirectories;
    }

}

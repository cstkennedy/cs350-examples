package edu.odu.cs.cs350.examples;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demonstrate how to set up input logic
 * to allow for testing without System.in
 */
class InputReader
{
    /**
     * This is a main function
     */
    public static void main(String[] args)
    throws IOException
    {
        BufferedReader bReader = null;

        // If in main
        bReader = new BufferedReader(new InputStreamReader(System.in));

        // If in unit test
        String testInput = "<NER>hello</NER>\n<NER>block2</NER>\n";
        //bReader = new BufferedReader(new StringReader(testInput));

        // Remaining logic that works with input
        ArrayList<String>  blocks = readBlocks(bReader);

        // Do something with each block
        for (String block : blocks) {
            System.out.println(block);
        }
    }

    /**
     * Read a set of input blocks
     *
     * Note that for the sake of this example 
     * I am making the assumption that each
     * line is one block
     */
    public static ArrayList<String> readBlocks(BufferedReader bReader)
    throws IOException
    {
        ArrayList<String> blocks = new ArrayList<String>();

        String line = null;

        /*
        line = bReader.readLine();

        while(line != null) {          
            blocks.add(line);

            line = bReader.readLine();
        }
        */

        Scanner s = new Scanner(bReader);

        while(s.hasNext()) {
            String str = s.next();

            blocks.add(str);
        }
        return blocks;
    }


}
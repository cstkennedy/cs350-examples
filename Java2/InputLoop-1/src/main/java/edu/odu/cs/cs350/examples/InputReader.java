package edu.odu.cs.cs350.examples;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Demonstrate how to set up input logic
 * to allow for testing without System.in
 */
class InputReader
{
    /**
     * This is a main function.
     * <p>
     * Top-down Design (which you should recall from CS 250)
     * states that the main function does next-to-no work
     * other than maintaining variables and calling other functions.
     *
     * I amend this rule to include basic input validation
     */
    public static void main(String[] args)
    throws IOException
    {
        BufferedReader bReader = null;

        // If in main
        //bReader = selectReaderSource(null);

        // If in unit test
        String testInput = "<NER>\n"
                         + "Thomas J Kennedy likes Oatmeal raisin cookies!\n"
                         + "</NER>\n"
                         + "<NER>\n"
                         + "Jay Morris likes pizza... and pointers to pizza.\n"
                         + "</NER>\n";

        bReader = selectReaderSource(testInput);

        // Remaining logic that works with input
        List<String> tokens = readTokens(bReader);

        System.out.println("Print one Token per line:");

        for (String token : tokens) {
            System.out.println("  -> " + token);
        }

        List<String> pruned = tokensWithTagsRemoved(tokens);

        System.out.println();
        System.out.println("Print one Pruned Token per line:");

        for (String token : pruned) {
            System.out.println("  -> " + token);
        }
    }

    /**
     * Set up the Input. If a non-null and non-empty String is passed in
     * create a BufferedReader around the String. Otherwise create a
     * BufferedReader around System.in
     */
    public static BufferedReader selectReaderSource(String sourceStr)
    {
        if (sourceStr == null || sourceStr.isEmpty()) {
            return new BufferedReader(new InputStreamReader(System.in));
        }

        return new BufferedReader(new StringReader(sourceStr));
    }

    /**
     * Read a set of input tokens.
     */
    public static List<String> readTokens(BufferedReader bReader)
    throws IOException
    {
        List<String> tokens = new ArrayList<String>();

        Scanner s = new Scanner(bReader);

        while (s.hasNext()) {
            String str = s.next();

            tokens.add(str);
        }
        return tokens;
    }

    /**
     * Identify whether a token is an HTML or XML style tag.
     *
     * @param token string to process
     *
     * @return true if the token is an HTML or XML style tag
     */
    public static boolean isTag(String token)
    {
        return token.startsWith("<")
            && token.endsWith(">");
    }

    /**
     * Return a list pruned of all HTML/XML style tag tokens.
     *
     * @param tokens token list to prune
     *
     * @return list of tokens without tags
     */
    public static List<String> tokensWithTagsRemoved(List<String> tokens)
    {
        List<String> pruned = new LinkedList<String>();

        for (String token : tokens) {
            if (!isTag(token)) {
                pruned.add(token);
            }
        }

        return pruned;
    }
}

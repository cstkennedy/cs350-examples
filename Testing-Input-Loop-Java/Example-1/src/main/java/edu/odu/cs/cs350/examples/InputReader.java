package edu.odu.cs.cs350.examples;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

/**
 * Demonstrate how to set up input logic to allow for testing without
 * System.in.
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
     * I often amend this rule to include basic input validation
     */
    public static void main(String[] args)
        throws IOException
    {
        //----------------------------------------------------------------------
        // If in main
        //----------------------------------------------------------------------
        // BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        //----------------------------------------------------------------------
        // If in unit test
        //----------------------------------------------------------------------
        final String testInput = String.join(
            System.lineSeparator(),
            "<NER>",
             "Thomas J Kennedy likes Oatmeal raisin cookies!",
             "</NER>",
             "<NER>",
             "Jay Morris likes pizza... and pointers to pizza.",
             "</NER>"
        );

        final BufferedReader bReader = new BufferedReader(new StringReader(testInput));

        //----------------------------------------------------------------------
        // Remaining logic that works with input
        //----------------------------------------------------------------------
        final List<String> tokens = readTokens(bReader);

        System.out.println("Print one Token per line:");

        for (final String token : tokens) {
            System.out.printf("  -> %s%n", token);
        }

        final List<String> pruned = tokensWithTagsRemoved(tokens);

        System.out.println();
        System.out.println("Print one Pruned Token per line:");

        for (final String token : pruned) {
            System.out.printf("  -> %s%n", token);
        }
    }

    /**
     * Read a set of input tokens.
     */
    public static List<String> readTokens(BufferedReader bReader)
    throws IOException
    {
        List<String> tokens = new ArrayList<>();

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
        // return token.startsWith("<")
        //     && token.endsWith(">");

        return token.matches("^\\s*<.*>\\s*$");
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
        return tokens.stream()
            .filter(token -> !isTag(token))
            .collect(toList());
    }
}

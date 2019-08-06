package edu.odu.cs.cs350.examples;

import edu.odu.cs.extract.wordlists.WordLists;

import java.util.List;
import java.util.ArrayList;
// import java.util.Iterator;

// import java.util.Set;
// import java.util.HashSet;

class WordListDemo
{
    public static void main(String[] args)
    {
        List<String> myWords = new ArrayList<String>();

        // Stop list
        for (String word : WordLists.stoplist()) {
            myWords.add(word);
            System.out.println(word);
        }

        for (String word : WordLists.englishDictionary()) {
            myWords.add(word);
            System.out.println(word);
        }
    }
}

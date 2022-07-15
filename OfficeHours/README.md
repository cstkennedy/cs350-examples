Title: Reviews CS 350
Author: Thomas J. Kennedy
TOC: yes
---

# Java: An Overview

This is a collection of short (20 to 30) minute Java discussions. The focus of
these examples and discussions is to provide an overview of Java. I expect that
you will have questions. Based on emails and office hours I will add additional
examples as we move through the semester.

## Java 1

  * Example 1 - An example of reading keyboard input using the Java `Scanner`
    class.
  * Example 2 - An example in which the Fibonacci Sequence is computed. This
    example includes C++ and Java examples. Note the Python 3 example is
    included for comparison. You will not be tested on Python.
  * Example 3 - An example of a CS 250 level Objected Oriented Program in Java
    (instead of C++).

    - This includes a brief discussion of Gradle and JUnit as topics of
      interest.
    - Gradle and JUnit are topics that we will discuss later in CS 350.
      - If you are truly curious you can jump ahead to the JUnit, Gradle and
        JUnit 2 reviews.

Part 1 of the discussion (Examples 1 and 2) is available
[here](https://youtu.be/tpB1wh5pt5Y) and Part 2 (Example 3) is available
[here](https://youtu.be/gpQZYIh4nhE).

All source code is available in \ExampleZip{Java1.zip}.


## Java 2: Buffered Reader & Top Down Design

This is a discussion of two examples, InputLoop1 and InputLoop2.

The discussion is available [here](https://youtu.be/7rMMovu0YYk) All source
code is available in \ExampleZip{Java2.zip}.

---


# Writing JUnit Tests & TDD

## JUnit 1 - A Quick HTML Color Class

\bSidebar

If you are already familiar with the basics of JUnit (e.g., setting up test
suites and writing assertions) you may want to skip ahead to [JUnit
2](#junit-2).

\eSidebar

This is a recorded discussion of how to start a JUnit test suite and the
general approach to writing unit tests. The focus is on a relatively simple
`HTMLColor` class.

^^^[HTMLColor.java]
```java
package edu.odu.cs.cs350.examples;

public class HtmlColor {
    private int red;   ///< red color component [0,255]
    private int green; ///< green color component [0,255]
    private int blue;  ///< blue color component [0,255]

    /**
     * Construct an HTML Color with all
     * attributes set to 0 (i.e., black, #000000)
# Office Hour (and Recitation) Discusison Examples

This directory contains various pieces of example code generated through
discussions my office hours. Each example is available in a subdirectory which
contains example code, build.gradle, and gradlew scripts.

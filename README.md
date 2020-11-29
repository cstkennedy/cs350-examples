Title: Reviews CS 350
Author: Thomas J. Kennedy
TOC: yes

%define <\ExampleZip> <zipFile> {[zipFile](./zipFile)}

# Updates in Progress

I will be updating these reviews throughout the semester. Everything below this
point may be updated or replaced over the next few weeks.

---

# SSH Keys

This is a recorded review of the basics of SSH at the command line (i.e.,
directly using variants of the command `ssh user@host`).

> In my lecture I used `~/public_html` to create my webpage example. You will
> need to use `~/secure_html` when you reproduce the steps.

The recording is available [here](https://youtu.be/_0u6DVIBS9Q).


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
     */
    public HtmlColor()
    {
        //...
    }

    /**
     * Construct an HTML Color
     *
     * @param r red value
     * @param g green value
     * @param b blue value
     */
    public HtmlColor(int r, int g, int b)
    {
        //...
    }

    /**
     * Retrieve the red component
     */
    public int getRed()
    {
        return -1;
    }

    /**
     * Set the red component
     *
     * @param v new value
     *
     * @pre v >= 0 && v <= 255
     */
    public void setRed(int v)
    {

    }

    /**
     * Retrieve the green component
     */
    public int getGreen()
    {
        return -1;
    }

    /**
     * Set the green component
     *
     * @param v new value
     *
     * @pre v >= 0 && v <= 255
     */
    public void setGreen(int v)
    {

    }

    /**
     * Retrieve the blue component
     */
    public int getBlue()
    {
        return -1;
    }

    /**
     * Set the blue component
     *
     * @param v new value
     *
     * @pre v >= 0 && v <= 255
     */
    public void setBlue(int v)
    {

    }

    /**
     * Return a hashcode
     */
    public int hashCode()
    {
        return 0;
    }
}
```
^^^

The recording is available [here](https://youtu.be/Z5c3dU5R2Fk). The example
material code is available in \ExampleZip{JUnit.zip}


## JUnit 2

This is a recorded discussion of JUnit starting with a discussion of JUnit
assertion syntax (Part 1, Examples 1 and 2). The discussion is separated into 3
recordings:

  - [Part 1](https://youtu.be/U_XQFn2pSDM) (Examples 1 to 2)
  - [Part 2](https://youtu.be/fZFOz1DrEIc) (Examples 3 to 7)
  - [Part 3](https://youtu.be/bxqd13S9ySs) (Example 8)

The example material code is available in \ExampleZip{JUnit2.zip}


## JUnit 3 - A Less Cliché Example

This JUnit discussion focuses on the methodology of writing unit tests.

A working knowledge of test syntax (e.g. `assertTrue` and `assertThat` is
assumed). This discussion builds upon the [first](#junit1) and
[second](#junit2) discussions.

The recording is available [here](https://youtu.be/J0QBoWBOZwc). The code
examples are available in [this zip file](JUnit3.zip).

---

# Gradle

\bSidebar

**This Example is based on Gradle 4 and earlier. This will be updated shortly
for Gradle 5.6.1, with the new plugin syntax.**

\eSidebar

This is a recorded review of writing a basic _Gradle_ build file for a Java
application.

The recording of the Review Session is available
[here](https://youtu.be/9fxjPdbxb44).  The example material code is available
in \ExampleZip{Gradle.zip}



# Eclipse

This is a collection of reviews covering the use of Eclipse.

  - [Setting Up A Java Project](https://youtu.be/mprApCjZpFk)
  - [Setting Up SSH Keys and Cloning a Git Repo](https://youtu.be/PQf5vHyOomM)
  - [Working through](https://youtu.be/tq9DNLzC4-U) the [Git Practice Lab](doc:gitLab)
  - [Setting up a Java Project under Git](https://youtu.be/Z2kYyc_Tph8)


# Gradle 2

\bSidebar

**This Example is based on Gradle 4 and earlier. This will be updated shortly
for Gradle 5.6.1, with the new plugin syntax.**

\eSidebar

This is a recorded review of extending a basic _Gradle_ build file for a Java
application. The discussion covered 3 examples:

  - _Example 1_ - Add FindBugs, PMD, Jacoco, and Javadoc
     to a Gradle build.
  - _Example 2_ - Add Checkstyle to the Example 1 Gradle build.
  - _Example 3_ - Discuss the corrections made based on the
    Example 2 Checkstyle report


The recording of the Review Session is available
[here](https://youtu.be/D8Oc0KbnpPk).  The example material code is available
in \ExampleZip{Gradle2.zip}.

I placed the final example in a
[repository](https://forge350.cs.odu.edu/tkennedy/Gradle2-CI) on the CS 350
Forge. The commit history  shows the changes that occurred in each step.


# Gitlab and Continuous Integration

This is a recorded review of updating a Gradle Buildscript and configuring
Continuous integration in Gitlab. The example repository is available in the
[350 Forge](https://forge350.cs.odu.edu/tkennedy/Gradle2-CI).


The recording is available [here](https://youtu.be/HBMthLTuESg).
The example material code is available in \ExampleZip{Gradle2-CI.zip}.


## CI & Updating Gradle Version

If you are using Gradle 5.6.1 or newer, your `build.gradle` file requires a few
changes (if you based it on my earlier examples).

\bSidebar

**Due to a few minor technical issues, this video was recorded at 720p (instead
of 1080p).**

\eSidebar

The recorded review of me migrating from Gradle 3.x/4.x to 5.6.1 is available
at <https://youtu.be/Dqfz2Z3Rsq0>.

---

# Testing Code in Python 3 & Rust

This semester we have focused almost exclusively on Java and Java-centric
tools. However, TDD concepts and analysis tools, and build/configuration
systems are not unique to Java.

| **Java Tool**  | **Python 3 Tool**                            | **Rust Tool**                                                                          |
| :-----------   | :-----------------                           | :------------                                                                          |
| Javadoc        | Pydoc                                        | Rustdoc                                                                                |
| Gradle         | [Tox](https://tox.readthedocs.io/en/latest/) | [Cargo](https://doc.rust-lang.org/stable/cargo/reference/specifying-dependencies.html) |
| JUnit/Hamcrest | PyUnit/PyHamcrest | [`cargo test`](https://doc.rust-lang.org/stable/cargo/guide/tests.html?highlight=test#tests)/[hamcrest2](https://github.com/Valloric/hamcrest2-rust) |
| Jacoco         | [Coverage.py](https://coverage.readthedocs.io/en/v4.5.x/) | [`cargo tarpaulin`](https://crates.io/crates/cargo-tarpaulin) |
| PMD/Spotbugs   | Pylint/Pycodestyle | `cargo check`/`cargo fix`|

I recorded two quick (~40 minute) discussions of testing: one for Rust and one
for Python 3:

  1. The Python recording is available [here](https://youtu.be/4eUs22jULI0).
     The Example Code is located in [PythonShapes.zip](./PythonShapes.zip).
  2. The Rust recording is available [here](https://youtu.be/NcYwj8Sdxo0). The
     Example Code is located
     [here](https://git-community.cs.odu.edu/tkennedy/rust-shapes-examples).

---

# Office Hour (and Recitation) Discusison Examples

This section contains various pieces of example code generated through
discussions my office hours. Each example is available as a zip file which
contains the example code, build.gradle, and gradlew scripts.

  1. \ExampleZip{OfficeHours-WordList.zip}
  2. \ExampleZip{OfficeHours-WekaBasics.zip}
  2. \ExampleZip{OfficeHours-CompileSimpleJava.zip}
  2. \ExampleZip{OfficeHours-JUnitCore.zip}
  2. \ExampleZip{OfficeHours-IniExample.zip}

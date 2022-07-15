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

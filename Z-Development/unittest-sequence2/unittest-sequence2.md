Title: Unit Test Number Sequence - Part 2
Author: Thomas J. Kennedy
TOC: yes


# Overview & Additions

You will prepare an *updated* JUnit test suite, `TestNumberSequence` for the
provided *updated* `NumberSequence` ADT.

**What is new?** I added the four missing functions to `NumberSequence`:

  - `clone`
  - `equals`
  - `hashCode`
  - `iterator`


# What To Do...

## Applying TDD (Getting Started)

You have been provided an *updated* skeleton for the `NumberSequence` class
that *defines* and *documents* the ADT interface, but does not implement any
functions.

This follows the practice of Test Driven Development (TDD) in which you develop
your tests _before_ writing the code to be tested. Your continuous challenge
in TDD, is to design tests so that any complete & correct implementation will
pass.

In this context correct means: *any implementation that follows the rules
outlined in the supplied documentation*.


## Checking toString...

If you used `containsString` to check `toString` in your solution to part 1,
you should definitely consider using `stringContainsInOrder`. Consider:

```java
assertThat(fromOneByOne.toString(), containsString("1"));
assertThat(fromOneByOne.toString(), containsString("2"));
```

If I wanted to check that `"1"` appeared before `"2"` I would use

```java
assertThat(fromOneByOne.toString(),
           stringContainsInOrder(Arrays.asList("1", "2")));
```

to check for both *content* and *ordering*.


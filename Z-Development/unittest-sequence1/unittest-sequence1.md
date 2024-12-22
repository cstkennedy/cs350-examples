Title: Unit Test Number Sequence - Part 1
Author: Thomas J. Kennedy
TOC: yes

# What To Do...


## Applying TDD (Getting Started)

You have been provided a skeleton for the `NumberSequence` class that *defines*
and *documents* the ADT interface, but does not implement any
functions.

This follows the practice of Test Driven Development (TDD) in which you develop
your tests _before_ writing the code to be tested.  Your continuous challenge
in TDD, is to design tests so that any complete & correct implementation will
pass.

In this context correct means: *any implementation that follows the rules
outlined in the supplied documentation*. Let us take a quick peek at
the `NumberSequence.first()` method:

```java
    /**
     * Retrieve the first number in the sequence.
     *
     * @return first number as an `int`
     */
    public int first()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return 0; // this is a placeholder so that the code compiles.
    }
```

This function, according to the Javadoc documentation, retrieves the first
number in the sequence. How is is stored? **This is an implementation
question.** Our only concern is whether this function returns the expected first
number as an `int`. The implementation details are not relevant to writing the
test.

What about the `NumberSequence.toString()` method?

```java
    /**
     * List all all numbers generated thus far, in order.
     * <p>
     * <b>Any formatting is acceptable.</b>
     */
    @Override
    public String toString()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return "This is a placeholder so that the code compiles.";
    }
```

Suppose I have just finished generating the sequence `<-1, 2, 5, 8>`. Which of
the following outputs are valid?

      <-1, 2, 5, 8>

or

      -1 2 5 8

or

      -1 | 2 | 5 | 8

or

      -1
       2
       5
       8

**All of them!** The documentation states that all the generated numbers need
to be present in the output. Formatting is not a concern.


# Missing Functions...?

If you took CS 330 with me recently, you may recall the **Java Class
Checklist**. For this exercise, I have omitted:

  - `clone`
  - `equals`
  - `hashCode`
  - `iterator`

These will be in part 2.


    ```java
    /**
     * 1 - Does this piece of code perform the operations
     *     it was designed to perform?
     *
     * 2 - Does this piece of code do something it was not
     *     designed to perform?
     *
     * 1 Test per mutator
     */
    ```

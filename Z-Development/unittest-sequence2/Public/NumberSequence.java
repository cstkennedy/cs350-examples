package edu.odu.cs.cs350.numbers;

import java.util.Iterator;
import java.util.Arrays;


/**
 * Arithmetic sequence generator modeled after the Python 3 <code>range()</code>
 * function.
 * <p>
 * It is legal for sequences to be monotonically increasing
 * (e.g., 1, 2, 3, ...) or monotonically decreasing (e.g., -2, -4, -6, ...).
 *
 * @see <a href="https://docs.python.org/3/library/stdtypes.html#range">
 *          Python range() function documentation
 *      </a>
 *
 * @author Thomas J. Kennedy
 */
public class NumberSequence implements Cloneable, Iterable<Integer>
{

    /**
     * Initialize the Number Sequence:
     * <ul>
     *  <li> Set the start to 1.</li>
     *  <li> Set the step size to 1.</li>
     *  <li> Initialize number storage.</li>
     * </ul>
     *
     * The start, 1, is generated immediately
     */
    public NumberSequence()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.
    }

    /**
     * Initialize the Number Sequence and prepare to generate a set of numbers
     * from an arbitrary starting point, with an arbitrary step size.
     * <p>
     * The starting point and step size can me set to a negative integer,
     * positive integer, or zero.
     *
     * The start, aStart, is generated immediately.
     *
     * @param aStart starting number
     * @param aStep difference between each number and the next
     */
    public NumberSequence(int aStart, int aStep)
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.
    }

    /**
     * Generate the next number in the sequence.
     */
    public void next()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.
    }

    /**
     * Retrieve the first number in the sequence.
     *
     * @return first number as an `int`
     */
    public int first()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return 9001;
    }

    /**
     * Retrieve the difference between each adjacent pair of numbers (i.e., the
     * step size).
     *
     * @return step size
     */
    public int step()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return 9001;
    }

    /**
     * Get the last (most recently generated) number.
     *
     * @return current last number as an `int`
     */
    public int currentLast()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return 9001;
    }

    /**
     * Current length of the arithmetic sequence (i.e., how many numbers have
     * been generated).
     *
     * @return length of the sequence
     */
    public int length()
    {
        // Not yet implemented.
        // This is an exercise in writing tests, not implementation.

        return 9001;
    }

    /**
     * Create an identical copy of the Number Sequence, including all numbers
     * generated thus far.
     */
    @Override
    public Object clone()
    {
        return null;
    }

    /**
     * Check two NumberSequence objects for equivalence based purely on the
     * numbers generated thus far.
     */
    @Override
    public boolean equals(Object rhs)
    {
        return false;
    }

    /**
     * Compute a hash code based on the collection of numbers generated thus
     * far.
     */
    @Override
    public int hashCode()
    {
        return -1;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }

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
}

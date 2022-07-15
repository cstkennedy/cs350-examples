# JUnit 1 - A Quick HTML Color Class

> If you are already familiar with the basics of JUnit (e.g., setting up test
> suites and writing assertions) you may want to skip ahead to [JUnit
> 2](#junit-2).

This is a recorded discussion of how to start a JUnit test suite and the
general approach to writing unit tests. The focus is on a relatively simple
`HTMLColor` class.

<details>

<summary> *HTMLColor Class* </summary>

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

</details>

package edu.odu.cs.cs350.examples;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * 1 - Does this piece of code perform the operations 
 *     it was designed to perform?
 * 
 * 2 - Does this piece of code do something it was not 
 *     designed to perform?
 * 
 * 1 Test per mutator
 */
public class TestHtmlColor extends TestCase {
    private HtmlColor black;
    private HtmlColor white;
    private HtmlColor red;
    private HtmlColor green;
    private HtmlColor blue;
    private HtmlColor rColor;

    @Override
    protected void setUp()
    {
        black  = new HtmlColor();
        white  = new HtmlColor(255, 255, 255);
        red    = new HtmlColor(255, 0, 0);
        green  = new HtmlColor(0, 255, 0);
        blue   = new HtmlColor(0, 0, 255);
        rColor = new HtmlColor(7, 62, 55);
    }

    @Test
    public void testSetRed()
    {
        HtmlColor color = black.clone();

        color.setRed(100);

        assertEquals(color.getRed(), 100);
        assertEquals(color.getBlue(), 0);
        assertEquals(color.getGreen(), 0);
    }

    @Test
    public void testSetGreen()
    {
        HtmlColor color = blue.clone();

        color.setGreen(100);

        assertEquals(color.getRed(), 0);
        assertEquals(color.getBlue(), 255);
        assertEquals(color.getGreen(), 100);
    }

    @Test
    public void testSetBlue()
    {
        HtmlColor color = white.clone();

        color.setBlue(100);

        assertEquals(color.getRed(), 255);
        assertEquals(color.getBlue(), 100);
        assertEquals(color.getGreen(), 255);
    }

    @Test
    public void testSetRedWithHashCode()
    {
        HtmlColor color       = black.clone();

        color.setRed(100);

        assertEquals(color.getRed(), 100);
        assertEquals(color.getBlue(), 0);
        assertEquals(color.getGreen(), 0);

        assertNotEquals(black.hashCode(), color.hashCode());
    }
}
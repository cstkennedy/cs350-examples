package edu.odu.cs.cs350.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 1 - Does this piece of code perform the operations 
 *     it was designed to perform?
 * 
 * 2 - Does this piece of code do something it was not 
 *     designed to perform?
 * 
 * 1 Test per mutator
 */
public class TestHtmlColor {
    @Test
    public void testSetRed()
    {
        HtmlColor color = new HtmlColor();

        color.setRed(253);

        assertEquals(253, color.getRed());









        assertEquals(color.getBlue(), 0);
        assertEquals(color.getGreen(), 0);
    }

    @Test
    public void testSetGreen()
    {
        HtmlColor color = new HtmlColor();

        color.setGreen(100);

        assertEquals(color.getRed(), 0);
        assertEquals(color.getBlue(), 0);
        assertEquals(color.getGreen(), 100);
    }

    @Test
    public void testSetBlue()
    {
        HtmlColor color = new HtmlColor();

        color.setBlue(100);

        assertEquals(color.getRed(), 0);
        assertEquals(color.getBlue(), 100);
        assertEquals(color.getGreen(), 0);
    }

    @Test
    public void testSetRedWithHashCode()
    {
        HtmlColor color       = new HtmlColor();
        int       oldHashCode = color.hashCode();

        color.setRed(100);

        assertEquals(color.getRed(), 100);
        assertEquals(color.getBlue(), 0);
        assertEquals(color.getGreen(), 0);

        assertNotEquals(oldHashCode, color.hashCode());
    }
}
package edu.odu.cs.cs350.examples;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHtmlColor {
    @Test
    public void testSetRed()
    {
        HtmlColor color = new HtmlColor();

        color.setRed(100);

        assertEquals(color.getRed(), 100);
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
}
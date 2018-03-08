package edu.odu.cs.cs350.examples;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;

/**
 * 1 - Does this piece of code perform the operations 
 *     it was designed to perform?
 * 
 * 2 - Does this piece of code do something it was not 
 *     designed to perform?
 * 
 * 1 Test per mutator
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHtmlColor {
    private HtmlColor black;
    private HtmlColor white;
    private HtmlColor red;
    private HtmlColor green;
    private HtmlColor blue;
    private HtmlColor rColor;

    @Before
    public void setUp()
    {
        black  = new HtmlColor();
        white  = new HtmlColor(255, 255, 255);
        red    = new HtmlColor(255, 0, 0);
        green  = new HtmlColor(0, 255, 0);
        blue   = new HtmlColor(0, 0, 255);
        rColor = new HtmlColor(7, 62, 55);
    }

    @Test
    public void testDefaultConstructor()
    {
        HtmlColor color = new HtmlColor();

        assertEquals(0, color.getRed());
        assertEquals(0, color.getBlue());
        assertEquals(0, color.getGreen());

        assertEquals(black.hashCode(), color.hashCode());
        //System.out.println(color.toString());
        assertEquals("000000", color.toString());
    }

    @Test
    public void testNonDefaultConstructor()
    {
        HtmlColor color = new HtmlColor(7, 62, 55);

        assertEquals(7, color.getRed());
        assertEquals(62, color.getGreen());
        assertEquals(55, color.getBlue());
        
        assertEquals(rColor.hashCode(), color.hashCode());

        String base16String = String.format(
            "%02X%02X%02X",
            color.getRed(),
            color.getGreen(),
            color.getBlue()).toUpperCase();
        
        assertEquals(base16String, color.toString());
    }

    @Test
    public void testSetRed()
    {
        HtmlColor color = (HtmlColor) black.clone();
        int oldHashCode = color.hashCode();

        color.setRed(100);

        assertEquals(100, color.getRed());
        assertEquals(0, color.getBlue());
        assertEquals(0, color.getGreen());

        assertNotEquals(oldHashCode, color.hashCode());
    }

    @Test
    public void testSetGreen()
    {
        HtmlColor color = (HtmlColor) blue.clone();
        int oldHashCode = color.hashCode();

        color.setGreen(100);

        assertEquals(color.getRed(), 0);
        assertEquals(color.getBlue(), 255);
        assertEquals(color.getGreen(), 100);

        assertNotEquals(oldHashCode, color.hashCode());
    }

    @Test
    public void testSetBlue()
    {
        HtmlColor color = (HtmlColor) white.clone();
        int oldHashCode = color.hashCode();

        color.setBlue(100);

        assertEquals(color.getRed(), 255);
        assertEquals(color.getBlue(), 100);
        assertEquals(color.getGreen(), 255);

        assertNotEquals(oldHashCode, color.hashCode());
        //System.out.println(color.toString());
        //assertEquals("FF64FF", color.toString());
        assertEquals("FFFF64", color.toString());
    }
}
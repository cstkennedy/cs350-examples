package edu.odu.cs.cs350.examples;

public class HtmlColor implements Cloneable{
    private int red;   ///< red color component [0,255]
    private int green; ///< green color component [0,255]
    private int blue;  ///< blue color component [0,255]

    /**
     * Construct an HTML Color with all
     * attributes set to 0 (i.e., black, #000000)
     */
    public HtmlColor()
    {
        this.red   = 0;
        this.green = 0;
        this.blue  = 0;
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
        this.red   = r;
        this.green = g;
        this.blue  = b;
    }

    /**
     * Retrieve the red component
     */
    public int getRed()
    {
        return this.red;
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
        this.red = v;
    }

    /**
     * Retrieve the green component
     */
    public int getGreen()
    {
        return this.green;
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
        this.green = v;
    }

    /**
     * Retrieve the blue component
     */
    public int getBlue()
    {
        return this.blue;
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
        this.blue = v;
    }

    /**
     * Return a hashcode
     */
    public int hashCode()
    {
        return (2 * this.red) 
             + (4 * this.green)
             + (8 * this.blue);
    }

    /**
     * Return a (deep) copy of this object.
     */
    @Override
    public Object clone()
    {
        return new HtmlColor(this.red, this.green, this.blue);
    }

    /**
     *
     */
    public String toString()
    {
        return String.format("%02X%02X%02X", red, green, blue).toUpperCase();
    }

}
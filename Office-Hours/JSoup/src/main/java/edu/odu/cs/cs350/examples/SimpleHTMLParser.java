package edu.odu.cs.cs350.examples;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

/**
 * This is a Simple HTML Parser that takes an HTML tag and an attribute,
 * extracts all tags, then all URLs from the specified attribute.
 *
 * @author Thomas J. Kennedy
 */
public class SimpleHTMLParser
{
    private String theTag;
    private String theAttribute;

    /**
     * A default SimpleHTMLParser can not be created.
     */
    private SimpleHTMLParser()
    {

    }

    public SimpleHTMLParser(String tag, String attribute)
    {
        this.theTag = tag;
        this.theAttribute = attribute;
    }

    /**
     * Extract all HTML tags.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<Element> extractAllTags(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator()));

        return this.extractAllTags(htmlAsString);
    }

    /**
     * Extract all HTML tags.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<Element> extractAllTags(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.theTag);

        List<Element> elementList = new ArrayList<>();
        for (Element elm : elements) {
            elementList.add(elm);
        }

        return elementList;
    }

    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<String> extractAllURIs(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator()));

        return this.extractAllURIs(htmlAsString);
    }

    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<String> extractAllURIs(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.getJSoupSelector());

        List<String> elementList = new ArrayList<>();
        for (Element elm : elements) {
            elementList.add(elm.attr(this.theAttribute));
        }

        return elementList;
    }

    /**
     * Combine the specified tag and attribute for use in JSoup selector
     * syntax.
     *
     * @returns Jsoup style selector
     */
    public String getJSoupSelector()
    {
        return String.format("%s[%s]", this.theTag, this.theAttribute);
    }

}

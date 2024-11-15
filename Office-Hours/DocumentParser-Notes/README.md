# Purpose

Take an HTML file, extract all information (e.g., anchor tags), and store it in
an `HTMLDocument` object.


# Steps

  1. Pass an file path into `DocumentParser.parse`
  2. `DocumentParser.parse` invokes helper functions (e.g., `extractImages`).
  3. `DocumentParser.parse` returns a fully initialized `HTMLDocument` object.


# Draft Interface

```java
public class DocumentParser
{

    public HTMLDocument parse(Path thePath)
    {
        HTMLDocument doc = new HTMLDocument(thePath);

        // All the tag extraction and analysis through helper functions.

        return doc;
    }

    public void extractAnchors(HTMLDocument theDoc)
    {
    }

    public void extractImages(HTMLDocument theDoc)
    {
    }

    //...

}
```

# HTMLDocument & HTMLParser

  1. Create a new HTMLDocument object, passing a path into the constructor.
    `HTMLDocument doc = new HTMLDocument("a/directory/a.html");`

  2. Pass the HTMLDocument (i.e., `doc`) into the `DocumentParser`.

  3. `DocumentParser` extracts all HTML information (anchor tags, image tags,
     script tag, and link tags).

  4. The extracted information is processed and the results are stored in
     `HTMLDocument`.


























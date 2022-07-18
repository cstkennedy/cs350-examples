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
        return null;
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



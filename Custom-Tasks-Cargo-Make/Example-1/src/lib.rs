use dom_query::Document;

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
pub struct SimpleHTMLParser {
    tag: String,
    attribute: String,
}

impl SimpleHTMLParser {
    pub fn new(tag: &str, attribute: &str) -> Self {
        Self {
            tag: tag.to_owned(),
            attribute: attribute.to_owned(),
        }
    }

    /// Extract all HTML tags.
    pub fn extract_all_tags(self, html_source: &str) -> Vec<String> {
        let document = Document::from(html_source);

        let anchors = document.select(&self.tag);

        anchors
            .iter()
            .map(|el| el.html())
            .map(String::from)
            .collect()
    }

    /// Extract all URIs from HTML tags with the required attribute.
    pub fn extract_all_uris(self, html_source: &str) -> Vec<String> {
        let document = Document::from(html_source);

        let anchors = document.select(&self.tag);

        anchors
            .iter()
            .flat_map(|el| el.attr(&self.attribute))
            .map(String::from)
            .collect()
    }
}

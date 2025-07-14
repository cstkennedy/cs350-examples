from typing import TextIO

import bs4


class SimpleHTMLParser:
    """
    This is a Simple HTML Parser that takes an HTML tag and an attribute,
    extracts all tags, then all URLs from the specified attribute.
    """

    def __init__(self, *, tag: str, attribute: str) -> None:
        self.tag = tag
        self.attribute = attribute

    def extract_all_tags(self, html_source: TextIO) -> list[str]:
        """
        Extract all HTML tags.
        """

        soup = bs4.BeautifulSoup(html_source, "html.parser")

        return [str(elem) for elem in soup.find_all(self.tag)]

    def extract_all_uris(self, html_source: TextIO) -> list[str]:
        """
        Extract all URIs from HTML tags with the required attribute.
        """

        soup = bs4.BeautifulSoup(html_source, "html.parser")

        # fmt: off
        return [
            str(elem[self.attribute])
            for elem in soup.find_all(
                self.tag,
                {self.attribute: True}
            )
        ]
        # fmt: on

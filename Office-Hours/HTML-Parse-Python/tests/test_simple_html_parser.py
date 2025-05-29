import sys

from hamcrest import assert_that, equal_to, has_length, is_, not_none

from html_parser import SimpleHTMLParser


def test_extract_anchor():

    html_source = "<a href='https://www.google.com'>Google Search!</a>"

    simple = SimpleHTMLParser(tag="a", attribute="href")

    anchors = list(simple.extract_all_tags(html_source))
    print(anchors, file=sys.stderr)

    assert_that(anchors, is_(not_none()))
    assert_that(len(anchors), equal_to(1))
    assert_that(anchors, has_length(1))


def test_extract_uri():

    html_source = "<a href='https://www.google.com'>Google Search!</a>"

    simple = SimpleHTMLParser(tag="a", attribute="href")

    anchors = list(simple.extract_all_uris(html_source))
    print(anchors, file=sys.stderr)

    assert_that(anchors, is_(not_none()))
    assert_that(len(anchors), equal_to(1))
    assert_that(anchors, has_length(1))


def test_extract_anchors():

    simple = SimpleHTMLParser(tag="a", attribute="href")

    with open("resources/anchors.html") as html_source:
        anchors = list(simple.extract_all_tags(html_source))

    print(anchors, file=sys.stderr)

    assert_that(anchors, is_(not_none()))
    assert_that(len(anchors), equal_to(2))
    assert_that(anchors, has_length(2))


def test_extract_uris():

    simple = SimpleHTMLParser(tag="a", attribute="href")

    with open("resources/anchors.html") as html_source:
        anchors = list(simple.extract_all_uris(html_source))

    print(anchors, file=sys.stderr)

    assert_that(anchors, is_(not_none()))
    assert_that(len(anchors), equal_to(2))
    assert_that(anchors, has_length(2))

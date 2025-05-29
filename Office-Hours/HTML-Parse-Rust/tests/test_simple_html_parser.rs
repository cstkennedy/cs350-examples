use std::fs::File;
use std::io::{BufReader, Read};

use eyre::{self};

use hamcrest2::prelude::*;
use rstest::{fixture, rstest};

use simple_html_parser::SimpleHTMLParser;

#[fixture]
fn large_html_source() -> eyre::Result<String> {
    let mut reader = BufReader::new(File::open("resources/anchors.html")?);

    let mut html_source = String::new();
    _ = reader.read_to_string(&mut html_source);

    Ok(html_source)
}

#[rstest]
pub fn test_extract_anchor() {
    let html_source = "<a href='https://www.google.com'>Google Search!</a>";

    let simple = SimpleHTMLParser::new("a", "href");

    let anchors = simple.extract_all_tags(html_source);
    eprintln!("{:?}", anchors);

    assert_that!(anchors.len(), equal_to(1));
    assert_that!(&anchors, len(1));
}

#[rstest]
pub fn test_extract_uri() {
    let html_source = "<a href='https://www.google.com'>Google Search!</a>";

    let simple = SimpleHTMLParser::new("a", "href");

    let anchors = simple.extract_all_uris(html_source);
    eprintln!("{:?}", anchors);

    assert_that!(anchors.len(), equal_to(1));
    assert_that!(&anchors, len(1));
}

#[rstest]
pub fn test_extract_anchors(large_html_source: eyre::Result<String>) {
    let html_source = large_html_source.unwrap();

    let simple = SimpleHTMLParser::new("a", "href");

    let anchors = simple.extract_all_tags(&html_source);
    eprintln!("{:?}", anchors);

    assert_that!(anchors.len(), equal_to(2));
    assert_that!(&anchors, len(2));
}

#[rstest]
pub fn test_extract_uris(large_html_source: eyre::Result<String>) {
    let html_source = large_html_source.unwrap();

    let simple = SimpleHTMLParser::new("a", "href");

    let anchors = simple.extract_all_uris(&html_source);
    eprintln!("{:?}", anchors);

    assert_that!(anchors.len(), equal_to(2));
    assert_that!(&anchors, len(2));
}

use std::io::{self, BufRead, BufReader};

use regex::Regex;

///
/// Read a set of input tokens.
///
pub fn read_tokens<R>(b_reader: R) -> Vec<String>
where
    R: BufRead,
{
    b_reader
        .lines()
        .flatten()
        .map(|line| {
            line.split_whitespace()
                .map(String::from)
                .collect::<Vec<_>>()
        })
        .flatten()
        .collect()
}

///
/// Identify whether a token is an HTML or XML style tag.
///
pub fn is_tag(token: &str) -> bool {
    let re = Regex::new("^\\s*<.*>\\s*$").unwrap();

    if let Some(_) = re.captures(&token) {
        true
    } else {
        false
    }
}

///
/// Return a list pruned of all HTML/XML style tag tokens.
///
pub fn tokens_with_tags_removed<I>(tokens: I) -> Vec<String>
where
    I: IntoIterator<Item = String>,
{
    tokens.into_iter().filter(|token| !is_tag(&token)).collect()
}

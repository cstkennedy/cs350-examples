use std::io::{self, BufRead, BufReader};

use regex::Regex;

///
/// Demonstrate how to set up input logic to allow for testing without
/// System.in.
///
///
/// This is a main function.
/// <p>
/// Top-down Design (which you should recall from CS 250)
/// states that the main function does next-to-no work
/// other than maintaining variables and calling other functions.
///
/// I often amend this rule to include basic input validation
///
fn main() {
    //----------------------------------------------------------------------
    // If in main
    //----------------------------------------------------------------------
    // let b_reader = BufReader::new(std::io::stdin());

    //----------------------------------------------------------------------
    // If in unit test
    //----------------------------------------------------------------------
    let test_input: String = [
        "<NER>",
        "Thomas J Kennedy likes Oatmeal raisin cookies!",
        "</NER>",
        "<NER>",
        "Jay Morris likes pizza... and pointers to pizza.",
        "</NER>",
    ]
    .join("\n");

    let b_reader = BufReader::new(test_input.as_bytes());

    //----------------------------------------------------------------------
    // Remaining logic that works with input
    //----------------------------------------------------------------------
    let tokens = read_tokens(b_reader);

    println!("Print one Token per line:");

    for token in tokens.iter() {
        println!("  -> {token}");
    }

    let pruned = tokens_with_tags_removed(tokens);

    println!();
    println!("Print one Pruned Token per line:");

    for token in pruned.iter() {
        println!("  -> {token}");
    }
}

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

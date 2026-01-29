use std::io::{self, BufRead, BufReader};

use input_loop::*;

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
    let b_reader = BufReader::new(std::io::stdin());

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

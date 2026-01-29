use std::io::BufReader;

use hamcrest2::prelude::*;
use rstest::*;

use input_loop::*;

const TEST_INPUT: &str = r#"
<NER>
Thomas J Kennedy likes Oatmeal raisin cookies!
</NER>
<NER>
Jay Morris likes pizza... and pointers to pizza.
</NER>
"#;

#[rstest]
pub fn test_tokens_with_tags_removed() {
    let raw_tokens = [
        "<NER>", "Thomas", "J", "Kennedy", "likes", "Oatmeal", "raisin", "cookies!", "</NER>",
        "<NER>", "Jay", "Morris", "likes", "pizza...", "and", "pointers", "to", "pizza.", "</NER>",
    ]
    .into_iter()
    .map(String::from)
    .collect::<Vec<_>>();

    let expected_pruned_tokens = [
        "Thomas", "J", "Kennedy", "likes", "Oatmeal", "raisin", "cookies!", "Jay", "Morris",
        "likes", "pizza...", "and", "pointers", "to", "pizza.",
    ]
    .into_iter()
    .map(String::from)
    .collect::<Vec<_>>();

    assert_that!(
        tokens_with_tags_removed(raw_tokens),
        is(equal_to(expected_pruned_tokens))
    )
}

#[rstest]
pub fn test_read_tokens() {
    let expected_raw_tokens = [
        "<NER>", "Thomas", "J", "Kennedy", "likes", "Oatmeal", "raisin", "cookies!", "</NER>",
        "<NER>", "Jay", "Morris", "likes", "pizza...", "and", "pointers", "to", "pizza.", "</NER>",
    ]
    .into_iter()
    .map(String::from)
    .collect::<Vec<_>>();

    let b_reader = BufReader::new(TEST_INPUT.as_bytes());
    let actual_tokens = read_tokens(b_reader);

    assert_that!(actual_tokens, is(equal_to(expected_raw_tokens)))
}

#[rstest]
#[case::OpeningTag("<NER>")]
#[case::ClosingTag("</NER>")]
pub fn test_is_tag(#[case] token: &str) {
    assert!(is_tag(token));
}

#[rstest]
#[case(" ")]
#[case("<")]
#[case(">")]
#[case("Cookies")]
pub fn test_is_not_tag(#[case] token: &str) {
    assert!(!is_tag(token));
}

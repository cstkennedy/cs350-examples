"""
Demonstrate how to set up input logic to allow for testing without
System.in.
"""

import re
import sys
from io import StringIO
from typing import Generator, Iterable, TextIO


def main() -> None:
    """
    This is a main function.
    <p>
    Top-down Design (which you should recall from CS 250)
    states that the main function does next-to-no work
    other than maintaining variables and calling other functions.

    I often amend this rule to include basic input validation
    """

    # --------------------------------------------------------------------------
    # If in main
    # --------------------------------------------------------------------------
    #  b_reader = sys.stdin

    # --------------------------------------------------------------------------
    # If in unit test
    # --------------------------------------------------------------------------
    test_input = "\n".join(
        (
            "<NER>",
            "Thomas J Kennedy likes Oatmeal raisin cookies!",
            "</NER>",
            "<NER>",
            "Jay Morris likes pizza... and pointers to pizza.",
            "</NER>",
        )
    )

    b_reader = StringIO(test_input)

    # --------------------------------------------------------------------------
    #  Remaining logic that works with input
    # --------------------------------------------------------------------------
    tokens = list(read_tokens(b_reader))

    print("Print one Token per line:")

    for token in tokens:
        print(f"  -> {token}")

    pruned = tokens_with_tags_removed(tokens)

    print()
    print("Print one Pruned Token per line:")

    for token in pruned:
        print(f"  -> {token}")


def read_tokens(b_reader: TextIO) -> Generator[str, None, None]:
    """
    Read a set of input tokens.
    """

    for line in b_reader:
        for token in line.split():
            yield token


def is_tag(token: str) -> bool:
    """
    Identify whether a token is an HTML or XML style tag.
    """
    re_pattern = re.compile("^\\s*<.*>\\s*$")

    if _ := re_pattern.match(token):
        return True

    return False


def tokens_with_tags_removed(
    tokens: Iterable[str],
) -> Generator[str, None, None]:
    """
    Return a list pruned of all HTML/XML style tag tokens.
    """

    for token in tokens:
        if is_tag(token):
            continue

        yield token


if __name__ == "__main__":
    main()

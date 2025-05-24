import os

from hamcrest import assert_that, equal_to


def test_relative_path() -> None:
    path = os.path.join("resources", "testProgram1", "KeyboardInput.java")

    with open(path, "r") as a_file:
        first_line = a_file.readline()
        assert_that(first_line, equal_to("import java.util.Scanner;"))

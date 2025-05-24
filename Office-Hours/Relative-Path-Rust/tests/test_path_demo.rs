use std::fs::File;
use std::io::BufReader;
use std::io::prelude::*;
use std::path::PathBuf;

use hamcrest2::prelude::*;
use rstest::*;

#[rstest]
pub fn test_relative_path() {
    let path: PathBuf = ["resources", "testProgram1", "KeyboardInput.java"]
        .iter()
        .collect();

    let first_line = {
        let file = File::open(path).unwrap();
        let mut reader = BufReader::new(file);

        let mut line = String::new();
        reader.read_line(&mut line).unwrap();

        line
    };

    assert_that!(first_line, equal_to("import java.util.Scanner;"));
}

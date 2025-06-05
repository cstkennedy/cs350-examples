use std::env;
use std::fs;
use std::path::Path;


const SCRIPT_CONTENT: &str =
r#"#! /usr/bin/env bash

echo "Rust is a fun programming language"
"#;

fn main() {
    let out_dir = env::var_os("OUT_DIR").unwrap();
    let dest_path = Path::new(&out_dir).join("desiredName.sh");
    fs::write(
        dest_path,
        &SCRIPT_CONTENT
    ).unwrap();
    println!("cargo::rerun-if-changed=build.rs");
}

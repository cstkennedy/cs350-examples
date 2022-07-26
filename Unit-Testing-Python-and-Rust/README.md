# Testing Code in Python 3 & Rust

This semester we have focused almost exclusively on Java and Java-centric
tools. However, TDD concepts and analysis tools, and build/configuration
systems are not unique to Java.

| **Java Tool**  | **Python 3 Tool**                            | **Rust Tool**                                                                          |
| :-----------   | :-----------------                           | :------------                                                                          |
| Javadoc        | Pydoc                                        | Rustdoc                                                                                |
| Gradle         | [Tox](https://tox.readthedocs.io/en/latest/) | [Cargo](https://doc.rust-lang.org/stable/cargo/reference/specifying-dependencies.html) |
| JUnit/Hamcrest | PyUnit/PyHamcrest | [`cargo test`](https://doc.rust-lang.org/stable/cargo/guide/tests.html?highlight=test#tests)/[hamcrest2](https://github.com/Valloric/hamcrest2-rust) |
| Jacoco         | [Coverage.py](https://coverage.readthedocs.io/en/v4.5.x/) | [`cargo tarpaulin`](https://crates.io/crates/cargo-tarpaulin) |
| PMD/Spotbugs   | Pylint/Pycodestyle | `cargo check`/`cargo fix`|

I recorded two quick (~40 minute) discussions of testing: one for Rust and one
for Python 3:

  1. The Python recording is available [here](https://youtu.be/4eUs22jULI0).
     The Example Code is located [here](https://github.com/cstkennedy/cs330-examples/tree/master/Review-06-Python3-Shapes).
  2. The Rust recording is available [here](https://youtu.be/NcYwj8Sdxo0). The
     Example Code is located
     [here](https://github.com/cstkennedy/rust-shapes-examples).

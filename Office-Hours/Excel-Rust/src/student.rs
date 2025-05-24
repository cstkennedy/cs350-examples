use std::fmt;

const DEFAULT_NAME: &'static str = "John Q. Smith";

#[derive(Debug, Hash, Eq, PartialEq, Clone)]
pub struct Student {
    pub name: String,
}

impl Default for Student {
    fn default() -> Self {
        Student {
            name: DEFAULT_NAME.to_owned(),
        }
    }
}

impl Student {
    pub fn new<'a>(nme: &'a str) -> Self {
        Student {
            name: nme.to_owned(),
        }
    }
}

impl fmt::Display for Student {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{}", self.name)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use hamcrest2::prelude::*;

    #[test]
    fn test_default() {
        let student = Student::default();

        assert_that!(&student.name, is(equal_to(&DEFAULT_NAME)));
        assert_that!(&student.name, equal_to(&DEFAULT_NAME));

        assert_that!(student.to_string(), equal_to(DEFAULT_NAME));
    }

    #[test]
    fn test_non_default_constructor() {
        let student = Student::default();

        let desired_name: &str = "Tommy Oliver";
        let tommy = Student::new(desired_name);

        assert_that!(&tommy.name, equal_to(&desired_name));

        assert_that!(&tommy.to_string(), equal_to(&desired_name));

        assert_that!(tommy, is_not(equal_to(student)));
    }

    #[test]
    fn test_clone() {
        let student = Student::new("Thomas");
        let copy = student.clone();

        assert_that!(std::ptr::eq(&student, &copy), is(false));
        assert_that!(student, eq(copy));
    }
}

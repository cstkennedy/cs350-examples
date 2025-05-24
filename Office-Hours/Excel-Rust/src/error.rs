use thiserror::Error;

use crate::student::Student;

#[derive(Debug, Error, PartialEq)]
pub enum EnrollError<'a> {
    #[error("{course_num} has reached its cap ({cap})")]
    SectionFull { course_num: &'a str, cap: usize },
    #[error("Student is already registered")]
    AlreadyRegistered,
    #[error("{0:?}")]
    Generic(&'static str),
}

#[derive(Debug, Error, PartialEq)]
pub struct ErrorWithValue<E: std::error::Error, V> {
    #[source]
    pub the_error: E,
    pub the_value: V,
}

pub type RosterError<'a> = ErrorWithValue<EnrollError<'a>, Student>;

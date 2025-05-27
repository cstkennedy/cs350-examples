pub mod error;
pub mod roster;
pub mod simple_excel_writer;
pub mod student;

pub mod prelude {
    pub use crate::roster::Roster;
    pub use crate::student::Student;
}

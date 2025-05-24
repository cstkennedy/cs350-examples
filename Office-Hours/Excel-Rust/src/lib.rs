pub mod error;
pub mod roster;
pub mod student;

pub mod prelude {
    pub use crate::roster::Roster;
    pub use crate::student::Student;
}

use enroll_students::error::{EnrollError, RosterError};
use enroll_students::prelude::{Roster, Student};

use enroll_students::simple_excel_writer::*;

fn main() -> eyre::Result<()> {
    let all_students = [
        Student::new("John"),
        Student::new("Tom"),
        Student::new("Jay"),
        Student::new("Oscar"),
    ];

    let cap = 4;
    let (_, cs330) = enroll_everyone(Roster::new(cap, "CS 330"), all_students);

    // roster = generate_roster()

    _ = demo_simple_table("report.xlsx");
    _ = demo_roster_table(cs330, "report_students.xlsx");

    Ok(())
}

fn enroll_everyone(
    mut roster: Roster,
    all_students: impl std::iter::IntoIterator<Item = Student>,
) -> (Vec<String>, Roster) {
    let course_num = roster.course_num.clone();

    let messages = all_students
        .into_iter()
        .map(|stu| {
            let name = stu.name.clone();

            match roster.enroll(stu) {
                Ok(_) => format!("{name} enrolled in {course_num}"),
                Err(roster_error) => {
                    format!(
                        "{} NOT enrolled in {course_num} ({})",
                        roster_error.the_value,
                        match roster_error.the_error {
                            EnrollError::AlreadyRegistered => "Already Enrolled",
                            EnrollError::SectionFull { .. } => "Full",
                            _ => "Unknown Error",
                        }
                    )
                }
            }
        })
        .collect();

    (messages, roster)
}

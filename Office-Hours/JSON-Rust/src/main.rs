use eyre::{self, OptionExt, Result, WrapErr};
use serde_json;

use enroll_students::error::{EnrollError, RosterError};
use enroll_students::prelude::{Roster, Student};

fn main() -> eyre::Result<()> {
    let all_students = [
        Student::new("John"),
        Student::new("Tom"),
        Student::new("Jay"),
        Student::new("Oscar"),
    ];

    let cap = 4;
    let (_, cs330) = enroll_everyone(Roster::new(cap, "CS 330"), all_students);

    let json_str = demo_naive_serialization(&cs330)?;
    println!("{}", &json_str);
    println!();

    let json_str = demo_map_serialization_nested(&cs330)?;
    println!("{}", &json_str);

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

/// Demonstrate naive serialization. By default every field is
/// output using the variable name.
fn demo_naive_serialization(roster: &Roster) -> eyre::Result<String> {
    Ok(serde_json::to_string_pretty(&roster)?)
}

/// Demonstrate nested serialization using extracted data stored in a map.
fn demo_map_serialization_nested(roster: &Roster) -> eyre::Result<String> {
    let student_entries: Vec<_> = roster
        .iter()
        .map(|student| serde_json::json!({"name": student.name, "gpa": 4.0}))
        .collect();

    let report = serde_json::json!({
        &roster.course_num: student_entries,
        "totalStudents": roster.num_enrolled(),
    });

    let json_str = serde_json::to_string_pretty(&report)?;

    Ok(json_str)
}

use hamcrest2::prelude::*;
use rstest::*;

use calamine::{Data, RangeDeserializer, RangeDeserializerBuilder, Reader, Xlsx, open_workbook};
use serde::Deserialize;

use enroll_students::simple_excel_writer::*;

#[rstest]
pub fn test_simple_report() {
    let mut workbook: Xlsx<_> = open_workbook("report.xlsx").expect("Cannot open 'report.xlsx'");

    let sheet = workbook.worksheet_range("Report").unwrap();

    for (idx, row) in (1..3).zip(sheet.rows()) {
        assert!(matches!(&row[0], Data::String(entry) if *entry == format!("A{}", idx)));
        assert!(matches!(&row[1], Data::String(entry) if *entry == format!("B{}", idx)));
        assert!(matches!(&row[2], Data::String(entry) if *entry == format!("C{}", idx)));
    }
}

#[derive(Clone, Debug, PartialEq, Deserialize)]
struct StudentRecord {
    #[serde(alias = "Student")]
    name: String,

    #[serde(alias = "Grade")]
    grade: f64,
}

#[rstest]
pub fn test_roster_report() {
    let mut workbook: Xlsx<_> =
        open_workbook("report_students.xlsx").expect("Cannot open 'report_students.xlsx'");

    let range = workbook.worksheet_range("Report").unwrap();

    let mut iter_records = RangeDeserializerBuilder::with_headers(&["Student", "Grade"])
        .from_range(&range)
        .unwrap();

    // Unwrap twice... once for the outer iterator and again for the inner result
    let student: StudentRecord = iter_records.next().unwrap().unwrap();
    assert_that!(
        student,
        is(equal_to(StudentRecord {
            name: "Oscar".to_owned(),
            grade: 4.0
        }))
    );

    let student: StudentRecord = iter_records.next().unwrap().unwrap();
    assert_that!(
        student,
        is(equal_to(StudentRecord {
            name: "Jay".to_owned(),
            grade: 4.0
        }))
    );

    let student: StudentRecord = iter_records.next().unwrap().unwrap();
    assert_that!(
        student,
        is(equal_to(StudentRecord {
            name: "John".to_owned(),
            grade: 4.0
        }))
    );

    let student: StudentRecord = iter_records.next().unwrap().unwrap();
    assert_that!(
        student,
        is(equal_to(StudentRecord {
            name: "Tom".to_owned(),
            grade: 4.0
        }))
    );
}

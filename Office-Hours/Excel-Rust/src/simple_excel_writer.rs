use rust_xlsxwriter::*;

use crate::prelude::{Roster, Student};

///
/// Output a 3x3 table with the cells labeled as A1, A2... C2, C3
///
pub fn demo_simple_table(destination: &str) -> eyre::Result<()> {
    let mut workbook = Workbook::new();
    let sheet = workbook.add_worksheet().set_name("Report")?;

    // Output 3 Rows (A, B, C)
    for idx_row in 0..2 {
        for (idx_col, letter_col) in (0..3).zip(['A', 'B', 'C']) {
            let cell_entry = format!("{}{}", letter_col, idx_row + 1);
            sheet.write(idx_row, idx_col, cell_entry)?;
        }
    }

    // Write and save the Excel document
    workbook.save(destination)?;

    Ok(())
}

/// Output a table with student names in the first column and grades in the
/// second column.
///
/// TODO: replace hardcoded "4.0" grades with actual grade values.
///
pub fn demo_roster_table(roster: Roster, destination: &str) -> eyre::Result<()> {
    let mut workbook = Workbook::new();
    let sheet = workbook.add_worksheet().set_name("Report")?;

    // Output the Header
    sheet.write(0, 0, "Student")?;
    sheet.write(0, 1, "Grade")?;

    // Output all students
    for (idx_row, stu) in (1..).zip(roster.iter()) {
        // Create and output a student row
        sheet.write(idx_row.try_into()?, 0, &stu.name)?;
        sheet.write_number(idx_row.try_into()?, 1, 4.0)?;
    }

    // Write and save the Excel document
    workbook.save(destination)?;

    Ok(())
}


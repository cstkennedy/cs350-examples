use rust_xlsxwriter::*;
use rust_xlsxwriter::*;


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

    /*
            # Set up the cell data
            cell_name = f"{chr(idx_col)}{idx_row}"

            # Create the cell and write to it
            sheet[cell_name] = cell_name
    */

    // Write and save the Excel document
    workbook.save(destination)?;

    Ok(())
}

/*
def demo_roster_table(roster: Roster, destination: str = "report.xlsx") -> None:
    """
    Output a table with student names in the first column and grades in the
    second column.

    TODO: replace hardcoded "4.0" grades with actual grade values.
    """

    workbook = Workbook()
    sheet = workbook.create_sheet(title="Report")

    # Output the Header
    sheet.append(["Student", "Grade"])

    # Output all students
    for stu in roster.list_enrolled_students():
        # Create and output a student row
        row = [stu.name, 4.0]
        sheet.append(row)

    # Write and save the Excel document
    workbook.save(destination)
*/

fn main() -> eyre::Result<()> {
    // roster = generate_roster()

    _ = demo_simple_table("report.xlsx");
    // demo_roster_table(roster, destination="report_students.xlsx")
    
    Ok(())
}


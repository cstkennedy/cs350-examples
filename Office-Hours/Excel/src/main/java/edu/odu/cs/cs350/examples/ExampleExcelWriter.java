package edu.odu.cs.cs350.examples;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExampleExcelWriter
{
    private Roster roster;
    private FileOutputStream destination;

    /**
     * Default constructor should never be used. "Disable" it by making it
     * private.
     */
    private ExampleExcelWriter()
    {

    }

    /**
     * If no destination is specified default to "default.xlsx" in the current
     * working directory (e.g., project root).
     *
     * @param src roster to output
     */
    public ExampleExcelWriter(final Roster src)
        throws FileNotFoundException
    {
        this.roster = src;
        this.destination = new FileOutputStream(
            new File("report.xlsx")
        );
    }

    /**
     * Output to a specified file.
     *
     * @param src roster to output
     * @param buffer location to which data is to be written
     */
    public ExampleExcelWriter(final Roster src, File outputFile)
        throws FileNotFoundException
    {
        this.roster = src;
        this.destination = new FileOutputStream(outputFile);
    }

    /**
     * Return the roster (data source)
     */
    public Roster getSourceData()
    {
        return this.roster;
    }

    /**
     * Output a 3x3 table with the cells labeled as A1, A2... C2, C3
     */
    public void demoSimpleTable()
        throws IOException
    {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        // Output 3 Rows (A, B, C)
        for (int idxRow = 0; idxRow < 3; ++idxRow) {
            Row row = sheet.createRow(idxRow);

            for (int idxCol = 0; idxCol < 3; ++idxCol) {
                // Determine the column letter based on the offset from A
                // (e.g., 'A' + 1 = 'B')
                final char colLetter = (char) ((int) 'A' + idxCol);

                // Set up the cell data
                String cellName =  String.format("%s%d", colLetter, idxRow + 1);

                // Create the cell and write to it
                Cell cell = row.createCell(idxCol);
                cell.setCellValue(cellName);
            }
        }

        // Write and save the Excel document
        workbook.write(this.destination);
        workbook.close();
    }

    /**
     * Output a table with student names in the first column and grades in the
     * second column.
     *
     * @TODO replace hardcoded "4.0" grades with actual grade values.
     */
    public void demoRosterTable()
        throws IOException
    {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        // Output the Header
        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Student");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Grade");

        // Output all students
        // (Python's enumerate generator function would be ideal here)
        int idxRow = 1;
        for (Student stu : this.roster) {
            Row row = sheet.createRow(idxRow);

            Cell cell = row.createCell(0);
            cell.setCellValue(stu.getName());

            cell = row.createCell(1);
            cell.setCellValue(4.0);

            ++idxRow;
        }

        // Write and save the Excel document
        workbook.write(this.destination);
        workbook.close();
    }
}

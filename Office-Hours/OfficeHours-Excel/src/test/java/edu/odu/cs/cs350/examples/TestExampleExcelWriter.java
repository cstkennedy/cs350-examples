package edu.odu.cs.cs350.examples;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.IsNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This is an integration test (by definition).
 *
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestExampleExcelWriter {

    Student john;
    Student tom;
    Student jay;
    Student oscar;

    List<Student> allStudents;

    Roster roster;

    @BeforeEach
    public void setUp()
    {
        john  = new Student("John");
        tom   = new Student("Tom");
        jay   = new Student("Jay");
        oscar = new Student("Oscar");

        allStudents = Arrays.asList(john, tom, jay, oscar);

        roster = new Roster(4, "CS 330");

        for (Student s : allStudents) {
            final boolean enrollResult = roster.enroll(s);
        }
    }

    @Test
    public void testDemoSimpleTable()
        throws IOException
    {
        // This should really be in a temp directory that gets deleted after
        // the test. However, for the purposed of demonstraction... the file is
        // left in the Gradle project root.
        File testFile = new File("testSimpleReport.xlsx");

        ExampleExcelWriter writer = new ExampleExcelWriter(roster, testFile);

        writer.demoSimpleTable();

        // Open the Excel File for examination
        FileInputStream theReport = new FileInputStream(testFile);
        Workbook workbook = new XSSFWorkbook(theReport);

        // Get the first sheet (Assume that the report is nonempty)
        Sheet sheet = workbook.getSheetAt(0);

        // Explicitly check each cell (we know that all cells contain string data)
        Cell cell = sheet.getRow(0).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("A1"));

        cell = sheet.getRow(0).getCell(1);
        assertThat(cell.getStringCellValue(), equalTo("B1"));

        cell = sheet.getRow(0).getCell(2);
        assertThat(cell.getStringCellValue(), equalTo("C1"));

        cell = sheet.getRow(1).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("A2"));

        cell = sheet.getRow(1).getCell(1);
        assertThat(cell.getStringCellValue(), equalTo("B2"));

        cell = sheet.getRow(1).getCell(2);
        assertThat(cell.getStringCellValue(), equalTo("C2"));

        cell = sheet.getRow(2).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("A3"));

        cell = sheet.getRow(2).getCell(1);
        assertThat(cell.getStringCellValue(), equalTo("B3"));

        cell = sheet.getRow(2).getCell(2);
        assertThat(cell.getStringCellValue(), equalTo("C3"));
    }

    @Test
    public void testDemoRosterTable()
        throws IOException
    {
        // This should really be in a temp directory that gets deleted after
        // the test. However, for the purposed of demonstraction... the file is
        // left in the Gradle project root.
        File testFile = new File("testRosterReport.xlsx");

        ExampleExcelWriter writer = new ExampleExcelWriter(roster, testFile);

        writer.demoRosterTable();

        // Open the Excel File for examination
        FileInputStream theReport = new FileInputStream(testFile);
        Workbook workbook = new XSSFWorkbook(theReport);

        // Get the first sheet (Assume that the report is nonempty)
        Sheet sheet = workbook.getSheetAt(0);

        // Explicitly check each cell (we know which cells contain String data
        // and which cells contain numeric data)
        
        // Check the header row first
        Cell cell = sheet.getRow(0).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("Student"));
        cell = sheet.getRow(0).getCell(1);
        assertThat(cell.getStringCellValue(), equalTo("Grade"));

        // Check the student data (starting with row 1)
        cell = sheet.getRow(1).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("John"));
        cell = sheet.getRow(1).getCell(1);
        assertThat(cell.getNumericCellValue(), closeTo(4.0, 0.01));

        cell = sheet.getRow(2).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("Tom"));
        cell = sheet.getRow(2).getCell(1);
        assertThat(cell.getNumericCellValue(), closeTo(4.0, 0.01));

        cell = sheet.getRow(3).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("Jay"));
        cell = sheet.getRow(3).getCell(1);
        assertThat(cell.getNumericCellValue(), closeTo(4.0, 0.01));

        cell = sheet.getRow(4).getCell(0);
        assertThat(cell.getStringCellValue(), equalTo("Oscar"));
        cell = sheet.getRow(4).getCell(1);
        assertThat(cell.getNumericCellValue(), closeTo(4.0, 0.01));

    }
}

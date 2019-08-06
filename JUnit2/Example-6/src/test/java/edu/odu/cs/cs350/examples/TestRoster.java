package edu.odu.cs.cs350.examples;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;

/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRoster {
    // Students - will not be changed during tests
    Student john  = new Student("John");
    Student tom   = new Student("Tom");
    Student jay   = new Student("Jay");
    Student oscar = new Student("Oscar");

    // Student "lists" - will not be changed during tests
    Student[] firstThreeStudents = {john, tom, jay};
    Student[] allStudents        = {john, tom, jay, oscar};

    // Course Rosters - will possibly change in each test
    Roster defaultCourse;
    Roster emptyCS350;

    @Before
    public void setUp()
    {
        defaultCourse = new Roster();
        emptyCS350    = new Roster(3, "CS 350");
    }

    @Test
    public void testDefaultConstructor()
    {
        assertThat(defaultCourse.getCourseNum(), equalTo("CS 150"));
        assertThat(defaultCourse.getEnrollLimit(),
                   equalTo(Roster.DEFAULT_MAX_STUDENTS));

        assertThat(defaultCourse.numEnrolled(), equalTo(0));

        // No students have been added
        assertThat(defaultCourse.listEnrolledStudents(), notNullValue());
        assertThat(defaultCourse.listEnrolledStudents().size(), equalTo(0));

        // skipping hashcode
        // skipping equals

        // test toString
        assertThat(defaultCourse.toString(), containsString("CS 150"));
        assertThat(defaultCourse.toString(),
                   containsString(Integer.toString(defaultCourse.numEnrolled())));
        assertThat(defaultCourse.toString(),
                   containsString(Integer.toString(Roster.DEFAULT_MAX_STUDENTS)));
    }

    @Test
    public void testNonDefaultConstructor()
    {
        assertThat(emptyCS350.getCourseNum(), equalTo("CS 350")); // fixed mistake
        assertThat(emptyCS350.getEnrollLimit(), equalTo(3));

        assertThat(defaultCourse.numEnrolled(), equalTo(0));

        // No students have been added
        assertThat(emptyCS350.listEnrolledStudents(), notNullValue());
        assertThat(emptyCS350.listEnrolledStudents().size(), equalTo(0));

        // NOT skipping hashcode
        assertThat(emptyCS350.hashCode(), not(equalTo(defaultCourse.hashCode())));
        // NOT skipping equals
        assertThat(emptyCS350, not(equalTo(defaultCourse)));

        // test toString
        assertThat(emptyCS350.toString(), containsString("CS 350"));
        assertThat(emptyCS350.toString(),
                   containsString(Integer.toString(emptyCS350.numEnrolled())));
        assertThat(emptyCS350.toString(), containsString(Integer.toString(3)));
    }

    @Test
    public void testSetCourseNum()
    {
        Roster cs252 = new Roster();

        int oldHashCode = cs252.hashCode();

        cs252.setCourseNum("CS 252");

        assertThat(cs252.getCourseNum(), equalTo("CS 252"));
        assertThat(cs252.getEnrollLimit(),
                   equalTo(Roster.DEFAULT_MAX_STUDENTS));

        assertThat(defaultCourse.numEnrolled(), equalTo(0));

        // No students have been added
        assertThat(cs252.listEnrolledStudents(), notNullValue());
        assertThat(cs252.listEnrolledStudents().size(), equalTo(0));

        // NOT skipping hashcode
        assertThat(cs252.hashCode(), not(equalTo(oldHashCode)));
        // NOT skipping equals
        assertThat(cs252, not(equalTo(defaultCourse)));

        // test toString
        assertThat(cs252.toString(), containsString("CS 252"));
        assertThat(cs252.toString(),
                   containsString(Integer.toString(cs252.numEnrolled()))); // fixed mistake
        assertThat(cs252.toString(),
                   containsString(Integer.toString(Roster.DEFAULT_MAX_STUDENTS)));
    }

    @Test
    public void testSetEnrollLimit()
    {
        assertThat(emptyCS350.getCourseNum(), equalTo("CS 350"));

        emptyCS350.setEnrollLimit(2);

        assertThat(emptyCS350.getEnrollLimit(), equalTo(2));

        assertThat(defaultCourse.numEnrolled(), equalTo(0));

        // No students have been added
        assertThat(emptyCS350.listEnrolledStudents(), notNullValue());
        assertThat(emptyCS350.listEnrolledStudents().size(), equalTo(0));

        // NOT skipping hashcode
        assertThat(emptyCS350.hashCode(), not(equalTo(defaultCourse.hashCode())));
        // NOT skipping equals
        assertThat(emptyCS350, not(equalTo(defaultCourse)));

        // test toString
        assertThat(emptyCS350.toString(), containsString("CS 350"));
        assertThat(emptyCS350.toString(),
                   containsString(Integer.toString(emptyCS350.numEnrolled())));
        assertThat(emptyCS350.toString(), containsString(Integer.toString(2)));
    }

    @Test
    public void testEnroll()
    {
        //This is where the fun starts
        Roster cs725 = new Roster(3, "CS 725");

        int oldHashCode = cs725.hashCode();

        assertThat(cs725.getCourseNum(), equalTo("CS 725"));
        assertThat(cs725.getEnrollLimit(), equalTo(3)); // fixed mistake

        assertThat(defaultCourse.numEnrolled(), equalTo(0));

        // try to add 4 students
        assertThat(cs725.enroll(john), is(true));
        assertThat(cs725.enroll(tom), is(true));
        assertThat(cs725.enroll(jay), is(true));
        assertThat(cs725.enroll(oscar), is(false)); // should fail (limit of 3)

        // 3 students have been added
        assertThat(cs725.listEnrolledStudents(), notNullValue());
        assertThat(cs725.listEnrolledStudents().size(), equalTo(3));
        assertThat(cs725.listEnrolledStudents().toArray(),
                   equalTo(firstThreeStudents));

        oldHashCode = cs725.hashCode();

        // Change the limit to 4
        emptyCS350.setEnrollLimit(4);
        assertThat(emptyCS350.getEnrollLimit(), equalTo(4));

        // try to add a 4th student with the new limit of 4
        assertThat(cs725.enroll(oscar), is(true)); // should succeed (limit of 4)

        // 4 students have been added
        assertThat(cs725.listEnrolledStudents(), notNullValue());
        assertThat(cs725.listEnrolledStudents().size(), equalTo(4));
        assertThat(cs725.listEnrolledStudents().toArray(),
                   equalTo(firstThreeStudents));

        // NOT skipping hashcode
        assertThat(cs725.hashCode(), not(equalTo(oldHashCode)));
        // NOT skipping equals
        assertThat(cs725, not(equalTo(defaultCourse)));

        // **test flaw** - did not exercise adding the same student twice
        assertThat(cs725.enroll(tom), is(false)); // should fail

        // test toString
        assertThat(cs725.toString(), containsString("CS 725"));
        assertThat(cs725.toString(),
                   containsString(Integer.toString(cs725.numEnrolled())));
        assertThat(cs725.toString(),
                   containsString(Integer.toString(3)));

        assertThat(cs725.toString(), containsString(allStudents[0].toString()));
        assertThat(cs725.toString(), containsString(allStudents[1].toString()));
        assertThat(cs725.toString(), containsString(allStudents[2].toString()));
        assertThat(cs725.toString(), containsString(allStudents[3].toString()));

    }

    @Test
    public void testClone()
    {
        fail("Left as an Exercise");
    }
}

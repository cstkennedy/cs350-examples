package edu.odu.cs.cs350.examples;

import java.util.LinkedHashSet;

/**
 * A class roster listing all students enrolled
 * in a course
 */
public class Roster implements Cloneable {
    public static final int DEFAULT_MAX_STUDENTS = 10;

    /**
     * Create a class roster with a limit
     * of DEFAULT_MAX_STUDENTS `Student`s
     * and the course number set to
     * "CS 150"
     */
    public Roster()
    {

    }

    /**
     * Create a class roster with a specified
     * enrollment limit and course number
     *
     * @param l enrollment limit
     * @param c course number
     */
    public Roster(int l, String c)
    {

    }

    /**
     * Retrieve the course number
     */
    public String getCourseNum()
    {
        return "";
    }

    /**
     * Change the course number
     *
     * @param n desired course number
     */
    public void setCourseNum(String n)
    {

    }

    /**
     * Retrieve the enrollment limit
     */
    public int getEnrollLimit()
    {
        return -1;
    }

    /**
     * Change the enrollment limit
     *
     * @param n desired limit
     */
    public void setEnrollLimit(int n)
    {

    }

    /**
     * Attempt to enroll a Student in the course
     *
     * Rules:
     *   1- A student can not be added if the enrollment
     *     limit has been reached.
     *   2- A student can not be added to a roster multiple times
     *
     * @param stu Student to enroll
     *
     * @return true if the Student was successfully enrolled
     *    in the course (added to the roster)
     */
    public boolean enroll(Student stu)
    {
        return false;
    }

    /**
     * Retrieve the number of enrolled students
     */
    public int numEnrolled()
    {
        return -1;
    }

    /**
     * Return a collection of students in
     * the order they were enrolled (added)
     *
     * @return Set of enrolled students. If no students
     *     have been added to the roster, the set will be
     *     empty.
     */
    public LinkedHashSet<Student> listEnrolledStudents()
    {
        return null;
    }

    /**
     * Compare 2 `Student`s based on name
     *
     * @param rhs the other (right-hand-side) student object
     */
    @Override
    public boolean equals(Object rhs)
    {
        if(!(rhs instanceof Roster)) {
            return false;
        }

        return false;
    }

    /**
     * Return a hashcode
     */
    @Override
    public int hashCode()
    {
        return 1;
    }

    /**
     * Return a (deep) copy of this object.
     */
    @Override
    public Object clone()
    {
        //return new Student(name);
        return null;
    }

    /**
     * Generate a String containing the course number,
     * number of enrolled students, enrollment limit, and the names
     * of all enrolled students.
     */
    @Override
    public String toString()
    {
        return "";
    }
}

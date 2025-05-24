import sys
from typing import TextIO

from examples.roster import Roster
from examples.student import Student
from simple_excel_writer import *


def generate_roster() -> Roster:

    john = Student("John")
    tom = Student("Tom")
    jay = Student("Jay")
    oscar = Student("Oscar")

    all_students = [john, tom, jay, oscar]

    cs330 = Roster(4, "CS 330")

    for stu in all_students:
        _ = cs330.enroll(stu)

    return cs330


def main() -> None:
    roster = generate_roster()

    demo_simple_table()
    demo_roster_table(roster, destination="report_students.xlsx")


if __name__ == "__main__":
    main()

import sys
from typing import TextIO

import jsonpickle

from examples.roster import Roster
from examples.student import Student


"""
Demonstrate simple Roster and Student ADTs.
"""


def generate_roster() -> Roster:
    """
    This is a non-trivial main function.
    """

    john = Student("John")
    tom = Student("Tom")
    jay = Student("Jay")
    oscar = Student("Oscar")

    all_students = [john, tom, jay, oscar]

    cs330 = Roster(4, "CS 330")

    for stu in all_students:
        _ = cs330.enroll(stu)

    return cs330


def demo_naive_serialization(roster: Roster, destination: TextIO) -> None:
    """
    Demonstrate naive serialization. By default every field is
    output using the variable name.
    """

    destination.write(jsonpickle.encode(roster, indent=4))


def demo_map_serialization_nested(roster: Roster, destination: TextIO) -> None:
    """
    Demonstrate nested serialization using extracted data stored in a map.
    """

    report = {
        roster.course_num: [
            {"name": student.name, "gpa": 4.0} for student in roster.students
        ],
        "totalStudents": roster.num_enrolled(),
    }

    destination.write(jsonpickle.encode(report, indent=4))


def main() -> None:
    roster = generate_roster()

    demo_naive_serialization(roster, sys.stdout)
    print()
    demo_map_serialization_nested(roster, sys.stdout)
    print()


if __name__ == "__main__":
    main()

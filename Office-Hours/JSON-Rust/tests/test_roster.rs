use std::collections::HashSet;

use hamcrest2::prelude::*;
use rstest::fixture;
use rstest::rstest;

use enroll_students::prelude::*;
use enroll_students::roster::DEFAULT_MAX_STUDENTS;

#[fixture]
fn default_courses() -> (Roster, Roster) {
    let default_course = Roster::default();
    let empty_cs350 = Roster::new(3, "CS 350");

    (default_course, empty_cs350)
}

type StudentListTuple = (
    Student,
    Student,
    Student,
    Student,
    [Student; 4],
    [Student; 3],
);

#[fixture]
fn students_and_lists() -> StudentListTuple {
    let john = Student::new("John");
    let tom = Student::new("Tom");
    let jay = Student::new("Jay");
    let oscar = Student::new("Oscar");

    // Student "lists" - will not be changed during tests
    let all_students = [john.clone(), tom.clone(), jay.clone(), oscar.clone()];
    let first_three_students = [john.clone(), tom.clone(), jay.clone()];

    (john, tom, jay, oscar, all_students, first_three_students)
}

#[rstest]
fn test_default_constructor() {
    let default_course = Roster::default();

    assert_that!(&default_course.course_num, equal_to("CS 150"));
    assert_that!(default_course.enroll_limit, equal_to(DEFAULT_MAX_STUDENTS));

    assert_that!(default_course.num_enrolled(), equal_to(0_usize));

    // No students have been added
    assert_that!(
        default_course.list_enrolled_students().len(),
        equal_to(0_usize)
    );

    // skipping hashcode
    // skipping equals

    // test __str__
    let default_course_str = default_course.to_string();
    assert_that!(default_course_str.contains("CS 150"), is(true));
    assert_that!(
        default_course_str.contains(&default_course.num_enrolled().to_string()),
        is(true)
    );
    assert_that!(
        default_course_str.contains(&DEFAULT_MAX_STUDENTS.to_string()),
        is(true)
    );
}

#[rstest]
fn test_non_default_constructor(default_courses: (Roster, Roster)) {
    let (default_course, empty_cs350) = default_courses;

    assert_that!(&empty_cs350.course_num, equal_to("CS 350"));
    assert_that!(empty_cs350.enroll_limit, equal_to(3));

    assert_that!(default_course.num_enrolled(), equal_to(0));

    // No students have been added
    // assert_that!(empty_cs350.list_enrolled_students(), is(none()));
    assert_that!(empty_cs350.list_enrolled_students().len(), equal_to(0));

    // NOT skipping hashcode
    // assert_that!(hash(empty_cs350), is_not(equal_to(hash(default_course))))
    // NOT skipping equals
    assert_that!(&empty_cs350, is_not(equal_to(&default_course)));

    // test __str__
    let empty_cs350_str = empty_cs350.to_string();
    assert!(empty_cs350_str.contains("CS 350"));
    assert!(empty_cs350_str.contains("3"));
}

#[rstest]
fn test_set_course_num(default_courses: (Roster, Roster)) {
    let (default_course, _) = default_courses;

    let mut cs252 = Roster::default();

    // let old_hash_code = cs252.hash();

    cs252.course_num = "CS 252".into();

    assert_that!(&cs252.course_num, equal_to("CS 252"));
    assert_that!(cs252.enroll_limit, equal_to(DEFAULT_MAX_STUDENTS));

    assert_that!(default_course.num_enrolled(), equal_to(0));

    // No students have been added
    assert_that!(cs252.list_enrolled_students().len(), equal_to(0));

    // NOT skipping hashcode
    // assert_that!(hash(cs252), is_not(equal_to(old_hash_code)));
    // NOT skipping equals
    assert_that!(&cs252, is(not(equal_to(&default_course))));

    // test __str__
    let cs252_str = cs252.to_string();
    assert!(cs252_str.contains("CS 252"));
    assert!(cs252_str.contains(&format!("{}", cs252.num_enrolled())));
    assert!(cs252_str.contains(&format!("{}", DEFAULT_MAX_STUDENTS)));
}

#[rstest]
fn test_set_enroll_limit(default_courses: (Roster, Roster)) {
    let (default_course, mut empty_cs350) = default_courses;

    empty_cs350.enroll_limit = 2;

    assert_that!(&empty_cs350.course_num, equal_to("CS 350"));
    assert_that!(empty_cs350.enroll_limit, equal_to(2));

    assert_that!(default_course.num_enrolled(), equal_to(0));

    // No students have been added
    assert_that!(empty_cs350.list_enrolled_students().len(), equal_to(0));

    // NOT skipping hashcode
    // assert_that!(hash(empty_cs350), is_not(equal_to(hash(default_course))));
    // NOT skipping equals
    assert_that!(&empty_cs350, is_not(equal_to(&default_course)));

    // test __str__
    let empty_cs350_str = empty_cs350.to_string();
    assert!(empty_cs350_str.contains("CS 350"));
    assert!(empty_cs350_str.contains(&format!("{}", empty_cs350.num_enrolled())));
    assert!(empty_cs350_str.contains("2"));
}

#[rstest]
fn test_enroll(default_courses: (Roster, Roster), students_and_lists: StudentListTuple) {
    let (john, tom, jay, oscar, all_students, first_three_students) = students_and_lists;
    let (default_course, _) = default_courses;

    // This is where the fun starts
    let mut cs725 = Roster::new(3, "CS 725");

    // old_hash_code = hash(cs725)

    // try to add 4 students
    assert_that!(cs725.enroll(john.clone()), is(ok()));
    assert_that!(cs725.enroll(tom.clone()), is(ok()));
    assert_that!(cs725.enroll(jay.clone()), is(ok()));
    assert_that!(cs725.enroll(oscar.clone()), is(err())); // should fail (limit of 3);

    assert_that!(&cs725.course_num, equal_to("CS 725"));
    assert_that!(cs725.enroll_limit, equal_to(3));
    assert_that!(cs725.num_enrolled(), equal_to(3)); // fixed mistake

    // 3 students have been added
    // assert_that!(cs725.list_enrolled_students(), not_none());
    assert_that!(cs725.list_enrolled_students().len(), equal_to(3));
    assert_that!(
        cs725
            .list_enrolled_students()
            .difference(&HashSet::from(first_three_students))
            .count(),
        is(equal_to(0))
    );

    // assert_that!(hash(cs725), is_not(equal_to(old_hash_code)));

    // old_hash_code = hash(cs725);

    // Change the limit to 4
    cs725.enroll_limit = 4;
    assert_that!(cs725.enroll_limit, equal_to(4));

    // try to add a 4th student with the new limit of 4
    assert_that!(cs725.enroll(oscar), is(ok())); // should succeed (limit of 4);

    // 4 students have been added
    // assert_that!(cs725.list_enrolled_students(), not_none());
    assert_that!(cs725.list_enrolled_students().len(), equal_to(4));
    // assert_that!(
    // cs725.list_enrolled_students(),
    // contains_inanyorder(*all_students),
    // );

    // NOT skipping hashcode
    // assert_that!(hash(cs725), is(not(equal_to(old_hash_code))));
    // NOT skipping equals
    assert_that!(&cs725, is_not(equal_to(&default_course)));

    // **test flaw** - did not exercise adding the same student twice
    assert_that!(cs725.enroll(tom), is(err())); // should fail

    // test __str__
    assert!(cs725.to_string().contains("CS 725"));
    assert!(
        cs725
            .to_string()
            .contains(&format!("{}", cs725.num_enrolled()))
    );
    assert!(cs725.to_string().contains("4"));

    assert!(cs725.to_string().contains(&all_students[0].to_string()));
    assert!(cs725.to_string().contains(&all_students[1].to_string()));
    assert!(cs725.to_string().contains(&all_students[2].to_string()));
    assert!(cs725.to_string().contains(&all_students[3].to_string()));
}

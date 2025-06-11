CREATE TABLE student_course (
    student_id INT,
    course_code VARCHAR(20),
    semester VARCHAR(10),
    grade CHAR(2),
    PRIMARY KEY (student_id, course_code)
);

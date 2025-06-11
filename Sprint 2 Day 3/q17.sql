CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

CREATE TABLE Students (
    student_id INT,
    course_id INT,
    name VARCHAR(100),
    email VARCHAR(100),
    PRIMARY KEY (student_id, course_id), -- Composite Key
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE studentDetails (
    studentId INT,
    courseId INT NOT NULL,
    email VARCHAR(100) UNIQUE,
    fullName VARCHAR(100),
    PRIMARY KEY (studentId, courseId)
);


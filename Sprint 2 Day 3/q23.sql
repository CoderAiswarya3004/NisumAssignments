CREATE TABLE Students (
  StudentID INT PRIMARY KEY,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  DateOfBirth DATE,
  Email VARCHAR(100)
);

CREATE TABLE Courses (
  CourseID INT PRIMARY KEY,
  CourseName VARCHAR(100),
  Credits INT
);

CREATE TABLE Enrollments (
  EnrollmentID INT PRIMARY KEY,
  StudentID INT,
  CourseID INT,
  EnrollmentDate DATE,
  FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
  FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

INSERT INTO Students VALUES
(1, 'John', 'Doe', '2001-01-15', 'john.doe@example.com'),
(2, 'Jane', 'Smith', '2000-05-21', 'jane.smith@example.com'),
(3, 'Raj', 'Kumar', '2002-09-10', 'raj.kumar@example.com'),
(4, 'Anita', 'Mehra', '1999-11-02', 'anita.mehra@example.com'),
(5, 'Kiran', 'Shah', '2001-04-04', 'kiran.shah@example.com'),
(6, 'Aman', 'Verma', '2003-07-07', 'aman.verma@example.com'),
(7, 'Sara', 'Lee', '2002-03-03', 'sara.lee@example.com'),
(8, 'Priya', 'Das', '2000-12-25', 'priya.das@example.com'),
(9, 'Vikram', 'Patel', '2001-08-18', 'vikram.patel@example.com'),
(10, 'Sneha', 'Singh', '1998-10-30', 'sneha.singh@example.com'),
(11, 'Manoj', 'Reddy', '2003-05-19', 'manoj.reddy@example.com'),
(12, 'Rhea', 'Chopra', '2002-06-22', 'rhea.chopra@example.com'),
(13, 'Zara', 'Ali', '2001-11-11', 'zara.ali@example.com'),
(14, 'Rohan', 'Joshi', '2000-02-17', 'rohan.joshi@example.com'),
(15, 'Dev', 'Mishra', '2001-09-09', 'dev.mishra@example.com');

INSERT INTO Courses VALUES
(101, 'Data Structures', 4),
(102, 'Database Systems', 3),
(103, 'Operating Systems', 3),
(104, 'Computer Networks', 4),
(105, 'Machine Learning', 5);

INSERT INTO Enrollments VALUES
(1001, 1, 101, '2024-06-01'),
(1002, 2, 102, '2024-06-02'),
(1003, 3, 101, '2024-06-03'),
(1004, 4, 103, '2024-06-04'),
(1005, 5, 104, '2024-06-05'),
(1006, 6, 102, '2024-06-06'),
(1007, 7, 105, '2024-06-07'),
(1008, 8, 101, '2024-06-08'),
(1009, 9, 1

-- Q24a: Retrieve all students
SELECT * FROM Students;

-- Q24b: Display only FirstName and Email of students
SELECT FirstName, Email FROM Students;

-- Q24c: List all courses with exactly 4 credits
SELECT * FROM Courses WHERE Credits = 4;

-- Q24d: Show students born after January 1, 2000
SELECT * FROM Students
WHERE DateOfBirth > '2000-01-01';

-- Q24e: List students whose first name starts with 'J'
SELECT * FROM Students
WHERE FirstName LIKE 'J%';

-- Q24f: Number of students enrolled in each course
SELECT CourseID, COUNT(StudentID) AS StudentCount
FROM Enrollments
GROUP BY CourseID;

-- Q24g: Display students and their enrollment dates
SELECT S.FirstName, S.LastName, E.EnrollmentDate
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID;

-- Q24h: List unique course IDs from Enrollments
SELECT DISTINCT CourseID FROM Enrollments;

-- Q24i: Students enrolled in CourseID 102
SELECT FirstName, LastName
FROM Students
WHERE StudentID IN (
  SELECT StudentID FROM Enrollments WHERE CourseID = 102
);

-- Q24j: Display students ordered by LastName
SELECT * FROM Students
ORDER BY LastName ASC;

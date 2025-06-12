--Retrieve all students
SELECT * FROM Students;

--Display only FirstName and Email of students
SELECT FirstName, Email FROM Students;

--List all courses with exactly 4 credits
SELECT * FROM Courses WHERE Credits = 4;

--Show students born after January 1, 2000
SELECT * FROM Students
WHERE DateOfBirth > '2000-01-01';

--List students whose first name starts with 'J'
SELECT * FROM Students
WHERE FirstName LIKE 'J%';

--Number of students enrolled in each course
SELECT CourseID, COUNT(StudentID) AS StudentCount
FROM Enrollments
GROUP BY CourseID;

--Display students and their enrollment dates
SELECT S.FirstName, S.LastName, E.EnrollmentDate
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID;

--List unique course IDs from Enrollments
SELECT DISTINCT CourseID FROM Enrollments;

--Students enrolled in CourseID 102
SELECT FirstName, LastName
FROM Students
WHERE StudentID IN (
  SELECT StudentID FROM Enrollments WHERE CourseID = 102
);

--Display students ordered by LastName alphabetically
SELECT * FROM Students
ORDER BY LastName ASC;

--List all students who have not enrolled in any course
SELECT * FROM Students
WHERE StudentID NOT IN (
  SELECT DISTINCT StudentID FROM Enrollments
);

--Show the average number of credits across all courses
SELECT AVG(Credits) AS AverageCredits FROM Courses;

--List the top 3 most recently enrolled students
SELECT S.FirstName, S.LastName, E.EnrollmentDate
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
ORDER BY E.EnrollmentDate DESC
LIMIT 3;

--Find all courses with names containing the word 'Data'
SELECT * FROM Courses
WHERE CourseName LIKE '%Data%';

--Display the youngest student in the database
SELECT * FROM Students
ORDER BY DateOfBirth DESC
LIMIT 1;

--Count the number of students with the same last name
SELECT LastName, COUNT(*) AS Count
FROM Students
GROUP BY LastName
HAVING COUNT(*) > 1;

--List courses along with the total number of enrolled students, sorted by count descending
SELECT C.CourseName, COUNT(E.StudentID) AS TotalEnrolled
FROM Courses C
LEFT JOIN Enrollments E ON C.CourseID = E.CourseID
GROUP BY C.CourseName
ORDER BY TotalEnrolled DESC;

--Find students who share the same first name
SELECT FirstName, COUNT(*) AS Count
FROM Students
GROUP BY FirstName
HAVING COUNT(*) > 1;

--Display enrollments made in the current year
SELECT * FROM Enrollments
WHERE YEAR(EnrollmentDate) = YEAR(CURDATE());

--List students along with the names of the courses they are enrolled in
SELECT S.FirstName, S.LastName, C.CourseName
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
JOIN Courses C ON E.CourseID = C.CourseID;

--List all students along with the courses they are enrolled in
SELECT S.FirstName, S.LastName, C.CourseName
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
JOIN Courses C ON E.CourseID = C.CourseID;

--List all courses and the students enrolled in them (include courses with no enrollments)
SELECT C.CourseName, S.FirstName, S.LastName
FROM Courses C
LEFT JOIN Enrollments E ON C.CourseID = E.CourseID
LEFT JOIN Students S ON E.StudentID = S.StudentID;

--Show all students who have not enrolled in any course
SELECT * FROM Students
WHERE StudentID NOT IN (
  SELECT StudentID FROM Enrollments
);

--List course names along with the count of enrolled students using JOIN
SELECT C.CourseName, COUNT(E.StudentID) AS EnrolledCount
FROM Courses C
LEFT JOIN Enrollments E ON C.CourseID = E.CourseID
GROUP BY C.CourseName;

--Show each student's full name and all course names they are enrolled in, ordered by student name
SELECT S.FirstName, S.LastName, C.CourseName
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
JOIN Courses C ON E.CourseID = C.CourseID
ORDER BY S.FirstName, S.LastName;

--List students and enrollment details using INNER JOIN
SELECT S.FirstName, S.LastName, C.CourseName, E.EnrollmentDate
FROM Students S
INNER JOIN Enrollments E ON S.StudentID = E.StudentID
INNER JOIN Courses C ON E.CourseID = C.CourseID;

--List all courses with student names using LEFT JOIN
SELECT C.CourseName, S.FirstName, S.LastName
FROM Courses C
LEFT JOIN Enrollments E ON C.CourseID = E.CourseID
LEFT JOIN Students S ON E.StudentID = S.StudentID;

--List student names and their course names using RIGHT JOIN (if supported by your DBMS)
SELECT S.FirstName, S.LastName, C.CourseName
FROM Courses C
RIGHT JOIN Enrollments E ON C.CourseID = E.CourseID
RIGHT JOIN Students S ON E.StudentID = S.StudentID;

--Show students and courses using FULL OUTER JOIN (if supported)
SELECT S.FirstName, S.LastName, C.CourseName
FROM Students S
FULL OUTER JOIN Enrollments E ON S.StudentID = E.StudentID
FULL OUTER JOIN Courses C ON E.CourseID = C.CourseID;

--Find students who are enrolled in both 'Database Systems' and 'Data Structures'
SELECT S.FirstName, S.LastName
FROM Students S
WHERE S.StudentID IN (
  SELECT E1.StudentID
  FROM Enrollments E1
  JOIN Courses C1 ON E1.CourseID = C1.CourseID
  WHERE C1.CourseName = 'Database Systems'
)
AND S.StudentID IN (
  SELECT E2.StudentID
  FROM Enrollments E2
  JOIN Courses C2 ON E2.CourseID = C2.CourseID
  WHERE C2.CourseName = 'Data Structures'
);

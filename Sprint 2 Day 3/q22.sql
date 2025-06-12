-- INNER JOIN
SELECT S.FirstName, C.CourseName
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
JOIN Courses C ON E.CourseID = C.CourseID;

-- LEFT JOIN
SELECT S.FirstName, C.CourseName
FROM Students S
LEFT JOIN Enrollments E ON S.StudentID = E.StudentID
LEFT JOIN Courses C ON E.CourseID = C.CourseID;

-- RIGHT JOIN
SELECT S.FirstName, C.CourseName
FROM Students S
RIGHT JOIN Enrollments E ON S.StudentID = E.StudentID
RIGHT JOIN Courses C ON E.CourseID = C.CourseID;

-- FULL OUTER JOIN
SELECT S.FirstName, C.CourseName
FROM Students S
FULL OUTER JOIN Enrollments E ON S.StudentID = E.StudentID
FULL OUTER JOIN Courses C ON E.CourseID = C.CourseID;

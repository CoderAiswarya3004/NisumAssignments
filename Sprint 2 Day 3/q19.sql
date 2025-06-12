SELECT CourseID,
       COUNT(EnrollmentID) AS TotalEnrollments,
       AVG(Credits) AS AvgCredits,
       MIN(Credits) AS MinCredits,
       MAX(Credits) AS MaxCredits,
       SUM(Credits) AS TotalCredits
FROM Enrollments E
JOIN Courses C ON E.CourseID = C.CourseID
GROUP BY CourseID
HAVING COUNT(EnrollmentID) > 1;

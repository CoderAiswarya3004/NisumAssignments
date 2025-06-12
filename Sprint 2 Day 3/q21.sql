SELECT FirstName, LastName
FROM Students
WHERE StudentID IN (
    SELECT StudentID
    FROM Enrollments
    WHERE CourseID = 102
);

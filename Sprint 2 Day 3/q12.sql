-- For studentDetails
INSERT INTO studentDetails (studentId, courseId, email, fullName)
VALUES 
(1, 101, 'a@x.com', 'Arun Kumar'),
(2, 102, 'b@x.com', 'Bina Roy'),
(3, 101, 'c@x.com', 'Charan Dey'),
(4, 103, 'd@x.com', 'Deepak R');

-- For employee
INSERT INTO employee (emp_id, emp_name, department, designation)
VALUES 
(1, 'Ravi R', 'HR', 'Manager'),
(2, 'Meena T', 'Finance', 'Analyst');

-- For salary_info
INSERT INTO salary_info (salary_id, emp_id, base_salary, bonus)
VALUES 
(1, 1, 50000, 5000),
(2, 2, 42000, 4000);

-- For course (assuming structure)
INSERT INTO course (course_id, course_name)
VALUES 
(101, 'Data Structures'),
(102, 'Databases'),
(103, 'Networks');

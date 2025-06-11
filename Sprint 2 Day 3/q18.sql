-- Single column
SELECT name FROM employee;

-- Multiple columns
SELECT name, salary FROM employee;

-- All columns
SELECT * FROM employee;

-- WHERE condition
SELECT * FROM employee WHERE department = 'HR';

-- ORDER BY
SELECT * FROM employee ORDER BY salary DESC;

-- LIMIT / FETCH
SELECT * FROM employee LIMIT 5;

--BETWEEN
SELECT * FROM employee WHERE salary BETWEEN 40000 AND 60000;
SELECT * FROM employee WHERE name BETWEEN 'A' AND 'M';

--IN
SELECT * FROM employee WHERE department IN ('HR', 'Finance');

--Like
SELECT * FROM employee WHERE name LIKE 'A%'; -- Starts with A
SELECT * FROM employee WHERE name LIKE '%n'; -- Ends with n



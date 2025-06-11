-- Single update
UPDATE employee
SET department = 'Marketing'
WHERE emp_id = 1;

-- Multiple updates
UPDATE salary_info
SET bonus = bonus + 1000
WHERE base_salary < 45000;

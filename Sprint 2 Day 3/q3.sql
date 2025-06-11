CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    department VARCHAR(50)
);
CREATE TABLE salary_info (
    salary_id INT PRIMARY KEY,
    emp_id INT,
    base_salary DECIMAL(10, 2),
    bonus DECIMAL(10, 2),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

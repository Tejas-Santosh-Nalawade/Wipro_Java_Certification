CREATE TABLE employees (
    employee_id     NUMBER(6) PRIMARY KEY,
    first_name      VARCHAR2(20),
    last_name       VARCHAR2(25),
    email           VARCHAR2(25),
    phone_number    VARCHAR2(20),
    hire_date       DATE,
    job_id          VARCHAR2(10),
    salary          NUMBER(8,2),
    commission_pct  NUMBER(2,2),
    manager_id      NUMBER(6),
    department_id   NUMBER(4)
);

INSERT INTO employees VALUES
(100,'Steven','King','SKING','5151234567',
TO_DATE('17-JUN-03','DD-MON-YY'),'AD_PRES',24000,NULL,NULL,90);

INSERT INTO employees VALUES
(101,'Neena','Kochhar','NKOCHHAR','5151234568',
TO_DATE('21-SEP-05','DD-MON-YY'),'AD_VP',17000,NULL,100,90);

INSERT INTO employees VALUES
(102,'Lex','De Haan','LDEHAAN','5151234569',
TO_DATE('13-JAN-01','DD-MON-YY'),'AD_VP',17000,NULL,100,90);

INSERT INTO employees VALUES
(103,'Alexander','Hunold','AHUNOLD','5151234570',
TO_DATE('03-JAN-06','DD-MON-YY'),'IT_PROG',9000,NULL,102,60);

INSERT INTO employees VALUES
(104,'Bruce','Ernst','BERNST','5151234571',
TO_DATE('21-MAY-07','DD-MON-YY'),'IT_PROG',6000,NULL,103,60);

INSERT INTO employees VALUES
(105,'David','Austin','DAUSTIN','5151234572',
TO_DATE('25-JUN-05','DD-MON-YY'),'IT_PROG',4800,NULL,103,60);

INSERT INTO employees VALUES
(106,'Valli','Pataballa','VPATABAL','5151234573',
TO_DATE('05-FEB-06','DD-MON-YY'),'IT_PROG',4800,NULL,103,60);

INSERT INTO employees VALUES
(107,'Diana','Lorentz','DLORENTZ','5151234574',
TO_DATE('07-FEB-07','DD-MON-YY'),'IT_PROG',4200,NULL,103,60);

INSERT INTO employees VALUES
(108,'Nancy','Greenberg','NGREENBE','5151234575',
TO_DATE('17-AUG-02','DD-MON-YY'),'FI_MGR',12000,NULL,101,100);

INSERT INTO employees VALUES
(109,'Daniel','Faviet','DFAVIET','5151234576',
TO_DATE('16-AUG-02','DD-MON-YY'),'FI_ACCOUNT',9000,0.15,108,100);

INSERT INTO employees VALUES
(110,'John','Chen','JCHEN','5151234577',
TO_DATE('28-SEP-05','DD-MON-YY'),'FI_ACCOUNT',8200,0.10,108,100);

INSERT INTO employees VALUES
(111,'Ismael','Sciarra','ISCIARRA','5151234578',
TO_DATE('30-SEP-05','DD-MON-YY'),'FI_ACCOUNT',7700,NULL,108,100);

INSERT INTO employees VALUES
(112,'Jose','Manuel','JMANUEL','5151234579',
TO_DATE('07-MAR-06','DD-MON-YY'),'FI_ACCOUNT',7800,0.20,108,100);

INSERT INTO employees VALUES
(113,'Luis','Popp','LPOPP','5151234580',
TO_DATE('07-DEC-07','DD-MON-YY'),'FI_ACCOUNT',6900,NULL,108,100);

INSERT INTO employees VALUES
(176,'Taylor','Matos','TMATOS','5151234600',
TO_DATE('15-JAN-94','DD-MON-YY'),'SA_REP',13000,0.30,NULL,50);

COMMIT;



--1)Employees earning more than $12,000
SELECT last_name, salary
FROM employees
WHERE salary > 12000;

--2)Last name and Department number for the employee 176 
SELECT last_name, department_id
FROM employees
WHERE employee_id = 176;

--3) Employees whose salary is NOT between $5,000 and $12,000
SELECT last_name, salary
FROM employees
WHERE salary NOT BETWEEN 5000 AND 12000;

--4) Employees with last names Matos and Taylor
SELECT last_name, job_id, hire_date
FROM employees
WHERE last_name IN ('Matos','Taylor')
ORDER BY hire_date ASC;

--5) Employees in department 20 or 50
SELECT last_name, department_id
FROM employees
WHERE department_id IN (20,50)
ORDER BY last_name;

--6) Employees earning between $5,000 and $12,000 in department 20 or 50
SELECT last_name AS Employee, salary AS "Monthly Salary"
FROM employees
WHERE salary BETWEEN 5000 AND 12000
AND department_id IN (20,50);

--7) Employees hired in 1994
SELECT last_name, hire_date
FROM employees
WHERE EXTRACT(YEAR FROM hire_date) = 1994;

--8) Employee without a manager

SELECT last_name, job_id
FROM employees
WHERE manager_id IS NULL;

--9) Employees earning commission
SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY 2 DESC,3 DESC;

--10)Salary greater than user-entered amount
SELECT last_name, salary
FROM employees
WHERE salary > &amount;

--11) Prompt for a manager ID and sort column
SELECT employee_id,last_name,salary,department_id
FROM employees
WHERE manager_id = &manager_id
ORDER BY &sorted_by;

--12) Display all employee last names in which the third letter is 'a'
SELECT last_name
FROM employees
WHERE last_name LIKE '__a%';

--13) Display the last names of all employees who have both an 'a' and an 'e' in their last name
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%'
AND last_name LIKE '%e%';

--14) Display the last name, job, and salary for all employees whose jobs are either those of a sales representative or of a stock clerk, 
--and whose salaries are not equal to $2500, $3500, or $7000

SELECT last_name,job_id,salary
FROM employees
WHERE job_id IN ('SA_REP', 'ST_CLERK')
AND salary NOT IN (2500, 3500, 7000);
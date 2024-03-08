CREATE DATABASE PQ01;
USE PQ01;

CREATE TABLE STAFF(
 ID INT(2) PRIMARY KEY,
 STAFF_NAME VARCHAR(50),
 STAFF_AGE VARCHAR(50),
 STAFF_ADDRESS VARCHAR(100),
 MONTHLY_PACKAGE INT(10)
);

CREATE TABLE PAYMENT(
PAYMENT_ID INT PRIMARY KEY,
DATE date,
STAFF_ID INT(2),
foreign key (STAFF_ID) references STAFF(ID),
AMOUNT INT(5));

INSERT INTO STAFF VALUES
(1, "ARAYAN", 22, "MUMBAI", 18000),
(2, "SUSHIL", 32, "DELHI", 20000),
(3, "MONTY", 25, "MOHALI", 22000),
(4, "AMIT", 20, "ALLAHABAD", 12000)
;

INSERT INTO PAYMENT VALUE
(101, '2009-12-30', 1, 3000),
(102, '2010-02-22', 3, 2500),
(103, '2010-02-23', 4, 3500)
;

SELECT STAFF_ID, STAFF_NAME, STAFF_AGE, AMOUNT
FROM STAFF S, PAYMENT P
WHERE S.ID = P.STAFF_ID;

SELECT STAFF.ID, PAYMENT.PAYMENT_ID
FROM STAFF
LEFT JOIN PAYMENT
ON STAFF.ID = PAYMENT.STAFF_ID;
-- 

CREATE TABLE emp (
    eno INT(2) PRIMARY KEY,
    ename VARCHAR(15),
    bdate DATE,
    title VARCHAR(15),
    salary INT(10),
    dno INT(5)
);

CREATE TABLE proj (
    pno INT(2) PRIMARY KEY,
    pname VARCHAR(15),
    budget INT(5),
    dno INT(5)
);


CREATE TABLE dept (
    dno INT(2) PRIMARY KEY,
    dname VARCHAR(15),
    mgreno VARCHAR(15)
);

CREATE TABLE workson (
    eno INT(2),
    pno INT(2),
    resp VARCHAR(15),
    hours INT(5),
    FOREIGN KEY (eno) REFERENCES emp(eno),
    FOREIGN KEY (pno) REFERENCES proj(pno)
);

INSERT INTO emp (eno, ename, bdate, title, salary, dno)
VALUES
    (1, 'John Doe', '1990-01-15', 'Manager', 80000, 101),
    (2, 'Jane Smith', '1985-05-20', 'Engineer', 75000, 102),
    (3, 'Bob Johnson', '1992-11-10', 'Analyst', 60000, 101),
    (4, 'Jeel Tikiwala', '1990-01-15', 'EE', 40000, 101),
    (5, 'Will Smith', '1985-05-20', 'SA', 45000, 102),
    (6, 'Bob the Builder', '1992-11-10', 'Developer', 38000, 101),
    (7, 'Alice Keys', '1988-09-05', 'EE', 42000, 103);
    
INSERT INTO proj (pno, pname, budget, dno)
VALUES
    (101, 'Project A', 150000, 101),
    (102, 'Project B', 120000, 102),
    (103, 'Project C', 200000, 101),
	(104, 'Project X', 120000, 104),
    (105, 'Project Y', 150000, 105),
    (106, 'Project Z', 90000, 106);

INSERT INTO dept (dno, dname, mgreno)
VALUES
    (101, 'HR', 'Mary Johnson'),
    (102, 'Engineering', 'Michael Smith'),
    (103, 'Finance', 'Sarah Davis');

INSERT INTO workson (eno, pno, resp, hours)
VALUES
    (1, 101, 'Manager', 40),
    (2, 101, 'Engineer', 35),
    (3, 102, 'Analyst', 30);
    



-- 1st Question 
SELECT pno, pname
FROM proj
WHERE budget > 100000;

-- 2nd Question
select resp, hours
from workson
WHERE hours < 10 && resp = 'Manager';

-- 3rd Question
SELECT eno, ename
FROM emp
WHERE (title = 'EE' OR title = 'SA') AND salary > 35000;

-- 4th Question
SELECT ename
FROM emp
WHERE dno = 'D1'
ORDER BY salary DESC;

-- 5th Question
select * 
from dept
ORDER BY dname asc;

-- 6th Question
SELECT emp.ename, dept.dname, emp.title
FROM emp
JOIN dept ON emp.dno = dept.dno;

-- 7th Question
SELECT proj.pname, workson.hours, proj.pno
FROM proj
JOIN workson ON proj.pno = workson.pno
WHERE hours > 10;

-- 8th Question
SELECT proj.pname , dept.dname,  proj.budget
FROM proj
JOIN dept ON proj.dno = dept.dno
WHERE budget < 50000;

-- 9th Question
SELECT emp.eno, emp.salary
FROM emp
JOIN dept ON emp.dno = dept.dno
WHERE dept.dname = 'Consulting'
ORDER BY emp.salary DESC;

-- 10th Question
SELECT emp.ename, proj.pname, emp.title, workson.hours
FROM emp
JOIN workson ON emp.eno = workson.eno
JOIN proj ON workson.pno = proj.pno;

create table employeee(
EMP_NAME VARCHAR(50),
ADDRESS VARCHAR(50),
SALARY INT(10)
);

INSERT INTO employeee
VALUES('Mike', 'New York', 20000);
select * from employeee;


CREATE table ARTIST(
Art_id int PRIMARY KEY,
Art_name VARCHAR(50),
Art_Gender VARCHAR(50)
);

CREATE TABLE PRODUCER(
Prod_id int PRIMARY KEY,
Prod_name VARCHAR(50),
Prod_Phone int
);

CREATE TABLE FILMS (
    Film_id int PRIMARY KEY,
    Film_title VARCHAR(50),
    Film_Year int,
    Film_Lang VARCHAR(50),
    Prod_id int, -- Add Prod_id column
    FOREIGN KEY (Prod_id) REFERENCES PRODUCER(Prod_id)
);

CREATE TABLE CASTING (
    Art_id int,
    FOREIGN KEY (Art_id) REFERENCES ARTIST(Art_id),
    Film_id int,
    FOREIGN KEY (Film_id) REFERENCES FILMS(Film_id),
    Part VARCHAR(50)
);

CREATE TABLE REVIEW(
Film_id int,
FOREIGN KEY (Film_id) REFERENCES FILMS(Film_id),
Stars varchar(50)
);


SELECT PROD_ID 
FROM PRODUCER 
WHERE PROD_NAME = 'FilmCo Ltd.';

SELECT A.ART_NAME,  F.FILM_TITLE, F.FILM_YEAR 
FROM ARTIST A, CASTING C, FILMS F
WHERE A.ART_ID=C.ART_ID 
AND C.FILM_ID=F.FILM_ID 
AND F.FILM_YEAR  BETWEEN 2016 AND 2018;

-- SELECT PROD_ID 
-- FROM PRODUCER 
-- WHERE PROD_NAME = ‘NIRAJ’
-- Then find the FILM_ID from the FILMS table using this PROD_ID.
-- SELECT FILM_ID FROM FILMS 
-- WHERE PROD_ID IN (SELECT PROD_ID 
-- FROM PRODUCER 
-- WHERE PROD_NAME = ‘NIRAJ’);


CREATE DATABASE NOV;



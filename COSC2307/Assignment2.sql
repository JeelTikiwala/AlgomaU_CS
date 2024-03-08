-- Name: Jeel Tikiwala
-- Subject: Database programming Assignment 2
-- Student id: 239659420


-- Question 1
-- Employee Table
CREATE TABLE EMPLOYEE (
SIN char (9) not null ,
Fname varchar (15) not null ,
Lname varchar (15) not null ,
Minit char ,
Bdate date ,
Address varchar (30) ,
Sex char ,
Salary decimal (10 , 2 ) ,
Super_Id char (9) ,
Dno integer not null ,
primary key (SIN) 
);

-- Department table
CREATE TABLE DEPARTMENT (
Dnumber integer not null ,
Dname varchar (15) not null ,
Mgr_SIN char (9) not null ,
Mgr_start_date date ,
primary key (Dnumber) ,
foreign key (Mgr_SIN) references employee(SIN)
);

-- DEPT_LOC
CREATE TABLE DEPT_LOC (
Dnumber integer not null ,
Dlocation varchar (15) not null ,
primary key (Dnumber , Dlocation ) ,
foreign key (Dnumber ) references department (Dnumber)
);

-- Project
CREATE TABLE PROJECT (
Pnumber integer not null ,
Pname varchar (15) not null ,
Plocation varchar ( 15 ) ,
Dnum integer not null ,
primary key (Pnumber) ,
foreign key (Dnum) references department (Dnumber)
);

-- Workson Table
CREATE TABLE WORKSON (
E_SIN char (9) not null ,
Pno integer not null ,
Hours decimal ( 3 , 1) not null ,
primary key (E_SIN , Pno ) ,
foreign key (E_SIN) references employee (SIN) ,
foreign key (Pno) references project (Pnumber)
);

CREATE TABLE DEPENDENT (
E_SIN char (9) not null ,
Dependent_name varchar (15) not null ,
Sex char ,
Bdate date ,
Relationship varchar ( 8 ) ,
primary key (E_SIN , Dependent_name ) ,
foreign key (E_SIN) references employee (SIN)
);


-- Add foreign Key
ALTER TABLE EMPLOYEE
ADD FOREIGN KEY
(Dno) references department (Dnumber);

-- Question 2
create table course ( 
    cnum        varchar(5) not null, 
    cname       varchar(40) not null, 
    primary key (cnum) );

create table professor ( 
    pnum        integer not null, 
    pname       varchar(20) not null, 
    office      varchar(10) not null, 
    dept        varchar(30) not null, 
    primary key (pnum) );
    
create table student ( 
    snum        integer not null, 
    sname       varchar(20) not null, 
    year        integer not null, 
    primary key (snum) );
    
create table class ( 
    cnum        varchar(5) not null, 
    term        varchar(5) not null, 
    section     integer not null, 
    pnum        integer not null, 
    primary key (cnum, term, section), 
    foreign key (cnum) references course (cnum), 
    foreign key (pnum) references professor (pnum) );
    
create table enrollment ( 
    snum        integer not null, 
    cnum        varchar(5) not null, 
    term        varchar(5) not null, 
    section     integer not null, 
    primary key (snum, cnum, term, section), 
    foreign key (snum) references student (snum), 
    foreign key (cnum, term, section) references class (cnum, term, section) );

create table mark ( 
    snum        integer not null, 
    cnum        varchar(5) not null, 
    term        varchar(5) not null, 
    section     integer not null, 
    grade       integer not null, 
    primary key (snum, cnum, term, section), 
    foreign key (snum, cnum, term, section) 
    references enrollment (snum, cnum, term, section) );
    
    
    create table schedule ( 
    cnum        varchar(5) not null, 
    term        varchar(5) not null, 
    section     integer not null, 
    day         varchar(10) not null, 
    time        varchar(5) not null, 
    room        varchar(10) not null, 
    primary key (cnum, term, section, day, time),
    foreign key (cnum, term, section) 
    references class (cnum, term, section) );


insert into course values ('CS448', 'Introduction to Databases');

insert into professor values (1, 'Weddell, Grant', 'DC3346', 'Computer Science');
insert into professor values (2, 'Ilyas, Ihab', 'DC3348', 'Computer Science');

insert into student values (1, 'Jones, Fred', 4);

insert into class values ('CS448', 'S2006', 1, 1);
insert into class values ('CS448', 'S2006', 2, 1);

insert into enrollment values (1, 'CS448', 'S2006', 2);

insert into schedule values ('CS448', 'S2006', 1, 'Monday', '09:30', 'MC4063');
insert into schedule values ('CS448', 'S2006', 1, 'Wednesday', '09:30', 'MC4063');
insert into schedule values ('CS448', 'S2006', 1, 'Friday', '09:30', 'MC4063');
insert into schedule values ('CS448', 'S2006', 2, 'Monday', '11:30', 'MC4058');
insert into schedule values ('CS448', 'S2006', 2, 'Wednesday', '11:30', 'MC4058');
insert into schedule values ('CS448', 'S2006', 2, 'Friday', '11:30', 'MC4058');

-- Question a
select distinct p.pnum, p.pname, p.dept
from professor as p ,
class as c,
schedule as s
where exists
(select * from mark as m, enrollment as e
where c.cnum = e.cnum
and c.term = e.term
and c.section = e.section
and e.cnum = m. cnum
and e.term = m. term
and e.section = m.section )
and c.cnum = s.cnum
and c.term = s.term
and c.section = s.section
and s.day = 'Monday '
and c.pnum = p.pnum;


-- Question b
SELECT COUNT(p.pnum) AS Total
FROM enrollment AS e,
     professor AS p,
     class AS c,
     student AS s
WHERE c.cnum = 'CS350'
  AND c.cnum = e.cnum
  AND c.term = e.term
  AND c.section = e.section
  AND s.snum = e.snum
  AND p.pnum = c.pnum
  AND NOT EXISTS (
    SELECT 1
    FROM mark
    WHERE mark.cnum = e.cnum
      AND mark.term = e.term
      AND mark.section = e.section
  );
  
  -- Question c
SELECT c.cnum, c.cname, m.grade
FROM course AS c, class AS cl, mark AS m, enrollment AS e
WHERE e.snum = 2234
AND e.snum = m.snum
AND cl.cnum = e.cnum
AND cl.term = e.term
AND cl.section = e.section
AND e.cnum = m.cnum
AND e.term = m.term
AND e.section = m.section
AND cl.cnum = c.cnum;

-- Question d
SELECT s.snum, s.sname, s.year
FROM student AS s
WHERE s.year <> 1
AND EXISTS (
  SELECT 1
  FROM mark AS m
  WHERE m.snum = s.snum
)
AND NOT EXISTS (
  SELECT 1
  FROM mark AS m
  WHERE m.snum = s.snum
  AND m.grade > 90
)
AND NOT EXISTS (
  SELECT 1
  FROM professor AS p, class AS cl, enrollment AS e
  WHERE p.dept = 'Philosophy'
  AND p.pnum = cl.pnum
  AND cl.cnum = e.cnum
  AND cl.term = e.term
  AND cl.section = e.section
  AND e.snum = s.snum
);

-- Question e
SELECT p.pnum, p.pname, p.dept
FROM professor p
WHERE NOT EXISTS (
  SELECT 1
  FROM class c, schedules s
  WHERE c.cnum = s.cnum
  AND c.term = s.term
  AND c.section = s.section
  AND c.pnum = p.pnum
  AND s.day IN ('Monday', 'Friday')
  AND NOT EXISTS (
    SELECT 1
    FROM mark m, enrollment e
    WHERE e.cnum = c.cnum
    AND e.term = c.term
    AND e.section = c.section
    AND m.cnum = e.cnum
    AND m.term = e.term
    AND m.section = e.section
  )
)
ORDER BY p.dept, p.pname;


-- Question f
SELECT DISTINCT c.cnum, c.term, c.section, p.pnum, p.pname
FROM professor p, class c
WHERE p.pnum = c.pnum
AND EXISTS (
  SELECT 1
  FROM mark m, enrollment e
  WHERE e.cnum = c.cnum
  AND e.term = c.term
  AND e.section = c.section
  AND m.cnum = e.cnum
  AND m.term = e.term
  AND m.section = e.section
);

-- Question g
SELECT e.cnum, COUNT(*) AS numOfEnrollment
FROM enrollment e
GROUP BY e.cnum
HAVING COUNT(*) IN (
  SELECT a.c
  FROM (
    SELECT DISTINCT COUNT(*) AS c
    FROM enrollment e
    GROUP BY e.cnum
  ) a
  WHERE (
    SELECT DISTINCT COUNT(*) AS c
    FROM (
      SELECT DISTINCT COUNT(*) AS c
      FROM enrollment e
      GROUP BY e.cnum
    ) b
    WHERE a.c > b.c
  ) < 3
);

-- question h
SELECT p.pname, p.pnum, cl.cnum, cl.term, cl.section, COUNT(*) AS numOfStudent
FROM student AS s, professor AS p, class AS cl, enrollment AS e
WHERE s.year = 3
AND e.snum = s.snum
AND e.cnum = cl.cnum
AND e.term = cl.term
AND e.section = cl.section
AND p.pnum = cl.pnum
AND NOT EXISTS (
  SELECT *
  FROM mark AS m, enrollment AS e2
  WHERE cl.cnum = e2.cnum
  AND cl.term = e2.term
  AND cl.section = e2.section
  AND e2.cnum = m.cnum
  AND e2.term = m.term
  AND e2.section = m.section
)
GROUP BY p.pname, p.pnum, cl.cnum, cl.term, cl.section
ORDER BY p.pname, p.pnum, cl.cnum, cl.term, cl.section;

-- question i
SELECT MAX(grade) AS maxGrade, MIN(grade) AS minGrade,
       p.pnum, p.pname, c.cnum, c.cname, cl.term, cl.section
FROM professor AS p, course AS c, class AS cl, mark AS m, enrollment AS e
WHERE cl.cnum = c.cnum
  AND p.pnum = cl.pnum
  AND p.dept = 'Statistics'
  AND cl.cnum = e.cnum
  AND cl.term = e.term
  AND cl.section = e.section
  AND e.cnum = m.cnum
  AND e.term = m.term
  AND e.section = m.section
GROUP BY p.pnum, p.pname, c.cnum, c.cname, cl.term, cl.section;

-- question j
SELECT (a.c * 100) / b.c AS percentage
FROM
(
    SELECT COUNT(DISTINCT dept) AS c
    FROM professor
    WHERE pnum NOT IN
    (
        SELECT pnum
        FROM class c
        WHERE NOT EXISTS
        (
            SELECT *
            FROM mark m, enrollment e
            WHERE e.cnum = c.cnum
            AND e.term = c.term
            AND e.section = c.section
            AND m.cnum = e.cnum
            AND m.term = e.term
            AND m.section = e.section
        )
        GROUP BY term, pnum
        HAVING COUNT(*) <= 1
    )
) AS a,
(
    SELECT COUNT(DISTINCT dept) AS c
    FROM professor
) AS b;

CREATE TABLE Products(
ProductID int PRIMARY KEY,
ProductName varchar(50),
SupplierID int,
CategoryID int,
Unit varchar(50),
Price int
);

INSERT INTO Products 
VALUES(1, "Chain", 1,1, "10boxies x 20 =bags", 18),
(2, "Chang", 1,1, "24-12 bottles", 19),
(3, "Annised Syrup", 1,2, "15-220ml bottles", 10),
(4, "Chef Cajun", 1,2, "48oz", 22),
(5, "Chef Mix", 1,2, "36 boxes", 21);

SELECT * FROM Products
WHERE PRICE BETWEEN 10 AND 20;

SELECT * FROM Products
WHERE PRICE NOT BETWEEN 10 AND 20;
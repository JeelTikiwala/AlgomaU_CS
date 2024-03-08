show databases;

-- create database IMDB
create database IMDB;

-- use database IMDB
use IMDB;

-- create the ACTOR table
CREATE TABLE ACTOR (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Primary Key with auto increment
    fname VARCHAR(255) NOT NULL, 
    lname VARCHAR(255) NOT NULL,
    gender CHAR(1)
);

SELECT * FROM MOVIE_DIRECTOR;

-- create the MOVIE table
CREATE TABLE MOVIE (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Primary Key with auto increment
    name VARCHAR(255) NOT NULL,
    year INT,
    movie_rank DECIMAL(5, 2)
);


-- create the DIRECTOR table
CREATE TABLE DIRECTOR (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Primary Key with auto increment
    fname VARCHAR(255) NOT NULL,
    lname VARCHAR(255) NOT NULL
);

-- create the CAST table
CREATE TABLE CAST (
    pid INT,
    mid INT,
    role VARCHAR(255),
    FOREIGN KEY (pid) REFERENCES ACTOR(id), -- Foreign key 
    FOREIGN KEY (mid) REFERENCES MOVIE(id) -- Foreign key
);


-- create the CAST table
CREATE TABLE MOVIE_DIRECTOR (
    did INT,
    mid INT,
    FOREIGN KEY (did) REFERENCES DIRECTOR(id), -- Foreign key
    FOREIGN KEY (mid) REFERENCES MOVIE(id) -- Foreign key
);

INSERT INTO ACTOR(id, fname, lname, gender)
VALUES
(1, 'Amitabh', 'Bachchan', 'M'),
(2, 'Shahrukh', 'Khan', 'M'),
(3, 'Aamir', 'Khan', 'M'),
(4, 'Salman', 'Khan', 'M'),
(5, 'Deepika', 'Padukone', 'F'),
(6, 'Priyanka', 'Chopra', 'F'),
(7, 'Kareena', 'Kapoor', 'F'),
(8, 'Ranbir', 'Kapoor', 'M'),
(9, 'Alia', 'Bhatt', 'F'),
(10, 'Akshay', 'Kumar', 'M'),
(11, 'Hrithik', 'Roshan', 'M'),
(12, 'Aishwarya', 'Rai', 'F'),
(13, 'Ranveer', 'Singh', 'M'),
(14, 'Kangana', 'Ranaut', 'F'),
(15, 'Anushka', 'Sharma', 'F'),
(16, 'Varun', 'Dhawan', 'M'),
(17, 'Irrfan', 'Khan', 'M'),
(18, 'Vidya', 'Balan', 'F'),
(19, 'Saif', 'Ali', 'M'),
(20, 'Katrina', 'Kaif', 'F'),
(21, 'Shahid', 'Kapoor', 'M'),
(22, 'Ayushmann', 'Khurrana', 'M'),
(23, 'Kajol', 'Devgan', 'F'),
(24, 'Ajay', 'Devgn', 'M'),
(25, 'Madhuri', 'Dixit', 'F'),
(26, 'Karan', 'Johar', 'M'),
(27, 'Rani', 'Mukerji', 'F'),
(28, 'Naseeruddin', 'Shah', 'M'),
(29, 'Shabana', 'Azmi', 'F'),
(30, 'Dev', 'Patel', 'M'),
(31, 'Freida', 'Pinto', 'F'),
(32, 'Leonardo', 'DiCaprio', 'M'),
(33, 'Meryl', 'Streep', 'F'),
(34, 'Tom', 'Hanks', 'M'),
(35, 'Angelina', 'Jolie', 'F'),
(36, 'Brad', 'Pitt', 'M'),
(37, 'Jennifer', 'Aniston', 'F'),
(38, 'Johnny', 'Depp', 'M'),
(39, 'Scarlett', 'Johansson', 'F'),
(40, 'Robert', 'Downey', 'M'),
(41, 'Julia', 'Roberts', 'F'),
(42, 'Will', 'Smith', 'M'),
(43, 'Charlize', 'Theron', 'F'),
(44, 'Chris', 'Hemsworth', 'M'),
(45, 'Emma', 'Watson', 'F'),
(46, 'Dwayne', 'Johnson', 'M'),
(47, 'Gal', 'Gadot', 'F'),
(48, 'Vin', 'Diesel', 'M'),
(49, 'Sandra', 'Bullock', 'F'),
(50, 'Matt', 'Damon', 'M');


INSERT INTO MOVIE (name, year, movie_rank) VALUES
('Sholay', 1975, 8.2),
('Deewar', 1975, 8.0),
('Zanjeer', 1973, 7.6),
('Dilwale Dulhania Le Jayenge', 1995, 8.1),
('Kabhi Khushi Kabhie Gham', 2001, 7.4),
('Lagaan', 2001, 8.1),
('Dangal', 2016, 8.4),
('Bajrangi Bhaijaan', 2015, 8.0),
('Sultan', 2016, 7.0),
('Padmaavat', 2018, 7.0),
('Chennai Express', 2013, 6.0),
('Bajirao Mastani', 2015, 7.2),
('Don', 2006, 7.1),
('Kabhi Khushi Kabhie Gham', 2001, 7.4),
('Jab We Met', 2007, 7.9),
('Rockstar', 2011, 7.7),
('Barfi!', 2012, 8.1),
('Raazi', 2018, 7.7),
('Gully Boy', 2019, 8.0),
('Toilet: Ek Prem Katha', 2017, 7.2),
('Kesari', 2019, 7.4),
('Koi... Mil Gaya', 2003, 7.1),
('Dhoom 2', 2006, 6.5),
('Devdas', 2002, 7.6),
('Jodhaa Akbar', 2008, 7.6),
('Goliyon Ki Raasleela Ram-Leela', 2013, 6.4),
('Bajirao Mastani', 2015, 7.2),
('Queen', 2013, 8.1),
('Tanu Weds Manu', 2011, 6.6),
('PK', 2014, 8.1),
('Sultan', 2016, 7.0),
('Badlapur', 2015, 7.4),
('Badrinath Ki Dulhania', 2017, 6.2),
('Piku', 2015, 7.6),
('The Lunchbox', 2013, 7.8),
('Kahaani', 2012, 8.1),
('The Dirty Picture', 2011, 6.6),
('Omkara', 2006, 8.0),
('Dil Chahta Hai', 2001, 8.1),
('Ek Tha Tiger', 2012, 5.4),
('Zindagi Na Milegi Dobara', 2011, 8.1);



INSERT INTO DIRECTOR (id, fname, lname) VALUES
(1, 'Ramesh', 'Sippy'),
(2, 'Yash', 'Chopra'),
(3, 'Prakash', 'Mehra'),
(4, 'Aditya', 'Chopra'),
(5, 'Karan', 'Johar'),
(6, 'Ashutosh', 'Gowariker'),
(7, 'Nitesh', 'Tiwari'),
(8, 'Kabir', 'Khan'),
(9, 'Ali', 'Abbas Zafar'),
(10, 'Sanjay', 'Leela Bhansali'),
(11, 'Rohit', 'Shetty'),
(12, 'Meghna', 'Gulzar'),
(13, 'Zoya', 'Akhtar'),
(14, 'Shree', 'Narayan Singh'),
(15, 'Anurag', 'Singh'),
(16, 'Rakesh', 'Roshan'),
(17, 'Sanjay', 'Gadhvi'),
(18, 'Vikas', 'Bahl'),
(19, 'Anand', 'L. Rai'),
(20, 'Rajkumar', 'Hirani'),
(21, 'David', 'Dhawan'),
(22, 'Shoojit', 'Sircar'),
(23, 'Ritesh', 'Batra'),
(24, 'Sujoy', 'Ghosh'),
(25, 'Milan', 'Luthria'),
(26, 'Vishal', 'Bhardwaj'),
(27, 'Kabir', 'Khan'),
(28, 'Zoya', 'Akhtar'),
(29, 'Steven', 'Spielberg'),
(30, 'Christopher', 'Nolan'),
(31, 'Martin', 'Scorsese'),
(32, 'Quentin', 'Tarantino'),
(33, 'James', 'Cameron'),
(34, 'Francis', 'Ford Coppola'),
(35, 'Ridley', 'Scott'),
(36, 'Alfred', 'Hitchcock'),
(37, 'Stanley', 'Kubrick'),
(38, 'Coen', 'Brothers'),
(39, 'Gore', 'Verbinski'),
(40, 'Tim', 'Burton'),
(41, 'M. Night', 'Shyamalan'),
(42, 'Wes', 'Anderson'),
(43, 'David', 'Fincher'),
(44, 'Ron', 'Howard'),
(45, 'Peter', 'Jackson'),
(46, 'Michael', 'Bay'),
(47, 'David', 'Yates'),
(48, 'Ang', 'Lee'),
(49, 'Mel', 'Gibson'),
(50, 'Sam', 'Raimi');


INSERT INTO CAST (pid, mid, role) VALUES
-- Amitabh Bachchan movies cast
(1, 1, 'Jai'),
(2, 1, 'Veeru'),
-- Shahrukh Khan movies cast
(2, 2, 'Rahul'),
(5, 2, 'Simran'),
-- Aamir Khan movies cast
(3, 3, 'Bhuvan'),
(7, 3, 'Elizabeth'),
-- Salman Khan movies cast
(4, 4, 'Pavan'),
(9, 4, 'Aarfa'),
-- Deepika Padukone movies cast
(5, 5, 'Padmavati'),
(13, 5, 'Alauddin Khilji'),
-- Priyanka Chopra movies cast
(6, 6, 'Kashibai'),
(16, 6, 'Bajirao'),
-- Kareena Kapoor movies cast
(7, 7, 'Pooja'),
(21, 7, 'Rahul'),
-- Ranbir Kapoor movies cast
(8, 8, 'Jordan'),
(24, 8, 'Heer'),
-- Alia Bhatt movies cast
(9, 9, 'Sehmat'),
(32, 9, 'Billy'),
-- Akshay Kumar movies cast
(10, 10, 'Keshav'),
(40, 10, 'Tony Stark'),
-- Hrithik Roshan movies cast
(11, 11, 'Rohit'),
(44, 11, 'Thor'),
-- Aishwarya Rai movies cast
(12, 12, 'Paro'),
(47, 12, 'Marley'),
-- Ranveer Singh movies cast
(13, 13, 'Ram'),
(48, 13, 'Dominic'),
-- Kangana Ranaut movies cast
(14, 14, 'Rani Mehra'),
(49, 14, 'Ryan'),
-- Anushka Sharma movies cast
(15, 15, 'Rukhsar'),
(50, 15, 'Jason');

INSERT INTO MOVIE_DIRECTOR (did, mid) VALUES
-- Amitabh Bachchan movies and directors
(1, 1), -- Sholay
(2, 2), -- Deewar
-- Shahrukh Khan movies and directors
(3, 3), -- Dilwale Dulhania Le Jayenge
(4, 4), -- Kabhi Khushi Kabhie Gham
-- Aamir Khan movies and directors
(5, 5), -- Lagaan
(6, 6), -- Dangal
-- Salman Khan movies and directors
(7, 7), -- Bajrangi Bhaijaan
(8, 8), -- Sultan
-- Deepika Padukone movies and directors
(9, 9),  -- Padmaavat
(10, 10), -- Chennai Express
-- Priyanka Chopra movies and directors
(11, 11), -- Bajirao Mastani
(12, 12), -- Don
-- Kareena Kapoor movies and directors
(13, 13), -- Kabhi Khushi Kabhie Gham
(14, 14), -- Jab We Met
-- Ranbir Kapoor movies and directors
(15, 15), -- Rockstar
(16, 16), -- Barfi!
-- Alia Bhatt movies and directors
(17, 17), -- Raazi
(18, 18), -- Gully Boy
-- Akshay Kumar movies and directors
(19, 19), -- Toilet: Ek Prem Katha
(20, 20), -- Kesari
-- Hrithik Roshan movies and directors
(21, 21), -- Koi... Mil Gaya
(22, 22), -- Dhoom 2
-- Aishwarya Rai movies and directors
(23, 23), -- Devdas
(24, 24), -- Jodhaa Akbar
-- Ranveer Singh movies and directors
(25, 25), -- Goliyon Ki Raasleela Ram-Leela
(26, 26), -- Bajirao Mastani
-- Kangana Ranaut movies and directors
(27, 27), -- Queen
(28, 28), -- Tanu Weds Manu
-- Anushka Sharma movies and directors
(29, 29), -- PK
(30, 30); -- Sultan


-- 1st Question(a)
SELECT DISTINCT fname, lname
FROM ACTOR
JOIN CAST ON ACTOR.id = CAST.pid
JOIN MOVIE ON MOVIE.id = CAST.mid
WHERE (MOVIE.year >= 1850 AND MOVIE.year < 1900)
  AND (MOVIE.year >= 1900 AND MOVIE.year < 1950);

-- 1nd Question(b)
SELECT DISTINCT fname, lname
FROM DIRECTOR
JOIN MOVIE_DIRECTOR ON DIRECTOR.id = MOVIE_DIRECTOR.did
JOIN MOVIE ON MOVIE.id = MOVIE_DIRECTOR.did
WHERE YEAR(MOVIE.year) % 4 = 0;

-- 2nd Question
SELECT DISTINCT name 
FROM Movie 
WHERE year = (SELECT year FROM Movie WHERE name = 'Shrek' LIMIT 1)
AND 
movie_rank > (SELECT movie_rank FROM Movie WHERE name = 'Shrek' LIMIT 1);


-- 3rd Question
SELECT fname, lname
FROM ACTOR
JOIN CAST ON ACTOR.id = CAST.pid
JOIN MOVIE ON MOVIE.id = CAST.mid
WHERE MOVIE.name = 'Officer 444';



-- 4th Question
SELECT fname, lname, COUNT(MOVIE_DIRECTOR.did) AS nfilms
FROM DIRECTOR
JOIN MOVIE_DIRECTOR ON DIRECTOR.id = MOVIE_DIRECTOR.did
GROUP BY id, fname, lname
ORDER BY nfilms DESC;


-- 5th Question(a)
SELECT name, count(CAST.pid) as CAST_SIZE
FROM MOVIE
JOIN CAST ON MOVIE.id = CAST.mid
GROUP BY name
ORDER BY CAST_SIZE DESC;

-- 5th Question(b)
SELECT name, COUNT(cast.pid) AS CAST_SIZE
FROM MOVIE
JOIN CAST ON MOVIE.id = CAST.mid
GROUP BY name
ORDER BY CAST_SIZE ASC;


-- 6th Question
SELECT fname, lname 
FROM ACTOR
JOIN Cast ON ACTOR.id = CAST.pid
JOIN MOVIE ON CAST.mid = MOVIE.id
JOIN MOVIE_DIRECTOR ON MOVIE.id = MOVIE_DIRECTOR.mid
GROUP BY fname, lname, MOVIE_DIRECTOR.did
HAVING count(*)>=10;

-- 7th Question 
SELECT fname, lname 
FROM ACTOR 
JOIN Cast ON ACTOR.id = CAST.pid
JOIN Movie ON CAST.mid = MOVIE.id
WHERE MOVIE.year < 1960;

-- 8th Question
SELECT name
FROM MOVIE
JOIN CAST ON MOVIE.id = CAST.mid
JOIN ACTOR ON CAST.pid = ACTOR.id
GROUP BY MOVIE.id, name
HAVING SUM(CASE WHEN ACTOR.gender = 'F' THEN 1 ELSE 0 END) > SUM(CASE WHEN ACTOR.gender = 'M' THEN 1 ELSE 0 END);

-- 9th Question
SELECT A1.fname AS male_fname, A1.lname AS male_lname, A2.fname AS female_fname, A2.lname AS female_lname, COUNT(DISTINCT M1.id) AS nfilms
FROM ACTOR A1
JOIN CAST C1 ON A1.id = C1.pid
JOIN MOVIE M1 ON C1.mid = M1.id
JOIN CAST C2 ON M1.id = C2.mid
JOIN ACTOR A2 ON C2.pid = A2.id
WHERE A1.gender = 'M' AND A2.gender = 'F'
GROUP BY A1.id, A1.fname, A1.lname, A2.id, A2.fname, A2.lname
ORDER BY nfilms DESC;

-- 10th Question
SELECT A.fname, A.lname, M.name AS debut_film, A.debut_year
FROM (
    SELECT ACTOR.id, ACTOR.fname, ACTOR.lname, MIN(MOVIE.year) AS debut_year
    FROM ACTOR
    JOIN CAST ON ACTOR.id = CAST.pid
    JOIN MOVIE ON CAST.mid = MOVIE.id
    GROUP BY ACTOR.id, ACTOR.fname, ACTOR.lname
) AS A
JOIN CAST ON A.id = CAST.pid
JOIN MOVIE M ON CAST.mid = M.id AND M.year = A.debut_year
ORDER BY A.lname;

-- 11th Question
SELECT DISTINCT A3.fname, A3.lname
FROM ACTOR A1
JOIN CAST C1 ON A1.id = C1.pid
JOIN MOVIE M1 ON C1.mid = M1.id
JOIN CAST C2 ON M1.id = C2.mid
JOIN ACTOR A2 ON C2.pid = A2.id
JOIN CAST C3 ON A2.id = C3.pid
JOIN MOVIE M2 ON C3.mid = M2.id
JOIN CAST C4 ON M2.id = C4.mid
JOIN ACTOR A3 ON C4.pid = A3.id
WHERE A1.fname = 'Kevin' AND A1.lname = 'Bacon'
  AND A3.id <> A1.id AND A3.id <> A2.id;


-- 12th Question
-- Finding all actors with finite Bacon numbers requires a sophisticated and 
-- big SQL query. The database schema and the quantity of actors and films in 
-- the database would determine the precise size of the query. 
-- To navigate the co-acting graph and find actors with finite Bacon numbers, 
-- recursive subqueries or joins would probably be required. 
-- In actuality, such a query could be too long and difficult to express succinctly.

-- 13th Question
SELECT
  CONCAT(LEFT(year, 3), '0s') AS decade,
  COUNT(*) AS no_of_films
FROM MOVIE
GROUP BY decade
ORDER BY no_of_films DESC;

-- 14th Question
SELECT
  A.id AS actor_id,
  A.fname AS first_name,
  A.lname AS last_name,
  COUNT(DISTINCT C.mid) AS num_movies,
  AVG(M.movie_rating) AS avg_movie_rating,
  RANK() OVER (ORDER BY COUNT(DISTINCT C.mid) DESC, AVG(M.movie_rating) DESC) AS popularity_rank
FROM
  ACTOR A
JOIN
  CAST C ON A.id = C.pid
JOIN
  MOVIE M ON C.mid = M.id
GROUP BY
  A.id, A.fname, A.lname
ORDER BY
  popularity_rank DESC;


 


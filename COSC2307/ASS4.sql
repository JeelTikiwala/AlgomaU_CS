-- Name: Jeel Tikiwala
-- Student ID: 239659420
-- Assignment 4
create database ass4;
use ass4;

-- Artist table(3)--
CREATE TABLE Artist
(ArtistId INT PRIMARY KEY NOT NULL,
 Name VARCHAR(100));
 
-- Album table(4)--
CREATE TABLE Album(
 AlbumId INT PRIMARY KEY NOT NULL,
 Title VARCHAR(100) NOT NULL,
 ArtistId INT NOT NULL,
 FOREIGN KEY (ArtistId) REFERENCES Artist (ArtistId));
 
-- Customer table(6) -- 
CREATE TABLE Customer(
 CustomerId INT PRIMARY KEY NOT NULL,
 FirstName VARCHAR(50) NOT NULL,
 LastName VARCHAR(50) NOT NULL,
 Company VARCHAR(100),
 Address VARCHAR(100),
 City VARCHAR(50),
 State VARCHAR(50),
 Country VARCHAR(50),
 PostalCode VARCHAR(10),
 Phone VARCHAR(20),
 Fax VARCHAR(20),
 Email VARCHAR(50) NOT NULL,
 SupportRepId INT,
 FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId)
);

-- Dmployee table(5)-
CREATE TABLE Employee(
 EmployeeId INT PRIMARY KEY NOT NULL,
 LastName VARCHAR(50) NOT NULL,
 FirstName VARCHAR(50) NOT NULL,
 Title VARCHAR(50),
 ReportsTo INT,
 BirthDate TIMESTAMP,
 HireDate TIMESTAMP,
 Address VARCHAR(100),
 City VARCHAR(50),
 State VARCHAR(50),
 Country VARCHAR(50),
 PostalCode VARCHAR(50),
 Phone VARCHAR(50),
 Fax VARCHAR(50),
 Email VARCHAR(50),
 FOREIGN KEY (ReportsTo) REFERENCES Employee (EmployeeId));

-- Genre Table(1)--
CREATE TABLE Genre(
 GenreId INT PRIMARY KEY NOT NULL,
 Name VARCHAR(100)
);

-- Invoice table(7) --
CREATE TABLE Invoice(
 InvoiceId INT PRIMARY KEY NOT NULL,
 CustomerId INT NOT NULL,
 InvoiceDate TIMESTAMP NOT NULL,
 BillingAddress VARCHAR(50),
 BillingCity VARCHAR(50),
 BillingState VARCHAR(50),
 BillingCountry VARCHAR(50),
 BillingPostalCode VARCHAR(50),
 Total NUMERIC(10,2) NOT NULL,
 FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
);

-- InvoiceLine table(8) -- 
CREATE TABLE InvoiceLine(
 InvoiceLineId INT NOT NULL,
 InvoiceId INT NOT NULL,
 TrackId INT NOT NULL,
 UnitPrice NUMERIC(10,2) NOT NULL,
 Quantity INT NOT NULL,
 PRIMARY KEY (InvoiceLineId),
 FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId),
 FOREIGN KEY (TrackId) REFERENCES Track (TrackId)
);

-- Media Type(2)--
CREATE TABLE MediaType(
 MediaTypeId INT PRIMARY KEY NOT NULL,
 Name VARCHAR(100)
);

-- Playlst table(9) -- 
CREATE TABLE Playlist(
 PlaylistId INT PRIMARY KEY NOT NULL,
 Name VARCHAR(100)
);

-- playlist track table(11) -- 
CREATE TABLE PlaylistTrack(
 PlaylistId INT NOT NULL,
 TrackId INT NOT NULL,
 PRIMARY KEY (PlaylistId, TrackId),
 FOREIGN KEY (PlaylistId) REFERENCES Playlist (PlaylistId),
 FOREIGN KEY (TrackId) REFERENCES Track (TrackId)
);

-- Track table(10)--
CREATE TABLE Track(
 TrackId INT PRIMARY KEY NOT NULL,
 Name VARCHAR(100) NOT NULL,
 AlbumId INT,
 MediaTypeId INT NOT NULL,
 GenreId INT,
 Composer VARCHAR(100),
 Milliseconds INT NOT NULL,
 Bytes INT,
 UnitPrice NUMERIC(10,2) NOT NULL,
 FOREIGN KEY (AlbumId) REFERENCES Album (AlbumId),
 FOREIGN KEY (GenreId) REFERENCES Genre (GenreId),
 FOREIGN KEY (MediaTypeId) REFERENCES MediaType (MediaTypeId)
);

-- Insert Queries
INSERT INTO Genre (GenreId, Name) VALUES (1, 'Rock');
INSERT INTO Genre (GenreId, Name) VALUES (2, 'Jazz');
INSERT INTO Genre (GenreId, Name) VALUES (3, 'Metal');
INSERT INTO Genre (GenreId, Name) VALUES (4, 'Alternative & Punk');
INSERT INTO Genre (GenreId, Name) VALUES (5, 'Rock And Roll');
INSERT INTO Genre (GenreId, Name) VALUES (6, 'Blues');

INSERT INTO MediaType (MediaTypeId, Name) VALUES (1, 'MPEG audio file');
INSERT INTO MediaType (MediaTypeId, Name) VALUES (2, 'Protected AAC audio file');
INSERT INTO MediaType (MediaTypeId, Name) VALUES (3, 'Protected MPEG-4 video
file');
INSERT INTO MediaType (MediaTypeId, Name) VALUES (4, 'Purchased AAC audio file');
INSERT INTO MediaType (MediaTypeId, Name) VALUES (5, 'AAC audio file');

INSERT INTO Artist (ArtistId, Name) VALUES (1, 'AC-DC');
INSERT INTO Artist (ArtistId, Name) VALUES (2, 'Accept');
INSERT INTO Artist (ArtistId, Name) VALUES (3, 'Aerosmith');
INSERT INTO Artist (ArtistId, Name) VALUES (4, 'Alanis Morissette');
INSERT INTO Artist (ArtistId, Name) VALUES (5, 'Alice In Chains');
INSERT INTO Artist (ArtistId, Name) VALUES (6, 'Ant�nio Carlos Jobim');

INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (1, 'For Those About To Rock
We Salute You', 1);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (2, 'Balls to the Wall', 2);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (3, 'Restless and Wild', 2);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (4, 'Let There Be Rock', 1);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (5, 'Big Ones', 3);
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (6, 'Jagged Little Pill', 4);

--
INSERT INTO Track (TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer,
Milliseconds, Bytes, UnitPrice) VALUES (1, 'For Those About To Rock (We Salute
You)', 1, 1, 1, 'Angus Young, Malcolm Young, Brian Johnson', 343719, 11170334,
0.99);
INSERT INTO Track (TrackId, Name, AlbumId, MediaTypeId, GenreId, Milliseconds,
Bytes, UnitPrice) VALUES (2, 'Balls to the Wall', 2, 2, 1, 342562, 5510424, 0.99);
INSERT INTO Track (TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer,
Milliseconds, Bytes, UnitPrice) VALUES (3, 'Fast As a Shark', 3, 2, 1, 'F.
Baltes, S. Kaufman, U. Dirkscneider & W. Hoffman', 230619, 3990994, 0.99);
INSERT INTO Track (TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer,
Milliseconds, Bytes, UnitPrice) VALUES (4, 'Restless and Wild', 3, 2, 1, 'F.
Baltes, R.A. Smith-Diesel, S. Kaufman, U. Dirkscneider & W. Hoffman', 252051,
4331779, 0.99);
INSERT INTO Track (TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer,
Milliseconds, Bytes, UnitPrice) VALUES (5, 'Princess of the Dawn', 3, 2, 1,
'Deaffy & R.A. Smith-Diesel', 375418, 6290521, 0.99);


-- Employee 1
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, BirthDate, HireDate,
    Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    1, 'Adams', 'Andrew', 'General Manager',
    '1962-02-18', '2002-08-14',
    '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1',
    '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@corp.com'
);

-- Employee 2
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate,
    HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    2, 'Edwards', 'Nancy', 'Sales Manager', 1,
    '1958-12-08', '2002-05-01',
    '825 8 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 2T3',
    '+1 (403) 262-3443', '+1 (403) 262-3322', 'nancy@corp.com'
);

-- Employee 3
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate,
    HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    3, 'Peacock', 'Jane', 'Sales Support Agent', 2,
    '1973-08-29', '2002-04-01',
    '1111 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5',
    '+1 (403) 262-3443', '+1 (403) 262-6712', 'jane@corp.com'
);

-- Employee 4
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate,
    HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    4, 'Park', 'Margaret', 'Sales Support Agent', 2,
    '1947-09-19', '2003-05-03',
    '683 10 Street SW', 'Calgary', 'AB', 'Canada', 'T2P 5G3',
    '+1 (403) 263-4423', '+1 (403) 263-4289', 'margaret@corp.com'
);

-- Employee 5
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate,
    HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    5, 'Johnson', 'Steve', 'Sales Support Agent', 2,
    '1965-03-03', '2003-10-17',
    '7727B 41 Ave', 'Calgary', 'AB', 'Canada', 'T3B 1Y7',
    '1 (780) 836-9987', '1 (780) 836-9543', 'steve@corp.com'
);

-- Employee 6
INSERT INTO Employee (
    EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate,
    HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email
) VALUES (
    6, 'Mitchell', 'Michael', 'IT Manager', 1,
    '1973-07-01', '2003-10-17',
    '5827 Bowness Road NW', 'Calgary', 'AB', 'Canada', 'T3B 0C5',
    '+1 (403) 246-9887', '+1 (403) 246-9899', 'michael@corp.com'
);

-- Customer 1
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Company, Address, City,
    State, Country, PostalCode, Phone, Fax, Email, SupportRepId
) VALUES (
    1, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.',
    'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000',
    '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3
);

-- Customer 2
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Address, City, Country,
    PostalCode, Phone, Email, SupportRepId
) VALUES (
    2, 'Leonie', 'Köhler', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany',
    '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5
);

-- Customer 3
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Address, City, State,
    Country, PostalCode, Phone, Email, SupportRepId
) VALUES (
    3, 'François', 'Tremblay', '1498 rue Bélanger', 'Montréal', 'QC',
    'Canada', 'H2G 1A7', '+1 (514) 721-4711', 'ftremblay@gmail.com', 3
);

-- Customer 4
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Address, City, Country,
    PostalCode, Phone, Email, SupportRepId
) VALUES (
    4, 'Björn', 'Hansen', 'Ullevålsveien 14', 'Oslo', 'Norway',
    '0171', '+47 22 44 22 22', 'bjorn.hansen@yahoo.no', 4
);

-- Customer 5
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Company, Address, City,
    Country, PostalCode, Phone, Fax, Email, SupportRepId
) VALUES (
    5, 'František', 'Wichterlová', 'JetBrains s.r.o.', 'Klanova 9/506',
    'Prague', 'Czech Republic', '14700', '+420 2 4172 5555', '+420 2 4172 5555',
    'frantisekw@jetbrains.com', 4
);

-- Customer 6
INSERT INTO Customer (
    CustomerId, FirstName, LastName, Address, City, Country,
    PostalCode, Phone, Email, SupportRepId
) VALUES (
    6, 'Helena', 'Holá', 'Rilská 3174/6', 'Prague', 'Czech Republic',
    '14300', '+420 2 4177 0449', 'hholy@gmail.com', 5
);

-- Inserting into Invoice table
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total)
VALUES (1, 2, '2009-01-01', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', 1.98);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total)
VALUES (2, 4, '2009-01-02', 'Ullevålsveien 14', 'Oslo', 'Norway', '0171', 3.96);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total)
VALUES (3, 8, '2009-01-03', 'Grøtrystraat 63', 'Brussels', 'Belgium', '1000', 5.94);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingState, BillingCountry, BillingPostalCode, Total)
VALUES (4, 14, '2009-01-06', '8210 111 ST NW', 'Edmonton', 'AB', 'Canada', 'T6G 2C7', 8.91);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingState, BillingCountry, BillingPostalCode, Total)
VALUES (5, 23, '2009-01-11', '69 Salem Street', 'Boston', 'MA', 'USA', '2113', 13.86);

INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total)
VALUES (6, 37, '2009-01-19', 'Berger Straße 10', 'Frankfurt', 'Germany', '60316', 0.99);

INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (1, 1, 2, 0.99, 1);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (2, 1, 4, 0.99, 1);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (3, 2, 6, 0.99, 1);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (4, 2, 8, 0.99, 1);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (5, 2, 10, 0.99, 1);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity)
VALUES (6, 2, 12, 0.99, 1);

INSERT INTO Playlist (PlaylistId, Name) VALUES (1, 'Music');
INSERT INTO Playlist (PlaylistId, Name) VALUES (2, 'Movies');
INSERT INTO Playlist (PlaylistId, Name) VALUES (3, 'TV Shows');
INSERT INTO Playlist (PlaylistId, Name) VALUES (4, 'Audiobooks');
INSERT INTO Playlist (PlaylistId, Name) VALUES (5, 'Movies');
INSERT INTO Playlist (PlaylistId, Name) VALUES (6, 'Music');
INSERT INTO Playlist (PlaylistId, Name) VALUES (7, 'Music Videos');

INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3402);
INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3389);
INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3390);
INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3391);
INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3392);
INSERT INTO PlaylistTrack (PlaylistId, TrackId) VALUES (1, 3393);


-- Q1
SELECT Genre.Name, COUNT(PlaylistTrack.PlaylistID) AS PlaylistCount
FROM Genre
JOIN Track ON Genre.GenreID = Track.GenreID
JOIN PlaylistTrack ON Track.TrackID = PlaylistTrack.TrackID
GROUP BY Genre.Name
ORDER BY PlaylistCount DESC;

-- Q2
SELECT *
FROM Track
WHERE Milliseconds > (SELECT AVG(Milliseconds) FROM Track WHERE MediaTypeID = 2);


-- Q3
SELECT Playlist.Name, COUNT(PlaylistTrack.TrackID) AS PopTrackCount
FROM Playlist
JOIN PlaylistTrack ON Playlist.PlaylistID = PlaylistTrack.PlaylistID
JOIN Track ON PlaylistTrack.TrackID = Track.TrackID
WHERE Track.GenreID = 9
GROUP BY Playlist.Name
ORDER BY PopTrackCount DESC;


-- Q4
SELECT Customer.CustomerID, Customer.City AS CustomerCity, COUNT(Employee.EmployeeID) AS EmployeesInSameCity
FROM Customer
JOIN Employee ON Customer.City = Employee.City
GROUP BY Customer.CustomerID, Customer.City
ORDER BY EmployeesInSameCity DESC;


-- Q5
SELECT Artist.Name, COUNT(Track.TrackID) AS JazzTrackCount
FROM Artist
JOIN Album ON Artist.ArtistID = Album.ArtistID
JOIN Track ON Album.AlbumID = Track.AlbumID
WHERE Track.GenreID = 11
GROUP BY Artist.Name
ORDER BY JazzTrackCount DESC;


-- Q6
SELECT Customer.FirstName, Customer.LastName, SUM(Invoice.Total) AS TotalAmountPaid
FROM Customer
JOIN Invoice ON Customer.CustomerID = Invoice.CustomerID
WHERE Customer.Country = 'Germany'
GROUP BY Customer.FirstName, Customer.LastName
ORDER BY TotalAmountPaid DESC;


-- Q7
SELECT FirstName, LastName, DATEDIFF(YEAR, BirthDate, CURDATE()) AS Age
FROM Employee
WHERE EmployeeID IN (
    SELECT SupportRepID
    FROM Customer
    GROUP BY SupportRepID
    HAVING COUNT(CustomerID) > 5);



-- Q8
SELECT FirstName, LastName, COUNT(Employee.EmployeeID) AS ManagedEmployeesCount
FROM Employee
WHERE ReportsTo IS NOT NULL
GROUP BY FirstName, LastName, ReportsTo
ORDER BY ManagedEmployeesCount DESC;


-- Q9
SELECT Artist.Name, COUNT(Track.TrackID) AS TrackCount
FROM Artist
JOIN Album ON Artist.ArtistID = Album.ArtistID
JOIN Track ON Album.AlbumID = Track.AlbumID
GROUP BY Artist.Name
HAVING TrackCount > 5;


-- Q10
SELECT Playlist.Name, COUNT(PlaylistTrack.TrackID) AS TrackCount
FROM Playlist
JOIN PlaylistTrack ON Playlist.PlaylistID = PlaylistTrack.PlaylistID
JOIN Track ON PlaylistTrack.TrackID = Track.TrackID
JOIN Album ON Track.AlbumID = Album.AlbumID
JOIN Artist ON Album.ArtistID = Artist.ArtistID
WHERE Artist.Name = 'AC/DC'
GROUP BY Playlist.Name
ORDER BY TrackCount DESC;




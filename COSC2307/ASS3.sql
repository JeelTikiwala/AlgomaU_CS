-- Name: Jeel Tikiwala
-- Student ID: 239659420
-- Assignment 3
create database ASS3;

use ASS3;
 -- Part table (5)-- 
  CREATE TABLE PART  ( P_PARTKEY     INTEGER PRIMARY KEY NOT NULL,
                       P_NAME        VARCHAR(100) NOT NULL,
                       P_MFGR        CHAR(25) ,
                       P_BRAND       CHAR(25) ,
                       P_TYPE        VARCHAR(25) ,
                       P_SIZE        INTEGER ,
                       P_CONTAINER   CHAR(25) ,
                       P_RETAILPRICE DECIMAL(15,2),
                       P_COMMENT     VARCHAR(25));
    
-- Partsupp table (6) -- 
  CREATE TABLE PARTSUPP ( PS_PARTKEY     INTEGER NOT NULL,
                          PS_SUPPKEY     INTEGER  NOT NULL,
                          PS_AVAILQTY    INTEGER,
                          PS_SUPPLYCOST  DECIMAL(15,2),
                          PS_COMMENT     VARCHAR(250),
                          PRIMARY KEY (PS_PARTKEY, PS_SUPPKEY),
                          FOREIGN KEY (PS_PARTKEY) REFERENCES PART(P_PARTKEY),
						  FOREIGN KEY (PS_SUPPKEY) REFERENCES SUPPLIER(S_SUPPKEY));
-- Nation Table (2)--                        
  CREATE TABLE NATION  ( N_NATIONKEY  INTEGER PRIMARY KEY NOT NULL,
                         N_NAME       CHAR(25),
                         N_REGIONKEY  INTEGER,
                         N_COMMENT    VARCHAR(250),
                         FOREIGN KEY (N_REGIONKEY) REFERENCES REGION(R_REGIONKEY));
  
  -- Region Table(1) -- 
  CREATE TABLE REGION  ( R_REGIONKEY  INTEGER PRIMARY KEY NOT NULL,
                         R_NAME       CHAR(25),
                         R_COMMENT    VARCHAR(250));
                         
-- Supplier Table (3)-- 
  CREATE TABLE SUPPLIER ( S_SUPPKEY     INTEGER PRIMARY KEY NOT NULL,
                          S_NAME        CHAR(25),
                          S_ADDRESS     VARCHAR(50),
                          S_NATIONKEY   INTEGER ,
                          S_PHONE       CHAR(25) ,
                          S_ACCTBAL     DECIMAL(15,2),
                          S_COMMENT     VARCHAR(250),
                          FOREIGN KEY (S_NATIONKEY) REFERENCES NATION(N_NATIONKEY));

-- Customer Table (4)-- 
  CREATE TABLE CUSTOMER ( C_CUSTKEY     INTEGER PRIMARY KEY NOT NULL,
                          C_NAME        VARCHAR(25),
                          C_ADDRESS     VARCHAR(50) ,
                          C_NATIONKEY   INTEGER ,
                          C_PHONE       CHAR(25) ,
                          C_ACCTBAL     DECIMAL(15,2),
                          C_MKTSEGMENT  CHAR(25),
                          C_COMMENT     VARCHAR(250),
                          FOREIGN KEY (C_NATIONKEY) REFERENCES NATION(N_NATIONKEY));

-- Orders table (7) --
  CREATE TABLE ORDERS  ( O_ORDERKEY       INTEGER PRIMARY KEY NOT NULL,
                         O_CUSTKEY        INTEGER NOT NULL,
                         O_ORDERSTATUS    CHAR(1) ,
                         O_TOTALPRICE     DECIMAL(15,2),
                         O_ORDERDATE      DATE NOT NULL,
                         O_ORDERPRIORITY  CHAR(25) ,
                         O_CLERK          CHAR(25) ,
                         O_SHIPPRIORITY   INTEGER,
                         O_COMMENT        VARCHAR(250),
                         FOREIGN KEY (O_CUSTKEY) REFERENCES CUSTOMER(C_CUSTKEY));

-- Lineitem table (8)-- 
  CREATE TABLE LINEITEM ( L_ORDERKEY        INTEGER NOT NULL,
                          L_PARTKEY         INTEGER NOT NULL,
                          L_SUPPKEY         INTEGER NOT NULL,
                          L_LINENUMBER      INTEGER NOT NULL,
                          L_QUANTITY        DECIMAL(15,2) ,
                          L_EXTENDEDPRICE   DECIMAL(15,2) ,
                          L_DISCOUNT        DECIMAL(15,2) ,
                          L_TAX             DECIMAL(15,2) ,
                          L_RETURNFLAG      CHAR(1),
                          L_LINESTATUS      CHAR(1),
                          L_SHIPDATE        DATE ,
                          L_COMMITDATE      DATE,
                          L_RECEIPTDATE     DATE ,
                          L_SHIPINSTRUCT    CHAR(25),
                          L_SHIPMODE        CHAR(25),
                          L_COMMENT         VARCHAR(250),
                          PRIMARY KEY (L_ORDERKEY, L_LINENUMBER),
						  FOREIGN KEY (L_ORDERKEY) REFERENCES ORDERS(O_ORDERKEY),
                          FOREIGN KEY (L_PARTKEY, L_SUPPKEY) REFERENCES PARTSUPP(PS_PARTKEY, PS_SUPPKEY));

-- INsert queries
-- Insert into REGION table
INSERT INTO REGION (R_REGIONKEY, R_NAME, R_COMMENT)
VALUES
(1, 'Americas', 'Region in Americas'),
(2, 'Europe', 'Region in Europe'),
(3, 'Asia', 'Region in Asia');

-- Insert into NATION table
INSERT INTO NATION (N_NATIONKEY, N_NAME, N_REGIONKEY, N_COMMENT)
VALUES
(1, 'USA', 1, 'Nation in Americas'),
(2, 'Germany', 2, 'Nation in Europe'),
(3, 'Japan', 3, 'Nation in Asia');

-- Insert into SUPPLIER table
INSERT INTO SUPPLIER (S_SUPPKEY, S_NAME, S_ADDRESS, S_NATIONKEY, S_PHONE, S_ACCTBAL, S_COMMENT)
VALUES
(1, 'SupplierX', '123 Main St, CityX', 1, '555-1234', 5000.00, 'Supplier in USA'),
(2, 'SupplierY', '456 Oak St, CityY', 2, '555-5678', 8000.00, 'Supplier in Germany'),
(3, 'SupplierZ', '789 Pine St, CityZ', 3, '555-9012', 7000.00, 'Supplier in Japan');

-- Insert into CUSTOMER table
INSERT INTO CUSTOMER (C_CUSTKEY, C_NAME, C_ADDRESS, C_NATIONKEY, C_PHONE, C_ACCTBAL, C_MKTSEGMENT, C_COMMENT)
VALUES
(1, 'CustomerA', '789 Elm St, CityA', 1, '111-1111', 3000.00, 'SegmentX', 'Customer in USA'),
(2, 'CustomerB', '234 Birch St, CityB', 2, '222-2222', 6000.00, 'SegmentY', 'Customer in Germany'),
(3, 'CustomerC', '567 Maple St, CityC', 3, '333-3333', 4500.00, 'SegmentZ', 'Customer in Japan');



-- Insert into PART table
INSERT INTO PART (P_PARTKEY, P_NAME, P_MFGR, P_BRAND, P_TYPE, P_SIZE, P_CONTAINER, P_RETAILPRICE, P_COMMENT)
VALUES
(1, 'Widget A', 'Manufacturer1', 'BrandX', 'Type1', 10, 'Box', 100.00, 'Standard widget'),
(2, 'Gadget B', 'Manufacturer2', 'BrandY', 'Type2', 20, 'Crate', 200.00, 'Advanced gadget'),
(3, 'Device C', 'Manufacturer3', 'BrandZ', 'Type3', 15, 'Bag', 150.00, 'Compact device'),
(4, 'Tool D', 'Manufacturer4', 'BrandX', 'Type4', 30, 'Pallet', 300.00, 'Heavy-duty tool'),
(5, 'Appliance E', 'Manufacturer5', 'BrandY', 'Type5', 25, 'Box', 250.00, 'Modern appliance');

-- Insert into PARTSUPP table
INSERT INTO PARTSUPP (PS_PARTKEY, PS_SUPPKEY, PS_AVAILQTY, PS_SUPPLYCOST, PS_COMMENT)
VALUES
(1, 1, 50, 50.00, 'SupplierX - Widget A'),
(1, 2, 75, 40.00, 'SupplierY - Widget A'),
(2, 3, 60, 60.00, 'SupplierZ - Gadget B');

-- Insert into ORDERS table
INSERT INTO ORDERS (O_ORDERKEY, O_CUSTKEY, O_ORDERSTATUS, O_TOTALPRICE, O_ORDERDATE, O_ORDERPRIORITY, O_CLERK, O_SHIPPRIORITY, O_COMMENT)
VALUES
(1, 1, 'A', 500.00, '2023-01-01', 'High', 'ClerkX', 1, 'Order comment 1'),
(2, 2, 'B', 700.00, '2023-02-01', 'Medium', 'ClerkY', 2, 'Order comment 2'),
(3, 3, 'C', 900.00, '2023-03-01', 'Low', 'ClerkZ', 3, 'Order comment 3');

-- Insert into LINEITEM table
INSERT INTO LINEITEM (L_ORDERKEY, L_PARTKEY, L_SUPPKEY, L_LINENUMBER, L_QUANTITY, L_EXTENDEDPRICE, L_DISCOUNT, L_TAX, L_RETURNFLAG, L_LINESTATUS, L_SHIPDATE, L_COMMITDATE, L_RECEIPTDATE, L_SHIPINSTRUCT, L_SHIPMODE, L_COMMENT)
VALUES
(1, 1, 1, 1, 10.00, 100.00, 0.05, 5.00, 'R', 'S', '2023-01-10', '2023-01-05', '2023-01-15', 'Handle with care', 'Air', 'Lineitem comment 1'),
(1, 2, 2, 2, 20.00, 200.00, 0.10, 10.00, 'N', 'O', '2023-01-12', '2023-01-07', '2023-01-17', 'Fragile', 'Ship', 'Lineitem comment 2'),
(2, 1, 1, 1, 15.00, 150.00, 0.08, 8.00, 'R', 'S', '2023-02-10', '2023-02-05', '2023-02-15', 'Handle with care', 'Air', 'Lineitem comment 3');

-- Q1
SELECT COUNT(Customer.C_CUSTKEY) AS EuropeanCustomersWithBalanceLessThan8000
FROM CUSTOMER
JOIN NATION ON CUSTOMER.C_NATIONKEY = NATION.N_NATIONKEY
JOIN REGION ON NATION.N_REGIONKEY = REGION.R_REGIONKEY
WHERE REGION.R_NAME = 'Europe' AND CUSTOMER.C_ACCTBAL < 8000;

-- Q2
SELECT REGION.R_NAME AS MostSuppliedRegion
FROM REGION
JOIN NATION ON REGION.R_REGIONKEY = NATION.N_REGIONKEY
JOIN SUPPLIER ON NATION.N_NATIONKEY = SUPPLIER.S_NATIONKEY
JOIN PARTSUPP ON SUPPLIER.S_SUPPKEY = PARTSUPP.PS_SUPPKEY
JOIN PART ON PARTSUPP.PS_PARTKEY = PART.P_PARTKEY
GROUP BY REGION.R_NAME
ORDER BY COUNT(DISTINCT PART.P_PARTKEY) DESC;

-- Q3
SELECT AVG(DATEDIFF(L_SHIPDATE, O_ORDERDATE)) AS AvgShippingTime
FROM ORDERS
JOIN LINEITEM ON ORDERS.O_ORDERKEY = LINEITEM.L_ORDERKEY
WHERE L_SHIPDATE IS NOT NULL AND LINEITEM.L_SHIPMODE = 'TRUCK';

-- Q4
SELECT L_QUANTITY, L_ORDERKEY
FROM LINEITEM
JOIN ORDERS ON LINEITEM.L_ORDERKEY = ORDERS.O_ORDERKEY
WHERE ORDERS.O_ORDERSTATUS = 'Shipped' AND LINEITEM.L_DISCOUNT = 0 AND ORDERS.O_CUSTKEY NOT IN (
    SELECT O_CUSTKEY
    FROM CUSTOMER
    JOIN NATION ON CUSTOMER.C_NATIONKEY = NATION.N_NATIONKEY
    JOIN REGION ON NATION.N_REGIONKEY = REGION.R_REGIONKEY
    WHERE REGION.R_NAME = 'Europe'
);


-- Q5
SELECT P_NAME
FROM PART
WHERE P_PARTKEY NOT IN (
    SELECT L_PARTKEY
    FROM LINEITEM
    JOIN ORDERS ON LINEITEM.L_ORDERKEY = ORDERS.O_ORDERKEY
    JOIN CUSTOMER ON ORDERS.O_CUSTKEY = CUSTOMER.C_CUSTKEY
    JOIN NATION ON CUSTOMER.C_NATIONKEY = NATION.N_NATIONKEY
    JOIN REGION ON NATION.N_REGIONKEY = REGION.R_REGIONKEY
    WHERE REGION.R_NAME = 'Europe'
);

-- Q6
SELECT DISTINCT P_NAME
FROM PART
JOIN LINEITEM ON PART.P_PARTKEY = LINEITEM.L_PARTKEY
JOIN ORDERS ON LINEITEM.L_ORDERKEY = ORDERS.O_ORDERKEY
JOIN CUSTOMER ON ORDERS.O_CUSTKEY = CUSTOMER.C_CUSTKEY
JOIN NATION ON CUSTOMER.C_NATIONKEY = NATION.N_NATIONKEY
JOIN SUPPLIER ON NATION.N_NATIONKEY = SUPPLIER.S_NATIONKEY
WHERE SUPPLIER.S_ACCTBAL = (
    SELECT MAX(S_ACCTBAL)
    FROM SUPPLIER
);

-- Q7
SELECT AVG(L_EXTENDEDPRICE) AS AverageOrderPrice
FROM LINEITEM
WHERE L_PARTKEY NOT IN (
    SELECT P_PARTKEY
    FROM PART
    WHERE P_SIZE > 40
);

-- Q8
SELECT S_NAME, COUNT(S_SUPPKEY) AS NumberOfPartsSupplied
FROM SUPPLIER
JOIN PARTSUPP ON SUPPLIER.S_SUPPKEY = PARTSUPP.PS_SUPPKEY
GROUP BY S_NAME
HAVING COUNT(PARTSUPP.PS_PARTKEY) > 5;

-- Q9
SELECT DISTINCT P_NAME
FROM PART
ORDER BY P_RETAILPRICE DESC
LIMIT 1;

-- Q10
SELECT DISTINCT P_NAME
FROM PART
WHERE P_RETAILPRICE = (
    SELECT MAX(P_RETAILPRICE)
    FROM PART
);


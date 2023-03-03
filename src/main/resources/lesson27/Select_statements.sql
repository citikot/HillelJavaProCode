SELECT * FROM customers;
SELECT contactFirstName as name, phone FROM customers;

SELECT * FROM customers c
WHERE c.contactFirstName = 'Julie';
SELECT * FROM customers c
WHERE c.contactFirstName = 'Julie' AND c.state='CA';
SELECT * FROM customers c
WHERE c.contactFirstName = 'Julie' OR c.contactFirstName='Jean';
SELECT * FROM customers c
WHERE c.country='USA' AND (c.contactFirstName = 'Julie' OR c.contactFirstName='Jean');
SELECT * FROM customers c
WHERE c.country IN ('USA', 'Canada', 'Japan');
SELECT * FROM customers c
WHERE c.country NOT IN ('USA', 'Canada', 'Japan');
SELECT * FROM customers c
WHERE c.contactFirstName LIKE 'Car%';
SELECT * FROM customers c
WHERE c.state IS NULL;
SELECT * FROM customers c
WHERE c.state IS NOT NULL;
SELECT * FROM customers c
WHERE length(c.contactFirstName)>10;
SELECT c.contactFirstName, c.contactLastName, concat(c.creditLimit/1000, 'k USD') as limitation FROM customers c
WHERE length(c.contactFirstName)>10;

SELECT c.contactFirstName, c.contactLastName, c.phone FROM customers c
ORDER BY c.contactFirstName;
SELECT c.contactFirstName, c.contactLastName, c.phone FROM customers c
ORDER BY c.contactFirstName ASC, c.contactLastName DESC;

SELECT DISTINCT contactFirstName as name FROM customers
ORDER by name;

SELECT c.contactFirstName FROM customers c
WHERE length(c.contactFirstName)>10
UNION -- ALL
SELECT c.contactFirstName FROM customers c
WHERE length(c.contactFirstName)>10;

SELECT c.contactFirstName FROM customers c
WHERE length(c.contactFirstName)>10
UNION
SELECT c.contactFirstName FROM customers c
WHERE length(c.contactFirstName)<5;

-- MINUS INTERSECT not supported by MySQL
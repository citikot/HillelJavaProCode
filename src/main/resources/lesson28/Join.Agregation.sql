-- join
SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
WHERE o.orderNumber IS NULL
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
WHERE orderNumber IS NOT NULL
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate FROM orders o
RIGHT JOIN customers c on o.customerNumber=c.customerNumber
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate FROM customers c
INNER JOIN orders o on o.customerNumber=c.customerNumber
ORDER BY c.contactFirstName;

-- What products buy every consumer
SELECT c.contactFirstName, c.contactLastName, o.orderNumber, o.status, o.shippedDate, p.productName, od.quantityOrdered FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
LEFT JOIN orderdetails od on od.orderNumber=o.orderNumber
LEFT JOIN products p on p.productCode=od.productCode
ORDER BY c.contactFirstName, o.orderNumber, p.productName;

-- self join
SELECT m.lastName as managerLastName, m.firstName as managerFirstName, 
e.lastName as employeeLastName, e.firstName as employeeFirstName FROM employees e
LEFT JOIN employees m ON m.employeeNumber = e.reportsTo
ORDER BY m.lastName, m.firstName;

-- aggregation
SELECT MAX(c.creditLimit), MIN(c.creditLimit), AVG(creditLimit) FROM customers c;

SELECT c.country, MAX(c.creditLimit), MIN(c.creditLimit), AVG(creditLimit) FROM customers c
GROUP BY c.country;

SELECT c.country, MAX(c.creditLimit), MIN(c.creditLimit), AVG(creditLimit) FROM customers c
WHERE c.state!='CA' OR c.state is NULL
GROUP BY c.country
ORDER BY c.country;

SELECT COUNT(*) FROM customers c;
SELECT COUNT(c.state) FROM customers c;

SELECT c.contactFirstName, c.contactLastName, COUNT(o.orderNumber) ordersCount FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
GROUP BY c.contactFirstName, c.contactLastName
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, COUNT(o.orderNumber) ordersCount FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
GROUP BY c.contactFirstName, c.contactLastName
HAVING ordersCount>2
ORDER BY c.contactFirstName;

SELECT c.contactFirstName, c.contactLastName, COUNT(o.orderNumber) ordersCount FROM customers c
LEFT JOIN orders o on o.customerNumber=c.customerNumber
WHERE c.country='USA'
GROUP BY c.contactFirstName, c.contactLastName
HAVING ordersCount>2
ORDER BY c.contactFirstName;

-- subquery
SELECT c.contactFirstName, c.contactLastName FROM customers c
WHERE c.customerNumber IN 
(SELECT p.customerNumber from payments p 
WHERE p.amount>10000)
ORDER BY c.contactFirstName;

SELECT t.country, count(*) FROM
(SELECT c.contactFirstName, c.contactLastName, c.country FROM customers c
WHERE length(c.contactFirstName)>10
UNION
SELECT c.contactFirstName, c.contactLastName, c.country FROM customers c
WHERE length(c.contactFirstName)<5) t
GROUP BY t.country;

SELECT c.customerNumber, c.customerName FROM customers c
WHERE EXISTS(SELECT 1 FROM orders o WHERE o.customernumber = c.customernumber);

SELECT 1 FROM DUAL;



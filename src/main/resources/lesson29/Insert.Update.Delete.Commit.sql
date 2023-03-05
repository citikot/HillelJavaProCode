-- Should disable autocommit in MySQL Workbanch

INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) 
VALUES (500, 'Pasko Inc', 'Pasko', 'Serhii', '123456', 'Address', 'Kyiv', 'Ukraine');

INSERT INTO customers
VALUES (600, 'Stepko', 'Kozak', 'Stepan', '234', 'address', null, 'Kyiv', null, null, 'Ukraine', null, 10000);

INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) 
VALUES (700, 'Pasko Inc', 'Pasko', 'Serhii', '123456', 'Address', 'Kyiv', 'Ukraine'),
(800, 'Pasko Inc2', 'Pasko', 'Serhii', '123456', 'Address', 'Kyiv', 'Ukraine');

UPDATE customers
SET customerName = 'Serhiys anywhere';

UPDATE customers
SET customerName = CONCAT(customerName, ' from USA')
WHERE country = 'USA';

-- Error by FK
DELETE FROM customers
WHERE country = 'USA';
CREATE DATABASE session_12;
USE session_12;

CREATE TABLE customer
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email   VARCHAR(100) NOT NULL
);

DELIMITER //
CREATE PROCEDURE PROC_SHOW_CUSTOMER()
BEGIN
    SELECT * FROM customer;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_CREATE_CUSTOMER(
    IN new_name VARCHAR(100),
    IN new_address VARCHAR(100),
    IN new_email VARCHAR(100))
BEGIN
    INSERT INTO customer(name, address, email) VALUES (new_name, new_address, new_email);
END;
//

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_CUSTOMER(
    IN id_update INT,
    IN new_name VARCHAR(100),
    IN new_address VARCHAR(100),
    IN new_email VARCHAR(100))
BEGIN
    UPDATE customer SET name=new_name, address=new_address, email=new_email WHERE id = id_update;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_FIND_CUSTOMER(IN in_find INT)
BEGIN
    SELECT *FROM customer WHERE id = in_find;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_FIND_BY_NAME_CUSTOMER(IN new_name VARCHAR(100))
BEGIN
    SELECT * FROM customer WHERE name LIKE CONCAT('%', new_name, '%');
END;
//
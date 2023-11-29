CREATE DATABASE quan_ly_san_pham;
USE quan_ly_san_pham;

CREATE TABLE category
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(60) NOT NULL,
    status           BIT(1)               DEFAULT 1,
    quantity_product INT         NOT NULL DEFAULT 0
);

CREATE TABLE product
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(60) NOT NULL,
    price       FLOAT       NOT NULL,
    category_id INT         NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

DELIMITER //
CREATE PROCEDURE PROC_SHOW_CATEGORY()
BEGIN
    SELECT * FROM category;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_SHOW_PRODUCT()
BEGIN
    SELECT * FROM product;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_CREATE_CATEGORY(IN newName VARCHAR(60))
BEGIN
    INSERT INTO category (name) VALUES (newName);
END;
//

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_CATEGORY(
    IN newId INT,
    IN newName VARCHAR(60),
    IN newStatus BIT(1),
    IN new_quantity_product INT
)
BEGIN
    UPDATE category SET name=newName, status=newStatus, quantity_product=new_quantity_product WHERE id = newId;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_FIND_CATEGORY(IN newId INT)
BEGIN
    SELECT * FROM category WHERE id = newId;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_CREATE_PRODUCT(
    IN newName VARCHAR(60),
    IN newPrice FLOAT,
    IN new_category_id INT
)
BEGIN
    INSERT INTO product (name, price, category_id) VALUES (newName, newPrice, new_category_id);
END;
//

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_QUALITY_CATEGORY(IN newId INT)
BEGIN
    UPDATE category SET quantity_product= quantity_product + 1 WHERE id = newId;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_FIND_PRODUCT(IN newId INT)
BEGIN
    SELECT * FROM product WHERE id = newId;
END;
//
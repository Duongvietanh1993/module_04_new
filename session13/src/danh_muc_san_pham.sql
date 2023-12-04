CREATE DATABASE danh_muc_san_pham;
USE danh_muc_san_pham;

CREATE TABLE category
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(100) NOT NULL UNIQUE,
    status BIT(1) DEFAULT 1
);

CREATE TABLE product
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    price       DOUBLE       NOT NULL,
    category_id INT          NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

DELIMITER //
CREATE PROCEDURE PROC_SHOW_PRODUCT()
BEGIN
    SELECT * FROM product;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_SHOW_CATEGORY()
BEGIN
    SELECT * FROM category;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_CREATE_PRODUCT(
    IN new_name VARCHAR(100),
    IN new_price DOUBLE,
    IN new_category_id INT)
BEGIN
    INSERT INTO product (name, price, category_id) VALUES (new_name, new_price, new_category_id);
END;
//

DELIMITER //
CREATE PROCEDURE PROC_CREATE_CATEGORY(
    IN new_name VARCHAR(100))
BEGIN
    INSERT INTO category (name) VALUES (new_name);
END;
//

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_PRODUCT(
    IN id_update INT,
    IN new_name VARCHAR(100),
    IN new_price DOUBLE,
    IN new_category_id INT
)
BEGIN
    UPDATE product
    SET name        = new_name,
        price       = new_price,
        category_id = new_category_id
    WHERE id = id_update;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_CATEGORY(
    IN id_update INT,
    IN new_name VARCHAR(100),
    IN new_status BIT(1)
)
BEGIN
    UPDATE category
    SET name        = new_name,
        status       = new_status
    WHERE id = id_update;
END;
//

DELIMITER //
CREATE PROCEDURE PROC_FIND_CATEGORY_BY_ID(IN _id INT)
BEGIN
    SELECT *FROM category WHERE id = _id;
end //

DELIMITER //
CREATE PROCEDURE PROC_UPDATE_STATUS_CATEGORY(IN _id INT,IN _status BIT(1))
BEGIN
    UPDATE category SET status=_status WHERE id = _id;
end; //
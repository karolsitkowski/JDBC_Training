DROP DATABASE IF EXISTS library;
DROP USER IF EXISTS 'library_admin';
CREATE DATABASE IF NOT EXISTS library CHARACTER SET utf8 COLLATE utf8_general_ci;
USE library;

CREATE USER 'library_admin' IDENTIFIED BY '1234';

GRANT ALL ON library.* TO 'library_admin';

CREATE TABLE addresses (
    id	INT         			NOT NULL AUTO_INCREMENT,
    address   VARCHAR(256)    	NOT NULL,
    city VARCHAR(256) 			NOT NULL,
    postal_code CHAR (6),
    PRIMARY KEY (id)
);

CREATE TABLE authors (
    id INT             			NOT NULL AUTO_INCREMENT,
    address_id INT				NOT NULL,
    first_name	VARCHAR(256)    NOT NULL,
    last_name   VARCHAR(256)    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) 	REFERENCES addresses (id) ON DELETE CASCADE
);

CREATE TABLE books (
    isbn	VARCHAR(11)   		NOT NULL,
    author_id INT				NOT NULL,
    title  VARCHAR(256)     	NOT NULL,
    publish_date  DATE,
    PRIMARY KEY (isbn),
    FOREIGN KEY (author_id) 	REFERENCES authors (id)
);

CREATE TABLE libraries (
   id	INT             		NOT NULL AUTO_INCREMENT,
   address_id INT				NOT NULL,
   lib_name	VARCHAR(256)   		NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (address_id) 	REFERENCES addresses (id) ON DELETE CASCADE
);

CREATE TABLE books_at_libraries (
    isbn VARCHAR(11)     		NOT NULL,
    library_id	INT				NOT NULL,
    PRIMARY KEY (isbn,library_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (library_id) 	REFERENCES libraries (id)
);

CREATE TABLE users (
    id	INT             		NOT NULL AUTO_INCREMENT,
    address_id INT				NOT NULL,
    first_name	VARCHAR(256)    NOT NULL,
    last_name   VARCHAR(256)    NOT NULL,
    gender	ENUM ('Male','Female')	NOT NULL,
    e_mail VARCHAR(256),
    phone_no VARCHAR(256),
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) 	REFERENCES addresses (id) ON DELETE CASCADE
);

CREATE TABLE books_at_users (
    isbn VARCHAR(11)     		NOT NULL,
    user_id	INT					NOT NULL,
    PRIMARY KEY (isbn,user_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (user_id) 		REFERENCES users (id)
);

CREATE TABLE categories (
    id      INT             	NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(256)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_at_categories (
    isbn VARCHAR(11)     		NOT NULL,
    category_id	INT				NOT NULL,
    PRIMARY KEY (isbn,category_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (category_id) 	REFERENCES categories (id)
);

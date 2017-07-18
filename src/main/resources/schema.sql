DROP DATABASE IF EXISTS library;
DROP USER IF EXISTS 'library_admin';
CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE USER 'library_admin' IDENTIFIED BY '1234';

GRANT ALL ON library.* TO 'library_admin';

DROP TABLE IF EXISTS books,
                     addresses,
                     libraries,
                     books_at_libraries, 
                     members, 
                     books_at_members,
                     categories,
                     books_at_categories,
                     authors;

CREATE TABLE addresses (
    id	INT         			NOT NULL AUTO_INCREMENT,
    street   VARCHAR(256)    	NOT NULL,
    home_no	CHAR(10)			NOT NULL,
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
    isbn      INT             	NOT NULL AUTO_INCREMENT,
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
    isbn INT     				NOT NULL,
    library_id	INT				NOT NULL,
    PRIMARY KEY (isbn,library_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (library_id) 	REFERENCES libraries (id)
);

CREATE TABLE members (
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

CREATE TABLE books_at_members (
    isbn INT     				NOT NULL,
    member_id	INT				NOT NULL,
    PRIMARY KEY (isbn,member_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (member_id) 	REFERENCES members (id)
);

CREATE TABLE categories (
    id      INT             	NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(256)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_at_categories (
    isbn INT     				NOT NULL,
    category_id	INT				NOT NULL,
    PRIMARY KEY (isbn,category_id),
    FOREIGN KEY (isbn) 			REFERENCES books (isbn),
    FOREIGN KEY (category_id) 	REFERENCES categories (id)
);

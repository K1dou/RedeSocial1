CREATE TABLE users(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
email VARCHAR(100)UNIQUE NOT NULL,
password VARCHAR (50) NOT NULL,
sexo VARCHAR(30) NOT NULL
);
CREATE TABLE users(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
email VARCHAR(100)UNIQUE NOT NULL,
password VARCHAR (255) NOT NULL,
sexo VARCHAR(30) NOT NULL,
role VARCHAR (20) NOT NULL
);
DROP DATABASE IF EXISTS jee3060;

CREATE DATABASE jee3060;

USE jee3060;

CREATE TABLE hobby
(

    hobbyid       INT AUTO_INCREMENT PRIMARY KEY,

    hobbyname     VARCHAR(50),

    hobbyoptional VARCHAR(50) NULL,

    hobbydesc     VARCHAR(500)

);
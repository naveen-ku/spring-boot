CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

-- Drop authorities first & then users because of foreign key reference
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
`username` varchar(50) NOT NULL,
`password` char(68) NOT NULL,
`enabled` tinyint NOT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Case 1 when stored unencrypted password in db
INSERT INTO `users`
VALUES
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1),
('admin','{noop}admin',1);


-- Case 2 when storing bcrypt hashed password in db

INSERT INTO `users`
VALUES
('john','{bcrypt}$2a$12$1o.oPWDRmZyHEtbb0fTEQO4UdIHPlan85/38McZWR32IKS6dBhKmy',1),
('mary','{bcrypt}$2a$12$PHsh4Ec7Nn9y0lAQxde35ufMkZ3Eu5o2vsLKY6hmQB33ThkRK0v5G',1),
('susan','{bcrypt}$2a$12$vAnkc527FKMYyztiWodeCOZvKljwmjrYOyXCIEddp/ZUBrwqqnbom',1),
('admin','{bcrypt}$2a$12$W6.CIc8w2AnUCxbjVP5aSe1YrC.PqKWWlSmM3ItBHgVI6AqsRCql2',1);


CREATE TABLE `authorities` (
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`username`)
REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN'),
('admin','ROLE_EMPLOYEE'),
('admin','ROLE_MANAGER'),
('admin','ROLE_ADMIN');
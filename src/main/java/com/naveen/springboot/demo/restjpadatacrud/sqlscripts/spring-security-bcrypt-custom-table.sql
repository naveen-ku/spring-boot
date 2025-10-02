CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
-- Drop roles first & then members because of foreign key reference
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
`user_id` varchar(50) NOT NULL,
`pw` char(68) NOT NULL,
`active` tinyint NOT NULL,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Case 2 when storing bcrypt hashed password in db

INSERT INTO `members`
VALUES
('john','{bcrypt}$2a$12$1o.oPWDRmZyHEtbb0fTEQO4UdIHPlan85/38McZWR32IKS6dBhKmy',1),
('mary','{bcrypt}$2a$12$PHsh4Ec7Nn9y0lAQxde35ufMkZ3Eu5o2vsLKY6hmQB33ThkRK0v5G',1),
('susan','{bcrypt}$2a$12$vAnkc527FKMYyztiWodeCOZvKljwmjrYOyXCIEddp/ZUBrwqqnbom',1),
('admin','{bcrypt}$2a$12$W6.CIc8w2AnUCxbjVP5aSe1YrC.PqKWWlSmM3ItBHgVI6AqsRCql2',1);


CREATE TABLE `roles` (
`user_id` varchar(50) NOT NULL,
`role` varchar(50) NOT NULL,
UNIQUE KEY `roles_idx_1` (`user_id`,`role`),
CONSTRAINT `roles_ibfk_1`
FOREIGN KEY (`user_id`)
REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles`
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
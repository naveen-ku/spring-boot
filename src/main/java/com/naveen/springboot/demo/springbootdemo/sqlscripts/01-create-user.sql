-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'spring'@'%' IDENTIFIED BY 'spring';

GRANT ALL PRIVILEGES ON * . * TO 'spring'@'%';
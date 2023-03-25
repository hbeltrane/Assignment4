-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	8.0.27

--
-- Create Database
--

CREATE DATABASE test;

USE test;

--
-- CREATE Database User
--

CREATE USER 'test_user'@'localhost' IDENTIFIED BY 'secret';

-- GRANT Global Privileges
GRANT SHOW DATABASES, RELOAD
ON *.*
TO 'test_user'@'localhost';

-- GRANT Database Privileges
GRANT SELECT, INSERT, UPDATE, DELETE,
  CREATE, INDEX, ALTER, EXECUTE,
  CREATE VIEW, SHOW VIEW, CREATE ROUTINE,
  ALTER ROUTINE, EVENT, TRIGGER, REFERENCES
ON test.*
TO 'test_user'@'localhost';

FLUSH PRIVILEGES;

USE test;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `lambton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lambton` (
  `sid` varchar(100) NOT NULL,
  `sname` varchar(100) NOT NULL,
  `gpa` double NOT NULL,
  `grade` varchar(100) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

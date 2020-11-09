-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: eLoan
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `loanapplication`
--

DROP TABLE IF EXISTS `loanapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loanapplication` (
  `appid` int unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) NOT NULL,
  `typeofloan` varchar(45) NOT NULL,
  `amtrequested` varchar(45) NOT NULL,
  `dateofapp` varchar(45) NOT NULL,
  `businessstruct` varchar(45) NOT NULL,
  `billingindi` varchar(45) NOT NULL,
  `taxpayer` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `applicationstatus` varchar(45) DEFAULT 'Not Approved',
  PRIMARY KEY (`appid`),
  UNIQUE KEY `loanapplication` (`firstname`,`typeofloan`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanapplication`
--

LOCK TABLES `loanapplication` WRITE;
/*!40000 ALTER TABLE `loanapplication` DISABLE KEYS */;
INSERT INTO `loanapplication` VALUES (35,'Suhas','V','Kulkarni','Home Loan','1300000','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Approved'),(36,'Suhas','V','Kulkarni','Education','400000','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Approved'),(37,'Suhas','V','Kulkarni','Vehicle Loan','1600000','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Not Approved'),(38,'Suvarsha','S','Kulkarni','Education','500000','2020-11-08','Individual','No','No','88922001','11111','suvarshas94@gmail.com','female','Approved'),(41,'Vinayak','R','Kulkarni','Personal Loan','200000','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Approved'),(42,'Random','B','Person','Home Loan','467800','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Approved'),(43,'Suresh','S','Kulkarni','Home Loan','300000','2020-11-08','Individual','Yes','Yes','7795723722','Bangalore','suhasvkulkarnii@gmail.com','male','Approved'),(44,'Anoop','D','Devaru','Home Loan','3400000','2020-11-08','Individual','Yes','Yes','7795723722','bangalore','suhasvkulkarnii@gmail.com','male','Not Approved');
/*!40000 ALTER TABLE `loanapplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loantable`
--

DROP TABLE IF EXISTS `loantable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loantable` (
  `loanid` int NOT NULL AUTO_INCREMENT,
  `appid` varchar(45) NOT NULL,
  `amountsanctioned` varchar(45) NOT NULL,
  `emimonthly` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `lcd` date NOT NULL,
  `psd` date NOT NULL,
  `loanapproveddate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`loanid`),
  UNIQUE KEY `loanid_UNIQUE` (`loanid`),
  UNIQUE KEY `appid_UNIQUE` (`appid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loantable`
--

LOCK TABLES `loantable` WRITE;
/*!40000 ALTER TABLE `loantable` DISABLE KEYS */;
INSERT INTO `loantable` VALUES (1,'1','200202','234','48','2024-11-08','2020-12-08','2020-11-08 11:59:31'),(2,'37','160000','15000','48','0000-00-00','0000-00-00','2020-11-08 13:27:36'),(3,'38','500000','0','120','2030-11-08','2020-12-08','2020-11-08 13:38:38'),(4,'41','200000','0','36','2023-11-08','2020-12-08','2020-11-08 13:44:27'),(5,'42','467800','40146.0','60','2025-11-08','2020-12-08','2020-11-08 14:26:35'),(6,'43','300000','25546.0','120','2030-11-08','2020-12-08','2020-11-08 14:46:10');
/*!40000 ALTER TABLE `loantable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` int NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (12345,'pass');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-08 20:53:16

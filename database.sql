-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: StudentAdmission
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_table`
--

DROP TABLE IF EXISTS `admin_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_table` (
  `id` varchar(255) NOT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `admin_college_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf2ff1baknkxadtwmdp3hs8k6u` (`admin_college_code`),
  CONSTRAINT `FKf2ff1baknkxadtwmdp3hs8k6u` FOREIGN KEY (`admin_college_code`) REFERENCES `numberofcolleges` (`college_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_table`
--

LOCK TABLES `admin_table` WRITE;
/*!40000 ALTER TABLE `admin_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numberofcolleges`
--

DROP TABLE IF EXISTS `numberofcolleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numberofcolleges` (
  `college_code` varchar(255) NOT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `college_rank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`college_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numberofcolleges`
--

LOCK TABLES `numberofcolleges` WRITE;
/*!40000 ALTER TABLE `numberofcolleges` DISABLE KEYS */;
/*!40000 ALTER TABLE `numberofcolleges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrationtable`
--

DROP TABLE IF EXISTS `registrationtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrationtable` (
  `name` varchar(255) NOT NULL,
  `status_application` varchar(255) DEFAULT NULL,
  `board` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `college_choice2` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `gpa` varchar(255) DEFAULT NULL,
  `joindate` datetime(6) DEFAULT NULL,
  `marks` varchar(255) DEFAULT NULL,
  `percentage` int(11) NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  `serial_no` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrationtable`
--

LOCK TABLES `registrationtable` WRITE;
/*!40000 ALTER TABLE `registrationtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrationtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selectedstudents`
--

DROP TABLE IF EXISTS `selectedstudents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selectedstudents` (
  `name` varchar(255) NOT NULL,
  `alloteddepartment` varchar(255) DEFAULT NULL,
  `board` varchar(255) DEFAULT NULL,
  `collegecode` varchar(255) DEFAULT NULL,
  `collegename` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `gpa` varchar(255) DEFAULT NULL,
  `joineddate` datetime(6) DEFAULT NULL,
  `marks` varchar(255) DEFAULT NULL,
  `percentage` int(11) NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selectedstudents`
--

LOCK TABLES `selectedstudents` WRITE;
/*!40000 ALTER TABLE `selectedstudents` DISABLE KEYS */;
/*!40000 ALTER TABLE `selectedstudents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 16:24:49

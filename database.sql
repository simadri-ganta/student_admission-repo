-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: new_database_for_student_admission
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
  KEY `FKk75rbqdol465tni3lxnykjros` (`admin_college_code`),
  CONSTRAINT `FKk75rbqdol465tni3lxnykjros` FOREIGN KEY (`admin_college_code`) REFERENCES `number_of_colleges` (`college_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_table`
--

LOCK TABLES `admin_table` WRITE;
/*!40000 ALTER TABLE `admin_table` DISABLE KEYS */;
INSERT INTO `admin_table` VALUES ('admin','admin','admin'),('CMRCETR05','07CMRCETR05','R05'),('CMRECR02','03CMRECR02','R02'),('CMRITR01','01CMRITR01','R01'),('CMRTCR04','09CMRTCR04','R04');
/*!40000 ALTER TABLE `admin_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `number_of_colleges`
--

DROP TABLE IF EXISTS `number_of_colleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `number_of_colleges` (
  `college_code` varchar(255) NOT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `college_rank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`college_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `number_of_colleges`
--

LOCK TABLES `number_of_colleges` WRITE;
/*!40000 ALTER TABLE `number_of_colleges` DISABLE KEYS */;
INSERT INTO `number_of_colleges` VALUES ('admin',NULL,NULL),('R01','CMRIT','01'),('R02','CMREC','03'),('R04','CMRTC','09'),('R05','CMRCET','07');
/*!40000 ALTER TABLE `number_of_colleges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_table`
--

DROP TABLE IF EXISTS `registration_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration_table` (
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
-- Dumping data for table `registration_table`
--

LOCK TABLES `registration_table` WRITE;
/*!40000 ALTER TABLE `registration_table` DISABLE KEYS */;
INSERT INTO `registration_table` VALUES ('abhisekh','accepted','ssc','R05','R05','it','7.6','2019-08-30 18:12:21.138000','789',80,'chaitanya',0),('akash macha','accepted','ssc','R05','R05','ece','8.835','2019-08-30 18:17:55.404000','890',93,'cmr global',0),('nform','accepted','ssc','R05','R05','ece','8.265','2019-08-30 18:23:13.434000','870',87,'nform',0),('poojitha','accepted','ssc','R01','R04','cse','9.31','2019-08-29 18:22:10.698000','8475',98,'fgdfg',0),('simadri','accepted','cbse','R01','R04','cse','6.8','2019-08-29 18:05:28.433000','890',80,'GSSS',0);
/*!40000 ALTER TABLE `registration_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selected_students`
--

DROP TABLE IF EXISTS `selected_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selected_students` (
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
-- Dumping data for table `selected_students`
--

LOCK TABLES `selected_students` WRITE;
/*!40000 ALTER TABLE `selected_students` DISABLE KEYS */;
INSERT INTO `selected_students` VALUES ('abhisekh','it','ssc','R05','CMRCET','it','7.6','2019-08-30 18:12:21.138000','789',80,'chaitanya'),('akash macha','ece','ssc','R05','CMRCET','ece','8.835','2019-08-30 18:17:55.404000','890',93,'cmr global'),('nform','ece','ssc','R05','CMRCET','ece','8.265','2019-08-30 18:23:13.434000','870',87,'nform'),('poojitha','cse','ssc','R01','CMRIT','cse','9.31','2019-08-29 18:22:10.698000','8475',98,'fgdfg'),('simadri','cse','cbse','R01','CMRIT','cse','6.8','2019-08-29 18:05:28.433000','890',80,'GSSS');
/*!40000 ALTER TABLE `selected_students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-30 18:38:22

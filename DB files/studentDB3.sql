-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: studentdb3
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `college_table`
--

DROP DATABASE IF EXISTS `studentDB3`;
CREATE DATABASE `studentDB3`;

USE `studentDB3`;

DROP TABLE IF EXISTS `college_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college_table` (
  `college_id` int(11) NOT NULL,
  `college_name` varchar(20) DEFAULT NULL,
  `nui` tinyint(1) DEFAULT NULL,
  `county` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`college_id`),
  KEY `fk_county` (`county`),
  CONSTRAINT `fk_county` FOREIGN KEY (`county`) REFERENCES `county_table` (`county_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college_table`
--

LOCK TABLES `college_table` WRITE;
/*!40000 ALTER TABLE `college_table` DISABLE KEYS */;
INSERT INTO `college_table` VALUES (777,'UCD',1,'Dublin'),(888,'GMIT',0,'Galway'),(999,'Trinity',1,'Dublin');
/*!40000 ALTER TABLE `college_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `county_table`
--

DROP TABLE IF EXISTS `county_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `county_table` (
  `county_name` varchar(20) NOT NULL,
  `main_town` varchar(20) DEFAULT NULL,
  `population` int(11) DEFAULT NULL,
  PRIMARY KEY (`county_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `county_table`
--

LOCK TABLES `county_table` WRITE;
/*!40000 ALTER TABLE `county_table` DISABLE KEYS */;
INSERT INTO `county_table` VALUES ('Dublin','Dublin',1500000),('Galway','Galway',500000),('Mayo','Castlebar',425000);
/*!40000 ALTER TABLE `county_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_table`
--

DROP TABLE IF EXISTS `course_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_table` (
  `course_ID` int(11) NOT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_ID`),
  KEY `college_id` (`college_id`),
  CONSTRAINT `course_table_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college_table` (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_table`
--

LOCK TABLES `course_table` WRITE;
/*!40000 ALTER TABLE `course_table` DISABLE KEYS */;
INSERT INTO `course_table` VALUES (100,'BSc Sw Devel',4,888),(101,'BA History',3,999),(102,'BEng Mech Eng',4,888);
/*!40000 ALTER TABLE `course_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_table`
--

DROP TABLE IF EXISTS `student_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_table` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `student_table_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course_table` (`course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_table`
--

LOCK TABLES `student_table` WRITE;
/*!40000 ALTER TABLE `student_table` DISABLE KEYS */;
INSERT INTO `student_table` VALUES (1,'John Smith',100),(2,'Alan O\'Brien',100),(3,'Sarah Murphy',101),(4,'Sean Mulligan',100);
/*!40000 ALTER TABLE `student_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-04 16:24:33

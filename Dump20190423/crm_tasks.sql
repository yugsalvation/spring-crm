-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: crm
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks` (
  `idtasks` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(45) DEFAULT NULL,
  `doc` date NOT NULL,
  `suser` varchar(45) DEFAULT NULL,
  `seuser` varchar(45) DEFAULT NULL,
  `description` longtext NOT NULL,
  `dor` date NOT NULL,
  `dom` date NOT NULL,
  `completed` int(11) DEFAULT '0',
  `tom` time DEFAULT NULL,
  `reminder` int(11) DEFAULT '0',
  `dropp` int(11) DEFAULT '0',
  `names` varchar(45) DEFAULT NULL,
  `names2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtasks`),
  KEY `suser_idx` (`suser`),
  KEY `seuser_idx` (`seuser`),
  KEY `oid_idx` (`oid`),
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `opportunity` (`opportunityid`),
  CONSTRAINT `seuser` FOREIGN KEY (`seuser`) REFERENCES `salesexecutiveuser` (`idseuser`),
  CONSTRAINT `suser` FOREIGN KEY (`suser`) REFERENCES `salesuser` (`idsalesuser`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (2,'O0001','2019-03-18',NULL,'SE0001','dada','2019-03-28','2019-03-30',1,'12:00:00',1,0,'sunita',NULL),(5,'O0007','2019-03-28',NULL,'SE0001','xyz','2019-03-28','2019-03-30',1,'12:00:00',1,0,'mihir',NULL),(6,'O0004','2019-04-07',NULL,'SE0001','gonna meet','2019-04-07','2019-04-09',1,'12:00:00',1,0,'DRASHTI','KOSHTI'),(7,'O0011','2019-04-11',NULL,'SE0002','Call her for meeting.\r\n','2019-04-11','2019-04-11',1,'14:00:00',1,0,'MANSI','LAKHTARIA'),(8,'O0012','2019-04-15',NULL,'SE0001','x6ssc','2019-04-15','2019-04-15',1,'17:00:00',1,0,'DIPAK','SIR');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 22:06:55

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
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leads` (
  `leadid` varchar(45) NOT NULL,
  `names` varchar(45) NOT NULL,
  `walking_date` date NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `contact_number` bigint(11) NOT NULL,
  `leadsource` varchar(45) NOT NULL,
  `agentid` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `opp` int(1) DEFAULT '0',
  `leadsuserid` varchar(45) DEFAULT NULL,
  `names2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`leadid`),
  KEY `agentid_idx` (`agentid`),
  KEY `suserid_idx` (`leadsuserid`),
  CONSTRAINT `agentid` FOREIGN KEY (`agentid`) REFERENCES `leadagentuser` (`agentid`),
  CONSTRAINT `leadsuserid` FOREIGN KEY (`leadsuserid`) REFERENCES `salesuser` (`idsalesuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads`
--

LOCK TABLES `leads` WRITE;
/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` VALUES ('L0003','SUNITA','2019-02-02','sunita@gmail.com',9409385290,'agency','LA0001','GANDHINAGAR',1,'S0001','RAWAL'),('L0004','DRASHTI','2019-03-05','dk@gmail.com',9409385290,'agency','LA0001','GANDHINAGAR',1,'S0001','KOSHTI'),('L0006','CHARMI','2019-03-03','charmirawal@gmail.com',9408110732,'agency','LA0001','GANDHINAGAR',1,'S0001','RAWAL'),('L0017','BHADRESH','2019-04-04','bhadresh@gmail.com',9624004045,'agency','LA0001','ADALAJ',1,'S0001','RAWAL'),('L0018','YUG','2019-03-06','yugrawal@gmail.com',9409385290,'agency','LA0001','ADALAJ',0,'S0009','RAWAL'),('L0019','MIHIR','2019-03-12','mihir@gmail.com',9409385290,'agency','LA0001','AHMEDABAD',1,'S0002','LAKHTARIA'),('L0020','RONAK','2019-03-12','ronakraval@gmail.com',9408110732,'agency','LA0001','AHMEDABAD',1,'S0002','RAWAL'),('L0021','JENISH','2019-03-12','jenish@gmail.com',9428042171,'agency','LA0001','AHMEDABAD',0,'S0009','KOSHTI'),('L0022','SANKET','2019-02-02','sanket@gmail.com',9624004045,'agency','LA0001','PHILADELPHIA',1,'S0002','RAWAL'),('L0023','KRUPA','2019-04-07','write2krupa@gmail.com',9409385290,'AGENCY','LA0001','PHILADELPHIA',0,'S0009','SHARMA'),('L0024','KALPESH','2019-04-10','yugrawal97@gmail.com',9409385290,'AGENCY','LA0001','AHMEDABAD',1,'S0002','KOSHTI'),('L0027','MANSI','2019-04-11','mihirlakhtaria@gmail.com',9409385290,'AGENCY','LA0001','AHMEDABAD',1,'S0009','LAKHTARIA'),('L0028','DIPAK','2019-04-15','yugrawal97@gmail.com',9409385290,'AGENCY','LA0001','ADALAJ',1,'S0001','SIR');
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`hbstudent`@`localhost`*/ /*!50003 TRIGGER `leads_BEFORE_INSERT` BEFORE INSERT ON `leads` FOR EACH ROW BEGIN
INSERT INTO idtablelead VALUES (NULL);
  SET NEW.leadid = CONCAT('L', LPAD(LAST_INSERT_ID(), 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 22:07:08

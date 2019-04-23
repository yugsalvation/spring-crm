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
-- Table structure for table `opportunity`
--

DROP TABLE IF EXISTS `opportunity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `opportunity` (
  `opportunityid` varchar(45) NOT NULL,
  `lid` varchar(45) DEFAULT NULL,
  `probability1` double DEFAULT '0',
  `probability2` double DEFAULT '0',
  `suserid` varchar(45) DEFAULT NULL,
  `sexuserid` varchar(45) DEFAULT NULL,
  `description` longtext,
  `doc` date DEFAULT NULL,
  `names` varchar(45) DEFAULT NULL,
  `contact_number` bigint(11) DEFAULT NULL,
  `walking_date` date DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `dropp` int(11) DEFAULT '0',
  `names2` varchar(45) DEFAULT NULL,
  `customer` int(11) DEFAULT '0',
  PRIMARY KEY (`opportunityid`),
  KEY `salesuserid_idx` (`suserid`),
  KEY `seuserid_idx` (`sexuserid`),
  KEY `leadid_idx` (`lid`),
  CONSTRAINT `lid` FOREIGN KEY (`lid`) REFERENCES `leads` (`leadid`),
  CONSTRAINT `sexuserid` FOREIGN KEY (`sexuserid`) REFERENCES `salesexecutiveuser` (`idseuser`),
  CONSTRAINT `suserid` FOREIGN KEY (`suserid`) REFERENCES `salesuser` (`idsalesuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opportunity`
--

LOCK TABLES `opportunity` WRITE;
/*!40000 ALTER TABLE `opportunity` DISABLE KEYS */;
INSERT INTO `opportunity` VALUES ('O0001','L0003',50,0,'S0001','SE0001','Interested in product.\r\nRequirements: xyz.\r\nAvailable to meet on 21/03/2019.','2019-03-10','SUNITA',9409385290,'2019-03-10','GANDHINAGAR','yugrawal97@gmail.com',0,'RAWAL',1),('O0004','L0004',10,0,'S0001','SE0001','','2019-03-10','DRASHTI',9409385290,'2019-03-10','GANDHINAGAR','yugrawal97@gmail.com',0,'KOSHTI',1),('O0005','L0006',0,0,'S0001',NULL,'','2019-03-10','CHARMI',9408110732,'2019-03-03','GANDHINAGAR','charmirawal@gmail.com',0,'RAWAL',0),('O0006','L0017',0,0,'S0001',NULL,NULL,'2019-03-10','BHADRESH',9624004045,'2019-03-10','ADALAJ','bhadresh@gmail.com',0,'RAWAL',0),('O0007','L0019',0,0,'S0002','SE0001','chances are high','2019-03-28','MIHIR',9409385290,'2019-03-12','AHMEDABAD','mihir@gmail.com',0,'LAKHTARIA',1),('O0008','L0020',0,0,'S0002','SE0002','hard to convince but not impossible','2019-03-28','RONAK',9408110732,'2019-03-12','AHMEDABAD','ronakraval@gmail.com',0,'RAWAL',0),('O0009','L0022',0,0,'S0002',NULL,NULL,'2019-04-07','SANKET',9624004045,'1997-08-13','PHILADELPHIA','sanket@gmail.com',0,'RAWAL',0),('O0010','L0024',0,0,'S0002','SE0002','xyz','2019-04-10','KALPESH',9409385290,'2019-04-10','AHMEDABAD','yugrawal97@gmail.com',0,'KOSHTI',0),('O0011','L0027',0,0,'S0009','SE0002','Probability=70 %\r\ninterested in xyz product\r\nhas abc requirements','2019-04-11','MANSI',9409385290,'2019-04-11','AHMEDABAD','mihirlakhtaria@gmail.com',0,'LAKHTARIA',1),('O0012','L0028',0,0,'S0001','SE0001','probability 20%\r\nInterested','2019-04-15','DIPAK',9409385290,'2019-04-15','ADALAJ','yugrawal97@gmail.com',0,'SIR',1);
/*!40000 ALTER TABLE `opportunity` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`hbstudent`@`localhost`*/ /*!50003 TRIGGER `opportunity_BEFORE_INSERT` BEFORE INSERT ON `opportunity` FOR EACH ROW BEGIN
INSERT INTO idtableopportunity VALUES (NULL);
  SET NEW.opportunityid = CONCAT('O', LPAD(LAST_INSERT_ID(), 4, '0'));
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

-- Dump completed on 2019-04-23 22:07:12

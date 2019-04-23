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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `cid` varchar(45) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `signupdate` date DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `contact_number` bigint(11) DEFAULT NULL,
  `address1` longtext,
  `salesuserid` varchar(45) DEFAULT NULL,
  `seuserid` varchar(45) DEFAULT NULL,
  `addressproof` longtext,
  `oppid` varchar(45) DEFAULT NULL,
  `address2` longtext,
  `city` varchar(45) DEFAULT NULL,
  `dropp` int(11) DEFAULT '0',
  PRIMARY KEY (`cid`),
  KEY `salesuserid_idx` (`salesuserid`),
  KEY `seuserid_idx` (`seuserid`),
  KEY `oppid_idx` (`oppid`),
  CONSTRAINT `oppid` FOREIGN KEY (`oppid`) REFERENCES `opportunity` (`opportunityid`),
  CONSTRAINT `salesuserid` FOREIGN KEY (`salesuserid`) REFERENCES `salesuser` (`idsalesuser`),
  CONSTRAINT `seuserid` FOREIGN KEY (`seuserid`) REFERENCES `salesexecutiveuser` (`idseuser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('C0001','SUNITA','RAWAL','2019-03-30','yugrawal97@gmail.com',9409385290,'5003,SANATAN 1, WING A','S0001','SE0001','C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/customeridproof/C0001.pdf','O0001','AMBA TOWNSHIP,TRIMANDIR','ADALAJ',0),('C0002','MIHIR','LAKHTARIA','2019-03-30','mihirlakhtaria@gmail.com',9409385290,'5003,SANATAN 1, WING A','S0002','SE0001','','O0007','AMBA TOWNSHIP,TRIMANDIR','AHMEDABAD',0),('C0003','DRASHTI','KOSHTI','2019-04-08','yugrawal97@gmail.com',9409385290,'5003,SANATAN 1, WING A','S0001','SE0001','','O0004','AMBA TOWNSHIP,TRIMANDIR','GANDHINAGAR',0),('C0004','MANSI','LAKHTARIA','2019-04-11','mihirlakhtaria@gmail.com',9409385290,'5003,Sanatan 1, Wing A','S0009','SE0002','C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/customeridproof/C0004.pdf','O0011','Amba Township,Trimandir','AHMEDABAD',0),('C0005','DIPAK','SIR','2019-04-15','yugrawal97@gmail.com',9409385290,'5003,SANATAN 1, WING A','S0001','SE0001',NULL,'O0012','AMBA TOWNSHIP,TRIMANDIR','ADALAJ',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`hbstudent`@`localhost`*/ /*!50003 TRIGGER `customer_BEFORE_INSERT` BEFORE INSERT ON `customer` FOR EACH ROW BEGIN
INSERT INTO idtablecustomer VALUES (NULL);
  SET NEW.cid = CONCAT('C', LPAD(LAST_INSERT_ID(), 4, '0'));
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

-- Dump completed on 2019-04-23 22:07:07

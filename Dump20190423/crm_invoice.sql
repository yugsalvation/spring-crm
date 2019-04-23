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
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invoice` (
  `idinvoice` varchar(45) NOT NULL,
  `custid` varchar(45) DEFAULT NULL,
  `productid` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `duedays` int(11) DEFAULT '0',
  `interest` int(11) DEFAULT '0',
  `sexeuserid` varchar(45) DEFAULT NULL,
  `acuser` varchar(45) DEFAULT NULL,
  `ordid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinvoice`),
  KEY `custid_idx` (`custid`),
  KEY `productid_idx` (`productid`),
  KEY `sexeuserid_idx` (`sexeuserid`),
  KEY `acuser_idx` (`acuser`),
  KEY `ordid_idx` (`ordid`),
  CONSTRAINT `acuser` FOREIGN KEY (`acuser`) REFERENCES `accountuser` (`idaccountuser`),
  CONSTRAINT `custid` FOREIGN KEY (`custid`) REFERENCES `customer` (`cid`),
  CONSTRAINT `ordid` FOREIGN KEY (`ordid`) REFERENCES `orders` (`idorder`),
  CONSTRAINT `productid` FOREIGN KEY (`productid`) REFERENCES `product` (`idproduct`),
  CONSTRAINT `sexeuserid` FOREIGN KEY (`sexeuserid`) REFERENCES `salesexecutiveuser` (`idseuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES ('I0001','C0001','P0001','102',0,0,'SE0001','AC0001','OR0001'),('I0002','C0004','P0001','102.0',0,0,'SE0002','AC0003','OR0002');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`hbstudent`@`localhost`*/ /*!50003 TRIGGER `invoice_BEFORE_INSERT` BEFORE INSERT ON `invoice` FOR EACH ROW BEGIN
INSERT INTO idtableinvoice VALUES (NULL);
  SET NEW.idinvoice = CONCAT('I', LPAD(LAST_INSERT_ID(), 4, '0'));
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

-- Dump completed on 2019-04-23 22:07:03

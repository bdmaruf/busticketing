CREATE DATABASE  IF NOT EXISTS `bus` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bus`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bus
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Temporary table structure for view `availableseat`
--

DROP TABLE IF EXISTS `availableseat`;
/*!50001 DROP VIEW IF EXISTS `availableseat`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `availableseat` (
  `sche_id` tinyint NOT NULL,
  `availableseat` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `availableseats`
--

DROP TABLE IF EXISTS `availableseats`;
/*!50001 DROP VIEW IF EXISTS `availableseats`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `availableseats` (
  `sche_id` tinyint NOT NULL,
  `available_seat` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `bookedseat`
--

DROP TABLE IF EXISTS `bookedseat`;
/*!50001 DROP VIEW IF EXISTS `bookedseat`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `bookedseat` (
  `sche_id` tinyint NOT NULL,
  `booked_seat` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `sche_id` int(11) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `total_seat` int(11) NOT NULL,
  `seat_numbers` varchar(150) NOT NULL,
  `bording_stopage_id` int(11) NOT NULL,
  `booking_time` date DEFAULT NULL,
  `pay_method_id` int(11) NOT NULL,
  `trnx_id` int(11) DEFAULT NULL,
  `total_cost` decimal(10,0) NOT NULL,
  `pin` varchar(20) NOT NULL,
  `booking_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (3,8,'1430404168883',1,'[H4]',10,'2015-04-30',1,NULL,500,'1430404192327',0),(4,11,'1430405107760',1,'[E4]',12,'2015-04-30',1,NULL,600,'1430405113966',0),(5,12,'1430405197909',1,'[A3]',12,'2015-04-30',1,NULL,700,'1430405212744',0),(6,9,'1430405287674',1,'[C3]',10,'2015-04-30',1,NULL,1200,'1430405362864',0),(7,11,'1430407488799',1,'[C2]',17,NULL,2,NULL,600,'1430407516615',0),(8,11,'1430407769728',1,'[D3]',12,'2015-04-30',2,NULL,600,'1430407790283',0),(9,8,'1430407916023',4,'[E1, E2, F1, F2]',10,'2015-04-30',2,NULL,2000,'1430407928966',0),(10,9,'1430421855239',1,'[C2]',10,'2015-05-01',1,NULL,1200,'1430421978470',0),(11,10,'1430422739190',3,'[A1, A2, A3]',10,'2015-05-01',2,NULL,6000,'1430422758450',0),(12,9,'1430422890174',1,'[C1]',10,'2015-05-01',2,NULL,1200,'1430422901019',0),(13,10,'1430423238238',1,'[A4]',10,'2015-05-01',1,NULL,2000,'1430423254302',0),(14,10,'1430423487581',4,'[B1, B2, B3, B4]',10,'2015-05-01',1,NULL,8000,'1430423502581',0),(15,9,'1430424207618',1,'[D2]',10,'2015-05-01',1,NULL,1200,'1430424218868',0),(16,10,'1430571653253',1,'[D4]',10,'2015-05-02',1,NULL,2000,'1430571678180',0),(17,13,'1430572978115',2,'[A4, B4]',14,'2015-05-02',2,NULL,3000,'1430573000657',0),(18,10,'1430573500023',2,'[C3, D3]',10,'2015-05-02',1,NULL,4000,'1430573514949',0),(19,10,'1430573643536',1,'[C2]',10,'2015-05-02',1,NULL,2000,'1430573657246',0),(20,10,'1430574030891',3,'[C1, D1, D2]',10,'2015-05-02',2,NULL,6000,'1430574054880',0),(21,10,'1430574155946',4,'[E1, E2, E3, E4]',10,'2015-05-02',2,NULL,8000,'1430574160054',0),(22,10,'1430574327302',4,'[F4, G4, H4, I4]',10,'2015-05-02',2,NULL,8000,'1430574356232',0),(23,10,'1430574480204',1,'[F3]',11,'2015-05-02',2,NULL,2000,'1430574501920',0),(24,10,'1430574512334',1,'[F2]',10,'2015-05-02',1,NULL,2000,'1430574533792',0),(25,10,'1430576343703',3,'[I1, I2, I3]',10,'2015-05-02',2,NULL,6000,'1430576375016',0),(26,10,'1430577213273',1,'[H3]',10,'2015-05-02',2,NULL,2000,'1430577238900',0),(27,13,'1430577340993',1,'[A3]',14,'2015-05-02',1,NULL,1500,'1430577356880',0),(28,10,'1430577419789',1,'[G3]',10,'2015-05-02',1,NULL,2000,'1430577436378',0),(29,13,'1430577570782',1,'[C4]',14,'2015-05-02',2,NULL,1500,'1430577582880',0),(30,13,'1430577688906',1,'[A2]',14,'2015-05-02',2,NULL,1500,'1430577691657',0),(31,10,'1430581820265',1,'[G2]',10,'2015-05-02',1,NULL,2000,'1430581839092',0),(32,10,'1430581925297',1,'[H2]',10,'2015-05-02',1,NULL,2000,'1430581927370',0),(33,13,'1430583912695',1,'[B3]',18,'2015-05-02',2,NULL,1500,'1430583926562',0),(34,13,'1430587031750',1,'[C3]',14,'2015-05-02',1,NULL,1500,'1430587047588',0),(35,10,'1430587135593',1,'[F1]',10,'2015-05-02',2,NULL,2000,'1430587146858',0),(36,15,'1430909218840',3,'[A2, A3, A4]',10,'2015-05-06',2,NULL,1500,'1430909242876',0),(37,13,'1431529277792',2,'[D4, E4]',14,'2015-05-13',2,NULL,3000,'1431529602307',0),(38,15,'1431548253202',1,'[B4]',16,'2015-05-14',3,NULL,500,'1431548262582',0),(39,10,'1431548650731',1,'[G1]',11,'2015-05-14',3,NULL,2000,'1431548654224',0),(40,13,'1431549511974',1,'[D3]',14,'2015-05-14',3,NULL,1500,'1431549567369',0),(41,13,'1431549619410',0,'[]',14,'2015-05-14',3,NULL,0,'1431549620828',0),(42,13,'1431550936371',1,'[A1]',14,'2015-05-14',3,NULL,1500,'1431550949686',0),(43,13,'1431587921238',2,'[B2, C2]',18,'2015-05-14',3,NULL,3000,'1431587954016',0),(44,13,'1431588797642',1,'[E3]',14,'2015-05-14',2,NULL,1500,'1431588806887',0),(45,13,'1431595825166',1,'[G1]',14,'2015-05-14',3,NULL,1500,'1431595840858',0),(46,14,'1431598303670',4,'[A3, B3, C3, D3]',0,'2015-05-14',2,NULL,2800,'1431598317081',0),(47,13,'1431598335848',1,'[B1]',14,'2015-05-14',2,NULL,1500,'1431598337575',0),(48,14,'1431598521793',1,'[A2]',20,'2015-05-14',2,NULL,700,'1431598524956',0),(49,14,'1431598625000',1,'[A1]',25,'2015-05-14',2,NULL,700,'1431598627853',0),(50,17,'1431598776732',4,'[A2, A3, A4, B3]',18,'2015-05-14',3,NULL,3600,'1431598785394',0),(51,16,'1431598911422',3,'[A1, A2, B2]',17,'2015-05-14',2,NULL,2100,'1431598936738',0),(52,13,'1431608025435',2,'[C1, D2]',18,'2015-05-14',3,NULL,3000,'1431608047871',0),(53,13,'1431610804936',4,'[G3, G4, H3, H4]',18,'2015-05-14',2,NULL,6000,'1431610825996',0);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus` (
  `bus_id` int(11) NOT NULL AUTO_INCREMENT,
  `opt_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `reg_no` varchar(20) DEFAULT NULL,
  `total_seat` int(11) NOT NULL,
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (6,1,5,14,'k-23-4590',36),(7,1,6,14,'k-09-0909',27),(8,1,7,14,'ki-09-0987',36),(9,8,5,14,'yp-09-0987',36),(10,8,6,14,'y-09-5645',27),(11,9,5,14,'jh-67-7865',36),(12,7,6,15,'yu-098765',27),(13,8,6,16,'ka-4529-22',27),(14,9,7,16,'ga-37-8976',40),(15,7,6,19,'ho-45-9876',27),(16,8,7,17,'ka-87-9876',40);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  `facility` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (5,'Regular','Non AC\r\nEconomy'),(6,'Business','AC Gold'),(7,'Economy','AC\r\nRegular');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `fromloc`
--

DROP TABLE IF EXISTS `fromloc`;
/*!50001 DROP VIEW IF EXISTS `fromloc`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `fromloc` (
  `sche_id` tinyint NOT NULL,
  `loc_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT,
  `loc_name` varchar(45) NOT NULL,
  `district` varchar(45) NOT NULL,
  PRIMARY KEY (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Dhaka','Dhaka'),(8,'Khulna','Khulna'),(9,'Sylhet','Sylhet'),(11,'Chittagong','Chittagong'),(12,'Borishal','Borishal'),(13,'Cox\'s Bazar','Cox\'s Bazar'),(15,'Rajshahi','Rajshahi'),(16,'Jashor','Jashor');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `opt_id` int(11) NOT NULL AUTO_INCREMENT,
  `opt_name` varchar(45) NOT NULL,
  `opt_details` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`opt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
INSERT INTO `operator` VALUES (1,'Sohag poribohoh','local'),(6,'GSK','emni'),(7,'Volvo','Volvo-AC/national international'),(8,'Shamoli','local inter district'),(9,'BRTC','Government Bus service'),(10,'Shukhin','inter district');
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymethod`
--

DROP TABLE IF EXISTS `paymethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymethod` (
  `pay_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `method` varchar(45) NOT NULL,
  `method_details` varchar(50) DEFAULT NULL,
  `mobile_no` varchar(20) NOT NULL,
  PRIMARY KEY (`pay_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymethod`
--

LOCK TABLES `paymethod` WRITE;
/*!40000 ALTER TABLE `paymethod` DISABLE KEYS */;
INSERT INTO `paymethod` VALUES (1,'Bkash','Mobile Payment','0198765433'),(2,'MKash','Mobile Payment','98709876'),(3,'credit','Online Payment','');
/*!40000 ALTER TABLE `paymethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `route_id` int(11) NOT NULL AUTO_INCREMENT,
  `route_name` varchar(100) NOT NULL,
  `from_loc_id` int(11) NOT NULL,
  `to_loc_id` int(11) NOT NULL,
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (14,'Dhaka-Chittagong',1,11),(15,'dhaka-Khulna',1,8),(16,'Dhaka-Sylhet',1,9),(17,'Dhaka-Borishal',1,12),(18,'Dhaka-Cox',1,13),(19,'Dhaka-Rajshahi',15,15),(20,'Dhaka-Jashor',1,16);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedul`
--

DROP TABLE IF EXISTS `schedul`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedul` (
  `sche_id` int(11) NOT NULL AUTO_INCREMENT,
  `bus_id` int(11) NOT NULL,
  `dprt_date` date NOT NULL,
  `dprt_time` time NOT NULL,
  `ariv_date` date NOT NULL,
  `ariv_time` time NOT NULL,
  `fare` varchar(45) NOT NULL,
  `sche_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`sche_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedul`
--

LOCK TABLES `schedul` WRITE;
/*!40000 ALTER TABLE `schedul` DISABLE KEYS */;
INSERT INTO `schedul` VALUES (10,8,'2015-05-15','13:00:00','2015-05-15','14:00:00','2000',1),(13,11,'2015-05-14','20:44:00','2015-05-15','15:00:00','1500',1),(14,12,'2015-05-16','09:00:00','2015-05-16','19:00:00','700',1),(15,6,'2015-05-15','16:00:00','2015-05-16','10:00:00','500',1),(16,13,'2015-05-14','13:13:00','2015-05-15','15:00:00','700',1),(17,14,'2015-05-15','12:00:00','2015-05-16','14:18:00','900',1);
/*!40000 ALTER TABLE `schedul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `schedulfromto`
--

DROP TABLE IF EXISTS `schedulfromto`;
/*!50001 DROP VIEW IF EXISTS `schedulfromto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `schedulfromto` (
  `sche_id` tinyint NOT NULL,
  `fromlocation` tinyint NOT NULL,
  `tolocation` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `searchview`
--

DROP TABLE IF EXISTS `searchview`;
/*!50001 DROP VIEW IF EXISTS `searchview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `searchview` (
  `sche_id` tinyint NOT NULL,
  `opt_name` tinyint NOT NULL,
  `category_id` tinyint NOT NULL,
  `category_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `seatbooking`
--

DROP TABLE IF EXISTS `seatbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seatbooking` (
  `seatbooking_id` int(11) NOT NULL AUTO_INCREMENT,
  `sche_id` int(11) NOT NULL,
  `seat_number` varchar(5) NOT NULL,
  PRIMARY KEY (`seatbooking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatbooking`
--

LOCK TABLES `seatbooking` WRITE;
/*!40000 ALTER TABLE `seatbooking` DISABLE KEYS */;
INSERT INTO `seatbooking` VALUES (74,8,'A1'),(75,8,'A2'),(76,8,'A3'),(77,8,'A4'),(78,8,'I1'),(79,8,'2'),(80,8,'I3'),(81,8,'I4'),(82,11,'E2'),(83,11,'E3'),(84,11,'F2'),(85,11,'F3'),(86,8,'I1'),(87,8,'2'),(88,8,'I3'),(89,8,'I4'),(90,9,'A1'),(91,9,'A2'),(92,9,'A3'),(93,9,'B1'),(94,9,'B2'),(95,9,'B3'),(96,8,'B2'),(97,8,'B3'),(98,8,'C2'),(99,8,'E3'),(100,13,'F1'),(101,13,'F2'),(102,13,'F3'),(103,13,'F4'),(104,12,'F2'),(105,12,'G2'),(106,12,'H2'),(107,12,'2'),(108,11,'A4'),(109,11,'B4'),(110,8,'B4'),(111,8,'C4'),(112,11,'A1'),(113,11,'A2'),(114,11,'A3'),(115,11,'B1'),(116,11,'B2'),(117,11,'B3'),(118,11,'H4'),(119,11,'I4'),(120,8,'B1'),(121,8,'C1'),(122,8,'C3'),(123,8,'D4'),(124,8,'E4'),(125,8,'D3'),(126,8,'D2'),(127,11,'C4'),(128,8,'I2'),(129,8,'F4'),(130,8,'D1'),(131,11,'G4'),(132,11,'C3'),(133,8,'H4'),(134,11,'E4'),(135,12,'A3'),(136,9,'C3'),(137,11,'C2'),(138,11,'D4'),(139,11,'D3'),(140,8,'E1'),(141,8,'E2'),(142,8,'F1'),(143,8,'F2'),(144,9,'C2'),(145,10,'A1'),(146,10,'A2'),(147,10,'A3'),(148,9,'C1'),(149,10,'A4'),(150,10,'B1'),(151,10,'B2'),(152,10,'B3'),(153,10,'B4'),(154,9,'D3'),(155,9,'D3'),(156,9,'D3'),(157,9,'D3'),(158,10,'C4'),(159,9,'D2'),(160,10,'D4'),(161,13,'A4'),(162,13,'B4'),(163,10,'C3'),(164,10,'D3'),(165,10,'C2'),(166,10,'C1'),(167,10,'D1'),(168,10,'D2'),(169,10,'E1'),(170,10,'E2'),(171,10,'E3'),(172,10,'E4'),(173,10,'F4'),(174,10,'G4'),(175,10,'H4'),(176,10,'I4'),(177,10,'F3'),(178,10,'F2'),(179,10,'I1'),(180,10,'I2'),(181,10,'I3'),(182,10,'H3'),(183,13,'A3'),(184,10,'G3'),(185,13,'C4'),(186,13,'A2'),(187,10,'G2'),(188,10,'H2'),(189,13,'B3'),(190,13,'C3'),(191,10,'F1'),(192,15,'A2'),(193,15,'A3'),(194,15,'A4'),(195,13,'D4'),(196,13,'E4'),(197,15,'B4'),(198,10,'G1'),(199,13,'D3'),(200,13,'A1'),(201,13,'B2'),(202,13,'C2'),(203,13,'E3'),(204,13,'G1'),(205,14,'A3'),(206,14,'B3'),(207,14,'C3'),(208,14,'D3'),(209,13,'B1'),(210,14,'A2'),(211,14,'A1'),(212,17,'A2'),(213,17,'A3'),(214,17,'A4'),(215,17,'B3'),(216,16,'A1'),(217,16,'A2'),(218,16,'B2'),(219,13,'C1'),(220,13,'D2'),(221,13,'G3'),(222,13,'G4'),(223,13,'H3'),(224,13,'H4');
/*!40000 ALTER TABLE `seatbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stopage`
--

DROP TABLE IF EXISTS `stopage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stopage` (
  `stopage_id` int(11) NOT NULL AUTO_INCREMENT,
  `stopage_name` varchar(45) NOT NULL,
  `stopage_loc_id` int(11) NOT NULL,
  `opt_id` int(11) NOT NULL,
  PRIMARY KEY (`stopage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stopage`
--

LOCK TABLES `stopage` WRITE;
/*!40000 ALTER TABLE `stopage` DISABLE KEYS */;
INSERT INTO `stopage` VALUES (10,'Motijhil',1,1),(11,'Kollanpur',1,1),(12,'Uttara',1,8),(14,'Motijhil',1,9),(15,'Kollan pur',1,8),(16,'Gabtoli',1,1),(17,'Gabtoli',1,8),(18,'komolapur',1,9),(19,'Motijhil',1,8),(20,'Motijhil',1,7),(21,'Motijhil',1,6),(22,'Motijhil',1,10),(23,'Gabtoli',1,6),(24,'Kollanpur',1,10),(25,'Uttara',1,7);
/*!40000 ALTER TABLE `stopage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!50001 DROP VIEW IF EXISTS `ticket`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `ticket` (
  `booking_id` tinyint NOT NULL,
  `pin` tinyint NOT NULL,
  `sche_id` tinyint NOT NULL,
  `seat_numbers` tinyint NOT NULL,
  `total_cost` tinyint NOT NULL,
  `fromlocation` tinyint NOT NULL,
  `tolocation` tinyint NOT NULL,
  `opt_name` tinyint NOT NULL,
  `category_name` tinyint NOT NULL,
  `dprt_date` tinyint NOT NULL,
  `dprt_time` tinyint NOT NULL,
  `user_firstname` tinyint NOT NULL,
  `user_age` tinyint NOT NULL,
  `stopage_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `toloc`
--

DROP TABLE IF EXISTS `toloc`;
/*!50001 DROP VIEW IF EXISTS `toloc`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `toloc` (
  `sche_id` tinyint NOT NULL,
  `loc_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `totalseat`
--

DROP TABLE IF EXISTS `totalseat`;
/*!50001 DROP VIEW IF EXISTS `totalseat`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `totalseat` (
  `sche_id` tinyint NOT NULL,
  `total_seat` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `trnx_id` int(11) NOT NULL AUTO_INCREMENT,
  `trnx_number` varchar(45) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `trnx_time` datetime NOT NULL,
  `mobile_no` varchar(20) NOT NULL,
  PRIMARY KEY (`trnx_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_firstname` varchar(45) NOT NULL,
  `user_lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_sex` varchar(7) NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_mobile` varchar(15) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('10','guest','Abdullah Al ','Maruf','guest','Male',26,'01818252671','eng.maruf@gmail.com',1),('11','guest','Kamal ','Uddin','guest','Male',25,'1234567890','asdfghjkl@gmail.com',1),('12','guest','','','guest','',0,'','',1),('13','guest','','','guest','',0,'','',1),('14','guest','dfa','a','guest','',0,'as','sa',1),('1430397206154','guest','asdfas','asdfas','guest','Male',22,'asdf','asdf',1),('1430397363939','guest','asd','asd','guest','Male',11,'asdf','hgfdsx',1),('1430397530086','guest','asdf','asdfas','guest','Male',22,'asd','asd',1),('1430401326718','guest','Selimul','Quader','guest','Male',24,'0987657','selim@gmail.com',1),('1430401628239','guest','kajsas',';jjksad;','guest','Male',657,'adsf','asdf',1),('1430403985071','guest','fahad','Abdullah','guest','Male',32,'87654','fahad@gmail.com',1),('1430404168883','guest','fahad','Abdullah','guest','Male',43,'9876543','asdfas@gmail.com',1),('1430405107760','guest','fahad','Abdullah','guest','Male',43,'9876543','asdfas@gmail.com',1),('1430405197909','guest','abdullah','ma','guest','Male',22,'23423','asdfsdf',1),('1430405287674','guest','asds','asdf','guest','Male',33,'asdf','asdf',1),('1430407488799','guest','jahan','islam','guest','Female',23,'897654','jha@gmail.com',1),('1430407703763','guest','selimul','quader','guest','Male',24,'0987654','selim@gmail.com',1),('1430407769728','guest','selimul ','quader','guest','Male',33,'323423423','asfsad@gasd.das',1),('1430407916023','guest','selimul ','quader','guest','Male',33,'323423423','asfsad@gasd.das',1),('1430421855239','guest','sdasd','asdassd','guest','Male',22,'asd','asdf',1),('1430422739190','guest','jamal','uddin','guest','Male',22,'456789','jamal@gmail.com',1),('1430422890174','guest','asdfa','asdfasd','guest','Male',22,'asdaf','asdfa',1),('1430423238238','guest','samad','islam','guest','Male',21,'asdfa','asdf',1),('1430423487581','guest','abdus','samal','guest','Male',11,'212423423','adfasdf',1),('1430423970357','guest','asdffa','asdfas','guest','Male',22,'asd','asdfas',1),('1430424116140','guest','asdffa','asdfas','guest','Male',22,'asd','asdfas',1),('1430424207618','guest','aasdfas','asdfasdf','guest','Male',1,'asdf','asdf',1),('1430571653253','guest','Robbani','Islam','guest','Male',32,'5467389','rabbani@gmail.com',1),('1430572978115','guest','fahim','kah','guest','Male',43,'23244','fahim@gmail.com',1),('1430573500023','guest','abdullah','maruf','guest','Male',23,'2342242','asdfasdfasff',1),('1430573643536','guest','kamak','uddin','guest','Male',23,'24323454','asdfasd',1),('1430574030891','guest','kamal','uddin','guest','Male',21,'876598','kamal@gmail.com',1),('1430574155946','guest','kamal','uddin','guest','Male',21,'876598','kamal@gmail.com',1),('1430574327302','guest','test','user','guest','Male',20,'1234567890','test@test.com',1),('1430574480204','guest','mozila','user','guest','Male',21,'2232342','mozila@gmail.com',1),('1430574512334','guest','chromium','user','guest','Male',20,'1234567890','chromium',1),('1430576343703','guest','selimul','Quader','guest','Male',24,'000000000','sq.du2009@gmail.com',1),('1430577213273','guest','in','th','guest','Male',32,'mean','time',1),('1430577340993','guest','mon','dia','guest','Male',89,'pora','d',1),('1430577419789','guest','joldi','asen','guest','Male',32,'sit ','fillup',1),('1430577570782','guest','joldi','asen','guest','Male',32,'sit ','fillup',1),('1430577688906','guest','joldi','asen','guest','Male',32,'sit ','fillup',1),('1430581820265','guest','adsfas','asdf','guest','Male',22,'asd','asdf',1),('1430581925297','guest','adsfas','asdf','guest','Male',22,'asd','asdf',1),('1430583912695','guest','asdfg','zxcvb','guest','Male',33,'zxcvb','zxc',1),('1430587031750','guest','.',';','guest','Male',0,'l','l',1),('1430587135593','guest','.fsdfa','sdf','guest','Male',432,'l','l',1),('1430909218840','guest','sdfgh','sdfghj','guest','Male',2,'234567890','asdfghj',1),('1431529277792','guest','Selimul ','Quader','guest','Male',26,'01717123456','selimul@gmail.com',1),('1431548253202','guest','sdSA','asD','guest','Male',0,'As','as',1),('1431548650731','guest','sdSA','asD','guest','Male',0,'As','as',1),('1431549511974','guest','asdf','asd','guest','Male',33,'asd','asd',1),('1431549619410','guest','asdf','asd','guest','Male',33,'asd','asd',1),('1431550936371','guest','544','33','guest','Male',3,'asd','sad',1),('1431587921238','guest','Shofiqul','Islam','guest','Male',90,'098098','-------',1),('1431588797642','guest','gfd','d','guest','Male',22,'vfds','fds',1),('1431595825166','guest','asdfgh','zxcvb','guest','Male',12,'zxcv','zxcvb',1),('1431598303670','guest','ksd;fk','adsfa','guest','Male',22,'asdf','sadf',1),('1431598335848','guest','ksd;fk','adsfa','guest','Male',22,'asdf','sadf',1),('1431598521793','guest','ksd;fk','adsfa','guest','Male',22,'asdf','sadf',1),('1431598625000','guest','ksd;fk','adsfa','guest','Male',22,'asdf','sadf',1),('1431598776732','guest','ksd;fk','adsfa','guest','Male',22,'asdf','sadf',1),('1431598911422','guest','Rofiqul ','islam','guest','Male',33,'0987654','rofiqul@gmail.com',1),('1431608025435','guest','dgdgdg','gdd','guest','Male',23,'dfhg','dfff',1),('1431610804936','guest','asdfas','asdfa','guest','Male',22,'sdfgsd','sfdgs',1),('15','guest','','','guest','',0,'','',1),('16','guest','','','guest','',0,'','',1),('17','guest','noman','khandokar','guest','Male',24,'098765432','noman@gmail.com',1),('18','guest','','','guest','',0,'','',1),('19','guest','fds','','guest','',0,'','',1),('20','guest','a','a','guest','Male',0,'a','a',1),('21','guest','jhgf','ad','guest','Male',9,'ads','asdf',1),('22','guest','Rakibul','hasan','guest','Male',23,'34567890','hasan@gmail.com',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `user_access` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'guest','without registration booked'),(2,'registered','update will get');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `availableseat`
--

/*!50001 DROP TABLE IF EXISTS `availableseat`*/;
/*!50001 DROP VIEW IF EXISTS `availableseat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `availableseat` AS select `seatbooking`.`sche_id` AS `sche_id`,((select `bus`.`total_seat` from `bus` where (`bus`.`bus_id` = (select `schedul`.`bus_id` from `schedul` where (`schedul`.`sche_id` = `seatbooking`.`sche_id`)))) - count(`seatbooking`.`seat_number`)) AS `availableseat` from `seatbooking` group by `seatbooking`.`sche_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `availableseats`
--

/*!50001 DROP TABLE IF EXISTS `availableseats`*/;
/*!50001 DROP VIEW IF EXISTS `availableseats`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `availableseats` AS select `totalseat`.`sche_id` AS `sche_id`,(`totalseat`.`total_seat` - ifnull((select `bookedseat`.`booked_seat` from `bookedseat` where (`bookedseat`.`sche_id` = `totalseat`.`sche_id`)),0)) AS `available_seat` from `totalseat` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `bookedseat`
--

/*!50001 DROP TABLE IF EXISTS `bookedseat`*/;
/*!50001 DROP VIEW IF EXISTS `bookedseat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bookedseat` AS select `seatbooking`.`sche_id` AS `sche_id`,count(0) AS `booked_seat` from `seatbooking` group by `seatbooking`.`sche_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `fromloc`
--

/*!50001 DROP TABLE IF EXISTS `fromloc`*/;
/*!50001 DROP VIEW IF EXISTS `fromloc`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `fromloc` AS select `schedul`.`sche_id` AS `sche_id`,`location`.`loc_name` AS `loc_name` from (((`location` join `route`) join `bus`) join `schedul`) where ((`location`.`loc_id` = `route`.`from_loc_id`) and (`route`.`route_id` = `bus`.`route_id`) and (`bus`.`bus_id` = `schedul`.`bus_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `schedulfromto`
--

/*!50001 DROP TABLE IF EXISTS `schedulfromto`*/;
/*!50001 DROP VIEW IF EXISTS `schedulfromto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `schedulfromto` AS select `fromloc`.`sche_id` AS `sche_id`,`fromloc`.`loc_name` AS `fromlocation`,`toloc`.`loc_name` AS `tolocation` from (`fromloc` join `toloc`) where (`fromloc`.`sche_id` = `toloc`.`sche_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `searchview`
--

/*!50001 DROP TABLE IF EXISTS `searchview`*/;
/*!50001 DROP VIEW IF EXISTS `searchview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `searchview` AS select `schedul`.`sche_id` AS `sche_id`,`operator`.`opt_name` AS `opt_name`,`category`.`category_id` AS `category_id`,`category`.`category_name` AS `category_name` from ((`schedul` join `operator`) join `category`) where ((`operator`.`opt_id` = (select `bus`.`opt_id` from `bus` where (`bus`.`bus_id` = `schedul`.`bus_id`))) and (`category`.`category_id` = (select `bus`.`category_id` from `bus` where (`bus`.`bus_id` = `schedul`.`bus_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ticket`
--

/*!50001 DROP TABLE IF EXISTS `ticket`*/;
/*!50001 DROP VIEW IF EXISTS `ticket`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ticket` AS select `booking`.`booking_id` AS `booking_id`,`booking`.`pin` AS `pin`,`booking`.`sche_id` AS `sche_id`,`booking`.`seat_numbers` AS `seat_numbers`,`booking`.`total_cost` AS `total_cost`,`schedulfromto`.`fromlocation` AS `fromlocation`,`schedulfromto`.`tolocation` AS `tolocation`,`searchview`.`opt_name` AS `opt_name`,`searchview`.`category_name` AS `category_name`,`schedul`.`dprt_date` AS `dprt_date`,`schedul`.`dprt_time` AS `dprt_time`,`user`.`user_firstname` AS `user_firstname`,`user`.`user_age` AS `user_age`,`stopage`.`stopage_name` AS `stopage_name` from (((((`booking` join `schedulfromto`) join `schedul`) join `searchview`) join `stopage`) join `user`) where ((`booking`.`sche_id` = `schedulfromto`.`sche_id`) and (`booking`.`sche_id` = `schedul`.`sche_id`) and (`schedul`.`sche_id` = `searchview`.`sche_id`) and (`booking`.`bording_stopage_id` = `stopage`.`stopage_id`) and (`booking`.`user_id` = `user`.`user_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `toloc`
--

/*!50001 DROP TABLE IF EXISTS `toloc`*/;
/*!50001 DROP VIEW IF EXISTS `toloc`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `toloc` AS select `schedul`.`sche_id` AS `sche_id`,`location`.`loc_name` AS `loc_name` from (((`location` join `route`) join `bus`) join `schedul`) where ((`location`.`loc_id` = `route`.`to_loc_id`) and (`route`.`route_id` = `bus`.`route_id`) and (`bus`.`bus_id` = `schedul`.`bus_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totalseat`
--

/*!50001 DROP TABLE IF EXISTS `totalseat`*/;
/*!50001 DROP VIEW IF EXISTS `totalseat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totalseat` AS select `a`.`sche_id` AS `sche_id`,`b`.`total_seat` AS `total_seat` from (`schedul` `a` join `bus` `b`) where (`a`.`bus_id` = `b`.`bus_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-02  8:01:24

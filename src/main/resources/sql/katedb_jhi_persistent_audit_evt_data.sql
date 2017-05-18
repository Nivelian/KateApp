-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: katedb
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `jhi_persistent_audit_evt_data`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_evt_data`
--

LOCK TABLES `jhi_persistent_audit_evt_data` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_evt_data` VALUES (1,'remoteAddress','0:0:0:0:0:0:0:1'),(2,'remoteAddress','0:0:0:0:0:0:0:1'),(3,'remoteAddress','0:0:0:0:0:0:0:1'),(4,'remoteAddress','127.0.0.1'),(5,'remoteAddress','127.0.0.1'),(6,'message','Bad credentials'),(6,'remoteAddress','127.0.0.1'),(6,'type','org.springframework.security.authentication.BadCredentialsException'),(7,'message','Bad credentials'),(7,'remoteAddress','127.0.0.1'),(7,'type','org.springframework.security.authentication.BadCredentialsException'),(8,'remoteAddress','127.0.0.1'),(9,'message','Bad credentials'),(9,'remoteAddress','127.0.0.1'),(9,'type','org.springframework.security.authentication.BadCredentialsException'),(10,'message','Bad credentials'),(10,'remoteAddress','127.0.0.1'),(10,'type','org.springframework.security.authentication.BadCredentialsException'),(11,'message','Bad credentials'),(11,'remoteAddress','127.0.0.1'),(11,'type','org.springframework.security.authentication.BadCredentialsException'),(12,'message','Bad credentials'),(12,'remoteAddress','127.0.0.1'),(12,'type','org.springframework.security.authentication.BadCredentialsException'),(13,'remoteAddress','127.0.0.1'),(14,'remoteAddress','127.0.0.1'),(15,'remoteAddress','127.0.0.1'),(16,'remoteAddress','127.0.0.1'),(17,'remoteAddress','127.0.0.1'),(18,'remoteAddress','127.0.0.1'),(19,'remoteAddress','127.0.0.1'),(20,'remoteAddress','127.0.0.1'),(21,'remoteAddress','127.0.0.1'),(22,'remoteAddress','127.0.0.1'),(23,'remoteAddress','127.0.0.1'),(24,'remoteAddress','127.0.0.1'),(25,'remoteAddress','127.0.0.1'),(26,'remoteAddress','127.0.0.1'),(27,'remoteAddress','127.0.0.1'),(28,'remoteAddress','127.0.0.1'),(29,'remoteAddress','127.0.0.1'),(30,'remoteAddress','0:0:0:0:0:0:0:1'),(31,'remoteAddress','127.0.0.1'),(32,'remoteAddress','127.0.0.1'),(33,'remoteAddress','0:0:0:0:0:0:0:1'),(34,'remoteAddress','172.20.4.57'),(35,'remoteAddress','172.20.4.57'),(35,'sessionId','GlYU8CzZ-Jz8ul-MeaMU2yweyB8_9Fqys3y2hbWX'),(36,'remoteAddress','172.20.4.57'),(37,'remoteAddress','172.20.4.57'),(37,'sessionId','v7caI1GbygFWuh-glxotTMOXN0HeBB3ZgEUDlct6'),(38,'remoteAddress','0:0:0:0:0:0:0:1'),(39,'remoteAddress','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18 14:01:06

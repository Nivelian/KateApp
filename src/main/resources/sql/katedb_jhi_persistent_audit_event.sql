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
-- Table structure for table `jhi_persistent_audit_event`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_event`
--

LOCK TABLES `jhi_persistent_audit_event` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_event` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_event` VALUES (1,'admin','2017-05-10 21:33:54','AUTHENTICATION_SUCCESS'),(2,'admin','2017-05-10 21:36:38','AUTHENTICATION_SUCCESS'),(3,'admin','2017-05-10 21:40:50','AUTHENTICATION_SUCCESS'),(4,'admin','2017-05-11 06:34:11','AUTHENTICATION_SUCCESS'),(5,'admin','2017-05-11 06:41:30','AUTHENTICATION_SUCCESS'),(6,'nivelian','2017-05-11 07:15:44','AUTHENTICATION_FAILURE'),(7,'nivelian','2017-05-11 07:15:52','AUTHENTICATION_FAILURE'),(8,'admin','2017-05-11 07:16:06','AUTHENTICATION_SUCCESS'),(9,'nivelian','2017-05-11 07:19:15','AUTHENTICATION_FAILURE'),(10,'nivelian','2017-05-11 07:19:21','AUTHENTICATION_FAILURE'),(11,'nivelian','2017-05-11 07:19:24','AUTHENTICATION_FAILURE'),(12,'nivelian','2017-05-11 07:19:29','AUTHENTICATION_FAILURE'),(13,'user','2017-05-11 07:19:35','AUTHENTICATION_SUCCESS'),(14,'admin','2017-05-11 07:21:16','AUTHENTICATION_SUCCESS'),(15,'admin','2017-05-11 07:24:23','AUTHENTICATION_SUCCESS'),(16,'admin','2017-05-11 07:24:45','AUTHENTICATION_SUCCESS'),(17,'admin','2017-05-11 08:41:23','AUTHENTICATION_SUCCESS'),(18,'admin','2017-05-11 08:44:29','AUTHENTICATION_SUCCESS'),(19,'admin','2017-05-11 08:49:06','AUTHENTICATION_SUCCESS'),(20,'user','2017-05-11 08:52:04','AUTHENTICATION_SUCCESS'),(21,'admin','2017-05-11 08:52:17','AUTHENTICATION_SUCCESS'),(22,'admin','2017-05-11 09:39:59','AUTHENTICATION_SUCCESS'),(23,'admin','2017-05-11 09:46:17','AUTHENTICATION_SUCCESS'),(24,'admin','2017-05-12 19:27:04','AUTHENTICATION_SUCCESS'),(25,'admin','2017-05-13 06:20:01','AUTHENTICATION_SUCCESS'),(26,'admin','2017-05-13 06:20:01','AUTHENTICATION_SUCCESS'),(27,'nivelian','2017-05-13 07:18:15','AUTHENTICATION_SUCCESS'),(28,'nivelian','2017-05-13 07:18:45','AUTHENTICATION_SUCCESS'),(29,'admin','2017-05-13 07:35:38','AUTHENTICATION_SUCCESS'),(30,'admin','2017-05-15 18:35:22','AUTHENTICATION_SUCCESS'),(31,'admin','2017-05-16 18:04:59','AUTHENTICATION_SUCCESS'),(32,'admin','2017-05-16 18:21:44','AUTHENTICATION_SUCCESS'),(33,'admin','2017-05-17 07:59:52','AUTHENTICATION_SUCCESS'),(34,'nivelian','2017-05-17 08:16:22','AUTHENTICATION_SUCCESS'),(35,'nivelian','2017-05-17 13:29:57','AUTHENTICATION_SUCCESS'),(36,'nivelian','2017-05-17 13:42:37','AUTHENTICATION_SUCCESS'),(37,'nivelian','2017-05-18 10:49:36','AUTHENTICATION_SUCCESS'),(38,'admin','2017-05-18 10:54:49','AUTHENTICATION_SUCCESS'),(39,'admin','2017-05-18 10:56:18','AUTHENTICATION_SUCCESS');
/*!40000 ALTER TABLE `jhi_persistent_audit_event` ENABLE KEYS */;
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
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: my_bank_app
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `password_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
INSERT INTO `password` VALUES (32,49,'12345',NULL),(33,50,'nishtha',NULL),(34,51,'urvashi',NULL),(35,52,'jatin',NULL),(36,53,'dsfdfv',NULL),(37,56,'ghngfmmjjhm',NULL),(38,58,'feg',NULL),(39,61,'sdcsc',NULL),(40,62,'vfdvfgb',NULL),(41,63,'vcxvzdfv',NULL),(42,65,'fgbfb',NULL),(43,66,'vdfdv',NULL),(44,72,'vdvd',NULL),(45,74,'dcvafdavdfv',NULL),(46,75,'admin',NULL),(47,76,'sonam',NULL),(48,77,NULL,NULL),(49,84,NULL,NULL),(50,86,NULL,NULL),(51,87,'3563',NULL),(52,88,NULL,NULL),(53,89,NULL,NULL),(54,109,NULL,NULL),(55,117,NULL,NULL),(56,119,NULL,NULL),(57,121,NULL,NULL),(58,122,NULL,NULL),(59,124,'shikha',NULL),(60,126,'ddd',NULL),(61,127,'ddd',NULL),(62,128,'ggg',NULL),(63,129,'dd',NULL),(64,130,'eee',NULL),(65,131,'aaa',NULL),(66,138,'rt',NULL),(67,139,'sssttt',NULL),(68,140,'111',NULL),(69,141,'ddd',NULL),(70,142,'rrr',NULL),(71,143,'shalu',NULL);
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-14 16:09:48

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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `transactiontypeid` int DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `action_type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `action_type` (`action_type`),
  KEY `transactiontypeid_idx` (`transactiontypeid`),
  CONSTRAINT `transaction_action` FOREIGN KEY (`action_type`) REFERENCES `transaction_action` (`id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `transactiontypeid` FOREIGN KEY (`transactiontypeid`) REFERENCES `transaction_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (35,50,7000,1,'2021-10-02','withdraw from my account',2),(36,50,7000,1,'2021-10-02','withdraw from my account',1),(49,49,4565,1,'2021-10-04','fgbfb',1),(50,50,7000,1,'2021-10-02','withdraw from my account',1),(51,NULL,7000,1,'2021-10-03','withdraw from my account',2),(52,52,9000,1,'2021-10-03','deposite in my account',1),(56,56,9000,1,'2021-10-03','deposite in my account',1),(66,66,9000,1,'2021-10-03','deposite in my account',1),(72,72,10000,1,'2021-10-04','deposite in my account',1),(74,74,4000,1,'2021-10-03','for party',1),(75,75,600,1,'2021-10-03','add',1),(76,66,7000,1,'2021-10-03','withdraw from my account',2),(77,66,7000,1,'2021-10-03','withdraw from my account',2),(78,66,4000,1,'2021-10-03','for party',2),(79,66,7000,1,'2021-10-04','withdraw from my account',2),(80,75,7000,1,'2021-10-04','withdraw from my account',2),(81,75,7000,1,'2021-10-04','withdraw from my account',2),(82,75,7000,2,'2021-10-04','withdraw from my account',2),(83,66,10000,1,'2021-10-04','deposite in my account',1),(84,66,4565,1,'2021-10-04','fgbfb',1),(85,49,4000,1,'2021-10-04','fdgvgcfhb',1),(86,49,4000,2,'2021-10-04','bvg gvnv gn gv',2),(87,49,4000,2,'2021-10-04','fvdxv',2),(88,NULL,600,1,'2021-10-07',' b,njkjnkjnk,nj',1),(89,75,7000,2,'2021-10-07','withdraw from my account',2),(90,NULL,600,1,'2021-10-07','vfzv',1),(91,75,7000,2,'2021-10-07','withdraw from my account',2),(92,75,7000,2,'2021-10-07','withdraw from my account',2),(93,49,4000,2,'2021-10-07','dd,dc ,sdv ',2),(94,NULL,600,1,'2021-10-07','dscdscd',1),(95,49,5000,2,'2021-10-07','a.dcms>DM ',2),(96,75,7000,2,'2021-10-07','withdraw from my account',2),(97,75,7000,2,'2021-10-07','withdraw from my account',2),(98,49,5000,2,'2021-10-07','a.dcms>DM ',2),(99,49,4565,2,'2021-10-07','aks,jdzc,z',2),(100,49,600,2,'2021-10-07','ckjjndskjzn c',2),(101,49,600,2,'2021-10-07','abcdsc',2),(102,49,4,2,'2021-10-08','jugfjyuhj',2),(103,49,600,2,'2021-10-08',',sdsmnfks',2),(104,49,4000,2,'2021-10-08','lfvnk,nfd,',2),(105,49,4000,2,'2021-10-08','dkfjvk',2),(106,49,600,2,'2021-10-08','vdfvdggbfgbf',2),(107,NULL,7000,2,'2021-10-08','withdraw from my account',2),(108,49,500,2,'2021-10-08','sssssssssssssssssss',2),(109,49,4000,2,'2021-10-08','rrrrrrrrrrrrrrrr',2),(110,49,600,2,'2021-10-08','tttttttttttt',2),(111,49,400,2,'2021-10-08','fvfzvvvvv',2),(112,NULL,400,1,'2021-10-08','.emd.skf,',1),(113,NULL,7000,2,'2021-10-08','withdraw from my account',2),(114,NULL,7000,2,'2021-10-08','withdraw from my account',2),(115,66,10000,1,'2021-10-08','deposite in my account',1),(116,NULL,7000,2,'2021-10-08','withdraw from my account',2),(117,NULL,400,1,'2021-10-08','.emd.skf,',1),(118,49,500,2,'2021-10-08','dsn c,d',2),(119,NULL,7000,2,'2021-10-08','withdraw from my account',2),(120,NULL,7000,2,'2021-10-08','withdraw from my account',2),(121,NULL,7000,2,'2021-10-08','withdraw from my account',2),(122,NULL,7000,2,'2021-10-08','withdraw from my account',2),(123,49,4000,2,'2021-10-08','lsdfmklkfkld',2),(124,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(125,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(126,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(127,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(128,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(129,49,600,2,'2021-10-08','d,dsmv,dfvm,gb',2),(130,49,600,2,'2021-10-08','fbgfgnghn',2),(131,49,600,2,'2021-10-08','fbgfgnghn',2),(132,49,600,2,'2021-10-08','fbgfgnghn',2),(133,NULL,7000,2,'2021-10-08','withdraw from my account',2),(134,49,800,2,'2021-10-08','hckxcnc',2),(135,49,800,2,'2021-10-08','hjghjb',2),(136,49,800,2,'2021-10-08','hjghjb',2),(137,NULL,800,1,'2021-10-08','hvbnvn',1),(138,66,10000,1,'2021-10-08','deposite in my account',1),(139,NULL,800,1,'2021-10-08','hvbnvn',1),(140,49,800,2,'2021-10-08','dfbfgbfg',2),(141,49,11,2,'2021-10-08','jkh',2),(142,49,789,2,'2021-10-08','jhgf',2),(143,49,789,2,'2021-10-08','jhgf',2),(144,49,789,2,'2021-10-08','jhgf',2),(145,49,789,2,'2021-10-08','jhgf',2),(146,49,789,2,'2021-10-08','jhgf',2),(147,49,789,2,'2021-10-08','jhgf',2),(148,49,789,2,'2021-10-08','jhgf',2),(149,49,789,2,'2021-10-08','jhgf',2),(150,49,789,2,'2021-10-08','jhgf',2),(151,49,789,2,'2021-10-08','jhgf',2),(152,49,789,2,'2021-10-08','jhgf',2),(153,49,789,2,'2021-10-08','jhgf',2),(154,49,789,2,'2021-10-08','jhgf',2),(155,49,789,2,'2021-10-08','jhgf',2),(156,49,789,2,'2021-10-08','jhgf',2),(157,49,789,2,'2021-10-08','jhgf',2),(158,49,4000,2,'2021-10-08','lkdsnc,dv n,f',2),(159,49,4000,2,'2021-10-08','jmbn m',2),(160,49,600,2,'2021-10-08','samsnzxc ',2),(161,49,4000,1,'2021-10-08','ashgcnd',1),(162,49,500,1,'2021-10-08','nmn cxm ',1),(163,49,600,1,'2021-10-08','for',1),(164,49,600,2,'2021-10-08','werrt',2),(165,49,600,2,'2021-10-09','dfggfbhfmj',2),(166,49,4000,1,'2021-10-09','fbfdnghm',1),(167,49,700,1,'2021-10-10','rregb',1),(168,49,600,2,'2021-10-10','hgfj',2),(169,49,500,1,'2021-10-11','wdfgh',1),(170,49,400,1,'2021-10-11','wdfdghj',1),(171,49,300,1,'2021-10-11','dfgh',1),(172,49,300,2,'2021-10-11','ewfgh',2),(173,49,500,1,'2021-10-11','sdfghjkkjjhvc',1),(174,49,500,2,'2021-10-11','xcvhbjkljhgf',2),(175,49,30,1,'2021-10-11','cghjklkjb',1),(176,49,789,2,'2021-10-11','clcfhk',2),(177,49,600,1,'2021-10-11','dsfdgbhjm',1),(178,49,400,1,'2021-10-11','sdbvvdmnv ',1),(179,49,5000,2,'2021-10-11','sdfmngfdbv',2),(180,49,-300,2,'2021-10-11','dffghj',2),(181,49,500,2,'2021-10-12','sdfghjkj',2),(182,49,4000,1,'2021-10-12','asdfgnhmj',1),(183,49,66666,1,'2021-10-12','sdfghj',1),(184,49,500,1,'2021-10-12','asdfghj',1),(185,49,10000,1,'2021-10-12','deposite in my account',1),(186,49,10000,1,'2021-10-12','deposite in my account',1),(187,49,10000,1,'2021-10-12','deposite in my account',1),(188,49,10000,1,'2021-10-12','deposite in my account',1),(189,66,4555,1,'2021-10-12','ASDFGHKJHGF',1),(190,66,656567,1,'2021-10-12','sdfgh',1),(191,66,656567,1,'2021-10-12','sdfgh',1),(192,66,656567,1,'2021-10-12','sdfgh',1),(193,66,656567,1,'2021-10-12','sdfgh',1),(194,66,656567,1,'2021-10-12','sdfgh',1),(195,66,32456,1,'2021-10-12','wesdfghj',1),(196,49,600,1,'2021-10-12','weghj',1),(197,49,1000,1,'2021-10-13','sdsfghjk',1),(198,49,500,2,'2021-10-13','asdfgh',2),(199,49,3000,1,'2021-10-13','dfgh',1),(200,49,500,1,'2021-10-14','sdfghj',1),(201,49,56789,2,'2021-10-14','sdffnm,',2),(202,49,4000,1,'2021-10-14','rtyuyio',1),(203,49,500,2,'2021-10-14','fmgh',2),(204,49,900,1,'2021-10-14','sdfgh',1),(205,49,4000,1,'2021-10-20','sdsfgh,.',1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-20 10:44:46

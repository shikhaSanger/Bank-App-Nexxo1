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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `aadhar_no` varchar(30) NOT NULL,
  `status_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `mobile_no` varchar(13) DEFAULT NULL,
  `password_key` int DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `status_id` (`status_id`),
  KEY `role_id` (`role_id`),
  KEY `userfrn_idx` (`password_key`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role_type` (`id`),
  CONSTRAINT `userfrn` FOREIGN KEY (`password_key`) REFERENCES `password` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (49,'Shikha',NULL,'sanger705@gmail.com','372178339362',1,2,'2021-10-02','9456425633',NULL,'Dadri'),(50,'Nishtha',NULL,'nishtha@gmail.com','',1,2,'2021-10-02','',NULL,''),(51,'Urvashi',NULL,'urvashi@gmail.com','372178339364',1,2,'2021-10-02','5465676767',NULL,'Meerut'),(52,'Jatin','1999-05-02','jatin@gmail.com','372188339362',1,2,'2021-10-02','3456789023',NULL,'Noida'),(53,'',NULL,'','',1,2,'2021-10-02','',NULL,''),(56,'tynjyj',NULL,'sanger@gmail.com','23535gbfgf',1,2,'2021-10-02','',NULL,''),(58,'DFFDF',NULL,'shikha.sanger@nexxo.com','rgfrdsfg',1,2,'2021-10-02','fgfdggfg',NULL,'fsdff'),(61,'DFFDF','2021-09-29','gtdgh@gmail.om','32443464365',1,2,'2021-10-02','9456425633',NULL,'Delhi'),(62,'Shivank','2021-10-14','shivank@gmail.com','1234567',1,2,'2021-10-02','5465676767',NULL,'Delhi'),(63,'Shivank','2021-10-14','shivan@gmail.com','1234567',1,2,'2021-10-02','5465676767',NULL,'Delhi'),(65,'Shivank','2021-10-14','shivn@gmail.com','1234567',1,2,'2021-10-02','5465676767',NULL,'Delhi'),(66,'Shivank','2021-10-14','shivnd@gmail.com','1234567',1,2,'2021-10-02','5465676767',NULL,'Delhi'),(72,'dbgb',NULL,'prabhjot@gmail.ocm','12345673243',1,2,'2021-10-02','2343534',NULL,''),(74,'csdvdfv',NULL,'prabhjot@gmail.com','32153455',1,2,'2021-10-02','',NULL,''),(75,'Admin','2021-10-12','admin@gmail.com','12345678',1,1,'2021-10-02','9910149844',NULL,'Delhi'),(76,'Sonam','1994-08-08','sonam@gmail.com','4264676979808',1,2,'2021-10-04','9856787845',NULL,'Sikandrabad'),(77,NULL,'2021-09-29','pooja@gmail.com','243656576',1,2,'2021-10-08','9456425633',NULL,'Himachal'),(84,NULL,'2021-09-27','sanger708@gmail.com','71276372347',1,2,'2021-10-08','2834384',NULL,'sjmasbmd'),(86,NULL,'2021-09-29','sanger70@gmail.com','3444354',1,2,'2021-10-08','2323435',NULL,'ssdfdf'),(87,'ssshhhiii','1997-02-02','sangershia@gmail.com','2352',1,2,'2021-10-08','77949',NULL,'delhi'),(88,NULL,'2021-09-26','shikha@gmail.com','123234335',1,2,'2021-10-08','12132565747',NULL,'Delhi'),(89,'Rakhi','2021-08-31','rakhi@gmail.com','343454565757',1,2,'2021-10-08','3967565435',NULL,'Goa'),(109,'Sneha','2021-09-28','sneha@gmail.com','87483757845',1,2,'2021-10-08','985689856',NULL,'Ghaziabad'),(117,'Shikha','2021-09-28','sanger710@gmail.com','2343546',1,2,'2021-10-08','232443234',NULL,'safds1232453'),(119,'Shikha','2021-09-06','sanger712@gmail.com','32425436',1,2,'2021-10-08','235646476',NULL,'fbghg'),(121,'Shikha','2021-10-12','sanger713@gmail.com','324235365',1,2,'2021-10-08','234355436',NULL,'dfsdfvgfdg'),(122,'Shikha','2021-09-26','sanger105@gmail.com','2435467678',1,2,'2021-10-08','24565476',NULL,'Noida'),(124,'Shikha','2021-10-06','sanger745@gmail.com','24345647787',1,2,'2021-10-08','324355645676',NULL,'Gr Noida'),(126,'Shikha','2021-10-12','urvashi89@gmail.com','34564',1,2,'2021-10-08','45676876798',NULL,'fghgfh22345'),(127,'DFFDF','2021-10-13','sanger111@gmail.com','2345643674',1,2,'2021-10-08','245365676',NULL,'ddfvbgfhg'),(128,'cfvbgfxnb','2021-10-26','admin56@gmail.com','2343565758',1,2,'2021-10-08','435567678',NULL,'sdafgf'),(129,'nishtha','2021-10-28','nishtha2345@gmail.com','14456768769',1,2,'2021-10-08','345677877',NULL,'ghjh'),(130,'urvashi','2021-10-21','urvashi1234@gmail.com','587898978',1,2,'2021-10-08','2435656768',NULL,'fjkfjgnfdk'),(131,'Shikha','2021-10-20','sanger666','6546578769',1,2,'2021-10-08','54758678658',NULL,'hbnvvjh'),(138,'Aakansha','2021-09-26','akansha@gmail.com','987654323456',1,2,'2021-10-10','9876543985',NULL,'gh.fghjk'),(139,'Preeti','2021-10-01','pre@gmail.com','213456786789',1,2,'2021-10-10','4563489654',NULL,'wdfdgb'),(140,'Preeti','2021-09-27','preeti@yahoo.com','213456574567',1,2,'2021-10-11','9910149844',NULL,'sadfgh'),(141,'shikha','2021-09-27','dhejf@gmail.com','223456788765',1,2,'2021-10-11','4567895678',NULL,'sdfghn'),(142,'Nishtha','2021-09-28','sanger0005@gmail.com','234567234567',1,2,'2021-10-14','9456425633',NULL,'Zxcxvcbn'),(143,'Shalu','2021-07-12','shalu@gmail.com','984567345676',1,2,'2021-10-14','9898456789',NULL,'vbnmbvcxz@*5@#');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-14 16:09:49

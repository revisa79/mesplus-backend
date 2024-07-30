-- MySQL dump 10.13  Distrib 8.3.0, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatmessage` (
  `id` int NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
INSERT INTO `chatmessage` VALUES (1,'Hey','manager',0),(2,'I\'m the manager here!','manager',0),(3,'The quick brown fox jumps over the lazy dog near the bank of the river.','manager',0),(4,'Hello','manager',0),(5,'The quick brown fox','manager',0),(6,'Yellow','manager',0),(7,'dfdfd','manager',0),(8,'Added new message','manager',0),(9,'Latest here','manager',0),(10,'Hi, user here. How are you guys?','user',0),(11,'MOre chat','manager',0),(12,'Can we move smoothly?','manager',0),(13,'Hello again','manager',0),(14,'fdsfdsf','manager',0),(15,'The quick brown fox jumps over the lazy dog near the bank of the river bank. ','user',0),(16,'Manager','manager',0),(17,'I\'m working on #12345 with Joel. We are currently replacing the ARM.','user',0),(18,'Hello, manager!','user',0),(19,'Hello again','user',0),(20,'Can you see me?','user',0),(21,'fdsfd','manager',0),(22,'fdfdfedfde','manager',0),(23,'The quick','manager',0),(24,'fdsfds','manager',0),(25,'fdsfdedsfeadfd','manager',0),(26,'dsfdsa','manager',0),(27,'fdsafdsa','manager',0),(28,'fdsfdsa','manager',0),(29,'fdsafds','manager',0),(30,'fdsafds','manager',0),(31,'fdsafdsa','manager',0),(32,'fdsafdsa','manager',0),(33,'fdsafdsa','manager',0),(34,'fdsafdsa','manager',0),(35,'fdsafdsaf','manager',0),(36,'fdsafdsa','manager',0),(37,'fdsafdsa','manager',0),(38,'fdsafdsa','manager',0),(39,'fdsfads','manager',0),(40,'fdsafds','manager',0),(41,'fdsfds','manager',0),(42,'fdsafds','manager',0),(43,'The quick','manager',0),(44,'The quickest','manager',0),(45,'fdsfdsa','manager',0),(46,'fsdfds','manager',0),(47,'fdsfd','manager',0),(48,'fdsfdsa','manager',0),(49,'fdsfd','manager',0),(50,'vcxvzvc','manager',0),(51,'fdsafdsa','manager',0),(52,'fdsfdsf','manager',0),(53,'fdsfd','manager',0),(54,'fdsfdsfd','manager',0),(55,'dsaDSA','manager',0),(56,'fdfd','manager',0),(57,'fdsfds','manager',0),(58,'fdsfdsfd','manager',0),(59,'Hello','manager',0),(60,'fdsfad','user',0),(61,'fdsfde','user',0),(62,'fdsafd','user',0),(63,'fdsafdsa','user',0),(64,'fdsafdsafds','user',0),(65,'fdsafdsafda','user',0),(66,'fdsafdsafds','user',0),(67,'fdsafdsafds','user',0),(68,'fdsafds','user',0),(69,'fdsafdsafds','user',0),(70,'fdsafdsafefd','user',0),(71,'fdfdaf','user',0),(72,'The quiick brown fox jumps over the lazy dog near the bank of the river','user',0),(73,'fdsfdsa','user',0),(74,'fdsfdsafd','user',0),(75,'fdsafdsa','user',0),(76,'fdsfdsa','user',0),(77,'fdsafdsafd','user',0),(78,'fdsafdsafedafdef','user',0),(79,'dfdafd','user',0),(80,'fdsfd','user',0),(81,'fdsfd','user',0),(82,'fdsfd','user',0),(83,'fdfd','user',0),(84,'fdsafd','user',0),(85,'fdfdwefe','user',0),(86,'The quick brown fox jumps over the lasy dog near the bank of the river bank inside the mall of asia. Laravel store at the busy BGC. 3,333 and 1/3. In process of gathering data. Eamil sent to SAM. Additional ECN is required. ','manager',0),(87,'b','manager',0),(88,'hi','manager',0),(89,'hi','manager',0),(90,'fdsafdsafds','manager',0),(91,'fdsafdsa','manager',0),(92,'The quick','manager',0),(93,'Brown','manager',0),(94,'Fox','manager',0),(95,'Jumps','manager',0),(96,'Over the lazy','manager',0),(97,'Dog','manager',0),(98,'Helo','user',0),(99,'The quick','user',0),(100,'brown','user',0),(101,'fox','user',0),(102,'jumps','user',0),(103,'over the lazy','user',0),(104,'Dog','user',0),(105,'near the bank of the river','user',0),(106,'The quick brown fox jumps over the lasy dog near the bank of the river bank inside the mall of asia. Laravel store at the busy BGC. 3,333 and 1/3. In process of gathering data. Eamil sent to SAM. Additional ECN is required.','user',0),(107,'Hello','user',0),(108,'hi','user',0),(109,'job','manager',0),(110,'david bazucki','manager',0),(111,'stevejobs','manager',0),(112,'Elon musk','user',0),(113,'bill gates','manager',0),(114,'david steve elon bill bazucki jobs musk gates','manager',0),(115,'xcxcxcxcx','manager',0),(116,'no text!?!?!?!?!?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????????//////?///////////////////////////////??????????????????????????????????????????','manager',0),(117,'hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi hi ','manager',0),(118,'hi hi hi hi hi vvhi hi hi hi hi hi hi hi hi vvvvvvvvvvvvvvvvvhi hi vvvvvvvvvvvhi hi hi hi ','manager',0),(121,'sus and','user',0),(122,'788787878787877887877878877887788778788787878778yyuyuy','manager',0);
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (123);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `active` tinyint(1) DEFAULT '1',
  `roles` varchar(255) NOT NULL DEFAULT '',
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'pass',1,'ROLE_ADMIN','user'),(10,'pass',1,'ROLE_ADMIN','manager');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-30 10:12:30

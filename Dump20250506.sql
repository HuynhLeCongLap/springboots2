-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.4.3

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
-- Table structure for table `follows`
--

DROP TABLE IF EXISTS `follows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follows` (
  `following_user_id` int NOT NULL,
  `followed_user_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`following_user_id`,`followed_user_id`),
  KEY `followed_user_id` (`followed_user_id`),
  CONSTRAINT `follows_ibfk_1` FOREIGN KEY (`following_user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `follows_ibfk_2` FOREIGN KEY (`followed_user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follows`
--

LOCK TABLES `follows` WRITE;
/*!40000 ALTER TABLE `follows` DISABLE KEYS */;
INSERT INTO `follows` VALUES (1,2,'2025-03-31 15:43:51');
/*!40000 ALTER TABLE `follows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `body` text,
  `user_id` int DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'1','1',1,'active','2025-03-31 16:27:18',''),(2,'1','1',1,'active','2025-03-31 16:27:20',''),(3,'1','1',1,'active','2025-03-31 16:27:21',''),(4,'1','1',1,'active','2025-03-31 16:27:21',''),(5,'1','1',1,'active','2025-03-31 16:27:22',''),(6,'1','1',1,'active','2025-03-31 16:30:14',''),(7,'1','1',1,'active','2025-03-31 16:49:34',''),(8,'1','1',1,'active','2025-03-31 16:55:09',''),(9,'1','1',1,'active','2025-03-31 16:55:57',''),(10,'1','1',1,'active','2025-03-31 17:02:02',''),(11,'1','1',1,'active','2025-04-01 01:15:38',''),(12,'1','1',1,'active','2025-04-01 01:17:32',''),(13,'adsad',NULL,2,'DRAFT','2025-04-01 02:21:38','adads'),(14,'baa',NULL,2,'DRAFT','2025-04-01 02:21:47','bbb'),(15,'bai',NULL,2,'DRAFT','2025-04-01 02:24:28','11111'),(16,'1',NULL,2,'DRAFT','2025-04-01 03:02:33','12'),(17,'aaaa',NULL,2,'DRAFT','2025-04-01 03:04:42','1\r\n'),(18,'aaaaaaaaa',NULL,2,'DRAFT','2025-04-01 03:15:52','aaa'),(21,'adada',NULL,2,'DRAFT','2025-04-01 03:30:38','adasdas'),(23,'ạdhasdjh',NULL,2,'DRAFT','2025-04-02 02:15:25','dsabdgasd'),(25,'aaaa',NULL,2,'DRAFT','2025-04-02 15:46:21','111111'),(26,'1',NULL,2,'DRAFT','2025-04-06 15:17:02','1\r\n'),(27,'aa',NULL,2,'DRAFT','2025-04-08 08:05:39','aaa'),(28,'zzz',NULL,2,'DRAFT','2025-04-08 08:08:25','zzz'),(29,'aa',NULL,2,'DRAFT','2025-04-08 08:09:52','aaa'),(30,'b',NULL,2,'DRAFT','2025-04-08 08:54:09','b'),(32,'meo',NULL,2,'DRAFT','2025-05-06 15:11:21','meo'),(33,'meo',NULL,2,'DRAFT','2025-05-06 15:11:29','meo');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1','1','ADMIN','2025-02-24 15:18:06',NULL),(2,'admin','$2a$10$ChE3oJpHvdHmZWJ.vU4o3e4irXnM.GPb1SQIFd9ONqGizLqBlo3bK','ADMIN','2025-03-31 13:43:25',NULL),(4,'admin1','$2a$10$TjZ5....','ROLE_USER','2025-03-31 15:26:12',NULL),(5,'testuser','$2a$10$kX1lZ3I5R9T...','USER','2025-03-31 15:40:26',NULL),(7,'admin2','$2a$10$...','ADMIN','2025-03-31 15:43:30',NULL),(8,'admin3','$2a$10$ChE3oJpHvdHmZWJ.vU4o3e4irXnM.GPb1SQIFd9ONqGizLqBlo3bK','ADMIN','2025-03-31 15:54:08',NULL),(10,'123','123','user','2025-04-02 14:14:08',NULL),(11,'t','t','user','2025-04-02 16:04:14',NULL),(12,'abc','111','user','2025-04-02 17:30:32',NULL),(13,'lapngu','lapngu','user','2025-05-06 13:46:54',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-06 22:37:14

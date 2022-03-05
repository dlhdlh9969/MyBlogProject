-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 58.239.58.243    Database: java404_kdh_2_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `blogvalue`
--

DROP TABLE IF EXISTS `blogvalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogvalue` (
  `user_id` varchar(45) NOT NULL,
  `blog_name` varchar(45) DEFAULT NULL,
  `age_yn` char(1) DEFAULT 'Y',
  `phone_yn` char(1) DEFAULT 'Y',
  `email_yn` char(1) DEFAULT 'Y',
  `board_color` varchar(45) DEFAULT 'black',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogvalue`
--

LOCK TABLES `blogvalue` WRITE;
/*!40000 ALTER TABLE `blogvalue` DISABLE KEYS */;
INSERT INTO `blogvalue` VALUES ('05','테스트05 님의 블로그 입니다.','Y','Y','Y','black'),('jin_test01','진빼로 님의 블로그 입니다.','Y','Y','Y','black'),('jin_test02','진니달리 님의 블로그 입니다.','Y','Y','Y','black'),('jin_test03','진테스트 님의 블로그 입니다.','Y','Y','Y','black'),('test01','아싸라비요','Y','N','Y','#fa12fa'),('test02','테스트02 님의 블로그 입니다.','Y','Y','Y','#3cb371'),('test03','테스트03 님의 블로그 입니다♡♡♡♡♡','N','N','N','#f80000'),('test06','테스트06 님의 블로그 입니다.','Y','Y','Y','black');
/*!40000 ALTER TABLE `blogvalue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28  2:31:10

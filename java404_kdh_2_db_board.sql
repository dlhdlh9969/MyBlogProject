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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `contents` text,
  `created_dt` datetime DEFAULT NULL,
  `updated_dt` datetime DEFAULT NULL,
  `board_div` char(1) DEFAULT NULL,
  `board_id` varchar(45) DEFAULT NULL,
  `hit_cnt` int DEFAULT NULL,
  `deleted_yn` char(1) DEFAULT 'N',
  `deleted_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (115,'jin_test02','테스트를 하겠습니다.','오우 이럴수가 이게 뭐지요. 아 잠이온다. 출근하기 싫다.\r\n내일은 월요일 일주일만 일하면 또 쉰다.\r\n흠흠흠흠흠\r\n오늘 점심은 그냥 이대로 패스하면 되는걸까.\r\n배가 너무 부르는구만.\r\n','2022-01-23 11:55:28',NULL,'B',NULL,NULL,'N',NULL),(116,'jin_test02',NULL,'안녕하심니까','2022-01-23 11:55:42',NULL,'G','jin_test01',NULL,'N',NULL),(117,'jin_test02',NULL,'ㅋㅋㅋㅋㅋㅋㅋㅋㅋ','2022-01-23 11:55:46',NULL,'G','jin_test01',NULL,'N',NULL),(118,'jin_test02',NULL,'흠.. 이상한데요?','2022-01-23 11:55:50',NULL,'G','jin_test01',NULL,'N',NULL),(119,'jin_test01',NULL,'dlglglgl\'glgl이히히히히히힣 이럴수가','2022-01-23 11:56:29',NULL,'G','jin_test02',NULL,'Y','2022-01-23 11:56:34'),(120,'jin_test01',NULL,'훔허ㅑㅐ저햐ㅓ흐흠흐므흫흐흐흐흐흐흠 왼쪽에 있는거 끄라던데','2022-01-23 11:56:46',NULL,'G','jin_test02',NULL,'N',NULL),(121,'jin_test03',NULL,'안녕하세요?','2022-01-23 11:57:31',NULL,'G','jin_test02',NULL,'N',NULL),(122,'jin_test02','으하하하하ㅏㅏㅏㅏ','게임을 그만 해야 되는데 왜이리 지ㅐ미있니?','2022-01-23 11:58:29',NULL,'B',NULL,NULL,'N',NULL),(123,'jin_test01','테스트 중입니다.222','이거 커서 선택하면 바로ㅠ 한글로 해주면 좋겠다. 한영키 매번 바꿀라니 겁나 귀찮네','2022-01-23 11:59:34',NULL,'B',NULL,NULL,'N',NULL),(124,'jin_test01','음? 어ㅏ닌가 이번에도 되네.111','아... 뭔지 알겠당////\r\n수ㅡ정도 된다\r\n\r\n아재요 목록 버튼이 안되요.!!!!!!!!!!!!!\r\n\r\n\r\n수정 후 확인 누르고 나서 목록이 안되요!\r\n\r\n버근가여!\r\n히히히히히히히힠','2022-01-23 11:59:56',NULL,'B',NULL,NULL,'N',NULL),(125,'jin_test01','ㅇㅇㅇㅇㅇ','배불러 잠와 낮잠 ㄱㄱ','2022-01-23 12:00:08',NULL,'B',NULL,NULL,'Y','2022-01-23 12:02:03'),(126,'jin_test01',NULL,'닥쳐','2022-01-23 12:00:16',NULL,'G','jin_test01',NULL,'N',NULL),(127,'jin_test01',NULL,'1','2022-01-23 12:00:24',NULL,'G','jin_test01',NULL,'N',NULL),(128,'jin_test01',NULL,'2','2022-01-23 12:00:26',NULL,'G','jin_test01',NULL,'N',NULL),(129,'jin_test01',NULL,'3','2022-01-23 12:00:28',NULL,'G','jin_test01',NULL,'N',NULL),(130,'jin_test01',NULL,'4','2022-01-23 12:00:30',NULL,'G','jin_test01',NULL,'N',NULL),(131,'jin_test01',NULL,'5','2022-01-23 12:00:34',NULL,'G','jin_test01',NULL,'N',NULL),(132,'jin_test01',NULL,'이거 페이지 어디까지 가는거졍?','2022-01-23 12:00:40',NULL,'G','jin_test01',NULL,'N',NULL),(133,'jin_test01',NULL,'1','2022-01-23 12:00:43',NULL,'G','jin_test01',NULL,'N',NULL),(134,'jin_test01',NULL,'2','2022-01-23 12:00:45',NULL,'G','jin_test01',NULL,'N',NULL),(135,'jin_test01',NULL,'3','2022-01-23 12:00:47',NULL,'G','jin_test01',NULL,'N',NULL),(136,'jin_test01',NULL,'4','2022-01-23 12:00:48',NULL,'G','jin_test01',NULL,'N',NULL),(137,'jin_test01',NULL,'올 기능 되?','2022-01-23 12:00:56',NULL,'G','jin_test01',NULL,'Y','2022-01-23 12:00:59'),(138,'jin_test01',NULL,'올 기능 되네??','2022-01-23 12:01:04',NULL,'G','jin_test01',NULL,'N',NULL),(139,'test01','ssf','sdfsdfd','2022-01-24 03:53:16',NULL,'B',NULL,NULL,'N',NULL),(140,'test02','sdfs','dfsdfsdf','2022-01-24 17:27:39',NULL,'B',NULL,NULL,'N',NULL),(141,'test01',NULL,'sdfsdfsdfsdf','2022-01-24 17:58:52',NULL,'G','test03',NULL,'N',NULL),(142,'test06',NULL,'sddsf','2022-01-25 15:39:07',NULL,'G','test06',NULL,'N',NULL),(143,'test06',NULL,'sdf','2022-01-25 15:39:10',NULL,'G','test06',NULL,'N',NULL),(144,'test06',NULL,'sdf','2022-01-25 15:39:11',NULL,'G','test06',NULL,'N',NULL),(145,'test06',NULL,'12','2022-01-25 15:39:16',NULL,'G','test06',NULL,'N',NULL),(146,'test06',NULL,'23','2022-01-25 15:39:17',NULL,'G','test06',NULL,'N',NULL),(147,'test06',NULL,'45','2022-01-25 15:39:18',NULL,'G','test06',NULL,'N',NULL),(148,'test06',NULL,'56','2022-01-25 15:39:20',NULL,'G','test06',NULL,'N',NULL),(149,'test06',NULL,'67','2022-01-25 15:39:22',NULL,'G','test06',NULL,'N',NULL),(150,'test06',NULL,'78','2022-01-25 15:39:23',NULL,'G','test06',NULL,'N',NULL),(151,'test06',NULL,'89','2022-01-25 15:39:25',NULL,'G','test06',NULL,'N',NULL),(152,'test06',NULL,'89','2022-01-25 15:39:26',NULL,'G','test06',NULL,'N',NULL),(153,'test06',NULL,'67','2022-01-25 15:39:28',NULL,'G','test06',NULL,'N',NULL),(154,'test01',NULL,'12','2022-01-25 15:39:54',NULL,'G','test06',NULL,'N',NULL),(155,'test03','테스트 첫 번째 글 작성','Test Good!','2022-01-28 01:44:57',NULL,'B',NULL,NULL,'N',NULL),(156,'test02',NULL,'테스트1','2022-01-28 01:55:33',NULL,'G','test03',NULL,'N',NULL),(157,'test02',NULL,'테스트2','2022-01-28 01:55:35',NULL,'G','test03',NULL,'N',NULL),(158,'test02',NULL,'테스트3','2022-01-28 01:55:38',NULL,'G','test03',NULL,'N',NULL);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28  2:31:09

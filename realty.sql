-- MySQL dump 10.15  Distrib 10.0.34-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: realty
-- ------------------------------------------------------
-- Server version	10.0.34-MariaDB-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follow` (
  `user_openid` varchar(100) NOT NULL,
  `project_id` varchar(45) NOT NULL,
  `follow_id` varchar(45) NOT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`follow_id`),
  KEY `fk_user_has_project_project1_idx` (`project_id`),
  KEY `fk_user_has_project_user_idx` (`user_openid`),
  CONSTRAINT `fk_user_has_project_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_project_user` FOREIGN KEY (`user_openid`) REFERENCES `user` (`user_openid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house_type`
--

DROP TABLE IF EXISTS `house_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house_type` (
  `type_id` varchar(45) NOT NULL,
  `project_id` varchar(45) NOT NULL,
  `price` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `discount` varchar(45) DEFAULT NULL,
  `orientation` varchar(45) DEFAULT NULL,
  `decoration` varchar(45) DEFAULT NULL,
  `reason` text,
  `telephone` varchar(45) DEFAULT NULL,
  `tags` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `fk_house_type_project1_idx` (`project_id`),
  CONSTRAINT `fk_house_type_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house_type`
--

LOCK TABLES `house_type` WRITE;
/*!40000 ALTER TABLE `house_type` DISABLE KEYS */;
INSERT INTO `house_type` VALUES ('6d103531-866b-4403-b48e-e5de6bc5091f','893dee4e-157f-4bf8-98bf-56632e70e262','20000/平米','云南大学呈贡校区A512',NULL,NULL,'南向','装修_w2',NULL,NULL,'安静，风景美2');
/*!40000 ALTER TABLE `house_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house_type_image`
--

DROP TABLE IF EXISTS `house_type_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house_type_image` (
  `image_id` varchar(45) NOT NULL,
  `filepath` varchar(100) NOT NULL,
  `house_type_id` varchar(45) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `fk_image_house_type1_idx` (`house_type_id`),
  CONSTRAINT `fk_image_house_type1` FOREIGN KEY (`house_type_id`) REFERENCES `house_type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house_type_image`
--

LOCK TABLES `house_type_image` WRITE;
/*!40000 ALTER TABLE `house_type_image` DISABLE KEYS */;
INSERT INTO `house_type_image` VALUES ('acbe6569-00ca-442e-b50e-cbab4756f2d1','/var/www/html/download/realty/house_type/686ea60d0ef341eab96cc1621f7b5c69.png','6d103531-866b-4403-b48e-e5de6bc5091f');
/*!40000 ALTER TABLE `house_type_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `manager_name` varchar(45) NOT NULL,
  `manager_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`manager_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('root','123');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `message_id` varchar(45) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `project_id` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `call` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `fk_message_project1_idx` (`project_id`),
  CONSTRAINT `fk_message_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES ('02eb2c94-d4a1-42ee-861a-bb0d2da4f8fb','first message',1,'2018-07-11 14:13:35','893dee4e-157f-4bf8-98bf-56632e70e262','15887017245','Mr Zheng',NULL),('51943e14-f015-4b82-a921-df323160de46','third message',0,'2018-07-11 14:15:00','893dee4e-157f-4bf8-98bf-56632e70e262','15887017245','Mr Zheng',NULL),('c2a4d2b5-9c2f-4eba-bf78-40256ef9f5f8','3 message',0,'2018-07-11 16:53:57','893dee4e-157f-4bf8-98bf-56632e70e262','15887017245','Mr Zheng',NULL);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` varchar(45) NOT NULL COMMENT '\n',
  `deal_amount` int(11) DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `reason` text,
  `detail` text,
  `tags` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `telephone` varchar(45) DEFAULT NULL,
  `is_show` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('893dee4e-157f-4bf8-98bf-56632e70e262',NULL,'云南大学呈贡校区',NULL,NULL,NULL,NULL,NULL,NULL,'安静，风景美',NULL,NULL,0);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_image`
--

DROP TABLE IF EXISTS `project_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_image` (
  `image_id` varchar(45) NOT NULL,
  `filepath` varchar(100) NOT NULL,
  `project_id` varchar(45) NOT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`image_id`),
  KEY `fk_project_image_project1_idx` (`project_id`),
  CONSTRAINT `fk_project_image_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_image`
--

LOCK TABLES `project_image` WRITE;
/*!40000 ALTER TABLE `project_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_openid` varchar(100) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2018-07-16 23:17:22

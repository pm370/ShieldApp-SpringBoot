/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.22 : Database - shield_app_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shield_app_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `shield_app_db`;

/*Table structure for table `mission` */

CREATE TABLE `mission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `details` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `assign_to` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeyc3kmjubnd8qythcob36q1q8` (`assign_to`),
  CONSTRAINT `FKeyc3kmjubnd8qythcob36q1q8` FOREIGN KEY (`assign_to`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `notification` */

CREATE TABLE `notification` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `contact_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4872qqu0mornlif2m3xcltxbk` (`contact_id`),
  KEY `FKdx5gnak831nwjdymuhpl6755g` (`user_id`),
  CONSTRAINT `FK4872qqu0mornlif2m3xcltxbk` FOREIGN KEY (`contact_id`) REFERENCES `user_contact_detail` (`id`),
  CONSTRAINT `FKdx5gnak831nwjdymuhpl6755g` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user_contact_detail` */

CREATE TABLE `user_contact_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contact_info` varchar(255) DEFAULT NULL,
  `notification_channel` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjqy3yj5l0sabav2ktikm0g1k4` (`user_id`),
  CONSTRAINT `FKjqy3yj5l0sabav2ktikm0g1k4` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user_info` */

CREATE TABLE `user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4lua6x6ujq74itwpednicrlsd` (`user_type_id`),
  CONSTRAINT `FK4lua6x6ujq74itwpednicrlsd` FOREIGN KEY (`user_type_id`) REFERENCES `user_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user_privilege` */

CREATE TABLE `user_privilege` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

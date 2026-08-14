-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: placement_management
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `applied_at` datetime(6) NOT NULL,
                                `remarks` varchar(255) DEFAULT NULL,
                                `status` enum('APPLIED','REJECTED','SELECTED','SHORTLISTED') NOT NULL,
                                `job_id` bigint NOT NULL,
                                `student_id` bigint NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FK65weib1lru9dkrbto5pv389vi` (`job_id`),
                                KEY `FKbxjuiec753shgoyw6x0l8opn8` (`student_id`),
                                CONSTRAINT `FK65weib1lru9dkrbto5pv389vi` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`),
                                CONSTRAINT `FKbxjuiec753shgoyw6x0l8opn8` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` VALUES (1,'2026-08-13 11:42:19.423436',NULL,'SELECTED',1,1),(2,'2026-08-13 13:38:07.801147',NULL,'APPLIED',2,1);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `active` bit(1) NOT NULL,
                             `description` varchar(255) DEFAULT NULL,
                             `email` varchar(255) NOT NULL,
                             `industry` varchar(255) DEFAULT NULL,
                             `location` varchar(255) DEFAULT NULL,
                             `name` varchar(255) NOT NULL,
                             `website` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `UKqjgsqh1oq7xhof2tdte9l7e2b` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,_binary '\0','Technology and consulting company','hr@tcs.com','IT Services','Pune','TCS','https://www.tcs.com'),(5,_binary '\0','Updated company description','hr@infosys.com','IT Services and Consulting','Pune','Infosys Technologies','https://www.infosys.com'),(6,_binary '','Global technology and consulting company','contact@infosys.com','IT Services','Pune','Infosys','https://www.infosys.com');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interviews`
--

DROP TABLE IF EXISTS `interviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interviews` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `feedback` varchar(255) DEFAULT NULL,
                              `interview_date` datetime(6) NOT NULL,
                              `interviewer` varchar(255) DEFAULT NULL,
                              `result` enum('FAILED','PASSED','PENDING','SCHEDULED') NOT NULL,
                              `application_id` bigint NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UK1s2lyr9qjkomstvne9mi044cj` (`application_id`),
                              CONSTRAINT `FKok2bail5ls3jjbjgl5c6nt620` FOREIGN KEY (`application_id`) REFERENCES `applications` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interviews`
--

LOCK TABLES `interviews` WRITE;
/*!40000 ALTER TABLE `interviews` DISABLE KEYS */;
INSERT INTO `interviews` VALUES (1,'Candidate performed well in the interview','2026-08-14 10:00:00.000000','HR Manager','PASSED',1),(2,'Initial interview scheduled','2026-08-14 10:00:00.000000','HR Manager','SCHEDULED',2);
/*!40000 ALTER TABLE `interviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `active` bit(1) DEFAULT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `eligible_branch` varchar(255) DEFAULT NULL,
                        `employment_type` varchar(255) DEFAULT NULL,
                        `graduation_year` int DEFAULT NULL,
                        `job_title` varchar(255) NOT NULL,
                        `location` varchar(255) DEFAULT NULL,
                        `minimum_cgpa` double DEFAULT NULL,
                        `salary_package` double DEFAULT NULL,
                        `company_id` bigint NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKrtmqcrktb6s7xq8djbs2a2war` (`company_id`),
                        CONSTRAINT `FKrtmqcrktb6s7xq8djbs2a2war` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,_binary '\0','Java, Spring Boot and Microservices developer','CSDS','Full Time',2027,'Senior Java Developer','Pune',8,10,1),(2,_binary '','Java and Spring Boot Developer','CSDS','Full Time',2027,'Software Developer','Pune',7.5,600000,1),(3,_binary '','Java developer position','CSDS','Full Time',2027,'Software Developer','Pune',7.5,6.5,1),(4,_binary '','Java and Spring Boot developer position','CSDS','Full Time',2027,'Java Developer','Pune',7.5,8.5,1),(5,_binary '','Python and Data Science developer','CSDS','Full Time',2027,'Python Developer','Pune',7,7.5,1);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placements`
--

DROP TABLE IF EXISTS `placements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `placements` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `placement_date` date DEFAULT NULL,
                              `salary` double NOT NULL,
                              `status` enum('ACCEPTED','OFFERED','REJECTED') NOT NULL,
                              `job_id` bigint NOT NULL,
                              `student_id` bigint NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UKs90r6gkfl1j6aoqwpsd73jjew` (`job_id`),
                              UNIQUE KEY `UKpdsslmnscbpem62ifrl0y7lxp` (`student_id`),
                              CONSTRAINT `FK2tygjyb6yrri5k3yyua5g2jau` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
                              CONSTRAINT `FK9vpaeo6nxwkwbuumsgxrart3` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placements`
--

LOCK TABLES `placements` WRITE;
/*!40000 ALTER TABLE `placements` DISABLE KEYS */;
INSERT INTO `placements` VALUES (1,'2026-08-13',600000,'ACCEPTED',1,1);
/*!40000 ALTER TABLE `placements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `UK85woe63nu9klkk9fa73vf0jd0` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Java'),(3,'Python'),(2,'Spring Boot'),(4,'SQL');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_skills`
--

DROP TABLE IF EXISTS `student_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_skills` (
                                  `student_id` bigint NOT NULL,
                                  `skill_id` bigint NOT NULL,
                                  PRIMARY KEY (`student_id`,`skill_id`),
                                  KEY `FKdyl6ffxg89qebmlpcg2x3fnbw` (`skill_id`),
                                  CONSTRAINT `FKdyl6ffxg89qebmlpcg2x3fnbw` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`),
                                  CONSTRAINT `FKovs9ju1ccjg7kq2m3tct9oh1y` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_skills`
--

LOCK TABLES `student_skills` WRITE;
/*!40000 ALTER TABLE `student_skills` DISABLE KEYS */;
INSERT INTO `student_skills` VALUES (1,1),(1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `student_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `active` bit(1) NOT NULL,
                            `branch` varchar(255) DEFAULT NULL,
                            `cgpa` double DEFAULT NULL,
                            `email` varchar(255) NOT NULL,
                            `graduation_year` int DEFAULT NULL,
                            `name` varchar(255) NOT NULL,
                            `phone` varchar(255) DEFAULT NULL,
                            `resume_url` varchar(255) DEFAULT NULL,
                            `roll_number` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `UKe2rndfrsx22acpq2ty1caeuyw` (`email`),
                            UNIQUE KEY `UK4j48kma5fa3dcya13gd0l3gi` (`phone`),
                            UNIQUE KEY `UKkmd86jf46110c60b412tjt2bg` (`roll_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,_binary '\0','CSDS',9.5,'madhura@example.com',2027,'Madhura Suryawanshi','9999999999','https://example.com/new-resume','CS001'),(2,_binary '','CSDS',9.5,'madhura@gmail.com',2027,'Madhura Suryawanshi','9876543210',NULL,NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-13 19:15:05

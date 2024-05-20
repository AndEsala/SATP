-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: patinaje
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `baterias`
--

DROP TABLE IF EXISTS `baterias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baterias` (
  `id` int NOT NULL,
  `id_torneo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fbk_bateria_torneo_idx` (`id_torneo`),
  CONSTRAINT `fbk_bateria_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baterias`
--

LOCK TABLES `baterias` WRITE;
/*!40000 ALTER TABLE `baterias` DISABLE KEYS */;
/*!40000 ALTER TABLE `baterias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baterias_deportistas`
--

DROP TABLE IF EXISTS `baterias_deportistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baterias_deportistas` (
  `id_bateria` int NOT NULL,
  `id_deportista` int NOT NULL,
  PRIMARY KEY (`id_bateria`,`id_deportista`),
  KEY `fbk_id_deportista_idx` (`id_deportista`),
  CONSTRAINT `fbk_id_bateria` FOREIGN KEY (`id_bateria`) REFERENCES `baterias` (`id`),
  CONSTRAINT `fbk_id_deportista` FOREIGN KEY (`id_deportista`) REFERENCES `deportistas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baterias_deportistas`
--

LOCK TABLES `baterias_deportistas` WRITE;
/*!40000 ALTER TABLE `baterias_deportistas` DISABLE KEYS */;
/*!40000 ALTER TABLE `baterias_deportistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `idade_min` int NOT NULL,
  `idade_max` int NOT NULL,
  `tipo_patin` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Huevito',5,6,'Tradicional/Recreativo'),(2,'Pollito',7,8,'Tradicional/Recreativo'),(3,'Pollito',7,8,'Profesional'),(4,'Pre infantil',9,10,'Tradicional/Recreativo'),(5,'Pre infantil',9,10,'Profesional'),(6,'Menores',11,12,'Tradicional/Recreativo'),(7,'Menores',11,12,'Profesional'),(14,'Abierta',13,50,'Tradicional/Recreativo'),(15,'Abierta',13,50,'Profesional');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clubes`
--

DROP TABLE IF EXISTS `clubes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clubes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `cidade` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubes`
--

LOCK TABLES `clubes` WRITE;
/*!40000 ALTER TABLE `clubes` DISABLE KEYS */;
INSERT INTO `clubes` VALUES (1,'Club Deportivo Olaya Skate Atlántico','Barranquilla'),(2,'Escuela de Patinajes de Hernán Sinig Madero','Santa Bárbara de Pinto'),(3,'Puerto Patín','Puerto Escondido'),(4,'AP Skate','Montería'),(5,'Club Deportivo Falcon','Montería');
/*!40000 ALTER TABLE `clubes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competencias`
--

DROP TABLE IF EXISTS `competencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competencias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competencias`
--

LOCK TABLES `competencias` WRITE;
/*!40000 ALTER TABLE `competencias` DISABLE KEYS */;
INSERT INTO `competencias` VALUES (1,'Velocidad 100m'),(2,'Velocidad 200m'),(3,'Velocidad 400m'),(4,'Velocidad 500m'),(5,'Velocidad 1000m');
/*!40000 ALTER TABLE `competencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deportistas`
--

DROP TABLE IF EXISTS `deportistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deportistas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doc_identidad` varchar(10) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `p_sobrenome` varchar(60) NOT NULL,
  `s_sobrenome` varchar(60) NOT NULL,
  `data_nascimento` date NOT NULL,
  `idade` int NOT NULL,
  `sexo` char(1) NOT NULL,
  `id_clube` int NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doc_identidad` (`doc_identidad`),
  KEY `fbk_deportista_clube_idx` (`id_clube`),
  KEY `fbk_deportista_cat_idx` (`id_categoria`),
  CONSTRAINT `fbk_deportista_cat` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fbk_deportista_clube` FOREIGN KEY (`id_clube`) REFERENCES `clubes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deportistas`
--

LOCK TABLES `deportistas` WRITE;
/*!40000 ALTER TABLE `deportistas` DISABLE KEYS */;
INSERT INTO `deportistas` VALUES (32,'1003402695','Andrés Felipe','Esala','Muñoz','2003-10-13',20,'M',4,7),(33,'1003003633','Andrés Felipe','Suárez','González','2003-07-22',20,'M',4,15);
/*!40000 ALTER TABLE `deportistas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcularEdad` BEFORE INSERT ON `deportistas` FOR EACH ROW BEGIN
DECLARE edadReal INT;
DECLARE tipoP VARCHAR(60);
DECLARE edadMi INT;
DECLARE edadMa INT;
DECLARE idCat INT;
SET edadReal = TIMESTAMPDIFF(YEAR, NEW.data_nascimento, CURDATE());
IF edadReal != NEW.idade THEN
SET NEW.idade = edadReal;
END IF;
SELECT tipo_patin INTO tipoP FROM categorias WHERE id = NEW.id_categoria;
SELECT idade_min INTO edadMi FROM categorias WHERE id = NEW.id_categoria;
SELECT idade_max INTO edadMa FROM categorias WHERE id = NEW.id_categoria;
IF NEW.idade >= edadMi AND NEW.idade <= edadMa THEN
SET NEW.idade = NEW.idade;
ELSE
SELECT id INTO idCat FROM categorias WHERE tipo_patin = tipoP AND idade_min <= NEW.idade AND idade_max >= NEW.idade;
SET NEW.id_categoria = idCat;
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `inscripciones`
--

DROP TABLE IF EXISTS `inscripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripciones` (
  `id_torneo` int NOT NULL,
  `id_deportista` int NOT NULL,
  `id_clube` int NOT NULL,
  `numero` int NOT NULL,
  `data_inscripcion` date NOT NULL,
  `pago` float NOT NULL,
  PRIMARY KEY (`id_torneo`,`id_clube`,`id_deportista`),
  UNIQUE KEY `unique_dep_torneo` (`id_torneo`,`id_deportista`) /*!80000 INVISIBLE */,
  UNIQUE KEY `unique_num_torneo` (`id_torneo`,`numero`),
  KEY `fbk_insc_deportista_idx` (`id_deportista`),
  KEY `fbk_insc_clube_idx` (`id_clube`),
  CONSTRAINT `fbk_insc_clube` FOREIGN KEY (`id_clube`) REFERENCES `clubes` (`id`),
  CONSTRAINT `fbk_insc_deportista` FOREIGN KEY (`id_deportista`) REFERENCES `deportistas` (`id`),
  CONSTRAINT `fbk_insc_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripciones`
--

LOCK TABLES `inscripciones` WRITE;
/*!40000 ALTER TABLE `inscripciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participaciones`
--

DROP TABLE IF EXISTS `participaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participaciones` (
  `id_competencia` int NOT NULL,
  `id_torneo` int NOT NULL,
  `id_deportista` int NOT NULL,
  `tempo` time NOT NULL,
  `posicion` int NOT NULL,
  `puntos` int NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_competencia`,`id_torneo`,`id_deportista`),
  KEY `fbk_part_torneo_idx` (`id_torneo`),
  KEY `fbk_part_deportista_idx` (`id_deportista`),
  CONSTRAINT `fbk_part_competencia` FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id`),
  CONSTRAINT `fbk_part_deportista` FOREIGN KEY (`id_deportista`) REFERENCES `deportistas` (`id`),
  CONSTRAINT `fbk_part_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participaciones`
--

LOCK TABLES `participaciones` WRITE;
/*!40000 ALTER TABLE `participaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `participaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneos`
--

DROP TABLE IF EXISTS `torneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `torneos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `descripcion` text NOT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date NOT NULL,
  `cidade` varchar(60) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `estado` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneos`
--

LOCK TABLES `torneos` WRITE;
/*!40000 ALTER TABLE `torneos` DISABLE KEYS */;
INSERT INTO `torneos` VALUES (1,'Festival de Patinaje AP Skate','Festival de Patinaje AP Skate','2023-11-11','2023-11-12','Montería','No Competitivo',1),(2,'CordoPatin','Festival de Patinaje municipal organizado por CordoPatín','2024-03-10','2024-03-11','Montería','No Competitivo',1);
/*!40000 ALTER TABLE `torneos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinadores`
--

DROP TABLE IF EXISTS `treinadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(10) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `p_sobrenome` varchar(60) NOT NULL,
  `s_sobrenome` varchar(60) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_treinador` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinadores`
--

LOCK TABLES `treinadores` WRITE;
/*!40000 ALTER TABLE `treinadores` DISABLE KEYS */;
INSERT INTO `treinadores` VALUES (1,'1234567890','Laura Vanessa','Pérez','Castañeda','3053788248');
/*!40000 ALTER TABLE `treinadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinadores_clubes`
--

DROP TABLE IF EXISTS `treinadores_clubes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinadores_clubes` (
  `id_treinador` int NOT NULL,
  `id_club` int NOT NULL,
  PRIMARY KEY (`id_treinador`,`id_club`),
  KEY `id_club` (`id_club`),
  CONSTRAINT `treinadores_clubes_ibfk_1` FOREIGN KEY (`id_treinador`) REFERENCES `treinadores` (`id`),
  CONSTRAINT `treinadores_clubes_ibfk_2` FOREIGN KEY (`id_club`) REFERENCES `clubes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinadores_clubes`
--

LOCK TABLES `treinadores_clubes` WRITE;
/*!40000 ALTER TABLE `treinadores_clubes` DISABLE KEYS */;
INSERT INTO `treinadores_clubes` VALUES (1,4);
/*!40000 ALTER TABLE `treinadores_clubes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-19 21:46:03

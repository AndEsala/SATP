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
  `id` int NOT NULL AUTO_INCREMENT,
  `id_torneo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fbk_bateria_torneo_idx` (`id_torneo`),
  CONSTRAINT `fbk_bateria_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baterias`
--

LOCK TABLES `baterias` WRITE;
/*!40000 ALTER TABLE `baterias` DISABLE KEYS */;
INSERT INTO `baterias` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1);
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
  CONSTRAINT `baterias_deportistas_ibfk_1` FOREIGN KEY (`id_bateria`) REFERENCES `baterias` (`id`),
  CONSTRAINT `fbk_id_deportista` FOREIGN KEY (`id_deportista`) REFERENCES `deportistas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baterias_deportistas`
--

LOCK TABLES `baterias_deportistas` WRITE;
/*!40000 ALTER TABLE `baterias_deportistas` DISABLE KEYS */;
INSERT INTO `baterias_deportistas` VALUES (5,32),(11,33),(11,34),(8,35),(8,36),(12,37),(12,38),(8,39),(12,40),(8,41),(9,42),(11,43),(7,44),(11,45),(11,46),(8,47),(12,48),(8,49),(9,50),(12,51),(7,52),(11,53),(6,54),(7,55),(10,56),(3,57),(2,58),(10,59),(6,60),(4,61),(1,62),(6,63),(6,64),(6,65),(10,66),(3,67),(4,68),(10,69),(7,70),(4,71),(3,72),(7,73),(6,74),(4,75),(2,76),(3,77),(10,78),(3,79),(7,80),(4,81),(10,82),(4,83);
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
  `nombre` varchar(60) NOT NULL,
  `edad_min` int NOT NULL,
  `edad_max` int NOT NULL,
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
  `nombre` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `ciudad` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubes`
--

LOCK TABLES `clubes` WRITE;
/*!40000 ALTER TABLE `clubes` DISABLE KEYS */;
INSERT INTO `clubes` VALUES (1,'Club Deportivo Olaya Skate Atlántico','','3054035240','Barranquilla'),(2,'Escuela de Patinajes de Hernán Sinig Madero','','3054035240','Santa Bárbara de Pinto'),(3,'Puerto Patín','','3054035240','Puerto Escondido'),(4,'AP Skate','','3054035240','Montería'),(5,'Club Deportivo Falcon','','3054035240','Montería'),(7,'DPTO Ing de Sistemas','dptosistemas@gmail.com','3054035240','Montería');
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
  `nombre` varchar(60) NOT NULL,
  `p_apellido` varchar(60) NOT NULL,
  `s_apellido` varchar(60) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `edad` int NOT NULL,
  `sexo` char(1) NOT NULL,
  `id_club` int NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doc_identidad` (`doc_identidad`),
  KEY `fbk_deportista_clube_idx` (`id_club`),
  KEY `fbk_deportista_cat_idx` (`id_categoria`),
  CONSTRAINT `fbk_deportista_cat` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fbk_deportista_clube` FOREIGN KEY (`id_club`) REFERENCES `clubes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deportistas`
--

LOCK TABLES `deportistas` WRITE;
/*!40000 ALTER TABLE `deportistas` DISABLE KEYS */;
INSERT INTO `deportistas` VALUES (32,'1003402695','Andrés Felipe','Esala','Muñoz','2003-10-13',20,'M',4,7),(33,'1003003633','Andrés Felipe','Suárez','González','2003-07-22',20,'M',4,15),(34,'1234567890','Juan','Pérez','Gómez','2005-04-12',19,'M',1,15),(35,'2345678901','María','Rodríguez','López','2003-08-25',20,'F',2,14),(36,'3456789012','Luis','Martínez','Fernández','2000-12-05',23,'M',3,14),(37,'4567890123','Ana','García','Sánchez','2002-03-15',22,'F',4,15),(38,'5678901234','Carlos','Hernández','Ramírez','2001-07-30',22,'M',5,15),(39,'6789012345','Laura','Jiménez','Torres','2004-11-21',19,'F',7,14),(40,'7890123456','Pablo','Díaz','Ruiz','1999-06-14',25,'M',1,15),(41,'8901234567','Sofía','Moreno','Morales','2006-01-07',18,'F',2,14),(42,'9012345678','Andrés','Castro','Peña','1998-09-23',25,'M',3,14),(43,'0123456789','Daniela','Ortiz','Herrera','2007-05-19',17,'F',4,15),(44,'1234509876','Santiago','Vargas','Castillo','2005-09-10',18,'M',5,14),(45,'2345610987','Valentina','Romero','Flores','2004-02-17',20,'F',7,15),(46,'3456721098','Diego','Torres','Gil','2003-11-28',20,'M',1,15),(47,'4567832109','Natalia','Méndez','Ríos','2002-06-03',22,'F',2,14),(48,'5678943210','Mateo','León','Soto','2001-10-15',22,'M',3,15),(49,'6789054321','Camila','Reyes','Vargas','2000-04-30',24,'F',4,14),(50,'7890165432','Martín','Rojas','Herrera','1999-12-12',24,'M',5,14),(51,'8901276543','Daniela','Escobar','Guzmán','1998-03-25',26,'F',7,15),(52,'9012387654','Alejandro','Mora','Paredes','2006-07-05',17,'M',1,14),(53,'0123498765','Adriana','Solís','Bustos','2005-11-19',18,'F',2,15),(54,'1111222233','Lucas','Navarro','Montes','2010-07-21',13,'M',3,14),(55,'2222333344','Elena','Fuentes','Cano','2009-05-12',15,'F',1,14),(56,'3333444455','Mateo','Ortega','Lara','2011-03-08',13,'M',4,15),(57,'4444555566','Sofía','Núñez','Duran','2012-11-25',11,'F',5,6),(58,'5555666677','Diego','Salinas','Espinoza','2013-09-16',10,'M',7,5),(59,'6666777788','María','Paredes','Mora','2010-01-30',14,'F',2,15),(60,'7777888899','Tomás','López','Vega','2011-06-04',13,'M',1,14),(61,'8888999900','Julia','Ramos','Campos','2012-08-19',11,'F',3,7),(62,'9999000011','Gabriel','Santos','Ibáñez','2013-10-22',10,'M',4,4),(63,'0000111122','Lucía','Vidal','Castro','2010-04-05',14,'F',5,14),(64,'1122334455','Martín','Cruz','Muñoz','2011-05-14',13,'M',3,14),(65,'2233445566','Isabella','Gómez','Pérez','2010-07-25',13,'F',1,14),(66,'3344556677','Emilio','Gutiérrez','Moreno','2009-11-30',14,'M',4,15),(67,'4455667788','Valeria','Ruiz','Jiménez','2012-10-01',11,'F',5,6),(68,'5566778899','Maximiliano','Cárdenas','Rojas','2013-03-19',11,'M',7,7),(69,'6677889900','Ana','Fernández','Luna','2009-08-22',14,'F',2,15),(70,'7788990011','Rodrigo','Vargas','Torres','2010-06-07',14,'M',1,14),(71,'8899001122','Renata','Silva','Ortega','2011-09-18',12,'F',3,7),(72,'9900112233','Joaquín','Castillo','Navarro','2012-12-05',11,'M',4,6),(73,'0011223344','Florencia','Serrano','Romero','2009-03-11',15,'F',5,14),(74,'1122445566','David','Peña','Soto','2010-05-24',14,'M',7,14),(75,'2233556677','Mía','Montoya','Gil','2011-07-28',12,'F',1,7),(76,'3344667788','Sebastián','Esquivel','Paz','2013-09-14',10,'M',3,5),(77,'4455778899','Clara','Rosales','Méndez','2012-11-17',11,'F',4,6),(78,'5566889900','Álvaro','Benítez','Díaz','2010-02-01',14,'M',5,15),(79,'6677990011','Paula','Iglesias','García','2011-08-12',12,'F',7,6),(80,'7788001122','Lucas','Bravo','Martín','2009-04-23',15,'M',2,14),(81,'8899112233','Lola','Molina','Vargas','2013-01-29',11,'F',1,7),(82,'9900223344','Daniel','Álvarez','Cabrera','2010-03-08',14,'M',3,15),(83,'0011334455','Adriana','Lara','Vega','2012-04-15',12,'F',4,7);
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

SET edadReal = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());

IF edadReal != NEW.edad THEN
SET NEW.edad = edadReal;
END IF;

SELECT tipo_patin INTO tipoP FROM categorias WHERE id = NEW.id_categoria;
SELECT edad_min INTO edadMi FROM categorias WHERE id = NEW.id_categoria;
SELECT edad_max INTO edadMa FROM categorias WHERE id = NEW.id_categoria;

IF NEW.edad >= edadMi AND NEW.edad <= edadMa THEN
SET NEW.edad = NEW.edad;
ELSE
SELECT id INTO idCat FROM categorias WHERE tipo_patin = tipoP AND edad_min <= NEW.edad AND edad_max >= NEW.edad;
SET NEW.id_categoria = idCat;
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `entrenadores`
--

DROP TABLE IF EXISTS `entrenadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `p_apellido` varchar(60) NOT NULL,
  `s_apellido` varchar(60) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_treinador` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenadores`
--

LOCK TABLES `entrenadores` WRITE;
/*!40000 ALTER TABLE `entrenadores` DISABLE KEYS */;
INSERT INTO `entrenadores` VALUES (1,'1234567890','Laura Vanessa','Pérez','Castañeda','3053788248'),(2,'1003402695','Andrés','Esala','Muñoz','3054035240');
/*!40000 ALTER TABLE `entrenadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenadores_clubes`
--

DROP TABLE IF EXISTS `entrenadores_clubes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenadores_clubes` (
  `id_club` int NOT NULL,
  `id_entrenador` int NOT NULL,
  PRIMARY KEY (`id_club`,`id_entrenador`),
  KEY `id_entrenador` (`id_entrenador`),
  CONSTRAINT `entrenadores_clubes_ibfk_1` FOREIGN KEY (`id_club`) REFERENCES `clubes` (`id`),
  CONSTRAINT `entrenadores_clubes_ibfk_2` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenadores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenadores_clubes`
--

LOCK TABLES `entrenadores_clubes` WRITE;
/*!40000 ALTER TABLE `entrenadores_clubes` DISABLE KEYS */;
INSERT INTO `entrenadores_clubes` VALUES (4,1),(7,2);
/*!40000 ALTER TABLE `entrenadores_clubes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripciones`
--

DROP TABLE IF EXISTS `inscripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripciones` (
  `id_torneo` int NOT NULL,
  `id_deportista` int NOT NULL,
  `id_club` int NOT NULL,
  `numero` int NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  `pago` float NOT NULL,
  PRIMARY KEY (`id_torneo`,`id_club`,`id_deportista`),
  UNIQUE KEY `unique_dep_torneo` (`id_torneo`,`id_deportista`) /*!80000 INVISIBLE */,
  UNIQUE KEY `unique_num_torneo` (`id_torneo`,`numero`),
  KEY `fbk_insc_deportista_idx` (`id_deportista`),
  KEY `fbk_insc_clube_idx` (`id_club`),
  CONSTRAINT `fbk_insc_clube` FOREIGN KEY (`id_club`) REFERENCES `clubes` (`id`),
  CONSTRAINT `fbk_insc_deportista` FOREIGN KEY (`id_deportista`) REFERENCES `deportistas` (`id`),
  CONSTRAINT `fbk_insc_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripciones`
--

LOCK TABLES `inscripciones` WRITE;
/*!40000 ALTER TABLE `inscripciones` DISABLE KEYS */;
INSERT INTO `inscripciones` VALUES (1,36,1,36,'2024-06-21',50000),(1,42,1,42,'2024-06-21',50000),(1,48,1,48,'2024-06-21',50000),(1,54,1,54,'2024-06-21',50000),(1,60,1,60,'2024-06-21',50000),(1,66,1,66,'2024-06-21',50000),(1,72,1,72,'2024-06-21',50000),(1,78,1,78,'2024-06-21',50000),(1,37,2,37,'2024-06-21',50000),(1,43,2,43,'2024-06-21',50000),(1,49,2,49,'2024-06-21',50000),(1,55,2,55,'2024-06-21',50000),(1,61,2,61,'2024-06-21',50000),(1,67,2,67,'2024-06-21',50000),(1,73,2,73,'2024-06-21',50000),(1,79,2,79,'2024-06-21',50000),(1,38,3,38,'2024-06-21',50000),(1,44,3,44,'2024-06-21',50000),(1,50,3,50,'2024-06-21',50000),(1,56,3,56,'2024-06-21',50000),(1,62,3,62,'2024-06-21',50000),(1,68,3,68,'2024-06-21',50000),(1,74,3,74,'2024-06-21',50000),(1,80,3,80,'2024-06-21',50000),(1,32,4,25,'2024-06-10',50000),(1,33,4,22,'2024-06-10',50000),(1,34,4,34,'2024-06-21',50000),(1,35,4,35,'2024-06-21',50000),(1,39,4,39,'2024-06-21',50000),(1,45,4,45,'2024-06-21',50000),(1,51,4,51,'2024-06-21',50000),(1,57,4,57,'2024-06-21',50000),(1,63,4,63,'2024-06-21',50000),(1,69,4,69,'2024-06-21',50000),(1,75,4,75,'2024-06-21',50000),(1,81,4,81,'2024-06-21',50000),(1,40,5,40,'2024-06-21',50000),(1,46,5,46,'2024-06-21',50000),(1,52,5,52,'2024-06-21',50000),(1,58,5,58,'2024-06-21',50000),(1,64,5,64,'2024-06-21',50000),(1,70,5,70,'2024-06-21',50000),(1,76,5,76,'2024-06-21',50000),(1,82,5,82,'2024-06-21',50000),(1,41,7,41,'2024-06-21',50000),(1,47,7,47,'2024-06-21',50000),(1,53,7,53,'2024-06-21',50000),(1,59,7,59,'2024-06-21',50000),(1,65,7,65,'2024-06-21',50000),(1,71,7,71,'2024-06-21',50000),(1,77,7,77,'2024-06-21',50000),(1,83,7,83,'2024-06-21',50000);
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
  `tiempo` time NOT NULL,
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
INSERT INTO `participaciones` VALUES (1,1,32,'00:00:18',1,6,'2024-06-10 00:00:00'),(1,1,33,'00:00:20',1,4,'2024-06-10 00:00:00');
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
  `nombre` varchar(60) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `ciudad` varchar(60) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `estado` tinyint NOT NULL,
  `club_organizador` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `club_organizador` (`club_organizador`),
  CONSTRAINT `torneos_ibfk_1` FOREIGN KEY (`club_organizador`) REFERENCES `clubes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneos`
--

LOCK TABLES `torneos` WRITE;
/*!40000 ALTER TABLE `torneos` DISABLE KEYS */;
INSERT INTO `torneos` VALUES (1,'Festival de Patinaje AP Skate','Festival de Patinaje AP Skate','2023-11-11','2023-11-12','Montería','No Competitivo',1,4),(2,'Torneo El Gran Papaya','Festival de Patinaje El Gran Papaya','2024-03-10','2024-03-11','Montería','No Competitivo',1,7);
/*!40000 ALTER TABLE `torneos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-23 14:52:38

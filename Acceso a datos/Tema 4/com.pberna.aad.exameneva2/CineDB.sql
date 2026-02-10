-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: CineDB
-- ------------------------------------------------------
-- Server version	9.0.1
create database CineDB;
use CineDB;

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
-- Table structure for table `Actores`
--

DROP TABLE IF EXISTS `Actores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Actores` (
  `id_actor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `edad` int DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `estatura` decimal(4,2) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`id_actor`),
  CONSTRAINT `Actores_chk_1` CHECK ((`edad` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actores`
--

LOCK TABLES `Actores` WRITE;
/*!40000 ALTER TABLE `Actores` DISABLE KEYS */;
INSERT INTO `Actores` VALUES (1,'Leonardo DiCaprio',49,'Estados Unidos',1.83,'1974-11-11'),(2,'Samuel L. Jackson',75,'Estados Unidos',1.89,'1948-12-21'),(3,'Matthew McConaughey',54,'Estados Unidos',1.82,'1969-11-04'),(4,'Christoph Waltz',67,'Austria',1.70,'1956-10-04');
/*!40000 ALTER TABLE `Actores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Directores`
--

DROP TABLE IF EXISTS `Directores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Directores` (
  `id_director` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `premios` int DEFAULT '0',
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_director`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Directores`
--

LOCK TABLES `Directores` WRITE;
/*!40000 ALTER TABLE `Directores` DISABLE KEYS */;
INSERT INTO `Directores` VALUES (1,'Christopher Nolan','Reino Unido','1970-07-30',10,'nolan@email.com'),(2,'Quentin Tarantino','Estados Unidos','1963-03-27',8,'tarantino@email.com'),(3,'Steven Spielberg','Estados Unidos','1946-12-18',15,'spielberg@email.com');
/*!40000 ALTER TABLE `Directores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Genero`
--

DROP TABLE IF EXISTS `Genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Genero` (
  `id_genero` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Genero`
--

LOCK TABLES `Genero` WRITE;
/*!40000 ALTER TABLE `Genero` DISABLE KEYS */;
INSERT INTO `Genero` VALUES (1,'Acción'),(2,'Drama'),(3,'Comedia'),(4,'Ciencia Ficción'),(5,'Terror'),(6,'Aventura');
/*!40000 ALTER TABLE `Genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pelicula_Actor`
--

DROP TABLE IF EXISTS `Pelicula_Actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pelicula_Actor` (
  `id_pelicula` int NOT NULL,
  `id_actor` int NOT NULL,
  `personaje` varchar(100) NOT NULL,
  `salario` decimal(10,2) DEFAULT '500000.00',
  PRIMARY KEY (`id_pelicula`,`id_actor`),
  KEY `id_actor` (`id_actor`),
  CONSTRAINT `Pelicula_Actor_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `Peliculas` (`id_pelicula`) ON DELETE CASCADE,
  CONSTRAINT `Pelicula_Actor_ibfk_2` FOREIGN KEY (`id_actor`) REFERENCES `Actores` (`id_actor`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pelicula_Actor`
--

LOCK TABLES `Pelicula_Actor` WRITE;
/*!40000 ALTER TABLE `Pelicula_Actor` DISABLE KEYS */;
INSERT INTO `Pelicula_Actor` VALUES (1,1,'Dom Cobb',20000000.00),(2,1,'Calvin Candie',15000000.00),(2,2,'Stephen',8000000.00),(2,4,'Dr. King Schultz',10000000.00),(3,2,'Ray Arnold',5000000.00),(4,1,'Cooper',18000000.00),(4,3,'Joseph Cooper',15000000.00);
/*!40000 ALTER TABLE `Pelicula_Actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Peliculas`
--

DROP TABLE IF EXISTS `Peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Peliculas` (
  `id_pelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `anio` int NOT NULL,
  `presupuesto` decimal(12,2) DEFAULT '0.00',
  `clasificacion` varchar(10) DEFAULT 'PG-13',
  `id_director` int DEFAULT NULL,
  `id_genero` int DEFAULT NULL,
  `recaudacion` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`),
  KEY `id_director` (`id_director`),
  KEY `Peliculas_Genero_FK` (`id_genero`),
  CONSTRAINT `Peliculas_Genero_FK` FOREIGN KEY (`id_genero`) REFERENCES `Genero` (`id_genero`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `Peliculas_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `Directores` (`id_director`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peliculas`
--

LOCK TABLES `Peliculas` WRITE;
/*!40000 ALTER TABLE `Peliculas` DISABLE KEYS */;
INSERT INTO `Peliculas` VALUES (1,'Inception',2010,160000000.00,'PG-13',1,4,728000000.00),(2,'Django Unchained',2012,100000000.00,'R',2,1,449000000.00),(3,'Jurassic Park',1993,63000000.00,'PG-13',3,6,1099000000.00),(4,'Interstellar',2014,165000000.00,'PG-13',1,4,773000000.00);
/*!40000 ALTER TABLE `Peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'CineDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-18 22:55:45

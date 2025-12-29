CREATE DATABASE  IF NOT EXISTS `exercicio2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `exercicio2`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: exercicio2
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Diretoria Comercial'),(2,'Marketing'),(3,'Desenvolvimento'),(4,'Administracao');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `qtd_dependentes` int(11) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `funcionario_departamento_fk` (`departamento`),
  CONSTRAINT `funcionario_departamento_fk` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Joao da Silva',2,1500,'Vendedor',1),(2,'Ruan Lopez',1,1800.5,'Assist Compras',1),(3,'Maria Lucia',3,1500,'Vendedor',1),(4,'Marcos Roberto',0,700,'estagiario',1),(5,'Pedro Lopes',2,2.5,'Programador Jr',3),(6,'Ana Claudia',0,2.65,'Programador Pl',3),(7,'Mario Alves Ruiz',1,2500,'Programador Jr',3),(8,'Rose Campos',4,6500,'Gerente',3),(9,'Carlos Roberto',3,5600,'Analista Jr',3),(10,'Joao da Silva',2,800,'Estagio TI',3),(11,'Mariana Braz',3,5800,'Analista Pl',3),(12,'Daniel Marcontes',5,3200,'Programador Sr',3),(13,'Debora Nascimento',3,3500,'Analista Mkt Jr',2),(14,'Carlos Miguel',1,1900,'Assist Mkt Jr',2),(15,'Marli Ana',0,1800,'Aux. Cobranca',1),(16,'Antonio Carlo',0,1200,'Telefonista',1),(17,'Carlo Antonio',0,6500,'Gerente',1),(18,'Maira Antonieta',1,6500,'Gerente',2);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'exercicio2'
--

--
-- Dumping routines for database 'exercicio2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-07 18:13:49

CREATE DATABASE  IF NOT EXISTS `dbfaculdade` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbfaculdade`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbfaculdade
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `ALUNO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_ALUNO` varchar(255) DEFAULT NULL,
  `RM_ALUNO` varchar(255) DEFAULT NULL,
  `CURSO_ID` int(11) DEFAULT NULL,
  `ESCOLA_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ALUNO_ID`),
  KEY `FK_scp1ualhpudo0v98byhhj05hb` (`CURSO_ID`),
  KEY `FK_cqeeimhcdyywrhgy93186p6ef` (`ESCOLA_ID`),
  CONSTRAINT `FK_cqeeimhcdyywrhgy93186p6ef` FOREIGN KEY (`ESCOLA_ID`) REFERENCES `escola` (`ESCOLA_ID`),
  CONSTRAINT `FK_scp1ualhpudo0v98byhhj05hb` FOREIGN KEY (`CURSO_ID`) REFERENCES `curso` (`CURSO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Felipe','1234',1,1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_disciplina`
--

DROP TABLE IF EXISTS `aluno_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_disciplina` (
  `ALUNO_ID` int(11) NOT NULL,
  `DISCIPLINA_ID` int(11) NOT NULL,
  `atividade` decimal(12,2) DEFAULT NULL,
  `projeto1` decimal(12,2) DEFAULT NULL,
  `projeto2` decimal(12,2) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `CURSO_ID` int(11) DEFAULT NULL,
  `PROFESSOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ALUNO_ID`,`DISCIPLINA_ID`),
  KEY `FK_52kke3v70wnkpmrykxt4aqstu` (`CURSO_ID`),
  KEY `FK_l2i15r0qi4umrabucfknuddrj` (`DISCIPLINA_ID`),
  KEY `FK_iij7yqmc7ymmblt430ypnjpm4` (`PROFESSOR_ID`),
  CONSTRAINT `FK_52kke3v70wnkpmrykxt4aqstu` FOREIGN KEY (`CURSO_ID`) REFERENCES `curso` (`CURSO_ID`),
  CONSTRAINT `FK_iij7yqmc7ymmblt430ypnjpm4` FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `professor` (`PROFESSOR_ID`),
  CONSTRAINT `FK_l2i15r0qi4umrabucfknuddrj` FOREIGN KEY (`DISCIPLINA_ID`) REFERENCES `disciplina` (`DISCIPLINA_ID`),
  CONSTRAINT `FK_nj4l5stwx967mh8nhvraj7agh` FOREIGN KEY (`ALUNO_ID`) REFERENCES `aluno` (`ALUNO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_disciplina`
--

LOCK TABLES `aluno_disciplina` WRITE;
/*!40000 ALTER TABLE `aluno_disciplina` DISABLE KEYS */;
INSERT INTO `aluno_disciplina` VALUES (1,1,10.00,10.00,10.00,'CURSANDO',NULL,NULL);
/*!40000 ALTER TABLE `aluno_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `CURSO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CURSO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CURSO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Curso1');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_disciplina`
--

DROP TABLE IF EXISTS `curso_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_disciplina` (
  `CURSO_ID` int(11) NOT NULL,
  `DISCIPLINA_ID` int(11) NOT NULL,
  PRIMARY KEY (`CURSO_ID`,`DISCIPLINA_ID`),
  KEY `FK_r8rqw0dw34tgiwdiepssrtcnt` (`DISCIPLINA_ID`),
  CONSTRAINT `FK_k8q6bgf0skr7xs7jptiuh4nc1` FOREIGN KEY (`CURSO_ID`) REFERENCES `curso` (`CURSO_ID`),
  CONSTRAINT `FK_r8rqw0dw34tgiwdiepssrtcnt` FOREIGN KEY (`DISCIPLINA_ID`) REFERENCES `disciplina` (`DISCIPLINA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_disciplina`
--

LOCK TABLES `curso_disciplina` WRITE;
/*!40000 ALTER TABLE `curso_disciplina` DISABLE KEYS */;
INSERT INTO `curso_disciplina` VALUES (1,1);
/*!40000 ALTER TABLE `curso_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `DISCIPLINA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DISCIPLINA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DISCIPLINA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Disciplina1');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola` (
  `ESCOLA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_ESCOLA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ESCOLA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (1,'Escola1'),(2,'Escola2');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola_curso`
--

DROP TABLE IF EXISTS `escola_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola_curso` (
  `ESCOLA_ID` int(11) NOT NULL,
  `CURSO_ID` int(11) NOT NULL,
  KEY `FK_t6oy2odu77dial9mnomrnc4mk` (`CURSO_ID`),
  KEY `FK_f7wysf4ajv4humvbshhaqdcgc` (`ESCOLA_ID`),
  CONSTRAINT `FK_f7wysf4ajv4humvbshhaqdcgc` FOREIGN KEY (`ESCOLA_ID`) REFERENCES `escola` (`ESCOLA_ID`),
  CONSTRAINT `FK_t6oy2odu77dial9mnomrnc4mk` FOREIGN KEY (`CURSO_ID`) REFERENCES `curso` (`CURSO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola_curso`
--

LOCK TABLES `escola_curso` WRITE;
/*!40000 ALTER TABLE `escola_curso` DISABLE KEYS */;
INSERT INTO `escola_curso` VALUES (1,1);
/*!40000 ALTER TABLE `escola_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola_professor`
--

DROP TABLE IF EXISTS `escola_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola_professor` (
  `ESCOLA_ID` int(11) NOT NULL,
  `PROFESSOR_ID` int(11) NOT NULL,
  KEY `FK_o6gv746d0tuvgkbm4tjv3b7ko` (`PROFESSOR_ID`),
  KEY `FK_4quusv56pqaw3hv2prcguvr0u` (`ESCOLA_ID`),
  CONSTRAINT `FK_4quusv56pqaw3hv2prcguvr0u` FOREIGN KEY (`ESCOLA_ID`) REFERENCES `escola` (`ESCOLA_ID`),
  CONSTRAINT `FK_o6gv746d0tuvgkbm4tjv3b7ko` FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `professor` (`PROFESSOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola_professor`
--

LOCK TABLES `escola_professor` WRITE;
/*!40000 ALTER TABLE `escola_professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `escola_professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `PROFESSOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_PROFESSOR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PROFESSOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `USUARIO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PERMISSAO` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USUARIO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'felipe','ADMINISTRADOR','123'),(2,'felipe1','PROFESSOR','123'),(3,'felipe2','ALUNO','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-29 16:23:54

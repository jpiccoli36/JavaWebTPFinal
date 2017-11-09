-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javatp
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `elementos`
--

DROP TABLE IF EXISTS `elementos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementos` (
  `IDElementosReserva` int(11) NOT NULL AUTO_INCREMENT,
  `NombreElementoReserva` varchar(45) DEFAULT NULL,
  `TipoElemento` varchar(45) NOT NULL,
  PRIMARY KEY (`IDElementosReserva`),
  KEY `TipoElemento_idx` (`TipoElemento`),
  KEY `Telementos_idx` (`NombreElementoReserva`),
  KEY `TiposEl_idx` (`TipoElemento`,`IDElementosReserva`),
  CONSTRAINT `TiposEl` FOREIGN KEY (`TipoElemento`) REFERENCES `tiposelementos` (`NombreElemento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos`
--

LOCK TABLES `elementos` WRITE;
/*!40000 ALTER TABLE `elementos` DISABLE KEYS */;
INSERT INTO `elementos` VALUES (23,'samsung','notebook'),(25,'bangho','notebook'),(26,'pry1','proyector'),(27,'pry2','proyector'),(28,'hp','notebook'),(41,'pry3','proyector'),(42,'acer','netbook'),(43,'compaq','netbook'),(44,'mic1','microfono'),(45,'mic2','microfono'),(46,'mic3','microfono'),(47,'tab1','tablets'),(48,'tab2','tablets'),(49,'tab3','tablets'),(50,'mic4','microfono'),(51,'mic5','microfono');
/*!40000 ALTER TABLE `elementos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `fhinicio` datetime DEFAULT NULL,
  `fhfin` datetime DEFAULT NULL,
  `elemento` varchar(45) DEFAULT NULL,
  `tipoelemento` varchar(45) DEFAULT NULL,
  `detalle` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `us_idx` (`usuario`),
  KEY `uss_idx` (`elemento`),
  KEY `tipoelem_idx` (`tipoelemento`),
  CONSTRAINT `elem` FOREIGN KEY (`elemento`) REFERENCES `elementos` (`NombreElementoReserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tipoelem` FOREIGN KEY (`tipoelemento`) REFERENCES `tiposelementos` (`NombreElemento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (3,'romi','2017-10-04 11:00:00','2017-10-04 12:00:00','samsung','notebook',NULL),(6,'analia94','2017-11-01 12:00:00','2018-01-01 13:00:00','pry1','proyector',NULL),(7,'juan','2017-12-03 11:30:00','2017-12-04 11:00:00','bangho','notebook',NULL),(8,'juanperez','2017-10-03 08:00:00','2017-10-04 10:30:00','samsung','notebook',NULL),(11,'analia94','2017-10-06 17:00:00','2017-10-06 18:30:00','bangho','notebook',NULL);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposelementos`
--

DROP TABLE IF EXISTS `tiposelementos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposelementos` (
  `idElementos` int(11) NOT NULL AUTO_INCREMENT,
  `NombreElemento` varchar(45) NOT NULL,
  `CantidadElementos` varchar(45) NOT NULL,
  PRIMARY KEY (`idElementos`),
  KEY `NombreElementos_idx` (`NombreElemento`),
  KEY `NombreElementosReserva_idx` (`NombreElemento`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposelementos`
--

LOCK TABLES `tiposelementos` WRITE;
/*!40000 ALTER TABLE `tiposelementos` DISABLE KEYS */;
INSERT INTO `tiposelementos` VALUES (1,'notebook','3'),(4,'tablets','2'),(6,'proyector','1'),(47,'netbook','2'),(48,'microfono','4');
/*!40000 ALTER TABLE `tiposelementos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(45) DEFAULT NULL,
  `NombreUsuario` varchar(45) DEFAULT NULL,
  `ApellidoUsuario` varchar(45) DEFAULT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Contraseña` varchar(45) DEFAULT NULL,
  `habilitado` varchar(45) DEFAULT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`,`Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'123','jose','piccoli','jpiccoli','123','inhabilitado','admin'),(2,'321','analia','salazar','analia94','321','habilitado','user'),(3,'12345','juan','jose','juan','321123','inhabilitado','user'),(4,'123123','pipo','antonio','pipon','1234','habilitado','user'),(5,'1234563','romina','scaraca','romi','123456','habilitado','user'),(17,'4569','juan','perez','juanperez','789','habilitado','user');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-07 20:48:46

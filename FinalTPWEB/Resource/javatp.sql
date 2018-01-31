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
  KEY `Telementos_idx` (`NombreElementoReserva`),
  KEY `TiposEl_idx` (`TipoElemento`,`IDElementosReserva`),
  CONSTRAINT `TiposEl` FOREIGN KEY (`TipoElemento`) REFERENCES `tiposelementos` (`NombreElemento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos`
--

LOCK TABLES `elementos` WRITE;
/*!40000 ALTER TABLE `elementos` DISABLE KEYS */;
INSERT INTO `elementos` VALUES (1,'HP','Notebook'),(2,'Acer','Notebook'),(3,'Asus','Notebook'),(4,'Vaio','Notebook'),(5,'BGH','Notebook'),(6,'Epson','Proyector'),(7,'ViewSonic','Proyector'),(8,'Xiaomi','Proyector'),(9,'Epson','Escaner'),(10,'HP','Escaner'),(11,'Samsung','Escaner'),(12,'Ipad','Tablet'),(13,'Samsung','Tablet'),(14,'BGH','Tablet'),(15,'Admiral','Tablet'),(16,'Laboratorio','Salon'),(17,'SUM','Salon'),(18,'Anfiteatro','Salon'),(19,'Salon de Actos','Salon'),(21,'Razer','Auriculares'),(22,'Hyperx','Auriculares'),(23,'Logitech','Auriculares'),(24,'Noganet','Auriculares'),(25,'Genius','Auriculares');
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
  KEY `elem_idx` (`elemento`),
  KEY `tipoelem_idx` (`tipoelemento`),
  CONSTRAINT `elem` FOREIGN KEY (`elemento`) REFERENCES `elementos` (`NombreElementoReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tipoelem` FOREIGN KEY (`tipoelemento`) REFERENCES `tiposelementos` (`NombreElemento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
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
  `CantidadElementos` int(11) NOT NULL,
  `Autorizado` varchar(45) DEFAULT NULL,
  `anterioridadminima` int(11) DEFAULT NULL,
  `diasmaxreserva` int(11) DEFAULT NULL,
  PRIMARY KEY (`idElementos`),
  KEY `NombreElementos_idx` (`NombreElemento`),
  KEY `NombreElementosReserva_idx` (`NombreElemento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposelementos`
--

LOCK TABLES `tiposelementos` WRITE;
/*!40000 ALTER TABLE `tiposelementos` DISABLE KEYS */;
INSERT INTO `tiposelementos` VALUES (1,'Notebook',3,'user',2,7),(2,'Proyector',1,'user',1,8),(3,'Escaner',2,'encargado',3,2),(4,'Tablet',1,'user',1,3),(5,'Salon',1,'encargado',4,2),(6,'Auriculares',5,'user',2,1);
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
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`,`Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'123','jose','piccoli','jpiccoli','123','habilitado','admin','jpiccoli36@gmail.com'),(2,'321','analia','salazar','analia94','321','habilitado','user','analiasuperpoderosa@gmail.com'),(3,'121212','juan','ramirez','jramirez','123123','habilitado','encargado','jramirez@gmail.com'),(4,'321321','patricia','silvano','psilvano','321321','inhabilitado','user','psilvano@gmail.com');
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

-- Dump completed on 2018-01-31 16:06:41

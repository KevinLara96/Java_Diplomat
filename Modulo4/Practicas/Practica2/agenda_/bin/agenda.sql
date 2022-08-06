-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
-- Volcando estructura de base de datos para agenda
DROP DATABASE IF EXISTS `agenda`;
CREATE DATABASE IF NOT EXISTS `agenda`
/*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agenda`;
-- Volcando estructura para tabla agenda.c_medio_contacto
DROP TABLE IF EXISTS `c_medio_contacto`;
CREATE TABLE IF NOT EXISTS `c_medio_contacto` (
  `id_medio_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `vc_nombre` varchar(50) NOT NULL,
  `vc_estatus` varchar(50) NOT NULL,
  PRIMARY KEY (`id_medio_contacto`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8;
-- Volcando datos para la tabla agenda.c_medio_contacto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `c_medio_contacto` DISABLE KEYS */;
INSERT INTO
  `c_medio_contacto` (`id_medio_contacto`, `vc_nombre`, `vc_estatus`)
VALUES
  (1, 'Teléfono casa', 'ACTIVO'),
  (2, 'Teléfono trabajo', 'ACTIVO'),
  (3, 'Teléfono celular', 'ACTIVO');
  /*!40000 ALTER TABLE `c_medio_contacto` ENABLE KEYS */;
-- Volcando estructura para tabla agenda.c_tipo_contacto
  DROP TABLE IF EXISTS `c_tipo_contacto`;
CREATE TABLE IF NOT EXISTS `c_tipo_contacto` (
    `id_tipo_contacto` int(11) NOT NULL AUTO_INCREMENT,
    `vc_nombre` varchar(50) NOT NULL,
    `vc_estatus` varchar(50) NOT NULL,
    PRIMARY KEY (`id_tipo_contacto`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8;
-- Volcando datos para la tabla agenda.c_tipo_contacto: ~0 rows (aproximadamente)
  /*!40000 ALTER TABLE `c_tipo_contacto` DISABLE KEYS */;
INSERT INTO
  `c_tipo_contacto` (`id_tipo_contacto`, `vc_nombre`, `vc_estatus`)
VALUES
  (1, 'Familiar', 'ACTIVO'),
  (2, 'Escolar', 'ACTIVO'),
  (3, 'Laboral', 'ACTIVO');
  /*!40000 ALTER TABLE `c_tipo_contacto` ENABLE KEYS */;
-- Volcando estructura para tabla agenda.t_contacto
  DROP TABLE IF EXISTS `t_contacto`;
CREATE TABLE IF NOT EXISTS `t_contacto` (
    `id_contacto` int(11) NOT NULL AUTO_INCREMENT,
    `vc_nombre` varchar(50) NOT NULL,
    `vc_apellidos` varchar(200) NOT NULL,
    `vi_edad` tinyint(4) NOT NULL DEFAULT 0,
    `vc_direccion` text NOT NULL,
    `id_tipo_contacto` int(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id_contacto`),
    KEY `fk_tipo_contacto` (`id_tipo_contacto`),
    CONSTRAINT `fk_tipo_contacto` FOREIGN KEY (`id_tipo_contacto`) REFERENCES `c_tipo_contacto` (`id_tipo_contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;
-- Volcando datos para la tabla agenda.t_contacto: ~0 rows (aproximadamente)
  /*!40000 ALTER TABLE `t_contacto` DISABLE KEYS */;
  /*!40000 ALTER TABLE `t_contacto` ENABLE KEYS */;
-- Volcando estructura para tabla agenda.t_contactos_medios
  DROP TABLE IF EXISTS `t_contactos_medios`;
CREATE TABLE IF NOT EXISTS `t_contactos_medios` (
    `id_contactos_medios` int(11) NOT NULL AUTO_INCREMENT,
    `vc_valor` varchar(300) NOT NULL,
    `id_contacto` int(11) NOT NULL,
    `id_medio_contacto` int(11) NOT NULL,
    PRIMARY KEY (`id_contactos_medios`),
    KEY `fk_medio_contacto` (`id_medio_contacto`),
    KEY `fk_contacto` (`id_contacto`),
    CONSTRAINT `fk_contacto` FOREIGN KEY (`id_contacto`) REFERENCES `t_contacto` (`id_contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_medio_contacto` FOREIGN KEY (`id_medio_contacto`) REFERENCES `c_medio_contacto` (`id_medio_contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;
-- Volcando datos para la tabla agenda.t_contactos_medios: ~0 rows (aproximadamente)
  /*!40000 ALTER TABLE `t_contactos_medios` DISABLE KEYS */;
  /*!40000 ALTER TABLE `t_contactos_medios` ENABLE KEYS */;
  /*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
  /*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
  /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
  /*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
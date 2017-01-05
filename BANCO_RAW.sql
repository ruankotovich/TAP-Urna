# WARNING: Using a password on the command line interface can be insecure.
# Source on localhost: ... connected.
SET FOREIGN_KEY_CHECKS=0;
# Exporting metadata from tap-urna
DROP DATABASE IF EXISTS `tap-urna`;
CREATE DATABASE `tap-urna`;
USE `tap-urna`;
# TABLE: tap-urna.administrator_privileges
CREATE TABLE `administrator_privileges` (
  `adm_key` varchar(50) NOT NULL,
  `adm_deadlock` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`adm_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# TABLE: tap-urna.candidatos
CREATE TABLE `candidatos` (
  `can_pid` int(11) NOT NULL AUTO_INCREMENT,
  `can_nome` varchar(100) NOT NULL,
  `can_partido` varchar(10) NOT NULL,
  `can_foto` longblob,
  PRIMARY KEY (`can_pid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
# TABLE: tap-urna.eleitores
CREATE TABLE `eleitores` (
  `ele_titulo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ele_nome` varchar(100) NOT NULL,
  `ele_dataNasc` varchar(20) NOT NULL,
  PRIMARY KEY (`ele_titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
# TABLE: tap-urna.votos
CREATE TABLE `votos` (
  `vot_ele_titulo` bigint(20) NOT NULL,
  `vot_can_pid` int(11) NOT NULL,
  `vot_branco` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`vot_ele_titulo`,`vot_can_pid`),
  KEY `vot_can_pid` (`vot_can_pid`),
  CONSTRAINT `votos_ibfk_1` FOREIGN KEY (`vot_ele_titulo`) REFERENCES `eleitores` (`ele_titulo`),
  CONSTRAINT `votos_ibfk_2` FOREIGN KEY (`vot_can_pid`) REFERENCES `candidatos` (`can_pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#...done.
SET FOREIGN_KEY_CHECKS=1;
#OBS : CADASTRE UM CANDIDATO COM O CÓDIGO 0 PARA SER O Voto Nulo

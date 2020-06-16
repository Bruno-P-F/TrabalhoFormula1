DROP DATABASE IF EXISTS formula1;
CREATE DATABASE formula1 /*!40100 DEFAULT CHARACTER SET latin1 */;
USE formula1;
CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idEquipe` int(11) NOT NULL,
  `idCargo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idEquipe_func_idx` (`idEquipe`),
  KEY `fk_idCargo_idx` (`idCargo`),
  CONSTRAINT `fk_idCargo` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`id`),
  CONSTRAINT `fk_idEquipe_func` FOREIGN KEY (`idEquipe`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB;
CREATE TABLE `grandprix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `localizacao` varchar(45) NOT NULL,
  `voltas` int(11) NOT NULL,
  `anoCorrida` int(11) NOT NULL,
  `percursoKm` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
CREATE TABLE `piloto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `nacionalidade` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `idEquipe` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idEquipe_idx` (`idEquipe`),
  CONSTRAINT `fk_idEquipe` FOREIGN KEY (`idEquipe`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB;
CREATE TABLE `gpposicao` (
  `idPiloto` int(11) NOT NULL,
  `idGrandprix` int(11) NOT NULL,
  `classificacao` int(11) NOT NULL,
  `pontos` int(11) NOT NULL,
  PRIMARY KEY (`idPiloto`,`idGrandprix`),
  KEY `fk_idGrandprix_idx` (`idGrandprix`),
  CONSTRAINT `fk_idGrandprix` FOREIGN KEY (`idGrandprix`) REFERENCES `grandprix` (`id`),
  CONSTRAINT `fk_idPiloto` FOREIGN KEY (`idPiloto`) REFERENCES `piloto` (`id`)
) ENGINE=InnoDB;
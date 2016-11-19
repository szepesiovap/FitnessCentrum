-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fitnesscentrum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitnesscentrum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnesscentrum` DEFAULT CHARACTER SET utf8 ;
USE `fitnesscentrum` ;

-- -----------------------------------------------------
-- Table `fitnesscentrum`.`recepcny`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesscentrum`.`recepcny` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(60) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `heslo` VARCHAR(75) NULL DEFAULT NULL,
  `salt` VARCHAR(75) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnesscentrum`.`spiner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesscentrum`.`spiner` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnesscentrum`.`spinning`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesscentrum`.`spinning` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `datum` DATE NULL DEFAULT NULL,
  `cas` TIME NULL DEFAULT NULL,
  `kapacita` INT(11) NULL DEFAULT NULL,
  `volne` INT(11) NULL DEFAULT NULL,
  `idTrener` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idTrenera_idx` (`idTrener` ASC),
  CONSTRAINT `idTrenera`
    FOREIGN KEY (`idTrener`)
    REFERENCES `fitnesscentrum`.`spiner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `fitnesscentrum`.`kluc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fitnesscentrum`.`kluc`;
CREATE TABLE IF NOT EXISTS `fitnesscentrum`.`kluc` (
  `id_kluca` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_kluca` VARCHAR(45) NOT NULL,
  `id_zakaznika` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_kluca`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('1M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('2M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('3M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('4M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('5M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('6M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('7M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('8M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('9M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('10M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('11M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('12M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('13M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('14M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('15M');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('1Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('2Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('3Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('4Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('5Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('6Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('7Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('8Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('9Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('10Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('11Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('12Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('13Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('14Z');
INSERT INTO `fitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('15Z');


-- -----------------------------------------------------
-- Table `fitnesscentrum`.`zakaznik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesscentrum`.`zakaznik` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(45) NULL DEFAULT NULL,
  `posledny_prichod` TIMESTAMP NULL DEFAULT NULL,
  `pritomny` TINYINT(1) NULL DEFAULT NULL,
  `kredit` INT(11) NULL DEFAULT NULL,
  `cislo_pernamentky` INT(11) NULL DEFAULT NULL,
	`id_kluca` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `fitnesscentrum`.`zakaznik` (`meno_priezvisko`,`pritomny`) VALUES ('Patka',0);
INSERT INTO `fitnesscentrum`.`zakaznik` (`meno_priezvisko`,`pritomny`) VALUES ('Lucka',1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

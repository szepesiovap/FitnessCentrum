CREATE SCHEMA IF NOT EXISTS `testFitnesscentrum` DEFAULT CHARACTER SET utf8 ;
USE `testFitnesscentrum` ;

-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`instruktor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`instruktor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`kluc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`kluc` (
  `id_kluca` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_kluca` VARCHAR(45) NOT NULL,
  `id_zakaznika` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_kluca`),
  UNIQUE INDEX `meno_kluca_UNIQUE` (`meno_kluca` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('1M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('2M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('3M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('4M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('5M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('6M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('7M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('8M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('9M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('10M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('11M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('12M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('13M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('14M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('15M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('1Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('2Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('3Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('4Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('5Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('6Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('7Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('8Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('9Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('10Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('11Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('12Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('13Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('14Z');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('15Z');


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`kredit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`kredit` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cena` DOUBLE NULL DEFAULT NULL,
  `nazov` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cena_UNIQUE` (`cena` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('30', '30 eur');
INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('50', '50 eur');
INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('80', '80 eur');


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`recepcny`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`recepcny` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(60) NULL DEFAULT NULL,
  `login` VARCHAR(45) NOT NULL,
  `heslo` VARCHAR(75) NULL DEFAULT NULL,
  `salt` VARCHAR(75) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `testFitnesscentrum`.`recepcny` (`meno_priezvisko`, `login`, `heslo`, `salt`)
VALUES ('admin','admin','CE6736FEFE7C7F09E83206EDF1756C182D81824EF987542EBBA1244202F0319E', 'd19d6534-e083-4f93-96b9-8499c09dc811');

UPDATE `testFitnesscentrum`.`recepcny` SET id = 0 WHERE id = 1;


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`rezervacia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`rezervacia` (
  `id_rezervacia` INT(11) NOT NULL AUTO_INCREMENT,
  `id_spinning` INT(11) NULL DEFAULT NULL,
  `id_zakaznik` INT(11) NULL DEFAULT NULL,
  `cas_rezervacie` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id_rezervacia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`spinning`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`spinning` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `datum` TIMESTAMP NULL DEFAULT NULL,
  `kapacita` INT(11) NULL DEFAULT NULL,
  `volne` INT(11) NULL DEFAULT NULL,
  `id_instruktora` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_instruktora_idx` (`id_instruktora` ASC),
  CONSTRAINT `idTrenera`
    FOREIGN KEY (`id_instruktora`)
    REFERENCES `testFitnesscentrum`.`instruktor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`vstupne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`vstupne` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cena_vstupneho` DOUBLE NULL DEFAULT NULL,
  `cena_spinningu` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- opatrenie, aby tam nikdy nebolo null
INSERT INTO `testFitnesscentrum`.`vstupne` (`cena_vstupneho`, `cena_spinningu`) VALUES ('3','5');


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`zakaznik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`zakaznik` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `meno_priezvisko` VARCHAR(45) NULL DEFAULT NULL,
  `posledny_prichod` TIMESTAMP NULL DEFAULT NULL,
  `pritomny` TINYINT(1) NULL DEFAULT NULL,
  `kredit` DOUBLE NULL DEFAULT NULL,
  `cislo_permanentky` VARCHAR(20) NULL DEFAULT NULL,
  `id_kluca` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cislo_permanentky_UNIQUE` (`cislo_permanentky` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `testFitnesscentrum`.`instruktor` (`meno_priezvisko`) VALUES ('Janko Hrasko');
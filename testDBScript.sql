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


-- -----------------------------------------------------
-- Table `testFitnesscentrum`.`kredit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`kredit` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cena` DOUBLE(6,2) NULL DEFAULT NULL,
  `nazov` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cena_UNIQUE` (`cena` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

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

CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`typ_cvicenia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nazov` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`cvicenie` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `datum` TIMESTAMP NULL DEFAULT NULL,
  `kapacita` INT(11) NULL DEFAULT NULL,
  `volne` INT(11) NULL DEFAULT NULL,
  `id_instruktora` INT(11) NULL DEFAULT NULL,
  `id_typ_cvicenia` INT(11),
  PRIMARY KEY (`id`),
  INDEX `id_instruktora_idx` (`id_instruktora` ASC),
  CONSTRAINT `idTrenera`
    FOREIGN KEY (`id_instruktora`)
    REFERENCES `fitnesscentrum`.`instruktor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
     CONSTRAINT `TypCvicenia`
    FOREIGN KEY (`id_typ_cvicenia`)
    REFERENCES `fitnesscentrum`.`typ_cvicenia` (`id`)
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

-- -----------------------------------------------------
-- Table `fitnesscentrum`.`rezervacia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testFitnesscentrum`.`rezervacia` (
  `id_rezervacia` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cvicenie` INT(11) NULL DEFAULT NULL,
  `id_zakaznik` INT(11) NULL DEFAULT NULL,
  `cas_rezervacie` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id_rezervacia`),
  INDEX `zakaznik.id_idx` (`id_zakaznik` ASC),
  INDEX `cvicenie.id_idx` (`id_cvicenie` ASC),
  CONSTRAINT `cvicenie.id`
    FOREIGN KEY (`id_cvicenie`)
    REFERENCES `fitnesscentrum`.`cvicenie` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `zakaznik.id`
    FOREIGN KEY (`id_zakaznik`)
    REFERENCES `fitnesscentrum`.`zakaznik` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `testFitnesscentrum`.`instruktor` (`meno_priezvisko`) VALUES ('Janko Hrasko');


INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('1M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('2M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('3M');
INSERT INTO `testFitnesscentrum`.`kluc` (`meno_kluca`) VALUES ('4M');


INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('30', '30 eur');
INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('50', '50 eur');
INSERT INTO `testFitnesscentrum`.`kredit` (`cena`, `nazov`) VALUES ('80', '80 eur');


INSERT INTO `testFitnesscentrum`.`vstupne` (`cena_vstupneho`, `cena_spinningu`) VALUES ('3','5');


INSERT INTO `testFitnesscentrum`.`recepcny` (`meno_priezvisko`, `login`, `heslo`, `salt`)
VALUES ('admin','admin','CE6736FEFE7C7F09E83206EDF1756C182D81824EF987542EBBA1244202F0319E', 'd19d6534-e083-4f93-96b9-8499c09dc811');
UPDATE `testFitnesscentrum`.`recepcny` SET id = 0 WHERE id = 1;

-- ma heslo 1111 (8BB4FFE3C9F049BAD909C4C9838B59A3292F1830FD66F10405BC559EB0706EB2)
INSERT INTO `testFitnesscentrum`.`recepcny` (`meno_priezvisko`, `login`, `heslo`, `salt`)
VALUES ('Ferko Nizky','ferko','3A5941FAFEB710CC30E47E9CFA73445A49B4B217CD9A6D6FA4D1FCEF3BAD43FB', '90ab8469-d66b-45fd-83ea-4497b0902413');


INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`) VALUES ('Jan Vysoky', '2016-12-04 11:20:21', '0');
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`,`kredit`,`cislo_permanentky`) VALUES ('Jane Doe', '2016-12-10 18:45:07', '0','50.0','111');
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`,`kredit`,`cislo_permanentky`,`id_kluca`) VALUES ('John Doe', '2016-12-10 18:49:51','1', '100.0','123',2);
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`) VALUES ('Zakaznik na vymazanie', '2016-12-04 11:20:21', '0');
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`) VALUES ('Stale pritomny zakaznik', '2016-12-04 11:20:21', '1');
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`,`kredit`,`cislo_permanentky`) VALUES ('Alf', '2016-12-10 18:45:07', '0','50.0','333');
INSERT INTO `testFitnesscentrum`.`zakaznik` (`meno_priezvisko`, `posledny_prichod`, `pritomny`,`kredit`,`cislo_permanentky`) VALUES ('Melman', '2016-12-10 18:45:07', '0','1.0','666');


UPDATE `testFitnesscentrum`.`kluc` SET id_zakaznika=3 WHERE id_kluca=2;
INSERT INTO `testFitnesscentrum`.`typ_cvicenia` (`nazov`) VALUES ('spinning');

INSERT INTO `testFitnesscentrum`.`cvicenie` (`datum`, `kapacita`, `volne`,`id_instruktora`,`id_typ_cvicenia`) VALUES ('2016-12-24 15:00:00', '10', '10', '1', '1');
INSERT INTO `testFitnesscentrum`.`cvicenie` (`datum`, `kapacita`, `volne`,`id_instruktora`,`id_typ_cvicenia`) VALUES ('2016-12-25 16:00:00', '5', '5', '1', '1');
INSERT INTO `testFitnesscentrum`.`cvicenie` (`datum`, `kapacita`, `volne`,`id_instruktora`,`id_typ_cvicenia`) VALUES ('2016-12-05 17:00:00', '10', '10', '1', '1');

INSERT INTO `testFitnesscentrum`.`rezervacia` (`id_cvicenie`, `id_zakaznik`, `cas_rezervacie`) VALUES (1,2,'2016-12-24 15:00:00');
INSERT INTO `testFitnesscentrum`.`rezervacia` (`id_cvicenie`, `id_zakaznik`, `cas_rezervacie`) VALUES (1,3,'2016-12-23 15:00:00');
INSERT INTO `testFitnesscentrum`.`rezervacia` (`id_cvicenie`, `id_zakaznik`, `cas_rezervacie`) VALUES (2,1,'2016-12-25 15:00:00');





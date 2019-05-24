-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema os_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema os_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `os_db` DEFAULT CHARACTER SET utf8 ;
USE `os_db` ;

-- -----------------------------------------------------
-- Table `os_db`.`os_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `os_db`.`os_status` (
  `sts_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sts_descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sts_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `os_db`.`os_chamado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `os_db`.`os_chamado` (
  `os_id` INT(11) NOT NULL AUTO_INCREMENT,
  `os_descricao` VARCHAR(500) NOT NULL,
  `os_status` INT(11) NOT NULL DEFAULT '1',
  `os_data` DATETIME NOT NULL,
  `os_tipo` INT(11) NOT NULL,
  `os_titulo` VARCHAR(50) NOT NULL,
  `os_usuabertura` VARCHAR(50) NOT NULL,
  `os_analista` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`os_id`),
  CONSTRAINT `os_status_FK`
    FOREIGN KEY (`os_status`)
    REFERENCES `os_db`.`os_status` (`sts_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `os_status_FK` ON `os_db`.`os_chamado` (`os_status` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `os_db`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `os_db`.`perfil` (
  `prf_id` INT(11) NOT NULL AUTO_INCREMENT,
  `prf_ativo` INT(11) NOT NULL,
  `prf_descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`prf_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `os_db`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `os_db`.`usuario` (
  `usu_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usu_ativo` INT(11) NOT NULL,
  `usu_cpf` VARCHAR(255) NOT NULL,
  `usu_email` VARCHAR(255) NULL DEFAULT NULL,
  `usu_login` VARCHAR(255) NOT NULL,
  `usu_nome` VARCHAR(255) NOT NULL,
  `usu_senha` VARCHAR(255) NOT NULL,
  `prf_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`usu_id`),
  CONSTRAINT `FK5B4D8B0E56B5EA44`
    FOREIGN KEY (`prf_id`)
    REFERENCES `os_db`.`perfil` (`prf_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK5B4D8B0E56B5EA44` ON `os_db`.`usuario` (`prf_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `os_db`.`os_interacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `os_db`.`os_interacao` (
  `in_id` INT(11) NOT NULL AUTO_INCREMENT,
  `os_id` INT(11) NOT NULL,
  `usu_id` INT(11) NOT NULL,
  `in_data` DATETIME NOT NULL,
  `in_descricao` BLOB NOT NULL,
  PRIMARY KEY (`in_id`),
  CONSTRAINT `os_id_FK`
    FOREIGN KEY (`os_id`)
    REFERENCES `os_db`.`os_chamado` (`os_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `usu_id_FK`
    FOREIGN KEY (`usu_id`)
    REFERENCES `os_db`.`usuario` (`usu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `os_id_FK` ON `os_db`.`os_interacao` (`os_id` ASC) VISIBLE;

CREATE INDEX `usu_id_FK` ON `os_db`.`os_interacao` (`usu_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

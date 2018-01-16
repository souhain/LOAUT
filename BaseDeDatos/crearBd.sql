-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente2` (
  `idCliente2` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente2`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cuenta2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cuenta2` (
  `idCuenta2` INT NOT NULL AUTO_INCREMENT,
  `saldo` DECIMAL NULL,
  `Cliente2_idCliente2` INT NOT NULL,
  PRIMARY KEY (`idCuenta2`, `Cliente2_idCliente2`),
  INDEX `fk_Cuenta2_Cliente2_idx` (`Cliente2_idCliente2` ASC),
  CONSTRAINT `fk_Cuenta2_Cliente2`
    FOREIGN KEY (`Cliente2_idCliente2`)
    REFERENCES `mydb`.`Cliente2` (`idCliente2`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

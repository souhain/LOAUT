CREATE DEFINER=`root`@`localhost` PROCEDURE `crearTablas`()
BEGIN

	CREATE TABLE IF NOT EXISTS `mydb`.`Cliente2` (
	  `idCliente2` INT NOT NULL AUTO_INCREMENT,
	  `name` VARCHAR(45) NULL,
	  `address` VARCHAR(45) NULL,
	  `email` VARCHAR(100) NULL,
	  `phone` VARCHAR(45) NULL,
	  PRIMARY KEY (`idCliente2`))
	ENGINE = InnoDB;

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

END
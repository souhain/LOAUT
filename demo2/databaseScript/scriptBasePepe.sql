USE `info_banco2` ;

-- -----------------------------------------------------
-- Table `info_banco2`.`cliente2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `info_banco2`.`cliente2` (
  `id_cliente2` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente2`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `info_banco2`.`cuenta2cuenta2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `info_banco2`.`cuenta2` (
  `id_cuenta2` INT NOT NULL AUTO_INCREMENT,
  `saldo` DECIMAL NULL,
  `ejecutive_email` VARCHAR(100) NULL,
  `cliente2_id_cliente2` INT NOT NULL,
  PRIMARY KEY (`id_cuenta2`, `cliente2_id_cliente2`),
  INDEX `fk_cliente2_id_cliente2_idx` (`cliente2_id_cliente2` ASC),
  CONSTRAINT `fk_cuenta2_cliente2`
    FOREIGN KEY (`cliente2_id_cliente2`)
    REFERENCES `info_banco2`.`cliente2` (`id_cliente2`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



  USE `info_banco2`;
  DROP procedure IF EXISTS `insertarCliente`;
  DELIMITER $$
  USE `info_banco2`$$
  CREATE PROCEDURE `insertarCliente`(
    in name VARCHAR(45),
    in address VARCHAR(45),
    in email VARCHAR(100),
    in phone VARCHAR(45) 
  )
  BEGIN
  	insert into cliente2 (name, address, email, phone) values
  		( name,address, email, phone);
  END $$
  DELIMITER ;



  USE `info_banco2`;
  DROP procedure IF EXISTS `insertarCuenta`;

  DELIMITER $$
  USE `info_banco2`$$
  CREATE PROCEDURE `insertarCuenta`(
   saldo DECIMAL,
   cliente2_id_cliente2 INT,
   ejecutive_email VARCHAR(100)
  )
  BEGIN
    insert into cuenta2 (saldo, cliente2_id_cliente2,ejecutive_email) values
    (`saldo`,`cliente2_id_cliente2`,`ejecutive_email`);
  END $$
  DELIMITER ;




  USE `info_banco2`;
  DROP procedure IF EXISTS `SPFinal1`;

  DELIMITER $$
  USE `info_banco2`$$
  CREATE  PROCEDURE `SPFinal1`(
    in name VARCHAR(45),
    in address VARCHAR(45),
    in email VARCHAR(100),
    in phone VARCHAR(45),	
    in saldo DECIMAL,
    in ejecutive_email VARCHAR(100),
    out idClienteOut int,
    out idCuentaOut int,
    out saldoOut decimal
  )
  BEGIN

      set idClienteOut = 0;
      
      
    select id_cliente2 into idClienteOut from cliente2 where (cliente2.name = name and cliente2.address = address and cliente2.email = email and cliente2.phone = phone) limit 1;

    if idClienteOut = 0 then 
      call insertarCliente(name, address, email, phone);
    end if;
      
      select id_cliente2 into idClienteOut from cliente2 where (cliente2.name = name and cliente2.address = address and cliente2.email = email and cliente2.phone = phone) limit 1;

    call insertarCuenta(saldo, idClienteOut,ejecutive_email);
     
   
      select id_cuenta2 into idCuentaOut  from cuenta2 where(
      cuenta2.saldo = saldo and cuenta2.cliente2_id_cliente2 = idClienteOut
      					and cuenta2.ejecutive_email=ejecutive_email
      ) limit 1;
      
      set saldoOut = saldo;
      
      
  END $$
  DELIMITER ;


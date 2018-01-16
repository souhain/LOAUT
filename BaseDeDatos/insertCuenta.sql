CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCuenta`(
`saldo` DECIMAL,
 `Cliente2_idCliente2` INT
)
BEGIN
  insert into cuenta2 (saldo, Cliente2_idCliente2) values
  (`saldo`,`Cliente2_idCliente2`);
END
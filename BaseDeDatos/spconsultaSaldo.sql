CREATE DEFINER=`root`@`localhost` PROCEDURE `consultaSaldo`(
	in idCliente int, 
    in idCuenta int 
)
BEGIN
	select Cliente2_idCliente2, idCuenta2, saldo   from cuenta2 
    where Cliente2_idCliente2 = idCliente AND idCuenta2 = idCuenta;

END
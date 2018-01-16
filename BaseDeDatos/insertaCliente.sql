CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCliente`(
  in name VARCHAR(45),
  in address VARCHAR(45),
  in email VARCHAR(100),
  in phone VARCHAR(45) 
)
BEGIN
	insert into cliente2 (name, address, email, phone) values
		( name,address, email,phone);

END
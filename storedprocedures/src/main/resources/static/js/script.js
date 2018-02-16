/**
 * 
 */
$(document).ready(function() {
	
			function validacampos(arreglo) {
				var validacion = true;
				for (var i = 0; i < arreglo.length; i++) {
					document.getElementById(arreglo[i]).style.border = "1px #00BFFF";
					if (document.getElementById(arreglo[i]).value === "") {
						document.getElementById(arreglo[i]).style.border = "1px solid red";
						validacion = false;
					}
				}
				return validacion;
			}

			function getExpresion(texto, type) {
				if ($.trim(type) === "n") {
					if (!/^([1-9])*$/.exec(texto))
						return true;

					return false;
				} else if ($.trim(type) === "d") {
					if (!/^[1-9]+([.])?([0-9]+)?$/.exec(texto))
						return true;

					return false;
				} else if ($.trim(type) === "c") {
					if (!/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/
							.exec(texto))
						return false;
					return true;
				}
			}

			$("#saldo").keypress(function() {
				if (getExpresion($("#saldo").val(), "d")) {
					$("#saldo").val("");
				}
			});

			$("#phone").keypress(function() {
				if (getExpresion($("#phone").val(), "n")) {
					$("#phone").val("");
				}
			});
			var ejecutivo = "CorreoDefault";
			$("#boton").click(function() {
					var arreglo = [ "name", "address", "email", "phone", "saldo" ];

					if (validacampos(arreglo)) {
							if (getExpresion($("#email").val(), "c")) {
							$("input").prop("disabled", true); // desabilita todos los input
							
							document.getElementById("email").style.border = "1px solid #eee"; // poner el borde de color gris
							
							// objeto JSON que llena los datos con sus campos...
							jsonObj = {
								"name" : $("#name").val(),
								"address" : $("#address").val(),
								"email" : $("#email").val(),
								"phone" : $("#phone").val(),
								"amount" : $("#saldo").val(),
								"excecutive" : ejecutivo
							};
							
							console.log("JSON a enviar: " + JSON.stringify(jsonObj)); //imprime el objeto que se creo

							// configuracion de ajax para envio de datos
							var settings = {
								"async" : true, // es asincrono
								"crossDomain" : true, // politica de seguridad
								"url": "http://localhost:8080/executestored", // url a donde se hara el request
								"method" : "POST", // tipo de entrada 
								"headers" : { // cabeceras del request
									"Content-Type" : "application/json", // tipo de request
									"Cache-Control" : "no-cache", // no generar cache en la consulta
									"Postman-Token" : "f98a90de-0233-e6e9-c02b-1d7b457c3f63" // token de postman
								},
								"processData" : false, // no procesamiento de datos en el envio
								"data" : JSON.stringify(jsonObj) // datos a enviar
							};

							$.ajax(settings).done(function(response) { // envio de datos con ajax con las configuraciones  hechas
								// limpia los campos
								$("#name").val("");
								$("#address").val("");
								$("#email").val("");
								$("#phone").val("");
								$("#saldo").val("");
								console.log(response.numeroCliente);

								// desglosa el response [de tipo objeto]
								/*<p>El response es la respuesta del servidor o del backend que 
								 * te retorna un valor, en este caso, debe de retornar un objeto</p>
								 * response.numeroCliente
								 * response.numeroCuenta
								 * response.saldo
								 * */
								console.log(response);
								$("#la").html("Cliente: "+ response.numeroCliente + " \nCuenta: "  + response.numeroCuenta + " \nSaldo: " + response.saldo);
								var pre = document.createElement('pre');
								//custom style.
								pre.style.maxHeight = "400px";
								pre.style.margin = "0";
								pre.style.padding = "24px";
								pre.style.whiteSpace = "pre-wrap";
								pre.style.textAlign = "justify";
								pre.style.color = "#013ADF";
								pre.appendChild(document.createTextNode($('#la').html()));
								//show as confirm
								alertify.confirm(pre, function(){
								        alertify.success('Ok');
								    }).set({labels:{ok:'Ok'}, padding: false});
								/*
								 * cambiar el contenido del div datos (donde se tiene la imagen)
								 * y los reemplaza por el mensaje con los datos retornados
								 * */
								/*$("#datos").fadeOut("fast",function() {
									$(this).html($("#alerta").html()).slideDown(10);
								});*/
								//console.log(response);
							});

							$("input").prop("disabled", false); // habbilitar los campos nuevamente 
						} else { // si el correo no es valido
							// no envia nada y marca en rojo su borde
							document.getElementById("email").style.border = "1px solid red";
						}
					}
				});

			
});




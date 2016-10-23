function verDatos(){ //redirige a ver datos
    document.verdatos.submit();
}

String.prototype.capitalize = function(){
    return this.replace(/\w+/g, function(a){
        return a.charAt(0).toUpperCase() + a.slice(1).toLowerCase();
    });
};

function copiarAlPortapapeles(id_elemento) {
  var aux = document.createElement("input");
  aux.setAttribute("value", document.getElementById(id_elemento).innerHTML);
  document.body.appendChild(aux);
  aux.select();
  document.execCommand("copy");
  document.body.removeChild(aux);
}

function copia_portapapeles(elemento){ 
    window.clipboardData.setData("Text", document.f1.campo1.value); 
 } 
 
function NoRecomendar(){ //redirige
    document.red.recomendado.value="No";
    document.red.submit();
}

function Redirigir(){ //redirige
    document.red.submit();
}

function Situacion(Situacion,Apaterno,Amaterno,nombre){
    document.red.submit();
    alert("Acabas de agregarle "+Situacion+" a: "+Apaterno+" "+Amaterno+" "+nombre);
}

function Redirigir4(){ //redirige
    document.red.submit();
    alert("Situacion agregada correctamente");
}

function Redirigir5(num){ //redirige
    document.getElementById("red"+num).submit();
    this.buscado.focus();
}

function Redirigir6(){ //redirige
    document.red.submit();
    alert("Situacion eliminada correctamente");
}

function Foto(){ //
    alert("Acabas de seleccionar una foto");
}

function Numero(numero){ //
    if (!/^([0-9])*$/.test(numero)){
       alert("Error: Estas ingresando un valor no numerico en un campo en el que solo se pueden escribir numeros");
       numero="";
    }
}

function Numero2(numero){ //
    if (!/^([0-9])*$/.test(numero)){
       alert("Error: En este campo solo puedes ingresar numeros, si quieres ingresar alguna letra u otra especificacion por favor escribela en el campo \"Información extra sobre tu dirección\" "); 
    }
}

function copiar(){ //
    document.formu.nombre1.value=document.formu.nombre1.value.toLowerCase();
    nombre = document.formu.nombre1.value;
    document.formu.Apaterno.value=document.formu.Apaterno.value.toLowerCase();
    Apaterno = document.formu.Apaterno.value;
    document.formu.Amaterno.value=document.formu.Amaterno.value.toLowerCase();
    Amaterno = document.formu.Amaterno.value;
    document.formu.usuario.value=nombre.substring(0, 3)+ Apaterno.substring(0, 3) + Amaterno.substring(0, 3);
}

function validacionIS(){ //validacion del inicio de sesion
    val=1;
    
    if (document.formu.usuario.value.length===0 || document.formu.usuario.value.length>20){ 
        alert("Tiene que escribir su usuario y no sobrepasar el limite de 20 caracteres");
        document.formu.nombre.focus();
        val= 0; 
    } 
    
    if (document.formu.pass.value.length===0 || document.formu.pass.value.length>30){ 
        alert("Tiene que escribir su contraseña y no sobrepasar el limite de 30 caracteres");
        document.formu.pass.focus();
        val= 0; 
    }
    
    if(val===1){
        document.formu.submit();
    }
}

function validacionR(){ //validacion registro
    val=1;
    
    document.formu.nombre.value=document.formu.nombre.value.capitalize();
    document.formu.Apaterno.value=document.formu.Apaterno.value.capitalize();
    document.formu.Amaterno.value=document.formu.Amaterno.value.capitalize();
    
    if (document.formu.nombre.value.length===0 || document.formu.nombre.value.length>30 || document.formu.nombre.value.length<3){ 
        alert("Error: Tienes que escribir tu nombre, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.nombre.focus();
        val= 0; 
    } 
    
    if (document.formu.Apaterno.value.length===0 || document.formu.Apaterno.value.length>30 || document.formu.Apaterno.value.length<3){ 
        alert("Error: Tienes que escribir tu apellido paterno, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.Apaterno.focus();
        val= 0; 
    } 
    
    if (document.formu.Amaterno.value.length===0 || document.formu.Amaterno.value.length>30 || document.formu.Amaterno.value.length<3){ 
        alert("Error: Tienes que escribir su apellido materno, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.Amaterno.focus();
        val= 0; 
    }
    
    var curp=document.formu.curp.value;
    if(curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9-a-z]{1})([0-9]{1})$/i)){//AAAA######AAAAAA##
    }else{
        alert("Error: CURP no válido.");
        document.formu.curp.focus();
        val= 0;
    }
     
    if (isNaN(parseInt(document.formu.telefono.value)) || document.formu.telefono.value.length!==8) {
       alert("Error: Número de teléfono de casa no válido"); 
       document.formu.telefono.focus();
       val= 0;
    }
    
    if(parseInt(document.formu.peso.value)<20){
        alert("¿En serio pesas menos de 20 kilogramos?"); 
        val= 0;
    }
    if(parseInt(document.formu.peso.value)>150){
        alert("¿En serio pesas más de 150 kilogramos?"); 
        val= 0;
    }
    if (isNaN(parseInt(document.formu.peso.value)) || document.formu.peso.value.length>5) {
        alert("Error: Peso no válido"); 
        document.formu.peso.focus();
        val= 0;
    }
     
     if(parseInt(document.formu.estatura.value)<1){
        alert("¿En serio mides menos de 1 metro?"); 
        val= 0;
    }
    if(parseInt(document.formu.estatura.value)>2.1){
        alert("¿En serio mides más de 2.1 metros?"); 
        val= 0;
    }
    if (isNaN(parseInt(document.formu.estatura.value)) || document.formu.estatura.value.length>4) {
        alert("Error: Estatura no válida"); 
        document.formu.estatura.focus();
        val= 0;
    }
  
    if (document.formu.calle.value.length===0 || document.formu.calle.value.length>40){ 
        alert("Error: Calle no válida (Dirección)");
        document.formu.calle.focus();
        val= 0; 
    }
    
    if (isNaN(parseInt(document.formu.num.value)) || document.formu.num.value.length>4) {
        alert("Error: Número de casa no válido (Dirección)"); 
        document.formu.num.focus();
        val= 0;
    }
     
    if (document.formu.colonia.value.length===0 || document.formu.colonia.value.length>40){ 
        alert("Error: Colonia no válida (Dirección)");
        document.formu.colonia.focus();
        val= 0; 
    } 
    
    if (document.formu.delegacion.value.length===0 || document.formu.delegacion.value.length>40){ 
        alert("Error: Delegación o Municipio no válido (Dirección)");
        document.formu.delegacion.focus();
        val= 0; 
    } 
    
    if (isNaN(parseInt(document.formu.cp.value)) || document.formu.cp.value.length>5) {
        alert("Error: Código Postal no válido (Dirección)"); 
        document.formu.cp.focus();
        val= 0;
    }
    
    if (document.formu.nombreT.value.length===0 || document.formu.nombreT.value.length>30){ 
        alert("Error: Nombre de tutor no válido");
        document.formu.nombreT.focus();
        val= 0; 
    } 
    
    if (document.formu.ApaternoT.value.length===0 || document.formu.ApaternoT.value.length>30){ 
        alert("Error: Apellido paterno de tutor no válido");
        document.formu.ApaternoT.focus();
        val= 0; 
    } 
    
    if (document.formu.AmaternoT.value.length===0 || document.formu.AmaternoT.value.length>30){ 
        alert("Error: Apellido materno de tutor no válido");
        document.formu.AmaternoT.focus();
        val= 0; 
    }
    
    if (isNaN(parseInt(document.formu.telefonoT.value)) || document.formu.telefonoT.value.length!==8) {
       alert("Error: Número de trabajo de tutor no válido"); 
       document.formu.telefonoT.focus();
       val= 0;
    }
    
    if (isNaN(parseInt(document.formu.celularT.value)) || document.formu.celularT.value.length!==10) {
       alert("Error: Número de celular de tutor no válido"); 
       document.formu.celularT.focus();
       val= 0;
    }
    
    if(val===1){
        document.formu.submit();
    }
     
}

function validacionRU(){ //validacion registro de personal
    val=1;
    
    if (document.formu.nombre1.value.length===0 || document.formu.nombre1.value.length>30 || document.formu.nombre1.value.length<3){ 
        alert("Error: Tienes que escribir tu nombre, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.nombre1.focus();
        val= 0; 
    } 
    
    if (document.formu.Apaterno.value.length===0 || document.formu.Apaterno.value.length>30 || document.formu.Apaterno.value.length<3){ 
        alert("Error: Tienes que escribir tu apellido paterno, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.Apaterno.focus();
        val= 0; 
    } 
    
    if (document.formu.Amaterno.value.length===0 || document.formu.Amaterno.value.length>30 || document.formu.Amaterno.value.length<3){ 
        alert("Error: Tienes que escribir su apellido materno, minimo 3 caracteres, maximo 30 caracteres");
        document.formu.Amaterno.focus();
        val= 0; 
    }
    
    if(document.formu.curp.value.length>18){//AAAA######AAAAAA##
        alert("Error: CURP no válido.");
        document.formu.curp.focus();
        val= 0;   
    }
    
    if(parseInt(document.formu.cp.value)>0){
        if((!/^([0-9])*$/.test(document.formu.cp.value)) || document.formu.cp.value.length!==5){
           alert("Error: El codigo postal que ingresaste no es valido" ); 
           document.formu.cp.focus();
           val= 0;
        }
    }
    
    if(parseInt(document.formu.num.value)>0){
        if(isNaN(parseInt(document.formu.num.value)) || document.formu.num.value.length>4){
           alert("Error: El numero que ingresaste no es valido" ); 
           document.formunumcp.focus();
           val= 0;
        }
    }

    if(parseInt(document.formu.celular.value)>0){
        if (isNaN(parseInt(document.formu.celular.value)) || document.formu.celular.value.length!==10) {
            alert("Error: Número de celular NO valido"); 
            document.formu.celular.focus();
            val= 0;
         }
    }
    
    if(parseInt(document.formu.telefono.value)>0){
        if (isNaN(parseInt(document.formu.telefono.value)) || document.formu.telefono.value.length!==8) {
            alert("Error: Número de telefono NO valido"); 
            document.formu.telefono.focus();
            val= 0;
         }
    }

   if (document.formu.pass.value.length===0 || document.formu.pass.value.length>30){ 
        alert("Error: Password no valido");
        document.formu.pass.focus();
        val= 0; 
    }
   
    
   
    if(val===1){
        document.formu.submit();
    }
     
}


function validaInfoByCurp(curp) {
    
	if (!curp === "") {

		if (!curp==="") {
			adminCalificaciones.consultaCalificacionesCicloActual(curp, {
				callback : function(resultado) {

					if (resultado == null) {
						mostrarDiv('id_ventana_aviso_mantenimiento');
						ocultarDiv('id_jsp_buscar_aspirante');
					} else {
						if (resultado.evaluacionesRegulares != null) {
							llenaTablaCicloActual(resultado);
						} else {
							mostrarDiv('id_ventana_error_buscar_aspirante');
						}
					}
				},
				async : false
			});
		}

		else {

			document.getElementById('etiqueta_curp_invalido_buscar_aspirantes').innerHTML = resultadoValidaEstructuraCurp.mensaje;
			cambiaColorBorder(cajaTexto_Curp);
			mostrarLabel('etiqueta_curp_invalido_buscar_aspirantes');
			cambiaColorFont('id_error_busqueda_curp');
		}
	}
}


/* 
function validaInfoByCurp() {
	var curp="";
	curp = cajaTexto_Curp.value;
	regresaColorBorder(cajaTexto_Curp);
	ocultarLabel('etiqueta_curp_buscar_aspirantes');
	ocultarLabel('etiqueta_curp_invalido_buscar_aspirantes');
	ocultarDiv('id_ventana_error_buscar_aspirante');
	regresaColorFont('id_error_busqueda_curp');

	if (curp == "") {
		cambiaColorBorder(cajaTexto_Curp);
		mostrarLabel('etiqueta_curp_buscar_aspirantes');
		cambiaColorFont('id_error_busqueda_curp');
	}

	else {

		var resultadoValidaEstructuraCurp = validaCurp('id_cajaTexto_curp_buscar_aspirante');

		if (resultadoValidaEstructuraCurp.success) {
			adminCalificaciones.consultaCalificacionesCicloActual(curp, {
				callback : function(resultado) {

					if (resultado == null) {
						mostrarDiv('id_ventana_aviso_mantenimiento');
						ocultarDiv('id_jsp_buscar_aspirante');
					} else {
						if (resultado.evaluacionesRegulares != null) {
							llenaTablaCicloActual(resultado);
						} else {
							mostrarDiv('id_ventana_error_buscar_aspirante');
						}
					}
				},
				async : false
			});
		}

		else {

			document.getElementById('etiqueta_curp_invalido_buscar_aspirantes').innerHTML = resultadoValidaEstructuraCurp.mensaje;
			cambiaColorBorder(cajaTexto_Curp);
			mostrarLabel('etiqueta_curp_invalido_buscar_aspirantes');
			cambiaColorFont('id_error_busqueda_curp');
		}
	}
}

function ga(a){
    var b=4,c="n",d=null;a&&((d=a.match(/(normal|oblique|italic)/i))&&d[1]&&(c=d[1].substr(0,1).toLowerCase()),(d=a.match(/([1-9]00|normal|bold)/i))&&d[1]&&(/bold/i.test(d[1])?b=7:/[1-9]00/.test(d[1])&&(b=parseInt(d[1].substr(0,1),10))));
    return c+b;
}

*/
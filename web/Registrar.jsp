<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Clases.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="Clases.AvisosDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Avisos"%>
<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession"%>
<%@page import = "java.io.*"%>
<%@page import = "javax.servlet.*"%>  
<%@page import = "javax.servlet.http.*"%>

<%
    int Estado=12; 
    Connection con = DB.getConnection();
    Statement sentencia=con.createStatement();
    String query = "call VerPermiso(1);";
    ResultSet resultados = sentencia.executeQuery(query); 
    if(resultados.next()){
        Estado=resultados.getInt("Estado");
    }
    con.close();
    Usuario h = new Usuario();
    String tipo=null;
    String nombre=null;
    String sexo=null;
    String id=null;
    try {
        h = ((Usuario) session.getAttribute("user"));
        nombre = h.getNombre();
        sexo = h.getSexo();
        tipo = h.getTipo();
        id = h.getId();
    } catch (Exception e) {
        e.printStackTrace();
    }
    AvisosDAO  av= new AvisosDAO();
    ArrayList<Avisos> p = (ArrayList)av.DesplegarAvisos();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Registrar Alumno">
    <meta name="author" content="Gerardo Arceo">
    <title>Registrate</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
</head><!--/head-->

<body class="homepage">
    <header>
        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Navegacion</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Inicio</a></li>
                        <li><a href="Secundaria120.jsp">Secundaria 120</a></li>
                        <li><a href="CuadroHonor.jsp">Cuadro de Honor</a></li>
                        <li><a href="Informacion.jsp">Información</a></li>
                        <%
                            
                        try {
                            if (!nombre.equals(null)) {%>
                                <li><a href="<%= tipo%>.jsp">Menú</a></li><%
                            }
                        } catch (Exception e) {%>
                            <li class="nivel1">Menú</li>
                        <%}%>                   
                        
                        <%
                        try {
                            if (!nombre.equals(null)) {%>
                            
                            <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%out.print("Hola " + nombre);%> <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <form method="post" action="<%= tipo %>" name="verdatos">
                                    <input type="hidden" name="id<%= tipo %>" value="<%= id%>">
                                    <input type="hidden" name="nombre" value="<%= nombre%>">
                                    <input type="hidden" name="sexo" value="<%= sexo%>">
                                    <input type="hidden" name="opc"  value="1"></form>
                               <li><a href="#" onClick="verDatos()">Ver mis datos</a></li>
                               <li><a href="CerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                        <%}
                        } catch (Exception e) {%>
                            <li class="nivel1"><a href="InicioSesion.jsp">Inicia Sesión</a></li>
                        <%}%>                   
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->		
    </header><!--/header-->
    <%if (id==null){%>
    <%if (Estado==1){%>
    <section id="contact-page">
        <div class="container">
            <div class="center"> 
                <br>
                <h2>Registrate</h2>
                <p class="lead">Si no tienes usuario por favor registrate a continuacion :)</p>
                <p class="lead">Nota: Los campos marcados con un asterisco son OBLIGATORIOS</p>
            </div> 
            <div class="row contact-wrap"> 
                <div class="status alert alert-success" style="display: none"></div>
                
                <form id="main-contact-form" class="contact-form" name="formu" method="post" action="Registrar" enctype="multipart/form-data">
                    <div class="col-sm-5 col-sm-offset-1">
                        
                        <fieldset>
                        <h2>Datos Personales</h2>
                        <div class="form-group">
                            <label>Nombre(s) <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="nombre" title="Debes de ingresar tu nombre" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" class="form-control" size="30"/>
                        </div>
                        <div class="form-group">
                            <label>Apellido Paterno <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="Apaterno" class="form-control" style="text-transform:capitalize" size="30">
                        </div>
                        <div class="form-group">
                            <label>Apellido Materno <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="Amaterno" class="form-control" style="text-transform:capitalize" size="30">
                        </div>
                        <div class="form-group">
                            <label>Grado</label>
                            <select name="ano">
                                <option value="1">1º</option>
                                <option value="2">2º</option>
                                <option value="3">3º</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Grupo</label>
                            <select name="grupo">
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="C">C</option>
                                <option value="D">D</option>
                                <option value="E">E</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Sexo</label>
                            <select name="sexo">
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Fecha de nacimiento</label>
                            <input type="date" name="nacimiento" min="2000-01-01" max="2015-01-01" value="2000-01-01" class="form-control">
                        </div>        
                        <div class="form-group">
                            <label>CURP <i class="fa fa-asterisk"></i> <a href="https://consultas.curp.gob.mx/CurpSP/" target="_blank">¿No te lo sabes?</a></label>
                            <input type="text" name="curp" class="form-control" required="required" size="18" onkeyup="javascript:this.value=this.value.toUpperCase();" placeholder="AAAA######AAAAAA##">
                        </div>
                        <div class="form-group">
                            <label>E-Mail</label>
                            <input type="email" name="email" class="form-control" required="required" size="40" placeholder="alumno@correo.com">
                        </div>
                        <div class="form-group">
                            <label>Celular</label>
                            <input type="text" name="celular" class="form-control" size="12" onkeyup="Numero(this.value);" placeholder="5512345678">
                        </div>
                        <div class="form-group">
                            <label>Telefono de casa <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="telefono" class="form-control" onkeyup="Numero(this.value);" size="10" placeholder="55123456">
                        </div><br><br>
                        </fieldset>
                        
                        <fieldset>
                            <h2>Datos Medicos</h2>
                        <div class="form-group">
                            <label>Peso <i class="fa fa-asterisk"> (En kilogramos)</i></label>
                            <input type="text" name="peso" class="form-control" size="10" placeholder="65.5">
                        </div>
                        <div class="form-group">
                            <label>Estatura <i class="fa fa-asterisk"> (En metros)</i></label>
                            <input type="text" name="estatura" class="form-control" size="10" placeholder="1.65">
                        </div> 
                        <div class="form-group">
                            <label>¿Necesitas lentes?</label><br>
                            <select name="lentes">
                                <option value="s">Si</option>
                                <option selected value="n">No</option>
                            </select><br><br>
                        </div>
                        <div class="form-group">
                        <label>¿Necesitas zapatos ortopedicos?</label><br>
                            <select name="zapatos">
                                <option value="s">Si</option>
                                <option selected value="n">No</option>
                            </select><br><br>
                        </div>
                        <div class="form-group">
                        <label>¿Tienes dificultades auditivas?</label><br>
                            <select name="auditivo">
                                <option value="s">Si</option>
                                <option selected value="n">No</option>
                            </select><br><br>
                        </div>
                        <div class="form-group">
                            <label>¿Tienes algún comentario sobre tu salud o persona?</label>
                            <textarea name="comentarioAlu" id="message" required="required" placeholder="(Ej.Alergia al cacahuate, dificultad para leer, extremadamente introvertido y/o timido)" class="form-control" rows="8"></textarea>
                        </div> 
                        <div class="form-group">
                            <label>Afiliación Médica</label><br>
                            <select name="afiliacion">
                                <option value="ISSSTE">ISSSTE</option>
                                <option value="IMSS">IMSS</option>
                                <option value="Otro">Otro</option>
                                <option selected value="Ninguno">Ninguno</option>
                            </select><br><br>
                        </div> 
                            <br>
                        <h2>Fotografía</h2>
                        <input type="file" onchange="Foto()" name="foto"/><br> 
                        </fieldset><br><br>
                    </div>
  
                    <div class="col-sm-5">
                        <fieldset>
                        
                        <h2>Dirección</h2>
                        <div class="form-group">
                            <label>Calle <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="calle" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="40" placeholder="Calzada del Maestro Rural">
                        </div>
                        <div class="form-group">
                            <label>Número <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="num" class="form-control" onkeyup="Numero2(this.value);" required="required" size="4" placeholder="57">
                        </div>
                        <div class="form-group">
                            <label>Colonia <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="colonia" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="40" placeholder="Un Hogar Para Nosotros">
                        </div>
                        <div class="form-group">
                            <label id="lab" name="lab">Delegación o Municipio <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="delegacion" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="40" placeholder="Miguel Hidalgo">
                        </div>
                        <div class="form-group">
                        <label>Estado</label>
                            <select name="estado">
                                <option value="Ciudad de Mexico">Ciudad de México</option>
                                <option value="Estado de Mexico">Estado de México</option>
                                <option value="Otro">Otro</option>
                            </select><br><br>
                        </div>
                        <div class="form-group">
                            <label>Código Postal <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="cp" class="form-control" onkeyup="Numero(this.value);" required="required" size="5" placeholder="11340">
                        </div>
                        <div class="form-group">
                            <label>Información extra sobre tu dirección</label>
                            <textarea name="comentarioDir" id="message" placeholder="(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)" required="required" class="form-control" rows="8"></textarea>
                        </div>
                        </fieldset><br><br>
                        
                        <fieldset>
                        <h2>Datos de Tutor</h2>
                        <div class="form-group">
                            <label>Parentesco con el alumno</label>
                            <select name="parentesco">
                                <option value="Madre">Madre</option>
                                <option value="Padre">Padre</option>
                                <option value="Tio o tia">Tio o tia</option>
                                <option value="Abuelo o abuela">Abuelo o abuela</option>
                                <option value="Otro">Otro</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="nombreT" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="30">
                        </div>
                        <div class="form-group">
                            <label>Apellido Paterno <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="ApaternoT" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="30">
                        </div>
                        <div class="form-group">
                            <label>Apellido Materno <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="AmaternoT" class="form-control" onkeyup="javascript:this.value=this.value.toLowerCase();" style="text-transform:capitalize;" required="required" size="30">
                        </div> 
                        <div class="form-group">
                            <label>Sexo</label>
                            <select name="sexoT">
                                <option value="Masculino">Masculino</option>
                                <option selected value="Femenino">Femenino</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Fecha de nacimiento</label>
                            <input type="date" name="nacimientoT" min="1900-01-01" max="2010-01-01" value="1990-01-01" class="form-control">
                        </div>        
                        <div class="form-group">
                            <label>CURP</label>
                            <input type="text" name="curpT" class="form-control" style="text-transform:uppercase;" onkeyup="javascript:this.value=this.value.toUpperCase();" required="required" size="18" placeholder="AAAA######AAAAAA##">
                        </div>
                        <div class="form-group">
                            <label>E-Mail</label>
                            <input type="email" name="emailT" class="form-control" required="required" size="40" placeholder="tutor@correo.com">
                        </div>
                        <div class="form-group">
                            <label>Celular <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="celularT" onkeyup="Numero(this.value);" class="form-control" size="12" placeholder="5512345678">
                        </div>
                        <div class="form-group">
                            <label>Telefono del trabajo <i class="fa fa-asterisk"></i></label>
                            <input type="text" name="telefonoT" onkeyup="Numero(this.value);" class="form-control" size="10" placeholder="55123456">
                        </div>
                        <div class="form-group">
                            <label>¿Con quién vive el alumno?</label><br>
                            <select name="vive">
                                <option value="Padre">Padre</option>
                                <option selected value="Madre">Madre</option>
                                <option value="Ambos">Ambos</option>
                                <option value="Otro">Otro</option>
                            </select><br><br>
                        </div> 
                        </fieldset>
                        
                        <br><br><br>
                    </div>
                    
                    <div class="form-group center">
                        <button type="button" class="btn btn-primary btn-lg" required="required" onclick="validacionR()">Registrar Alumno</button> 
                    </div>
                </form>
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#contact-page-->
    <%}else{%>
        <div class="center"> 
            <br><br><br><br><br><br><br><br>
            <h2>Oh, no :(</h2>
            <p class="lead">Los sentimos, ya se han cerrado las inscripciones para alumnos</p>
        </div> 
        <br><br><br><br><br><br><br><br><br><br><br>
    <%}%>
    <%}else{%>
        <div class="center"> 
            <br><br><br><br><br><br><br><br>
            <h2>No puedes registrarte</h2>
            <p class="lead">Ya tienes una sesión iniciada, cierrala primero por favor</p>
        </div> 
        <br><br><br><br><br><br><br><br><br><br><br>
    <%}%>
    
<footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2016 <a target="_blank" title="Desarrollo web">By Gerardo Arceo</a>. <i class="fa fa-code"></i>
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <a href="Politica.jsp">Política de privacidad</a>  
                        <li>Se feliz</li>
                        <li><a id="gototop" class="gototop" href="#"><i class="fa fa-arrow-up"></i></a></li><!--#gototop-->
                    </ul>
                </div>
                
            </div>
        </div>
    </footer><!--/#footer-->

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/wow.min.js"></script>
</body>
</html>
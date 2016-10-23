<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Avisos"%>
<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession"%>
<%@page import = "java.io.*"%>
<%@page import = "javax.servlet.*"%>  
<%@page import = "javax.servlet.http.*"%>
<%
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
        id= h.getId();
    } catch (Exception e) {
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Error</title>

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
    <br><br><br><br><br><br><br><br><br><br>
<section id="error" class="container text-center">
        <h1>ERROR 500</h1><br><br><br><br>
        <p>Ha habido un error con el servidor, es posible que tu sesión se haya cerrado, prueba ir al menú principal y volver a ingresar</p>
        <br><br><br><br><a class="btn btn-primary" href="InicioSesion.jsp">Iniciar Sesión</a>
    </section><!--/#error-->
    <br><br><br><br><br><br><br><br><br><br><br>
    
    <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2016 <a target="_blank" title="Desarrollo web">By Gerardo Arceo</a>. <i class="fa fa-code"></i>
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
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
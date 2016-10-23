<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Docente</title>

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
        
        <script>
            function opc1(){
                document.getElementById('opc').value=1;
                document.formu.submit();
            }
            function opc2(){
                document.getElementById('opc').value=2;
                document.formu.submit();
            }
            function opc3(){
                document.getElementById('opc').value=3;
                document.formu.submit();
            }
            function opc4(){
                document.getElementById('opc').value=4;
                document.formu.submit();
            }
        </script>
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

    <%if(h.getTipo().equals("Docente")){%>
<br><br><br><br>
    <div class="container">
        <div class="center">
            <h2><br>
                <%if(h.getSexo().equals("Masculino")){
                out.print("Bienvenido profesor " + nombre);
            }else{
                if(h.getSexo().equals("Femenino")){
                    out.print("Bienvenida profesora " + nombre);
                }else{
                    out.print("Bienvenid@ profesor@ " + nombre);
                }
            }
            %>
            </h2><hr>
            <h2>
                <form name="fecha" action="Director" method="POST">
                    <input type="hidden" name="idDirector" value="<%= id%>">
                     <input type="hidden" name="nombre" value="<%= nombre%>">
                     <input type="hidden" name="sexo" value="<%= sexo%>">
                     <input type="hidden" name="opc" value="8">
                     <input type="date" name="fecha" id="fecha" value="<%= fecha%>" onblur="submit()">
                </form>
            </h2>
                <br><br><br>
        </div>
        <div class="row">
             <ul class="navbar-static-top text-center">
                 <form name="formu" action="Docente" method="post">
                     <input type="hidden" name="idDocente" value="<%= id%>">
                     <input type="hidden" name="nombre" value="<%= nombre%>">
                     <input type="hidden" name="sexo" value="<%= sexo%>">
                     <input type="hidden" name="opc" id="opc" value="1">
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #57041B" onclick="opc2()">Mis puntuaciones</button>
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #D02D00" onclick="opc3()">Agregar incidencia</button>
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #57041B" onclick="opc4()">Buscar Alumno</button>
                 </form>
             </ul>
        </div><br><br><br>
<br><br><br><br>
    <%}else{%>
        <h1>ERROR: No tienes permiso para estar en esta pagina</h1>
    <%}%>

    </div>
    <br><br><br><br><br><br>
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
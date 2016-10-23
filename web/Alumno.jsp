<%@page import="java.sql.ResultSet"%>
<%@page import="Clases.DB"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario h = new Usuario();
    String tipo=null;
    String nombre=null;
    String sexo=null;
    String id=null;
    int monedas=0;
    String nombreT="";
    String ApaternoT="";
    String Parentesco="";
    String SexoT="";
    try {
        h = ((Usuario) session.getAttribute("user"));
        nombre = h.getNombre();
        sexo = h.getSexo();
        tipo = h.getTipo();
        id= h.getId();
    } catch (Exception e) {
        e.printStackTrace();
    }
    Connection con = DB.getConnection();
    Statement sentencia=con.createStatement();
    Statement sentencia2=con.createStatement();
    Statement sentencia3=con.createStatement();
    String query = "call VerMonedasId("+id+");";
    String query2 = "call VerTutor("+id+");";
    String query3 = "call VerDatos("+id+")";
    ResultSet resultados = sentencia.executeQuery(query); 
    ResultSet resultados2 = sentencia2.executeQuery(query2); 
    ResultSet resultados3 = sentencia3.executeQuery(query3);    
    if(resultados.next()){
        monedas=resultados.getInt(1);
    }
    if(resultados2.next()){
        nombreT=resultados2.getString("Nombre");
        ApaternoT=resultados2.getString("Apaterno");
        Parentesco=resultados2.getString("Parentesco");
        SexoT=resultados2.getString("Sexo");    
    }
    String curp = "";
    if(resultados3.next()){
        curp=resultados3.getString("curp");
    }
    con.close();
    
    nombreT=h.capitalizar(nombreT);
    ApaternoT=h.capitalizar(ApaternoT);
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Gerardo Arceo">
        <title>Alumno</title>

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
                document.getElementById('opc2').value=4;
                document.formu2.submit();
            }
            function opc5(){
                document.getElementById('opc').value=5;
                document.formu.submit();
            }
            function opc6(){
                document.getElementById('opc2').value=6;
                document.formu2.submit();
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

    <%if(h.getTipo().equals("Alumno")){%>
<br><br><br><br>
    <div class="container">
        <div class="center">
            <h2><br>
            <%
                if (SexoT.equals("Masculino")){
                    out.println("<p>Bienvenido ");
                }else if(SexoT.equals("Femenino")){
                    out.println("<p>Bienvenida ");
                }else{
                    out.println("<p>Bienvenid@ ");
                }
                
                if(Parentesco.equals("Padre")){
                    out.print("papá ");
                }else if(Parentesco.equals("Madre")){
                    out.println("mamá ");
                }else{
                    out.print("tutor ");
                }

                out.println(nombreT + " " + ApaternoT);
            %>
            </div>
            <p id="pw" hidden="true"><%= curp%></p>
        <div class="row">
             <ul class="navbar-static-top text-center">
                 <form name="formu" action="Alumno" method="post">
                     <input type="hidden" name="idAlumno" value="<%= id%>">
                     <input type="hidden" name="nombre" value="<%= nombre%>">
                     <input type="hidden" name="sexo" value="<%= sexo%>">
                     <input type="hidden" name="opc" id="opc" value="1">
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #9932CC" onclick="opc5()">Faltas y Retardos</button>
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #DC143C" onclick="opc3()">Conducta</button>
                     <a target="_blank" href="http://comunidadescolar.sepdf.gob.mx:8024/ConsultaCalificaciones/index.jsp" class="btn btn-primary btn-lg" style="background-color: #1E90FF" onclick="copiarAlPortapapeles('pw');">Calificaciones</a>
                 </form>
             </ul>
         </div>
                     <br><br><hr><br><br>
                     
        <div class="container">
            <div class="center"><h2>
            <%if(h.getSexo().equals("Masculino")){
                out.print("Bienvenido " + nombre);
            }else{
                if(h.getSexo().equals("Femenino")){
                    out.print("Bienvenida " + nombre);
                }else{
                    out.print("Bienvenid@ " + nombre);
                }
            }
            %>
            </h2><br><h2><i class="fa fa-money"></i>
                <span style="color:#FF8C00">C</span><span style="color:#FFA500">r</span><span style="color:#FF8C00">é</span><span style="color:#FFA500">d</span><span style="color:#FF8C00">i</span><span style="color:#FFA500">t</span><span style="color:#FF8C00">o</span><span style="color:#FFA500">s</span><span style="color:#FF8C00">: </span>
                <span style="color:#008000"><%out.print(monedas);%> </span><i class="fa fa-money"></i></h2>
            </div>
        </div>
        <div class="row">
             <ul class="navbar-static-top text-center">
                 <form name="formu2" action="Alumno" method="post">
                     <input type="hidden" name="idAlumno" value="<%= id%>">
                     <input type="hidden" name="nombre" value="<%= nombre%>">
                     <input type="hidden" name="sexo" value="<%= sexo%>">
                     <input type="hidden" name="opc" id="opc2" value="1">
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #32CD32" onclick="opc4()">Calificar Profesores</button>
                     <button type="button" class="btn btn-primary btn-lg" style="background-color: #2F4F4F" onclick="opc6()">Denuncia Anónima</button>
                 </form>
             </ul>
         </div>
    </div>

    <%}else{%>
        <h1>ERROR: No tienes permiso para estar en esta pagina</h1>
    <%}%>

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
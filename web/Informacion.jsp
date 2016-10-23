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
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Información</title>

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
    <script src='http://www.google.com/jsapi'></script>
    <script>
    google.load("prototype","1.7.0.0");
    google.load("scriptaculous", "1.9.0");
    </script>
    <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
    <script type="text/javascript">
        function mostrar1(){
            document.getElementById('oculto1').style.display = 'block';
            document.getElementById('mostrado1').style.display='none';
        }
        function ocultar1(){
            document.getElementById('mostrado1').style.display = 'block';
            document.getElementById('oculto1').style.display='none';
        }

        function mostrar2(){
            document.getElementById('oculto2').style.display = 'block';
            document.getElementById('mostrado2').style.display='none';
        }
        function ocultar2(){
            document.getElementById('mostrado2').style.display = 'block';
            document.getElementById('oculto2').style.display='none';
        }
        
        function mostrar3(){
            document.getElementById('oculto3').style.display = 'block';
            document.getElementById('mostrado3').style.display='none';
        }
        function ocultar3(){
            document.getElementById('mostrado3').style.display = 'block';
            document.getElementById('oculto3').style.display='none';
        }
        
        function mostrar4(){
            document.getElementById('oculto4').style.display = 'block';
            document.getElementById('mostrado4').style.display='none';
        }
        function ocultar4(){
            document.getElementById('mostrado4').style.display = 'block';
            document.getElementById('oculto4').style.display='none';
        }
        
        function mostrar5(){
            document.getElementById('oculto5').style.display = 'block';
            document.getElementById('mostrado5').style.display='none';
        }
        function ocultar5(){
            document.getElementById('mostrado5').style.display = 'block';
            document.getElementById('oculto5').style.display='none';
        }
        
        function mostrar6(){
            document.getElementById('oculto6').style.display = 'block';
            document.getElementById('mostrado6').style.display='none';
        }
        function ocultar6(){
            document.getElementById('mostrado6').style.display = 'block';
            document.getElementById('oculto6').style.display='none';
        }
        
        function mostrar7(){
            document.getElementById('oculto7').style.display = 'block';
            document.getElementById('mostrado7').style.display='none';
        }
        function ocultar7(){
            document.getElementById('mostrado7').style.display = 'block';
            document.getElementById('oculto7').style.display='none';
        }
        
        function mostrar8(){
            document.getElementById('oculto8').style.display = 'block';
            document.getElementById('mostrado8').style.display='none';
        }
        function ocultar8(){
            document.getElementById('mostrado8').style.display = 'block';
            document.getElementById('oculto8').style.display='none';
        }
        
        function mostrar9(){
            document.getElementById('oculto9').style.display = 'block';
            document.getElementById('mostrado9').style.display='none';
        }
        function ocultar9(){
            document.getElementById('mostrado9').style.display = 'block';
            document.getElementById('oculto9').style.display='none';
        }
        
        function mostrar10(){
            document.getElementById('oculto10').style.display = 'block';
            document.getElementById('mostrado10').style.display='none';
        }
        function ocultar10(){
            document.getElementById('mostrado10').style.display = 'block';
            document.getElementById('oculto10').style.display='none';
        }
        
        function mostrar11(){
            document.getElementById('oculto11').style.display = 'block';
            document.getElementById('mostrado11').style.display='none';
        }
        function ocultar11(){
            document.getElementById('mostrado11').style.display = 'block';
            document.getElementById('oculto11').style.display='none';
        }
    </script>
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

    <section id="about-us">
      
        <div class="container">
            <div class="center">
                <div class="center wow fadeInDown">
                    <h2>Preguntas Frecuentes...</h2><br><br>
                    
                    
                    <div id="mostrado1"><p class="lead" onclick="mostrar1()"><a><strong>¿Que es ésta página web? <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto1" style='display:none;'><p onclick="ocultar1()"><a>¿Que es ésta página web? <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        El sitio en donde usted está navegando en este momento, es en realidad una aplicación web, que, a diferencia de una simple página web, ésta permite interactuar con el usuario de distintas formas, la aplicación fue desarrollada especial y exclusivamente para la Secundaria Diurna N°120, “Rosario Castellanos”, turno matutino, con el fin de aprovechar toda la tecnología que existe actualmente, convirtiendo así a esta secundaria en una escuela que está a la vanguardia tecnológica, permitiéndole gozar de todos los beneficios de los recursos digitales.
                    </p><p onclick="ocultar1()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>

                    <br><br><br>
                    
                    <div id="mostrado2"><p class="lead" onclick="mostrar2()"><a><strong>¿Para qué se desarrolló esta aplicación web? <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto2" style='display:none;'><p onclick="ocultar2()"><a>¿Para qué se desarrolló esta aplicación web? <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        Esta aplicación web forma parte del sistema SIPREDE, que por sus siglas significa “Sistema Integral de Prevención de la Deficiencia Escolar”, fue desarrollada principalmente para que los padres de familia y/o tutores de los alumnos, puedan llevar un correcto seguimiento de las actividades académicas desarrolladas por su hijo o hija en la escuela, día con día, lamentablemente existen múltiples causas por las cuales un alumno puede tener deficiencia en la escuela, afortunadamente, el apoyo continuo y oportuno de los padres o tutores en casa, puede reducir drásticamente esta situación.
                        </p><p onclick="ocultar2()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
                    
                    <div id="mostrado3"><p class="lead" onclick="mostrar3()"><a><strong>¿Quiénes participan en este sistema digital? <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto3" style='display:none;'><p onclick="ocultar3()"><a>¿Quiénes participan en este sistema digital? <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        TODA la Comunidad Escolar, muchas veces se piensa erróneamente que la conforman solamente los profesores y los alumnos, sin embargo, la integramos TODOS los que influimos de alguna manera en los resultados educativos de los alumnos de la escuela.<br>
                        La Comunidad Escolar está conformada por el alumnado, padres de familia, profesores, personal de apoyo, personal administrativo y directivo, todos ellos deben de trabajar de manera colaborativa para lograr un objetivo en común, formar una educación de calidad e integral en todos los ámbitos de nuestros jóvenes alumnos, para que tengan un futuro prometedor.
                    </p><p onclick="ocultar3()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
                    
                    <h2>¿Qué puedo hacer en la aplicación si soy…?</h2><br>
                    
                    <p class="lead">
                        Lo que se puede hacer en esta aplicación web, depende del rol que se tenga dentro de la Comunidad Escolar, todos desempeñamos un distinto trabajo, sin embargo, todos trabajamos y colaboramos juntos por un mismo fin, el éxito de nuestros alumnos.
                    </p><br>
                    
                    <div id="mostrado11"><p class="lead" onclick="mostrar11()"><a><strong>Padre de familia o tutor <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto11" style='display:none;'><p onclick="ocultar11()"><a>Padre de familia o tutor <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-heart"></i></a> Puedo ver las asistencias y puntualidad de mi hijo o hija todos los días laborales del ciclo escolar.<br><br>
                        <a><i class="fa fa-heart"></i></a> Puedo ver las calificaciones por periodo de evaluación e inclusive de ciclos escolares anteriores.<br><br>
                        <a><i class="fa fa-heart"></i></a> Puedo enterarme de su comportamiento diariamente y de incidencias médicas cuando estas ocurran. 
                    </p><p onclick="ocultar11()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
                    
                    <div id="mostrado5"><p class="lead" onclick="mostrar5()"><a><strong>Estudiante <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto5" style='display:none;'><p onclick="ocultar5()"><a>Estudiante <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-pencil"></i></a> Puedo ver la misma información que mi padre o tutor.<br><br>
                        <a><i class="fa fa-pencil"></i></a> Puedo denunciar anónimamente a algún compañero que tenga conductas inadecuadas como: bullying, robo, consumo o venta de sustancias ilegales, etc. El personal de apoyo a la docencia y directivo investigarán cada denuncia y en caso de ser necesario, se hablará con el indiciado y con sus padres y si resultase responsable recibirá la sanción correspondiente, cuidando siempre el anonimato e integridad de todo el alumnado.<br><br>
                        <a><i class="fa fa-pencil"></i></a> Puedo hacer una pequeña evaluación sobre los profesores que me imparten clases, esto únicamente es con el fin de que mis profesores se enteren de la opinión de sus alumnos, esta calificación es un parámetro que permitirá que cada docente haga una reflexión sobre su desempeño profesional, y en ningún caso conocerá la opinión individual de un alumno, únicamente la percepción global, esto contribuye a su rendición de cuentas que todo servidor público debe realizar.
                    </p><p onclick="ocultar5()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                   
                    <br><br><br>
                    
                    <div id="mostrado6"><p class="lead" onclick="mostrar6()"><a><strong>Profesor <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto6" style='display:none;'><p onclick="ocultar6()"><a>Profesor <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-edit"></i></a> Si eres un profesor, puedes enterarte de las opiniones de los alumnos de todos los grupos en los que impartes clases, al ver el promedio de las calificaciones que los mismos te asignaron, puedes realizar una reflexión de tu práctica docente, para lograr un proceso de calidad, es decir, la mejora continua; cabe mencionar que esta evaluación se realiza con fines estadísticos y de medición de la calidad y que solamente puede  ser observada por cada docente de manera particular y que en ningún caso sancionara a docente alguno, producto de este resultado. <br><br>
                        <a><i class="fa fa-edit"></i></a> Como docente puedes agregar incidencias de conducta al alumnado cuando rompa alguna de las normas establecidas por el Marco de Convivencia Escolar para Escuelas Secundarias. <br><br>
                        <a><i class="fa fa-edit"></i></a> Por ultimo puedes buscar y obtener información específica de un alumno en particular tales como: sus faltas y retardos, las incidencias que lleva acumuladas, sus calificaciones en todas las asignaturas y las barreras para el aprendizaje que presenta. <br><br>
                    </p><p onclick="ocultar6()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
                    
                    <div id="mostrado7"><p class="lead" onclick="mostrar7()"><a><strong>Personal de Apoyo <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto7" style='display:none;'><p onclick="ocultar7()"><a>Personal de Apoyo <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-eye"></i></a> Como Personal de Apoyo puedes agregar incidencias de conducta al alumnado cuando rompa alguna de las normas establecidas por el Marco de Convivencia Escolar para Escuelas Secundarias. <br><br>
                        <a><i class="fa fa-eye"></i></a> Puedes registrar diariamente las faltas o retardos de los alumnos. <br><br>
                        <a><i class="fa fa-eye"></i></a> Por ultimo puedes buscar y obtener información específica de un alumno en particular tales como: sus faltas y retardos y las incidencias que lleva acumuladas.
                    </p><p onclick="ocultar7()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
  
                    <div id="mostrado8"><p class="lead" onclick="mostrar8()"><a><strong>Personal Administrativo <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto8" style='display:none;'><p onclick="ocultar8()"><a>Personal Administrativo <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-folder-open-o"></i></a> Si formas parte del personal administrativo de la escuela podrás modificar los datos de cualquier usuario que esté registrado en la aplicación web. <br><br>
                        <a><i class="fa fa-folder-open-o"></i></a> Puedes registrar al personal de la escuela. <br><br>
                        <a><i class="fa fa-folder-open-o"></i></a> Puedes dar de baja a cualquier alumno registrado en la aplicación.
                    <p><p onclick="ocultar8()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                    <br><br><br>
                    
                    <div id="mostrado9"><p class="lead" onclick="mostrar9()"><a><strong>Personal Médico <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto9" style='display:none;'><p onclick="ocultar9()"><a>Personal Médico <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-plus-square"></i></a> Si laboras en el área médica de la institución, puedes agregarle a algún alumno un reporte médico, con la finalidad de llevar un registro de las ocasiones que el alumno acude al servicio médico escolar, el tratamiento que se le ha dado y que su padre o tutor esté al tanto de cada incidencia. <br><br>
                        <a><i class="fa fa-plus-square"></i></a> Puedes ver los datos médicos de los alumnos y tendrás acceso a los datos de contacto de su tutor en caso de que ocurra alguna emergencia.
                    </p><p onclick="ocultar9()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>

                    <br><br><br>
                    
                    <div id="mostrado10"><p class="lead" onclick="mostrar10()"><a><strong>Director <i class="fa fa-arrow-down"></i></strong></a></p></div>
                    <div id="oculto10" style='display:none;'><p onclick="ocultar10()"><a>Director <i class="fa fa-arrow-up"></i></a></p><p class="lead">
                        <a><i class="fa fa-briefcase"></i></a> Si eres el director de la escuela, puedes agregar los avisos que aparecen en la página principal de la aplicación web.<br><br>
                        <a><i class="fa fa-briefcase"></i></a> Puedes modificar los datos de cualquier usuario registrado en la aplicación.<br><br>
                        <a><i class="fa fa-briefcase"></i></a> Puedes buscar y obtener información específica de cualquier usuario registrado en la aplicación.<br><br>
                        <a><i class="fa fa-briefcase"></i></a> Puedes agregar incidencias de conducta al alumnado cuando rompa alguna de las normas establecidas por el Marco de Convivencia Escolar para Escuelas Secundarias o agregarle alguna incidencia a cualquier miembro del personal de la escuela. <br><br>
                        <a><i class="fa fa-briefcase"></i></a> Por último, puedes reportar diariamente al personal de la escuela que falte o llegue tarde a sus labores, esto para llevar un registro de la puntualidad, faltas y demás situaciones del personal. 
                    </p><p onclick="ocultar10()"><a>Ver menos <i class="fa fa-arrow-up"></i></a></p></div>
                    
                </div>
                <br><hr><br>
                <div class="col-xs-12 col-sm-4 col-md-3 center">
                    <div class="recent-work-wrap center">
                        <img class="img-responsive" src="images/CalendarioEscolar2016-2017.jpg" alt="">
                        <div class="overlay center">
                            <div class="recent-work-inner center">
                                <h3><a>Calendario del Ciclo Escolar 2016-2017 de la Secundaria N°120 "Rosario Castellanos" turno matutino</a></h3>
                                <a class="preview" href="images/CalendarioEscolar2016-2017.jpg" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>  

                <br><br><br>
                
                <label>MARCO PARA LA CONVIVENCIA ESCOLAR  EN LAS ESCUELAS DE EDUCACIÓN SECUNDARIA DEL DISTRITO FEDERAL</label>
                <h1><font size="7"><a href="http://www2.sepdf.gob.mx/convivencia/escuela/archivos/divulgacion_secundaria.pdf" target="_blank"><i class="fa fa-legal"></i></a></font></h1>
            
                <br><br><br>
                
                <h3><strong><a href="Politica.jsp">Política de Privacidad</a></strong></h3>

            </div>  

        </div>
    </section>
    
    

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
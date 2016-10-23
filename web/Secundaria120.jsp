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
    <title>Secundaria 120</title>

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
            <div class="center wow fadeInDown">
                <h2>Secundaria 120 "Rosario Castellanos"</h2>
            </div>

            <!-- about us slider -->
            <div id="about-slider">
                    <div id="carousel-slider" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators visible-xs">
                                <li data-target="#carousel-slider" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-slider" data-slide-to="1"></li>
                                <li data-target="#carousel-slider" data-slide-to="2"></li>
                            </ol>

                            <div class="carousel-inner">
                                    <div class="item active">
                                            <img src="images/slider/secu1.jpg" class="img-responsive" alt=""> 
                               </div>
                               <div class="item">
                                            <img src="images/slider/secu2.jpg" class="img-responsive" alt=""> 
                               </div> 
                               <div class="item">
                                            <img src="images/slider/secu3.jpg" class="img-responsive" alt=""> 
                               </div> 
                            </div>

                            <a class="left carousel-control hidden-xs" href="#carousel-slider" data-slide="prev">
                                    <i class="fa fa-angle-left"></i> 
                            </a>

                            <a class=" right carousel-control hidden-xs"href="#carousel-slider" data-slide="next">
                                    <i class="fa fa-angle-right"></i> 
                            </a>
                    </div> <!--/#carousel-slider-->
            </div><!--/#about-slider-->


            <!-- Our Skill -->
            <div class="skill-wrap clearfix">
                <div class="center wow fadeInDown">
                        <h2>Objetivo</h2>
                        <p class="lead"><h3>Contribuir a fortalecer las capacidades, habilidades, destrezas y  competencias para la vida de todos y todas las alumnas través de acciones  y estrategias enfocadas en el desarrollo integral del educando para su desarrollo cognitivo, social, del medio ambiente y vida democrática.</h3></p>
                </div>
                <div class="center wow fadeInDown">
                        <h2>Misión</h2>
                        <p class="lead"><h3>Mejorar la educación  y el bienestar de todos y todas las alumnas a través de la articulación de acciones con programas, estrategias pedagógicas y prioridades educativas para contribuir en el  desarrollo  de sus facultades y fomentar en él, el amor a  la Patria y la justicia.</h3></p>
                </div>
                <div class="center wow fadeInDown">
                        <h2>Visión</h2>
                        <p class="lead"><h3>Lograr una escuela donde todos y todas las alumnas disfruten plenamente de sus derechos educativos y puedan desarrollar sus capacidades con igualdad de oportunidades; trabajar en conjunto con todos los actores educativos y de esta forma lograr buenos ciudadanos, con entusiasmo y dedicación para fortalecer el desarrollo de México.</h3></p>
                </div>
            </div>
   
        </div>
    </section><!--/.our-skill-->
    
    <section id="about-us">
        <div class="container">
            
            <!-- about us slider -->
            <div id="about-slider">
                    <div id="carousel-slider" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators visible-xs">
                                <li data-target="#carousel-slider" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-slider" data-slide-to="1"></li>
                                <li data-target="#carousel-slider" data-slide-to="2"></li>
                            </ol>

                            <div class="carousel-inner">
                               <div class="item active">
                                    <img src="images/slider/info1.jpg" class="img-responsive" alt=""> 
                               </div>
                               <div class="item">
                                    <img src="images/slider/info2.jpg" class="img-responsive" alt=""> 
                               </div> 
                               <div class="item">
                                    <img src="images/slider/info3.jpg" class="img-responsive" alt=""> 
                               </div> 
                                <div class="item">
                                    <img src="images/slider/info4.jpg" class="img-responsive" alt=""> 
                               </div> 
                               <div class="item">
                                    <img src="images/slider/info5.jpg" class="img-responsive" alt=""> 
                               </div> 
                            </div>

                            <a class="left carousel-control hidden-xs" href="#carousel-slider" data-slide="prev">
                                    <i class="fa fa-angle-left"></i> 
                            </a>

                            <a class=" right carousel-control hidden-xs"href="#carousel-slider" data-slide="next">
                                    <i class="fa fa-angle-right"></i> 
                            </a>
                    </div> <!--/#carousel-slider-->
            </div><!--/#about-slider-->

            <div class="skill-wrap clearfix">
                <div class="center wow fadeInDown">
                        <h2>¿Quién fue Rosario Castellanos?</h2>
                        <p class="lead">Nacida en la Ciudad de México en 1925, fue una narradora y poeta mexicana, considerada en este segundo <br>
                            género la más importante del siglo XX en su país. Durante su infancia vivió en Comitán (Chiapas), <br>
                            de donde procedía su familia. Cursó estudios de letras Universidad Nacional Autónoma de México. En Madrid 
                            <br>complementaría su formación con cursos de estética y estilística. Fallecio en Tel Aviv en el año 1974.</p>
                        <a href="https://es.wikipedia.org/wiki/Rosario_Castellanos target="_blank"">Más información</a>
                </div>
            </div>  
        </div>
    </section><!--/.our-skill-->
    
    <section id="contact-info">
        <div class="center">                
            <h2>¿Cómo llegar a la escuela?</h2>
        </div>
        <div class="gmap-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-5 text-center">
                        <div class="gmap">
                            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3762.1369414908395!2d-99.17058398564701!3d19.44966174517605!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85d1f8bf521b00ad%3A0x33ff3341e575d6dc!2sSecundaria+Diurna+No+120%2C+Rosario+Castellanos!5e0!3m2!1sen!2sus!4v1467236649440"></iframe>
                        </div>
                    </div>

                    <div class="col-sm-7 map-content">
                        <ul class="form-group center">
                                <address>
                                    <h2>Dirección</h2><br><br>
                                    <h3>
                                    <p>Calzada del Maestro Rural #57 <br>
                                        Colonia: Un Hogar Para Nosotros<br>
                                    Delegación: Miguel Hidalgo<br>Codigo Postal:11340</p>
                                    <p>Teléfono: 53412115<br>
                                    e-Mail: <a href="mailto:contacto@secundaria120.com">contacto@secundaria120.com</a></p>
                                    </h3>
                                </address>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>  <!--/gmap_area -->
    
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


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
    AvisosDAO  av= new AvisosDAO();
    ArrayList<Avisos> p = (ArrayList)av.DesplegarAvisos();
    int tamaño=p.size();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Inicio | Secundaria 120</title>

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
                                    <input type="hidden" name="opc" value="1"></form>
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

    <section id="main-slider" class="no-margin">
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item active" style="background-image: url(images/slider/bg1.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Bienvenido a la secundaria 120</h1>
                                    <h2 class="animation animated-item-2">"Rosario Castellanos"</h2>
                                    <a class="btn-slide animation animated-item-3" href="Secundaria120.jsp">Más información</a>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="images/slider/img1.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg2.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Hay alguien tan inteligente que aprende de la experiencia de los demás.</h1>
                                    <h2 class="animation animated-item-2">Voltaire (1694-1778) Filósofo y escritor francés.</h2>
                                    <a class="btn-slide animation animated-item-3" href="CuadroHonor.jsp">Cuadro de Honor</a>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->
          
                <div class="item" style="background-image: url(images/slider/bg3.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Dime y lo olvido, enséñame y lo recuerdo, involúcrame y lo aprendo.</h1>
                                    <h2 class="animation animated-item-2">Benjamin Franklin (1706-1790) Estadista y científico estadounidense.</h2>
                                    <a class="btn-slide animation animated-item-3" href="Informacion.jsp">Más información</a>
                                </div>
                            </div>
                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/.item-->
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
        <a class="prev hidden-xs" href="#main-slider" data-slide="prev">
            <i class="fa fa-chevron-left"></i>
        </a>
        <a class="next hidden-xs" href="#main-slider" data-slide="next">
            <i class="fa fa-chevron-right"></i>
        </a>
    </section><!--/#main-slider-->

    <section id="feature" >
        <div class="container">
           <div class="center wow fadeInDown">
                <h2>Avisos</h2>
                <p class="lead">A continuacion algunos avisos importantes para la comunidad educativa</p>
            </div>
            <div class="row">

                        <div class="feature-wrap">
                            <i class="fa fa-bullhorn"></i>
                            <h2><a target="_blank" title="<%=p.get(tamaño-6).getFecha()%>"><%=p.get(tamaño-6).getAsunto() + "</a></h2>" + "<h3>" + p.get(tamaño-6).getContenido()%></h3>
                        </div>
                        <hr>

                        <div class="feature-wrap">
                            <i class="fa fa-paperclip"></i>
                            <h2><a target="_blank" title="<%=p.get(tamaño-5).getFecha()%>"><%=p.get(tamaño-5).getAsunto()+ "</a></h2>" + "<h3>" + p.get(tamaño-5).getContenido()%></h3>
                        </div>
                        <hr>

                        <div class="feature-wrap">
                            <i class="fa fa-info"></i>
                            <h2><a target="_blank" title="<%=p.get(tamaño-4).getFecha()%>"><%=p.get(tamaño-4).getAsunto()+ "</a></h2>" + "<h3>" + p.get(tamaño-4).getContenido()%></h3>
                        </div>
                        <hr>
                        
                        <div class="feature-wrap">
                            <i class="fa fa-file"></i>
                            <h2><a target="_blank" title="<%=p.get(tamaño-3).getFecha()%>"><%=p.get(tamaño-3).getAsunto()+ "</a></h2>" + "<h3>" + p.get(tamaño-3).getContenido()%></h3>
                        </div>

                </div>
            </div><!--/.row-->         
        </div><!--/.container-->
    </section><!--/#feature-->

    <section id="recent-works">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Trabajos Sobresalientes</h2>
                <p class="lead">En la secundaria 120 se realizan trabajos sobresalientes que merecen reconocmiento, a contnuacion algunos de ellos...</p>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item1.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Presentación</a> </h3>
                                <p>Apertura a la Muestra Pedagógica de Tecnologías</p>
                                <a class="preview" href="images/portfolio/recent/item1.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item2.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Bordados y Tejidos</a></h3>
                                <p>Muestra de algunos trabajos realizados por los alumnos.</p>
                                <a class="preview" href="images/portfolio/recent/item2.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item3.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Artes Plásticas</a></h3>
                                <p>Recopilación de trabajos realizados en el taller de Artes Plásticas</p>
                                <a class="preview" href="images/portfolio/recent/item3.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item4.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Isométricos</a></h3>
                                <p>Creación de algunos isométricos realizados durante el ciclo escolar.</p>
                                <a class="preview" href="images/portfolio/recent/item4.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item5.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Revolución</a></h3>
                                <p>Estructura realizada unicamente con palillos de madera.</p>
                                <a class="preview" href="images/portfolio/recent/item5.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item6.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Artesanías</a></h3>
                                <p>Variedad de artesanías realizadas por los alumnos en Artes Plásticas</p>
                                <a class="preview" href="images/portfolio/recent/item6.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item7.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Dibujo</a></h3>
                                <p>Magníficas mandalas realizadas por los alumnos</p>
                                <a class="preview" href="images/portfolio/recent/item7.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="images/portfolio/recent/item8.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a>Secundaria 120</a></h3>
                                <p>Maqueta a escala de la Secundaria 120</p>
                                <a class="preview" href="images/portfolio/recent/item8.png" rel="prettyPhoto"><i class="fa fa-eye"></i> Ampliar</a>
                            </div> 
                        </div>
                    </div>
                </div>   
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#recent-works-->

    <section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
                <h2>Actividades</h2>
                <p class="lead">En la secundaría 120 se realizan diversas actividades para lograr<br> el desarrollo multidisiplinario e integral de los alumnos que estudian en ella</p>
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services1.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Música</h3>
                            <p>La música ayuda a desarrollar  a los alumnos integralmente al mismo tiempo que permite el desarrollo óptimo de partes del hemisferio derecho del cerebro.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services2.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Artes Plásticas</h3>
                            <p>En esta asignatura los alumnos desarrollan su parte artística creando varias manualidades con ayuda de las técnicas aprendidas de los docentes.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services3.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Preparación y Conservación de Productos Alimenticios</h3>
                            <p>Los conocimientos obtenidos por los alumnos son expuestos al final del año</p>
                        </div>
                    </div>
                </div>  

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services4.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Bordados y Tejidos</h3>
                            <p>En este laboratorio de tecnología los alumnos se hacen acreedores de algunas las técnicas correctas usadas en la elaboración de prendas a mano</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services5.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Diseño Arquitectónico</h3>
                            <p>El diseño aquitectónico ayuda a desarrollar el razonamiento lógico asi como algunas partes del hemisferio izquierdo del cerebro.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="images/services/services6.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Electrotecnia</h3>
                            <p>Aporta al alumnado la asimilación de conceptos básicos relacionados con la electricidad asi como conocer e interpretar sus fenómenos básicos.</p>
                        </div>
                    </div>
                </div>                                                
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#services-->

    <section id="partner">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Afilaciones</h2>
            </div>
            <div class="partners">
                <ul>
                    <li> <a href="http://www.gob.mx/sep" target="_blank"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms" src="images/partners/partner1.png"></a></li>
                    <li> <a href="http://www2.sepdf.gob.mx/principal/index.html" target="_blank"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms" src="images/partners/partner2.png"></a></li>
                    <li> <a href="http://tic.sepdf.gob.mx/" target="_blank"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="900ms" src="images/partners/partner3.png" width=\"411\" height=\"127\"></a></li>
                    <li> <a href="http://www2.sepdf.gob.mx/contacto_maestro/index.jsp" target="_blank"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1200ms" src="images/partners/partner4.png"></a></li>
                    <li> <a href="http://www.explainers.tv/videos.php" target="_blank"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1500ms" src="images/partners/partner5.png"></a></li>
                </ul>
            </div>        
        </div><!--/.container-->
    </section><!--/#partner-->

    <section id="conatcat-info">
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <div class="media contact-info wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="pull-left">
                            <i class="fa fa-envelope"></i>
                        </div>
                        <div class="media-body">
                            <h2>¿Tienes alguna pregunta, duda o sugerencia?</h2>
                            <p>Por favor envía un correo electroónico a la siguiente dirección: <a href="mailto:contacto@secundaria120.com">contacto@secundaria120.com</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.container-->    
    </section><!--/#conatcat-info-->
    
    <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2016 <a target="_blank" title="Desarrollo web">By Gerardo Arceo</a>. <i class="fa fa-code"></i> SIPREDE 1.1
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
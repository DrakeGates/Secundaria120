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
    <title>Política de privacidad</title>

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
                    <h2>POLÍTICA DE PRIVACIDAD</h2>
<h3>En la Secundaria Diurna Número 120 “Rosario Castellanos”, su privacidad es importante para nosotros. Esta declaración establece las prácticas de privacidad con respecto a la compilación, uso y divulgación de información personal en este sitio web.
La información personal es aquella información que lo identifica a usted personalmente. La información personal podrá incluir su nombre, dirección de correo electrónico y dirección postal, según sea el caso. Los visitantes del sitio web no podrán solicitar la revelación de ningún dato personal.
Sin su permiso, La Secundaria Diurna Número 120 jamás revelará, venderá o arrendará a terceros distintos a los pertenecientes a nuestras subsidiarias, la información personal que usted nos haya proporcionado a través del sitio, a menos que la ley nos obligue a hacerlo.
</h3>
            </div>
            <!-- Our Skill -->
            <div class="skill-wrap clearfix">
                <div class="center wow fadeInDown">
                    
                        <h2>Acceso</h2>
                        <p class="lead">
Si usted ya ha solicitado ser parte de una lista de correo, podrá cancelar su perfil a través de su contacto con nosotros, utilizando la información suministrada al final de esta declaración de privacidad. Si usted ya nos ha proporcionado su información personal y desea verificar, eliminar o corregir la información existente en nuestros archivos, sírvase contactarnos utilizando la información suministrada al final de esta declaración de privacidad.
                        </p>
                        
                        <h2>Seguridad</h2>
                        <p class="lead">
Su información personal será tratada por La Secundaria Diurna Número 120 como información privada y confidencial. Nos esforzamos en garantizarle que sus datos personales quedan protegidos en todo momento; la información es almacenada en un sitio seguro de La Secundaria Diurna Número 120, con el objeto de mantener la confidencialidad de la misma.                     
No obstante, a pesar de que La Secundaria Diurna Número 120 ha puesto en práctica métodos considerados eficaces para la protección de sus datos personales, no podemos garantizarle que dicha información no podría perderse, ser utilizada ilegalmente, o modificados sus términos en forma fraudulenta, ya que ninguna transmisión de datos a través de Internet puede ser garantizada como completamente confidencial. En consecuencia, no asumimos responsabilidad legal alguna derivada del uso de la información suministrada por usted o por terceros a través de dicho medio.
                        </p>

                        <h2>Información confidencial o reservada</h2>
                        <p class="lead">
La Secundaria Diurna Número 120 se complace en tener noticias suyas, y recibe con agrado sus comentarios relacionados con la educación, la comunidad educativa o sobre la secundaria en sí. Usted sabrá comprender que La Secundaria Diurna Número 120 no desea recibir información suya confidencial o reservada a través de nuestro sitio web. Sírvase tomar en cuenta que cualquier información no personal o material enviado a La Secundaria Diurna Número 120, será considerado como NO confidencial. Mediante el envío a La Secundaria Diurna Número 120 de cualquier información o material, usted otorga a La Secundaria Diurna Número 120 una licencia irrestricta e irrevocable para utilizar, reproducir, mostrar, explotar, modificar, transmitir y distribuir dicho material o información, y también usted presta su acuerdo para que La Secundaria Diurna Número 120 se considera libre de utilizar cualquier idea, concepto, conocimiento o técnica que usted nos envíe para cualquier propósito.
                        </p>
                        
                        <h2>Correo electrónico (E-mail)</h2>
                        <p class="lead">
Si usted enviase una consulta por correo electrónico a este sitio, cualquier información personal por usted sometida podría ser utilizada por los empleados de La Secundaria Diurna Número 120 o sus filiales que requieran acceso al mismo para responder a su consulta.
                        </p>
                        
                        <h2>Cambios</h2>
                        <p class="lead">
La Secundaria Diurna Número 120 se reserva el derecho de modificar esta declaración de privacidad de la forma en que lo considere oportuno y sin previo aviso. Sin embargo, nos aseguraremos de que cualquier cambio a esta declaración publicado en esta página, esté en conformidad con las leyes de privacidad vigentes en México.
                        </p>
                        
                        <h2>Enlaces externos</h2>
                        <p class="lead">
Este sitio web podrá contener enlaces que podrían llevarlo a usted a otros sitios web. Esta declaración de privacidad no se extiende a las prácticas de recopilación de datos de terceros, y La Secundaria Diurna Número 120 no asume responsabilidad alguna por las prácticas de privacidad, políticas o acciones de terceros. Antes de tomar una decisión acerca de su aceptación o no de utilizar dichos sitios basados en sus prácticas de privacidad, debería usted informarse de las políticas de privacidad de los mismos.
                        </p>
                        
                        <h2>¡Descubra más!</h2>
                        <p class="lead">
Si usted quisiese formular comentarios, preguntas o quejas acerca de la declaración de privacidad La Secundaria Diurna Número 120 o sus prácticas, sírvase ponerse en contacto con los Directivos o con el ingeniero en software por correo electrónico a contacto@secundaria120.com<mailto: contacto@secundaria120.com > .
                        </p>               
                        
                        <h2>ACEPTO DECLINO</h2>
                        <p class="lead">
Mediante el sometimiento de esta declaración, certifico que las declaraciones formuladas por mí en este formulario de solicitud, o en cualquier otro documento justificativo, son verdaderas y completas. Comprendo y acepto que una declaración falsa podría descalificarme del empleo, o después de haber sido asignado al mismo, lo que podría resultar en la aplicación de acciones disciplinarias, hasta donde lo permita la legislación aplicable. Asimismo, con el simple hecho de registrarme en la página web o de utilizarla de cualquier forma o con cualquier motivo u objetivo, acepto completa e irrevocablemente todo lo declarado en esta política de privacidad.
                        </p>
                </div>
            </div>
        </div>
    </section><!--/.our-skill-->
    
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
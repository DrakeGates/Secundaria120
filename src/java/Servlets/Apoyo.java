package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.SQLException;
import Clases.DB;
import Clases.Funciones;
import Clases.UsuarioDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Apoyo extends HttpServlet
{
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final UsuarioDAO p = new UsuarioDAO();
        final Funciones Funcion = new Funciones();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            String idApoyo = request.getParameter("idApoyo");
            final String nombre = request.getParameter("nombre");
            final String fecha = Funcion.VerFecha(idApoyo);
            final String diaActual = fecha.substring(8, 10);
            final String mesActual = fecha.substring(5, 7);
            final String anoActual = fecha.substring(0, 4);
            out.println("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"\">\n        <title>Apoyo</title>\n\n        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n    </head><!--/head-->\n\n    <body class=\"homepage\">\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Apoyo.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>\n" + "                                <ul class=\"dropdown-menu\">\n" + "<form method=\"post\" action=\"Apoyo\" name=\"verdatos\">\n" + "                                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>\n" + "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>\n" + "                            </li>   \n" + "                        </ul>\n" + "                    </div>\n" + "                </div><!--/.container-->\n" + "            </nav><!--/nav-->\n" + "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idApoyo);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + " <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Cambiar Contrase\u00f1a</button></form>                        <br><br>");
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        </div><br><br>");
            }
            else if (opc.equals("2.2")) {
                idApoyo = request.getParameter("idApoyo");
                final String idAlumno = request.getParameter("idAlumno");
                final String nombreA = request.getParameter("nombreA");
                final String apellidoP = request.getParameter("apellidoP");
                final String apellidoM = request.getParameter("apellidoM");
                out.println("<h3>Alumno a reportar: " + nombreA + " " + apellidoP + " " + apellidoM + "</h3><br>");
                out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"175\" height=\"210\"//>");
                out.println("</div><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS DE INDISCIPLINA LEVES</label><br>\n               <select name=\"incidencia1\">\n                     <option value=\"1\">Inasistencia injustificada a la escuela</option>\n                     <option value=\"2\">No entrar a una clase estando en la escuela</option>\n                     <option value=\"3\">Llegar tarde a la escuela o a las clases sin justificaci\u00f3n</option>\n                     <option value=\"4\">Utilizar dentro de la escuela sin autorizaci\u00f3n materiales prohibidos</option>\n                     <option value=\"5\">Estar en \u00e1reas que no corresponda a su actividad dentro del plantel</option>\n                     <option value=\"6\">No portar la credencial escolar</option>\n                     <option value=\"7\">Usar dispositivos electr\u00f3nicos de la escuela sin autorizaci\u00f3n</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"1\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS QUE PERTURBAN EL ORDEN</label><br>\n               <select name=\"incidencia2\">\n                     <option value=\"8\">Utilizar cerillos y/o encendedores</option>\n                     <option value=\"9\">Apostar y/o participar en juegos de azar</option>\n                     <option value=\"10\">Mentir, dar informaci\u00f3n falsa o enga\u00f1ar al personal escolar</option>\n                     <option value=\"11\">Hacer uso de las pertenencias de otros sin autorizaci\u00f3n</option>\n                     <option value=\"12\">Comportarse de una manera que perturbe el proceso educativo</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"2\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS ALTAMENTE PERTURBADORAS DEL ORDEN</label><br>\n               <select name=\"incidencia3\">\n                     <option value=\"13\">Salir de la clase sin permiso de alguna autoridad</option>\n                     <option value=\"14\">Ingresar a clase sin permiso del docente frente a grupo</option>\n                     <option value=\"15\">Asistir a la escuela con personas no autorizadas</option>\n                     <option value=\"16\">Da\u00f1ar, cambiar o modificar un registro o documento escolar</option>\n                     <option value=\"17\">Apropiarse de objetos que pertenecen a otra persona sin autorizaci\u00f3n</option>\n                     <option value=\"18\">Violar el reglamento sobre el uso de Internet</option>\n                     <option value=\"19\">Incurrir en conductas de deshonestidad acad\u00e9mica</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"3\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS QUE PROVOCAN PELIGRO</label><br>\n               <select name=\"incidencia4\">\n                     <option value=\"20\">Activar injustificadamente las alarmas</option>\n                     <option value=\"21\">Realizar una amenaza de bomba</option>\n                     <option value=\"22\">Provocar la combusti\u00f3n, detonaci\u00f3n de objetos o el riesgo de incendio</option>\n                     <option value=\"23\">Realizar actos de vandalismo o da\u00f1o a los bienes de alguien o de la escuela</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"4\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS DISCRIMINATORIAS</label><br>\n               <select name=\"incidencia5\">\n                     <option value=\"24\">Emplear insultos relacionados con la discriminaci\u00f3n</option>\n                     <option value=\"25\">Realizar actos de intimidaci\u00f3n por algun tipo de discriminaci\u00f3n</option>\n                     <option value=\"26\">Tratar de infligir o causar serios da\u00f1os de cualquier tipo</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"5\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS VIOLENTAS</label><br>\n               <select name=\"incidencia6\">\n                     <option value=\"27\">Utilizar expresiones verbales, lenguaje o gestos groseros o irrespetuosos</option>\n                     <option value=\"28\">Conductas de agresi\u00f3n f\u00edsica o similares, como juegos bruscos, o escupir a otra persona.</option>\n                     <option value=\"29\">Distribuir cualquier tipo de materiales que contengan calumnias, amenazas, da\u00f1os, etc.</option>\n                     <option value=\"30\">Incurrir en conductas de agresi\u00f3n f\u00edsica y/o juegos o bromas pesadas.</option>\n                     <option value=\"31\">Participar en actos de coerci\u00f3n o amenazas que impliquen violencia, da\u00f1os o perjuicios</option>\n                     <option value=\"32\">Planear, participar, realizar u ordenar actos de acoso escolar o bullying, incluso el cibern\u00e9tico</option>\n                     <option value=\"33\">Crear riesgo de lesiones ya sea mediante conductas imprudentes o la utilizaci\u00f3n de objetos</option>\n                     <option value=\"34\">Incitar o causar disturbios</option>\n                     <option value=\"35\">Utilizar la fuerza o amenazar utilizando la fuerza para apropiarse de los bienes de otros</option>\n                     <option value=\"36\">Utilizar la fuerza contra alguien de la comunidad escolar o intentar infligirles serios da\u00f1os</option>\n                     <option value=\"37\">Participar en un incidente de violencia grupal</option>\n                     <option value=\"38\">Participar en ri\u00f1as dentro y fuera del plantel</option>\n                     <option value=\"39\">Causar una lesi\u00f3n grave ya sea mediante conductas imprudentes o la utilizaci\u00f3n de objetos</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + 
                        "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"6\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS AGRESIVA DE \u00cdNDOLE SEXUAL</label><br>\n               <select name=\"incidencia7\">\n                     <option value=\"40\">Emitir comentarios, insinuaciones o proposiciones con alguna sugerencia sexual</option>\n                     <option value=\"41\">Realizar actos de agresi\u00f3n sexual f\u00edsica, u obligar a otros a participar de una actividad sexual</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + 
                        "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"7\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS DE RIEGO POR SUSTANCIAS T\u00d3XICO ADICTIVAS</label><br>\n               <select name=\"incidencia8\">\n                     <option value=\"42\">Posesi\u00f3n de sustancias t\u00f3xico-adictivas</option>\n                     <option value=\"43\">Consumo de sustancias t\u00f3xico-adictivas</option>\n                     <option value=\"44\">Distribuci\u00f3n de sustancias t\u00f3xico-adictivas</option>\n                     <option value=\"45\">Posesi\u00f3n de medicamentos sin que hayan sido prescritos por un m\u00e9dico</option>\n                     <option value=\"46\">Consumo de medicamentos sin prescripci\u00f3n m\u00e9dica.</option>\n                     <option value=\"47\">Distribuci\u00f3n de medicamentos</option>\n                     <option value=\"48\">Posesi\u00f3n de sustancias qu\u00edmicas industriales</option>\n                     <option value=\"49\">Consumo de sustancias qu\u00edmicas industriales</option>\n                     <option value=\"50\">Distribuci\u00f3n de sustancias qu\u00edmicas industriales</option>\n                     <option value=\"51\">Posesi\u00f3n de drogas</option>\n                     <option value=\"52\">Consumo de drogas</option>\n                     <option value=\"53\">Distribuci\u00f3n y venta de drogas</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" +
                        "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"8\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS BLANCAS</label><br>\n               <select name=\"incidencia9\">\n                     <option value=\"54\">Posesi\u00f3n de un arma blanca o instrumento que ponga en riesgo a alguien</option>\n                     <option value=\"55\">Utilizar cualquier tipo de arma blanca, con el fin de tratar de da\u00f1ar a alguien</option>\n                     <option value=\"56\">Utilizar cualquier arma, lesionando a alguien</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + 
                        "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"9\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Apoyo\" method=\"POST\">\n<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS DE FUEGO</label><br>\n               <select name=\"incidencia10\">\n                     <option value=\"57\">Poseer cualquier tipo de arma de fuego</option>\n                     <option value=\"58\">Utilizar cualquier arma de fuego con el fin de tratar de causar lesiones</option>\n                     <option value=\"59\">Utilizar cualquier arma de fuego lesionando a alguien</option>\n               </select><br>               <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + 
                        " <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"10\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
                out.println("<div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("2.3")) {
                final String idAlumno = request.getParameter("idAlumno");
                idApoyo = request.getParameter("idApoyo");
                String incidencia = "";
                final String parameter;
                final String opc2 = parameter = request.getParameter("opc2");
                switch (parameter) {
                    case "1": {
                        incidencia = request.getParameter("incidencia1");
                        break;
                    }
                    case "2": {
                        incidencia = request.getParameter("incidencia2");
                        break;
                    }
                    case "3": {
                        incidencia = request.getParameter("incidencia3");
                        break;
                    }
                    case "4": {
                        incidencia = request.getParameter("incidencia4");
                        break;
                    }
                    case "5": {
                        incidencia = request.getParameter("incidencia5");
                        break;
                    }
                    case "6": {
                        incidencia = request.getParameter("incidencia6");
                        break;
                    }
                    case "7": {
                        incidencia = request.getParameter("incidencia7");
                        break;
                    }
                    case "8": {
                        incidencia = request.getParameter("incidencia8");
                        break;
                    }
                    case "9": {
                        incidencia = request.getParameter("incidencia9");
                        break;
                    }
                    case "10": {
                        incidencia = request.getParameter("incidencia10");
                        break;
                    }
                }
                final String query = "call AgregarIncidencia(" + idAlumno + "," + idApoyo + ",'" + incidencia + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><h3>Informe ingresado a la base de datos correctamente</h3><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        <br><br><br></div>");
            }
            else if (opc.equals("3")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query2 = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con2 = DB.getConnection()) {
                        final Statement sentencia2 = con2.createStatement();
                        final ResultSet resultados2 = sentencia2.executeQuery(query2);
                        int i = 0;
                        while (resultados2.next()) {
                            if (resultados2.getInt("idTipo") == 1) {
                                ++i;
                                final String js = "Redirigir5(" + i + ");";
                                final String formu = "red" + i;
                                out.println("<form action=\"Apoyo\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados2.getString("idPersona") + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados2.getString("Nombre") + " " + resultados2.getString("Apaterno") + " " + resultados2.getString("Amaterno") + " <strong>" + resultados2.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con2.close();
                    }
                    catch (SQLException ex2) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                out.println("<br><br><br><h2>¿De que grupo es el alumno?</h2>");
                out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                       <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("3.1")) {
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia3 = con3.createStatement();
                    idApoyo = request.getParameter("idApoyo");
                    final String ano = request.getParameter("ano");
                    final String grupo = request.getParameter("grupo");
                    int j = 1;
                    final String query3 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados = sentencia3.executeQuery(query3);
                    out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Consultar</th>\n</tr>\n");
                    while (resultados.next()) {
                        out.println("<tr><td>" + j + "</td><td>" + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " " + resultados.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + 
                                "<input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Consultar</button></form></th> \n");
                        out.println("</tr>");
                        ++j;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        <br><br><br></div>");
                    con3.close();
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.2")) {
                final String idAlumno = request.getParameter("idAlumno");
                String comentarioAlu = "";
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query4 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados3 = sentencia2.executeQuery(query4);
                    final Statement sentencia4 = con2.createStatement();
                    final String query5 = "call VerIncidenciasAlumnoId(" + idAlumno + ");";
                    final ResultSet resultados4 = sentencia4.executeQuery(query5);
                    out.println("</div><div class=\"col-sm-5 col-sm-offset-1\"><h2>Datos Personales</h2><br>");
                    String nombreA2 = "";
                    String apellidoP2 = "";
                    String apellidoM2 = "";
                    String curp = "";
                    if (resultados3.next()) {
                        nombreA2 = resultados3.getString("Nombre");
                        apellidoP2 = resultados3.getString("Apaterno");
                        apellidoM2 = resultados3.getString("Amaterno");
                        curp = resultados3.getString("Curp");
                        out.println("<h3>Nombre: " + nombreA2 + "<br>Apellido Paterno: " + apellidoP2 + "<br>Apellido Materno: " + apellidoM2 + "<br>Grupo: " + resultados3.getString("Ano") + "° " + resultados3.getString("Grupo") + "<br>CURP: " + curp + "<br>Nacimiento: " + resultados3.getString("Nacimiento") + "<br>" + "<br>Parentesco del tutor: " + resultados3.getString("DatosExtraAlumno.Parentesco") + "<br>Nombre Tutor: " + resultados3.getString("d1.Nombre") + "<br>Apellido Paterno Tutor: " + resultados3.getString("d1.Apaterno") + "<br>Apellido Materno Tutor: " + resultados3.getString("d1.Amaterno") + "<br>Celular Tutor: " + resultados3.getString("d1.Celular") + "<br>Telefono del trabajo: " + resultados3.getString("d1.Celular") + "</h3>");
                        out.println("</div>");
                        out.println("<div class=\"col-sm-5\">");
                        out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"215\" height=\"258\"//>");
                        out.println("</div><br><br><br><br><br><br><br><br><br>");
                        out.println("<form method=\"post\"><input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"opc\" value=\"3.3\">" + "<input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"nombreA\" value=" + nombreA2 + ">" + "<input type=\"hidden\" name=\"Apaterno\" value=" + apellidoP2 + ">" + "<input type=\"hidden\" name=\"Amaterno\" value=" + apellidoM2 + ">" + "<input type=\"hidden\" name=\"idPersona\" value=" + idAlumno + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" onclick=\"submit()\" style=\"background-color: #008000\">Ver Situaciones</button>" + "</form><br><p id=\"pw\" hidden=\"true\">" + curp + "</p>");
                        out.println("<a onclick=\"copiarAlPortapapeles('pw');\" target=\"_blank\" href=\"http://comunidadescolar.sepdf.gob.mx:8024/ConsultaCalificaciones/index.jsp\" class=\"btn btn-primary btn-lg\" style=\"background-color: #1E90FF\" onclick=\"copiarAlPortapapeles('pw');\">Calificaciones</a>");
                        out.println("<br><form method=\"post\"><input type=\"hidden\" name=\"opc\" value=\"2.2\"><input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"nombreA\" value=" + nombreA2 + ">" + "<input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP2 + ">" + "<input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM2 + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #EE2222\" onclick=\"submit()\">Agregar Incidencia</button>" + "</form><br>");
                        comentarioAlu = resultados3.getString("DatosExtraAlumno.Comentario");
                    }
                    out.println("<br><br><br><br><br><br><br><div class=\"center\">");
                    out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.21\">\n" + "                    <textarea name=\"comentarioAlu\" class=\"form-control\" rows=\"8\">" + comentarioAlu + "</textarea>\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Modificar Comentario</button></form>");
                    out.println("<br><br><br><br>");
                    if (resultados4.next()) {
                        out.println("<h2>Incidencias</h2><br><strong>" + resultados4.getString("TipoIncidencia") + "</strong><br><h3>" + resultados4.getString("Incidencia") + "<br><br> Ocurrida el " + resultados4.getString("Fecha") + "<br>Reportada por " + resultados4.getString("Nombre del reportador") + " " + resultados4.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    else {
                        out.println("<br><br><strong>Sin incidencias :D</strong><br><br><br>");
                    }
                    while (resultados4.next()) {
                        out.println("<strong>" + resultados4.getString("TipoIncidencia") + "</strong><br><h3>" + resultados4.getString("Incidencia") + "<br><br> Ocurrida el " + resultados4.getString("Fecha") + "<br>Reportada por " + resultados4.getString("Nombre del reportador") + " " + resultados4.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><form name=\"formu\" action=\"Apoyo.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br>");
                out.println("</div>");
            }
            else if (opc.equals("3.21")) {
                final String idAlumno = request.getParameter("idAlumno");
                final String comentarioAlu = request.getParameter("comentarioAlu");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query4 = "call ModificarComentarioAlumno(" + idAlumno + ",'" + comentarioAlu + "');";
                    final ResultSet resultados3 = sentencia2.executeQuery(query4);
                    out.println("<form action=\"Apoyo\" method=\"POST\" name=\"red\" id=\"red\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" +
                            "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\"></form>\n");
                    out.println("<script>Redirigir();</script>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.3")) {
                final String idPersona = request.getParameter("idPersona");
                final String nombreA = request.getParameter("nombreA");
                final String Apaterno = request.getParameter("Apaterno");
                final String Amaterno = request.getParameter("Amaterno");
                final String idAlumno2 = request.getParameter("idAlumno");
                final ArrayList<String> Situaciones = (ArrayList<String>)Funcion.VerSituaciones(idPersona);
                int x = 0;
                out.println("<br><br><br><h2>Situaciones sobre " + nombreA + " " + Apaterno + " " + Amaterno + "</h2><br><br><br>");
                try (final Connection con4 = DB.getConnection()) {
                    final Statement sentencia5 = con4.createStatement();
                    final String query6 = "call TotalSituaciones(" + idPersona + ");";
                    final ResultSet resultados5 = sentencia5.executeQuery(query6);
                    while (resultados5.next()) {
                        out.println("<h3>Total de <strong>" + resultados5.getString("Situacion") + "</strong>: " + resultados5.getString("Total") + "</h3><br>");
                    }
                    con4.close();
                    out.println("<br><br><br><hr>");
                }
                catch (SQLException ex4) {
                    response.sendRedirect("Error.jsp");
                }
                if (Situaciones.size() > x) {
                    out.println("<strong>" + Situaciones.get(x) + "</strong><br>" + "Fecha: " + Situaciones.get(x + 1));
                    out.println("<br><br><form name=\"formu\" action=\"Apoyo\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"3.4\">\n       <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "       <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "       <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">\n" + "       <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "       <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno + ">\n" + "       <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno + ">\n" + "       <input type=\"hidden\" name=\"idSituacion\" value=" + Situaciones.get(x + 2) + ">\n" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Eliminar</button>" + "</form><br><hr><br>");
                    x += 3;
                }
                else {
                    out.println("<br><br><br><br><br><strong>Este usuario no tiene ninguna reporte de faltas o impuntualidad :D</strong><br><br><br><br><br>");
                }
                while (Situaciones.size() > x) {
                    out.println("<strong>" + Situaciones.get(x) + "</strong><br>" + "Fecha: " + Situaciones.get(x + 1));
                    out.println("<br><br><form name=\"formu\" action=\"Apoyo\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"3.4\">\n       <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "       <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "       <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">\n" + "       <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "       <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno + ">\n" + "       <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno + ">\n" + "       <input type=\"hidden\" name=\"idSituacion\" value=" + Situaciones.get(x + 2) + ">\n" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Eliminar</button>" + "</form><br><hr><br>");
                    x += 3;
                }
                out.println("<br><br><form name=\"formu\" action=\"Apoyo\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"3.2\">\n       <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "       <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "       <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno2 + ">\n" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button>" + "</form><br></div>");
            }
            else if (opc.equals("3.4")) {
                final String idPersona = request.getParameter("idPersona");
                final String nombreA = request.getParameter("nombreA");
                final String Apaterno = request.getParameter("Apaterno");
                final String Amaterno = request.getParameter("Amaterno");
                final String idSituacion = request.getParameter("idSituacion");
                final String query4 = "call EliminarSituacion(" + idSituacion + ");";
                try (final Connection con5 = DB.getConnection()) {
                    final Statement sentencia6 = con5.createStatement();
                    final ResultSet resultados6 = sentencia6.executeQuery(query4);
                    con5.close();
                    out.println("<br><br><form name=\"formu\" action=\"Apoyo\" method=\"post\" name=\"red\" id=\"red\">       <input type=\"hidden\" name=\"opc\" value=\"3.3\">\n       <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "       <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "       <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">\n" + "       <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "       <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno + ">\n" + "       <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno + ">\n" + "<script>Redirigir6();</script> </form><br></div>");
                }
                catch (SQLException ex5) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("4")) {
                out.println("<br><br><br><br><br><h2>Escoge un grupo por favor</h2><br><br><br>");
                out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" +
                        "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        </div><br><br><br><br>");
            }
            else if (opc.equals("4.1")) {
                idApoyo = request.getParameter("idApoyo");
                final String ano2 = request.getParameter("ano");
                final String grupo2 = request.getParameter("grupo");
                final String locate = request.getParameter("locate");
                int k = 1;
                final ArrayList<String> Alumnos = (ArrayList<String>)Funcion.VerGrupo(ano2, grupo2);
                out.println("<script>location.href='#" + locate + "'</script>");
                out.println("<h2>Alumnos del grupo " + ano2 + "º " + grupo2 + "</h2><br>");
                out.println("<table border=1 style=text-align:center;><tr><th></th><th></th><th colspan=\"2\" style=text-align:center;>Retardo</th><th colspan=\"2\" style=text-align:center;>Falta</th><th colspan=\"2\" style=text-align:center;>Entrada</th></tr><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Leve</th>\n<th>Grave</th>\n<th>Injustificada</th>\n<th>Justificada</th>\n<th>Sin Credencial</th>\n<th>Extempor\u00e1nea</th>\n<th>Retiro Anticipado</th>\n</tr>\n");
                for (int x2 = 0; Alumnos.size() > x2; x2 += 4) {
                    out.println("<tr id=\"" + k + "\"><td>" + k + "</td><td>" + Alumnos.get(x2 + 1) + " " + Alumnos.get(x2 + 2) + " " + Alumnos.get(x2) + "</td>");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"2\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Leve\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" style=\"background-color: #FFA500\" onClick=\"submit()\">Leve</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"3\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Grave\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF4500\" required=\"required\" onClick=\"submit()\">Grave</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"1\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Falta Injustificada\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF0000\" required=\"required\" onClick=\"submit()\">Injustificada</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"9\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Falta con Justificante\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #DC143C\" required=\"required\" onClick=\"submit()\">Justificada</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"7\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Asistencia Sin Credencial\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #4B0082\" required=\"required\" onClick=\"submit()\">Sin Credencial</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"8\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Entrada Extempor\u00e1nea Autorizada\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #0000CD\" required=\"required\" onClick=\"submit()\">Extempor\u00e1nea</button></form></th> \n");
                    out.println("<th><form action=\"Apoyo\" method=\"POST\" name=\"formu\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idSituacion\" value=\"10\">\n" + "                    <input type=\"hidden\" name=\"locate\" value=\"" + k + "\">\n" + "                    <input type=\"hidden\" name=\"Situacion\" value=\"Retiro Anticipado\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #2F4F4F\" required=\"required\" onClick=\"submit()\">Retiro Anticipado</button></form></th> \n");
                    out.println("</tr>");
                    ++k;
                }
                out.println("</table>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        <br><br><br></div>");
            }
            else if (opc.equals("4.2")) {
                idApoyo = request.getParameter("idApoyo");
                final String idAlumno = request.getParameter("idAlumno");
                final String ano3 = request.getParameter("ano");
                final String grupo3 = request.getParameter("grupo");
                final String nombreA3 = request.getParameter("nombreA");
                final String apellidoP3 = request.getParameter("apellidoP");
                final String apellidoM3 = request.getParameter("apellidoM");
                final String idSituacion2 = request.getParameter("idSituacion");
                final String Situacion = request.getParameter("Situacion");
                final String locate2 = request.getParameter("locate");
                final String query7 = "call AgregarSituacion(" + idAlumno + "," + idApoyo + "," + idSituacion2 + ",'" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                try (final Connection con6 = DB.getConnection()) {
                    final Statement sentencia7 = con6.createStatement();
                    final ResultSet resultados7 = sentencia7.executeQuery(query7);
                    con6.close();
                }
                catch (SQLException ex6) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<form action=\"Apoyo\" method=\"POST\" name=\"red\" id=\"red\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano3 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo3 + ">" + "                    <input type=\"hidden\" name=\"locate\" value=" + locate2 + ">" + "                    <script>Situacion('" + Situacion + "','" + apellidoP3 + "','" + apellidoM3 + "','" + nombreA3 + "');</script>");
            }
            else if (opc.equals("5")) {
                idApoyo = request.getParameter("idApoyo");
                out.println("<br><br><br><br><br><br><h2>Por favor escribe tu nueva contrase\u00f1a</h2><br>");
                out.println("<form action=\"Apoyo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idApoyo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" +
                        " <input type=\"text\" name=\"Pass\" placeholder=\"Contrase\u00f1a\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.1\"><br><br>\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Cambiar Contrase\u00f1a</button>" + "<br><br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("5.1")) {
                final String idPersona = request.getParameter("idApoyo");
                final String Pass = request.getParameter("Pass");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query4 = "call ModificarPass(" + idPersona + ",'" + Pass + "');";
                    final ResultSet resultados3 = sentencia2.executeQuery(query4);
                    out.println("<br><br><br><br><br><br><h2>Contrase\u00f1a modificada exitosamente :D</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Apoyo.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            out.println("<footer id=\"footer\" class=\"midnight-blue\">\n        <div class=\"container\">\n            <div class=\"row\">\n                <div class=\"col-sm-6\">\n                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>\n                </div>\n                <div class=\"col-sm-6\">\n                    <ul class=\"pull-right\">\n                        <li>Se feliz</li>\n                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </footer><!--/#footer-->\n\n        \n    <script src=\"js/jquery.js\"></script>\n    <script src=\"js/bootstrap.min.js\"></script>\n    <script src=\"js/jquery.prettyPhoto.js\"></script>\n    <script src=\"js/jquery.isotope.min.js\"></script>\n    <script src=\"js/main.js\"></script>\n    <script src=\"js/wow.min.js\"></script>\n    </body>\n</html>\n");
        }
        catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
    }
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

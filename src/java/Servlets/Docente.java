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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Docente extends HttpServlet
{
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Funciones Funcion = new Funciones();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            String idDocente = request.getParameter("idDocente");
            final String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            final String fecha = Funcion.VerFecha(idDocente);
            final String diaActual = fecha.substring(8, 10);
            final String mesActual = fecha.substring(5, 7);
            final String anoActual = fecha.substring(0, 4);
            out.println("<!DOCTYPE html>" + 
 "<html lang=\"en\">" + 
 "    <head>" + 
 "        <meta charset=\"utf-8\">" + 
 "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + 
 "        <meta name=\"description\" content=\"\">" + 
 "        <meta name=\"author\" content=\"\">" + 
 "        <title>Docente</title>" + 
 "" + 
 "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">" + 
 "        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">" + 
 "        <link href=\"css/animate.min.css\" rel=\"stylesheet\">" + 
 "        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">" + 
 "        <link href=\"css/main.css\" rel=\"stylesheet\">" + 
 "        <link href=\"css/responsive.css\" rel=\"stylesheet\">" + 
 "        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">" + 
 "        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">" + 
 "        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">" + 
 "        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">" + 
 "        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">" + 
 "       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>" + 
 "    </head><!--/head-->" + 
 "" + 
 "    <body class=\"homepage\">" + 
 "        <header>" + 
 "            <nav class=\"navbar navbar-inverse\" role=\"banner\">" + 
 "                <div class=\"container\">" + 
 "                    <div class=\"navbar-header\">" + 
 "                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">" + 
 "                            <span class=\"sr-only\">Navegacion</span>" + 
 "                            <span class=\"icon-bar\"></span>" + 
 "                            <span class=\"icon-bar\"></span>" + 
 "                            <span class=\"icon-bar\"></span>" + 
 "                        </button>" + 
 "                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>" + 
 "                    </div>" + 
 "" + 
 "                    <div class=\"collapse navbar-collapse navbar-right\">" + 
 "                    <ul class=\"nav navbar-nav\">" + 
 "                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>" + 
 "                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>" + 
 "                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>" + 
 "                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>" + 
 "                            <li><a href=\"Docente.jsp\">Menu</a></li>" + 
 "                                <li class=\"dropdown active\">" + 
 "                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>" + 
 "                                <ul class=\"dropdown-menu\">" + 
 "<form method=\"post\" action=\"Docente\" name=\"verdatos\">" + 
 "                                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>" + 
 "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>" + 
 "                            </li>   " + 
 "                        </ul>" + 
 "                    </div>" + 
 "                </div><!--/.container-->" + 
 "            </nav><!--/nav-->" + 
 "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idDocente);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5\">" + 
 "");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Cambiar Contrase\u00f1a</button></form>                        <br><br>");
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        </div><br><br>");
            }
            else if (opc.equals("2")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call VerDatosDocenteId(" + idDocente + ");";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><br><br><br><h2>¿En que grupo quieres ver tu puntuaci\u00f3n?</h2>");
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.1\">" + 
 "                    <div class=\"form-group\">" + 
 "<label>Grupo</label>" + 
 "                    <select name=\"anogrupo\">" + 
 "");
                    while (resultados.next()) {
                        out.println("<option value=" + resultados.getString("Ano") + resultados.getString("Grupo") + ">" + resultados.getString("Ano") + "º " + resultados.getString("Grupo") + "</option>" + 
 "");
                    }
                    out.println("</select></div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Continuar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String anogrupo = request.getParameter("anogrupo");
                    final char ano = anogrupo.charAt(0);
                    final char grupo = anogrupo.charAt(1);
                    sexo = request.getParameter("sexo");
                    final String query2 = "call VerAsignaturasDadas(" + idDocente + "," + ano + ",'" + grupo + "');";
                    final ResultSet resultados2 = sentencia.executeQuery(query2);
                    out.println("<br><br><br><h2>Selecciona la asignatura de la que quieras consultar tu puntuaci\u00f3n</h2><br>");
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">" + 
 "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.2\">" + 
 "                    <select name=\"idAsignatura\">" + 
 "");
                    while (resultados2.next()) {
                        out.println("<option value=" + resultados2.getString("idAsignatura") + ">" + resultados2.getString("Asignatura") + "</option>" + 
 "");
                    }
                    out.println("</select><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.2")) {
                idDocente = request.getParameter("idDocente");
                final String ano2 = request.getParameter("ano");
                final String grupo2 = request.getParameter("grupo");
                final String idAsignatura = request.getParameter("idAsignatura");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call PromedioCalificaciones(" + ano2 + ",'" + grupo2 + "','" + idDocente + "'," + idAsignatura + ");";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    int Claridad = 0;
                    int Ayuda = 0;
                    int Facilidad = 0;
                    int Recomendado = 0;
                    int Alumnos = 1;
                    if (resultados2.next()) {
                        Claridad = resultados2.getInt("Claridad") * 20;
                        Ayuda = resultados2.getInt("Ayuda") * 20;
                        Facilidad = resultados2.getInt("Facilidad") * 20;
                        Alumnos = resultados2.getInt("Alumnos");
                        if (Alumnos == 0) {
                            Alumnos = 1;
                        }
                    }
                    final Statement sentencia3 = con2.createStatement();
                    final String query3 = "call PromedioRecomendado(" + ano2 + ",'" + grupo2 + "','" + idDocente + "'," + idAsignatura + ");";
                    final ResultSet resultados3 = sentencia3.executeQuery(query3);
                    if (resultados3.next()) {
                        Recomendado = resultados3.getInt("Reco") * 100 / Alumnos;
                    }
                    out.println("<h2><span style=\"color:#00FF7C\">&#9733;</span><span style=\"color:#8B0000\">P</span><span style=\"color:#FF8C00\">u</span><span style=\"color:#32CD32\">n</span><span style=\"color:#00BFFF\">t</span><span style=\"color:#8B0000\">u</span><span style=\"color:#FF8C00\">a</span><span style=\"color:#32CD32\">c</span><span style=\"color:#00BFFF\">i</span><span style=\"color:#8B0000\">o</span><span style=\"color:#FF8C00\">n</span><span style=\"color:#32CD32\">e</span><span style=\"color:#00BFFF\">s</span><span style=\"color:#00FF7C\">&#9733;</span></h2><FONT SIZE=\"5\">");
                    if (Claridad < 40) {
                        out.println("<br><strong>Claridad.....<span style=\"color:#FF0000\">" + Claridad + "</span>/100");
                    }
                    else if (Claridad < 60) {
                        out.println("<br><strong>Claridad.....<span style=\"color:#FF4500\">" + Claridad + "</span>/100");
                    }
                    else if (Claridad < 80) {
                        out.println("<br><strong>Claridad.....<span style=\"color:#FF8C00\">" + Claridad + "</span>/100");
                    }
                    else if (Claridad <= 100) {
                        out.println("<br><strong>Claridad.....<span style=\"color:#00FF00\">" + Claridad + "</span>/100");
                    }
                    out.println("<h2><a target=\"_blank\" title=\"¿Qu\u00e9 tan claro explica el profesor los conceptos que se ense\u00f1an, independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>");
                    if (Ayuda < 40) {
                        out.println("<br><strong>Ayuda.....<span style=\"color:#FF0000\">" + Ayuda + "</span>/100");
                    }
                    else if (Ayuda < 60) {
                        out.println("<br><strong>Ayuda.....<span style=\"color:#FF4500\">" + Ayuda + "</span>/100");
                    }
                    else if (Ayuda < 80) {
                        out.println("<br><strong>Ayuda.....<span style=\"color:#FF8C00\">" + Ayuda + "</span>/100");
                    }
                    else if (Ayuda <= 100) {
                        out.println("<br><strong>Ayuda.....<span style=\"color:#00FF00\">" + Ayuda + "</span>/100");
                    }
                    out.println("<h2><a target=\"_blank\" title=\"¿Qu\u00e9 tanto ayuda el profesor a sus alumnos, ya sea con puntos extras, asesor\u00edas, etc. independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>");
                    if (Facilidad < 40) {
                        out.println("<br><strong>Facilidad.....<span style=\"color:#FF0000\">" + Facilidad + "</span>/100");
                    }
                    else if (Facilidad < 60) {
                        out.println("<br><strong>Facilidad.....<span style=\"color:#FF4500\">" + Facilidad + "</span>/100");
                    }
                    else if (Facilidad < 80) {
                        out.println("<br><strong>Facilidad.....<span style=\"color:#FF8C00\">" + Facilidad + "</span>/100");
                    }
                    else if (Facilidad <= 100) {
                        out.println("<br><strong>Facilidad.....<span style=\"color:#00FF00\">" + Facilidad + "</span>/100");
                    }
                    out.println("<h2><a target=\"_blank\" title=\"¿Qu\u00e9 tan f\u00e1cil es sacar una buena calificaci\u00f3n, asumiendo que el alumno cumple con todas las tareas y proyectos, independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>");
                    out.println("<br>Lo recomiendan el ");
                    if (Recomendado < 50) {
                        out.println("<span style=\"color:#FF0000\">" + Recomendado + "</span>");
                    }
                    else if (Recomendado < 70) {
                        out.println("<span style=\"color:#FF4500\">" + Recomendado + "</span>");
                    }
                    else if (Recomendado < 80) {
                        out.println("<span style=\"color:#FF8C00\">" + Recomendado + "</span>");
                    }
                    else if (Recomendado <= 100) {
                        out.println("<span style=\"color:#00FF00\">" + Recomendado + "</span>");
                    }
                    out.println("% de sus alumnos");
                    out.println("</FONT>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br></div>");
            }
            else if (opc.equals("3")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query4 = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con3 = DB.getConnection()) {
                        final Statement sentencia4 = con3.createStatement();
                        final ResultSet resultados4 = sentencia4.executeQuery(query4);
                        int i = 0;
                        while (resultados4.next()) {
                            if (resultados4.getInt("idTipo") == 1) {
                                ++i;
                                final String js = "Redirigir5(" + i + ");";
                                final String formu = "red" + i;
                                out.println("<form action=\"Docente\" method=\"POST\" name=" + formu + " id=" + formu + ">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">" + 
 "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados4.getString("idPersona") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados4.getString("Apaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados4.getString("Amaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados4.getString("Nombre") + ">" + 
 "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados4.getString("Nombre") + " " + resultados4.getString("Apaterno") + " " + resultados4.getString("Amaterno") + " <strong>" + resultados4.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con3.close();
                    }
                    catch (SQLException ex3) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                try (final Connection con4 = DB.getConnection()) {
                    final Statement sentencia5 = con4.createStatement();
                    final String query5 = "call VerDatosDocenteId(" + idDocente + ");";
                    final ResultSet resultados4 = sentencia5.executeQuery(query5);
                    out.println("<br><br><br><h2>¿En que grupo quieres agregar una incidencia?</h2><br>");
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">" + 
 "                    <select name=\"anogrupo\">" + 
 "");
                    while (resultados4.next()) {
                        out.println("<option value=" + resultados4.getString("Ano") + resultados4.getString("Grupo") + ">" + resultados4.getString("Ano") + "º " + resultados4.getString("Grupo") + "</option>" + 
 "");
                    }
                    out.println("</select><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br></div>");
                    con4.close();
                }
                catch (SQLException ex4) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    idDocente = request.getParameter("idDocente");
                    sexo = request.getParameter("sexo");
                    final String anogrupo = request.getParameter("anogrupo");
                    final char ano = anogrupo.charAt(0);
                    final char grupo = anogrupo.charAt(1);
                    int i = 1;
                    final String query6 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados5 = sentencia.executeQuery(query6);
                    out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>" + 
 "<th>#</th>" + 
 "<th>Alumno</td>" + 
 "<th>Reportar</th>" + 
 "</tr>" + 
 "");
                    while (resultados5.next()) {
                        out.println("<tr><td>" + i + "</td><td>" + resultados5.getString("Apaterno") + " " + resultados5.getString("Amaterno") + " " + resultados5.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">" + 
 "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">" + 
 "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados5.getString("Datos.idPersona") + ">" + 
 "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados5.getString("Datos.Nombre") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados5.getString("Datos.Apaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados5.getString("Datos.Amaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">" + 
 "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Reportar</button></form></th> " + 
 "");
                        out.println("</tr>");
                        ++i;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.2")) {
                idDocente = request.getParameter("idDocente");
                sexo = request.getParameter("sexo");
                final String idAlumno = request.getParameter("idAlumno");
                final String nombreA = request.getParameter("nombreA");
                final String apellidoP = request.getParameter("apellidoP");
                final String apellidoM = request.getParameter("apellidoM");
                out.println("<h3>Alumno a reportar: " + nombreA + " " + apellidoP + " " + apellidoM + "</h3><br>");
                out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"175\" height=\"210\"//>");
                out.println("</div><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS DE INDISCIPLINA LEVES</label><br>" + 
 "               <select name=\"incidencia1\">" + 
 "                     <option value=\"1\">Inasistencia injustificada a la escuela</option>" + 
 "                     <option value=\"2\">No entrar a una clase estando en la escuela</option>" + 
 "                     <option value=\"3\">Llegar tarde a la escuela o a las clases sin justificaci\u00f3n</option>" + 
 "                     <option value=\"4\">Utilizar dentro de la escuela sin autorizaci\u00f3n materiales prohibidos</option>" + 
 "                     <option value=\"5\">Estar en \u00e1reas que no corresponda a su actividad dentro del plantel</option>" + 
 "                     <option value=\"6\">No portar la credencial escolar</option>" + 
 "                     <option value=\"7\">Usar dispositivos electr\u00f3nicos de la escuela sin autorizaci\u00f3n</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"1\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS QUE PERTURBAN EL ORDEN</label><br>" + 
 "               <select name=\"incidencia2\">" + 
 "                     <option value=\"8\">Utilizar cerillos y/o encendedores</option>" + 
 "                     <option value=\"9\">Apostar y/o participar en juegos de azar</option>" + 
 "                     <option value=\"10\">Mentir, dar informaci\u00f3n falsa o enga\u00f1ar al personal escolar</option>" + 
 "                     <option value=\"11\">Hacer uso de las pertenencias de otros sin autorizaci\u00f3n</option>" + 
 "                     <option value=\"12\">Comportarse de una manera que perturbe el proceso educativo</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"2\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS ALTAMENTE PERTURBADORAS DEL ORDEN</label><br>" + 
 "               <select name=\"incidencia3\">" + 
 "                     <option value=\"13\">Salir de la clase sin permiso de alguna autoridad</option>" + 
 "                     <option value=\"14\">Ingresar a clase sin permiso del docente frente a grupo</option>" + 
 "                     <option value=\"15\">Asistir a la escuela con personas no autorizadas</option>" + 
 "                     <option value=\"16\">Da\u00f1ar, cambiar o modificar un registro o documento escolar</option>" + 
 "                     <option value=\"17\">Apropiarse de objetos que pertenecen a otra persona sin autorizaci\u00f3n</option>" + 
 "                     <option value=\"18\">Violar el reglamento sobre el uso de Internet</option>" + 
 "                     <option value=\"19\">Incurrir en conductas de deshonestidad acad\u00e9mica</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"3\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS QUE PROVOCAN PELIGRO</label><br>" + 
 "               <select name=\"incidencia4\">" + 
 "                     <option value=\"20\">Activar injustificadamente las alarmas</option>" + 
 "                     <option value=\"21\">Realizar una amenaza de bomba</option>" + 
 "                     <option value=\"22\">Provocar la combusti\u00f3n, detonaci\u00f3n de objetos o el riesgo de incendio</option>" + 
 "                     <option value=\"23\">Realizar actos de vandalismo o da\u00f1o a los bienes de alguien o de la escuela</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"4\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS DISCRIMINATORIAS</label><br>" + 
 "               <select name=\"incidencia5\">" + 
 "                     <option value=\"24\">Emplear insultos relacionados con la discriminaci\u00f3n</option>" + 
 "                     <option value=\"25\">Realizar actos de intimidaci\u00f3n por algun tipo de discriminaci\u00f3n</option>" + 
 "                     <option value=\"26\">Tratar de infligir o causar serios da\u00f1os de cualquier tipo</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"5\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS VIOLENTAS</label><br>" + 
 "               <select name=\"incidencia6\">" + 
 "                     <option value=\"27\">Utilizar expresiones verbales, lenguaje o gestos groseros o irrespetuosos</option>" + 
 "                     <option value=\"28\">Conductas de agresi\u00f3n f\u00edsica o similares, como juegos bruscos, o escupir a otra persona.</option>" + 
 "                     <option value=\"29\">Distribuir cualquier tipo de materiales que contengan calumnias, amenazas, da\u00f1os, etc.</option>" + 
 "                     <option value=\"30\">Incurrir en conductas de agresi\u00f3n f\u00edsica y/o juegos o bromas pesadas.</option>" + 
 "                     <option value=\"31\">Participar en actos de coerci\u00f3n o amenazas que impliquen violencia, da\u00f1os o perjuicios</option>" + 
 "                     <option value=\"32\">Planear, participar, realizar u ordenar actos de acoso escolar o bullying, incluso el cibern\u00e9tico</option>" + 
 "                     <option value=\"33\">Crear riesgo de lesiones ya sea mediante conductas imprudentes o la utilizaci\u00f3n de objetos</option>" + 
 "                     <option value=\"34\">Incitar o causar disturbios</option>" + 
 "                     <option value=\"35\">Utilizar la fuerza o amenazar utilizando la fuerza para apropiarse de los bienes de otros</option>" + 
 "                     <option value=\"36\">Utilizar la fuerza contra alguien de la comunidad escolar o intentar infligirles serios da\u00f1os</option>" + 
 "                     <option value=\"37\">Participar en un incidente de violencia grupal</option>" + 
 "                     <option value=\"38\">Participar en ri\u00f1as dentro y fuera del plantel</option>" + 
 "                     <option value=\"39\">Causar una lesi\u00f3n grave ya sea mediante conductas imprudentes o la utilizaci\u00f3n de objetos</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"6\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS AGRESIVA DE \u00cdNDOLE SEXUAL</label><br>" + 
 "               <select name=\"incidencia7\">" + 
 "                     <option value=\"40\">Emitir comentarios, insinuaciones o proposiciones con alguna sugerencia sexual</option>" + 
 "                     <option value=\"41\">Realizar actos de agresi\u00f3n sexual f\u00edsica, u obligar a otros a participar de una actividad sexual</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"7\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS DE RIEGO POR SUSTANCIAS T\u00d3XICO ADICTIVAS</label><br>" + 
 "               <select name=\"incidencia8\">" + 
 "                     <option value=\"42\">Posesi\u00f3n de sustancias t\u00f3xico-adictivas</option>" + 
 "                     <option value=\"43\">Consumo de sustancias t\u00f3xico-adictivas</option>" + 
 "                     <option value=\"44\">Distribuci\u00f3n de sustancias t\u00f3xico-adictivas</option>" + 
 "                     <option value=\"45\">Posesi\u00f3n de medicamentos sin que hayan sido prescritos por un m\u00e9dico</option>" + 
 "                     <option value=\"46\">Consumo de medicamentos sin prescripci\u00f3n m\u00e9dica.</option>" + 
 "                     <option value=\"47\">Distribuci\u00f3n de medicamentos</option>" + 
 "                     <option value=\"48\">Posesi\u00f3n de sustancias qu\u00edmicas industriales</option>" + 
 "                     <option value=\"49\">Consumo de sustancias qu\u00edmicas industriales</option>" + 
 "                     <option value=\"50\">Distribuci\u00f3n de sustancias qu\u00edmicas industriales</option>" + 
 "                     <option value=\"51\">Posesi\u00f3n de drogas</option>" + 
 "                     <option value=\"52\">Consumo de drogas</option>" + 
 "                     <option value=\"53\">Distribuci\u00f3n y venta de drogas</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"8\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS BLANCAS</label><br>" + 
 "               <select name=\"incidencia9\">" + 
 "                     <option value=\"54\">Posesi\u00f3n de un arma blanca o instrumento que ponga en riesgo a alguien</option>" + 
 "                     <option value=\"55\">Utilizar cualquier tipo de arma blanca, con el fin de tratar de da\u00f1ar a alguien</option>" + 
 "                     <option value=\"56\">Utilizar cualquier arma, lesionando a alguien</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"9\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Docente\" method=\"POST\">" + 
 "<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS DE FUEGO</label><br>" + 
 "               <select name=\"incidencia10\">" + 
 "                     <option value=\"57\">Poseer cualquier tipo de arma de fuego</option>" + 
 "                     <option value=\"58\">Utilizar cualquier arma de fuego con el fin de tratar de causar lesiones</option>" + 
 "                     <option value=\"59\">Utilizar cualquier arma de fuego lesionando a alguien</option>" + 
 "               </select><br>               <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "               <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
 "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
 "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">" + 
 "               <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"10\">" + 
 "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                out.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
                out.println("<div class=\"form-group center\">" + 
 "                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        </div>");
            }
            else if (opc.equals("3.3")) {
                final String idAlumno = request.getParameter("idAlumno");
                idDocente = request.getParameter("idDocente");
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
                final String query = "call AgregarIncidencia(" + idAlumno + "," + idDocente + ",'" + incidencia + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                try (final Connection con5 = DB.getConnection()) {
                    final Statement sentencia6 = con5.createStatement();
                    final ResultSet resultados2 = sentencia6.executeQuery(query);
                    out.println("<div class=\"form-group center\"><h3>Informe ingresado a la base de datos correctamente</h3></div><br>");
                    con5.close();
                }
                catch (SQLException ex5) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<div class=\"form-group center\">" + 
 "                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        </div>");
            }
            else if (opc.equals("4")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query4 = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con3 = DB.getConnection()) {
                        final Statement sentencia4 = con3.createStatement();
                        final ResultSet resultados4 = sentencia4.executeQuery(query4);
                        int i = 0;
                        while (resultados4.next()) {
                            if (resultados4.getInt("idTipo") == 1) {
                                ++i;
                                final String js = "Redirigir5(" + i + ");";
                                final String formu = "red" + i;
                                out.println("<form action=\"Docente\" method=\"POST\" name=" + formu + " id=" + formu + ">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">" + 
 "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados4.getString("idPersona") + ">" + 
 "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados4.getString("Nombre") + " " + resultados4.getString("Apaterno") + " " + resultados4.getString("Amaterno") + " <strong>" + resultados4.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con3.close();
                    }
                    catch (SQLException ex3) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                try (final Connection con4 = DB.getConnection()) {
                    final Statement sentencia5 = con4.createStatement();
                    final String query5 = "call VerDatosDocenteId(" + idDocente + ");";
                    final ResultSet resultados4 = sentencia5.executeQuery(query5);
                    out.println("<br><br><br><br><br><br><h2>¿De que grupo es el alumno?</h2>");
                    out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">" + 
 "<label>Grupo</label>" + 
 "                    <select name=\"anogrupo\">" + 
 "");
                    while (resultados4.next()) {
                        out.println("<option value=" + resultados4.getString("Ano") + resultados4.getString("Grupo") + ">" + resultados4.getString("Ano") + "º " + resultados4.getString("Grupo") + "</option>" + 
 "");
                    }
                    out.println("</select><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br><br><br><br></div>");
                    con4.close();
                }
                catch (SQLException ex4) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("4.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    idDocente = request.getParameter("idDocente");
                    sexo = request.getParameter("sexo");
                    final String anogrupo = request.getParameter("anogrupo");
                    final char ano = anogrupo.charAt(0);
                    final char grupo = anogrupo.charAt(1);
                    int i = 1;
                    final String query6 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados5 = sentencia.executeQuery(query6);
                    out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>" + 
 "<th>#</th>" + 
 "<th>Alumno</td>" + 
 "<th>Consultar</th>" + 
 "</tr>" + 
 "");
                    while (resultados5.next()) {
                        out.println("<tr><td>" + i + "</td><td>" + resultados5.getString("Apaterno") + " " + resultados5.getString("Amaterno") + " " + resultados5.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">" + 
 "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">" + 
 "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados5.getString("Datos.idPersona") + ">" + 
 "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados5.getString("Datos.Nombre") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados5.getString("Datos.Apaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados5.getString("Datos.Amaterno") + ">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">" + 
 "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Consultar</button></form></th> " + 
 "");
                        out.println("</tr>");
                        ++i;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("4.2")) {
                final String idAlumno = request.getParameter("idAlumno");
                String faltas = "0";
                String retardos = "0";
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    final Statement sentencia7 = con2.createStatement();
                    final String query7 = "call VerIncidenciasAlumnoId(" + idAlumno + ");";
                    final ResultSet resultados6 = sentencia7.executeQuery(query7);
                    final Statement sentencia8 = con2.createStatement();
                    final String query8 = "call TotalFaltas(" + idAlumno + ");";
                    final ResultSet resultados7 = sentencia8.executeQuery(query8);
                    if (resultados7.next()) {
                        faltas = resultados7.getString("Faltas");
                    }
                    final Statement sentencia9 = con2.createStatement();
                    final String query9 = "call TotalRetardos(" + idAlumno + ");";
                    final ResultSet resultados8 = sentencia9.executeQuery(query9);
                    if (resultados8.next()) {
                        retardos = resultados8.getString("Retardos");
                    }
                    out.println("</div><div class=\"col-sm-5 col-sm-offset-1\"><h2>Datos Personales</h2>");
                    String curp = "";
                    while (resultados2.next()) {
                        out.println("<h3>Nombre: " + resultados2.getString("Nombre") + "<br>Apellido Paterno: " + resultados2.getString("Apaterno") + "<br>Apellido Materno: " + resultados2.getString("Amaterno") + "<br>Nacimiento: " + resultados2.getString("Nacimiento") + "<br>Lentes: " + resultados2.getString("Lentes") + "<br>Zapatos Ortop\u00e9dicos: " + resultados2.getString("Zapatos") + "<br>Dificultades auditivas: " + resultados2.getString("Auditivo") + "<br>Comentario sobre el alumno: " + resultados2.getString("DatosExtraAlumno.Comentario") + "<br><br>Total de faltas: " + faltas + "<br>Total de retardos: " + retardos + "</h3><br><br>");
                        curp = resultados2.getString("Curp");
                    }
                    out.println("<br><br></div>");
                    out.println("<div class=\"col-sm-5\">");
                    out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"215\" height=\"258\"//>");
                    out.println("<br>");
                    out.println("                     <a target=\"_blank\" href=\"http://comunidadescolar.sepdf.gob.mx:8024/ConsultaCalificaciones/index.jsp\" class=\"btn btn-primary btn-lg\" style=\"background-color: #1E90FF\" onclick=\"copiarAlPortapapeles('pw');\">Calificaciones</a>" + 
 "");
                    out.println("</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
                    out.println("<br><br><br><br><br><br><br><div class=\"form-group center\">");
                    if (resultados6.next()) {
                        out.println("<h2>Incidencias</h2><br><strong>" + resultados6.getString("TipoIncidencia") + "</strong><br><h3>" + resultados6.getString("Incidencia") + "<br><br> Ocurrida el " + resultados6.getString("Fecha") + "<br>Reportada por " + resultados6.getString("Nombre del reportador") + " " + resultados6.getString("Apellido del reportador") + "<br></hr><br></h3>");
                    }
                    else {
                        out.println("<br><br><strong>Sin incidencias :D</strong><br><br><br>");
                    }
                    while (resultados6.next()) {
                        out.println("<strong>" + resultados6.getString("TipoIncidencia") + "</strong><br><h3>" + resultados6.getString("Incidencia") + "<br><br> Ocurrida el " + resultados6.getString("Fecha") + "<br>Reportada por " + resultados6.getString("Nombre del reportador") + " " + resultados6.getString("Apellido del reportador") + "<br></hr><br></h3>");
                    }
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><form name=\"formu\" action=\"Docente.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br><br><br><br>");
                out.println("</div>");
            }
            else if (opc.equals("5")) {
                idDocente = request.getParameter("idDocente");
                out.println("<br><br><br><br><br><br><h2>Por favor escribe tu nueva contrase\u00f1a</h2><br>");
                out.println("<form action=\"Docente\" method=\"POST\">" + 
 "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
 "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
 "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">" + 
 "                    <input type=\"text\" name=\"Pass\" placeholder=\"Contrase\u00f1a\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.1\"><br><br>" + 
 "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Cambiar Contrase\u00f1a</button>" + "<br><br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("5.1")) {
                final String idPersona = request.getParameter("idDocente");
                final String Pass = request.getParameter("Pass");
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia4 = con3.createStatement();
                    final String query10 = "call ModificarPass(" + idPersona + ",'" + Pass + "');";
                    final ResultSet resultados9 = sentencia4.executeQuery(query10);
                    out.println("<br><br><br><br><br><br><h2>Contrase\u00f1a modificada exitosamente :D</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Docente.jsp'\">Volver</button> " + 
 "                        <br><br><br><br><br><br><br></div>");
                    con3.close();
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("6")) {
                final String fechaNueva = request.getParameter("fecha");
                Funcion.ActualizarFecha(idDocente, fechaNueva);
                response.sendRedirect("Docente.jsp");
            }
            out.println("<footer id=\"footer\" class=\"midnight-blue\">" + 
 "        <div class=\"container\">" + 
 "            <div class=\"row\">" + 
 "                <div class=\"col-sm-6\">" + 
 "                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>" + 
 "                </div>" + 
 "                <div class=\"col-sm-6\">" + 
 "                    <ul class=\"pull-right\">" + 
 "                        <li>Se feliz</li>" + 
 "                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->" + 
 "                    </ul>" + 
 "                </div>" + 
 "            </div>" + 
 "        </div>" + 
 "    </footer><!--/#footer-->" + 
 "" + 
 "        " + 
 "    <script src=\"js/jquery.js\"></script>" + 
 "    <script src=\"js/bootstrap.min.js\"></script>" + 
 "    <script src=\"js/jquery.prettyPhoto.js\"></script>" + 
 "    <script src=\"js/jquery.isotope.min.js\"></script>" + 
 "    <script src=\"js/main.js\"></script>" + 
 "    <script src=\"js/wow.min.js\"></script>" + 
 "    </body>" + 
 "</html>" + 
 "");
        }
        catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
    }
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

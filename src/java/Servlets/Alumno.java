package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.SQLException;
import Clases.DB;
import Clases.Funciones;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Alumno extends HttpServlet
{
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Funciones Funcion = new Funciones();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            String idAlumno = request.getParameter("idAlumno");
            final String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            out.println("<!DOCTYPE html>\n<html lang=\"es\">\n    <head>\n<title>Alumno</title>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>         <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"Gerardo Arceo\">        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n       <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js\"></script>\n       <script type=\"text/javascript\" src=\"js/jquery.color.js\"></script>\n       <script type=\"text/javascript\" src=\"js/script1.js\"></script>       <script type=\"text/javascript\" src=\"js/script2.js\"></script>       <script type=\"text/javascript\" src=\"js/script3.js\"></script>       <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script><script type=\"text/javascript\">\n        function mostrar(){\n            document.getElementById('oculto').style.display = 'block';\n            document.getElementById('mostrado').style.display='none';\n        }</script>    </head><!--/head-->\n\n    <body>\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Alumno.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>\n" + "                                <ul class=\"dropdown-menu\">\n" + "<form method=\"post\" action=\"Alumno\" name=\"verdatos\">\n" + "                                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>\n" + "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>\n" + "                            </li>   \n" + "                        </ul>\n" + "                    </div>\n" + "                </div><!--/.container-->\n" + "            </nav><!--/nav-->\n" + "        </header><!--/header-->");
            String nombreT = "";
            String ApaternoT = "";
            String Parentesco = "";
            String SexoT = "";
            final String fecha = Funcion.VerFecha(idAlumno);
            final String diaActual = fecha.substring(8, 10);
            final String mesActual = fecha.substring(5, 7);
            final String anoActual = fecha.substring(0, 4);
            try (final Connection con = DB.getConnection()) {
                final Statement sentencia = con.createStatement();
                final String query = "call VerTutor(" + idAlumno + ");";
                final ResultSet resultados = sentencia.executeQuery(query);
                if (resultados.next()) {
                    nombreT = resultados.getString("Nombre");
                    ApaternoT = resultados.getString("Apaterno");
                    Parentesco = resultados.getString("Parentesco");
                    SexoT = resultados.getString("Sexo");
                }
            }
            catch (SQLException ex) {
                response.sendRedirect("Error.jsp");
            }
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idAlumno);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button> \n                        </div><br><br>");
            }
            else if (opc.equals("2")) {
                String curp = "";
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    if (resultados2.next()) {
                        curp = resultados2.getString("Datos.Curp");
                    }
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call VerIncidenciasAlumnoId(" + idAlumno + ");";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><h2>Incidencias</h2><br><br><br><br>");
                    if (resultados.next()) {
                        out.println("<strong>" + resultados.getString("TipoIncidencia") + "</strong><br><h3>" + resultados.getString("Incidencia") + "<br><br> Ocurrida el " + resultados.getString("Fecha") + "<br>Reportada por " + resultados.getString("Nombre del reportador") + " " + resultados.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    else {
                        out.println("<strong>Felicidades, no tienes ninguna incidencia :D</strong><br><br><br>");
                    }
                    while (resultados.next()) {
                        out.println("<strong>" + resultados.getString("TipoIncidencia") + "</strong><br><h3>" + resultados.getString("Incidencia") + "<br><br> Ocurrida el " + resultados.getString("Fecha") + "<br>Reportada por " + resultados.getString("Nombre del reportador") + " " + resultados.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><form name=\"formu\" action=\"Alumno.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br><br><br></div>");
            }
            else if (opc.equals("4")) {
                int i = 0;
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    resultados2.next();
                    final String ano = resultados2.getString("Ano");
                    final String grupo = resultados2.getString("Grupo");
                    final Statement sentencia3 = con2.createStatement();
                    final String query3 = "call VerDocentesGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados3 = sentencia3.executeQuery(query3);
                    out.println("<br><br><br><h2>Mis profesores</h2><br>");
                    while (resultados3.next()) {
                        ++i;
                        out.println("<h3>" + resultados3.getString("Apaterno") + " " + resultados3.getString("Amaterno") + " " + resultados3.getString("Nombre") + "<strong> . . . . . . . . " + resultados3.getString("Asignatura") + "</strong>" + "<form action=\"Alumno\" method=\"POST\">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + resultados3.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados3.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados3.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados3.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + resultados3.getString("idAsignatura") + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + resultados3.getString("Asignatura") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\"><i class=\"fa fa-pencil\"></i></button></form>" + "<br>");
                    }
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><form name=\"formu\" action=\"Alumno.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br><br><br></div>");
            }
            else if (opc.equals("4.1")) {
                final String idDocente = request.getParameter("idDocente");
                final String idAsignatura = request.getParameter("idAsignatura");
                final String Asignatura = request.getParameter("Asignatura");
                final String nombreA = request.getParameter("nombreA");
                final String apellidoP = request.getParameter("apellidoP");
                final String apellidoM = request.getParameter("apellidoM");
                final String ano = request.getParameter("ano");
                final String grupo = request.getParameter("grupo");
                int facilidad = 0;
                int ayuda = 0;
                int claridad = 0;
                String recomendado = null;
                String comentario = null;
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia4 = con3.createStatement();
                    final String query4 = "call VerUnaCalificacion(" + idDocente + "," + idAsignatura + "," + idAlumno + ");";
                    final ResultSet resultados4 = sentencia4.executeQuery(query4);
                    if (resultados4.next()) {
                        facilidad = resultados4.getInt("Facilidad");
                        ayuda = resultados4.getInt("Ayuda");
                        claridad = resultados4.getInt("Claridad");
                        recomendado = resultados4.getString("recomendado");
                        comentario = resultados4.getString("Comentario");
                    }
                    con3.close();
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("Docente a calificar: " + nombreA + " " + apellidoP + " " + apellidoM + "<br>Asignatura impartida: " + Asignatura + "<br><br>");
                out.println("<div id=\"mostrado\"><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"mostrar()\">Puntuaciones</button></div>");
                out.println("<div id=\"oculto\" style='display:none;'>");
                if (claridad == 0) {
                    out.println("No has calificado a\u00fan la claridad del docente.<br>");
                }
                else {
                    out.println("Puntuaci\u00f3n en claridad: " + claridad + ".<br>");
                }
                if (ayuda == 0) {
                    out.println("No has calificado a\u00fan la ayuda del docente.<br>");
                }
                else {
                    out.println("Puntuaci\u00f3n en ayuda: " + ayuda + ".<br>");
                }
                if (facilidad == 0) {
                    out.println("No has calificado a\u00fan la facilidad del docente.<br>");
                }
                else {
                    out.println("Puntuaci\u00f3n en facilidad: " + facilidad + ".<br>");
                }
                if (recomendado == null) {
                    out.println("No has dicho si recomiendas o no al docente.<br>");
                }
                else {
                    out.println("" + recomendado + " recomendar\u00eda a este docente.<br>");
                }
                if (comentario == null) {
                    out.println("No has escrito ningun comentario para el docente.<br>");
                }
                else {
                    out.println("Comentario: " + comentario + ".<br>");
                }
                out.println("</div><h2><br><hr><h3>OJO: La calificacion le pongas al docente ser\u00e1 de forma an\u00f3nima y el comentario solo lo podr\u00e1n ver los directivos.</h3><br><br>");
                out.println("<h2><span style=\"color:#00FF7C\">&#9733;</span><span style=\"color:#8B0000\">C</span><span style=\"color:#FF8C00\">l</span><span style=\"color:#32CD32\">a</span><span style=\"color:#00BFFF\">r</span><span style=\"color:#8B0000\">i</span><span style=\"color:#FF8C00\">d</span><span style=\"color:#32CD32\">a</span><span style=\"color:#00BFFF\">d</span><span style=\"color:#8B0000\"><span style=\"color:#00FF7C\">&#9733;</span></h2><h2><a target=\"_blank\" title=\"¿Qu\u00e9 tan claro explica el profesor los conceptos que se ense\u00f1an, independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>\t\t<ul id=\"raiting1\">\n\t\t\t<li><a href=\"#\">Muy confuso</a></li>\n\t\t\t<li><a href=\"#\">Confuso</a></li>\n\t\t\t<li><a href=\"#\">Algo claro</a></li>\n\t\t\t<li><a href=\"#\">Bastante claro</a></li>\n\t\t\t<li><a href=\"#\">S\u00faper claro</a></li>\n\t\t</ul>\n");
                out.println("<form action=\"Alumno\" method=\"POST\" name=\"cali1\" id=\"cali1\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                                <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura + ">\n" + "                    <input type=\"hidden\" name=\"claridad\" value=\"5\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\"></form>");
                out.println("<h2><span style=\"color:#00FF7C\">&#9733;</span><span style=\"color:#8B0000\">A</span><span style=\"color:#FF8C00\">y</span><span style=\"color:#32CD32\">u</span><span style=\"color:#00BFFF\">d</span><span style=\"color:#8B0000\">a</span><span style=\"color:#00FF7C\">&#9733;</span></h2><h2><a target=\"_blank\" title=\"¿Qu\u00e9 tanto ayuda el profesor a sus alumnos, ya sea con puntos extras, asesor\u00edas, etc. independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>\t\t<ul id=\"raiting2\">\n\t\t\t<li><a href=\"#\">No ayuda nada</a></li>\n\t\t\t<li><a href=\"#\">Le tienes que rogar por algo de ayuda</a></li>\n\t\t\t<li><a href=\"#\">Si le pides ayuda, te la da</a></li>\n\t\t\t<li><a href=\"#\">Lo m\u00e1s probable es que te ayude</a></li>\n\t\t\t<li><a href=\"#\">Ayuda bastante</a></li>\n\t\t</ul>\n");
                out.println("<form action=\"Alumno\" method=\"POST\" name=\"cali2\" id=\"cali2\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                                <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura + ">\n" + "                    <input type=\"hidden\" name=\"ayuda\" value=\"5\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\"></form>");
                out.println("<h2><span style=\"color:#00FF7C\">&#9733;</span><span style=\"color:#8B0000\">F</span><span style=\"color:#FF8C00\">a</span><span style=\"color:#32CD32\">c</span><span style=\"color:#00BFFF\">i</span><span style=\"color:#8B0000\">l</span><span style=\"color:#FF8C00\">i</span><span style=\"color:#32CD32\">d</span><span style=\"color:#00BFFF\">a</span><span style=\"color:#8B0000\">d</span><span style=\"color:#00FF7C\">&#9733;</span></h2><h2><a target=\"_blank\" title=\"¿Qu\u00e9 tan f\u00e1cil es sacar una buena calificaci\u00f3n, asumiendo que el alumno cumple con todas las tareas y proyectos, independientemente de la materia?\"><i class=\"fa fa-info-circle\"></i></a></h2>\t\t<ul id=\"raiting3\">\n\t\t\t<li><a href=\"#\">Muy dif\u00edcil</a></li>\n\t\t\t<li><a href=\"#\">Algo dif\u00edcil</a></li>\n\t\t\t<li><a href=\"#\">Lo usual</a></li>\n\t\t\t<li><a href=\"#\">Algo f\u00e1cil</a></li>\n\t\t\t<li><a href=\"#\">Super f\u00e1cil</a></li>\n\t\t</ul>\n");
                out.println("<form action=\"Alumno\" method=\"POST\" name=\"cali3\" id=\"cali3\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura + ">\n" + "                    <input type=\"hidden\" name=\"facilidad\" value=\"5\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\"></form>");
                out.println("<label>¿Recomendar\u00edas a este docente?</label><br><form action=\"Alumno\" method=\"post\" name=\"red\" id=\"red\">                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura + ">\n" + "                    <input type=\"hidden\" name=\"recomendado\" id=\"recomendado\" value=\"S\u00ed\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #008000\" required=\"required\" onclick=\"Redirigir()\">S\u00ed</button>" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #8B0000\" required=\"required\" onclick=\"NoRecomendar()\">No</button>" + "</form><br><br>");
                out.println("<form action=\"Alumno\" method=\"post\"><div class=\"form-group\">\n                            <label>Comentario sobre el docente</label><br>\n                            <textarea name=\"comentario\" id=\"message\" required=\"required\" class=\"form-control\" rows=\"8\" rows=\"16\"></textarea>\n                        </div>                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button>" + "</form></ul><br><br><br><br><br>");
                out.println("<form name=\"formu\" action=\"Alumno\" method=\"post\">                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4\">" + "     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button>" + "</form><br>" + "</div>");
            }
            else if (opc.equals("4.2")) {
                final String nombreA2 = request.getParameter("nombreA");
                final String apellidoP2 = request.getParameter("apellidoP");
                final String apellidoM2 = request.getParameter("apellidoM");
                final String idDocente2 = request.getParameter("idDocente");
                final String idAsignatura2 = request.getParameter("idAsignatura");
                final String Asignatura2 = request.getParameter("Asignatura");
                final String claridad2 = request.getParameter("claridad");
                final String ayuda2 = request.getParameter("ayuda");
                final String facilidad2 = request.getParameter("facilidad");
                final String recomendado2 = request.getParameter("recomendado");
                final String comentario2 = request.getParameter("comentario");
                String query5 = "";
                final String ano2 = request.getParameter("ano");
                final String grupo2 = request.getParameter("grupo");
                if (claridad2 != null) {
                    query5 = "call Claridad(" + idAlumno + "," + idDocente2 + "," + idAsignatura2 + "," + ano2 + ",'" + grupo2 + "'," + claridad2 + ",'" + anoActual + "-" + mesActual + "-" + diaActual + "')";
                }
                else if (ayuda2 != null) {
                    query5 = "call Ayuda(" + idAlumno + "," + idDocente2 + "," + idAsignatura2 + "," + ano2 + ",'" + grupo2 + "'," + ayuda2 + ",'" + anoActual + "-" + mesActual + "-" + diaActual + "')";
                }
                else if (facilidad2 != null) {
                    query5 = "call Facilidad(" + idAlumno + "," + idDocente2 + "," + idAsignatura2 + "," + ano2 + ",'" + grupo2 + "'," + facilidad2 + ",'" + anoActual + "-" + mesActual + "-" + diaActual + "')";
                }
                else if (recomendado2 != null) {
                    query5 = "call Recomendado(" + idAlumno + "," + idDocente2 + "," + idAsignatura2 + "," + ano2 + ",'" + grupo2 + "','" + recomendado2 + "','" + anoActual + "-" + mesActual + "-" + diaActual + "')";
                }
                else if (comentario2 != null) {
                    query5 = "call Comentario(" + idAlumno + "," + idDocente2 + "," + idAsignatura2 + "," + ano2 + ",'" + grupo2 + "','" + comentario2 + "','" + anoActual + "-" + mesActual + "-" + diaActual + "')";
                }
                try (final Connection con4 = DB.getConnection()) {
                    final Statement sentencia5 = con4.createStatement();
                    final ResultSet resultados4 = sentencia5.executeQuery(query5);
                    con4.close();
                }
                catch (SQLException ex4) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<form action=\"Alumno\" method=\"POST\" name=\"red\" id=\"red\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente2 + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + nombreA2 + ">\n" + "                                    <input type=\"hidden\" name=\"ano\" value=" + ano2 + ">\n" + "                                    <input type=\"hidden\" name=\"grupo\" value=" + grupo2 + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP2 + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM2 + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura2 + ">\n" + "                    <input type=\"hidden\" name=\"Asignatura\" value=" + Asignatura2 + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\"></form><script>Redirigir();</script>");
            }
            else if (opc.equals("5")) {
                idAlumno = request.getParameter("idAlumno");
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call TotalSituaciones(" + idAlumno + ");";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    while (resultados.next()) {
                        out.println("<br><br><br><br><h3>Total de <strong>" + resultados.getString("Situacion") + "</strong>: " + resultados.getString("Total") + "</h3><br>");
                    }
                    con.close();
                    out.println("<br><br><br><hr>");
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
                final ArrayList<String> Situaciones = (ArrayList<String>)Funcion.VerSituaciones(idAlumno);
                int x = 0;
                if (Situaciones.size() > x) {
                    out.println("<strong>" + Situaciones.get(x) + "</strong><br>" + "Fecha: " + Situaciones.get(x + 1) + "<hr>");
                    x += 3;
                }
                else {
                    out.println("<br><br><br><br><br><h2><strong>Felicidades, no tienes ningun reporte de faltas o impuntualidad :D</strong></h2><br><br><br><br><br>");
                }
                while (Situaciones.size() > x) {
                    out.println("<strong>" + Situaciones.get(x) + "</strong><br>" + "Fecha: " + Situaciones.get(x + 1) + "<hr>");
                    x += 3;
                }
                out.println("<br><br><br><form name=\"formu\" action=\"Alumno.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br><br><br></div>");
            }
            else if (opc.equals("6")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Alumno\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de alumno\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Alumno\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6\"><br><br>");
                    out.println("</form><h3>Toca al alumno que quieras denunciar</h3>");
                    final String query6 = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con5 = DB.getConnection()) {
                        final Statement sentencia6 = con5.createStatement();
                        final ResultSet resultados2 = sentencia6.executeQuery(query6);
                        int j = 0;
                        while (resultados2.next()) {
                            if (resultados2.getInt("idTipo") == 1) {
                                ++j;
                                final String js = "Redirigir5(" + j + ");";
                                final String formu = "red" + j;
                                out.println("<form action=\"Alumno\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">\n" + "                    <input type=\"hidden\" name=\"idAlumno2\" value=" + resultados2.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados2.getString("Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados2.getString("Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados2.getString("Amaterno") + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados2.getString("Nombre") + " " + resultados2.getString("Apaterno") + " " + resultados2.getString("Amaterno"));
                                out.println("</a></p></form>");
                            }
                        }
                        con5.close();
                    }
                    catch (SQLException ex5) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                out.println("<br><br><h2>¿De que grupo es el alumno a denunciar?</h2>");
                out.println("<form action=\"Alumno\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Alumno.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("6.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    idAlumno = request.getParameter("idAlumno");
                    sexo = request.getParameter("sexo");
                    final String ano3 = request.getParameter("ano");
                    final String grupo3 = request.getParameter("grupo");
                    int k = 1;
                    final String query7 = "call VerAlumnosGrupo(" + ano3 + ",'" + grupo3 + "');";
                    final ResultSet resultados5 = sentencia.executeQuery(query7);
                    out.println("<h2>Alumnos del grupo " + ano3 + "º " + grupo3 + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Denunciar</th>\n</tr>\n");
                    while (resultados5.next()) {
                        out.println("<tr><td>" + k + "</td><td>" + resultados5.getString("Apaterno") + " " + resultados5.getString("Amaterno") + " " + resultados5.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Alumno\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano3 + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo3 + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno2\" value=" + resultados5.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados5.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados5.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados5.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Denunciar</button></form></th> \n");
                        out.println("</tr>");
                        ++k;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Alumno.jsp'\">Volver</button> \n                        <br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("6.2")) {
                idAlumno = request.getParameter("idAlumno");
                sexo = request.getParameter("sexo");
                final String idAlumno2 = request.getParameter("idAlumno2");
                final String nombreA3 = request.getParameter("nombreA");
                final String apellidoP3 = request.getParameter("apellidoP");
                final String apellidoM3 = request.getParameter("apellidoM");
                out.println("<h3>Alumno a denunciar: <strong>" + nombreA3 + " " + apellidoP3 + " " + apellidoM3 + "</strong></h3><br>");
                out.println("<img src=\"F?idAlumno=" + idAlumno2 + "\" width=\"175\" height=\"210\"//>");
                out.println("<br><br><br><br>                        <h2>OJO:</h2>\n                        <div class=\"container\"><div class=\"skill-wrap clearfix\">\n                <div class=\"center wow fadeInDown\"><p class=\"lead\">Tu denuncia es completamente an\u00f3nima, no tengas miedo de escribir la situaci\u00f3n por la que est\u00e1s pasando t\u00fa o alg\u00fan otro compa\u00f1ero nos ser\u00eda de mucha ayuda detectar a los compa\u00f1eros que no saben convivir sanamente, si tienes alguna propuesta sobre c\u00f3mo solucionar el problema, por favor escr\u00edbela en el recuadro de continuaci\u00f3n...</p></div>\n            </div></div>");
                out.println("<th><form action=\"Alumno\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno2\" value=" + idAlumno2 + ">\n" + "                    <textarea name=\"descripcion\" id=\"message\" placeholder=\"Describe el tipo de bullying que tu compa\u00f1ero ha realizado contra ti o contra algun otro compa\u00f1ero, si te apetece escribe alguna propuesta para solucionar el problema, muchas gracias por denunciar :D las personas como t\u00fa que se defienden y defienden a los dem\u00e1s son un ejemplo a seguir ;)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.3\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Ingresar Denuncia</button></form></th> \n");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Alumno.jsp'\">Volver</button> \n                        <br><br><br></div>");
            }
            else if (opc.equals("6.3")) {
                idAlumno = request.getParameter("idAlumno");
                final String idAlumno2 = request.getParameter("idAlumno2");
                final String descripcion = request.getParameter("descripcion");
                final String query8 = "call AgregarDenuncia(" + idAlumno + "," + idAlumno2 + ",'" + descripcion + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                try (final Connection con6 = DB.getConnection()) {
                    final Statement sentencia7 = con6.createStatement();
                    final ResultSet resultados6 = sentencia7.executeQuery(query8);
                    out.println("<br><br><br><h3>Much\u00edsimas gracias por denunciar, muy pronto resolveremos el problema :)</h3><br><br><br><br>");
                    con6.close();
                }
                catch (SQLException ex6) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Alumno.jsp'\">Volver</button> \n                        <br><br><br></div>");
            }
            out.println("<footer id=\"footer\" class=\"midnight-blue\">\n        <div class=\"container\">\n            <div class=\"row\">\n                <div class=\"col-sm-6\">\n                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>\n                </div>\n                <div class=\"col-sm-6\">\n                    <ul class=\"pull-right\">\n                        <li>Se feliz</li>\n                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </footer><!--/#footer-->\n    </body>\n</html>\n");
        }
        catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
    }
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

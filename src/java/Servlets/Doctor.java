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

public class Doctor extends HttpServlet
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
            String idDoctor = request.getParameter("idDoctor");
            final String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            final String fecha = Funcion.VerFecha(idDoctor);
            final String diaActual = fecha.substring(8, 10);
            final String mesActual = fecha.substring(5, 7);
            final String anoActual = fecha.substring(0, 4);
            out.println("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"\">\n        <title>M\u00e9dico</title>\n\n        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n    </head><!--/head-->\n\n    <body class=\"homepage\">\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Doctor.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>\n" + "                                <ul class=\"dropdown-menu\">\n" + "<form method=\"post\" action=\"Doctor\" name=\"verdatos\">\n" + "                                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>\n" + "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>\n" + "                            </li>   \n" + "                        </ul>\n" + "                    </div>\n" + "                </div><!--/.container-->\n" + "            </nav><!--/nav-->\n" + "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idDoctor);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Cambiar Contrase\u00f1a</button></form>                        <br><br>");
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        </div><br><br>");
            }
            else if (opc.equals("2")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con = DB.getConnection()) {
                        final Statement sentencia = con.createStatement();
                        final ResultSet resultados = sentencia.executeQuery(query);
                        int i = 0;
                        while (resultados.next()) {
                            if (resultados.getInt("idTipo") == 1) {
                                ++i;
                                final String js = "Redirigir5(" + i + ");";
                                final String formu = "red" + i;
                                out.println("<form action=\"Doctor\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.2\">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados.getString("Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados.getString("Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados.getString("Nombre") + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con.close();
                    }
                    catch (SQLException ex) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                out.println("<br><br><br><br><br><br><h2>¿De que grupo es el alumno?</h2>");
                out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("2.1")) {
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    idDoctor = request.getParameter("idDoctor");
                    sexo = request.getParameter("sexo");
                    final String ano = request.getParameter("ano");
                    final String grupo = request.getParameter("grupo");
                    int j = 1;
                    final String query2 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    out.println("<br><br><br><h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Reportar</th>\n</tr>\n");
                    while (resultados2.next()) {
                        out.println("<tr><td>" + j + "</td><td>" + resultados2.getString("Apaterno") + " " + resultados2.getString("Amaterno") + " " + resultados2.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados2.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados2.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados2.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados2.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.2\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Reportar</button></form></th> \n");
                        out.println("</tr>");
                        ++j;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.2")) {
                idDoctor = request.getParameter("idDoctor");
                sexo = request.getParameter("sexo");
                final String idAlumno = request.getParameter("idAlumno");
                final String nombreA = request.getParameter("nombreA");
                final String apellidoP = request.getParameter("apellidoP");
                final String apellidoM = request.getParameter("apellidoM");
                final String ano2 = request.getParameter("ano");
                final String grupo2 = request.getParameter("grupo");
                out.println("<h3>Alumno a reportar: " + nombreA + " " + apellidoP + " " + apellidoM + "</h3><br>");
                out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"175\" height=\"210\"//>");
                out.println("<br><br><br><br>");
                out.println("<form action=\"Doctor\" method=\"POST\">\n<label>Informe Medico</label><br>\n<textarea name=\"incidencia\" placeholder=\"(Ej.Fuerte dolor de cabeza y nauseas, se tuvo que retirar a su casa, medicamento recomendado Paracetamol)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>\n               <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "               <input type=\"hidden\" name=\"tipo\" value=\"Buena\">\n" + "               <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "               <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "               <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "               <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "               <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Reporte</button>");
                out.println("<br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
            }
            else if (opc.equals("2.3")) {
                final String idAlumno = request.getParameter("idAlumno");
                idDoctor = request.getParameter("idDoctor");
                final String incidencia = request.getParameter("incidencia");
                final String query3 = "call AgregarIncidenciaMedica(" + idAlumno + "," + idDoctor + ",'" + incidencia + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia3 = con3.createStatement();
                    final ResultSet resultados3 = sentencia3.executeQuery(query3);
                    out.println("<br><br><br><br><br><br><h3>Informe ingresado a la base de datos correctamente</h3><br>");
                    con3.close();
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("3")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con = DB.getConnection()) {
                        final Statement sentencia = con.createStatement();
                        final ResultSet resultados = sentencia.executeQuery(query);
                        int i = 0;
                        while (resultados.next()) {
                            if (resultados.getInt("idTipo") == 1) {
                                ++i;
                                final String js = "Redirigir5(" + i + ");";
                                final String formu = "red" + i;
                                out.println("<form action=\"Doctor\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con.close();
                    }
                    catch (SQLException ex) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                out.println("<br><br><br><br><br><br><h2>¿De que grupo es el alumno?</h2>");
                out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("3.1")) {
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    idDoctor = request.getParameter("idDoctor");
                    sexo = request.getParameter("sexo");
                    final String ano = request.getParameter("ano");
                    final String grupo = request.getParameter("grupo");
                    int j = 1;
                    final String query2 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados2 = sentencia2.executeQuery(query2);
                    out.println("<br><br><br><h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Consultar</th>\n</tr>\n");
                    while (resultados2.next()) {
                        out.println("<tr><td>" + j + "</td><td>" + resultados2.getString("Apaterno") + " " + resultados2.getString("Amaterno") + " " + resultados2.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"ano\" value=" + ano + ">\n" + "                    <input type=\"hidden\" name=\"grupo\" value=" + grupo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados2.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados2.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados2.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados2.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Consultar</button></form></th> \n");
                        out.println("</tr>");
                        ++j;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.2")) {
                final String idAlumno = request.getParameter("idAlumno");
                String comentarioAlu = "";
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query4 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados3 = sentencia.executeQuery(query4);
                    final Statement sentencia4 = con.createStatement();
                    final String query5 = "call VerIncidenciasMedicasAlumnoId(" + idAlumno + ");";
                    final ResultSet resultados4 = sentencia4.executeQuery(query5);
                    out.println("</div><div class=\"col-sm-5 col-sm-offset-1\"><h2>Datos Personales</h2><br>");
                    if (resultados3.next()) {
                        out.println("<h3>Nombre: " + resultados3.getString("Nombre") + "<br>Apellido Paterno: " + resultados3.getString("Apaterno") + "<br>Apellido Materno: " + resultados3.getString("Amaterno") + "<br>Nacimiento: " + resultados3.getString("Nacimiento") + "<br>Peso: " + resultados3.getString("Peso") + "<br>Estatura: " + resultados3.getString("Estatura") + "<br>Lentes: " + resultados3.getString("Lentes") + "<br>Zapatos Ortop\u00e9dicos: " + resultados3.getString("Zapatos") + "<br>Dificultades auditivas: " + resultados3.getString("Auditivo") + "");
                        comentarioAlu = resultados3.getString("DatosExtraAlumno.Comentario");
                    }
                    out.println("</div>");
                    out.println("<div class=\"col-sm-5\">");
                    out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"215\" height=\"258\"//>");
                    out.println("</div><br><br><br><br><br><br><br><br><br><br><br>");
                    out.println("<br><br><br><br><br><br><br><div class=\"form-group center\">");
                    out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idApoyo\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.21\">\n" + "                    <textarea name=\"comentarioAlu\" class=\"form-control\" rows=\"8\">" + comentarioAlu + "</textarea>\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Modificar Comentario</button></form>");
                    out.println("<br><br><br><br>");
                    if (resultados4.next()) {
                        out.println("<h2>Incidencias M\u00e9dicas</h2><br><h3>" + resultados4.getString("Incidencia") + "<br>Ocurrida el " + resultados4.getString("Fecha") + "<br>Reportada por " + resultados4.getString("Nombre del reportador") + " " + resultados4.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    else {
                        out.println("<strong>No hay incidencias m\u00e9dicas :D</strong><br><br><br><br>");
                    }
                    while (resultados4.next()) {
                        out.println("<h3>" + resultados4.getString("Incidencia") + "<br>Ocurrida el " + resultados4.getString("Fecha") + "<br>Reportada por " + resultados4.getString("Nombre del reportador") + " " + resultados4.getString("Apellido del reportador") + "<br><hr><br></h3>");
                    }
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><form name=\"formu\" action=\"Doctor.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form>");
                out.println("<br><br><br><br></div>");
            }
            else if (opc.equals("3.21")) {
                final String idAlumno = request.getParameter("idAlumno");
                final String comentarioAlu = request.getParameter("comentarioAlu");
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query4 = "call ModificarComentarioAlumno(" + idAlumno + ",'" + comentarioAlu + "');";
                    final ResultSet resultados3 = sentencia.executeQuery(query4);
                    out.println("<form action=\"Doctor\" method=\"POST\" name=\"red\" id=\"red\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\"></form>\n");
                    out.println("<script>Redirigir();</script>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("4")) {
                idDoctor = request.getParameter("idDoctor");
                out.println("<br><br><br><br><br><br><h2>Por favor escribe tu nueva contrase\u00f1a</h2><br>");
                out.println("<form action=\"Doctor\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDoctor\" value=" + idDoctor + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"Pass\" placeholder=\"Contrase\u00f1a\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\"><br><br>\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Cambiar Contrase\u00f1a</button>" + "<br><br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("4.1")) {
                final String idPersona = request.getParameter("idDoctor");
                final String Pass = request.getParameter("Pass");
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query4 = "call ModificarPass(" + idPersona + ",'" + Pass + "');";
                    final ResultSet resultados3 = sentencia.executeQuery(query4);
                    out.println("<br><br><br><br><br><br><h2>Contrase\u00f1a modificada exitosamente :D</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Doctor.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
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

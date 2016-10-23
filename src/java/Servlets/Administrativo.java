package Servlets;

import java.io.InputStream;
import javax.servlet.http.Part;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import Clases.DB;
import Clases.Funciones;
import Clases.UsuarioDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Administrativo extends HttpServlet
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
            String idAdministrativo = request.getParameter("idAdministrativo");
            final String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            out.println("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"\">\n        <title>Administrativo</title>\n\n        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n    </head><!--/head-->\n\n    <body class=\"homepage\">\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Administrativo.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>\n" + "                                <ul class=\"dropdown-menu\">\n" + "<form method=\"post\" action=\"Administrativo\" name=\"verdatos\">\n" + "                                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>\n" + "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>\n" + "                            </li>   \n" + "                        </ul>\n" + "                    </div>\n" + "                </div><!--/.container-->\n" + "            </nav><!--/nav-->\n" + "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                idAdministrativo = request.getParameter("idAdministrativo");
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idAdministrativo);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div><br><br>");
            }
            else if (opc.equals("2")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2\"><br><br>");
                    out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                    final String query = "call BuscarPersona('^" + buscado + "');";
                    try (final Connection con = DB.getConnection()) {
                        final Statement sentencia = con.createStatement();
                        final ResultSet resultados = sentencia.executeQuery(query);
                        int i = 0;
                        while (resultados.next()) {
                            ++i;
                            final String js = "Redirigir5(" + i + ");";
                            final String formu = "red" + i;
                            if (resultados.getInt("idTipo") == 1) {
                                out.println("<form action=\"Administrativo\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                            else {
                                if (resultados.getInt("idTipo") > 4) {
                                    continue;
                                }
                                final int tipo = resultados.getInt("idTipo");
                                String s = "";
                                switch (tipo) {
                                    case 2: {
                                        s = "Docente";
                                        break;
                                    }
                                    case 3: {
                                        s = "Apoyo";
                                        break;
                                    }
                                    case 4: {
                                        s = "Doctor";
                                        break;
                                    }
                                    default: {
                                        response.sendRedirect("Error.jsp");
                                        break;
                                    }
                                }
                                out.println("<form action=\"Administrativo\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.5\">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"s\" value=" + s + ">\n" + "                    <input type=\"hidden\" name=\"tipo\" value=" + tipo + ">\n" + "<br>");
                                out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Persona\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                out.println("</a></p></form>");
                            }
                        }
                        con.close();
                    }
                    catch (SQLException ex) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                out.println("<br><br><br><h2>¿Que tipo de usuario quieres modificar?</h2>");
                out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.1\">\n" + "                    <select name=\"tipo\">\n" + "<option value=\"1\">Alumno</option>" + "<option value=\"2\">Docente</option>" + "<option value=\"3\">Apoyo</option>" + "<option value=\"4\">M\u00e9dico</option>" + "<option value=\"5\">Yo</option>" + "</select><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div><br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("2.1")) {
                idAdministrativo = request.getParameter("idAdministrativo");
                final int tipo2 = Integer.parseInt(request.getParameter("tipo"));
                String u = "";
                String s2 = "";
                int j = 1;
                if (tipo2 >= 2) {
                    if (tipo2 == 5) {
                        out.println("<form action=\"Administrativo\" method=\"POST\" name=\"red\" id=\"red\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"s\" value=\"Administrativo\">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.5\">\n" + "                    </form>");
                        out.println("<script>Redirigir();</script>");
                    }
                    else {
                        switch (tipo2) {
                            case 2: {
                                u = "Docentes";
                                s2 = "Docente";
                                break;
                            }
                            case 3: {
                                u = "Apoyos";
                                s2 = "Apoyo";
                                break;
                            }
                            case 4: {
                                u = "Doctores";
                                s2 = "Doctor";
                                break;
                            }
                            default: {
                                response.sendRedirect("Error.jsp");
                                break;
                            }
                        }
                        final ArrayList<String> Personas = (ArrayList<String>)Funcion.VerPersonas(u);
                        out.println("<h2>" + u + " registrados en el sistema</h2><br>");
                        out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>" + s2 + "</td>\n" + "<th>Modificar</th>\n" + "</tr>\n");
                        for (int x = 0; Personas.size() > x; x += 4, ++j) {
                            out.println("<tr><td>" + j + "</td><td>" + Personas.get(x + 1) + " " + Personas.get(x + 2) + " " + Personas.get(x) + "</td>");
                            out.println("<th><form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"s\" value=" + s2 + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x + 3) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.5\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Modificar</button></form></th> \n");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("<br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button></div>");
                    }
                }
                else if (tipo2 == 1) {
                    idAdministrativo = request.getParameter("idAdministrativo");
                    sexo = request.getParameter("sexo");
                    out.println("<br><br><br><br><br><br><h2>¿De que grupo es el alumno?</h2>");
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.2\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                    out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                    out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.2")) {
                idAdministrativo = request.getParameter("idAdministrativo");
                sexo = request.getParameter("sexo");
                final String ano = request.getParameter("ano");
                final String grupo = request.getParameter("grupo");
                int k = 1;
                final ArrayList<String> Alumnos = (ArrayList<String>)Funcion.VerGrupo(ano, grupo);
                out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Modificar</th>\n</tr>\n");
                for (int x2 = 0; Alumnos.size() > x2; x2 += 4) {
                    out.println("<tr><td>" + k + "</td><td>" + Alumnos.get(x2 + 1) + " " + Alumnos.get(x2 + 2) + " " + Alumnos.get(x2) + "</td>");
                    out.println("<th><form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.3\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Modificar</button></form></th> \n");
                    out.println("</tr>");
                    ++k;
                }
                out.println("</table>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("2.3")) {
                final String idAlumno = request.getParameter("idAlumno");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call VerDatos(" + idAlumno + ");";
                    final ResultSet resultados = sentencia2.executeQuery(query2);
                    if (resultados.next()) {
                        out.println("</div><section id=\"contact-page\">\n        <div class=\"container\">\n            <div class=\"center\"> \n                <br>\n                <h2>Modificar Alumno</h2>\n            </div> \n            <div class=\"row contact-wrap\"> \n                <div class=\"status alert alert-success\" style=\"display: none\"></div>\n                \n                <form enctype=\"multipart/form-data\" id=\"main-contact-form\" class=\"contact-form\" name=\"contact-form\" method=\"post\" action=\"Administrativo\">\n                    <div class=\"col-sm-5 col-sm-offset-1\">\n                        \n                        <fieldset>\n                        <h2>Datos Personales</h2>\n                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.4\">\n                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                        <div class=\"form-group\">\n" + "                            <label>Nombre</label>\n" + "                            <input type=\"text\" name=\"nombre1\" value=\"" + resultados.getString("Nombre") + "\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Paterno</label>\n" + "                            <input type=\"text\" name=\"Apaterno\" value=\"" + resultados.getString("Apaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Materno</label>\n" + "                            <input type=\"text\" name=\"Amaterno\" value=\"" + resultados.getString("Amaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Grado</label>\n" + "<select name=\"ano\">");
                        if (resultados.getString("Ano").equals("1")) {
                            out.println("<option selected value=\"1\">1º</option>\n                                <option value=\"2\">2º</option>\n                                <option value=\"3\">3º</option>");
                        }
                        else if (resultados.getString("Ano").equals("2")) {
                            out.println("<option value=\"1\">1º</option>\n                                <option selected value=\"2\">2º</option>\n                                <option value=\"3\">3º</option>");
                        }
                        else if (resultados.getString("Ano").equals("3")) {
                            out.println("<option value=\"1\">1º</option>\n                                <option value=\"2\">2º</option>\n                                <option selected value=\"3\">3º</option>");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Grupo</label>\n                            <select name=\"grupo\" selected=\"B\">\n");
                        if (resultados.getString("Grupo").equals("A")) {
                            out.println("<option selected value=\"A\">A</option>\n                                <option value=\"B\">B</option>\n                                <option value=\"C\">C</option>\n                                <option value=\"D\">D</option>\n                                <option value=\"E\">E</option>\n");
                        }
                        else if (resultados.getString("Grupo").equals("B")) {
                            out.println("<option value=\"A\">A</option>\n                                <option selected value=\"B\">B</option>\n                                <option value=\"C\">C</option>\n                                <option value=\"D\">D</option>\n                                <option value=\"E\">E</option>\n");
                        }
                        else if (resultados.getString("Grupo").equals("C")) {
                            out.println("<option value=\"A\">A</option>\n                                <option value=\"B\">B</option>\n                                <option selected value=\"C\">C</option>\n                                <option value=\"D\">D</option>\n                                <option value=\"E\">E</option>\n");
                        }
                        else if (resultados.getString("Grupo").equals("D")) {
                            out.println("<option value=\"A\">A</option>\n                                <option value=\"B\">B</option>\n                                <option value=\"C\">C</option>\n                                <option selected value=\"D\">D</option>\n                                <option value=\"E\">E</option>\n");
                        }
                        else if (resultados.getString("Grupo").equals("E")) {
                            out.println("<option value=\"A\">A</option>\n                                <option value=\"B\">B</option>\n                                <option value=\"C\">C</option>\n                                <option value=\"D\">D</option>\n                                <option selected value=\"E\">E</option>\n");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Sexo</label>\n                            <select name=\"sexo1\" selected=" + resultados.getString("Sexo") + ">\n");
                        if (resultados.getString("Sexo").equals("Masculino")) {
                            out.println("<option selected value=\"Masculino\">Masculino</option>\n                                <option value=\"Femenino\">Femenino</option>\n");
                        }
                        else if (resultados.getString("Sexo").equals("Femenino")) {
                            out.println("<option value=\"Masculino\">Masculino</option>\n                                <option selected value=\"Femenino\">Femenino</option>\n");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Fecha de nacimiento</label>\n                            <input type=\"date\" value=" + resultados.getString("Nacimiento") + " name=\"nacimiento\" min=\"2000-01-01\" max=\"2010-01-01\" class=\"form-control\">\n" + "                        </div>        \n" + "                        <div class=\"form-group\">\n" + "                            <label>CURP</label>\n" + "                            <input type=\"text\" value=" + resultados.getString("Curp") + " name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>E-Mail</label>\n" + "                            <input type=\"email\" value=" + resultados.getString("Email") + " name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Celular</label>\n" + "                            <input type=\"number\" value=" + resultados.getString("Celular") + " name=\"celular\" class=\"form-control\" size=\"12\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Telefono de casa</label>\n" + "                            <input type=\"number\" value=" + resultados.getString("Telefono") + " name=\"telefono\" class=\"form-control\" size=\"10\">\n" + "                        </div><br><br>\n" + "                        </fieldset>\n" + "                        \n" + "                        <fieldset>\n" + "                            <h2>Datos Medicos</h2>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Peso</label>\n" + "                            <input type=\"text\" value=" + resultados.getString("Peso") + " name=\"peso\" class=\"form-control\" size=\"10\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Estatura</label>\n" + "                            <input type=\"text\" value=" + resultados.getString("Estatura") + " name=\"estatura\" class=\"form-control\" size=\"10\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>¿Necesitas lentes?</label><br>\n" + "                            <select name=\"lentes\">\n");
                        if (resultados.getString("Lentes").equals("s")) {
                            out.println("<option selected value=\"s\">Si</option>\n                                <option value=\"n\">No</option>\n");
                        }
                        else if (resultados.getString("Lentes").equals("n")) {
                            out.println("<option value=\"s\">Si</option>\n                                <option selected value=\"n\">No</option>\n");
                        }
                        out.println("</select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                        <label>¿Necesitas zapatos ortopedicos?</label><br>\n                            <select name=\"zapatos\">\n");
                        if (resultados.getString("Zapatos").equals("s")) {
                            out.println("<option selected value=\"s\">Si</option>\n                                <option value=\"n\">No</option>\n");
                        }
                        else if (resultados.getString("Zapatos").equals("n")) {
                            out.println("<option value=\"s\">Si</option>\n                                <option selected value=\"n\">No</option>\n");
                        }
                        out.println("</select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                        <label>¿Tienes dificultades auditivas?</label><br>\n                            <select name=\"auditivo\">\n");
                        if (resultados.getString("Auditivo").equals("s")) {
                            out.println("<option selected value=\"s\">Si</option>\n                                <option value=\"n\">No</option>\n");
                        }
                        else if (resultados.getString("Auditivo").equals("n")) {
                            out.println("<option value=\"s\">Si</option>\n                                <option selected value=\"n\">No</option>\n");
                        }
                        out.println("</select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Algun comentario sobre tu salud o persona?</label>\n                            <textarea name=\"comentarioAlu\" id=\"message\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados.getString("DatosExtraAlumno.Comentario") + "</textarea>\n" + "                        </div>" + "                        <div class=\"form-group\">\n" + "                        <label>Afiliacion Medica</label><br>\n" + "                            <select name=\"afiliacion\">");
                        if (resultados.getString("Afiliacion").equals("ISSSTE")) {
                            out.println("<option selected value=\"ISSSTE\">ISSSTE</option>\n                                <option value=\"IMSS\">IMSS</option>\n                                <option value=\"Otro\">Otro</option>\n                                <option value=\"Ninguno\">Ninguno</option>");
                        }
                        else if (resultados.getString("Afiliacion").equals("IMSS")) {
                            out.println("<option value=\"ISSSTE\">ISSSTE</option>\n                                <option selected value=\"IMSS\">IMSS</option>\n                                <option value=\"Otro\">Otro</option>\n                                <option value=\"Ninguno\">Ninguno</option>");
                        }
                        else if (resultados.getString("Afiliacion").equals("Otro")) {
                            out.println("<option value=\"ISSSTE\">ISSSTE</option>\n                                <option value=\"IMSS\">IMSS</option>\n                                <option selected value=\"Otro\">Otro</option>\n                                <option value=\"Ninguno\">Ninguno</option>");
                        }
                        else if (resultados.getString("Afiliacion").equals("Ninguno")) {
                            out.println("<option value=\"ISSSTE\">ISSSTE</option>\n                                <option value=\"IMSS\">IMSS</option>\n                                <option value=\"Otro\">Otro</option>\n                                <option selected value=\"Ninguno\">Ninguno</option>");
                        }
                        out.println("</selected></div><br>                        </fieldset><br><br><br><br>\n                        \n                        <fieldset><br><br><br><br>\n                        <h2>Datos de acceso</h2>\n                        <div class=\"form-group\">\n                            <label>Usuario</label>\n                            <input type=\"text\" value=\"" + resultados.getString("Usuario") + "\" name=\"usuario\" class=\"form-control\" size=\"20\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Contrase\u00f1a</label>\n" + "                            <input type=\"password\" value=" + resultados.getString("Pass") + " name=\"pass\" class=\"form-control\" size=\"20\">\n" + "                        </div>\n" + "                        </fieldset>\n" + "                    </div>\n" + "  \n" + "                    <div class=\"col-sm-5\">\n" + "<fieldset>\n" + "                        <h2>Fotograf\u00eda</h2>");
                        out.println("<p><img src=\"F?idAlumno=" + idAlumno + "\" width=\"87\" height=\"105\" align=\"left\">Fotograf\u00eda Actual</p>");
                        final String folio = resultados.getString("Folio");
                        out.println("                        <input type=\"file\" name=\"foto\"/><br>                         <input type=\"text\" name=\"folio\" value=" + folio + "> Folio<br> " + "                        <fieldset>\n" + "                        <h2>Direcci\u00f3n</h2>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Calle</label>\n" + "                            <input type=\"text\" value=\"" + resultados.getString("Calle") + "\" name=\"calle\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Numero</label>\n" + "                            <input type=\"text\" value=" + resultados.getString("Num") + " name=\"num\" class=\"form-control\" required=\"required\" size=\"4\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Colonia</label>\n" + "                            <input type=\"text\" value=\"" + resultados.getString("Colonia") + "\" name=\"colonia\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Delegacion</label>\n" + "                            <input type=\"text\" value=\"" + resultados.getString("Delegacion") + "\" name=\"delegacion\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                        <label>Estado</label>\n" + "                            <select name=\"estado\">\n");
                        if (resultados.getString("Estado").equals("Ciudad de Mexico")) {
                            out.println("<option selected value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("Estado").equals("Estado de Mexico")) {
                            out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option selected value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("Estado").equals("Otro")) {
                            out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option selected value=\"Otro\">Otro</option>\n");
                        }
                        out.println("</select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Codigo Postal</label>\n                            <input type=\"text\" value=" + resultados.getString("cp") + " name=\"cp\" class=\"form-control\" required=\"required\" size=\"5\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Algun comentario sobre el lugar donde vives?</label>\n" + "                            <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados.getString("catDirecciones.Comentario") + "</textarea>\n" + "                        </div>\n" + "                        </fieldset><br><br>\n" + "                        \n" + "                        <fieldset>\n" + "                        <h2>Datos de Tutor</h2>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Parentesco con el alumno</label>\n" + "                            <select name=\"parentesco\">\n");
                        if (resultados.getString("DatosExtraAlumno.Parentesco").equals("Madre")) {
                            out.println("<option selected value=\"Madre\">Madre</option>\n                                <option value=\"Padre\">Padre</option>\n                                <option value=\"Tio o tia\">Tio o tia</option>\n                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("DatosExtraAlumno.Parentesco").equals("Padre")) {
                            out.println("<option value=\"Madre\">Madre</option>\n                                <option selected value=\"Padre\">Padre</option>\n                                <option value=\"Tio o tia\">Tio o tia</option>\n                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("DatosExtraAlumno.Parentesco").equals("Tio o tia")) {
                            out.println("<option value=\"Madre\">Madre</option>\n                                <option value=\"Padre\">Padre</option>\n                                <option selected value=\"Tio o tia\">Tio o tia</option>\n                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("DatosExtraAlumno.Parentesco").equals("Abuelo o abuela")) {
                            out.println("<option value=\"Madre\">Madre</option>\n                                <option value=\"Padre\">Padre</option>\n                                <option value=\"Tio o tia\">Tio o tia</option>\n                                <option selected value=\"Abuelo o abuela\">Abuelo o abuela</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados.getString("DatosExtraAlumno.Parentesco").equals("Otro")) {
                            out.println("<option value=\"Madre\">Madre</option>\n                                <option value=\"Padre\">Padre</option>\n                                <option value=\"Tio o tia\">Tio o tia</option>\n                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>\n                                <option selected value=\"Otro\">Otro</option>\n");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Nombre</label>\n                            <input type=\"text\" value=\"" + resultados.getString("d1.Nombre") + "\" name=\"nombreT\" class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Paterno</label>\n" + "                            <input type=\"text\" value=\"" + resultados.getString("d1.Apaterno") + "\" name=\"ApaternoT\" class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Materno</label>\n" + "                            <input type=\"text\" value=\"" + resultados.getString("d1.Amaterno") + "\" name=\"AmaternoT\" class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div> \n" + "                        <div class=\"form-group\">\n" + "                            <label>Sexo</label>\n" + "                            <select name=\"sexoT\">\n");
                        if (resultados.getString("d1.Sexo").equals("Masculino")) {
                            out.println("<option selected value=\"Masculino\">Masculino</option>\n                                <option value=\"Femenino\">Femenino</option>\n");
                        }
                        else if (resultados.getString("d1.Sexo").equals("Femenino")) {
                            out.println("<option value=\"Masculino\">Masculino</option>\n                                <option selected value=\"Femenino\">Femenino</option>\n");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Fecha de nacimiento</label>\n                            <input type=\"date\" value=" + resultados.getString("d1.Nacimiento") + " name=\"nacimientoT\" min=\"1900-01-01\" max=\"2010-01-01\" class=\"form-control\">\n" + "                        </div>        \n" + "                        <div class=\"form-group\">\n" + "                            <label>CURP</label>\n" + "                            <input type=\"text\" value=" + resultados.getString("d1.Curp") + " name=\"curpT\" class=\"form-control\" required=\"required\" size=\"18\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>E-Mail</label>\n" + "                            <input type=\"email\" value=" + resultados.getString("d1.Email") + " name=\"emailT\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Celular</label>\n" + "                            <input type=\"number\" value=" + resultados.getString("d1.Celular") + " name=\"celularT\" class=\"form-control\" size=\"12\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Telefono del trabajo</label>\n" + "                            <input type=\"number\" value=" + resultados.getString("d1.Telefono") + " name=\"telefonoT\" class=\"form-control\" size=\"10\">\n" + "                        </div>" + "<br><div class=\"form-group\">\n" + "                            <label>Con quien vive el alumno</label>\n" + "                            <select name=\"vive\">");
                        final String string = resultados.getString("Vive");
                        switch (string) {
                            case "Padre": {
                                out.println("<option selected value=\"Padre\">Padre</option>\n                                <option value=\"Madre\">Madre</option>\n                                <option value=\"Ambos\">Ambos</option>\n                                <option value=\"Otro\">Otro</option>");
                                break;
                            }
                            case "Madre": {
                                out.println("<option value=\"Padre\">Padre</option>\n                                <option selected value=\"Madre\">Madre</option>\n                                <option value=\"Ambos\">Ambos</option>\n                                <option value=\"Otro\">Otro</option>");
                                break;
                            }
                            case "Ambos": {
                                out.println("<option value=\"Padre\">Padre</option>\n                                <option value=\"Madre\">Madre</option>\n                                <option selected value=\"Ambos\">Ambos</option>\n                                <option value=\"Otro\">Otro</option>");
                                break;
                            }
                            case "Otro": {
                                out.println("<option value=\"Padre\">Padre</option>\n                                <option value=\"Madre\">Madre</option>\n                                <option value=\"Ambos\">Ambos</option>\n                                <option selected value=\"Otro\">Otro</option>");
                                break;
                            }
                        }
                        out.println("                     </select></div>   </fieldset><br><br><br>\n                        \n                        <div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Guardar cambios</button> \n                        </div>                    </div>\n                </form> \n            </div><!--/.row-->\n        </div><!--/.container-->\n    </section><!--/#contact-page-->");
                    }
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("2.4")) {
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                final String nombre2 = request.getParameter("nombre1");
                final String Apaterno = request.getParameter("Apaterno");
                final String Amaterno = request.getParameter("Amaterno");
                final String ano2 = request.getParameter("ano");
                final String grupo2 = request.getParameter("grupo");
                final String sexo2 = request.getParameter("sexo1");
                final String nacimiento = request.getParameter("nacimiento");
                final String curp = request.getParameter("curp");
                final String email = request.getParameter("email");
                final String celular = request.getParameter("celular");
                final String telefono = request.getParameter("telefono");
                final String calle = request.getParameter("calle");
                final String num = request.getParameter("num");
                final String colonia = request.getParameter("colonia");
                final String delegacion = request.getParameter("delegacion");
                final String estado = request.getParameter("estado");
                final String cp = request.getParameter("cp");
                final String comentarioDir = request.getParameter("comentarioDir");
                final String usuario = request.getParameter("usuario");
                final String pass = request.getParameter("pass");
                final String peso = request.getParameter("peso");
                final String estatura = request.getParameter("estatura");
                final String lentes = request.getParameter("lentes");
                final String zapatos = request.getParameter("zapatos");
                final String auditivo = request.getParameter("auditivo");
                final String comentarioAlu = request.getParameter("comentarioAlu");
                final String nombreT = request.getParameter("nombreT");
                final String ApaternoT = request.getParameter("ApaternoT");
                final String AmaternoT = request.getParameter("AmaternoT");
                final String sexoT = request.getParameter("sexoT");
                final String nacimientoT = request.getParameter("nacimientoT");
                final String curpT = request.getParameter("curpT");
                final String emailT = request.getParameter("emailT");
                final String celularT = request.getParameter("celularT");
                final String telefonoT = request.getParameter("telefonoT");
                final String parentesco = request.getParameter("parentesco");
                final String idAlumno2 = request.getParameter("idAlumno");
                final String afiliacion = request.getParameter("afiliacion");
                final String vive = request.getParameter("vive");
                final String folio2 = request.getParameter("folio");
                final Part foto = request.getPart("foto");
                final String tipo3 = foto.getContentType();
                final long tama\u00f1o = foto.getSize();
                final String nomFoto = foto.getSubmittedFileName();
                final InputStream f = foto.getInputStream();
                try {
                    p.ModificarAlumno(nombre2, Apaterno, Amaterno, ano2, grupo2, sexo2, nacimiento, curp, email, celular, telefono, calle, num, colonia, delegacion, estado, cp, comentarioDir, usuario, pass, peso, estatura, lentes, zapatos, auditivo, comentarioAlu, nombreT, ApaternoT, AmaternoT, sexoT, nacimientoT, curpT, emailT, celularT, telefonoT, parentesco, idAlumno2, afiliacion, vive, folio2);
                    out.println("<br><br><br><br><br><br>");
                    out.println("<h2>Exito: Se ha modificado correctamente al alumno :)</h2>");
                    if (tama\u00f1o < 1500000L) {
                        if (tipo3.equals("image/jpeg") || tipo3.equals("image/png") || tipo3.equals("image/jpg")) {
                            p.guardaImagen(usuario, nomFoto, f);
                            out.println("<br><br><br><br><br><br>");
                            out.println("<h2>Exito: Se ha modificado correctamente la fotograf\u00eda del alumno :)</h2>");
                        }
                        else {
                            out.println("El formato de la fotografia no coincide con el solicitado");
                        }
                    }
                    else {
                        out.println("La fotografia es demasiado grande");
                    }
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button>");
                    out.println("<br><br><br><br><br><br></div>");
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.5")) {
                final String idPersona = request.getParameter("idPersona");
                final String s3 = request.getParameter("s");
                final String query3 = "call VerDatos(" + idPersona + ")";
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia3 = con3.createStatement();
                    final ResultSet resultados2 = sentencia3.executeQuery(query3);
                    if (resultados2.next()) {
                        out.println("</div><section id=\"contact-page\">\n        <div class=\"container\">\n            <div class=\"center\"> \n                <br>\n                <h2>Modificar " + s3 + "</h2>\n" + "            </div> \n" + "            <div class=\"row contact-wrap\"> \n" + "                <div class=\"status alert alert-success\" style=\"display: none\"></div>\n" + "                \n" + "                <form id=\"main-contact-form\" class=\"contact-form\" name=\"contact-form\" method=\"post\" action=\"Administrativo\">\n" + "                    <div class=\"col-sm-5 col-sm-offset-1\">\n" + "                        \n" + "                        <fieldset>\n" + "                        <h2>Datos Personales</h2>\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.6\">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados2.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                        <div class=\"form-group\">\n" + "                            <label>Nombre</label>\n" + "                            <input type=\"text\" name=\"nombre1\" value=\"" + resultados2.getString("Nombre") + "\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Paterno</label>\n" + "                            <input type=\"text\" name=\"Apaterno\" value=\"" + resultados2.getString("Apaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Apellido Materno</label>\n" + "                            <input type=\"text\" name=\"Amaterno\" value=\"" + resultados2.getString("Amaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">\n" + "                        </div>\n");
                        out.println("                        <div class=\"form-group\">\n                            <label>Sexo</label>\n                            <select name=\"sexo1\" selected=" + resultados2.getString("Sexo") + ">\n");
                        if (resultados2.getString("Sexo").equals("Masculino")) {
                            out.println("<option selected value=\"Masculino\">Masculino</option>\n                                <option value=\"Femenino\">Femenino</option>\n");
                        }
                        else if (resultados2.getString("Sexo").equals("Femenino")) {
                            out.println("<option value=\"Masculino\">Masculino</option>\n                                <option selected value=\"Femenino\">Femenino</option>\n");
                        }
                        out.println("</select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Fecha de nacimiento</label>\n                            <input type=\"date\" value=" + resultados2.getString("Nacimiento") + " name=\"nacimiento\" min=\"2000-01-01\" max=\"2010-01-01\" class=\"form-control\">\n" + "                        </div>        \n" + "                        <div class=\"form-group\">\n" + "                            <label>CURP</label>\n" + "                            <input type=\"text\" value=" + resultados2.getString("Curp") + " name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>E-Mail</label>\n" + "                            <input type=\"email\" value=" + resultados2.getString("Email") + " name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Celular</label>\n" + "                            <input type=\"number\" value=" + resultados2.getString("Celular") + " name=\"celular\" class=\"form-control\" size=\"12\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Telefono de casa</label>\n" + "                            <input type=\"number\" value=" + resultados2.getString("Telefono") + " name=\"telefono\" class=\"form-control\" size=\"10\">\n" + "                        </div><br><br>\n" + "                        </fieldset>\n" + "                        \n" + "                        <fieldset>\n" + "                        <h2>Datos de acceso</h2>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Crea un usuario</label>\n" + "                            <input type=\"text\" value=\"" + resultados2.getString("Usuario") + "\" name=\"usuario\" class=\"form-control\" size=\"20\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Contrase\u00f1a</label>\n" + "                            <input type=\"password\" value=" + resultados2.getString("Pass") + " name=\"pass\" class=\"form-control\" size=\"20\">\n" + "                        </div>\n" + "                        </fieldset>\n" + "                    </div>\n" + "  \n" + "                    <div class=\"col-sm-5\">\n" + "                        <fieldset>\n" + "                        <h2>Direccion</h2>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Calle</label>\n" + "                            <input type=\"text\" value=\"" + resultados2.getString("Calle") + "\" name=\"calle\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Numero</label>\n" + "                            <input type=\"text\" value=" + resultados2.getString("Num") + " name=\"num\" class=\"form-control\" required=\"required\" size=\"4\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Colonia</label>\n" + "                            <input type=\"text\" value=\"" + resultados2.getString("Colonia") + "\" name=\"colonia\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Delegacion</label>\n" + "                            <input type=\"text\" value=\"" + resultados2.getString("Delegacion") + "\" name=\"delegacion\" class=\"form-control\" required=\"required\" size=\"40\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                        <label>Estado</label>\n" + "                            <select name=\"estado\">\n");
                        if (resultados2.getString("Estado").equals("Ciudad de Mexico")) {
                            out.println("<option selected value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados2.getString("Estado").equals("Estado de Mexico")) {
                            out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option selected value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n");
                        }
                        else if (resultados2.getString("Estado").equals("Otro")) {
                            out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option selected value=\"Otro\">Otro</option>\n");
                        }
                        out.println("</select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Codigo Postal</label>\n                            <input type=\"text\" value=" + resultados2.getString("cp") + " name=\"cp\" class=\"form-control\" required=\"required\" size=\"5\">\n" + "                        </div>\n" + "                        <div class=\"form-group\">\n" + "                            <label>Algun comentario sobre el lugar donde vives?</label>\n" + "                            <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados2.getString("catDirecciones.Comentario") + "</textarea>\n" + "                        </div>\n" + "                        </fieldset><br><br>\n" + "                        \n" + "                        <br><br><br><br>\n" + "                        \n" + "                        <div class=\"form-group center\">\n" + "                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Guardar cambios</button> \n" + "                        </div>\n" + "                    </div>\n" + "                </form> \n");
                        if (resultados2.getString("idTipo").equals("2")) {
                            out.println("<form action=\"Administrativo\" method=\"POST\">                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados2.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + "><div class=\"form-group center\">\n" + "<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.7\">\n" + "                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Modificar asignaturas impartidas</button> \n" + "                        </div>\n");
                        }
                        out.println("            </div><!--/.row-->\n        </div><!--/.container-->\n    </section><!--/#contact-page-->");
                    }
                    con3.close();
                }
                catch (SQLException ex4) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("2.6")) {
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                final String nombre2 = request.getParameter("nombre1");
                final String Apaterno = request.getParameter("Apaterno");
                final String Amaterno = request.getParameter("Amaterno");
                final String sexo3 = request.getParameter("sexo1");
                final String nacimiento2 = request.getParameter("nacimiento");
                final String curp2 = request.getParameter("curp");
                final String email2 = request.getParameter("email");
                final String celular2 = request.getParameter("celular");
                final String telefono2 = request.getParameter("telefono");
                final String calle2 = request.getParameter("calle");
                final String num2 = request.getParameter("num");
                final String colonia2 = request.getParameter("colonia");
                final String delegacion2 = request.getParameter("delegacion");
                final String estado2 = request.getParameter("estado");
                final String cp2 = request.getParameter("cp");
                final String comentarioDir2 = request.getParameter("comentarioDir");
                final String usuario2 = request.getParameter("usuario");
                final String pass2 = request.getParameter("pass");
                final String idPersona2 = request.getParameter("idPersona");
                try {
                    p.ModificarUsuario(nombre2, Apaterno, Amaterno, sexo3, nacimiento2, curp2, email2, celular2, telefono2, calle2, num2, colonia2, delegacion2, estado2, cp2, comentarioDir2, usuario2, pass2, idPersona2, idAdministrativo);
                    out.println("<br><br><br><br><br><br>");
                    out.println("<h2>Exito: Se ha modificado correctamente el usuario</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button>");
                    out.println("<br><br><br><br><br><br></div>");
                }
                catch (SQLException ex5) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("2.7")) {
                final String idDocente = request.getParameter("idPersona");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call VerTodasAsignaturasDadas(" + idDocente + ");";
                    final ResultSet resultados = sentencia2.executeQuery(query2);
                    out.println("<br><br><br><div class=\"col-sm-5 col-sm-offset-1\"><h2>Asignaturas impartidas por el docente</h2>");
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.8\">\n" + "                    <div class=\"form-group\">\n" + "                    <select name=\"asignatura\">\n");
                    while (resultados.next()) {
                        out.println("<option value=\"" + resultados.getString("idAsignatura") + " " + resultados.getString("Ano") + resultados.getString("Grupo") + "\">" + resultados.getString("Asignatura") + " en el grupo " + resultados.getString("Ano") + "º " + resultados.getString("Grupo") + "</option>\n");
                    }
                    out.println("</select></div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Dejar de impartir la asignatura</button></form><br>");
                    out.println("</div>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<div class=\"col-sm-5\"><form action=\"Administrativo\" method=\"POST\">\n                        <h2>Agregar una nueva asignatura</h2>\n                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.9\">\n" + "                            <select name=\"asignatura\">\n" + "                                <option value=\"1\">Espa\u00f1ol</option>\n" + "                                <option value=\"2\">Ingl\u00e9s</option>\n" + "                                <option value=\"3\">Matem\u00e1ticas</option>\n" + "                                <option value=\"4\">Biolog\u00eda</option>\n" + "                                <option value=\"5\">F\u00edsica</option>\n" + "                                <option value=\"6\">Qu\u00edmica</option>\n" + "                                <option value=\"7\">Geograf\u00eda</option>\n" + "                                <option value=\"8\">Historia</option>\n" + "                                <option value=\"9\">Asignatura Estatal</option>\n" + "                                <option value=\"10\">Formaci\u00f3n C\u00edvica y \u00c9tica</option>\n" + "                                <option value=\"11\">Tutor\u00eda</option>\n" + "                                <option value=\"12\">Educaci\u00f3n F\u00edsica</option>\n" + "                                <option value=\"13\">M\u00fasica</option>\n" + "                                <option value=\"14\">Artes Pl\u00e1sticas</option>\n" + "                                <option value=\"15\">Preparaci\u00f3n y Conservaci\u00f3n de Productos Alimenticios</option>\n" + "                                <option value=\"16\">Bordados y Tejidos</option>\n" + "                                <option value=\"17\">Dise\u00f1o Arquitect\u00f3nico</option>\n" + "                                <option value=\"18\">Electrotecnia</option>\n" + "                            </select><br><br>\n" + "                        </div>");
                out.println("</select></div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Continuar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div><br><br><br>");
            }
            else if (opc.equals("2.8")) {
                final String relacion = request.getParameter("asignatura");
                final String delimitadores = "[ .,;?!¡¿'\"\\[\\]]+";
                final String[] palabrasSeparadas = relacion.split(delimitadores);
                final String idAsignatura = palabrasSeparadas[0];
                final String anogrupo = palabrasSeparadas[1];
                final char ano3 = anogrupo.charAt(0);
                final char grupo3 = anogrupo.charAt(1);
                final String idDocente2 = request.getParameter("idDocente");
                final String query4 = "call EliminarAsignaturaGrupoDocente(" + idDocente2 + "," + idAsignatura + "," + ano3 + ",'" + grupo3 + "')";
                try (final Connection con4 = DB.getConnection()) {
                    final Statement sentencia4 = con4.createStatement();
                    final ResultSet resultados3 = sentencia4.executeQuery(query4);
                    con4.close();
                    out.println("<br><br><br><br><br><br>");
                    out.println("<h2>Exito: Se ha eliminado la asignatura correctamente :)</h2>");
                }
                catch (SQLException ex6) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button>");
                out.println("<br><br><br><br><br><br></div>");
            }
            else if (opc.equals("2.9")) {
                final int idAsignatura2 = Integer.parseInt(request.getParameter("asignatura"));
                final String idDocente3 = request.getParameter("idDocente");
                out.println("<div class=\"form-group center\"><h3>Por favor escoge el grupo en el que quieras impartir la asignatura seleccionada</h3>\n");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente3 + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura2 + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.10\">\n" + "                        <label>Grado</label><br>\n" + "                            <select name=\"ano\">\n");
                switch (idAsignatura2) {
                    case 1:
                    case 2:
                    case 3:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18: {
                        out.println("<option value=\"1\">1°</option>");
                        out.println("<option value=\"2\">2°</option>");
                        out.println("<option value=\"3\">3°</option>");
                        break;
                    }
                    case 8:
                    case 10: {
                        out.println("<option value=\"2\">2°</option>");
                        out.println("<option value=\"3\">3°</option>");
                        break;
                    }
                    case 4:
                    case 7:
                    case 9: {
                        out.println("<option value=\"1\">1°</option>");
                        break;
                    }
                    case 5: {
                        out.println("<option value=\"2\">2°</option>");
                        break;
                    }
                    case 6: {
                        out.println("<option value=\"3\">3°</option>");
                        break;
                    }
                }
                out.println("</select></div>");
                out.println("<div class=\"col-sm-5\">                        <label>Grupo</label><br>\n                            <select name=\"grupo\">\n                               <option value=\"A\">A</option>                               <option value=\"B\">B</option>                               <option value=\"C\">C</option>                               <option value=\"D\">D</option>                               <option value=\"E\">E</option>                            </select></div>");
                out.println("<br><br><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form>                            <br><br><br><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("2.10")) {
                final String idDocente = request.getParameter("idDocente");
                final String idAsignatura3 = request.getParameter("idAsignatura");
                final String ano4 = request.getParameter("ano");
                final String grupo4 = request.getParameter("grupo");
                final String query2 = "call AgregarAsignaturaGrupoDocente(" + idDocente + "," + idAsignatura3 + "," + ano4 + ",'" + grupo4 + "')";
                final String query5 = "call VerAsignaturaExiste(" + idDocente + "," + idAsignatura3 + "," + ano4 + ",'" + grupo4 + "')";
                try (final Connection con5 = DB.getConnection()) {
                    final Statement sentencia5 = con5.createStatement();
                    final Statement sentencia6 = con5.createStatement();
                    final ResultSet resultados4 = sentencia6.executeQuery(query5);
                    if (resultados4.next()) {
                        out.println("<br><br><br><br><br><br>");
                        out.println("<h2>Error: El docente ya esta impartiendo esa materia en ese grupo</h2>");
                    }
                    else {
                        final ResultSet resultados5 = sentencia5.executeQuery(query2);
                        out.println("<br><br><br><br><br><br>");
                        out.println("<h2>Exito: Se le ha asignado la asignatura correctamente al docente</h2>");
                    }
                    con5.close();
                }
                catch (SQLException ex7) {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button>");
                out.println("<br><br><br><br><br><br>");
            }
            else if (opc.equals("3")) {
                out.println("</div><section id=\"contact-page\">\n        <div class=\"container\"><div class=\"row contact-wrap\"><div class=\"form-group center\"><h3>¿Que tipo de usuario quieres registrar?</h3>");
                out.println("<form id=\"main-contact-form\" class=\"contact-form\" action=\"Administrativo\" method=\"POST\" name=\"formu\" id=\"formu\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">\n" + "                    <div class=\"form-group\">\n" + "                    <select name=\"tipo\">\n" + "<option selected value=\"2\">Docente</option>" + "<option value=\"3\">Apoyo</option>" + "<option value=\"4\">Doctor</option>" + "<option value=\"5\">Administrativo</option>" + "</select></div><br><hr>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><h3>Datos Personales</h3>\n                        <div class=\"form-group\">\n                            <label>Nombre <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp=\"copiar()\" onKeyUp=\"capitalize()\" type=\"text\" name=\"nombre1\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Apellido Paterno <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Apaterno\" class=\"form-control\" required=\"required\" size=\"30\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Apellido Materno <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Amaterno\" class=\"form-control\" required=\"required\" size=\"30\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Sexo</label>\n                            <select name=\"sexo1\">\n                                <option selected value=\"Masculino\">Masculino</option>\n                                <option value=\"Femenino\">Femenino</option>\n                            </select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Fecha de nacimiento</label>\n                            <input type=\"date\" name=\"nacimiento\" value=\"1965-01-01\" min=\"1900-01-01\" max=\"2005-01-01\" class=\"form-control\">\n                        </div>        \n                        <div class=\"form-group\">\n                            <label>CURP <a href=\"https://consultas.curp.gob.mx/CurpSP/\">¿No te lo sabes?</a></label>\n                            <input type=\"text\" style=\"text-transform:uppercase;\" onkeyup=\"javascript:this.value=this.value.toUpperCase();\" name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>E-Mail</label>\n                            <input type=\"email\" name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Celular</label>\n                            <input type=\"text\" name=\"celular\" class=\"form-control\" onkeyup=\"Numero(this.value);\" size=\"12\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Telefono de casa</label>\n                            <input type=\"text\" name=\"telefono\" class=\"form-control\" onkeyup=\"Numero(this.value);\" size=\"10\">\n                        </div></div>");
                out.println("<div class=\"col-sm-5\"><h3>Direccion</h3>\n                        <div class=\"form-group\">\n                            <label>Calle</label>\n                            <input type=\"text\" name=\"calle\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Numero</label>\n                            <input type=\"text\" name=\"num\" class=\"form-control\" required=\"required\" onkeyup=\"Numero2(this.value);\" size=\"4\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Colonia</label>\n                            <input type=\"text\" name=\"colonia\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Delegacion o Municipio</label>\n                            <input type=\"text\" name=\"delegacion\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                        <label>Estado</label>\n                            <select name=\"estado\">\n                                <option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n                            </select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Codigo Postal</label>\n                            <input type=\"text\" name=\"cp\" class=\"form-control\" required=\"required\" onkeyup=\"Numero(this.value);\" size=\"5\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>¿Algun comentario sobre el lugar donde vives?</label>\n                            <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>\n                        </div>\n                        </fieldset>");
                out.println("</div><br><br><br><br><br><div class=\"form-group center\"><br><br><h2>Datos de acceso</h2>\n                        <div class=\"form-group\">\n                            <label>Usuario</label>\n                            <input onclick = \"copiar()\" disabled type=\"text\" name=\"usuario\" class=\"form-control\" size=\"20\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Contrase\u00f1a <i class=\"fa fa-asterisk\"></i></label>\n                            <input type=\"password\" name=\"pass\" class=\"form-control\" size=\"20\">\n                        </div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"validacionRU()\">Registrar</button></form></div>");
                out.println("</div></div>               </section>");
                out.println("<hr><div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div>");
            }
            else if (opc.equals("3.1")) {
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                final String tipo4 = request.getParameter("tipo");
                final String nombre3 = request.getParameter("nombre1");
                final String Apaterno2 = request.getParameter("Apaterno");
                final String Amaterno2 = request.getParameter("Amaterno");
                final String sexo4 = request.getParameter("sexo1");
                final String nacimiento3 = request.getParameter("nacimiento");
                String curp3 = request.getParameter("curp");
                String email3 = request.getParameter("email");
                String celular3 = request.getParameter("celular");
                String telefono3 = request.getParameter("telefono");
                String calle3 = request.getParameter("calle");
                String num3 = request.getParameter("num");
                String colonia3 = request.getParameter("colonia");
                String delegacion3 = request.getParameter("delegacion");
                final String estado3 = request.getParameter("estado");
                String cp3 = request.getParameter("cp");
                String comentarioDir3 = request.getParameter("comentarioDir");
                final String pass2 = request.getParameter("pass");
                if (nombre3 == null || nombre3.length() == 0 || Amaterno2 == null || Amaterno2.length() == 0 || Apaterno2 == null || Apaterno2.length() == 0 || pass2 == null || pass2.length() == 0) {
                    response.sendRedirect("Error.jsp");
                }
                if (email3 == null || email3.length() == 0) {
                    email3 = "SinCorreo";
                }
                if (curp3 == null || curp3.length() == 0) {
                    curp3 = "SinCurp";
                }
                if (celular3 == null || celular3.length() == 0) {
                    celular3 = "0";
                }
                if (telefono3 == null || telefono3.length() == 0) {
                    telefono3 = "0";
                }
                if (calle3 == null || calle3.length() == 0) {
                    calle3 = "SinCalle";
                }
                if (num3 == null || num3.length() == 0) {
                    num3 = "0";
                }
                if (colonia3 == null || colonia3.length() == 0) {
                    colonia3 = "SinColonia";
                }
                if (delegacion3 == null || delegacion3.length() == 0) {
                    delegacion3 = "SinDelegacion";
                }
                if (cp3 == null || cp3.length() == 0) {
                    cp3 = "0";
                }
                if (comentarioDir3 == null || comentarioDir3.length() == 0) {
                    comentarioDir3 = "Sin Comentario de direccion";
                }
                String usuario = "";
                if (nombre3.length() >= 3 || Apaterno2.length() >= 3 || Amaterno2.length() >= 3) {
                    usuario = nombre3.substring(0, 3) + Apaterno2.substring(0, 3) + Amaterno2.substring(0, 3);
                    usuario = usuario.toLowerCase();
                    usuario = usuario.replace('\u00e1', 'a');
                    usuario = usuario.replace('\u00e9', 'e');
                    usuario = usuario.replace('\u00ed', 'i');
                    usuario = usuario.replace('\u00f3', 'o');
                    usuario = usuario.replace('\u00fa', 'u');
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                boolean registrar = true;
                try (final Connection con6 = DB.getConnection()) {
                    final Statement sentencia7 = con6.createStatement();
                    final String query6 = "select * from Acceso where Usuario='" + usuario + "';";
                    final ResultSet resultados6 = sentencia7.executeQuery(query6);
                    if (resultados6.next()) {
                        registrar = false;
                    }
                    con6.close();
                }
                catch (SQLException ex8) {
                    response.sendRedirect("Error.jsp");
                }
                if (registrar) {
                    try (final Connection con6 = DB.getConnection()) {
                        final Statement sentencia7 = con6.createStatement();
                        final int l = 0;
                        final String query7 = "call RegistrarUsuario(" + tipo4 + ",'" + nombre3 + "','" + Apaterno2 + "','" + Amaterno2 + "','" + sexo4 + "','" + nacimiento3 + "','" + curp3 + "','" + email3 + "'," + celular3 + "," + telefono3 + ",'" + calle3 + "'," + num3 + " ,'" + colonia3 + "','" + delegacion3 + "' ,'" + estado3 + "'," + cp3 + ",'" + comentarioDir3 + "','" + usuario + "','" + pass2 + "');";
                        final ResultSet resultados7 = sentencia7.executeQuery(query7);
                        out.println("<br><br><br><br><br><br><br><br><h2>Usuario registrado con exito</h2><br>");
                        out.println("<br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Registro.jsp'\">Volver</button> \n                        </div><br><br><br><br><br><br><br><br>");
                        con6.close();
                    }
                    catch (SQLException ex8) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else {
                    out.println("<section id=\"error\" class=\"container text-center\">\n        <h1>¿Ya te has registrado antes?</h1>\n        <p>El usuario que se te ha asignado ya existe, probablemente ya estes registrado en la p\u00e1gina, intenta iniciar sesi\u00f3n, si este no es tu caso por favor ve a control escolar a que solucionen esto o envia un correo a: contacto@secundaria120.com<br><br>\n        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n    </section><!--/#error-->\n<br><br><br>");
                }
            }
            else if (opc.equals("4")) {
                final String buscado = request.getParameter("buscado");
                out.println("<br><label>Buscar por nombre</label><br>");
                if (buscado == null) {
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4\"><br><br>");
                    out.println("</form><br>");
                }
                else {
                    out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4\"><br><br>");
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
                                out.println("<form action=\"Administrativo\" method=\"POST\" name=" + formu + " id=" + formu + ">\n" + "                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + " onclick=\"submit();\">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados.getString("Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados.getString("Apaterno") + ">\n" + "<br>");
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
                idAdministrativo = request.getParameter("idAdministrativo");
                sexo = request.getParameter("sexo");
                out.println("<br><br><br><h2>¿De que grupo es el alumno a eliminar?</h2>");
                out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button></div><br><br><br><br>");
            }
            else if (opc.equals("4.1")) {
                idAdministrativo = request.getParameter("idAdministrativo");
                sexo = request.getParameter("sexo");
                final String ano = request.getParameter("ano");
                final String grupo = request.getParameter("grupo");
                int k = 1;
                final ArrayList<String> Alumnos = (ArrayList<String>)Funcion.VerGrupo(ano, grupo);
                out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Eliminar</th>\n</tr>\n");
                for (int x2 = 0; Alumnos.size() > x2; x2 += 4) {
                    out.println("<tr><td>" + k + "</td><td>" + Alumnos.get(x2 + 1) + " " + Alumnos.get(x2 + 2) + " " + Alumnos.get(x2) + "</td>");
                    out.println("<th><form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.2\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Eliminar</button></form></th> \n");
                    out.println("</tr>");
                    ++k;
                }
                out.println("</table>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button>");
                out.println("<br><br><br><br></div>");
            }
            else if (opc.equals("4.2")) {
                final String idPersona = request.getParameter("idPersona");
                out.println("<br><br><br><h2>¿Estas segurisisimo de querer borrar a " + request.getParameter("nombreA") + " " + request.getParameter("apellidoP") + "?</h2>" + "<br><h3>OJO: Esta operaci\u00f3n no tiene vuelta atr\u00e1s...</h3>");
                out.println("<form action=\"Administrativo\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idAdministrativo\" value=" + idAdministrativo + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Dar de baja</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        </div><br><br><br><br>");
            }
            else if (opc.equals("4.3")) {
                final String idPersona = request.getParameter("idPersona");
                idAdministrativo = request.getParameter("idAdministrativo");
                try (final Connection con2 = DB.getConnection()) {
                    final Statement sentencia2 = con2.createStatement();
                    final String query2 = "call BorrarUsuario(" + idPersona + "," + idAdministrativo + ");";
                    final ResultSet resultados = sentencia2.executeQuery(query2);
                    out.println("<br><br><br><br><br><br><br><br><br><h2>Has eliminado correctamente al alumno</h2><br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Administrativo.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
                    con2.close();
                }
                catch (SQLException ex2) {
                    response.sendRedirect("Error.jsp");
                }
            }
            out.println("<footer id=\"footer\" class=\"midnight-blue\">\n        <div class=\"container\">\n            <div class=\"row\">\n                <div class=\"col-sm-6\">\n                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>\n                </div>\n                <div class=\"col-sm-6\">\n                    <ul class=\"pull-right\">\n                        <li>Se feliz</li>\n                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </footer><!--/#footer-->\n\n        \n    <script src=\"js/jquery.js\"></script>\n    <script src=\"js/bootstrap.min.js\"></script>\n    <script src=\"js/jquery.prettyPhoto.js\"></script>\n    <script src=\"js/jquery.isotope.min.js\"></script>\n    <script src=\"js/main.js\"></script>\n    <script src=\"js/wow.min.js\"></script>\n    </body>\n</html>\n");
        }
        catch (IOException | NumberFormatException | ServletException ex10) {
            final Exception ex9;
            response.sendRedirect("Error.jsp");
        }
    }
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

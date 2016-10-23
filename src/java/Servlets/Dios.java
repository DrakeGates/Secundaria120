package Servlets;

import javax.servlet.ServletException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.SQLException;
import Clases.DB;
import Clases.Funciones;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Dios extends HttpServlet
{
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Funciones Funcion = new Funciones();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            String idDios = request.getParameter("idDios");
            final String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            out.println("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"\">\n        <title>Dios</title>\n\n        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n    </head><!--/head-->\n\n    <body class=\"homepage\">\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Dios.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola " + nombre + "<i class=\"fa fa-angle-down\"></i></a>\n" + "                                <ul class=\"dropdown-menu\">\n" + "<form method=\"post\" action=\"Dios\" name=\"verdatos\">\n" + "                                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>\n" + "                               <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>\n" + "                            </li>   \n" + "                        </ul>\n" + "                    </div>\n" + "                </div><!--/.container-->\n" + "            </nav><!--/nav-->\n" + "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Se inmensamente feliz dios " + nombre + "</p>");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idDios);
                out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                if (Datos.size() >= 8) {
                    out.println("<h3>Nombre: " + Datos.get(0) + "<br>Apellido Paterno: " + Datos.get(1) + "<br>Apellido Materno: " + Datos.get(2) + "<br>Nacimiento: " + Datos.get(3) + "<br>Curp: " + Datos.get(4) + "<br>Email: " + Datos.get(5) + "<br>Celular: " + Datos.get(6) + "<br>Telefono: " + Datos.get(7));
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
                out.println("<br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        </div><br><br>");
            }
            else if (opc.equals("2")) {
                out.println("<br><br><br><br><br><br><h2>¿Estas segurisisimo de querer borrar a todos los alumnos de 3° grado?</h2><br><h3>OJO: Esta operaci\u00f3n no tiene vuelta atr\u00e1s...</h3>");
                out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.1\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Seguro</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        </div><br><br><br><br><br><br><br>");
            }
            else if (opc.equals("2.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call BorrarAlumnos3();";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><br><br><br><h2>Has eliminado a todos los alumnos de 3° grado</h2><br><br><br><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3")) {
                out.println("<br><br><br><h2>¿Que tipo de usuario quieres eliminar?</h2>");
                out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">\n" + "                    <select name=\"tipo\">\n" + "<option value=\"1\">Alumno</option>" + "<option value=\"2\">Docente</option>" + "<option value=\"3\">Apoyo</option>" + "<option value=\"4\">Doctor</option>" + "<option value=\"5\">Administrativo</option>" + "<option value=\"6\">Director</option>" + "</select><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br></div>");
            }
            else if (opc.equals("3.1")) {
                idDios = request.getParameter("idDios");
                sexo = request.getParameter("sexo");
                final int tipo = Integer.parseInt(request.getParameter("tipo"));
                String u = "";
                String s = "";
                int i = 1;
                if (tipo >= 2) {
                    switch (tipo) {
                        case 2: {
                            u = "Docentes";
                            s = "Docente";
                            break;
                        }
                        case 3: {
                            u = "Apoyos";
                            s = "Apoyo";
                            break;
                        }
                        case 4: {
                            u = "Doctores";
                            s = "Doctor";
                            break;
                        }
                        case 5: {
                            u = "Administrativos";
                            s = "Administrativo";
                            break;
                        }
                        case 6: {
                            u = "Directores";
                            s = "Director";
                            break;
                        }
                        default: {
                            response.sendRedirect("Error.jsp");
                            break;
                        }
                    }
                    try (final Connection con2 = DB.getConnection()) {
                        final Statement sentencia2 = con2.createStatement();
                        final String query2 = "call VerTodos" + u + "();";
                        final ResultSet resultados2 = sentencia2.executeQuery(query2);
                        out.println("<h2>" + u + " registrados en el sistema</h2><br>");
                        out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>" + s + "</td>\n" + "<th>Eliminar</th>\n" + "</tr>\n");
                        while (resultados2.next()) {
                            out.println("<tr><td>" + i + "</td><td>" + resultados2.getString("Apaterno") + " " + resultados2.getString("Amaterno") + " " + resultados2.getString("Nombre") + "</td>");
                            out.println("<th><form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"u\" value=" + u + ">\n" + "                    <input type=\"hidden\" name=\"s\" value=" + s + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"tipo\" value=" + tipo + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados2.getString("idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados2.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados2.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados2.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Eliminar</button></form></th> \n");
                            out.println("</tr>");
                            ++i;
                        }
                        out.println("</table>");
                        out.println("<br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br></div>");
                        con2.close();
                    }
                    catch (SQLException ex2) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else if (tipo == 1) {
                    idDios = request.getParameter("idDios");
                    sexo = request.getParameter("sexo");
                    out.println("<br><br><br><h2>¿De que grupo es el alumno?</h2>");
                    out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.2\">\n" + "                    <div class=\"form-group\">\n" + "<label>Grado</label>\n" + "                    <select name=\"ano\">\n" + "<option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                    out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>\n                    <select name=\"grupo\">\n<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"C\">D</option><option value=\"C\">E</option></select>");
                    out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br></div>");
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.2")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    idDios = request.getParameter("idDios");
                    sexo = request.getParameter("sexo");
                    final String ano = request.getParameter("ano");
                    final String grupo = request.getParameter("grupo");
                    int j = 1;
                    final String query3 = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
                    final ResultSet resultados3 = sentencia.executeQuery(query3);
                    out.println("<h2>Alumnos del grupo " + ano + "º " + grupo + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>\n<th>#</th>\n<th>Alumno</td>\n<th>Eliminar</th>\n</tr>\n");
                    while (resultados3.next()) {
                        out.println("<tr><td>" + j + "</td><td>" + resultados3.getString("Apaterno") + " " + resultados3.getString("Amaterno") + " " + resultados3.getString("Nombre") + "</td>");
                        out.println("<th><form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados3.getString("Datos.idPersona") + ">\n" + "                    <input type=\"hidden\" name=\"nombreA\" value=" + resultados3.getString("Datos.Nombre") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoP\" value=" + resultados3.getString("Datos.Apaterno") + ">\n" + "                    <input type=\"hidden\" name=\"apellidoM\" value=" + resultados3.getString("Datos.Amaterno") + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.3\">\n" + "                    <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Eliminar</button></form></th> \n");
                        out.println("</tr>");
                        ++j;
                    }
                    out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("3.3")) {
                final String idPersona = request.getParameter("idPersona");
                out.println("<br><br><br><h2>¿Estas segurisisimo de querer borrar a " + request.getParameter("nombreA") + " " + request.getParameter("apellidoP") + "?</h2>" + "<br><h3>OJO: Esta operaci\u00f3n no tiene vuelta atr\u00e1s...</h3>");
                out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.4\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Eliminar para siempre</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br></div>");
            }
            else if (opc.equals("3.4")) {
                final String idPersona = request.getParameter("idPersona");
                idDios = request.getParameter("idDios");
                try (final Connection con3 = DB.getConnection()) {
                    final Statement sentencia3 = con3.createStatement();
                    final String query4 = "call BorrarUsuario(" + idPersona + "," + idDios + ");";
                    final ResultSet resultados4 = sentencia3.executeQuery(query4);
                    out.println("<br><br><br><br><br><br><h2>Has eliminado correctamente al usuario</h2><br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
                    con3.close();
                }
                catch (SQLException ex3) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("4")) {
                out.println("<br><br><br><h2>¿Estas segurisisimo de querer borrar todas las incidencias?</h2><br><h3>OJO: Esta operaci\u00f3n no tiene vuelta atr\u00e1s...</h3>");
                out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.1\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Seguro</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br><br></div>");
            }
            else if (opc.equals("4.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call BorrarIncidencias();";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><br><br><br><h2>Has eliminado todas las incidencias de la base de datos</h2><br><br><br><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("5")) {
                out.println("<br><br><br><h2>¿Estas segurisisimo de querer borrar todas las calificaciones?</h2><br><h3>OJO: Esta operaci\u00f3n no tiene vuelta atr\u00e1s...</h3>");
                out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n" + "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.1\">\n");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Seguro</button></form><br>");
                out.println("<br><br><br><br>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br></div>");
            }
            else if (opc.equals("5.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call BorrarCalificaciones();";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<h2>Has eliminado todas las calificaciones de la base de datos</h2><br><br><br><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("6")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call VerPermiso(1);";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<form action=\"Dios\" method=\"POST\">\n                    <input type=\"hidden\" name=\"idDios\" value=" + idDios + ">\n" + "                    <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">\n" + "                    <input type=\"hidden\" name=\"sexo\" value=" + sexo + ">\n");
                    int Estado = 12;
                    if (resultados.next()) {
                        Estado = resultados.getInt("Estado");
                    }
                    if (Estado == 0) {
                        out.println("<br><br><br><br><br><br><h2>En este momento las inscripciones estan cerradas</h2><br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Abrir las inscripciones</button></form><br>");
                    }
                    else if (Estado == 1) {
                        out.println("<br><br><br><br><br><br><h2>En este momento las inscripciones estan abiertas</h2><br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Cerrar las inscripciones</button></form><br>");
                    }
                    out.println("<input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.1\"></form>\n");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (opc.equals("6.1")) {
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "call AbrirCerrarInscripciones();";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    out.println("<br><br><br><br><br><br><h2>Has cambiado el destino de la humanidad, bien hecho campe\u00f3n ;)</h2><br><br><br><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Dios.jsp'\">Volver</button> \n                        <br><br><br><br><br><br></div>");
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
            }
            out.println("<footer id=\"footer\" class=\"midnight-blue\">\n        <div class=\"container\">\n            <div class=\"row\">\n                <div class=\"col-sm-6\">\n                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>\n                </div>\n                <div class=\"col-sm-6\">\n                    <ul class=\"pull-right\">\n                        <li>Se feliz</li>\n                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </footer><!--/#footer-->\n\n        \n    <script src=\"js/jquery.js\"></script>\n    <script src=\"js/bootstrap.min.js\"></script>\n    <script src=\"js/jquery.prettyPhoto.js\"></script>\n    <script src=\"js/jquery.isotope.min.js\"></script>\n    <script src=\"js/main.js\"></script>\n    <script src=\"js/wow.min.js\"></script>\n    </body>\n</html>\n");
        }
        catch (IOException | NumberFormatException ex5) {
            final Exception ex4;
            response.sendRedirect("Error.jsp");
        }
    }
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

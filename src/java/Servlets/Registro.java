package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.SQLException;
import Clases.DB;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Registro extends HttpServlet
{
    public String capitalizar(final String palabra) {
        if (palabra.length() == 0) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
    
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            out.println("<!DOCTYPE html>" + 
 "<html lang=\"en\">" + 
 "    <head>" + 
 "        <meta charset=\"utf-8\">" + 
 "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + 
 "        <meta name=\"description\" content=\"\">" + 
 "        <meta name=\"author\" content=\"\">" + 
 "        <title>Registro</title>" + 
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
 "                            <li><a href=\"Registro.jsp\">Menu</a></li>" + 
 "                                <li class=\"dropdown active\">" + 
 "                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola<i class=\"fa fa-angle-down\"></i></a>" + 
 "                                <ul class=\"dropdown-menu\">" + 
 "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>                                </ul>" + 
 "                            </li>   " + 
 "                        </ul>" + 
 "                    </div>" + 
 "                </div><!--/.container-->" + 
 "            </nav><!--/nav-->" + 
 "        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>Bienvenid@");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                response.sendRedirect("Registro.jsp");
            }
            else if (opc.equals("3")) {
                out.println("</div><section id=\"contact-page\">" + 
 "        <div class=\"container\"><div class=\"row contact-wrap\"><div class=\"form-group center\"><h3>¿Que tipo de usuario eres?</h3>");
                out.println("<form id=\"main-contact-form\" class=\"contact-form\" action=\"Registro\" method=\"POST\" name=\"formu\" id=\"formu\">" + 
 "                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">" + 
 "                    <div class=\"form-group\">" + 
 "                    <select name=\"tipo\">" + 
 "<option selected value=\"2\">Docente</option><option value=\"3\">Apoyo</option><option value=\"4\">M\u00e9dico</option><option value=\"5\">Administrativo</option></select></div><br><hr>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><h3>Datos Personales</h3>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Nombre <i class=\"fa fa-asterisk\"></i></label>" + 
 "                            <input style=\"text-transform:capitalize\" onKeyUp=\"copiar()\" onKeyUp=\"capitalize()\" type=\"text\" name=\"nombre1\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Apellido Paterno <i class=\"fa fa-asterisk\"></i></label>" + 
 "                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Apaterno\" class=\"form-control\" required=\"required\" size=\"30\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Apellido Materno <i class=\"fa fa-asterisk\"></i></label>" + 
 "                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Amaterno\" class=\"form-control\" required=\"required\" size=\"30\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Sexo</label>" + 
 "                            <select name=\"sexo1\">" + 
 "                                <option selected value=\"Masculino\">Masculino</option>" + 
 "                                <option value=\"Femenino\">Femenino</option>" + 
 "                            </select>" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Fecha de nacimiento</label>" + 
 "                            <input type=\"date\" name=\"nacimiento\" value=\"1965-01-01\" min=\"1900-01-01\" max=\"2005-01-01\" class=\"form-control\">" + 
 "                        </div>        " + 
 "                        <div class=\"form-group\">" + 
 "                            <label>CURP <a href=\"https://consultas.curp.gob.mx/CurpSP/\">¿No te lo sabes?</a></label>" + 
 "                            <input type=\"text\" style=\"text-transform:uppercase;\" this.value=this.value.toUpperCase();\" name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>E-Mail</label>" + 
 "                            <input type=\"email\" name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Celular</label>" + 
 "                            <input type=\"text\" name=\"celular\" onkeyup=\"Numero(this.value);\" class=\"form-control\" size=\"12\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Telefono de casa</label>" + 
 "                            <input type=\"text\" name=\"telefono\" class=\"form-control\" onkeyup=\"Numero(this.value);\" size=\"10\">" + 
 "                        </div></div>");
                out.println("<div class=\"col-sm-5\"><h3>Direccion</h3>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Calle</label>" + 
 "                            <input type=\"text\" name=\"calle\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Numero</label>" + 
 "                            <input type=\"text\" name=\"num\" class=\"form-control\" onkeyup=\"Numero(this.value);\" required=\"required\" size=\"4\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Colonia</label>" + 
 "                            <input type=\"text\" name=\"colonia\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Delegacion o Municipio</label>" + 
 "                            <input type=\"text\" name=\"delegacion\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                        <label>Estado</label>" + 
 "                            <select name=\"estado\">" + 
 "                                <option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
 "                                <option value=\"Estado de Mexico\">Estado de Mexico</option>" + 
 "                                <option value=\"Otro\">Otro</option>" + 
 "                            </select><br><br>" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Codigo Postal</label>" + 
 "                            <input type=\"text\" name=\"cp\" class=\"form-control\" onkeyup=\"Numero(this.value);\" required=\"required\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Informaci\u00f3n extra sobre tu direcci\u00f3n</label>" + 
 "                            <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>" + 
 "                        </div>" + 
 "                        </fieldset>");
                out.println("</div><br><br><br><br><br><div class=\"form-group center\"><br><br><h2>Datos de acceso</h2>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Usuario</label>" + 
 "                            <input onclick = \"copiar()\" disabled type=\"text\" name=\"usuario\" class=\"form-control\" size=\"20\">" + 
 "                        </div>" + 
 "                        <div class=\"form-group\">" + 
 "                            <label>Contrase\u00f1a <i class=\"fa fa-asterisk\"></i></label>" + 
 "                            <input type=\"password\" name=\"pass\" class=\"form-control\" size=\"20\">" + 
 "                        </div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"validacionRU()\">Registrar</button></form></div>");
                out.println("</div></div>               </section>");
                out.println("<hr><div class=\"form-group center\">" + 
 "                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Registro.jsp'\">Volver</button> " + 
 "                        </div>");
            }
            else if (opc.equals("3.1")) {
                final String tipo = request.getParameter("tipo");
                String nombre1 = request.getParameter("nombre1");
                String Apaterno = request.getParameter("Apaterno");
                String Amaterno = request.getParameter("Amaterno");
                final String sexo1 = request.getParameter("sexo1");
                final String nacimiento = request.getParameter("nacimiento");
                String curp = request.getParameter("curp");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                String telefono = request.getParameter("telefono");
                String calle = request.getParameter("calle");
                String num = request.getParameter("num");
                String colonia = request.getParameter("colonia");
                String delegacion = request.getParameter("delegacion");
                final String estado = request.getParameter("estado");
                String cp = request.getParameter("cp");
                String comentarioDir = request.getParameter("comentarioDir");
                final String pass = request.getParameter("pass");
                nombre1 = this.capitalizar(nombre1);
                Apaterno = this.capitalizar(Apaterno);
                Amaterno = this.capitalizar(Amaterno);
                if (nombre1 == null || nombre1.length() == 0 || Amaterno == null || Amaterno.length() == 0 || Apaterno == null || Apaterno.length() == 0 || pass == null || pass.length() == 0) {
                    response.sendRedirect("Error.jsp");
                }
                if (email == null || email.length() == 0) {
                    email = "SinCorreo";
                }
                if (curp == null || curp.length() == 0) {
                    curp = "SinCurp";
                }
                if (celular == null || celular.length() == 0) {
                    celular = "0";
                }
                if (telefono == null || telefono.length() == 0) {
                    telefono = "0";
                }
                if (calle == null || calle.length() == 0) {
                    calle = "SinCalle";
                }
                if (num == null || num.length() == 0) {
                    num = "0";
                }
                if (colonia == null || colonia.length() == 0) {
                    colonia = "SinColonia";
                }
                if (delegacion == null || delegacion.length() == 0) {
                    delegacion = "SinDelegacion";
                }
                if (cp == null || cp.length() == 0) {
                    cp = "0";
                }
                if (comentarioDir == null || comentarioDir.length() == 0) {
                    comentarioDir = "Sin Comentario de direccion";
                }
                String usuario = "";
                if (nombre1.length() >= 3 || Apaterno.length() >= 3 || Amaterno.length() >= 3) {
                    usuario = nombre1.substring(0, 3) + Apaterno.substring(0, 3) + Amaterno.substring(0, 3);
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
                try (final Connection con = DB.getConnection()) {
                    final Statement sentencia = con.createStatement();
                    final String query = "select * from Acceso where Usuario='" + usuario + "';";
                    final ResultSet resultados = sentencia.executeQuery(query);
                    if (resultados.next()) {
                        registrar = false;
                    }
                    con.close();
                }
                catch (SQLException ex) {
                    response.sendRedirect("Error.jsp");
                }
                if (registrar) {
                    try (final Connection con = DB.getConnection()) {
                        final Statement sentencia = con.createStatement();
                        final int i = 0;
                        final String query2 = "call RegistrarUsuario(" + tipo + ",'" + nombre1 + "','" + Apaterno + "','" + Amaterno + "','" + sexo1 + "','" + nacimiento + "','" + curp + "','" + email + "'," + celular + "," + telefono + ",'" + calle + "'," + num + " ,'" + colonia + "','" + delegacion + "' ,'" + estado + "'," + cp + ",'" + comentarioDir + "','" + usuario + "','" + pass + "');";
                        final ResultSet resultados2 = sentencia.executeQuery(query2);
                        out.println("<br><br><br><br><br><br><br><br><h2>Usuario registrado con exito</h2><br>");
                        out.println("<br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Registro.jsp'\">Volver</button> " + 
 "                        </div><br><br><br><br><br><br><br><br>");
                        con.close();
                    }
                    catch (SQLException ex) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else {
                    out.println("<section id=\"error\" class=\"container text-center\">" + 
 "        <h1>¿Ya te has registrado antes?</h1>" + 
 "        <p>El usuario que se te ha asignado ya existe, probablemente ya estes registrado en la p\u00e1gina, intenta iniciar sesi\u00f3n, si este no es tu caso por favor ve a control escolar a que solucionen esto o envia un correo a: contacto@secundaria120.com<br><br>" + 
 "        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>" + 
 "    </section><!--/#error-->" + 
 "<br><br><br>");
                }
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

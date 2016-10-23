// 
// Decompiled by Procyon v0.5.30
// 

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
            out.println("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n        <meta name=\"description\" content=\"\">\n        <meta name=\"author\" content=\"\">\n        <title>Registro</title>\n\n        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n        <link href=\"css/main.css\" rel=\"stylesheet\">\n        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n       <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n    </head><!--/head-->\n\n    <body class=\"homepage\">\n        <header>\n            <nav class=\"navbar navbar-inverse\" role=\"banner\">\n                <div class=\"container\">\n                    <div class=\"navbar-header\">\n                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                            <span class=\"sr-only\">Navegacion</span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                            <span class=\"icon-bar\"></span>\n                        </button>\n                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                    </div>\n\n                    <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                            <li><a href=\"Registro.jsp\">Menu</a></li>\n                                <li class=\"dropdown active\">\n                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola<i class=\"fa fa-angle-down\"></i></a>\n                                <ul class=\"dropdown-menu\">\n                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>                                </ul>\n                            </li>   \n                        </ul>\n                    </div>\n                </div><!--/.container-->\n            </nav><!--/nav-->\n        </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>Bienvenid@");
            out.println("</h2><hr>");
            if (opc.equals("1")) {
                response.sendRedirect("Registro.jsp");
            }
            else if (opc.equals("3")) {
                out.println("</div><section id=\"contact-page\">\n        <div class=\"container\"><div class=\"row contact-wrap\"><div class=\"form-group center\"><h3>¿Que tipo de usuario eres?</h3>");
                out.println("<form id=\"main-contact-form\" class=\"contact-form\" action=\"Registro\" method=\"POST\" name=\"formu\" id=\"formu\">\n                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">\n                    <div class=\"form-group\">\n                    <select name=\"tipo\">\n<option selected value=\"2\">Docente</option><option value=\"3\">Apoyo</option><option value=\"4\">M\u00e9dico</option><option value=\"5\">Administrativo</option></select></div><br><hr>");
                out.println("<div class=\"col-sm-5 col-sm-offset-1\"><h3>Datos Personales</h3>\n                        <div class=\"form-group\">\n                            <label>Nombre <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp=\"copiar()\" onKeyUp=\"capitalize()\" type=\"text\" name=\"nombre1\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Apellido Paterno <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Apaterno\" class=\"form-control\" required=\"required\" size=\"30\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Apellido Materno <i class=\"fa fa-asterisk\"></i></label>\n                            <input style=\"text-transform:capitalize\" onKeyUp = \"copiar()\" type=\"text\" name=\"Amaterno\" class=\"form-control\" required=\"required\" size=\"30\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Sexo</label>\n                            <select name=\"sexo1\">\n                                <option selected value=\"Masculino\">Masculino</option>\n                                <option value=\"Femenino\">Femenino</option>\n                            </select>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Fecha de nacimiento</label>\n                            <input type=\"date\" name=\"nacimiento\" value=\"1965-01-01\" min=\"1900-01-01\" max=\"2005-01-01\" class=\"form-control\">\n                        </div>        \n                        <div class=\"form-group\">\n                            <label>CURP <a href=\"https://consultas.curp.gob.mx/CurpSP/\">¿No te lo sabes?</a></label>\n                            <input type=\"text\" style=\"text-transform:uppercase;\" this.value=this.value.toUpperCase();\" name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>E-Mail</label>\n                            <input type=\"email\" name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Celular</label>\n                            <input type=\"text\" name=\"celular\" onkeyup=\"Numero(this.value);\" class=\"form-control\" size=\"12\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Telefono de casa</label>\n                            <input type=\"text\" name=\"telefono\" class=\"form-control\" onkeyup=\"Numero(this.value);\" size=\"10\">\n                        </div></div>");
                out.println("<div class=\"col-sm-5\"><h3>Direccion</h3>\n                        <div class=\"form-group\">\n                            <label>Calle</label>\n                            <input type=\"text\" name=\"calle\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Numero</label>\n                            <input type=\"text\" name=\"num\" class=\"form-control\" onkeyup=\"Numero(this.value);\" required=\"required\" size=\"4\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Colonia</label>\n                            <input type=\"text\" name=\"colonia\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Delegacion o Municipio</label>\n                            <input type=\"text\" name=\"delegacion\" class=\"form-control\" onkeyup=\"javascript:this.value=this.value.toLowerCase();\" style=\"text-transform:capitalize;\" required=\"required\" size=\"40\">\n                        </div>\n                        <div class=\"form-group\">\n                        <label>Estado</label>\n                            <select name=\"estado\">\n                                <option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>\n                                <option value=\"Estado de Mexico\">Estado de Mexico</option>\n                                <option value=\"Otro\">Otro</option>\n                            </select><br><br>\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Codigo Postal</label>\n                            <input type=\"text\" name=\"cp\" class=\"form-control\" onkeyup=\"Numero(this.value);\" required=\"required\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Informaci\u00f3n extra sobre tu direcci\u00f3n</label>\n                            <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>\n                        </div>\n                        </fieldset>");
                out.println("</div><br><br><br><br><br><div class=\"form-group center\"><br><br><h2>Datos de acceso</h2>\n                        <div class=\"form-group\">\n                            <label>Usuario</label>\n                            <input onclick = \"copiar()\" disabled type=\"text\" name=\"usuario\" class=\"form-control\" size=\"20\">\n                        </div>\n                        <div class=\"form-group\">\n                            <label>Contrase\u00f1a <i class=\"fa fa-asterisk\"></i></label>\n                            <input type=\"password\" name=\"pass\" class=\"form-control\" size=\"20\">\n                        </div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"validacionRU()\">Registrar</button></form></div>");
                out.println("</div></div>               </section>");
                out.println("<hr><div class=\"form-group center\">\n                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Registro.jsp'\">Volver</button> \n                        </div>");
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
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Registro.jsp'\">Volver</button> \n                        </div><br><br><br><br><br><br><br><br>");
                        con.close();
                    }
                    catch (SQLException ex) {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else {
                    out.println("<section id=\"error\" class=\"container text-center\">\n        <h1>¿Ya te has registrado antes?</h1>\n        <p>El usuario que se te ha asignado ya existe, probablemente ya estes registrado en la p\u00e1gina, intenta iniciar sesi\u00f3n, si este no es tu caso por favor ve a control escolar a que solucionen esto o envia un correo a: contacto@secundaria120.com<br><br>\n        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n    </section><!--/#error-->\n<br><br><br>");
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

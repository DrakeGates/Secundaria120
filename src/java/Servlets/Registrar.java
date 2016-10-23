// 
// Decompiled by Procyon v0.5.30
// 

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.io.InputStream;
import javax.servlet.http.Part;
import java.io.PrintWriter;
import java.sql.SQLException;
import Clases.DB;
import Clases.UsuarioDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Registrar extends HttpServlet
{
    public String capitalizar(final String palabra) {
        if (palabra.length() == 0) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final UsuarioDAO p = new UsuarioDAO();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        boolean registrar = true;
        String nombre = request.getParameter("nombre");
        String Apaterno = request.getParameter("Apaterno");
        String Amaterno = request.getParameter("Amaterno");
        String ano = request.getParameter("ano");
        String grupo = request.getParameter("grupo");
        String sexo = request.getParameter("sexo");
        String nacimiento = request.getParameter("nacimiento");
        final String curp = request.getParameter("curp");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        final String telefono = request.getParameter("telefono");
        final String calle = request.getParameter("calle");
        final String num = request.getParameter("num");
        final String colonia = request.getParameter("colonia");
        final String delegacion = request.getParameter("delegacion");
        final String estado = request.getParameter("estado");
        final String cp = request.getParameter("cp");
        String comentarioDir = request.getParameter("comentarioDir");
        String peso = request.getParameter("peso");
        String estatura = request.getParameter("estatura");
        String lentes = request.getParameter("lentes");
        String zapatos = request.getParameter("zapatos");
        String auditivo = request.getParameter("auditivo");
        String comentarioAlu = request.getParameter("comentarioAlu");
        String nombreT = request.getParameter("nombreT");
        String ApaternoT = request.getParameter("ApaternoT");
        String AmaternoT = request.getParameter("AmaternoT");
        String sexoT = request.getParameter("sexoT");
        String nacimientoT = request.getParameter("nacimientoT");
        String curpT = request.getParameter("curpT");
        String emailT = request.getParameter("emailT");
        final String celularT = request.getParameter("celularT");
        final String telefonoT = request.getParameter("telefonoT");
        String parentesco = request.getParameter("parentesco");
        final String afiliacion = request.getParameter("afiliacion");
        final String vive = request.getParameter("vive");
        final Part foto = request.getPart("foto");
        final String tipo = foto.getContentType();
        final long tama\u00f1o = foto.getSize();
        final String nomFoto = foto.getSubmittedFileName();
        final InputStream f = foto.getInputStream();
        try {
            if (nombre == null || nombre.length() == 0 || Amaterno == null || Amaterno.length() == 0 || Apaterno == null || Apaterno.length() == 0 || curp == null || curp.length() == 0 || telefono == null || telefono.length() == 0) {
                response.sendRedirect("Error.jsp");
            }
            if (ano == null || ano.length() != 1) {
                ano = "1";
            }
            if (grupo == null || grupo.length() != 1) {
                grupo = "A";
            }
            if (sexo == null || sexo.length() == 0) {
                sexo = "Masculino";
            }
            if (nacimiento == null || nacimiento.length() == 0) {
                nacimiento = "1999-09-06";
            }
            if (email == null || email.length() == 0 || email.length() > 40) {
                email = "SinCorreo";
            }
            if (celular == null || celular.length() == 0 || celular.length() > 10) {
                celular = "0";
            }
            if (peso == null || peso.length() == 0) {
                peso = "0";
            }
            try {
                Float.parseFloat(peso);
            }
            catch (Exception e) {
                peso = "0";
            }
            if (estatura == null || estatura.length() == 0) {
                estatura = "0";
            }
            try {
                Float.parseFloat(estatura);
            }
            catch (Exception e) {
                estatura = "0";
            }
            if (lentes == null || lentes.length() == 0) {
                lentes = "n";
            }
            if (zapatos == null || zapatos.length() == 0) {
                zapatos = "n";
            }
            if (auditivo == null || auditivo.length() == 0) {
                auditivo = "n";
            }
            if (calle == null || calle.length() == 0 || num == null || num.length() == 0 || colonia == null || colonia.length() == 0 || delegacion == null || delegacion.length() == 0 || estado == null || estado.length() == 0 || cp == null || cp.length() == 0) {
                response.sendRedirect("Error.jsp");
            }
            if (comentarioDir == null || comentarioDir.length() == 0) {
                comentarioDir = "Sin Comentario";
            }
            if (comentarioAlu == null || comentarioAlu.length() == 0) {
                comentarioAlu = "Sin Comentario";
            }
            if (sexoT == null || sexoT.length() == 0) {
                sexoT = "Femenino";
            }
            if (nacimientoT == null || nacimientoT.length() == 0) {
                nacimientoT = "1990-09-06";
            }
            if (nombreT == null || nombreT.length() == 0 || AmaternoT == null || AmaternoT.length() == 0 || ApaternoT == null || ApaternoT.length() == 0 || telefonoT == null || telefonoT.length() == 0 || celularT == null || celularT.length() == 0) {
                response.sendRedirect("Error.jsp");
            }
            if (parentesco == null || parentesco.length() == 0) {
                parentesco = "Madre";
            }
            if (curpT == null || curpT.length() == 0) {
                curpT = "SinCurp";
            }
            if (emailT == null || emailT.length() == 0) {
                emailT = "SinCorreo";
            }
        }
        catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
        String usuario = "";
        String pass = "";
        if (nombre.length() >= 3 || Apaterno.length() >= 3 || Amaterno.length() >= 3 || curp.length() == 18) {
            usuario = nombre.substring(0, 3) + Apaterno.substring(0, 3) + Amaterno.substring(0, 3) + curp.charAt(17);
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
        if (nombreT.length() >= 3 || ApaternoT.length() >= 3 || AmaternoT.length() >= 3) {
            pass = nombreT.substring(0, 3) + ApaternoT.substring(0, 3) + AmaternoT.substring(0, 3);
            pass = pass.toLowerCase();
            pass = pass.replace('\u00e1', 'a');
            pass = pass.replace('\u00e9', 'e');
            pass = pass.replace('\u00ed', 'i');
            pass = pass.replace('\u00f3', 'o');
            pass = pass.replace('\u00fa', 'u');
        }
        else {
            response.sendRedirect("Error.jsp");
        }
        nombre = this.capitalizar(nombre);
        Apaterno = this.capitalizar(Apaterno);
        Amaterno = this.capitalizar(Amaterno);
        nombreT = this.capitalizar(nombreT);
        ApaternoT = this.capitalizar(ApaternoT);
        AmaternoT = this.capitalizar(AmaternoT);
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
        out.println("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n    <title>Exito</title>\n\n    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n    <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n    <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n    <link href=\"css/main.css\" rel=\"stylesheet\">\n    <link href=\"css/responsive.css\" rel=\"stylesheet\">\n    <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n    <script src=\"js/validacion.js\" language=\"javascript\" type=\"text/javascript\"></script>\n</head><!--/head-->\n\n<body class=\"homepage\">\n    <header>\n        <nav class=\"navbar navbar-inverse\" role=\"banner\">\n            <div class=\"container\">\n                <div class=\"navbar-header\">\n                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                        <span class=\"sr-only\">Navegacion</span>\n                        <span class=\"icon-bar\"></span>\n                        <span class=\"icon-bar\"></span>\n                        <span class=\"icon-bar\"></span>\n                    </button>\n                    <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"logo\"></a>\n                </div>\n\t\t\t\t\n                <div class=\"collapse navbar-collapse navbar-right\">\n                    <ul class=\"nav navbar-nav\">\n                        <li class=\"active\"><a href=\"index.jsp\">Inicio</a></li>\n                        <li><a href=\"Secundaria120.jsp\">Secundaria 120</a></li>\n                        <li><a href=\"CuadroHonor.jsp\">Cuadro de Honor</a></li>\n                        <li><a href=\"Informacion.jsp\">Informaci\u00f3n</a></li>\n                        <li class=\"nivel1\"><a href=\"InicioSesion.jsp\">Inicia Sesi\u00f3n</a></li>\n                    </ul>\n                </div>\n            </div><!--/.container-->\n        </nav><!--/nav-->\t\t\n    </header><!--/header-->");
        if (registrar) {
            try {
                p.RegistrarAlumno(nombre, Apaterno, Amaterno, ano, grupo, sexo, nacimiento, curp, email, celular, telefono, calle, num, colonia, delegacion, estado, cp, comentarioDir, usuario, pass, peso, estatura, lentes, zapatos, auditivo, comentarioAlu, nombreT, ApaternoT, AmaternoT, sexoT, nacimientoT, curpT, emailT, celularT, telefonoT, parentesco, afiliacion, vive);
                if (tama\u00f1o < 1500000L) {
                    if (tipo.equals("image/jpeg") || tipo.equals("image/png") || tipo.equals("image/jpg")) {
                        p.guardaImagen(usuario, nomFoto, f);
                        out.println("<section id=\"error\" class=\"container text-center\">\n        <h1>\u00c9XITO</h1>\n        <p>El registro se ha completado con \u00e9xito :)</p>\n        <h1>DATOS DE ACCESO</h1><h3><p>Tu nombre de usuario es: <strong>" + usuario + "</strong><br>Tu contrase\u00f1a es: <strong>" + pass + "</strong></p></h3><br><br>\n" + "        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n" + "    </section><!--/#error-->\n" + "<br><br><br>");
                    }
                    else {
                        out.println("<section id=\"error\" class=\"container text-center\">\n        <h1>\u00c9XITO</h1>\n        <h3><p>El registro se ha completado con \u00e9xito :)<br> Pero no se pudo agregar la fotograf\u00eda porque el formato no coincide con el solicitado o porque no seleccionaste ninguna :(</p></h3>\n        <h1>DATOS DE ACCESO</h1><h3><p>Tu nombre de usuario es: <strong>" + usuario + "</strong><br>Tu contrase\u00f1a es: <strong>" + pass + "</strong></p></h3><br><br>\n" + "        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n" + "    </section><!--/#error-->\n" + "<br><br><br>");
                    }
                }
                else {
                    out.println("<section id=\"error\" class=\"container text-center\">\n        <h1>\u00c9XITO</h1>\n        <p>El registro se ha completado con \u00e9xito :)<br> Pero no se pudo agregar la fotograf\u00eda porque la fotografia seleccionada ocupa demasiada memoria :(</p>\n        <h1>DATOS DE ACCESO</h1><h3><p>Tu nombre de usuario es: <strong>" + usuario + "</strong><br>Tu contrase\u00f1a es: <strong>" + pass + "</strong></p></h3><br><br>\n" + "        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n" + "    </section><!--/#error-->" + "<br><br><br>");
                }
            }
            catch (SQLException ex) {
                response.sendRedirect("Error.jsp");
            }
        }
        else {
            out.println("<br><br><br>\n<section id=\"error\" class=\"container text-center\">\n        <h1>¿Ya te has registrado antes?</h1>\n        <p>El usuario que se te ha asignado ya existe, probablemente ya estes registrado en la p\u00e1gina, intenta iniciar sesi\u00f3n, si este no es tu caso por favor ve a control escolar a que solucionen esto o envia un correo a: contacto@secundaria120.com<br><br>\n        <a class=\"btn btn-primary\" href=\"index.jsp\">Ir a inicio</a>\n    </section><!--/#error-->\n<br><br><br>");
        }
        out.println("<footer id=\"footer\" class=\"midnight-blue\">\n        <div class=\"container\">\n            <div class=\"row\">\n                <div class=\"col-sm-6\">\n                    &copy; 2016 <a target=\"_blank\" title=\"Desarrollo web\">By Gerardo Arceo</a>. <i class=\"fa fa-code\"></i>\n                </div>\n                <div class=\"col-sm-6\">\n                    <ul class=\"pull-right\">\n                        <li>Se feliz</li>\n                        <li><a id=\"gototop\" class=\"gototop\" href=\"#\"><i class=\"fa fa-arrow-up\"></i></a></li><!--#gototop-->\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </footer><!--/#footer-->\n    <script src=\"js/jquery.js\"></script>\n    <script src=\"js/bootstrap.min.js\"></script>\n    <script src=\"js/jquery.prettyPhoto.js\"></script>\n    <script src=\"js/jquery.isotope.min.js\"></script>\n    <script src=\"js/main.js\"></script>\n    <script src=\"js/wow.min.js\"></script>\n</body>\n</html>");
    }
}

package Servlets;

import javax.servlet.ServletException;
import java.io.InputStream;
import javax.servlet.http.Part;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import Clases.DB;
import Clases.Funciones;
import Clases.UsuarioDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class Director extends HttpServlet
{
    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final UsuarioDAO p = new UsuarioDAO();
        final Funciones Funcion = new Funciones();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            final String opc = request.getParameter("opc");
            String idDirector = request.getParameter("idDirector");
            final String nombre = request.getParameter("nombre");
            final String fecha = Funcion.VerFecha(idDirector);
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
"        <title>Director</title>" + 
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
"    <body class=\"homepage\">        <header>" + 
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
"                            <li><a href=\"Director.jsp\">Menu</a></li>" + 
"                                <li class=\"dropdown active\">" + 
"                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Hola" + nombre + "<i class=\"fa fa-angle-down\"></i></a>" + 
"                                       <ul class=\"dropdown-menu\">" + 
"       <form method=\"post\" action=\"Director\" name=\"verdatos\">" + 
"                                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"1\"></form>" + 
"                                      <li><a href=\"#\" onClick=\"verDatos()\">Ver mis datos</a></li>" + "                               <li><a href=\"CerrarSesion\">Cerrar Sesi\u00f3n</a></li>" + "                                </ul>" + 
"                                   </li>  " + 
"                               </ul>" + 
"                           </div>" + 
"                       </div><!--/.container-->" + 
"                   </nav><!--/nav-->" + 
"               </header><!--/header-->");
            out.println("<div class=\"center\"><h2><br>");
            out.println("<p>Men\u00fa de" + nombre + "</p>");
            out.println("</h2><hr>");
            switch (opc) {
                case"1":
                    final ArrayList<String> Datos = (ArrayList<String>)Funcion.VerDatos(idDirector);
                    out.println("<br><br><br><br><h2>Datos Personales</h2><br>");
                    if (Datos.size() >= 8) {
                        out.println("<h3>Nombre:" + Datos.get(0) + "<br>Apellido Paterno:" + Datos.get(1) + "<br>Apellido Materno:" + Datos.get(2) + "<br>Nacimiento:" + Datos.get(3) + "<br>Curp:" + Datos.get(4) + "<br>Email:" + Datos.get(5) + "<br>Celular:" + Datos.get(6) + "<br>Telefono:" + Datos.get(7));
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }   out.println("<br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div><br><br>");
                    break;
                case"2.3":
                    {
                        final String idAlumno = request.getParameter("idAlumno");
                        try (final Connection con = DB.getConnection()) {
                            final Statement sentencia = con.createStatement();
                            final String query ="call VerDatos(" + idAlumno + ");";
                            final ResultSet resultados = sentencia.executeQuery(query);
                            if (resultados.next()) {
                                out.println("</div><section id=\"contact-page\">" + 
"        <div class=\"container\">" + 
"            <div class=\"center\">" + 
"                <br>" + 
"                <h2>Modificar Alumno</h2>" + 
"            </div>" + 
"            <div class=\"row contact-wrap\">" + 
"                <div class=\"status alert alert-success\" style=\"display: none\"></div>" + 
"               " + 
"                <form enctype=\"multipart/form-data\" id=\"main-contact-form\" class=\"contact-form\" name=\"contact-form\" method=\"post\" action=\"Director\">" + 
"                    <div class=\"col-sm-5 col-sm-offset-1\">" + 
"                       " + 
"                        <fieldset>" + 
"                        <h2>Datos Personales</h2>" + 
"                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.4\">" + 
"                    <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Nombre</label>" + 
"                                   <input type=\"text\" name=\"nombre1\" value=\"" + resultados.getString("Nombre") + "\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Paterno</label>" + 
"                                   <input type=\"text\" name=\"Apaterno\" value=\"" + resultados.getString("Apaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Materno</label>" + 
"                                   <input type=\"text\" name=\"Amaterno\" value=\"" + resultados.getString("Amaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Grado</label>" + 
"       <select name=\"ano\">");
                                switch (resultados.getString("Ano")) {
                                    case"1":
                                        out.println("<option selected value=\"1\">1º</option>" + 
"                                <option value=\"2\">2º</option>" + 
"                                <option value=\"3\">3º</option>");
                                        break;
                                    case"2":
                                        out.println("<option value=\"1\">1º</option>" + 
"                                <option selected value=\"2\">2º</option>" + 
"                                <option value=\"3\">3º</option>");
                                        break;
                                    case"3":
                                        out.println("<option value=\"1\">1º</option>" + 
"                                <option value=\"2\">2º</option>" + 
"                                <option selected value=\"3\">3º</option>");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Grupo</label>" + 
"                            <select name=\"grupo\">" + 
"");
                                switch (resultados.getString("Grupo")) {
                                    case"A":
                                        out.println("<option selected value=\"A\">A</option>" + 
"                                <option value=\"B\">B</option>" + 
"                                <option value=\"C\">C</option>" + 
"                                <option value=\"D\">D</option>" + 
"                                <option value=\"E\">E</option>" + 
"");
                                        break;
                                    case"B":
                                        out.println("<option value=\"A\">A</option>" + 
"                                <option selected value=\"B\">B</option>" + 
"                                <option value=\"C\">C</option>" + 
"                                <option value=\"D\">D</option>" + 
"                                <option value=\"E\">E</option>" + 
"");
                                        break;
                                    case"C":
                                        out.println("<option value=\"A\">A</option>" + 
"                                <option value=\"B\">B</option>" + 
"                                <option selected value=\"C\">C</option>" + 
"                                <option value=\"D\">D</option>" + 
"                                <option value=\"E\">E</option>" + 
"");
                                        break;
                                    case"D":
                                        out.println("<option value=\"A\">A</option>" + 
"                                <option value=\"B\">B</option>" + 
"                                <option value=\"C\">C</option>" + 
"                                <option selected value=\"D\">D</option>" + 
"                                <option value=\"E\">E</option>" + 
"");
                                        break;
                                    case"E":
                                        out.println("<option value=\"A\">A</option>" + 
"                                <option value=\"B\">B</option>" + 
"                                <option value=\"C\">C</option>" + 
"                                <option value=\"D\">D</option>" + 
"                                <option selected value=\"E\">E</option>" + 
"");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Sexo</label>" + 
"                            <select name=\"sexo1\" selected=" + resultados.getString("Sexo") + ">" + 
"");
                                if (resultados.getString("Sexo").equals("Masculino")) {
                                    out.println("<option selected value=\"Masculino\">Masculino</option>" + 
"                                <option value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                else if (resultados.getString("Sexo").equals("Femenino")) {
                                    out.println("<option value=\"Masculino\">Masculino</option>" + 
"                                <option selected value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Fecha de nacimiento</label>" + 
"                            <input type=\"date\" value=" + resultados.getString("Nacimiento") + " name=\"nacimiento\" min=\"2000-01-01\" max=\"2010-01-01\" class=\"form-control\">" + 
"                               </div>       " + 
"                               <div class=\"form-group\">" + 
"                                   <label>CURP</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Curp") + " name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>E-Mail</label>" + 
"                                   <input type=\"email\" value=" + resultados.getString("Email") + " name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Celular</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("Celular") + " name=\"celular\" class=\"form-control\" size=\"12\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Telefono de casa</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("Telefono") + " name=\"telefono\" class=\"form-control\" size=\"10\">" + 
"                               </div><br><br>" + 
"                               </fieldset>" + 
"                              " + 
"                               <fieldset>" + 
"                                   <h2>Datos Medicos</h2>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Peso</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Peso") + " name=\"peso\" class=\"form-control\" size=\"10\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Estatura</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Estatura") + " name=\"estatura\" class=\"form-control\" size=\"10\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>¿Necesitas lentes?</label><br>" + 
"                                   <select name=\"lentes\">" + 
"");
                                if (resultados.getString("Lentes").equals("s")) {
                                    out.println("<option selected value=\"s\">Si</option>" + 
"                                <option value=\"n\">No</option>" + 
"");
                                }
                                else if (resultados.getString("Lentes").equals("n")) {
                                    out.println("<option value=\"s\">Si</option>" + 
"                                <option selected value=\"n\">No</option>" + 
"");
                                }
                                out.println("</select><br><br>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                        <label>¿Necesitas zapatos ortopedicos?</label><br>" + 
"                            <select name=\"zapatos\">" + 
"");
                                if (resultados.getString("Zapatos").equals("s")) {
                                    out.println("<option selected value=\"s\">Si</option>" + 
"                                <option value=\"n\">No</option>" + 
"");
                                }
                                else if (resultados.getString("Zapatos").equals("n")) {
                                    out.println("<option value=\"s\">Si</option>" + 
"                                <option selected value=\"n\">No</option>" + 
"");
                                }
                                out.println("</select><br><br>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                        <label>¿Tienes dificultades auditivas?</label><br>" + 
"                            <select name=\"auditivo\">" + 
"");
                                if (resultados.getString("Auditivo").equals("s")) {
                                    out.println("<option selected value=\"s\">Si</option>" + 
"                                <option value=\"n\">No</option>" + 
"");
                                }
                                else if (resultados.getString("Auditivo").equals("n")) {
                                    out.println("<option value=\"s\">Si</option>" + 
"                                <option selected value=\"n\">No</option>" + 
"");
                                }
                                out.println("</select><br><br>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Algun comentario sobre tu salud o persona?</label>" + 
"                            <textarea name=\"comentarioAlu\" id=\"message\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados.getString("DatosExtraAlumno.Comentario") + "</textarea>" + 
"                               </div>" + "                        <div class=\"form-group\">" + 
"                               <label>Afiliacion Medica</label><br>" + 
"                                   <select name=\"afiliacion\">");
                                switch (resultados.getString("Afiliacion")) {
                                    case"ISSSTE":
                                        out.println("<option selected value=\"ISSSTE\">ISSSTE</option>" + 
"                                <option value=\"IMSS\">IMSS</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"                                <option value=\"Ninguno\">Ninguno</option>");
                                        break;
                                    case"IMSS":
                                        out.println("<option value=\"ISSSTE\">ISSSTE</option>" + 
"                                <option selected value=\"IMSS\">IMSS</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"                                <option value=\"Ninguno\">Ninguno</option>");
                                        break;
                                    case"Otro":
                                        out.println("<option value=\"ISSSTE\">ISSSTE</option>" + 
"                                <option value=\"IMSS\">IMSS</option>" + 
"                                <option selected value=\"Otro\">Otro</option>" + 
"                                <option value=\"Ninguno\">Ninguno</option>");
                                        break;
                                    case"Ninguno":
                                        out.println("<option value=\"ISSSTE\">ISSSTE</option>" + 
"                                <option value=\"IMSS\">IMSS</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"                                <option selected value=\"Ninguno\">Ninguno</option>");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</selected></div><br>                        </fieldset><br><br><br><br>" + 
"                       " + 
"                        <fieldset><br><br><br><br>" + 
"                        <h2>Datos de acceso</h2>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Crea un usuario</label>" + 
"                            <input type=\"text\" value=\"" + resultados.getString("Usuario") + "\" name=\"usuario\" class=\"form-control\" size=\"20\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Contrase\u00f1a</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Pass") + " name=\"pass\" class=\"form-control\" size=\"20\">" + 
"                               </div>" + 
"                               </fieldset>" + 
"                           </div>" + 
"        " + 
"                           <div class=\"col-sm-5\">" + 
"       <fieldset>" + 
"                               <h2>Fotograf\u00eda</h2>");
                                out.println("<p><img src=\"F?idAlumno=" + idAlumno + "\" width=\"87\" height=\"105\" align=\"left\">Fotograf\u00eda Actual</p>");
                                final String folio = resultados.getString("Folio");
                                out.println("                        <input type=\"file\" name=\"foto\"/><br>                         <input type=\"text\" name=\"folio\" value=" + folio + "> Folio<br>" + "                        <fieldset>" + 
"                               <h2>Direccion</h2>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Calle</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Calle") + "\" name=\"calle\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Numero</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Num") + " name=\"num\" class=\"form-control\" required=\"required\" size=\"4\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Colonia</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Colonia") + "\" name=\"colonia\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Delegacion</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Delegacion") + "\" name=\"delegacion\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                               <label>Estado</label>" + 
"                                   <select name=\"estado\">" + 
"");
                                switch (resultados.getString("Estado")) {
                                    case"Ciudad de Mexico":
                                        out.println("<option selected value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Estado de Mexico":
                                        out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option selected value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Otro":
                                        out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option selected value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</select><br><br>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Codigo Postal</label>" + 
"                            <input type=\"text\" value=" + resultados.getString("cp") + " name=\"cp\" class=\"form-control\" required=\"required\" size=\"5\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Algun comentario sobre el lugar donde vives?</label>" + 
"                                   <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados.getString("catDirecciones.Comentario") + "</textarea>" + 
"                               </div>" + 
"                               </fieldset><br><br>" + 
"                              " + 
"                               <fieldset>" + 
"                               <h2>Datos de Tutor</h2>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Parentesco con el alumno</label>" + 
"                                   <select name=\"parentesco\">" + 
"");
                                switch (resultados.getString("DatosExtraAlumno.Parentesco")) {
                                    case"Madre":
                                        out.println("<option selected value=\"Madre\">Madre</option>" + 
"                                <option value=\"Padre\">Padre</option>" + 
"                                <option value=\"Tio o tia\">Tio o tia</option>" + 
"                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Padre":
                                        out.println("<option value=\"Madre\">Madre</option>" + 
"                                <option selected value=\"Padre\">Padre</option>" + 
"                                <option value=\"Tio o tia\">Tio o tia</option>" + 
"                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Tio o tia":
                                        out.println("<option value=\"Madre\">Madre</option>" + 
"                                <option value=\"Padre\">Padre</option>" + 
"                                <option selected value=\"Tio o tia\">Tio o tia</option>" + 
"                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Abuelo o abuela":
                                        out.println("<option value=\"Madre\">Madre</option>" + 
"                                <option value=\"Padre\">Padre</option>" + 
"                                <option value=\"Tio o tia\">Tio o tia</option>" + 
"                                <option selected value=\"Abuelo o abuela\">Abuelo o abuela</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Otro":
                                        out.println("<option value=\"Madre\">Madre</option>" + 
"                                <option value=\"Padre\">Padre</option>" + 
"                                <option value=\"Tio o tia\">Tio o tia</option>" + 
"                                <option value=\"Abuelo o abuela\">Abuelo o abuela</option>" + 
"                                <option selected value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Nombre</label>" + 
"                            <input type=\"text\" value=\"" + resultados.getString("d1.Nombre") + "\" name=\"nombreT\" class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Paterno</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("d1.Apaterno") + "\" name=\"ApaternoT\" class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Materno</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("d1.Amaterno") + "\" name=\"AmaternoT\" class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Sexo</label>" + 
"                                   <select name=\"sexoT\">" + 
"");
                                if (resultados.getString("d1.Sexo").equals("Masculino")) {
                                    out.println("<option selected value=\"Masculino\">Masculino</option>" + 
"                                <option value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                else if (resultados.getString("d1.Sexo").equals("Femenino")) {
                                    out.println("<option value=\"Masculino\">Masculino</option>" + 
"                                <option selected value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Fecha de nacimiento</label>" + 
"                            <input type=\"date\" value=" + resultados.getString("d1.Nacimiento") + " name=\"nacimientoT\" min=\"1900-01-01\" max=\"2010-01-01\" class=\"form-control\">" + 
"                               </div>       " + 
"                               <div class=\"form-group\">" + 
"                                   <label>CURP</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("d1.Curp") + " name=\"curpT\" class=\"form-control\" required=\"required\" size=\"18\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>E-Mail</label>" + 
"                                   <input type=\"email\" value=" + resultados.getString("d1.Email") + " name=\"emailT\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Celular</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("d1.Celular") + " name=\"celularT\" class=\"form-control\" size=\"12\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Telefono del trabajo</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("d1.Telefono") + " name=\"telefonoT\" class=\"form-control\" size=\"10\">" + 
"                               </div><br>" + "<div class=\"form-group\">" + 
"                                   <label>Con quien vive el alumno</label>" + 
"                                   <select name=\"vive\">");
                                final String string = resultados.getString("Vive");
                                switch (string) {
                                    case"Padre": {
                                        out.println("<option selected value=\"Padre\">Padre</option>" + 
"                                <option value=\"Madre\">Madre</option>" + 
"                                <option value=\"Ambos\">Ambos</option>" + 
"                                <option value=\"Otro\">Otro</option>");
                                        break;
                                    }
                                    case"Madre": {
                                        out.println("<option value=\"Padre\">Padre</option>" + 
"                                <option selected value=\"Madre\">Madre</option>" + 
"                                <option value=\"Ambos\">Ambos</option>" + 
"                                <option value=\"Otro\">Otro</option>");
                                        break;
                                    }
                                    case"Ambos": {
                                        out.println("<option value=\"Padre\">Padre</option>" + 
"                                <option value=\"Madre\">Madre</option>" + 
"                                <option selected value=\"Ambos\">Ambos</option>" + 
"                                <option value=\"Otro\">Otro</option>");
                                        break;
                                    }
                                    case"Otro": {
                                        out.println("<option value=\"Padre\">Padre</option>" + 
"                                <option value=\"Madre\">Madre</option>" + 
"                                <option value=\"Ambos\">Ambos</option>" + 
"                                <option selected value=\"Otro\">Otro</option>");
                                        break;
                                    }
                                }
                                out.println("                     </select></div><br><br>   </fieldset><br><br><br>                        <div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Guardar cambios</button>" + 
"                        </div>                    </div>" + 
"                </form>" + 
"            </div><!--/.row-->" + 
"        </div><!--/.container-->" + 
"    </section><!--/#contact-page-->");
                            }
                            con.close();
                        }
                        catch (SQLException ex2) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"2.4":
                    {
                        response.setContentType("text/html;charset=UTF-8");
                        response.setCharacterEncoding("UTF-8");
                        request.setCharacterEncoding("UTF-8");
                        final String nombre2 = request.getParameter("nombre1");
                        final String Apaterno = request.getParameter("Apaterno");
                        final String Amaterno = request.getParameter("Amaterno");
                        final String ano = request.getParameter("ano");
                        final String grupo = request.getParameter("grupo");
                        final String sexo1 = request.getParameter("sexo1");
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
                        final String tipo = foto.getContentType();
                        final long tama\u00f1o = foto.getSize();
                        final String nomFoto = foto.getSubmittedFileName();
                        final InputStream f = foto.getInputStream();
                        try {
                            p.ModificarAlumno(nombre2, Apaterno, Amaterno, ano, grupo, sexo1, nacimiento, curp, email, celular, telefono, calle, num, colonia, delegacion, estado, cp, comentarioDir, usuario, pass, peso, estatura, lentes, zapatos, auditivo, comentarioAlu, nombreT, ApaternoT, AmaternoT, sexoT, nacimientoT, curpT, emailT, celularT, telefonoT, parentesco, idAlumno2, afiliacion, vive, folio2);
                            out.println("<br><br><br><br><br><br>");
                            out.println("<h2>Exito: Se ha modificado correctamente al alumno :)</h2>");
                            if (tama\u00f1o < 1500000L) {
                                if (tipo.equals("image/jpeg") || tipo.equals("image/png") || tipo.equals("image/jpg")) {
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
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                            out.println("<br><br><br><br><br><br></div>");
                        }
                        catch (SQLException ex3) {
                            response.sendRedirect("Error.jsp");
                        }       break;
                    }
                case"2.5":
                    {
                        final String idPersona = request.getParameter("idPersona");
                        final String query2 ="call VerDatos(" + idPersona + ")";
                        try (final Connection con2 = DB.getConnection()) {
                            final Statement sentencia2 = con2.createStatement();
                            final ResultSet resultados = sentencia2.executeQuery(query2);
                            if (resultados.next()) {
                                out.println("</div><section id=\"contact-page\">" + 
"        <div class=\"container\">" + 
"            <div class=\"center\">" + 
"                <br>" + 
"                <h2>Modificar Usuario</h2>" + 
"            </div>" + 
"            <div class=\"row contact-wrap\">" + 
"                <div class=\"status alert alert-success\" style=\"display: none\"></div>" + 
"               " + 
"                <form id=\"main-contact-form\" class=\"contact-form\" name=\"contact-form\" method=\"post\" action=\"Director\">" + 
"                    <div class=\"col-sm-5 col-sm-offset-1\">" + 
"                       " + 
"                        <fieldset>" + 
"                        <h2>Datos Personales</h2>" + 
"                    <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.6\">" + 
"                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados.getString("idPersona") + ">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Nombre</label>" + 
"                                   <input type=\"text\" name=\"nombre1\" value=\"" + resultados.getString("Nombre") + "\" title=\"Debes de ingresar tu nombre\" class=\"form-control\" size=\"30\" required/>" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Paterno</label>" + 
"                                   <input type=\"text\" name=\"Apaterno\" value=\"" + resultados.getString("Apaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Apellido Materno</label>" + 
"                                   <input type=\"text\" name=\"Amaterno\" value=\"" + resultados.getString("Amaterno") + "\"  class=\"form-control\" required=\"required\" size=\"30\">" + 
"                               </div>" + 
"");
                                out.println("                        <div class=\"form-group\">" + 
"                            <label>Sexo</label>" + 
"                            <select name=\"sexo1\" selected=" + resultados.getString("Sexo") + ">" + 
"");
                                if (resultados.getString("Sexo").equals("Masculino")) {
                                    out.println("<option selected value=\"Masculino\">Masculino</option>" + 
"                                <option value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                else if (resultados.getString("Sexo").equals("Femenino")) {
                                    out.println("<option value=\"Masculino\">Masculino</option>" + 
"                                <option selected value=\"Femenino\">Femenino</option>" + 
"");
                                }
                                out.println("</select>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Fecha de nacimiento</label>" + 
"                            <input type=\"date\" value=" + resultados.getString("Nacimiento") + " name=\"nacimiento\" min=\"2000-01-01\" max=\"2010-01-01\" class=\"form-control\">" + 
"                               </div>       " + 
"                               <div class=\"form-group\">" + 
"                                   <label>CURP</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Curp") + " name=\"curp\" class=\"form-control\" required=\"required\" size=\"18\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>E-Mail</label>" + 
"                                   <input type=\"email\" value=" + resultados.getString("Email") + " name=\"email\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Celular</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("Celular") + " name=\"celular\" class=\"form-control\" size=\"12\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Telefono de casa</label>" + 
"                                   <input type=\"number\" value=" + resultados.getString("Telefono") + " name=\"telefono\" class=\"form-control\" size=\"10\">" + 
"                               </div><br><br>" + 
"                               </fieldset>" + 
"                              " + 
"                               <fieldset>" + 
"                               <h2>Datos de acceso</h2>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Crea un usuario</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Usuario") + "\" name=\"usuario\" class=\"form-control\" size=\"20\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Contrase\u00f1a</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Pass") + " name=\"pass\" class=\"form-control\" size=\"20\">" + 
"                               </div>" + 
"                               </fieldset>" + 
"                           </div>" + 
"        " + 
"                           <div class=\"col-sm-5\">" + 
"                               <fieldset>" + 
"                               <h2>Direccion</h2>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Calle</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Calle") + "\" name=\"calle\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Numero</label>" + 
"                                   <input type=\"text\" value=" + resultados.getString("Num") + " name=\"num\" class=\"form-control\" required=\"required\" size=\"4\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Colonia</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Colonia") + "\" name=\"colonia\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Delegacion</label>" + 
"                                   <input type=\"text\" value=\"" + resultados.getString("Delegacion") + "\" name=\"delegacion\" class=\"form-control\" required=\"required\" size=\"40\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                               <label>Estado</label>" + 
"                                   <select name=\"estado\">" + 
"");
                                switch (resultados.getString("Estado")) {
                                    case"Ciudad de Mexico":
                                        out.println("<option selected value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Estado de Mexico":
                                        out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option selected value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    case"Otro":
                                        out.println("<option value=\"Ciudad de Mexico\">Ciudad de Mexico</option>" + 
"                                <option value=\"Estado de Mexico\">Estado de Mexico</option>" + 
"                                <option selected value=\"Otro\">Otro</option>" + 
"");
                                        break;
                                    default:
                                        break;
                                }
                                out.println("</select><br><br>" + 
"                        </div>" + 
"                        <div class=\"form-group\">" + 
"                            <label>Codigo Postal</label>" + 
"                            <input type=\"text\" value=" + resultados.getString("cp") + " name=\"cp\" class=\"form-control\" required=\"required\" size=\"5\">" + 
"                               </div>" + 
"                               <div class=\"form-group\">" + 
"                                   <label>Algun comentario sobre el lugar donde vives?</label>" + 
"                                   <textarea name=\"comentarioDir\" id=\"message\" placeholder=\"(Ej.Edificio 'A' 2º piso Tocar la puerta fuerte)\" required=\"required\" class=\"form-control\" rows=\"8\">" + resultados.getString("catDirecciones.Comentario") + "</textarea>" + 
"                               </div>" + 
"                               </fieldset><br><br>" + 
"                              " + 
"                               <br><br><br><br>" + 
"                              " + 
"                               <div class=\"form-group center\">" + 
"                                   <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Guardar cambios</button>" + 
"                               </div>" + 
"                           </div>" + 
"                       </form>" + 
"");
                                if (resultados.getString("idTipo").equals("2")) {
                                    out.println("<form action=\"Director\" method=\"POST\">                    <input type=\"hidden\" name=\"idPersona\" value=" + resultados.getString("idPersona") + ">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <div class=\"form-group center\">" + 
"       <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.7\">" + 
"                                   <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Modificar asignaturas impartidas</button>" + 
"                               </div>" + 
"");
                                }
                                out.println("            </div><!--/.row-->" + 
"        </div><!--/.container-->" + 
"    </section><!--/#contact-page-->");
                            }
                            con2.close();
                        }
                        catch (SQLException ex4) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"2.6":
                    {
                        response.setContentType("text/html;charset=UTF-8");
                        response.setCharacterEncoding("UTF-8");
                        request.setCharacterEncoding("UTF-8");
                        final String nombre2 = request.getParameter("nombre1");
                        final String Apaterno = request.getParameter("Apaterno");
                        final String Amaterno = request.getParameter("Amaterno");
                        final String sexo2 = request.getParameter("sexo1");
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
                            p.ModificarUsuario(nombre2, Apaterno, Amaterno, sexo2, nacimiento2, curp2, email2, celular2, telefono2, calle2, num2, colonia2, delegacion2, estado2, cp2, comentarioDir2, usuario2, pass2, idPersona2, idDirector);
                            out.println("<br><br><br><br><br><br><h2>Exito: Se ha modificado correctamente el usuario</h2>");
                            out.println("<br><br><br><br><br><br>");
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                            out.println("<br><br><br><br><br><br></div>");
                        }
                        catch (SQLException ex5) {
                            response.sendRedirect("Error.jsp");
                        }       break;
                    }
                case"2.7":
                    {
                        final String idDocente = request.getParameter("idPersona");
                        try (final Connection con = DB.getConnection()) {
                            final Statement sentencia = con.createStatement();
                            final String query ="call VerTodasAsignaturasDadas(" + idDocente + ");";
                            final ResultSet resultados = sentencia.executeQuery(query);
                            out.println("<div class=\"col-sm-5 col-sm-offset-1\"><h2>Asignaturas impartidas por el docente</h2>");
                            out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.8\">" + 
"                           <div class=\"form-group\">" + 
"                           <select name=\"asignatura\">" + 
"");
                            while (resultados.next()) {
                                out.println("<option value=\"" + resultados.getString("idAsignatura") + " " + resultados.getString("Ano") + resultados.getString("Grupo") + "\">" + resultados.getString("Asignatura") + " en el grupo" + resultados.getString("Ano") + "º" + resultados.getString("Grupo") + "</option>" + 
"");
                            }
                            out.println("</select></div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Dejar de impartir la asignatura</button></form><br>");
                            out.println("</div>");
                            con.close();
                        }
                        catch (SQLException ex2) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<div class=\"col-sm-5\"><form action=\"Director\" method=\"POST\">" + 
"                        <h2>Agregar una nueva asignatura</h2>" + 
"                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.9\">" + 
"                                   <select name=\"asignatura\">" + 
"                                       <option value=\"1\">Espa\u00f1ol</option>" + 
"                                       <option value=\"2\">Ingl\u00e9s</option>" + 
"                                       <option value=\"3\">Matem\u00e1ticas</option>" + 
"                                       <option value=\"4\">Biolog\u00eda</option>" + 
"                                       <option value=\"5\">F\u00edsica</option>" + 
"                                       <option value=\"6\">Qu\u00edmica</option>" + 
"                                       <option value=\"7\">Geograf\u00eda</option>" + 
"                                       <option value=\"8\">Historia</option>" + 
"                                       <option value=\"9\">Asignatura Estatal</option>" + 
"                                       <option value=\"10\">Formaci\u00f3n C\u00edvica y \u00c9tica</option>" + 
"                                       <option value=\"11\">Tutor\u00eda</option>" + 
"                                       <option value=\"12\">Educaci\u00f3n F\u00edsica</option>" + 
"                                       <option value=\"13\">M\u00fasica</option>" + 
"                                       <option value=\"14\">Artes Pl\u00e1sticas</option>" + 
"                                       <option value=\"15\">Preparaci\u00f3n y Conservaci\u00f3n de Productos Alimenticios</option>" + 
"                                       <option value=\"16\">Bordados y Tejidos</option>" + 
"                                       <option value=\"17\">Dise\u00f1o Arquitect\u00f3nico</option>" + 
"                                       <option value=\"18\">Electrotecnia</option>" + 
"                                   </select><br><br>" + 
"                               </div>");
                        out.println("</select></div><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Continuar</button></form><br>");
                        out.println("<br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"2.8":
                    final String relacion = request.getParameter("asignatura");
                    final String delimitadores ="[ .,;?!¡¿'\"\\[\\]]+ ";
                    final String[] palabrasSeparadas = relacion.split(delimitadores);
                    final String idAsignatura = palabrasSeparadas[0];
                    final String anogrupo = palabrasSeparadas[1];
                    final char ano2 = anogrupo.charAt(0);
                    final char grupo2 = anogrupo.charAt(1);
                    final String idDocente2 = request.getParameter("idDocente");
                    final String query3 ="call EliminarAsignaturaGrupoDocente(" + idDocente2 + "," + idAsignatura + "," + ano2 + ",'" + grupo2 + "')";
                    try (final Connection con3 = DB.getConnection()) {
                        final Statement sentencia3 = con3.createStatement();
                        final ResultSet resultados2 = sentencia3.executeQuery(query3);
                        con3.close();
                        out.println("<br><br><br><br><br><br><h2>Exito: Se ha eliminado la asignatura correctamente :)</h2>");
                    }
                    catch (SQLException ex6) {
                        response.sendRedirect("Error.jsp");
                    }   out.println("<br><br><br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                    out.println("<br><br><br><br><br><br>");
                    break;
                case"2.9":
                    final int idAsignatura2 = Integer.parseInt(request.getParameter("asignatura"));
                    final String idDocente3 = request.getParameter("idDocente");
                    out.println("<div class=\"form-group center\"><h3>Por favor escoge el grupo en el que quieras impartir la asignatura seleccionada</h3></div>" + 
"");
                    out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDocente\" value=" + idDocente3 + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"idAsignatura\" value=" + idAsignatura2 + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"2.10\">" + 
"                               <label>Grado</label><br>" + 
"                                   <select name=\"ano\">" + 
"");
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
                    }   out.println("</select></div></div>");
                    out.println("<div class=\"col-sm-5\"><div class=\"form-group center\">                        <label>Grupo</label><br>" + 
"                            <select name=\"grupo\">" + 
"                               <option value=\"A\">A</option>                               <option value=\"B\">B</option>                               <option value=\"C\">C</option>                               <option value=\"D\">D</option>                               <option value=\"E\">E</option>                            </select></div></div>");
                    out.println("<div class=\"form-group center\"><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></div></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                    break;
                case"2.10":
                    {
                        final String idDocente = request.getParameter("idDocente");
                        final String idAsignatura3 = request.getParameter("idAsignatura");
                        final String ano3 = request.getParameter("ano");
                        final String grupo3 = request.getParameter("grupo");
                        final String query ="call AgregarAsignaturaGrupoDocente(" + idDocente + "," + idAsignatura3 + "," + ano3 + ",'" + grupo3 + "')";
                        final String query4 ="call VerAsignaturaExiste(" + idDocente + "," + idAsignatura3 + "," + ano3 + ",'" + grupo3 + "')";
                        try (final Connection con4 = DB.getConnection()) {
                            final Statement sentencia4 = con4.createStatement();
                            final Statement sentencia5 = con4.createStatement();
                            final ResultSet resultados3 = sentencia5.executeQuery(query4);
                            if (resultados3.next()) {
                                out.println("<br><br><br><br><br><br><h2>Error: El docente ya esta impartiendo esa materia en ese grupo</h2>");
                            }
                            else {
                                final ResultSet resultados4 = sentencia4.executeQuery(query);
                                out.println("<br><br><br><br><br><br><h2>Exito: Se le ha asignado la asignatura correctamente al docente</h2>");
                            }
                            con4.close();
                        }
                        catch (SQLException ex7) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                        out.println("<br><br><br><br><br><br>");
                        break;
                    }
                case"3":
                    out.println("<h2>Agregar Aviso</h2>");
                    out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"3.1\">" + 
"       <div class=\"form-group\">" + 
"                                   <label>Asunto</label>" + 
"                                   <textarea name=\"asunto\" placeholder=\"(Ej.Se suspenden clases\" required=\"required\" class=\"form-control\" rows=\"1\"></textarea>" + 
"                               </div><br><br>" + "<div class=\"form-group\">" + 
"                                   <label>Contenido</label>" + 
"                                   <textarea name=\"contenido\" placeholder=\"(Ej. Habr\u00e1 suspensi\u00f3n de labores en toda la zona escolar por motivo del dia del maestro)\" required=\"required\" class=\"form-control\" rows=\"10\"></textarea>" + 
"                               </div>" + "</select>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button></div>");
                    break;
                case"3.1":
                    final String asunto = request.getParameter("asunto");
                    final String contenido = request.getParameter("contenido");
                    try (final Connection con2 = DB.getConnection()) {
                        final Statement sentencia2 = con2.createStatement();
                        final String query5 ="call SubirAviso('" + asunto + "','" + contenido + "');";
                        final ResultSet resultados5 = sentencia2.executeQuery(query5);
                        out.println("<br><br><br><br><br><br>");
                        out.println("<h2>Aviso agregado con \u00e9xito</h2>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                        out.println("<br><br><br><br><br><br>");
                        con2.close();
                    }
                    catch (SQLException ex4) {
                        response.sendRedirect("Error.jsp");
                    }   break;
                case"4.21":
                    {
                        idDirector = request.getParameter("idDirector");
                        final String idAlumno = request.getParameter("idAlumno");
                        final String nombreA = request.getParameter("nombreA");
                        final String apellidoP = request.getParameter("apellidoP");
                        final String apellidoM = request.getParameter("apellidoM");
                        out.println("<h3>Alumno a reportar:" + nombreA + " " + apellidoP + " " + apellidoM + "</h3><br>");
                        out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"175\" height=\"210\"//>");
                        out.println("</div><br><br><br><br>");
                        out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS DE INDISCIPLINA LEVES</label><br>" + 
"               <select name=\"incidencia1\">" + 
"                     <option value=\"1\">Inasistencia injustificada a la escuela</option>" + 
"                     <option value=\"2\">No entrar a una clase estando en la escuela</option>" + 
"                     <option value=\"3\">Llegar tarde a la escuela o a las clases sin justificaci\u00f3n</option>" + 
"                     <option value=\"4\">Utilizar dentro de la escuela sin autorizaci\u00f3n materiales prohibidos</option>" + 
"                     <option value=\"5\">Estar en \u00e1reas que no corresponda a su actividad dentro del plantel</option>" + 
"                     <option value=\"6\">No portar la credencial escolar</option>" + 
"                     <option value=\"7\">Usar dispositivos electr\u00f3nicos de la escuela sin autorizaci\u00f3n</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"1\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS QUE PERTURBAN EL ORDEN</label><br>" + 
"               <select name=\"incidencia2\">" + 
"                     <option value=\"8\">Utilizar cerillos y/o encendedores</option>" + 
"                     <option value=\"9\">Apostar y/o participar en juegos de azar</option>" + 
"                     <option value=\"10\">Mentir, dar informaci\u00f3n falsa o enga\u00f1ar al personal escolar</option>" + 
"                     <option value=\"11\">Hacer uso de las pertenencias de otros sin autorizaci\u00f3n</option>" + 
"                     <option value=\"12\">Comportarse de una manera que perturbe el proceso educativo</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"2\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS ALTAMENTE PERTURBADORAS DEL ORDEN</label><br>" + 
"               <select name=\"incidencia3\">" + 
"                     <option value=\"13\">Salir de la clase sin permiso de alguna autoridad</option>" + 
"                     <option value=\"14\">Ingresar a clase sin permiso del docente frente a grupo</option>" + 
"                     <option value=\"15\">Asistir a la escuela con personas no autorizadas</option>" + 
"                     <option value=\"16\">Da\u00f1ar, cambiar o modificar un registro o documento escolar</option>" + 
"                     <option value=\"17\">Apropiarse de objetos que pertenecen a otra persona sin autorizaci\u00f3n</option>" + 
"                     <option value=\"18\">Violar el reglamento sobre el uso de Internet</option>" + 
"                     <option value=\"19\">Incurrir en conductas de deshonestidad acad\u00e9mica</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"3\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS QUE PROVOCAN PELIGRO</label><br>" + 
"               <select name=\"incidencia4\">" + 
"                     <option value=\"20\">Activar injustificadamente las alarmas</option>" + 
"                     <option value=\"21\">Realizar una amenaza de bomba</option>" + 
"                     <option value=\"22\">Provocar la combusti\u00f3n, detonaci\u00f3n de objetos o el riesgo de incendio</option>" + 
"                     <option value=\"23\">Realizar actos de vandalismo o da\u00f1o a los bienes de alguien o de la escuela</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"4\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS DISCRIMINATORIAS</label><br>" + 
"               <select name=\"incidencia5\">" + 
"                     <option value=\"24\">Emplear insultos relacionados con la discriminaci\u00f3n</option>" + 
"                     <option value=\"25\">Realizar actos de intimidaci\u00f3n por algun tipo de discriminaci\u00f3n</option>" + 
"                     <option value=\"26\">Tratar de infligir o causar serios da\u00f1os de cualquier tipo</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"5\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
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
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"6\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS AGRESIVA DE \u00cdNDOLE SEXUAL</label><br>" + 
"               <select name=\"incidencia7\">" + 
"                     <option value=\"40\">Emitir comentarios, insinuaciones o proposiciones con alguna sugerencia sexual</option>" + 
"                     <option value=\"41\">Realizar actos de agresi\u00f3n sexual f\u00edsica, u obligar a otros a participar de una actividad sexual</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"7\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
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
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"8\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<div class=\"col-sm-5 col-sm-offset-1\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS BLANCAS</label><br>" + 
"               <select name=\"incidencia9\">" + 
"                     <option value=\"54\">Posesi\u00f3n de un arma blanca o instrumento que ponga en riesgo a alguien</option>" + 
"                     <option value=\"55\">Utilizar cualquier tipo de arma blanca, con el fin de tratar de da\u00f1ar a alguien</option>" + 
"                     <option value=\"56\">Utilizar cualquier arma, lesionando a alguien</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"9\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<div class=\"col-sm-5\"><div class=\"form-group center\"><form name=\"formu\" action=\"Director\" method=\"POST\">" + 
"<label>CONDUCTAS DE RIESGO POR POSESI\u00d3N Y/O USO DE ARMAS DE FUEGO</label><br>" + 
"               <select name=\"incidencia10\">" + 
"                     <option value=\"57\">Poseer cualquier tipo de arma de fuego</option>" + 
"                     <option value=\"58\">Utilizar cualquier arma de fuego con el fin de tratar de causar lesiones</option>" + 
"                     <option value=\"59\">Utilizar cualquier arma de fuego lesionando a alguien</option>" + 
"               </select><br>               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Mala\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.3\">" + 
"                      <input type=\"hidden\" name=\"opc2\" id=\"opc2\" value=\"10\">" + 
"                      <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Informe</button></form></div></div>");
                        out.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"4.3":
                    {
                        final String idAlumno = request.getParameter("idAlumno");
                        idDirector = request.getParameter("idDirector");
                        String incidencia ="";
                        final String parameter;
                        final String opc2 = parameter = request.getParameter("opc2");
                        switch (parameter) {
                            case"1": {
                                incidencia = request.getParameter("incidencia1");
                                break;
                            }
                            case"2": {
                                incidencia = request.getParameter("incidencia2");
                                break;
                            }
                            case"3": {
                                incidencia = request.getParameter("incidencia3");
                                break;
                            }
                            case"4": {
                                incidencia = request.getParameter("incidencia4");
                                break;
                            }
                            case"5": {
                                incidencia = request.getParameter("incidencia5");
                                break;
                            }
                            case"6": {
                                incidencia = request.getParameter("incidencia6");
                                break;
                            }
                            case"7": {
                                incidencia = request.getParameter("incidencia7");
                                break;
                            }
                            case"8": {
                                incidencia = request.getParameter("incidencia8");
                                break;
                            }
                            case"9": {
                                incidencia = request.getParameter("incidencia9");
                                break;
                            }
                            case"10": {
                                incidencia = request.getParameter("incidencia10");
                                break;
                            }
                        }       final String query6 ="call AgregarIncidencia(" + idAlumno + "," + idDirector + ",'" + incidencia + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                        try (final Connection con5 = DB.getConnection()) {
                            final Statement sentencia6 = con5.createStatement();
                            final ResultSet resultados6 = sentencia6.executeQuery(query6);
                            out.println("<div class=\"form-group center\"><h3>Informe ingresado a la base de datos correctamente</h3></div><br>");
                            con5.close();
                        }
                        catch (SQLException ex8) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"4.4":
                    {
                        idDirector = request.getParameter("idDirector");
                        final String idPersona = request.getParameter("idPersona");
                        final String nombreA = request.getParameter("nombreA");
                        final String apellidoP = request.getParameter("apellidoP");
                        final String apellidoM = request.getParameter("apellidoM");
                        out.println("<br><br><br><br>");
                        out.println("<h3>Usuario a reportar:" + nombreA + " " + apellidoP + " " + apellidoM + "</h3><br>");
                        out.println("<br><br><br>");
                        out.println("<form action=\"Director\" method=\"POST\">" + 
"<label>Incidencia Suprema</label><br>" + 
"<textarea name=\"incidencia\" placeholder=\"(Ej.Maestro falto sin autorizacion mia y descuido a 3 grupos #NoSeVale)\" required=\"required\" class=\"form-control\" rows=\"8\"></textarea>" + 
"               <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                      <input type=\"hidden\" name=\"tipo\" value=\"Buena\">" + 
"                      <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                      <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"                      <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"4.5\">" + 
"                      <br><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Meter Reporte</button>");
                        out.println("<br><br><br><br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"4.5":
                    {
                        final String idPersona = request.getParameter("idPersona");
                        idDirector = request.getParameter("idDirector");
                        final String incidencia = request.getParameter("incidencia");
                        final String query7 ="call AgregarIncidenciaSuprema(" + idPersona + "," + idDirector + ",'" + incidencia + "','" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                        try (final Connection con6 = DB.getConnection()) {
                            final Statement sentencia7 = con6.createStatement();
                            final ResultSet resultados5 = sentencia7.executeQuery(query7);
                            out.println("<div class=\"form-group center\"><h3>Informe ingresado a la base de datos correctamente</h3></div><br>");
                            con6.close();
                        }
                        catch (SQLException ex9) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><br><br>");
                        out.println("<div class=\"form-group center\">" + 
"                            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        break;
                    }
                case"5":
                    final String buscado = request.getParameter("buscado");
                    out.println("<br><label>Buscar por nombre</label><br>");
                    if (buscado == null) {
                        out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"text\" name=\"buscado\" onblur=\"submit()\" placeholder=\"Nombre de persona :D\">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5\"><br><br>");
                        out.println("</form><br>");
                    }
                    else {
                        out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"text\" name=\"buscado\" onblur=\"submit()\" value=" + buscado + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5\"><br><br>");
                        out.println("</form><h3>Para ver los datos de una persona solo toca su nombre :)</h3>");
                        final String query2 ="call BuscarPersona('^" + buscado + "');";
                        try (final Connection con2 = DB.getConnection()) {
                            final Statement sentencia2 = con2.createStatement();
                            final ResultSet resultados = sentencia2.executeQuery(query2);
                            int i = 0;
                            while (resultados.next()) {
                                ++i;
                                final String js ="Redirigir5(" + i + ");";
                                final String formu ="red" + i;
                                if (resultados.getInt("idTipo") == 1) {
                                    out.println("<form action=\"Director\" method=\"POST\" name=" + formu + " id=" + formu + ">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.3\">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + resultados.getString("idPersona") + ">" + 
"       <br>");
                                    out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Alumno\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                    out.println("</a></p></form>");
                                }
                                else {
                                    if (resultados.getInt("idTipo") > 5) {
                                        continue;
                                    }
                                    out.println("<form action=\"Director\" method=\"POST\" name=" + formu + " id=" + formu + ">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.4\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + resultados.getString("idPersona") + ">" + 
"                           <input type=\"hidden\" name=\"idTipo\" value=" + resultados.getString("idTipo") + ">" + 
"       <br>");
                                    out.println("<p onclick=" + js + "><a target=\"_blank\" title=\"Ver datos Persona\">" + resultados.getString("Nombre") + " " + resultados.getString("Apaterno") + " " + resultados.getString("Amaterno") + " <strong>" + resultados.getString("Persona") + "</strong>");
                                    out.println("</a></p></form>");
                                }
                            }
                            con2.close();
                        }
                        catch (SQLException ex4) {
                            response.sendRedirect("Error.jsp");
                        }
                    }   out.println("<br><br><br><h2>¿Que tipo de usuario estas buscando?</h2>");
                    out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.1\">" + 
"                           <select name=\"tipo\">" + 
"       <option value=\"1\">Alumno</option>" + "<option value=\"2\">Docente</option>" + "<option value=\"3\">Apoyo</option>" + "<option value=\"4\">M\u00e9dico</option>" + "<option value=\"5\">Administrativo</option>" + "</select><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" onclick=\"submit();\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                    out.println("<br><br><br><br></div>");
                    break;
                case"5.1":
                    {
                        idDirector = request.getParameter("idDirector");
                        final int tipo2 = Integer.parseInt(request.getParameter("tipo"));
                        String u ="";
                        String s ="";
                        int j = 1;
                        if (tipo2 >= 2) {
                            switch (tipo2) {
                                case 2: {
                                    u ="Docentes";
                                    s ="Docente";
                                    break;
                                }
                                case 3: {
                                    u ="Apoyos";
                                    s ="Apoyo";
                                    break;
                                }
                                case 4: {
                                    u ="Doctores";
                                    s ="Doctor";
                                    break;
                                }
                                case 5: {
                                    u ="Administrativos";
                                    s ="Administrativo";
                                    break;
                                }
                                default: {
                                    response.sendRedirect("Error.jsp");
                                    break;
                                }
                            }
                            final ArrayList<String> Personas = (ArrayList<String>)Funcion.VerPersonas(u);
                            out.println("<h2>" + u + " registrados en el sistema</h2><br>");
                            out.println("<table border=1 style=text-align:center;><tr>" + 
"<th>#</th>" + 
"<th>" + s + "</td>" + 
"       <th>Consultar</th>" + 
"       </tr>" + 
"");
                            for (int x = 0; Personas.size() > x; x += 4) {
                                out.println("<tr><td>" + j + "</td><td>" + Personas.get(x + 1) + " " + Personas.get(x + 2) + " " + Personas.get(x) + "</td>");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"u\" value=" + u + ">" + 
"                           <input type=\"hidden\" name=\"s\" value=" + s + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.4\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Consultar</button></form></th>" + 
"");
                                out.println("</tr>");
                                ++j;
                            }
                            out.println("</table>");
                            out.println("<br><br><br><br>");
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                        }
                        else if (tipo2 == 1) {
                            out.println("<br><br><br><h2>¿De que grupo es el alumno?</h2>");
                            out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.2\">" + 
"       <label>A\u00f1o</label>" + 
"                           <select name=\"ano\">" + 
"       <option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>" + 
"                    <select name=\"grupo\">" + 
"<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                            out.println("</select><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                            out.println("<br><br><br><br>");
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                            out.println("<br><br><br><br></div>");
                        }
                        else {
                            response.sendRedirect("Error.jsp");
                        }       break;
                    }
                case"5.2":
                    idDirector = request.getParameter("idDirector");
                    final String ano4 = request.getParameter("ano");
                    final String grupo4 = request.getParameter("grupo");
                    int k = 1;
                    final ArrayList<String> Alumnos = (ArrayList<String>)Funcion.VerGrupo(ano4, grupo4);
                    out.println("<h2>Alumnos del grupo" + ano4 + "º" + grupo4 + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr>" + 
"<th>#</th>" + 
"<th>Alumno</td>" + 
"<th>Consultar</th>" + 
"</tr>" + 
"");
                    for (int x2 = 0; Alumnos.size() > x2; x2 += 4) {
                        out.println("<tr><td>" + k + "</td><td>" + Alumnos.get(x2 + 1) + " " + Alumnos.get(x2 + 2) + " " + Alumnos.get(x2) + "</td>");
                        out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos.get(x2 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos.get(x2) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos.get(x2 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos.get(x2 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.3\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"submit()\">Consultar</button></form></th>" + 
"");
                        out.println("</tr>");
                        ++k;
                    }   out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div>");
                    break;
                case"5.3":
                    {
                        final String idAlumno = request.getParameter("idAlumno");
                        try (final Connection con = DB.getConnection()) {
                            final Statement sentencia = con.createStatement();
                            final String query ="call VerDatos(" + idAlumno + ");";
                            final ResultSet resultados = sentencia.executeQuery(query);
                            final Statement sentencia8 = con.createStatement();
                            final String query8 ="call VerIncidenciasAlumnoId(" + idAlumno + ");";
                            final ResultSet resultados7 = sentencia8.executeQuery(query8);
                            out.println("</div><div class=\"col-sm-5 col-sm-offset-1\"><h2>Datos Personales</h2><br>");
                            String nombreA2;
                            String apellidoP2;
                            String apellidoM2;
                            String curp3;
                            if (resultados.next()) {
                                nombreA2 = resultados.getString("Nombre");
                                apellidoP2 = resultados.getString("Apaterno");
                                apellidoM2 = resultados.getString("Amaterno");
                                curp3 = resultados.getString("Curp");
                                out.println("<h3>Nombre:" + nombreA2 + "<br>Apellido Paterno:" + apellidoP2 + "<br>Apellido Materno:" + apellidoM2 + "<br>Comentario sobre el alumno:" + resultados.getString("DatosExtraAlumno.Comentario") + "<br>Grupo:" + resultados.getString("Ano") + "°" + resultados.getString("Grupo") + "<br>CURP:" + curp3 + "<br>Nacimiento:" + resultados.getString("Nacimiento") + "<br>" + "<br>Usuario:" + resultados.getString("Usuario") + "<br>Constrase\u00f1a:" + resultados.getString("Pass") + "<br>" + "<br>Parentesco del tutor:" + resultados.getString("DatosExtraAlumno.Parentesco") + "<br>Nombre Tutor:" + resultados.getString("d1.Nombre") + "<br>Apellido Paterno Tutor:" + resultados.getString("d1.Apaterno") + "<br>Apellido Materno Tutor:" + resultados.getString("d1.Amaterno") + "<br>Celular Tutor:" + resultados.getString("d1.Celular") + "<br>Telefono del trabajo:" + resultados.getString("d1.Celular") + "</h3>");
                                out.println("</div>");
                                out.println("<div class=\"col-sm-5\">");
                                out.println("<img src=\"F?idAlumno=" + idAlumno + "\" width=\"215\" height=\"258\"//>");
                                out.println("</div><br><br><br><br><br><br><br><br><br>");
                                out.println("<form method=\"post\"><input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"opc\" value=\"5.6\">" + "<input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"nombreA\" value=" + nombreA2 + ">" + "<input type=\"hidden\" name=\"Apaterno\" value=" + apellidoP2 + ">" + "<input type=\"hidden\" name=\"Amaterno\" value=" + apellidoM2 + ">" + "<input type=\"hidden\" name=\"idPersona\" value=" + idAlumno + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" onclick=\"submit()\" style=\"background-color: #008000\">Ver Situaciones</button>" + "</form><br>");
                                out.println("<form method=\"post\"><input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"opc\" value=\"2.3\">" + "<input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" onclick=\"submit()\" style=\"background-color: #B8860B\">Modificar Datos</button>" + "</form><br>");
                                out.println("<form method=\"post\"><input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"opc\" value=\"4.21\">" + "<input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno + ">" + "<input type=\"hidden\" name=\"nombreA\" value=" + nombreA2 + ">" + "<input type=\"hidden\" name=\"apellidoP\" value=" + apellidoP2 + ">" + "<input type=\"hidden\" name=\"apellidoM\" value=" + apellidoM2 + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #EE2222\" onclick=\"submit()\">Agregar Incidencia</button>" + "</form><br><p id=\"pw\" hidden=\"true\">" + curp3 + "</p>");
                                out.println("<a onclick=\"copiarAlPortapapeles('pw');\" target=\"_blank\" href=\"http://comunidadescolar.sepdf.gob.mx:8024/ConsultaCalificaciones/index.jsp\" class=\"btn btn-primary btn-lg\" style=\"background-color: #1E90FF\" onclick=\"copiarAlPortapapeles('pw');\">Calificaciones</a>" + 
"");
                            }
                            out.println("<br><br><br><br><br><br><br><div class=\"form-group center\"><h2>Incidencias</h2><br>");
                            if (resultados7.next()) {
                                out.println("<strong>" + resultados7.getString("TipoIncidencia") + "</strong><br><h3>" + resultados7.getString("Incidencia") + "<br><br> Ocurrida el" + resultados7.getString("Fecha") + "<br>Reportada por" + resultados7.getString("Nombre del reportador") + " " + resultados7.getString("Apellido del reportador") + "<br><hr><br></h3>");
                            }
                            else {
                                out.println("<br><br><strong>Este alumno no tiene ninguna incidencia :D</strong><br><br>");
                            }
                            while (resultados7.next()) {
                                out.println("<strong>" + resultados7.getString("TipoIncidencia") + "</strong><br><h3>" + resultados7.getString("Incidencia") + "<br><br> Ocurrida el" + resultados7.getString("Fecha") + "<br>Reportada por" + resultados7.getString("Nombre del reportador") + " " + resultados7.getString("Apellido del reportador") + "<br><hr><br></h3>");
                            }
                            con.close();
                        }
                        catch (SQLException ex2) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><form name=\"formu\" action=\"Director.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br>");
                        out.println("</div>");
                        break;
                    }
                case"5.4":
                    {
                        String idPersona = request.getParameter("idPersona");
                        String idTipo ="";
                        try (final Connection con2 = DB.getConnection()) {
                            final Statement sentencia2 = con2.createStatement();
                            final String query5 ="call VerDatos(" + idPersona + ");";
                            final ResultSet resultados5 = sentencia2.executeQuery(query5);
                            final Statement sentencia9 = con2.createStatement();
                            final String query9 ="call VerIncidenciasAlumnoId(" + idPersona + ");";
                            final ResultSet resultados8 = sentencia9.executeQuery(query9);
                            out.println("</div><div class=\"col-sm-5 col-sm-offset-1\"><h2>Datos Personales</h2><br>");
                            String nombreA3 ="";
                            String Apaterno2 ="";
                            String Amaterno2 ="";
                            if (resultados5.next()) {
                                nombreA3 = resultados5.getString("Nombre");
                                Apaterno2 = resultados5.getString("Apaterno");
                                Amaterno2 = resultados5.getString("Amaterno");
                                out.println("<h3>Nombre:" + nombreA3 + "<br>Apellido Paterno:" + Apaterno2 + "<br>Apellido Materno:" + Amaterno2 + "<br>Nacimiento:" + resultados5.getString("Nacimiento") + "<br>CURP:" + resultados5.getString("Curp") + "<br>Celular:" + resultados5.getString("Celular") + "<br>Tel\u00e9fono:" + resultados5.getString("Telefono") + "</h3>");
                                idTipo = resultados5.getString("idTipo");
                                if (!idTipo.equals("2")) {
                                    out.println("</div><br>");
                                    out.println("<div class=\"col-sm-5\">");
                                }
                                out.println("<br><form name=\"formu\" action=\"Director\" method=\"post\">                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + nombreA3 + ">" + 
"                           <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno2 + ">" + 
"                           <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno2 + ">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"       <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.6\">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\" style=\"background-color: #008000\">Ver Situaciones</button>" + "</form><br>");
                                out.println("<form method=\"post\"><input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + "<input type=\"hidden\" name=\"opc\" value=\"2.5\">" + "<input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"\" value=\"usuario\">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" onclick=\"submit()\" style=\"background-color: #B8860B\">Modificar Datos</button>" + "</form><br>");
                                out.println("<form method=\"post\"><input type=\"hidden\" name=\"opc\" value=\"4.4\"><input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + "<input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + "<input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + "<input type=\"hidden\" name=\"nombreA\" value=" + nombreA3 + ">" + "<input type=\"hidden\" name=\"apellidoP\" value=" + Apaterno2 + ">" + "<input type=\"hidden\" name=\"apellidoM\" value=" + Amaterno2 + ">" + "<button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #EE2222\" onclick=\"submit()\">Agregar Incidencia</button>" + "</form><br>");
                                if (!idTipo.equals("2")) {
                                    out.println("</div>");
                                }
                            }
                            out.println("</div><br>");
                            out.println("<div class=\"col-sm-5\">");
                            if (idTipo.equals("2")) {
                                final Statement sentencia10 = con2.createStatement();
                                final String query10 ="call PromedioCalificaciones1(" + idPersona + ");";
                                final ResultSet resultados9 = sentencia10.executeQuery(query10);
                                int Claridad = 0;
                                int Ayuda = 0;
                                int Facilidad = 0;
                                int Recomendado = 0;
                                int Alumnos2 = 1;
                                if (resultados9.next()) {
                                    Claridad = resultados9.getInt("Claridad") * 20;
                                    Ayuda = resultados9.getInt("Ayuda") * 20;
                                    Facilidad = resultados9.getInt("Facilidad") * 20;
                                    Alumnos2 = resultados9.getInt("Alumnos");
                                    if (Alumnos2 == 0) {
                                        Alumnos2 = 1;
                                    }
                                }
                                final Statement sentencia11 = con2.createStatement();
                                final String query11 ="call PromedioRecomendado1(" + idPersona + ");";
                                final ResultSet resultados10 = sentencia11.executeQuery(query11);
                                if (resultados10.next()) {
                                    Recomendado = resultados10.getInt("Reco") * 100 / Alumnos2;
                                }
                                out.println("<div class=\"center\"><h2><span style=\"color:#00FF7C\">&#9733;</span><span style=\"color:#8B0000\">P</span><span style=\"color:#FF8C00\">u</span><span style=\"color:#32CD32\">n</span><span style=\"color:#00BFFF\">t</span><span style=\"color:#8B0000\">u</span><span style=\"color:#FF8C00\">a</span><span style=\"color:#32CD32\">c</span><span style=\"color:#00BFFF\">i</span><span style=\"color:#8B0000\">o</span><span style=\"color:#FF8C00\">n</span><span style=\"color:#32CD32\">e</span><span style=\"color:#00BFFF\">s</span><span style=\"color:#00FF7C\">&#9733;</span></h2><FONT SIZE=\"3\">");
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
                                out.println("<br>Lo recomiendan el");
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
                                idPersona = resultados5.getString("idPersona");
                                out.println("<form name=\"formu\" action=\"Director\" method=\"post\">                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + nombreA3 + ">" + 
"                           <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno2 + ">" + 
"                           <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno2 + ">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"       <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"5.5\">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\" style=\"background-color: #4B0082\">Ver Comentarios</button>" + "</form></div><br>");
                            }
                            out.println("</div><br><br><br><br><br><br><br>");
                            out.println("<br><br><br><br><br><br><br><br><br><div class=\"center\"><h2>Incidencias</h2><br>");
                            if (resultados8.next()) {
                                out.println("<strong>" + resultados8.getString("TipoIncidencia") + "</strong><br><h3>" + resultados8.getString("Incidencia") + "<br><br> Ocurrida el" + resultados8.getString("Fecha") + "<br>Reportada por" + resultados8.getString("Nombre del reportador") + " " + resultados8.getString("Apellido del reportador") + "<br><hr><br></h3>");
                            }
                            else {
                                out.println("<br><br><strong>Este usuario no tiene ninguna incidencia :D</strong><br><br>");
                            }
                            while (resultados8.next()) {
                                out.println("<strong>" + resultados8.getString("TipoIncidencia") + "</strong><br><h3>" + resultados8.getString("Incidencia") + "<br><br> Ocurrida el" + resultados8.getString("Fecha") + "<br>Reportada por" + resultados8.getString("Nombre del reportador") + " " + resultados8.getString("Apellido del reportador") + "<br><hr><br></h3>");
                            }
                            con2.close();
                        }
                        catch (SQLException ex4) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><form name=\"formu\" action=\"Director.jsp\" method=\"post\">     <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button></form><br>");
                        out.println("</div>");
                        break;
                    }
                case"5.5":
                    {
                        response.setContentType("text/html;charset=UTF-8");
                        response.setCharacterEncoding("UTF-8");
                        request.setCharacterEncoding("UTF-8");
                        final String idDocente = request.getParameter("idPersona");
                        final String nombreA = request.getParameter("nombreA");
                        final String Apaterno3 = request.getParameter("Apaterno");
                        final String Amaterno3 = request.getParameter("Amaterno");
                        try (final Connection con5 = DB.getConnection()) {
                            final Statement sentencia6 = con5.createStatement();
                            final String query12 ="call VerComentarios(" + idDocente + ");";
                            final ResultSet resultados11 = sentencia6.executeQuery(query12);
                            out.println("<h2>Comentarios sobre" + nombreA + " " + Apaterno3 + " " + Amaterno3 + "</h2><br><hr><br>");
                            while (resultados11.next()) {
                                out.println("<strong>" + resultados11.getString("Comentario") + "</strong><br>" + "Comentado por" + resultados11.getString("Nombre") + " " + resultados11.getString("Apaterno") + " " + resultados11.getString("Amaterno") + " del grupo" + resultados11.getString("Ano") + "°" + resultados11.getString("Grupo") + "<br><hr><br>");
                            }
                            con5.close();
                        }
                        catch (SQLException ex8) {
                            response.sendRedirect("Error.jsp");
                        }       out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"5.4\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idPersona\" value=" + idDocente + ">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button>" + "</form><br></div>");
                        break;
                    }
                case"5.6":
                    {
                        final String idPersona = request.getParameter("idPersona");
                        final String nombreA = request.getParameter("nombreA");
                        final String Apaterno3 = request.getParameter("Apaterno");
                        final String Amaterno3 = request.getParameter("Amaterno");
                        final String idAlumno3 = request.getParameter("idAlumno");
                        final ArrayList<String> Situaciones = (ArrayList<String>)Funcion.VerSituaciones(idPersona);
                        int x3 = 0;
                        out.println("<br><br><br><h2>Situaciones sobre" + nombreA + " " + Apaterno3 + " " + Amaterno3 + "</h2><br><br><br>");
                        try (final Connection con7 = DB.getConnection()) {
                            final Statement sentencia12 = con7.createStatement();
                            final String query13 ="call TotalSituaciones(" + idPersona + ");";
                            final ResultSet resultados4 = sentencia12.executeQuery(query13);
                            while (resultados4.next()) {
                                out.println("<h3>Total de <strong>" + resultados4.getString("Situacion") + "</strong>:" + resultados4.getString("Total") + "</h3><br>");
                            }
                            con7.close();
                            out.println("<br><br><br><hr>");
                        }
                        catch (SQLException ex10) {
                            response.sendRedirect("Error.jsp");
                        }       if (Situaciones.size() > x3) {
                            out.println("<strong>" + Situaciones.get(x3) + "</strong><br>" + "Fecha:" + Situaciones.get(x3 + 1));
                            out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"5.7\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"              <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno3 + ">" + 
"              <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">" + 
"              <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno3 + ">" + 
"              <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno3 + ">" + 
"              <input type=\"hidden\" name=\"idSituacion\" value=" + Situaciones.get(x3 + 2) + ">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Eliminar</button>" + "</form><br><hr><br>");
                            x3 += 3;
                        }
                        else {
                            out.println("<br><br><br><br><br><strong>Este usuario no tiene ninguna reporte de faltas o impuntualidad :D</strong><br><br><br><br><br>");
                        }       while (Situaciones.size() > x3) {
                            out.println("<strong>" + Situaciones.get(x3) + "</strong><br>" + "Fecha:" + Situaciones.get(x3 + 1));
                            out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"5.7\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"              <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno3 + ">" + 
"              <input type=\"hidden\" name=\"nombreA\" value=" + nombreA + ">" + 
"              <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno3 + ">" + 
"              <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno3 + ">" + 
"              <input type=\"hidden\" name=\"idSituacion\" value=" + Situaciones.get(x3 + 2) + ">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Eliminar</button>" + "</form><br><hr><br>");
                            x3 += 3;
                        }       if (idAlumno3 == null) {
                            out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"5.4\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button>" + "</form><br></div>");
                        }
                        else {
                            out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\">       <input type=\"hidden\" name=\"opc\" value=\"5.3\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno3 + ">" + 
"            <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Volver</button>" + "</form><br></div>");
                        }       break;
                    }
                case"5.7":
                    {
                        final String idPersona = request.getParameter("idPersona");
                        final String idAlumno4 = request.getParameter("idAlumno");
                        final String nombreA4 = request.getParameter("nombreA");
                        final String Apaterno4 = request.getParameter("Apaterno");
                        final String Amaterno4 = request.getParameter("Amaterno");
                        final String idSituacion = request.getParameter("idSituacion");
                        final String query14 ="call EliminarSituacion(" + idSituacion + ");";
                        try (final Connection con7 = DB.getConnection()) {
                            final Statement sentencia12 = con7.createStatement();
                            final ResultSet resultados12 = sentencia12.executeQuery(query14);
                            con7.close();
                            out.println("<br><br><form name=\"formu\" action=\"Director\" method=\"post\" name=\"red\" id=\"red\">       <input type=\"hidden\" name=\"opc\" value=\"5.6\">" + 
"       <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"              <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"              <input type=\"hidden\" name=\"idPersona\" value=" + idPersona + ">" + 
"              <input type=\"hidden\" name=\"idAlumno\" value=" + idAlumno4 + ">" + 
"              <input type=\"hidden\" name=\"nombreA\" value=" + nombreA4 + ">" + 
"              <input type=\"hidden\" name=\"Apaterno\" value=" + Apaterno4 + ">" + 
"              <input type=\"hidden\" name=\"Amaterno\" value=" + Amaterno4 + ">" + 
"       <script>Redirigir6();</script> </form><br></div>");
                        }
                        catch (SQLException ex10) {
                            response.sendRedirect("Error.jsp");
                        }       break;
                    }
                case"6":
                    out.println("<br><br><br><br><br><h2>Tipo de usuario al que agregaras un reporte de puntualidad y asistencia</h2>");
                    out.println("<br><br><br><br><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.1\">" + 
"                           <select name=\"tipo\">" + 
"       <option value=\"1\">Alumno</option>" + "<option value=\"2\">Docente</option>" + "<option value=\"3\">Apoyo</option>" + "<option value=\"4\">Doctor</option>" + "<option value=\"5\">Administrativo</option>" + "</select><br><br>");
                    out.println("<br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                    out.println("<br><br><br><br><br><br></div>");
                    break;
                case"6.1":
                    {
                        idDirector = request.getParameter("idDirector");
                        final int tipo2 = Integer.parseInt(request.getParameter("tipo"));
                        String u ="";
                        String s ="";
                        int j = 1;
                        if (tipo2 >= 2) {
                            switch (tipo2) {
                                case 2: {
                                    u ="Docentes";
                                    s ="Docente";
                                    break;
                                }
                                case 3: {
                                    u ="Apoyos";
                                    s ="Apoyo";
                                    break;
                                }
                                case 4: {
                                    u ="Doctores";
                                    s ="Doctor";
                                    break;
                                }
                                case 5: {
                                    u ="Administrativos";
                                    s ="Administrativo";
                                    break;
                                }
                                default: {
                                    response.sendRedirect("Error.jsp");
                                    break;
                                }
                            }
                            final ArrayList<String> Personas = (ArrayList<String>)Funcion.VerPersonas(u);
                            final String locate = request.getParameter("locate");
                            out.println("<script>location.href='#" + locate + "'</script>");
                            out.println("<h2>" + u + " registrados en el sistema</h2><br>");
                            out.println("<table border=4 style=text-align:center;><tr><th></th><th></th><th colspan=\"3\" style=text-align:center;>Retardo</th><th colspan=\"3\" style=text-align:center;>Falta</th></tr><tr>" + 
"<th>#</th>" + 
"<th ALIGN=CENTER>" + s + "</td>" + 
"       <th ALIGN=CENTER>Tolerado (-10)</th>" + 
"       <th ALIGN=CENTER>Leve (+10)</th>" + 
"       <th ALIGN=CENTER>Grave (+20)</th>" + 
"       <th ALIGN=CENTER>Injustificada</th>" + 
"       <th ALIGN=CENTER>D\u00eda Econ\u00f3mico</th>" + 
"       <th ALIGN=CENTER>Licencia M\u00e9dica</th>" + 
"       </tr>" + 
"");
                            for (int x3 = 0; Personas.size() > x3; x3 += 4) {
                                out.println("<tr><td>" + j + "</td><td>" + Personas.get(x3 + 1) + " " + Personas.get(x3 + 2) + " " + Personas.get(x3) + "</td>");
                                out.println("<th id=\"" + j + "\"><form action=\"Director\" method=\"POST\">" + 
"                           <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"2\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Tolerado\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FFD700\" onClick=\"submit()\">Tolerado</button></form></th>" + 
"");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"3\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Leve\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FFA500\" onClick=\"submit()\">Leve</button></form></th>" + 
"");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"4\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Grave\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF4500\" onClick=\"submit()\">Grave</button></form></th>" + 
"");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"1\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Falta Injustificada\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF0000\" onClick=\"submit()\">Injustificada</button></form></th>" + 
"");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"5\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"D\u00eda Econ\u00f3mico\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #8A2BE2\" onClick=\"submit()\">D\u00eda Econ\u00f3mico</button></form></th>" + 
"");
                                out.println("<th><form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo2 + ">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"6\">" + 
"                           <input type=\"hidden\" name=\"idPersona\" value=" + Personas.get(x3 + 3) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Personas.get(x3) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Personas.get(x3 + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Personas.get(x3 + 2) + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + j + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Licencia M\u00e9dica\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #32CD32\" onClick=\"submit()\">Licencia M\u00e9dica</button></form></th>" + 
"");
                                out.println("</tr>");
                                ++j;
                            }
                            out.println("</table>");
                            out.println("<br><br><br><br>");
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>                        </div>");
                        }
                        else {
                            out.println("<br><br><br><br><br><h2>¿De que grupo es el alumno?</h2><br><br><br><br>");
                            out.println("<form action=\"Director\" method=\"POST\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.11\">" + 
"       <label>A\u00f1o</label>" + 
"                           <select name=\"ano\">" + 
"       <option value=\"1\">1º</option>" + "<option value=\"2\">2º</option>" + "<option value=\"3\">3º</option>" + "</select>");
                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Grupo</label>" + 
"                    <select name=\"grupo\">" + 
"<option value=\"A\">A</option><option value=\"B\">B</option><option value=\"C\">C</option><option value=\"D\">D</option><option value=\"E\">E</option></select><br><br>");
                            out.println("</select><br><br><button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onclick=\"submit()\">Aceptar</button></form><br>");
                            out.println("<br><br><br><br><br><br>");
                            out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>");
                            out.println("<br><br><br><br><br><br></div>");
                        }       break;
                    }
                case"6.11":
                    int l = 1;
                    idDirector = request.getParameter("idDirector");
                    final String ano5 = request.getParameter("ano");
                    final String grupo5 = request.getParameter("grupo");
                    final String locate2 = request.getParameter("locate");
                    final ArrayList<String> Alumnos3 = (ArrayList<String>)Funcion.VerGrupo(ano5, grupo5);
                    out.println("<script>location.href='#" + locate2 + "'</script>");
                    out.println("<h2>Alumnos del grupo" + ano5 + "º" + grupo5 + "</h2><br>");
                    out.println("<table border=1 style=text-align:center;><tr><th></th><th></th><th colspan=\"2\" style=text-align:center;>Retardo</th><th colspan=\"2\" style=text-align:center;>Falta</th><th colspan=\"2\" style=text-align:center;>Entrada</th></tr><tr>" + 
"<th>#</th>" + 
"<th>Alumno</td>" + 
"<th>Leve</th>" + 
"<th>Grave</th>" + 
"<th>Injustificada</th>" + 
"<th>Justificada</th>" + 
"<th>Sin Credencial</th>" + 
"<th>Extempor\u00e1nea</th>" + 
"<th>Retiro Anticipado</th>" + 
"</tr>" + 
"");
                    for (int x = 0; Alumnos3.size() > x; x += 4) {
                        out.println("<tr id=\"" + l + "\"><td>" + l + "</td><td>" + Alumnos3.get(x + 1) + " " + Alumnos3.get(x + 2) + " " + Alumnos3.get(x) + "</td>");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"2\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Leve\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" style=\"background-color: #FFA500\" onClick=\"submit()\">Leve</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"3\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retardo Grave\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF4500\" required=\"required\" onClick=\"submit()\">Grave</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"1\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Falta Injustificada\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #FF0000\" required=\"required\" onClick=\"submit()\">Injustificada</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"9\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Falta con Justificante\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #DC143C\" required=\"required\" onClick=\"submit()\">Justificada</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"7\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Asistencia Sin Credencial\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #4B0082\" required=\"required\" onClick=\"submit()\">Sin Credencial</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"8\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Entrada Extempor\u00e1nea Autorizada\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #0000CD\" required=\"required\" onClick=\"submit()\">Extempor\u00e1nea</button></form></th>" + 
"");
                        out.println("<th><form action=\"Director\" method=\"POST\" name=\"formu\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano5 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo5 + ">" + 
"                           <input type=\"hidden\" name=\"idAlumno\" value=" + Alumnos3.get(x + 3) + ">" + 
"                           <input type=\"hidden\" name=\"nombreA\" value=" + Alumnos3.get(x) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoP\" value=" + Alumnos3.get(x + 1) + ">" + 
"                           <input type=\"hidden\" name=\"apellidoM\" value=" + Alumnos3.get(x + 2) + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.2\">" + 
"                           <input type=\"hidden\" name=\"idSituacion\" value=\"10\">" + 
"                           <input type=\"hidden\" name=\"locate\" value=\"" + l + "\">" + 
"                           <input type=\"hidden\" name=\"Situacion\" value=\"Retiro Anticipado\">" + 
"                           <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"background-color: #2F4F4F\" required=\"required\" onClick=\"submit()\">Retiro Anticipado</button></form></th>" + 
"");
                        out.println("</tr>");
                        ++l;
                    }   out.println("</table>");
                    out.println("<br><br><br><br>");
                    out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        <br><br><br></div>");
                    break;
                case"6.2":
                    {
                        idDirector = request.getParameter("idDirector");
                        final String idAlumno = request.getParameter("idAlumno");
                        String idPersona3 = request.getParameter("idPersona");
                        final String idSituacion2 = request.getParameter("idSituacion");
                        final String tipo3 = request.getParameter("tipo");
                        final String ano6 = request.getParameter("ano");
                        final String grupo6 = request.getParameter("grupo");
                        final String nombreA5 = request.getParameter("nombreA");
                        final String apellidoP3 = request.getParameter("apellidoP");
                        final String apellidoM3 = request.getParameter("apellidoM");
                        final String Situacion = request.getParameter("Situacion");
                        final String locate3 = request.getParameter("locate");
                        if (idAlumno != null) {
                            idPersona3 = idAlumno;
                        }       final String query15 ="call AgregarSituacion(" + idPersona3 + "," + idDirector + "," + idSituacion2 + ",'" + anoActual + "-" + mesActual + "-" + diaActual + "');";
                        try (final Connection con8 = DB.getConnection()) {
                            final Statement sentencia13 = con8.createStatement();
                            final ResultSet resultados13 = sentencia13.executeQuery(query15);
                            con8.close();
                        }
                        catch (SQLException ex11) {
                            response.sendRedirect("Error.jsp");
                        }       if (idAlumno == null) {
                            out.println("<form action=\"Director\" method=\"POST\" name=\"red\" id=\"red\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.1\">" + 
"                           <input type=\"hidden\" name=\"tipo\" value=" + tipo3 + ">" + 
"                           <input type=\"hidden\" name=\"locate\" value=" + locate3 + ">" + "                    <script>Situacion('" + Situacion + "','" + apellidoP3 + "','" + apellidoM3 + "','" + nombreA5 + "');</script>");
                        }
                        else {
                            out.println("<form action=\"Director\" method=\"POST\" name=\"red\" id=\"red\">" + 
"                    <input type=\"hidden\" name=\"idDirector\" value=" + idDirector + ">" + 
"                           <input type=\"hidden\" name=\"nombre\" value=" + nombre + ">" + 
"                           <input type=\"hidden\" name=\"opc\" id=\"opc\" value=\"6.11\">" + 
"                           <input type=\"hidden\" name=\"ano\" value=" + ano6 + ">" + 
"                           <input type=\"hidden\" name=\"grupo\" value=" + grupo6 + ">" + "                    <input type=\"hidden\" name=\"locate\" value=" + locate3 + ">" + "                    <script>Situacion('" + Situacion + "','" + apellidoP3 + "','" + apellidoM3 + "','" + nombreA5 + "');</script>");
                        }       break;
                    }
                case"7":
                    try (final Connection con9 = DB.getConnection()) {
                        final Statement sentencia14 = con9.createStatement();
                        final String query6 ="call VerDenuncias();";
                        final ResultSet resultados14 = sentencia14.executeQuery(query6);
                        out.println("<br><br><br><br><h2>Denuncias An\u00f3nimas</h2><br>");
                        if (resultados14.next()) {
                            out.println("<h3>" + resultados14.getString("d1.Nombre") + " " + resultados14.getString("d1.Apaterno") + " " + resultados14.getString("d1.Amaterno") + "<br>DENUNCIA A <br>" + resultados14.getString("d2.Nombre") + " " + resultados14.getString("d2.Apaterno") + " " + resultados14.getString("d2.Amaterno") + "<br>EL DIA" + resultados14.getString("Fecha") + "</h3>" + resultados14.getString("Descripcion") + "<br><hr><br>");
                        }
                        else {
                            out.println("<br><br><br><h3>Por el momento nadie ha levantado ninguna Denuncia An\u00f3nima</h3><br><br><br>");
                        }
                        while (resultados14.next()) {
                            out.println("<h3>" + resultados14.getString("d1.Nombre") + " " + resultados14.getString("d1.Apaterno") + " " + resultados14.getString("d1.Amaterno") + "<br>DENUNCIA A <br>" + resultados14.getString("d2.Nombre") + " " + resultados14.getString("d2.Apaterno") + " " + resultados14.getString("d2.Amaterno") + "<br>EL DIA" + resultados14.getString("Fecha") + "</h3>" + resultados14.getString("Descripcion") + "<br><hr><br>");
                        }
                        out.println("<br><br><br>");
                        out.println("<button type=\"button\" class=\"btn btn-primary btn-lg\" required=\"required\" onClick=\"window.location.href='Director.jsp'\">Volver</button>" + 
"                        </div><br><br>");
                        con9.close();
                    }
                    catch (SQLException ex12) {
                        response.sendRedirect("Error.jsp");
                    }   break;
                case"8":
                    final String fechaNueva = request.getParameter("fecha");
                    Funcion.ActualizarFecha(idDirector, fechaNueva);
                    response.sendRedirect("Director.jsp");
                    break;
                default:
                    break;
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
"       " + 
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
        catch (IOException | NumberFormatException ex14) {
            final Exception ex13;
            response.sendRedirect("Error.jsp");
        }
        catch (SQLException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}


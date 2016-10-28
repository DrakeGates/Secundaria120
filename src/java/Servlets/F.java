// 
// Decompiled by Procyon v0.5.30
// 
//La función de este servlet es desplegar la foto de algun usuario.

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.OutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import Clases.DB;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class F extends HttpServlet
{
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String idAlumno = request.getParameter("idAlumno");
        try (final Connection con = DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            final String query = "select Foto from Datos where idPersona = " + idAlumno + ";";
            final ResultSet resultados = sentencia.executeQuery(query);
            if (resultados.next()) {
                try {
                    response.setContentType("image/jpg");
                    final InputStream in = resultados.getBinaryStream(1);
                    final OutputStream out = (OutputStream)response.getOutputStream();
                    final byte[] buffer = new byte[4096];
                    while (true) {
                        final int nBytes = in.read(buffer);
                        if (nBytes == -1) {
                            break;
                        }
                        out.write(buffer, 0, nBytes);
                    }
                    in.close();
                    out.flush();
                    out.close();
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            con.close();
        }
        catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
        }
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
}

// 
// Decompiled by Procyon v0.5.30
// 

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import Clases.Usuario;
import java.sql.SQLException;
import Clases.UsuarioDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class InicioSesion extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        final String usuario = request.getParameter("usuario");
        final String pass = request.getParameter("pass");
        final UsuarioDAO us = new UsuarioDAO();
        Usuario user;
        try {
            user = us.BuscarPorUsuario(usuario);
        }
        catch (SQLException ex) {
            user = null;
        }
        if (user != null && user.getPass().equals(pass) && user.getUsuario().equals(usuario)) {
            final HttpSession session = request.getSession();
            session.setAttribute("user", (Object)user);
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("InicioSesion.jsp");
        }
    }
}

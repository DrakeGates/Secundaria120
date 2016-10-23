// 
// Decompiled by Procyon v0.5.30
// 

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class CerrarSesion extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        request.getRequestDispatcher("/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
}

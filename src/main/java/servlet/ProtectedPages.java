/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author infoo
 */
@WebServlet(name = "ProtectedPages", urlPatterns = {"/ProtectedPages"})
public class ProtectedPages extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		try {
			HttpSession session = ((HttpServletRequest) request).getSession(false);
			if (session != null && session.getAttribute("userName") != null) {
				// connecté, on traite la requête			
				chain.doFilter(request, response);
			} else {
				// Pas connecté, on va vers la page de login (racine)
				((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/");
			}
		} catch (IOException | ServletException t) {
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}

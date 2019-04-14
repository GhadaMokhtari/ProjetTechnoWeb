/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DataSourceFactory;

// bibliothèque Google GSon
import com.google.gson.*;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author bonne
 */

@WebServlet(name = "allCommandes", urlPatterns = {"/allCommandes"})
public class ListCommandesServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
                System.out.println("enttttttttttttreeeeeeeeeeee");
		// Créér le DAO avec sa source de données
		DAO dao = new DAO(DataSourceFactory.getDataSource());

		Properties resultat = new Properties();
		

		try (PrintWriter out = response.getWriter()) {
			// On spécifie que la servlet va générer du JSON
			response.setContentType("application/json;charset=UTF-8");
			// Générer du JSON
			// Gson gson = new Gson();
			// setPrettyPrinting pour que le JSON généré soit plus lisible
                        System.out.println("hhhhhhhhhhoooooooooooohhhhh");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			out.println(gson.toJson(resultat));
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
    
}

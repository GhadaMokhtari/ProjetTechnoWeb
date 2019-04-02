/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.DataSourceFactory;

/**
 *
 * @author bonne
 */
@WebServlet(name = "addCommandeServlet", urlPatterns = {"/addCommande"})
public class AddCommandeServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		DAO dao = new DAO(DataSourceFactory.getDataSource());
		String quantite = request.getParameter("qte");
		String message;
		try {
			dao.ajoutCommande(Integer.parseInt(quantite));
			message = String.format("Commande %s ajoutée", quantite);
		} catch (NumberFormatException | SQLException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = ex.getMessage();
		}
		
		Properties resultat = new Properties();
		resultat.put("message", message);

		try (PrintWriter out = response.getWriter()) {
			// On spécifie que la servlet va générer du JSON
			response.setContentType("application/json;charset=UTF-8");
			// Générer du JSON
			Gson gson = new Gson();
			out.println(gson.toJson(resultat));
		}
	}
    
}

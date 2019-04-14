/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.CustomerDAO;
import model.DataSourceFactory;
import simplejdbc.DAOException;

/**
 *
 * @author infoo
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     
         protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
           response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
          
        if (null != action) {
            switch (action) {
                case "connexion":
                    if(checkLogin(request)){
                      request.getRequestDispatcher("affiche.jsp").forward(request, response);
                    }
                    break;
                case "logout":
                    doLogout(request);
                    break;
            }
        }

       //vérification de la connectivité
        Customer userName = findUserInSession(request);
        String jspView;
        if (null == userName) { 
            // si l'utilisateur n'est pas connecté, on choisit la page de login
            jspView = "connection.jsp";

        } else { 
            // si l'utilisateur est connecté on choisit la page d'affichage
            jspView = "affiche.jsp";
        }
        // On va vers la page choisie
        request.getRequestDispatcher(jspView).forward(request, response);

    }


    private boolean checkLogin(HttpServletRequest request) throws DAOException {
        // Les paramètres transmis dans la requête
        String login = request.getParameter("email");
        int pwd = Integer.parseInt(request.getParameter("motdepasse"));
           System.out.println("testttt  "+pwd);
        CustomerDAO cdao = new CustomerDAO(DataSourceFactory.getDataSource());
       
        Customer user = cdao.LoginCustomer(pwd,login);

        if (user != null) {
            // On a trouvé la combinaison login / password
            // On stocke l'information dans la session
            HttpSession session = request.getSession(true); // démarre la session
            session.setAttribute("userName", user);
            
            return true;
            
           
        } else{ // On positionne un message d'erreur pour l'afficher dans la JSP
             request.setAttribute("errorMessage", "Login/Password incorrect");
            return false;
        }
    }

    private void doLogout(HttpServletRequest request) {
       HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
    }

    private Customer findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (Customer) session.getAttribute("userName");
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
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             try {
                 processRequest(request, response);
             } catch (DAOException ex) {
                 Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

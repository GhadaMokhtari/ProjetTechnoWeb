package connectionpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Quelle action a appelé cette servlet ?
        String action = request.getParameter("action");
        if (null != action) {
            switch (action) {
                case "login":
                    checkLogin(request);
                    break;
                case "logout":
                    doLogout(request);
                    break;
            }
        }

       //vérification de la connectivité
        String userName = findUserInSession(request);
        String jspView;
        if (null == userName) { 
            // si l'utilisateur n'est pas connecté, on choisit la page de login
            jspView = "login.jsp";

        } else { 
            // si l'utilisateur est connecté on choisit la page d'affichage
            jspView = "affiche.jsp";
        }
        // On va vers la page choisie
        request.getRequestDispatcher(jspView).forward(request, response);

    }


    private void checkLogin(HttpServletRequest request) {
        // Les paramètres transmis dans la requête
        String loginParam = request.getParameter("loginParam");
        String passwordParam = request.getParameter("passwordParam");

        // Le login/password défini dans web.xml
        String login = getInitParameter("login");
        String password = getInitParameter("password");
        String userName = getInitParameter("userName");

        if ((login.equals(loginParam) && (password.equals(passwordParam)))) {
            // On a trouvé la combinaison login / password
            // On stocke l'information dans la session
            HttpSession session = request.getSession(true); // démarre la session
            session.setAttribute("userName", userName);
        } else { // On positionne un message d'erreur pour l'afficher dans la JSP
            request.setAttribute("errorMessage", "Login/Password incorrect");
        }
    }

    private void doLogout(HttpServletRequest request) {
       HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
    }

    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }
}

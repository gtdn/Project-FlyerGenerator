package servlets;

import classes.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Pour la demande connection
 * Si utilisatuer existe faire connection
 * sinon faire inscription
 * */
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String mot = request.getParameter("mot");
        if(nom != null && !nom.equals("")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(nom,mot));
            request.getRequestDispatcher("pageUtilisateur.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
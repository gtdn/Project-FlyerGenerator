package servlets;

import classes.User;
import dao.UserDAO;
import javax.servlet.ServletConfig;   
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.persistence.EntityManager;

import javax.persistence.Persistence;
/**.
 * Pour la demande connection
 * Si utilisatuer existe faire connection
 * sinon faire inscription
 * */
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    /**.
     * traiter pour inscription
     * @param request requete
     * @param response react
     * @throws ServletException si il a erreur
     * @throws IOException pour erreur
     */
    
    private EntityManager em;
    private UserDAO userdao;

    
    public void init(ServletConfig servletconfig) 
    throws ServletException 
{ 
    super.init(servletconfig);
    this.em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
    this.userdao = new UserDAO(em);
    
     
}
    protected final void doPost(final HttpServletRequest request,
                         final HttpServletResponse response, ServletConfig servletconfig)
            throws ServletException, IOException {
        init(servletconfig);
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        if (pseudo != null && !pseudo.equals("")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(pseudo, password));
            request.getRequestDispatcher("pageUtilisateur.jsp").
                    forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    /**.
     * aller au page inscription
     * @param request requete
     * @param response react
     * @throws ServletException erreur
     * @throws IOException erreur
     */
    protected final void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}

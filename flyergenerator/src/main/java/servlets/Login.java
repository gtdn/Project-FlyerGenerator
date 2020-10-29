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
import javax.persistence.EntityManagerFactory;
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
     * @param servletconfig servletconfig
     * @throws ServletException si il a erreur
     * @throws IOException pour erreur
     */

     /**.
     * Entity manager pour faire le lien avec la base de données
    */
    private EntityManager em;
    /**.
     * DAO
    */
    private UserDAO userdao;

    /**.
     * Instancies les DAO
     * @param servletconfig paramètre
     * @throws ServletException erreurs
    */

    public final void init(final ServletConfig servletconfig)
    throws ServletException {
    super.init(servletconfig);
    final EntityManagerFactory factory;
    factory = Persistence.createEntityManagerFactory("flyergenerator");
    em =  factory.createEntityManager();
    this.userdao = new UserDAO(em);
}

    /**.
     * Methode post
     * @param request requete
     * @param response reponse
     * @param servletconfig servlet config
     * @throws ServletException erreurs
     * @throws IOException autre erreurs
    */
    protected final void doPost(final HttpServletRequest request,
                         final HttpServletResponse response,
                        final ServletConfig servletconfig)
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

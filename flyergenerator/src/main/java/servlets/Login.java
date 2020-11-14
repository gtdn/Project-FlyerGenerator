package servlets;

import modele.User;
import dao.UserDAO;
//import javax.servlet.ServletConfig;
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
     * @throws ServletException erreurs
    */

     public final void init() // final ServletConfig servletconfig)
    throws ServletException {
    super.init();
    final EntityManagerFactory factory;
    factory = Persistence.createEntityManagerFactory("flyergenerator");
    this.em =  factory.createEntityManager();

    this.userdao = new UserDAO(em);
}

    /**.
     * Methode post
     * @param request requete
     * @param response reponse
     * @throws ServletException erreurs
     * @throws IOException autre erreurs
    */
    protected final void doPost(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        userdao.ajouterUser(name, pwd);
        if (name != null && !name.equals("")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(name, pwd));
            request.getRequestDispatcher("interface.jsp").
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

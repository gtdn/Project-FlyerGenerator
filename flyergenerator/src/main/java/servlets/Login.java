package servlets;

import modele.User;
import modele.Competition;
import modele.Conference;
import modele.Exposition;
import modele.Spectacle;

import dao.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.ArrayList;
/**
 * Pour la demande connection.
 * Si utilisatuer existe faire connection
 * sinon faire inscription
 * */
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    /**
     * Entity manager pour faire le lien avec la base de données.
    */
    private EntityManager em;
    /**.
     * DAO
    */
    private UserDAO userdao;

    /**
     * List op competitions.
     */
    private List<Competition> competitions;
     /**
     * List op expositions.
     */
    private List<Exposition> expositions;
    /**
     * List op conferences.
     */
    private List<Conference> conferences;
     /**
     * List op spectacles.
     */
    private List<Spectacle> spectacles;

    /**
     * Instancies les DAO.
     * @throws ServletException erreurs
    */
    public final void init() // final ServletConfig servletconfig)
    throws ServletException {
    super.init();
    final EntityManagerFactory factory;
    factory = Persistence.createEntityManagerFactory("flyergenerator");
    this.em =  factory.createEntityManager();
    this.userdao = new UserDAO(em);
    this.competitions = new ArrayList<>();
    this.expositions = new ArrayList<>();
    this.spectacles = new ArrayList<>();
    this.conferences = new ArrayList<>();
}

    /**
     * Methode post.
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
        ServletContext context = getServletContext();
        context.setAttribute("competitions", this.competitions);
        context.setAttribute("expositions", this.expositions);
        context.setAttribute("spectacles", this.spectacles);
        context.setAttribute("conferences", this.conferences);
        context.setAttribute("em", this.em);
        User u = userdao.ajouterUser(name, pwd);
        if (u != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", u);
            request.getRequestDispatcher("interface.jsp").
                    forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    /**
     * aller au page inscription.
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

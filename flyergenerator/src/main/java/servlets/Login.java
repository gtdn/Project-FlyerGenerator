package servlets;

import modele.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    protected final void doPost(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
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

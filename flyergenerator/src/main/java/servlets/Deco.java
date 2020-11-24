package servlets;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * pour deconnection.
 */
@WebServlet(name = "Deco", urlPatterns = "/Deco")
public class Deco extends HttpServlet {

    /**
     * Traiter les commend deconnect.
     * @param request requete
     * @param response reqct
     * @throws ServletException pour erreur
     * @throws IOException pour erreur
     */
    @Override
    protected final void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Conference;
import dao.ConferenceDAO;
import modele.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.persistence.EntityManager;

import java.io.IOException;


@WebServlet(name = "Conference", urlPatterns = "/Conference")
public class ControllerConf extends HttpServlet {
    /**
     * doGet.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(final HttpServletRequest request,
     final HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        List<Conference> conferences = (List<Conference>) getServletContext().
            getAttribute("conferences");
        ConferenceDAO confDao = new ConferenceDAO(
            (EntityManager) getServletContext().getAttribute("em"));
        final int i = ((User) session.getAttribute("user")).getID();
        conferences = confDao.getConferenceByIdUser(i);
        request.setAttribute("conferences", conferences);
        RequestDispatcher rd = request.
            getRequestDispatcher("historique/histoConf.jsp");
        rd.forward(request, response);
    }

    /**
     * DoPost.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {
    }
}

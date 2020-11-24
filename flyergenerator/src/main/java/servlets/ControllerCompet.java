
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Competition;
import dao.CompetitionDAO;
import modele.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.persistence.EntityManager;


import java.io.IOException;


@WebServlet(name = "Competition", urlPatterns = "/Competition")
public class ControllerCompet extends HttpServlet {
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

        List<Competition> competitions =
        (List<Competition>) getServletContext().
            getAttribute("competitions");
        CompetitionDAO compDao = new CompetitionDAO(
            (EntityManager) getServletContext().getAttribute("em"));
        final int i = ((User) session.getAttribute("user")).getID();
        competitions = compDao.getCompetitionByIdUser(i);
        request.setAttribute("competitions", competitions);
        RequestDispatcher rd = request.
            getRequestDispatcher("historique/histoComp.jsp");
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

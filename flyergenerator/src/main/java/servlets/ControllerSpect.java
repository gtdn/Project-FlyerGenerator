package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Spectacle;
import dao.SpectacleDAO;
import modele.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.persistence.EntityManager;

import java.io.IOException;


@WebServlet(name = "Spectacle", urlPatterns = "/Spectacle")
public class ControllerSpect extends HttpServlet {
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

        List<Spectacle> spectacles = (List<Spectacle>) getServletContext().
            getAttribute("spectacles");
        SpectacleDAO specDao = new SpectacleDAO(
            (EntityManager) getServletContext().getAttribute("em"));
        final int i = ((User) session.getAttribute("user")).getID();
        spectacles = specDao.getSpectacleByIdUser(i);
        request.setAttribute("spectacles", spectacles);
        RequestDispatcher rd = request.
            getRequestDispatcher("historique/histoSpec.jsp");
        rd.forward(request, response);
    }
}

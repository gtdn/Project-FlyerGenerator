package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Exposition;
import dao.ExpositionDAO;
import modele.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.persistence.EntityManager;


import java.io.IOException;


@WebServlet(name = "Exposition", urlPatterns = "/Exposition")
public class ControllerExpo extends HttpServlet {
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

        List<Exposition> expositions = (List<Exposition>) getServletContext().
            getAttribute("expositions");
        ExpositionDAO expoDao = new ExpositionDAO(
            (EntityManager) getServletContext().getAttribute("em"));
        final int i = ((User) session.getAttribute("user")).getID();
        expositions = expoDao.getExpositionByIdUser(i);
        request.setAttribute("expositions", expositions);
        RequestDispatcher rd = request.
            getRequestDispatcher("historique/histoExpo.jsp");
        rd.forward(request, response);
    }
}

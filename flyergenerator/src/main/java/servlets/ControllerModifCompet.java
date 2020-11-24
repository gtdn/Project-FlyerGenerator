package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Competition;
import dao.CompetitionDAO;
import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet(name = "ModifCompetition", urlPatterns = "/ModifCompetition")
public class ControllerModifCompet extends HttpServlet {
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
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Competition compet = new Competition();
        ServletContext context = getServletContext();
        CompetitionDAO competdao = new CompetitionDAO(
            (EntityManager) context.getAttribute("em"));
        compet = competdao.getCompetitionByIdEvent(id);
        request.setAttribute("nom", compet.getNom());
        request.setAttribute("ville", compet.getVille());
        request.setAttribute("lieu", compet.getLieu());
        request.setAttribute("prix", compet.getPrix());
        request.setAttribute("cashPrize", compet.getCashPrize());
        request.setAttribute("date", compet.getDateDebut());
        request.setAttribute("hashtag", compet.getHashtag());
        request.setAttribute("description", compet.getResume());
        request.setAttribute("nom_orga", compet.getContacts().getNom());
        request.setAttribute("numeroContact", compet.getContacts().getNumero());
        request.setAttribute("mail", compet.getContacts().getMail());
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("interface.jsp?contenu=compet");
        dispatcher.forward(request, response);

    }
}

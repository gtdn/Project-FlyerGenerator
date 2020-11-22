import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Spectacle;
import dao.SpectacleDAO;
import javax.persistence.EntityManager;

import java.io.IOException;

@WebServlet(name = "ModifSpectacle", urlPatterns = "/ModifSpectacle")
public class ControllerModifSpect extends HttpServlet {
    /**
     * doGet.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(final HttpServletRequest request,
     final HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * DoPost.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Spectacle spect = new Spectacle();
        ServletContext context = getServletContext();
        SpectacleDAO spectdao = new SpectacleDAO(
            (EntityManager) context.getAttribute("em"));
        spect = spectdao.getSpectacleByIdEvent(id);
        request.setAttribute("nom", spect.getNom());
        request.setAttribute("ville", spect.getVille());
        request.setAttribute("lieu", spect.getLieu());
        request.setAttribute("prix", spect.getPrix());
        request.setAttribute("date", spect.getDateDebut());
        request.setAttribute("horaire", spect.getHeureDebut());
        request.setAttribute("nom_asso", spect.getNomAssociation());
        request.setAttribute("nom_orga", spect.getContacts().getNom());
        request.setAttribute("numeroContact", spect.getContacts().getNumero());
        request.setAttribute("mail", spect.getContacts().getMail());
        RequestDispatcher dispatcher = request.getRequestDispatcher(
            "interface.jsp?contenu=spect");
        dispatcher.forward(request, response);
    }
}

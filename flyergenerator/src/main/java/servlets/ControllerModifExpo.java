package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Exposition;
import dao.ExpositionDAO;
import javax.persistence.EntityManager;

import java.io.IOException;

@WebServlet(name = "ModifExposition", urlPatterns = "/ModifExposition")
public class ControllerModifExpo extends HttpServlet {
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
        Exposition expo = new Exposition();
        ServletContext context = getServletContext();
        ExpositionDAO expodao = new ExpositionDAO(
            (EntityManager) context.getAttribute("em"));
        expo = expodao.getExpositionByIdEvent(id);
        String numero = "0" + expo.getContacts().getNumero();
        request.setAttribute("nom", expo.getNom());
        request.setAttribute("ville", expo.getVille());
        request.setAttribute("lieu", expo.getLieu());
        request.setAttribute("prix", expo.getPrix());
        request.setAttribute("dateDeb", expo.getDateDebut());
        request.setAttribute("dateFin", expo.getDateFin());
        request.setAttribute("nom_contact", expo.getContacts().getNom());
        request.setAttribute("numeroContact", numero);
        request.setAttribute("mail", expo.getContacts().getMail());
        request.setAttribute("theme", expo.getTheme());
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("interface.jsp?contenu=expo");
        dispatcher.forward(request, response);
    }
}

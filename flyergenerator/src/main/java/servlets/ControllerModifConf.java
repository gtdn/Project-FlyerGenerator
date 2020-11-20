import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Conference;
import dao.ConferenceDAO;
//import modele.User;
//import javax.servlet.http.HttpSession;
//import java.util.List;
import javax.persistence.EntityManager;

import java.io.IOException;

@WebServlet(name = "ModifConference", urlPatterns = "/ModifConference")
public class ControllerModifConf extends HttpServlet {
    /**
     * doGet.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(final HttpServletRequest request,
     final HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession(true);

        List<Conference> conferences = (List<Conference>) getServletContext().
            getAttribute("conferences");
        ConferenceDAO confDao = new ConferenceDAO(
            (EntityManager) getServletContext().getAttribute("em"));
        final int i = ((User) session.getAttribute("user")).getID();
        conferences = confDao.getConferenceByIdUser(i);
        request.setAttribute("conferences", conferences);
        RequestDispatcher rd = request.
            getRequestDispatcher("historique/histoConf.jsp");
        rd.forward(request, response);*/
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
        System.out.print("VOILAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Conference conf = new Conference();
        ServletContext context = getServletContext();
        ConferenceDAO confdao = new ConferenceDAO((EntityManager) context.getAttribute("em"));
        conf = confdao.getConferenceByIdEvent(id);
        request.setAttribute("nom", conf.getNom());
        request.setAttribute("ville", conf.getVille());
        request.setAttribute("lieu", conf.getLieu());
        request.setAttribute("prix", conf.getPrix());
        request.setAttribute("date", conf.getDateDebut());
        request.setAttribute("horaire", conf.getHeureDebut());
        request.setAttribute("nom_orga", conf.getContacts().getNom());
        request.setAttribute("intervenants", String.join(", ", conf.getListeIntervenants()));
        request.setAttribute("numeroContact", conf.getContacts().getNumero());
        request.setAttribute("mail", conf.getContacts().getMail());
        request.setAttribute("description", conf.getResume());
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("interface.jsp?contenu=conf");
        dispatcher.forward(request, response);

    }
}

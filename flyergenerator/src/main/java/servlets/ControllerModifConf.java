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
        System.out.print("ID----------------->");
        System.out.print(id);
        System.out.print("<-----------------ID");
        Conference conf = new Conference();
        ServletContext context = getServletContext();
        ConferenceDAO confdao = new ConferenceDAO(
            (EntityManager) context.getAttribute("em"));
        conf = confdao.getConferenceByIdEvent(id);
        System.out.print("NOM----------------->");
        System.out.print(conf.getNom());
        System.out.print("<-----------------NOM");
        request.setAttribute("nom", conf.getNom());
        request.setAttribute("ville", conf.getVille());
        request.setAttribute("lieu", conf.getLieu());
        request.setAttribute("prix", conf.getPrix());
        request.setAttribute("date", conf.getDateDebut());
        request.setAttribute("intervenants", conf.getListeIntervenants());
        if (conf.getContacts().getNom() != null) {
            request.setAttribute("nom_orga", conf.getContacts().getNom());
        } else {
            request.setAttribute("nom_orga", "");
        }
        request.setAttribute("numeroContact", conf.getContacts().getNumero());
        request.setAttribute("mail", conf.getContacts().getMail());
        request.setAttribute("description", conf.getResume());
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("interface.jsp?contenu=conf");
        dispatcher.forward(request, response);

    }
}

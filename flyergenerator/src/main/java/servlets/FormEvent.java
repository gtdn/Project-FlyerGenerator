package servlets;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;

import modele.Exposition;
import modele.Competition;
import modele.User;
import modele.Event;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.apache.commons.io.FileUtils;

import dao.ExpositionDAO;
import dao.CompetitionDAO;
/**
 * Define webServelt.
 */
@WebServlet("/formEvent")
public class FormEvent extends HttpServlet {
    /**
     * Entity manager pour faire le lien avec la base de données.
    */
    private EntityManager em;
    /**
     * doPost method.
     * @param request request
     * @param response response
     * @throws ServletException servelt
     * @throws IOException exception
     */
    protected final void doPost(final HttpServletRequest request,
    final HttpServletResponse response) throws ServletException, IOException {

        String eventType = request.getParameter("eventType");

        HttpSession session = request.getSession(true);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");




        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventDateBeg = request.getParameter("eventDateBeg");
        String eventContactName = request.getParameter(
            "eventContactName");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");



        //Save Commun
        Event e = new Event();
        /* Save in BDD */
        final EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("flyergenerator");
        this.em =  factory.createEntityManager();

        e.setNom(request.getParameter("eventTitle"));
        final int i = ((User) session.getAttribute("user")).getID();
        e.setIdutilisateur(i);
        e.setLieu(eventCity);
        /*e.setLocation(eventLocation)*/ // quand le champ Location sera en BDD
        Time heurBeg = new Time(0);
        e.setHeureDebut(heurBeg);
        Date dateBeg = Date.valueOf(request.getParameter("eventDateBeg"));
        e.setDateDebut(dateBeg);


        if (eventType.equals("exposition")) {

            Exposition expo = new Exposition();
            expo.copieEvent(e);
            ExpositionDAO expositionDAO = new ExpositionDAO(em);

            String theme = "theme";
            expo.setTheme(theme);
            String[] eventDateBegSplitted = eventDateBeg.split("-");
            expositionDAO.updateExposition(expo);

        }
        if (eventType.equals("competition")) {

            Competition compet = new Competition();
            compet.copieEvent(e);
            CompetitionDAO competDAO = new CompetitionDAO(em);

            /* Add in BDD */
            competDAO.updateCompetition(compet);

        }



        if (eventType.equals("exposition")) {
            System.out.println("test");
            System.out.println(eventTitle);
            String current = new java.io.File(".").getCanonicalPath();
            String htmlString = new String(Files.readAllBytes(Paths.get(
                current + "/html/flyer_exposition.html")),
            StandardCharsets.UTF_8);

            if (request.getParameter("eventPrice") == "") {
                eventPrice = "0€";
            } else {
                eventPrice += " €";
            }

            String[] eventDateBegSplitted = eventDateBeg.split("-");
            eventDateBeg = eventDateBegSplitted[2];
            String eventDateEnd = request.getParameter("eventDateEnd");
            String[] eventDateEndSplitted = eventDateEnd.split("-");
            eventDateEnd = eventDateEndSplitted[2];
            String eventYear = eventDateBegSplitted[0];
            String[] months = {"None", "Janvier", "Février", "Mars", "Avril",
            "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre",
            "Novembre", "Décembre"};
            String eventMonth = months[(Integer.parseInt(
                eventDateBegSplitted[1]))];
            htmlString = htmlString.replace("$eventTitle$", eventTitle);
            htmlString = htmlString.replace("$urlApplication$", urlApplication);
            htmlString = htmlString.replace("$eventCity$", eventCity);
            htmlString = htmlString.replace("$eventLocation$", eventLocation);
            htmlString = htmlString.replace("$eventPrice$", eventPrice);
            htmlString = htmlString.replace("$eventDateBeg$", eventDateBeg);
            htmlString = htmlString.replace("$eventDateEnd$", eventDateEnd);
            htmlString = htmlString.replace("$eventYear$", eventYear);
            htmlString = htmlString.replace("$eventMonth$", eventMonth);
            htmlString = htmlString.replace("$eventContactName$",
            eventContactName);
            htmlString = htmlString.replace("$eventContactNumber$",
            eventContactNumber);
            htmlString = htmlString.replace("$eventContactEmail$",
            eventContactEmail);

            byte[] pdfData = getPdf(htmlString);
            FileUtils.writeByteArrayToFile(new File(
                current + "/pdf/output.pdf"), pdfData);
        }
        response.sendRedirect("validation.jsp");





    }
    /**
     * function to getPDF.
     * @param html link to getPDF
     * @return results.
     */
    public final byte[] getPdf(final String html) {
        byte[] results = null;
        try {
          String[] command = {"wkhtmltopdf", "--disable-smart-shrinking",
          "--enable-local-file-access",
          "--page-size", "A5", "-L", "0",
          "-B", "0", "-R", "0", "-T", "0", "-", "-"};
          ProcessBuilder builder = new ProcessBuilder(command);
          builder.redirectErrorStream(false);
          Process process = builder.start();
          try (BufferedOutputStream stdin = new BufferedOutputStream(
          process.getOutputStream())) {
              stdin.write(html.getBytes());
          }
          try (BufferedInputStream stdout = new BufferedInputStream(
          process.getInputStream());
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            while (true) {
                int x = stdout.read();
                if (x == -1) {
                    break;
                }
                outputStream.write(x);
            }
            results = outputStream.toByteArray();
            process.waitFor();
          }
        } catch (Exception e) {
            return null;
        }
        return results;
      }
}

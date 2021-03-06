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
import modele.Conference;
import modele.Spectacle;
import modele.User;
import modele.Event;
import modele.Contacts;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;



import org.apache.commons.io.FileUtils;

import dao.ExpositionDAO;
import dao.CompetitionDAO;
import dao.ConferenceDAO;
import dao.SpectacleDAO;
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

        request.setCharacterEncoding("UTF-8");

        String eventType = request.getParameter("eventType");

        HttpSession session = request.getSession(true);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");



        // requests saved in a var cause used multiple times
        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHourBegtest = request.getParameter("eventHourBeg") + ":00";
        String eventDateBeg = request.getParameter("eventDateBeg");
        // PersonneList missing yet
        String eventOrganizer = request.getParameter(
            "eventOrganizer");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");




        // Generate the PDF
        if (eventType.equals("exposition")) {
            generateExpositionFlyer(session, request);
        } else if (eventType.equals("competition")) {
            generateCompetitionFlyer(session, request);
        } else if (eventType.equals("conference")) {
            generateConferenceFlyer(session, request);
        } else if (eventType.equals("spectacle")) {
            generateSpectacleFlyer(session, request);
        }




        // Saving those common data in mother Class Event
        Event e = new Event();

        fillEvent(e, session, request);
        ServletContext context = getServletContext();
        this.em = (EntityManager) context.getAttribute("em");

        /* treating those Data in the appropriate Daughter Class
        and adding the specifiques data to this Class*/
        if (eventType.equals("exposition")) {

            fillAndSaveExposition(e, request);

        } else if (eventType.equals("competition")) {

            fillAndSaveCompetition(e, request);

        } else if (eventType.equals("conference")) {

            fillAndSaveConference(e, request);

        } else if (eventType.equals("spectacle")) {

            fillAndSaveSpectacle(e, request);

        }
        response.sendRedirect("validation.jsp");
    }

    /**
     *
     * @param session session
     * @param request request
     * @throws ServletException
     * @throws IOException
     */
    public void generateExpositionFlyer(final HttpSession session,
    final HttpServletRequest request) throws ServletException, IOException {
        String current = new java.io.File(".").getCanonicalPath();
        String htmlString = new String(Files.readAllBytes(Paths.get(
            current
            + "/../webapps/flyergenerator/flyers/flyer_exposition.html")),
        StandardCharsets.UTF_8);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");

        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHourBeg = request.getParameter("eventHourBeg");
        String eventHourEnd = request.getParameter("eventHourEnd");
        String eventDateBeg = request.getParameter("eventDateBeg");
        String eventDateEnd = request.getParameter("eventDateEnd");
        String eventOrganizer = request.getParameter(
            "eventOrganizer");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");
        String eventBackground = request.getParameter("eventBackground");

        // Formating the hour to have the format we want
        eventHourBeg = eventHourBeg.replace(":", "H");
        eventHourEnd = eventHourEnd.replace(":", "H");

        eventPrice += " €";

        String[] eventDateBegSplitted = eventDateBeg.split("-");
        eventDateBeg = eventDateBegSplitted[2];
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
            eventOrganizer);
        htmlString = htmlString.replace("$eventContactNumber$",
            eventContactNumber);
        htmlString = htmlString.replace("$eventContactEmail$",
            eventContactEmail);
        htmlString = htmlString.replace("$eventHourBeg$", eventHourBeg);
        htmlString = htmlString.replace("$eventHourEnd$", eventHourEnd);
        htmlString = htmlString.replace("$eventBackground$",
            eventBackground);

        byte[] pdfData = getPdf(htmlString);
        FileUtils.writeByteArrayToFile(new File(
            current + "/../webapps/flyergenerator/pdf/output.pdf"),
            pdfData);
    }

    /**
     *
     * @param session session
     * @param request request
     * @throws ServletException
     * @throws IOException
     */
    public void generateCompetitionFlyer(final HttpSession session,
    final HttpServletRequest request) throws ServletException, IOException {
        String current = new java.io.File(".").getCanonicalPath();
        String htmlString = new String(Files.readAllBytes(Paths.get(
            current
            + "/../webapps/flyergenerator/flyers/flyer_competition.html")),
        StandardCharsets.UTF_8);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");

        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHour = request.getParameter("eventHourBeg");
        String eventDate = request.getParameter("eventDateBeg");
        String eventOrganizer = request.getParameter(
            "eventOrganizer");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");
        String eventBackground = request.getParameter("eventBackground");
        String eventCashPrize = request.getParameter("eventCashPrize");
        String eventHashtag = request.getParameter("eventHashtag");
        String eventDescription = request.getParameter("eventDescription");

        // Formating the hour to have the format we want
        eventHour = eventHour.replace(":", "h");

        eventPrice += " €";

        eventHashtag = "#" + eventHashtag;

        String[] eventDateSplitted = eventDate.split("-");
        eventDate = eventDateSplitted[2];
        String eventYear = eventDateSplitted[0];
        String[] months = {"None", "Jan", "Fév", "Mars", "Avr",
        "Mai", "Juin", "Juil", "Août", "Sept", "Oct",
        "Nov", "Déc"};
        String eventMonth = months[(Integer.parseInt(
            eventDateSplitted[1]))];
        String eventDay = eventDateSplitted[2];

        htmlString = htmlString.replace("$eventTitle$", eventTitle);
        htmlString = htmlString.replace("$urlApplication$", urlApplication);
        htmlString = htmlString.replace("$eventCity$", eventCity);
        htmlString = htmlString.replace("$eventLocation$", eventLocation);
        htmlString = htmlString.replace("$eventPrice$", eventPrice);
        htmlString = htmlString.replace("$eventYear$", eventYear);
        htmlString = htmlString.replace("$eventMonth$", eventMonth);
        htmlString = htmlString.replace("$eventContactName$",
            eventOrganizer);
        htmlString = htmlString.replace("$eventContactNumber$",
            eventContactNumber);
        htmlString = htmlString.replace("$eventContactEmail$",
            eventContactEmail);
        htmlString = htmlString.replace("$eventHour$", eventHour);
        htmlString = htmlString.replace("$eventBackground$",
            eventBackground);
        htmlString = htmlString.replace("$eventCashPrize$", eventCashPrize);
        htmlString = htmlString.replace("$eventDay$", eventDay);
        htmlString = htmlString.replace("$eventHashtag$", eventHashtag);
        htmlString = htmlString.replace("$eventDescription$", eventDescription);
        htmlString = htmlString.replace("$eventOrganizer$", eventOrganizer);

        byte[] pdfData = getPdf(htmlString);
        FileUtils.writeByteArrayToFile(new File(
            current + "/../webapps/flyergenerator/pdf/output.pdf"),
            pdfData);
    }

    /**
     *
     * @param session session
     * @param request request
     * @throws ServletException
     * @throws IOException
     */
    public void generateConferenceFlyer(final HttpSession session,
    final HttpServletRequest request) throws ServletException, IOException {
        String current = new java.io.File(".").getCanonicalPath();
        String htmlString = new String(Files.readAllBytes(Paths.get(
            current
            + "/../webapps/flyergenerator/flyers/flyer_conference.html")),
        StandardCharsets.UTF_8);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");

        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHour = request.getParameter("eventHourBeg");
        String eventDate = request.getParameter("eventDateBeg");
        String eventOrganizer = request.getParameter(
            "eventOrganizer");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");
        String eventBackground = request.getParameter("eventBackground");
        String eventDescription = request.getParameter("eventDescription");
        String eventSpeakers = request.getParameter("eventSpeaker1");

        // Formating the hour to have the format we want
        eventHour = eventHour.replace(":", "H");

        eventPrice += " €";

        String[] eventDateSplitted = eventDate.split("-");
        eventDate = eventDateSplitted[2];
        String eventYear = eventDateSplitted[0];
        String[] months = {"None", "Janvier", "Février", "Mars", "Avril",
        "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre",
        "Novembre", "Décembre"};
        String eventMonth = months[(Integer.parseInt(
            eventDateSplitted[1]))];
        String eventDay = eventDateSplitted[2];

        eventSpeakers = eventSpeakers.replace(" , ", ",");
        eventSpeakers = eventSpeakers.replace(" ,", ",");
        eventSpeakers = eventSpeakers.replace(", ", ",");
        eventSpeakers = eventSpeakers.replace(",", "</br>");

        htmlString = htmlString.replace("$eventTitle$", eventTitle);
        htmlString = htmlString.replace("$urlApplication$", urlApplication);
        htmlString = htmlString.replace("$eventCity$", eventCity);
        htmlString = htmlString.replace("$eventLocation$", eventLocation);
        htmlString = htmlString.replace("$eventPrice$", eventPrice);
        htmlString = htmlString.replace("$eventYear$", eventYear);
        htmlString = htmlString.replace("$eventMonth$", eventMonth);
        htmlString = htmlString.replace("$eventContactName$",
            eventOrganizer);
        htmlString = htmlString.replace("$eventContactNumber$",
            eventContactNumber);
        htmlString = htmlString.replace("$eventContactEmail$",
            eventContactEmail);
        htmlString = htmlString.replace("$eventHour$", eventHour);
        htmlString = htmlString.replace("$eventBackground$",
            eventBackground);
        htmlString = htmlString.replace("$eventDay$", eventDay);
        htmlString = htmlString.replace("$eventDescription$", eventDescription);
        htmlString = htmlString.replace("$eventOrganizer$", eventOrganizer);
        htmlString = htmlString.replace("$eventSpeakers$", eventSpeakers);

        byte[] pdfData = getPdf(htmlString);
        FileUtils.writeByteArrayToFile(new File(
            current + "/../webapps/flyergenerator/pdf/output.pdf"),
            pdfData);
    }

    /**
     *
     * @param session session
     * @param request request
     * @throws ServletException
     * @throws IOException
     */
    public void generateSpectacleFlyer(final HttpSession session,
    final HttpServletRequest request) throws ServletException, IOException {
        String current = new java.io.File(".").getCanonicalPath();
        String htmlString = new String(Files.readAllBytes(Paths.get(
            current
            + "/../webapps/flyergenerator/flyers/flyer_spectacle.html")),
        StandardCharsets.UTF_8);

        String urlApplication = request.getRequestURL().toString();
        urlApplication = urlApplication.replace("/formEvent", "");

        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHour = request.getParameter("eventHourBeg");
        String eventDate = request.getParameter("eventDateBeg");
        String eventOrganizer = request.getParameter(
            "eventOrganizer");
        String eventAsso = request.getParameter("eventAsso");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");
        String eventBackground = request.getParameter("eventBackground");
        String eventArtists = request.getParameter("eventSpeaker1");

        // Formating the hour to have the format we want
        eventHour = eventHour.replace(":", "h");

        eventPrice += " €";

        String[] eventDateSplitted = eventDate.split("-");
        eventDate = eventDateSplitted[2];
        String eventYear = eventDateSplitted[0];
        String[] months = {"None", "Janvier", "Février", "Mars", "Avril",
        "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre",
        "Novembre", "Décembre"};
        String eventMonth = months[(Integer.parseInt(
            eventDateSplitted[1]))];
        String eventDay = eventDateSplitted[2];

        eventArtists = eventArtists.replace(" , ", ",");
        eventArtists = eventArtists.replace(" ,", ",");
        eventArtists = eventArtists.replace(", ", ",");
        eventArtists = eventArtists.replace(",", " // ");

        htmlString = htmlString.replace("$eventTitle$", eventTitle);
        htmlString = htmlString.replace("$urlApplication$", urlApplication);
        htmlString = htmlString.replace("$eventCity$", eventCity);
        htmlString = htmlString.replace("$eventLocation$", eventLocation);
        htmlString = htmlString.replace("$eventPrice$", eventPrice);
        htmlString = htmlString.replace("$eventYear$", eventYear);
        htmlString = htmlString.replace("$eventMonth$", eventMonth);
        htmlString = htmlString.replace("$eventContactName$",
            eventOrganizer);
        htmlString = htmlString.replace("$eventContactNumber$",
            eventContactNumber);
        htmlString = htmlString.replace("$eventContactEmail$",
            eventContactEmail);
        htmlString = htmlString.replace("$eventHour$", eventHour);
        htmlString = htmlString.replace("$eventBackground$",
            eventBackground);
        htmlString = htmlString.replace("$eventDay$", eventDay);
        htmlString = htmlString.replace("$eventOrganizer$", eventOrganizer);
        htmlString = htmlString.replace("$eventArtists$", eventArtists);
        htmlString = htmlString.replace("$eventAsso$", eventAsso);

        byte[] pdfData = getPdf(htmlString);
        FileUtils.writeByteArrayToFile(new File(
            current + "/../webapps/flyergenerator/pdf/output.pdf"),
            pdfData);
    }

    /**
     * This fonction fill an given Event with commons Data.
     * @param e the Event to fill.
     * @param session the actual session.
     * @param request the HttpServlet to request parameters from.
     */
    public void fillEvent(final Event e, final HttpSession session,
        final HttpServletRequest request) {
        String eventTitle = request.getParameter("eventTitle");
        String eventCity = request.getParameter("eventCity");
        String eventLocation = request.getParameter("eventLocation");
        String eventPrice = request.getParameter("eventPrice");
        String eventHourBeg = request.getParameter("eventHourBeg") + ":00";
        String eventDateBeg = request.getParameter("eventDateBeg");
        String eventContactName = request.getParameter(
            "eventOrganizer");
        String eventContactNumber = request.getParameter("eventContactNumber");
        String eventContactEmail = request.getParameter("eventContactEmail");

        e.setIdutilisateur(((User) session.getAttribute("user")).getID());
        e.setNom(eventTitle);
        e.setVille(eventCity);
        e.setLieu(eventLocation);
        int prix = Integer.valueOf(eventPrice);
        e.setPrix(prix);
        Time heurBeg = Time.valueOf(eventHourBeg);
        e.setHeureDebut(heurBeg);
        Date dateBeg = Date.valueOf(eventDateBeg);
        e.setDateDebut(dateBeg);
        Contacts contacts = new Contacts();
        contacts.setNom(eventContactName);
        int numeroTel = Integer.valueOf(eventContactNumber);
        contacts.setNumero(numeroTel);
        contacts.setMail(eventContactEmail);
        e.setContacts(contacts);

    }

    /**
     * This fonction create, fill and save in DataBase an Exposition.
     * @param e the Event to copy from.
     * @param request the HttpServlet to request parameters from.
     */
    public void fillAndSaveExposition(final Event e,
     final HttpServletRequest request) {
        /* create an exposition from general Events data */
        Exposition expo = new Exposition();
        expo.copieEvent(e);

        /* add specifics data */
        String theme = request.getParameter("eventTheme");
        expo.setTheme(theme);

        String eventHourEnd = request.getParameter("eventHourEnd") + ":00";
        Time heurEnd = Time.valueOf(eventHourEnd);
        expo.setHeureFin(heurEnd);

        String eventDateEnd = request.getParameter("eventDateEnd");
        Date dateEnd = Date.valueOf(eventDateEnd);
        expo.setDateFin(dateEnd);

        /* Save the complete exposition data into our DataBase */
        ExpositionDAO expositionDAO = new ExpositionDAO(em);
        expositionDAO.updateExposition(expo);

    }
    /**
     * This fonction create, fill and save in DataBase a Competition.
     * @param e the Event to copy from.
     * @param request the HttpServlet to request parameters from.
     */
    public void fillAndSaveCompetition(final Event e,
        final HttpServletRequest request) {

    /* create a competition from general Events data */
    Competition compet = new Competition();
    compet.copieEvent(e);

    /* add specifics data */
    compet.setHashtag(request.getParameter("eventHashtag"));
    compet.setResume(request.getParameter("eventDescription"));
    compet.setCashPrize(request.getParameter("eventCashPrize"));


    /* Save the complete competition data into our DataBase */
    CompetitionDAO competDAO = new CompetitionDAO(em);
    competDAO.updateCompetition(compet);
    }

    /**
     * This fonction create, fill and save in DataBase a Conference.
     * @param e the Event to copy from.
     * @param request the HttpServlet to request parameters from.
     */
    public void fillAndSaveConference(final Event e,
        final HttpServletRequest request) {

        /* create a conferance from general Events data */
        Conference conf = new Conference();
        conf.copieEvent(e);

        /* add specifics data */
        conf.setResume(request.getParameter("eventDescription"));
        conf.setListeIntervenants(request.getParameter("eventSpeaker1"));

        /* Save the complete competition data into our DataBase */
        ConferenceDAO confDAO = new ConferenceDAO(em);
        confDAO.updateConference(conf);
    }
    /**
     * This fonction create, fill and save in DataBase a Spectacle.
     * @param e the Event to copy from.
     * @param request the HttpServlet to request parameters from.
     */
    public void fillAndSaveSpectacle(final Event e,
        final HttpServletRequest request) {

        /* create a spectacle from general Events data */
        Spectacle spec = new Spectacle();
        spec.copieEvent(e);

        /* add specifics data */
        spec.setListeArtistes(request.getParameter("eventSpeaker1"));
        spec.setNomAssociation(request.getParameter("eventAsso"));

        /* Save the complete competition data into our DataBase */
        SpectacleDAO specDAO = new SpectacleDAO(em);
        specDAO.updateSpectacle(spec);
    }


    /**
     * function to getPDF.
     * @param html link to getPDF
     * @return results.
     */
    public final byte[] getPdf(final String html) {
        byte[] results = null;
        try {
          String[] command = {"wkhtmltopdf", "--encoding", "utf-8",
            "--disable-smart-shrinking",
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

package test1;

import org.junit.Test;

import dao.ConferenceDAO;
import dao.ExpositionDAO;
import dao.SpectacleDAO;
import dao.CompetitionDAO;
import dao.UserDAO;
import modele.Competition;
import modele.User;
import modele.Event;
import modele.Spectacle;
import modele.Conference;
import modele.Contacts;
import modele.Exposition;
import modele.Contacts;
import java.util.Collection;
import java.util.Vector;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by ecoquery on 26/09/2016.
 */
public class JPATest {

    @Test
    public void setupEMTest() {
      /* EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
        Competition compet = new Competition();
        UserDAO userdao = new UserDAO(em);
        User test = userdao.ajouterUser("pseudo", "motdepasse");
        SpectacleDAO spectacledao = new SpectacleDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        CompetitionDAO competitiondao = new CompetitionDAO(em);
        ExpositionDAO expodao = new ExpositionDAO(em);
        List<Conference> liste_spectacle = conferencedao.getConferenceByIdUser(732);
        //Conference spec = liste_spectacle.get(0);
        Spectacle spec = new Spectacle();
        Exposition expo = new Exposition();
        Conference conf = new Conference();
        spec.setIdutilisateur(732);
        expo.setIdutilisateur(732);
        compet.setIdutilisateur(732);
        conf.setIdutilisateur(732);
        List<String> intervenants = new ArrayList<String>();
        intervenants.add("Booba");
        intervenants.add("Lacrim");
        intervenants.add("Andy");
        spec.setListeIntervenants(intervenants);
        System.out.println(String.join(", ",spec.getListeIntervenants()));
        System.out.println("<--------------------");
        Contacts cont = new Contacts();
        //spec.setContacts(cont);
        spec.setListeIntervenants(intervenants);
        conf.setListeIntervenants(intervenants);
        expo.setListeIntervenants(intervenants);
        compet.setListeIntervenants(intervenants);
        spec.setContacts(cont);
        conf.setContacts(cont);
        expo.setContacts(cont);
        compet.setContacts(cont);
        spectacledao.updateSpectacle(spec);
        conferencedao.updateConference(conf);
        competitiondao.updateCompetition(compet);
        expodao.updateExposition(expo);
        /*ConferenceDAO conferencedao = new ConferenceDAO(em);
        ExpositionDAO expositiondao = new ExpositionDAO(em);
        CompetitionDAO competDAO = new CompetitionDAO(em);
        Event event = new Event();
        event.setIdutilisateur(732);
        Spectacle spec = new Spectacle();
        Exposition exp = new Exposition();
        Conference conf = new Conference();
        Competition comp = new Competition();
        List<String> intervenants = new ArrayList<String>();
        intervenants.add("Booba");
        intervenants.add("Lacrim");
        intervenants.add("Andy");
        spec.copieEvent(event);
        conf.copieEvent(event);
        exp.copieEvent(event);
        comp.copieEvent(event);
        spec.setListeIntervenants(intervenants);
        conf.setListeIntervenants(intervenants);
        exp.setListeIntervenants(intervenants);
        comp.setListeIntervenants(intervenants);
        spectacledao.updateSpectacle(spec);
        conferencedao.updateConference(conf);
        competDAO.updateCompetition(compet);
        expodao.updateConference(expo);
        List<Competition> liste_competition = competDAO.getCompetitionByIdUser(732);
        System.out.println(liste_competition.size());
        System.out.println("<--------------------");


        expositiondao.updateExposition(exp);
        /*List<Spectacle> liste_spectacle = spectacledao.getSpectacleByIdUser(test.getID());
        
        //Spectacle test_2 = liste_spectacle.get(0);
        Collection<String> testintervenant = new ArrayList<String>();
       
        }*/
        //em.close();

    }
   

}

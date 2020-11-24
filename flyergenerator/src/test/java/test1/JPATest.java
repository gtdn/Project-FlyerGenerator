package test1;

import org.junit.Test;

import dao.ConferenceDAO;
import dao.ExpositionDAO;
import dao.CompetitionDAO;
import dao.SpectacleDAO;
import dao.UserDAO;
import jdk.jfr.Timestamp;
import modele.Competition;
import modele.User;
import modele.Event;
import modele.Competition;
import modele.Conference;
import modele.Contacts;
import modele.Exposition;
import modele.Spectacle;
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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by ecoquery on 26/09/2016.
 */
public class JPATest {

    @Test // Test Connexion Base de donnée
    public void setupEMTest() {
       EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
       em.close();
        }
    @Test //Test Connexion Utilisateur
    public void ConnexionUser() {
      EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
      UserDAO userdao = new UserDAO(em);
      User test = userdao.ajouterUser("pseudo", "motdepasse");
      em.close();
      assert(test != null);
    }
    @Test // Ce test crée 4 éevenements à l'utilisateur "pseudo" et vérifie qu'il a bien 4 événements de plus après leurs ajouts
    public void CreationEvenements() {
      EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
      CompetitionDAO competitiondao = new CompetitionDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        SpectacleDAO spectacledao = new SpectacleDAO(em);
        ExpositionDAO expositiondao = new ExpositionDAO(em);
        Competition compet = new Competition();
        Competition spec = new Competition();
        Exposition expo = new Exposition();
        Conference conf = new Conference();
        //L'id 27 est celui de l'utilisateur "pseudo"
        // On récupère le nombre de différents évènements
        int nombreCompetition = competitiondao.getNombreCompetitionByIdUser(27);
        int nombreConference = conferencedao.getNombreConferenceByIdUser(27);
        int nombreExposition = expositiondao.getNombreExpositionByIdUser(27);
        int nombreSpectacle = spectacledao.getNombreSpectacleByIdUser(27);

        int nombreEvent = nombreCompetition + nombreConference + nombreSpectacle + nombreExposition;
        spec.setIdutilisateur(27); 
        expo.setIdutilisateur(27);
        compet.setIdutilisateur(27);
        conf.setIdutilisateur(27);

        Contacts contact = new Contacts();
        spec.setContacts(contact); 
        expo.setContacts(contact);
        compet.setContacts(contact);
        conf.setContacts(contact);
        competitiondao.updateCompetition(spec);
        conferencedao.updateConference(conf);
        competitiondao.updateCompetition(compet);
        expositiondao.updateExposition(expo);

        int nombreCompetition2 = competitiondao.getNombreCompetitionByIdUser(27);
        int nombreConference2 = conferencedao.getNombreConferenceByIdUser(27);
        int nombreExposition2 = expositiondao.getNombreExpositionByIdUser(27);
        int nombreSpectacle2 = spectacledao.getNombreSpectacleByIdUser(27);
        int nombreEvent2 = nombreCompetition2 + nombreConference2 + nombreSpectacle2 + nombreExposition2;

        em.close();

        nombreEvent = nombreEvent + 4;
        assertEquals(nombreEvent,nombreEvent2);
    }
    @Test // Ce test modifie 4 éevenements à l'utilisateur "pseudo" et vérifie qu'il a bien le même nombre d'évènements après leurs ajouts
    public void ModificationEvenements() {
      EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
      CompetitionDAO competitiondao = new CompetitionDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        SpectacleDAO spectacledao = new SpectacleDAO(em);
        ExpositionDAO expositiondao = new ExpositionDAO(em);
        Competition compet = new Competition();
        Spectacle spec = new Spectacle();
        Exposition expo = new Exposition();
        Conference conf = new Conference();
        //L'id 27 est celui de l'utilisateur "pseudo"
        // On récupère les différents événements
        List<Competition> listCompetition = competitiondao.getCompetitionByIdUser(27);
        List<Conference> listConference  = conferencedao.getConferenceByIdUser(27);
        List<Exposition> listExposition = expositiondao.getExpositionByIdUser(27);
        List<Spectacle> listSpectacle = spectacledao.getSpectacleByIdUser(27);
        //On récupère leur nombre
        int nombreCompetition = competitiondao.getNombreCompetitionByIdUser(27);
        int nombreConference = conferencedao.getNombreConferenceByIdUser(27);
        int nombreExposition = expositiondao.getNombreExpositionByIdUser(27);
        int nombreSpectacle = spectacledao.getNombreSpectacleByIdUser(27);

        int nombreEvent = nombreCompetition + nombreConference + nombreSpectacle + nombreExposition;
        // On prend 4 évènements des listes
        compet = listCompetition.get(0);
        spec = listSpectacle.get(0);
        expo = listExposition.get(0);
        conf = listConference.get(0);
        // On récupère des événements déjà existants et on les remet dans la bdd
        spectacledao.updateSpectacle(spec);
        conferencedao.updateConference(conf);
        competitiondao.updateCompetition(compet);
        expositiondao.updateExposition(expo);
        // Normalement le nombre d'évènement ne changera pas car les évènements remplaceront leur
        // copie déjà existantes dans la bdd 
        int nombreCompetition2 = competitiondao.getNombreCompetitionByIdUser(27);
        int nombreConference2 = conferencedao.getNombreConferenceByIdUser(27);
        int nombreExposition2 = expositiondao.getNombreExpositionByIdUser(27);
        int nombreSpectacle2 = spectacledao.getNombreSpectacleByIdUser(27);
        int nombreEvent2 = nombreCompetition2 + nombreConference2 + nombreSpectacle2 + nombreExposition2;
        em.close();
        assert(nombreEvent ==nombreEvent2);
    }

    }
   

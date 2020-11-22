package test1;

import org.junit.Test;

import dao.ConferenceDAO;
import dao.ExpositionDAO;
import dao.SpectacleDAO;
import dao.CompetitionDAO;
import dao.UserDAO;
import jdk.jfr.Timestamp;
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
       EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
       em.close();
        }
    @Test 
    public void ConnexionUser() {
      EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
      UserDAO userdao = new UserDAO(em);
      User test = userdao.ajouterUser("pseudo", "motdepasse");
      em.close();
      assert(test != null);
    }
    @Test 
    public void CreationEvenements() {
      EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
      SpectacleDAO spectacledao = new SpectacleDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        CompetitionDAO competitiondao = new CompetitionDAO(em);
        ExpositionDAO expodao = new ExpositionDAO(em);
        Competition compet = new Competition();
        Spectacle spec = new Spectacle();
        Exposition expo = new Exposition();
        Conference conf = new Conference();
        spec.setIdutilisateur(27); // Identifiant de l'utilisateur "pseudo"
        expo.setIdutilisateur(27);
        compet.setIdutilisateur(27);
        conf.setIdutilisateur(27);
        spectacledao.updateSpectacle(spec);
        conferencedao.updateConference(conf);
        competitiondao.updateCompetition(compet);
        expodao.updateExposition(expo);
        em.close();
    }

    }
   

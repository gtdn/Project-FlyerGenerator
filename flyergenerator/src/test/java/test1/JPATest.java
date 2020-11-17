package test1;

import org.junit.Test;

import dao.ConferenceDAO;
import dao.ExpositionDAO;
import dao.SpectacleDAO;
import dao.CompetitionDAO;
import dao.UserDAO;
import modele.Competition;
import modele.User;
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

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by ecoquery on 26/09/2016.
 */
public class JPATest {

    @Test
    public void setupEMTest() {
        EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
        Competition compet = new Competition();
        UserDAO userdao = new UserDAO(em);
        User test = userdao.ajouterUser("pseudo", "motdepasse");
        SpectacleDAO spectacledao = new SpectacleDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        ExpositionDAO expositiondao = new ExpositionDAO(em);
        CompetitionDAO competDAO = new CompetitionDAO(em);
        Spectacle spec = new Spectacle(27, "blabla", "chemin", "bercy", new Time(0), new Date(0), "asso");
        spectacledao.updateSpectacle(spec);
        List<Spectacle> liste_spectacle = spectacledao.getSpectacleByIdUser(test.getID());
        
        //Spectacle test_2 = liste_spectacle.get(0);
        Collection<String> testintervenant = new ArrayList<String>();
        testintervenant.add("test_4_265");
        testintervenant.add("test_4_toujours_265");
        //test_2.setListeIntervenants(testintervenant);
        Contacts contact = new Contacts();
        spec.setContacts(contact);
        //spectacledao.updateSpectacle(test_2);
        compet.setIdutilisateur(27);
        competDAO.updateCompetition(compet);
        /*Exposition exp = new Exposition(27, "blabla", "chemin", "bercy", 0, new Time(0), new Time(0), new Date(0), new Date(0), "asso");
        Conference conf = new Conference(27, "blabla", "chemin", "bercy", 0, new Time(0), new Time(0), new Date(0), new Date(0), "asso");
        Contacts contact = new Contacts();
        //spec.setContacts(contact);
        spectacledao.updateSpectacle(spec);
        expositiondao.updateExposition(exp);
        conferencedao.updateConference(conf);
        System.out.print(test.getID());
        
        
        List<Spectacle> liste_spectacle = spectacledao.getSpectacleByIdUser(test.getID());
        
        Spectacle test_2 = liste_spectacle.get(0);
        System.out.print(" ANNONCE ID SPECTACLE TEST : ");
        //System.out.print(test_2.getId());
        System.out.print( "ANNONCE ID SPECTACLE TEST : ");
        //test_2.setLieu("20");
        //spec.setLieu("TEST_SPEC_9");
        //contact = test_2.getContacts();
        Collection<String> testintervenant = new ArrayList<String>();//= test_2.getListeIntervenants();
        testintervenant.add("test_2_265");
        testintervenant.add("test_2_toujours_265");
        //test_2.setListeIntervenants(testintervenant);
        spectacledao.updateSpectacle(test_2);
        //conferencedao.updateConference(conf);

        System.out.print(" ANNONCE MAIL CONTACT : ");
        //System.out.print(testintervenant.toArray()[0]);
        System.out.print( "ANNONCE MAIL CONTACT : ");
        //System.out.print(test_2.getId());        
        /*for(int i=0; i<liste_spectacle.size(); i++)
        {
            System.out.print(liste_spectacle.size());
            System.out.print(liste_spectacle.get(i).getLieu());
        }*/
        em.close();

    }
   

}

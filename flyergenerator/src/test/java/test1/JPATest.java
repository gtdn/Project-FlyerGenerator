package test1;

import org.junit.Test;

import dao.ConferenceDAO;
import dao.ExpositionDAO;
import dao.SpectacleDAO;
import dao.UserDAO;
import modele.User;
import modele.Spectacle;
import modele.Conference;
import modele.Contacts;
import modele.Exposition;
import modele.Contacts;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by ecoquery on 26/09/2016.
 */
public class JPATest {

    @Test
    public void setupEMTest() {
        EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
        UserDAO userdao = new UserDAO(em);
        User test = userdao.ajouterUser("pseudo", "motdepasse");
        SpectacleDAO spectacledao = new SpectacleDAO(em);
        ConferenceDAO conferencedao = new ConferenceDAO(em);
        ExpositionDAO expositiondao = new ExpositionDAO(em);
        Spectacle spec = new Spectacle(27, "blabla", "chemin", "bercy", 0, new Time(0), new Time(0), new Date(0), new Date(0), "asso");
        Exposition exp = new Exposition(27, "blabla", "chemin", "bercy", 0, new Time(0), new Time(0), new Date(0), new Date(0), "asso");
        Conference conf = new Conference(27, "blabla", "chemin", "bercy", 0, new Time(0), new Time(0), new Date(0), new Date(0), "asso");
        Contacts contact = new Contacts();
        spec.setContacts(contact);
        spectacledao.updateSpectacle(spec);
        expositiondao.updateExposition(exp);
        //conferencedao.updateConference(conf);
        System.out.print(test.getID());
        List<Spectacle> liste_spectacle = spectacledao.getSpectacleByIdUser(test.getID());
        //Spectacle test_2 = liste_spectacle.get(0);
        //test_2.setLieu("20");
        //spec.setLieu("TEST_SPEC_9");
        //spectacledao.UpdateSpectacle(test_2);
        //System.out.print(test_2.getId());        
        /*for(int i=0; i<liste_spectacle.size(); i++)
        {
            System.out.print(liste_spectacle.size());
            System.out.print(liste_spectacle.get(i).getLieu());
        }*/
        em.close();

    }
   

}

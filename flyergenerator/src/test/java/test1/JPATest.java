package test1;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by ecoquery on 26/09/2016.
 */
public class JPATest {

    @Test
    public void setupEMTest() {
        @PersistenceContext(unitName = "flyergenerator");
        EntityManager em = Persistence.createEntityManagerFactory("flyergenerator").createEntityManager();
        em.close();
    }

}

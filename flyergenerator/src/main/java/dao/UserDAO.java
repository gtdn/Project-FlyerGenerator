package dao;

import modele.User;

import javax.persistence.TypedQuery;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * Created by ecoquery on 25/09/2016.
 */
public class UserDAO {
    /**
     * entite manager.
     */
    private final EntityManager em;

    /**
     * @param newEm entite manageur
     */
    public UserDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**
     * Renvoie l'utilisateur correspondant à cet email.
     * @param id l'id de l'utilisateur
     * @return l'utilisateur ou null s'il n'existe pas
     */
    public final User getUserById(final int id) {
        return em.find(User.class, id);
    }

    /**
     * Créée un nouvel utilisateur si nouveau pseudo ou.
     * prend celui existant dans la base de données,
     * retourne null si bon pseudo mais mauvais password
     * @param password mot de passe du useur
     * @param pseudo pseudo
     * @return l'utilisateur créé ou lis à jour
     */
    public final User ajouterUser(final String pseudo, final String password) {
        User user = new User(pseudo, password);
        TypedQuery<User> q = em.createQuery("SELECT"
        + " u FROM utilisateur u WHERE u.pseudo"
        + " = ?1", User.class);
        q.setParameter(1, pseudo);
        List<User> results = q.getResultList();
        if (results.size() > 0) {
            if (results.iterator().next().getPassword().equals(password)) {
                return results.iterator().next();
            } else {
                return null;
        }
    } else {
        System.out.println("ETAPE2");
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }
    }

    /**
     * Créée un nouvel utilisateur ou met à jour son pseudo.
     * @param password mot de passe du useur
     * @param pseudo pseudo
     * @return l'utilisateur créé ou lis à jour
     */
    public final User createDataBase(final String pseudo,
     final String password) {
        User user = new User(pseudo, password);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
}

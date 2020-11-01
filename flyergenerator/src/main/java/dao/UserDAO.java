package dao;

import modele.User;

import javax.persistence.EntityManager;

/**
 * Created by ecoquery on 25/09/2016.
 */
public class UserDAO {


    /**.
     * entite manager
     */
    private final EntityManager em;

    /**.
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
     * Créée un nouvel utilisateur ou met à jour son pseudo.
     * @param password mot de passe du useur
     * @param pseudo pseudo
     * @return l'utilisateur créé ou lis à jour
     */
    /**public final User AjouterUser
     * (final String pseudo, final String password) {
        User user = new User(pseudo, password);
        TypedQuery<User> q = em.createQuery("SELE
        CT utilisateur FROM utilisateur
         WHERE utilisateur.pseudo = ?1", User.class);
        q.setParameter(1,pseudo);
        Collection<User> results = q.getResultList();
        if (results.size() < 1) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
        }
        return null;
    }
    }*/
        /**
     * Créée un nouvel utilisateur ou met à jour son pseudo.
     * @param password mot de passe du useur
     * @param pseudo pseudo
     * @return l'utilisateur créé ou lis à jour
     */
    public final User createTest(final String pseudo, final String password) {
        User user = new User(pseudo, password);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
}

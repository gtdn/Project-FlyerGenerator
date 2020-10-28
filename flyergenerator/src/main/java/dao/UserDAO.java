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
     * @param userID id du useur
     * @param pseudo id du pseudo
     * @return l'utilisateur créé ou lis à jour
     */
    public final User createOrUpdate(final int userID, final String pseudo) {
        User user = getUserById(userID);
        if (user == null) {
        user = new User();
        user.setId(userID);
            user.setPseudo(pseudo);
            em.persist(user);
        } else {
            user.setPseudo(pseudo);
        }
        return user;
    }
}

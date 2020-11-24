package dao;

import modele.Conference;

import javax.persistence.TypedQuery;
import java.util.List;


import javax.persistence.EntityManager;

/**
    * Class Dao pour conference.
*/
public class ConferenceDAO {


    /**
     * entite manager.
     */
    private final EntityManager em;

    /**
     * @param newEm entite manageur.
     */
    public ConferenceDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**
     * @param idUser conference donné en parametre.
     * @return toutes les conferences de l'utilisateur
     */
    public final List<Conference> getConferenceByIdUser(final int idUser) {

        TypedQuery<Conference> q = em.createQuery("SELECT spec"
        + " FROM conference spec WHERE spec.idUtilisateur"
        + " = ?1", Conference.class);
        q.setParameter(1, idUser);
        List<Conference> results = q.getResultList();
        if (results.size() > 0) {
            return results;
        } else {
            return null;
        }
    }
    /**
     * @param idUser conference donné en parametre.
     * @return le nombre de conferences de l'utilisateur
     */
    public final int getNombreConferenceByIdUser(final int idUser) {

        List<Conference> liste = getConferenceByIdUser(idUser);
        if (liste != null) {
            return liste.size();
        } else {
            return 0;
        }
    }
    /**
     * @param idEvent conference donné en parametre.
     * @return toutes les conferences de l'utilisateur
     */
    public final Conference getConferenceByIdEvent(final int idEvent) {

        Conference conf = new Conference();
        conf = em.find(Conference.class, idEvent);
        return conf;
    }
    /**
     * modifie ou crée une conference.
     * dans la data base
     * @param spec Conference donné en parametre
     */
    public final void updateConference(final Conference spec) {
        TypedQuery<Conference> q = em.createQuery("SELECT spec"
        + " FROM conference spec WHERE spec.idEvent"
        + " = ?1", Conference.class);
        q.setParameter(1, spec.getId());
        List<Conference> results = q.getResultList();
        if (results.size() > 0) {
            if (results.iterator().next().equals(spec)) {
                em.getTransaction().begin();
                 em.persist(spec);
                 em.getTransaction().commit();
            } else {
                return;
            }
        } else {
            ajoutConference(spec);
        }

}
    /**
     * ajoute une conference.
     * dans la data base
     * @param spec Spectacle donné en parametre
     */
    public final void ajoutConference(final Conference spec) {
        em.getTransaction().begin();
        em.persist(spec);
        em.getTransaction().commit();
    }

}

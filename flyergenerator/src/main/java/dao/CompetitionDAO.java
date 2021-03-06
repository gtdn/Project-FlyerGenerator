package dao;

import modele.Competition;

import javax.persistence.TypedQuery;
import java.util.List;


import javax.persistence.EntityManager;

/**
    * Class Dao pour Competition.
*/
public class CompetitionDAO {


    /**
     * entite manager.
     */
    private final EntityManager em;

    /**
     * @param newEm entite manageur.
     */
    public CompetitionDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**
     * @param idUser Competition donné en parametre.
     * @return toutes les Competitions de l'utilisateur
     */
    public final List<Competition> getCompetitionByIdUser(final int idUser) {

        TypedQuery<Competition> q = em.createQuery("SELECT conf"
        + " FROM competition conf WHERE conf.idUtilisateur"
        + " = ?1", Competition.class);
        q.setParameter(1, idUser);
        List<Competition> results = q.getResultList();
        if (results.size() > 0) {
            return results;
        } else {
            return null;
        }
    }
    /**
     * @param idUser Competition donné en parametre.
     * @return le nombre de Competitions de l'utilisateur
     */
    public final int getNombreCompetitionByIdUser(final int idUser) {

        List<Competition> liste = getCompetitionByIdUser(idUser);
        if (liste != null) {
            return liste.size();
        } else {
            return 0;
        }
    }
    /**
     * @param idEvent Competition donné en parametre.
     * @return toutes les Competitions de l'utilisateur
     */
    public final Competition getCompetitionByIdEvent(final int idEvent) {

        Competition compet = new Competition();
        compet = em.find(Competition.class, idEvent);
        return compet;
    }
    /**
     * modifie ou crée une Competition.
     * dans la data base
     * @param conf Competition donné en parametre
     */
    public final void updateCompetition(final Competition conf) {
        TypedQuery<Competition> q = em.createQuery("SELECT conf"
        + " FROM competition conf WHERE conf.idEvent"
        + " = ?1", Competition.class);
        q.setParameter(1, conf.getId());
        List<Competition> results = q.getResultList();
        if (results.size() > 0) {
            if (results.iterator().next().equals(conf)) {
                em.getTransaction().begin();
                 em.persist(conf);
                 em.getTransaction().commit();
            } else {
                return;
            }
        } else {
            ajoutCompetition(conf);
        }

}
    /**
     * ajoute une Competition.
     * dans la data base
     * @param conf conf donné en parametre
     */
    public final void ajoutCompetition(final Competition conf) {
        em.getTransaction().begin();
        em.persist(conf);
        em.getTransaction().commit();
    }

}

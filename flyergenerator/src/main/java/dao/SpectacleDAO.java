package dao;

import modele.Spectacle;

import javax.persistence.TypedQuery;
import java.util.List;


import javax.persistence.EntityManager;

    /**
     * classe SpectacleDao.
     */
public class SpectacleDAO {


    /**.
     * entite manager.
     */
    private final EntityManager em;

    /**
     * @param newEm entite manageur.
     */
    public SpectacleDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**
     * @param idUser Spectacle donné en parametre.
     * @return toutes les spectacles de l'utilisateur
     */
    public final List<Spectacle> getSpectacleByIdUser(final int idUser) {

        TypedQuery<Spectacle> q = em.createQuery("SELECT spec"
        + " FROM spectacle spec WHERE spec.idUtilisateur"
        + " = ?1", Spectacle.class);
        q.setParameter(1, idUser);
        List<Spectacle> results = q.getResultList();
        System.out.print("NOMBRE DE SPECTACLE");
        System.out.print(results.size());
        System.out.print("NOMBRE DE SPECTACLE");
        if (results.size() > 0) {
            return results;
        } else {
            return null;
        }
    }

     /**
     * @param idEvent Spectacle donné en parametre.
     * @return toutes les Spectacles de l'utilisateur
     */
    public final Spectacle getSpectacleByIdEvent(final int idEvent) {
        Spectacle expo = new Spectacle();
        expo = em.find(Spectacle.class, idEvent);
        return expo;
    }

    /**
     * modifie ou crée une spectacle.
     * dans la data base
     * @param spec Spectacle donné en parametre
     */
    public final void updateSpectacle(final Spectacle spec) {
        TypedQuery<Spectacle> q = em.createQuery("SELECT spec"
        + " FROM spectacle spec WHERE spec.idEvent"
        + "  = ?1", Spectacle.class);
        q.setParameter(1, spec.getId());
        System.out.print("ID SPECTACLE MODIFIE : ");
        System.out.print(spec.getId());
        List<Spectacle> results = q.getResultList();
        if (results.size() > 0) {
            System.out.print("COMPARAISON SPECTACLE");
            System.out.print(results.iterator().next().equals(spec));
            System.out.print("COMPARAISON SPECTACLE");
            if (results.iterator().next().equals(spec)) {
                System.out.print(" ENDGAME ENDGAME ENDGAME ENDGAMR ");
                em.getTransaction().begin();
                System.out.print(" INFINITY WARS ");
                 //em.remove(results.iterator().next());
                 System.out.print(" ENDGAME ENDGAME ENDGAME ENDGAMR ");
                 em.persist(spec);
                 System.out.print(" 22222222222222 WARS ");
                 em.getTransaction().commit();
                 System.out.print(" 33333333333333 WARS ");
            } else {
                return;
            }
        } else {
            ajoutSpectacle(spec);
        }

}
    /**
     * ajoute un spectacle.
     * dans la data base
     * @param spec Spectacle donné en parametre
     */
    public final void ajoutSpectacle(final Spectacle spec) {
        em.getTransaction().begin();
        em.persist(spec);
        em.getTransaction().commit();

    }

}

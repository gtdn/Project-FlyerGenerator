package dao;

import modele.Conference;

import javax.persistence.TypedQuery;
import java.util.List;


import javax.persistence.EntityManager;

/**.
     * Class Dao pour conference
     */
public class ConferenceDAO {


    /**.
     * entite manager
     */
    private final EntityManager em;

    /**.
     * @param newEm entite manageur
     */
    public ConferenceDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**.
     * @param idUser conference donné en parametre
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
    /**.
     * modifie ou crée une conference
     * dans la data base
     * @param spec Conference donné en parametre
     */
    public final void updateConference(final Conference spec) {
        System.out.print("COMPARAISON CONFERENCE");
        TypedQuery<Conference> q = em.createQuery("SELECT spec"
        + " FROM conference spec WHERE spec.idEvent"
        + " = ?1", Conference.class);
        q.setParameter(1, spec.getId());
        List<Conference> results = q.getResultList();
        if (results.size() > 0) {
            System.out.print("COMPARAISON Conference");
            System.out.print(results.iterator().next().equals(spec));
            System.out.print("COMPARAISON Conference");
            if (results.iterator().next().equals(spec)) {
                em.getTransaction().begin();
                 //em.remove(results.iterator().next());
                 em.persist(spec);
                 em.getTransaction().commit();
            } else {
                return;
            }
        } else {
            ajoutConference(spec);
        }

}
    /**.
     * ajoute une conference
     * dans la data base
     * @param spec Spectacle donné en parametre
     */
    public final void ajoutConference(final Conference spec) {
        em.getTransaction().begin();
        em.persist(spec);
        em.getTransaction().commit();
    }

}

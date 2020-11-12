package dao;

import modele.Exposition;

import javax.persistence.TypedQuery;
import java.util.List;


import javax.persistence.EntityManager;
    /**.
     * Class Dao pour Exposition
     */
public class ExpositionDAO {


    /**.
     * entite manager
     */
    private final EntityManager em;

    /**.
     * @param newEm entite manageur
     */
    public ExpositionDAO(final EntityManager newEm) {
        this.em = newEm;
    }

    /**.
     * @param idUser Spectacle donné en parametre
     * @return toutes les conferences de l'utilisateur
     */
    public final List<Exposition> getExpositionByIdUser(final int idUser) {

        TypedQuery<Exposition> q = em.createQuery("SELECT spec FROM exposition spec WHERE spec.id_utilisateur = ?1", Exposition.class);
        q.setParameter(1, idUser);
        List<Exposition> results = q.getResultList();
        if (results.size() > 0) {
            return results;
        } else {
            return null;
        }
    }

    /**.
     * modifie ou crée une conference
     * dans la data base
     * @param exp exposition donné en parametre
     */
    public final void updateExposition(final Exposition exp) {
        TypedQuery<Exposition> q = em.createQuery("SELECT spec FROM exposition spec WHERE spec.id_event = ?1", Exposition.class);
        q.setParameter(1, exp.getId());
        List<Exposition> results = q.getResultList();
        if (results.size() > 0) {
            System.out.print("COMPARAISON Exposition");
            System.out.print(results.iterator().next().equals(exp));
            System.out.print("COMPARAISON Exposition");
            if (results.iterator().next().equals(exp)) {
                em.getTransaction().begin();
                 em.remove(results.iterator().next());
                 em.persist(exp);
                 em.getTransaction().commit();
            } else {
                return;
            }
        } else {
            ajoutExposition(exp);
        }

}
    /**.
     * ajoute une conference
     * dans la data base
     * @param exp Spectacle donné en parametre
     */
    public final void ajoutExposition(final Exposition exp) {
        em.getTransaction().begin();
        em.persist(exp);
        em.getTransaction().commit();
    }

}

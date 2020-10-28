package modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

//import java.util.ArrayList;

/**.
 * Classe Utilisateur du site
 */
@Entity
@Table(name = "utilisateur")
public class User {
    /**.
     * Identifiant de l'utilisateur
    */
    @Id
    @GeneratedValue()
    @Column(name = "id_utilisateur")
    private int userID;

    private String password;

    /**.
     * Pseudo de l'utilisateur
    */
    private String pseudo;

    /**.
     * Liste des evenènements de l'utilisateur
    */
    /**
    * @OnetoMany(mappedBy = "utilisateur")
    * private ArrayList<Event> listEvent;
    */
    /**
     * @param id id a set
     */
    public final void setId(final int id) {
        userID = id;
    }
    /**
     * @return l'id de l'utilisateur
     */
    public final int getID() {
        return userID;
    }
    /**
     * @param p pseudo a set
     */
    public final void setPseudo(final String p) {
        pseudo = p;
    }
    /**
     * @return le pseudo de l'utilisateur
     */
    public final String getPseudo() {
        return pseudo;
    }

    // pas de get/set pour event list pour l'instant, j'attends de voir
    // comment on l'utilise
}

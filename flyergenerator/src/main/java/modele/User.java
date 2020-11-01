package modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

//import java.util.ArrayList;
import java.util.Objects;

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

    /**.
     * Pseudo de l'utilisateur
    */
    private String pseudo;

    /**.
     * Password de l'utilisateur
    */
    private String password;

    /**.
     * Liste des evenènements de l'utilisateur
    */
    /**
    * @OnetoMany(mappedBy = "utilisateur")
    * private ArrayList<Event> listEvent;
    */
    //private ArrayList<Event> listEvent;

    public User() {
        this.pseudo = "test";
        this.password = "test";
    }
    /**.
     * Constructeur
     * @param p de user
     * @param pwd de user
     */
    public User(final String p, final String pwd) {
        this.pseudo = p;
        this.password = pwd;
    }

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
    /**
     * @return le password de l'utilisateur
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @return la taille(i.e. le nombre) de la
     * liste d'evenement de l'utilisateur.

     public final int getListEventSize() {
        return listEvent.size();
    }
    */

    /**.
     * compare user
     * @param o de entree
     * @return true si le meme
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return user.getPseudo().equals(this.pseudo)
                && user.getPassword().equals(this.password);
    }

    /**.
     * comparer hash obj
     * @return true si mem hash
     */
    @Override
    public final int hashCode() {
        return Objects.hash(pseudo, password);
    }
}

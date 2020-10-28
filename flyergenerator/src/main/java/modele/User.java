package modele;

import java.util.ArrayList;
import java.util.Objects;

/**.
 * Classe Utilisateur du site
 */
public class User {
    /**.
     * Identifiant de l'utilisateur
    */
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
    private ArrayList<Event> listEvent;


    /**.
     * Constructeur
     * @param n de user
     * @param p de user
     */
    public User(final String pseudo, final String pwd) {
        this.pseudo = pseudo;
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

    /**
     * @return le password de l'utilisateur
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @return la taille(i.e. le nombre) de la
     * liste d'evenement de l'utilisateur.
     */
    public final int getListEventSize() {
        return listEvent.size();
    }

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

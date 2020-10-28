package modele;
/**.
 * Class des moyens de contact pour l'évènement (tel, mail, etc)
 */
public class Contacts {
    /**.
     * identifiant du contact
     */
    private int id;
    /**.
     * identifiant de l'event associé
     */
    private int idEvent;
    /**.
     * nom du contact
     */
    private String nom;
    /**.
     * numero de tel du contact
     */
    private int numero;
    /**.
     * adresse mail du contact
     */
    private String mail;


    /**
     * @return l'id du contact
     */
    public final int getID() {
        return id;
    }

    /**
     * @return l'id de l'event associé
     */
    public final int getIDEvent() {
        return idEvent;
    }

    /**
     * @return le nom du contact
     */
    public final String getnom() {
        return nom;
    }

    /**
     * @return le numero de telephone du contact
     */
    public final int getNumero() {
        return numero;
    }

    /**
     * @return le mail du contact
     */
    public final String getMail() {
        return mail;
    }

}

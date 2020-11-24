package modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

/**
 * Class des moyens de contact pour l'évènement (tel, mail, etc).
 */
@Entity(name = "contact")
@Table(name = "contact")
public class Contacts {

    /**
     * numero.
     */
    public static final int NUM = 0600000000;

    /**
     * Constructeur vide.
     */
    public Contacts() {
        this.nom = "nom_contact";
        this.mail = "mail@contact";
        this.numero = NUM;
    }

    /**
     * identifiant du contact.
     */
    @Id
    @GeneratedValue()
    @Column(name = "id_contact")
    private int id;

    /**
     * nom du contact.
     */
    private String nom;
    /**
     * numero de tel du contact.
     */
    private int numero;
    /**
     * adresse mail du contact.
     */
    private String mail;

    /**
     * @param newid id.
     */
    public final void id(final int newid) {
        this.id = newid;
    }

    /**
     * set le nom du contacts.
     * @param newNom valeur du nom a set.
     */
    public void setNom(final String newNom) {
        this.nom = newNom;
    }

    /**
     * set le numero du Contacts.
     * @param newNumero valeur du numero de tel a set.
     */
    public void setNumero(final int newNumero) {
        this.numero = newNumero;
    }

    /**
     * set le mail du Contacts.
     * @param newMail valeur du mail a set.
     */
    public void setMail(final String newMail) {
        this.mail = newMail;
    }

    /**
     * @return id du contact.
     */
    public final int getID() {
        return id;
    }

    /**
     * @return le nom du contact
     */
    public final String getNom() {
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

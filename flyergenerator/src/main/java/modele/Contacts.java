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
    public static final int NUMERO = 0600000000;

    /**
     * Constructeur vide.
     */
    public Contacts() {
        this.nom = "nom_contact";
        this.mail = "mail@contact";
        this.numero = NUMERO;
    }

    /**
     * identifiant du contact.
     */
    @Id
    @GeneratedValue()
    @Column(name = "id_contact")
    private int id;
    /*
    @OneToOne(mappedBy = "id_event", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_event")
    private Event idEvent;
     */
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

    /*public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    /**
     * @return l'id de l'event associé
     *
    public final int getIDEvent() {
        return idEvent;
    }
*
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
     */
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

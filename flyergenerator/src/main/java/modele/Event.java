package modele;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

/**
 * Classe mère des evènements.
 */
@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {

    /**
     * Constructeur vide.
     */
    public Event() {
        this.idUtilisateur = 0;
        this.nom = "nom_event";
        this.imagePath = "imagePath";
        this.lieu = "lieu";
        this.ville = "ville";
        this.prix = 0;
        this.heureDebut = new Time(0);
        this.dateDebut = new Date(0);

    }
    /**
     * @param newidutilisateur &.
     * @param newnom &
     * @param newimagePath &
     * @param newlieu &
     * @param newheureDebut &
     * @param newdateDebut &
     */
    public Event(final int newidutilisateur, final String newnom,
     final String newimagePath, final String newlieu,
      final Time newheureDebut, final Date newdateDebut) {
        this.idUtilisateur = newidutilisateur;
        this.nom = newnom;
        this.imagePath = newimagePath;
        this.lieu = newlieu;
        this.heureDebut = newheureDebut;
        this.dateDebut = newdateDebut;
    }
    /**
     * identifiant de l'evenement.
     */
    @Id
    @GeneratedValue()
    @Column(name = "id_event")
    private int idEvent;

    /**
     * identifiant de l'utilisateur associé (créateur).
     */
    @Column(name = "id_utilisateur")
    private int idUtilisateur;
    /**
     * nom de l'evenement.
     */
    private String nom;
    /**
     * chemin de l'image de fond (background).
     */
    @Column(name = "path_img_back")
    private String imagePath;
    /**
     * lieu de l'evenement.
     */
    private String lieu;
    /**
     * ville de l'evenement.
     */
    private String ville;
    /**
     * prix d'entrée de l'evenement.
     */
    private int prix;
    /**.
     * heure du debut de l'evenement.
     */
    @Column(name = "heuredeb")
    private Time heureDebut;
    /**
     * date du debut de l'evenement.
     */
    @Column(name = "datedeb")
    private Date dateDebut;
    /**
     * moyen de contacter les organisateur de l'evenement.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    private Contacts contacts;

    /**
     * @return contacts.
     */
    public final Contacts getContacts() {
        return this.contacts;
    }

    /**
     * @param newcontacts nouveau contact.
     */
    public final void setContacts(final Contacts newcontacts) {
        this.contacts = newcontacts;
    }

    /**
     * Renvoie l'email de l'utilisateur.
     * @return id.
     */
    public final int getId() {
        return this.idEvent;
    }

    /**
     * @param newid nouvel id.
     */
    public final void setId(final int newid) {
        this.idEvent = newid;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return id User
     */
    public final int getIdutilisateur() {
        return this.idUtilisateur;
    }

    /**
     * @param newidutilisateur nouvel id utilisateur.
     */
    public final void setIdutilisateur(final int newidutilisateur) {
        this.idUtilisateur = newidutilisateur;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return nom
     */
    public final String getNom() {
        return this.nom;
    }

    /**
     * @param newnom nouveau nom.
     */
    public final void setNom(final String newnom) {
        this.nom = newnom;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return imagePath
     */
    public final String getImagePath() {
        return this.imagePath;
    }

    /**
     * @param newimagePath nouveau lien image.
     */
    public final void setImagePath(final String newimagePath) {
        this.imagePath = newimagePath;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return lieu
     */
    public final String getLieu() {
        return this.lieu;
    }

    /**
     * @param newlieu nouveau lieu.
     */
    public final void setLieu(final String newlieu) {
        this.lieu = newlieu;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return ville
     */
    public final String getVille() {
        return this.ville;
    }

    /**
     * @param newVille nouvelle ville.
     */
    public final void setVille(final String newVille) {
        this.ville = newVille;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return prix
     */
    public final int getPrix() {
        return this.prix;
    }

    /**
     * @param newprix nouveau prix.
     */
    public final void setPrix(final int newprix) {
        this.prix = newprix;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     * @return heureDebut
     */
    public final Time getHeureDebut() {
        return this.heureDebut;
    }

    /**
     * @param newheureDebut nlle heure debut.
     */
    public final void setHeureDebut(final Time newheureDebut) {
        this.heureDebut = newheureDebut;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return dateDebut
     */
    public final Date getDateDebut() {
        return this.dateDebut;
    }

    /**
     * @param newdateDebut nouvelle date de début.
     */
    public final void setDateDebut(final Date newdateDebut) {
        this.dateDebut = newdateDebut;
    }

    /**
     * permet de copier un event.
     * @param e l'event a copier.
     */
    public final void copieEvent(final Event e) {
        this.idUtilisateur = e.getIdutilisateur();
        this.nom = e.getNom();
        this.ville = e.getVille();
        this.lieu = e.getLieu();
        this.prix = e.getPrix();
        this.heureDebut = e.getHeureDebut();
        this.dateDebut = e.getDateDebut();

        this.contacts = e.getContacts();
    }

}

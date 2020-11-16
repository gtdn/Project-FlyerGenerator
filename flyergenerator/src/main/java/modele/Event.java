package modele;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.ArrayList;
//import java.util.List;


//import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.OneToMany;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**.
 * Classe mère des evènements
 */
@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {

    /**.
     * Constructeur vide
     */
    public Event() {
        this.idUtilisateur = 0;
        this.nom = "nom_event";
        this.imagePath = "imagePath";
        this.lieu = "lieu";
        this.prix = 0;
        this.heureDebut = new Time(0);
        this.heureFin = new Time(0);
        this.dateDebut = new Date(0);
        this.dateFin = new Date(0);
        this.listeIntervenants = null;

    }
    /*
    /**.
     *
     * @param newidutilisateur a
     * @param newnom a
     * @param newimagePath a
     * @param newlieu a
     * @param newprix a
     * @param newheureDebut a
     * @param newheureFin a
     * @param newdateDebut a
     * @param newdateFin a
     /
    public Event(final int newidutilisateur,
     final String newnom, final String newimagePath,
     final String newlieu, final int newprix, final Time newheureDebut,
      final Time newheureFin, final Date newdateDebut, final Date newdateFin) {
        this.idUtilisateur = newidutilisateur;
        this.nom = newnom;
        this.imagePath = newimagePath;
        this.lieu = newlieu;
        this.prix = newprix;
        this.heureDebut = newheureDebut;
        this.heureFin = newheureFin;
        this.dateDebut = newdateDebut;
        this.dateFin = newdateFin;
        this.listeIntervenants = null;
    }
*/
    /**.
     *
     * @param newidutilisateur &
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
        this.listeIntervenants = null;
    }
    /**.
     * identifiant de l'evenement
     */
    @Id
    @GeneratedValue()
    @Column(name = "id_event")
    private int idEvent;

    /**.
     * identifiant de l'utilisateur associé (créateur)
     */
    @Column(name = "id_utilisateur")
    private int idUtilisateur;
    /**.
     * nom de l'evenement
     */
    private String nom;
    /**.
     * chemin de l'image de fond (background)
     */
    @Column(name = "path_img_back")
    private String imagePath;
    /**.
     * lieu de l'evenement
     */
    private String lieu;
    /**.
     * prix d'entrée de l'evenement
     */
    private int prix;
    /**.
     * heure du debut de l'evenement
     */
    @Column(name = "heuredeb")
    private Time heureDebut;
    /**.
     * heure de fin de l'evenement
     */
    @Column(name = "heuredef")
    private Time heureFin;
    /**.
     * date du debut de l'evenement
     */
    @Column(name = "datedeb")
    private Date dateDebut;
    /**.
     * date de fin de l'evenement
     */
    @Column(name = "datedef")
    private Date dateFin;
    /**.
     * liste des intervenants de l'evenenement
     */
    @ElementCollection
    @CollectionTable(
        name = "INTERVENANT",
        joinColumns = @JoinColumn(name = "ID_EVENT")
    )
    //@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "nom")
    private Collection<String> listeIntervenants = new ArrayList<>();

    /**.
     * @return listeIntervenants
     */
    public final Collection<String> getListeIntervenants() {
        return this.listeIntervenants;
    }

    /**.
     * @param newlisteIntervenants nouvelle liste d'intervenants
     */
    public final void setListeIntervenants(
        final Collection<String> newlisteIntervenants) {
        this.listeIntervenants = newlisteIntervenants;
    }
    /**.
     * moyen de contacter les organisateur de l'evenement
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    private Contacts contacts;

    /**.
     * @return contacts
     */
    public final Contacts getContacts() {
        return this.contacts;
    }

    /**.
     * @param newcontacts nouveau contact
     */
    public final void setContacts(final Contacts newcontacts) {
        System.out.print("ID_EVENT DE CONTACT:");
        //System.out.print(contacts.getIDEvent());
        System.out.print(this.idEvent);
        System.out.print("ID_EVENT DE CONTACT:");
        this.contacts = newcontacts;
    }

    /**.
     * Renvoie l'email de l'utilisateur.
     *
     * @return id.
     */
    public final int getId() {
        return this.idEvent;
    }

    /**.
     * @param newid nouvel id
     */
    public final void setId(final int newid) {
        this.idEvent = newid;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return id User
     */
    public final int getIdutilisateur() {
        return this.idUtilisateur;
    }

    /**.
     * @param newidutilisateur nouvel id utilisateur
     */
    public final void setIdutilisateur(final int newidutilisateur) {
        this.idUtilisateur = newidutilisateur;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return nom
     */
    public final String getNom() {
        return this.nom;
    }

    /**.
     * @param newnom nouveau nom
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

    /**.
     * @param newimagePath nouveau lien image
     */
    public final void setImagePath(final String newimagePath) {
        this.imagePath = newimagePath;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return lieu
     */
    public final String getLieu() {
        return this.lieu;
    }

    /**.
     * @param newlieu nouveau lieu
     */
    public final void setLieu(final String newlieu) {
        this.lieu = newlieu;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return prix
     */
    public final int getPrix() {
        return this.prix;
    }

    /**.
     * @param newprix nouveau prix
     */
    public final void setPrix(final int newprix) {
        this.prix = newprix;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return heureDebut
     */
    public final Time getHeureDebut() {
        return this.heureDebut;
    }

    /**.
     *
     * @param newheureDebut nlle heure debut
     */
    public final void setHeureDebut(final Time newheureDebut) {
        this.heureDebut = newheureDebut;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return heureFin
     */
    public final Time getHeureFin() {
        return this.heureFin;
    }

    /**.
     * @param newheureFin nouvelle heure de fin
     */
    public final void setHeureFin(final Time newheureFin) {
        this.heureFin = newheureFin;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return dateDebut
     */
    public final Date getDateDebut() {
        return this.dateDebut;
    }

    /**.
     * @param newdateDebut nouvelle date de début
     */
    public final void setDateDebut(final Date newdateDebut) {
        this.dateDebut = newdateDebut;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return dateFin
     */
    public final Date getDateFin() {
        return this.dateFin;
    }

    /**
     * @param newdateFin nouvelle date de fin
     */
    public final void setDateFin(final Date newdateFin) {
        this.dateFin = newdateFin;
    }

    /*public ArrayList<Personne> getListeIntervenants() {
        return this.listeIntervenants;
    }

    public void setListeIntervenants(ArrayList<Personne> listeIntervenants) {
        this.listeIntervenants = listeIntervenants;
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }*/



}

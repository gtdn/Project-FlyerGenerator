package modele;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;


//import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

/**.
 * Classe mère des evènements
 */
@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {

    public Event() {
        this.id_utilisateur = 0;
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

    public Event(final int id_utilisateur, final String nom, final String imagePath, final String lieu, final int prix, final Time heureDebut, final Time heureFin, final Date dateDebut, final Date dateFin) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.imagePath = imagePath;
        this.lieu = lieu;
        this.prix = prix;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.listeIntervenants = null;
    }
    public Event(final int id_utilisateur, final String nom, final String imagePath, final String lieu, final Time heureDebut, final Date dateDebut) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.imagePath = imagePath;
        this.lieu = lieu;
        this.heureDebut = heureDebut;
        this.dateDebut = dateDebut;
        this.listeIntervenants = null;
    }
    /**.
     * identifiant de l'evenement
     */
    @Id
    @GeneratedValue()
    @Column(name = "id_event")
    private int id_event;

    /**.
     * identifiant de l'utilisateur associé (créateur)
     */
    @Column(name = "id_utilisateur")
    private int id_utilisateur;
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
        name="INTERVENANT",
        joinColumns=@JoinColumn(name="ID_EVENT")
    )
    @Column(name="nom")
    private Collection<String> listeIntervenants = new ArrayList<>();

    public Collection<String> getListeIntervenants() {
        return this.listeIntervenants;
    }

    public void setListeIntervenants(Collection<String> listeIntervenants) {
        this.listeIntervenants = listeIntervenants;
    }
    /**.
     * moyen de contacter les organisateur de l'evenement
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_event")
    private Contacts contacts;

    public Contacts getContacts() {
        return this.contacts;
    }

    public void setContacts(Contacts contacts) {
        System.out.print("ID_EVENT DE CONTACT:");
        //System.out.print(contacts.getIDEvent());
        System.out.print(this.id_event);          
        System.out.print("ID_EVENT DE CONTACT:");
        this.contacts = contacts;
    }

    /**.
     * Renvoie l'email de l'utilisateur.
     *
     * @return id.
     */
    public final int getId() {
        return this.id_event;
    }

    public final void setId(final int id) {
        this.id_event = id;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return id User
     */
    public final int getid_utilisateur() {
        return this.id_utilisateur;
    }

    public final void setid_utilisateur(final int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return nom
     */
    public final String getNom() {
        return this.nom;
    }

    public final void setNom(final String nom) {
        this.nom = nom;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return imagePath
     */
    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(final String imagePath) {
        this.imagePath = imagePath;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return lieu
     */
    public final String getLieu() {
        return this.lieu;
    }

    public final void setLieu(final String lieu) {
        this.lieu = lieu;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return prix
     */
    public final int getPrix() {
        return this.prix;
    }

    public final void setPrix(final int prix) {
        this.prix = prix;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return heureDebut
     */
    public final Time getHeureDebut() {
        return this.heureDebut;
    }

    public final void setHeureDebut(final Time heureDebut) {
        this.heureDebut = heureDebut;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return heureFin
     */
    public final Time getHeureFin() {
        return this.heureFin;
    }

    public final void setHeureFin(final Time heureFin) {
        this.heureFin = heureFin;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return dateDebut
     */
    public final Date getDateDebut() {
        return this.dateDebut;
    }

    public final void setDateDebut(final Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    /**
     * Renvoie l'email de l'utilisateur.
     *
     * @return dateFin
     */
    public final Date getDateFin() {
        return this.dateFin;
    }

    public final void setDateFin(final Date dateFin) {
        this.dateFin = dateFin;
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

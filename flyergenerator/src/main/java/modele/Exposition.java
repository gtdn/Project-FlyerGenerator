package modele;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Date;
import java.sql.Time;
/**
 * Classe de l'evènement du type Exposition.
 * Elle herite de Event.
 */
@Entity(name = "exposition")
@Table(name = "exposition")
public class Exposition extends Event {
    /**
     * Constructeur vide de exposition.
     */
    public Exposition() {
        super();
        this.heureFin = new Time(0);
        this.dateFin = new Date(0);
        this.theme = "theme_de_base";
    }
    /**
     * Constructeur avec toutes les valeures possibles.
     * @param idUser idUser
     * @param nom nom evenement
     * @param imagePath lienimage
     * @param lieu lieu evenement
     * @param heureDebut heure debutEvenement
     * @param dateDebut date debut evenement
     * @param newtheme nom association
     */
    public Exposition(final int idUser,
     final String nom, final String imagePath,
      final String lieu, final Time heureDebut,
      final Date dateDebut, final String newtheme) {

        super(idUser, nom, imagePath, lieu,
         heureDebut, dateDebut);
        this.theme = newtheme;
    }

    /**
     * getterName.
     * @return name
     */
    public final String getName() {
        return super.getNom();
    }
    /**
     * @return theme
     */
    public final String getTheme() {
        return this.theme;
    }

    /**
     * @param newtheme nouveau theme.
     */
    public final void setTheme(final String newtheme) {
        this.theme = newtheme;
    }
    /**
     * description du theme de l'exposition.
     */
    @Column
    private String theme;
        /**
     * heure de fin de l'evenement.
     */
    @Column(name = "heuredef")
    private Time heureFin;
    /**
     * date de fin de l'evenement.
     */
    @Column(name = "datedef")
    private Date dateFin;
    /**
     * Renvoie l'email de l'utilisateur.
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
     * @return dateFin
     */
    public final Date getDateFin() {
        return this.dateFin;
    }

    /**
     * @param newdateFin nouvelle date de fin.
     */
    public final void setDateFin(final Date newdateFin) {
        this.dateFin = newdateFin;
    }
}

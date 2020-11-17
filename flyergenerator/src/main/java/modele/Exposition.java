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
     * id de l'exposition.
     */
    //private int idExposition;



    public Exposition() {
        super();
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
    /*
    /**
     * Constructeur avec toutes les valeures possibles.
     * @param idUser idUser
     * @param nom nom evenement
     * @param imagePath lienimage
     * @param lieu lieu evenement
     * @param prix evenement
     * @param heureDebut heure debutEvenement
     * @param heureFin heure fin evenement
     * @param dateDebut date debut evenement
     * @param dateFin date fin
     * @param newtheme nom association
     /
    public Exposition(final int idUser, final String nom,
    final String imagePath, final String lieu, final int prix,
    final Time heureDebut, final Time heureFin, final Date dateDebut,
    final Date dateFin, final String newtheme) {

        super(idUser, nom, imagePath, lieu, prix,
         heureDebut, heureFin, dateDebut, dateFin);
        this.theme = newtheme;
    }
*/
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
}

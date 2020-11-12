package modele;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Date;
import java.sql.Time;
/**.
 * Classe de l'evènement du type Exposition.
 * Elle herite de Event.
 */
@Entity(name = "exposition")
@Table(name = "exposition")
public class Exposition extends Event {
    /**.
     * id de l'exposition
     */
    //private int idExposition;



    public Exposition() {
        super();
        this.theme = "theme_de_base";
    }
    /**.
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
     */
    public Exposition(final int idUser, final String nom,
    final String imagePath, final String lieu, final int prix,
    final Time heureDebut, final Time heureFin, final Date dateDebut,
    final Date dateFin, final String newtheme) {

        super(idUser, nom, imagePath, lieu, prix,
         heureDebut, heureFin, dateDebut, dateFin);
        this.theme = newtheme;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    /**.
     * description du theme de l'exposition
     */
    @Column
    private String theme;
}

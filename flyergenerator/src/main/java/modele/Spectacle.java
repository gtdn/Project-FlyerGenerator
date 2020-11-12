package modele;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Date;
import java.sql.Time;



@Entity(name = "spectacle")
@Table(name = "spectacle")
    /**.
     * Class spectacle herite de Event
     */
public class Spectacle extends Event {

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
     * @param newnomAssociation nom association
     */
    public Spectacle(final int idUser, final String nom,
    final String imagePath, final String lieu, final int prix,
    final Time heureDebut, final Time heureFin, final Date dateDebut,
    final Date dateFin, final String newnomAssociation) {

        super(idUser, nom, imagePath, lieu, prix,
         heureDebut, heureFin, dateDebut, dateFin);
        this.nomAssociation = newnomAssociation;
    }

    /**.
     * Constructeur avec toutes les valeures possibles.
     * @param idUser idUser
     * @param nom nom evenement
     * @param imagePath lienimage
     * @param lieu lieu evenement
     * @param heureDebut heure debutEvenement
     * @param dateDebut date debut evenement
     * @param newnomAssociation nom association
     */
    public Spectacle(final int idUser,
     final String nom, final String imagePath,
      final String lieu, final Time heureDebut,
      final Date dateDebut, final String newnomAssociation) {

        super(idUser, nom, imagePath, lieu,
         heureDebut, dateDebut);
        this.nomAssociation = newnomAssociation;
    }
    /**.
    * Constructeur par défaut
    */
    public Spectacle() {
        super();
        this.nomAssociation = "association_de_base";
    }


        /**.
     * id du spectacle
     */
    //private int idSpectacle;
    /**.
     * nom de l'association organisatrice
     */
    @Column(name = "nom_asso")
    private String nomAssociation;
}

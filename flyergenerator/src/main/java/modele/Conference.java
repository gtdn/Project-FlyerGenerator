package modele;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Date;
import java.sql.Time;

/**
 * Classe de l'evènement du type Conference. Elle herite de Event.
 */
@Entity(name = "conference")
@Table(name = "conference")
public class Conference extends Event {

    /**
     * Constructeur vide Conference.
     */
    public Conference() {
        super();
        this.resume = "resume_de_base";
        this.listeIntervenants = "";
    }

    /**
     * Constructeur avec toutes les valeures possibles.
     * @param idUser idUser
     * @param nom nom evenement
     * @param imagePath lienimage
     * @param lieu lieu evenement
     * @param heureDebut heure debutEvenement
     * @param dateDebut date debut evenement
     * @param newresume nom association
     */
    public Conference(final int idUser,
            final String nom, final String imagePath,
            final String lieu, final Time heureDebut,
            final Date dateDebut, final String newresume) {

        super(idUser, nom, imagePath, lieu,
                heureDebut, dateDebut);
        this.resume = newresume;
    }
    /**
     * @return resume.
     */
    public final String getResume() {
        return this.resume;
    }
    /**
     * liste des intervenants de l'evenenement.
     */
    @Column(name = "Intervenants")
    private String listeIntervenants;

    /**
     * @return listeIntervenants.
     */
    public final String getListeIntervenants() {
        return this.listeIntervenants;
    }

    /**
     * @param newlisteIntervenants nouvelle liste d'intervenants.
     */
    public final void setListeIntervenants(
        final String newlisteIntervenants) {
        this.listeIntervenants = newlisteIntervenants;
    }

    /**
     * @param newresume resume.
     */
    public final void setResume(final String newresume) {
        this.resume = newresume;
    }
    /**
     * descriptif de la conference.
     */
    @Column(name = "resumee")
    private String resume;
}

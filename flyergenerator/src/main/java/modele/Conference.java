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

    /*
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
     * @param newresume nom association
     /
    public Conference(final int idUser, final String nom,
    final String imagePath, final String lieu, final int prix,
    final Time heureDebut, final Time heureFin, final Date dateDebut,
    final Date dateFin, final String newresume) {

        super(idUser, nom, imagePath, lieu, prix,
         heureDebut, heureFin, dateDebut, dateFin);
        this.resume = newresume;
    }
     */
 /*
    public int getIdConference() {
        return this.idConference;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }
     */
    /**
     * @return resume.
     */
    public final String getResume() {
        return this.resume;
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

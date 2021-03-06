package modele;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Classe de l'evènement du type Competition.
 * Elle herite de Event.
 */
@Entity(name = "competition")
@Table(name = "competition")
public class Competition extends Event {

    /**
     * constructeur vide.
     */
    public Competition() {
        super();
    }
    /**
     * id de l'event general.
     */
    private String hashtag;
    /**
     * descriptif de la competition.
     */
    private String resume;
    /**
     * ce que l'on peut gagner dans cette competition.
     */
    private String cashPrize;

    /**
     * @return retourne hashtag.
     */
    public final String getHashtag() {
        return this.hashtag;
    }

    /**
     * @param newhashtag nouvel hashtag.
     */
    public final void setHashtag(final String newhashtag) {
        this.hashtag = newhashtag;
    }

    /**
     * @return resume.
     */
    public final String getResume() {
        return this.resume;
    }

    /**
     * @param newresume nouveau resume.
     */
    public final void setResume(final String newresume) {
        this.resume = newresume;
    }

    /**
     * @return cashPrize.
     */
    public final String getCashPrize() {
        return this.cashPrize;
    }

    /**
     * @param newcashPrize nouveau cashPrize.
     */
    public final void setCashPrize(final String newcashPrize) {
        this.cashPrize = newcashPrize;
    }

}

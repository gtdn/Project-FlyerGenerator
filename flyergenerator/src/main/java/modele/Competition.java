package modele;
/**.
 * Classe de l'evènement du type Competition.
 * Elle herite de Event.
 */
public class Competition extends Event {

    public Competition() {
        super();
    }
    /**.
     * id de l'event general
     */
    private String hashtag;
    /**.
     * nom de l'organisateur
     */
    private String nomOrganisateur;
    /**.
     * descriptif de la competition
     */
    private String resume;
    /**.
     * ce que l'on peut gagner dans cette competition
     */
    private String cashPrize;

    public String getHashtag() {
        return this.hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getNomOrganisateur() {
        return this.nomOrganisateur;
    }

    public void setNomOrganisateur(String nomOrganisateur) {
        this.nomOrganisateur = nomOrganisateur;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCashPrize() {
        return this.cashPrize;
    }

    public void setCashPrize(String cashPrize) {
        this.cashPrize = cashPrize;
    }

}

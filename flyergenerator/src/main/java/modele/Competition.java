package modele;
/**.
 * Classe de l'evènement du type Competition.
 * Elle herite de Event.
 */
public class Competition {
    /**.
     * id de la competition
     */
    private int idCompetition;
    /**.
     * id de l'event general
     */
    private int idEvent;
    /**.
     * hashtag de l'event
     */
    private String hashtag;
    /**.
     * nom de l'organisateur
     */
    private String nomOrganisateur;
    /**.
     * descriptif de l'event
     */
    private String resume;
    /**.
     * ce que l'on peut gagner dans cette competition
     */
    private String cashPrize;

}

package modele;
/**.
 * Classe mère des evènements
 */
public class Event {
    /**.
     * identifiant de l'evenement
     */
    private int id;
    /**.
     * identifiant de l'utilisateur associé (créateur)
     */
    private int idUser;
    /**.
     * nom de l'evenement
     */
    private String nom;
    /**.
     * chemin de l'image de fond (background)
     */
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
    private int heureDebut;
    /**.
     * heure de fin de l'evenement
     */
    private int heureFin;


}

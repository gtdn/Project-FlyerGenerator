package classes;

import java.util.ArrayList;

/**.
 * Class gestion de utilisateur
 * @author gr08
 * @version 1.0
 */
public class ListeUser {
    /**.
     * list de user a gere
     */
    private ArrayList<User> lUser;

    /**.
     * constructeur par default
     */
    public ListeUser() {
        this.lUser = new ArrayList<>(); }

    /**.
     * constructeur
     * @param l entree
     */
    public ListeUser(final ArrayList<User> l) {
        this.lUser = l; }

    /**.
     * get list user
     * @return list user
     */
    public final ArrayList<User> getlUser() {
        return lUser; }

    /**.
     * saisir
     * @param l entree
     */
    public final void setlUser(final ArrayList<User> l) {
        this.lUser = l; }

    /**.
     * cherche user
     * @param u user pour cherche
     * @return ture si trouve
     */
    public final boolean trouverUser(final User u) {
        for (int i = 0; i < lUser.size(); i++) {
            if (lUser.get(i).equals(u)) {
                return true;
            }
        }
        return false;
    }

    /**.
     * ajoute un user
     * @param u user pour ajoute
     */
    public final void add(final User u) {
        lUser.add(u);
    }
}

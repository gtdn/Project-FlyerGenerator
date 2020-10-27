package classes;

import java.util.Objects;

/**.
 * class de utilisateur
 */
public class User {
    /**.
     * nom user
     */
    private final String nom;
    /**.
     * mot de pass
     */
    private String password;

    /**.
     * constructeur
     * @param n de user
     * @param p de user
     */
    public User(final String n, final String p) {
        this.nom = n;
        this.password = p;
    }

    /**.
     * constructeur par default
     * @param n entree
     */
    public User(final String n) {
        this.nom = n;
        this.password = new String("123");
    }

    /**.
     * saisir pass
     * @param pass pour saisir
     */
    public final void setPassword(final String pass) {
        this.password = pass;
    }

    /**.
     * retourner mot de pass
     * @return en string
     */
    public final String getPassword() {
        return password;
    }

    /**.
     * retourner nom user
     * @return en string
     */
    public final String getNom() {
        return nom;
    }

    /**.
     * compare user
     * @param o de entree
     * @return true si le meme
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return user.getNom().equals(this.nom)
                && user.getPassword().equals(this.password);
    }

    /**.
     * comparer hash obj
     * @return true si mem hash
     */
    @Override
    public final int hashCode() {
        return Objects.hash(nom, password);
    }
}

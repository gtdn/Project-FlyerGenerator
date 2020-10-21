package classes;
import java.util.ArrayList;

public class ListeUser{
    private ArrayList<User> lUser;

    public ListeUser() {
        this.lUser = new ArrayList<>();
    }

    public ListeUser(ArrayList<User> lUser) {
        this.lUser = lUser;
    }

    public ArrayList<User> getlUser() {
        return lUser;
    }

    public void setlUser(ArrayList<User> lUser) {
        this.lUser = lUser;
    }
    /**
     * Chercher un utilisateur dans la liste
     */
    public boolean trouverUser(User u){
        for(int i=0;i<lUser.size();i++)
        {
            if(lUser.get(i).equals(u))
                return true;
        }
        return false;
    }
    /**
     * Ajouter un nouv utilisatuer
     */
    public void add(User u){
        lUser.add(u);
    }
}
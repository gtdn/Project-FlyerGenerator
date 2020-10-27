package modele;


public class User {
    
    private int userID;
    private String pseudo;
    private ArrayList<Event> listEvent;

    public void setId (int id) {
        userID = id;
    }
    public int getID() {
        return userID;
    }

    public void setPseudo (String P) {
        pseudo = P;
    }
    public int getPseudo() {
        return pseudo;
    }

    // pas de get/set pour event list pour l'instant, j'attends de voir
    // comment on l'utilise
}

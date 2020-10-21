package classes;

import java.util.Objects;

public class User {
    private final String nom;
    private String password;

    public User(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public User(String nom) {
        this.nom = nom;
        this.password = new String("123");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String getNom() {
        return nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user.getNom().equals(this.nom) && user.getPassword().equals(this.password);
    }
}
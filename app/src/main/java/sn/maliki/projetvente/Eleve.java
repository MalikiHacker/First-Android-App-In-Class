package sn.maliki.projetvente;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class Eleve implements Serializable {

    @PrimaryKey
    int uid;

    private String prenom;
    private String nom;

    public Eleve(){}

    public Eleve(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return  prenom + ' ' + nom ;
    }
}

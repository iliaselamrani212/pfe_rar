package com.example.pfe.classes;

public class Auteur {
    private int id_auteur ;
    private String nom_auteur ;
    private String prenom_auteur ;
    private String bio_auteur ;

    
    public Auteur(int id_auteur, String nom_auteur ,String prenom_auteur ,String bio_auteur){
        this.id_auteur=id_auteur ;
        this.nom_auteur=nom_auteur;
        this.prenom_auteur=prenom_auteur;
        this.bio_auteur=bio_auteur;

    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

       public String getNom_auteur() {
        return nom_auteur;
    }
   
    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public String getPrenom_auteur() {
        return prenom_auteur;
    }

    public void setPrenom_auteur(String prenom_auteur) {
        this.prenom_auteur = prenom_auteur;
    }

    public String getBio_auteur() {
        return bio_auteur;
    }

    public void setBio_auteur(String bio_auteur) {
        this.bio_auteur = bio_auteur;
    }
    
}

package com.example.pfe.classes;

public class User {
  
    private String  nom_user ;
    private String prenom_user ;
    private String email_user ;
    private String mdp_user ;
    public User(String nom_user, String prenom_user, String email_user, String mdp_user) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email_user = email_user;
        this.mdp_user = mdp_user;
    }
    public String getNom_user() {
        return nom_user;
    }
    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }
    public String getPrenom_user() {
        return prenom_user;
    }
    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }
    public String getEmail_user() {
        return email_user;
    }
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }
    public String getMdp_user() {
        return mdp_user;
    }
    public void setMdp_user(String mdp_user) {
        this.mdp_user = mdp_user;
    }
}

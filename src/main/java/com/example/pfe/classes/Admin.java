package com.example.pfe.classes;

public class Admin extends User {
    private int id_admin ;
    public int getId_admin() {
        return id_admin;
    }
    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    public Admin(int id_admin,String nom_user, String prenom_user, String email_user, String mdp_user) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.id_admin=id_admin;
        
    }
}

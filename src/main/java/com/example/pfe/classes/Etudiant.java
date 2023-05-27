package com.example.pfe.classes;

public class Etudiant extends User {
    private String cne ;
    private String filiere;
    private String telephone ;
    
  
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public Etudiant(String cne,String nom_user, String prenom_user, String email_user, String mdp_user) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.cne=cne;
    }
    public Etudiant(String cne,String nom_user, String prenom_user, String email_user, String mdp_user,String filiere , String telephone) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.cne=cne;
        this.filiere=filiere;
        this.telephone=telephone ;
    }
    public String getCne() {
        return cne;
    }
    public void setCne(String cne) {
        this.cne = cne;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package com.example.pfe.classes;

public class Tag {
    private int id_tag ;
    private String nom_tag ;

    public Tag(int id_tag, String nom_tag) {
        this.id_tag = id_tag;
        this.nom_tag = nom_tag;
    }
    
    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public String getNom_tag() {
        return nom_tag;
    }

    public void setNom_tag(String nom_tag) {
        this.nom_tag = nom_tag;
    }



    

    
}

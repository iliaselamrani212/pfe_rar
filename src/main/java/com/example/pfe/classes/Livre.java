package com.example.pfe.classes;

public class Livre {
 private int id_livre;
 private String titre ;
 private String description ;
 private byte[] couverture ;
 private int id_auteur ;
 private int nombre_pages;
 private int exemplaire;
 





public int getExemplaire() {
    return exemplaire;
}

public void setExemplaire(int exemplaire) {
    this.exemplaire = exemplaire;
}

public int getId_auteur() {
    return id_auteur;
}

public void setId_auteur(int id_auteur) {
    this.id_auteur = id_auteur;
}

public Livre(int id_livre, String titre, String description, byte[] couverture, int id_auteur , int nombre_pages,int exemplaire) {
    this.id_livre = id_livre;
    this.titre = titre;
    this.description = description;
    this.couverture = couverture;
    this.id_auteur = id_auteur;
    this.nombre_pages=nombre_pages ;
    this.exemplaire=exemplaire;
   

}

public int getId_livre() {
    return id_livre;
}

public void setId_livre(int id_livre) {
    this.id_livre = id_livre;
}

public String getTitre() {
    return titre;
}

public void setTitre(String titre) {
    this.titre = titre;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public byte[] getCouverture() {
    return couverture;
}

public void setCouverture(byte[] couverture) {
    this.couverture = couverture;
}
public int getNombre_pages() {
    return nombre_pages;
}

public void setNombre_pages(int nombre_pages) {
    this.nombre_pages = nombre_pages;
}

    
}

package com.example.pfe.classes;

import java.time.LocalDate;

public class Commentaire {
    private int  id_commentaire;
    private int id_livre;
    private String cne ;
    private String contenu;
    private  LocalDate commentDate ;
    public LocalDate getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }
    public Commentaire(int id_commentaire, int id_livre, String cne, String contenu, LocalDate commentDate) {
        this.id_commentaire = id_commentaire;
        this.id_livre = id_livre;
        this.cne = cne;
        this.contenu = contenu;
        this.commentDate = commentDate;
    }
    public Commentaire(int id_commentaire, int id_livre, String cne, String contenu) {
        this.id_commentaire = id_commentaire;
        this.id_livre = id_livre;
        this.cne = cne;
        this.contenu = contenu;
    }
    public int getId_commentaire() {
        return id_commentaire;
    }
    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }
    public int getId_livre() {
        return id_livre;
    }
    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }
    public String getCne() {
        return cne;
    }
    public void setCne(String cne) {
        this.cne = cne;
    }
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}

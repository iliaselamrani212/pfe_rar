package com.example.pfe.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.example.pfe.classes.Etudiant;
import com.example.pfe.database.GetStetment;
import com.example.pfe.classes.Session;
import com.example.pfe.classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Modele_etudiant {
    public static User checkEtudiant(String email, String mot_de_pass) {
     
      try {
        
        ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant where EMAIL_ETUDIANT='"+email+"'");
        
          while (r.next()) {
            // if(PasswordCrypter.checkPassword(mot_de_pass,r.getString("MDP_ETUDIANT"))==true){
              
            User e=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
            return e;}
          // }
          return null;
              
        } catch (SQLException e) {
         
          return null;
          
        }
           
        }
        public static int countetu() {
      
          try {
           
            ResultSet r=  GetStetment.statement.executeQuery("select count(*) from etudiant");
            
              while (r.next()) {
                
                return r.getInt("count(*)");
              }
              return 0;
                  
            } catch (SQLException e) {
             
              return 0;
              
            }
               
            }
            public static  ObservableList<Etudiant> load() throws SQLException{
              ObservableList<Etudiant> e=FXCollections.observableArrayList();
             
              ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant");
              while (r.next()) {
                Etudiant etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
                e.add(etu);
              }
              return e;
            }


            public static  Etudiant getProfileEtudiant( String cneEtudiant)  {
              Etudiant etu=null;
              try {
               
                ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant  where cne='"+cneEtudiant+"'");
               
                while(r.next()){
                  etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
                  
                }
            } 
            catch (Exception e) {
              // TODO: handle exception
            } 
             
              
           return etu;
           
          }

          public static void changemotdepass(String nv_pass) {
           
            try {
            
              String query = "UPDATE etudiant SET MDP_ETUDIANT='"+nv_pass+"' where EMAIL_ETUDIANT='"+ Session.email_utiliasteur+"' and NOM_ETUDIANT='"+Session.nom_utiliasteur+"' and  PRENOM_ETUDIANT='"+Session.prenom_utiliasteur+"'";
              
             GetStetment.statement.executeUpdate(query);}
             catch (SQLException e) {
             
              e.printStackTrace();
            }
          }
        public static Etudiant getetuparemail(String email){
          Etudiant etu=null;
          try {
           
            ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant  where EMAIL_ETUDIANT='"+email+"'");
           
            while(r.next()){
              etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
              
            }
        } 
        catch (Exception e) {
          // TODO: handle exception
        } 
        return etu;
        }
        public static String getoldpass(String email,String nom,String prenom){
         String mdps=null;
          try {
           
            ResultSet r=  GetStetment.statement.executeQuery("select MDP_ETUDIANT from etudiant  where EMAIL_ETUDIANT='"+email+"' and NOM_ETUDIANT='"+nom+"' and  PRENOM_ETUDIANT='"+prenom+"' ");
           
            while(r.next()){
             mdps=r.getString("MDP_ETUDIANT");
              
            }
        } 
        catch (Exception e) {
          // TODO: handle exception
        } 
        return mdps;
        }
        public static String getcneetudiant(String email,String nom,String prenom){
          String cne=null;
           try {
            
             ResultSet r=  GetStetment.statement.executeQuery("select cne from etudiant  where EMAIL_ETUDIANT='"+email+"' and NOM_ETUDIANT='"+nom+"' and  PRENOM_ETUDIANT='"+prenom+"' ");
            
             while(r.next()){
              cne=r.getString("cne");
               
             }
         } 
         catch (Exception e) {
           // TODO: handle exception
         } 
         return cne;
         }





         public static  Vector<Etudiant> getEdutiants() throws SQLException{
          Vector<Etudiant> e = new Vector<Etudiant>() ;
         
          ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant");
          while (r.next()) {
            Etudiant etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
            e.add(etu);
          }
          return e;
        }
    }


package com.example.pfe.models;


import com.example.pfe.classes.Commentaire;
import com.example.pfe.database.GetStetment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;




public  class Modele_cmnt {
    public static Vector<Commentaire> getcmnts (int  id_livre) throws SQLException{
        ResultSet r  = GetStetment.statement.executeQuery("select * from commentaire where  ID_LIVRE="+id_livre+"ORDER BY  COMMENT_DATE DESC");
        Vector<Commentaire> listeofcmnts = new Vector<>();
        while (r.next()) {
          LocalDate commentDate = r.getDate("COMMENT_DATE").toLocalDate();
            Commentaire com=new Commentaire(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4),commentDate);
         
          listeofcmnts.add( com);
        }
    
        return listeofcmnts;
    
      }
      public static void addcmnt (int id_commentaire , int  id_livre , String cne , String contenu ) throws SQLException{
        LocalDate currentDate = LocalDate.now();
    
        GetStetment.statement.executeQuery("insert into commentaire values ("+id_commentaire+","+id_livre+",'"+cne+"','"+contenu+"',TO_DATE('"+currentDate+"', 'YYYY-MM-DD'))");

      
        
      }
      public static void deletecmnt (int id_commentaire) throws SQLException{
       
    
        GetStetment.statement.executeQuery("delete from commentaire where id_commentaire='"+id_commentaire+"'");
      
        
      }
      public static String selectaut (int id_commentaire) throws SQLException{
     
    
        ResultSet r= GetStetment.statement.executeQuery("select CNE from commentaire where id_commentaire='"+id_commentaire+"'");
        while (r.next()) {
          ResultSet r1= GetStetment.statement.executeQuery("select NOM_ETUDIANT, PRENOM_ETUDIANT from  etudiant where CNE='"+r.getString(1)+"'");
          while (r1.next()) {
           return r1.getString(1)+" "+r1.getString(2);
           
          }
        }
      return null;
        
      }
      public static void supprimer_commentaire(int id_commentaire) throws SQLException{
        GetStetment.statement.executeQuery("delete from commentaire where ID_COMMENTAIRE = '"+id_commentaire+"'");
        System.out.println("deleted");

      }
      

  }

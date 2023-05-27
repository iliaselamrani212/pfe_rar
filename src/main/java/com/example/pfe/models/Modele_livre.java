package com.example.pfe.models;

import com.example.pfe.database.GetStetment;
import com.example.pfe.classes.Livre;
import com.example.pfe.database.conn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Modele_livre {
  public static int addLivre (int id_livre , String titre , String description , File couverture , int id_auteur , int nombre_de_page, int exemplaire) throws SQLException, FileNotFoundException {

      FileInputStream fis = new FileInputStream(couverture);
      String sql = "INSERT INTO livre  VALUES (?, ?, ?,?,?,?,?,?)";
      PreparedStatement statement = conn.Connection().prepareStatement(sql);
      statement.setInt(1, id_livre); // Set the book ID
      statement.setString(2, titre ); // Set the book title
      statement.setString(3, description ); // Set the book description
      statement.setBinaryStream(4, fis, (int) couverture.length()); // Set the image as a binary stream
      statement.setInt(5, id_auteur); // Set the book ID_auteur
      statement.setInt(6, nombre_de_page);//Set the book nombre_page
      statement.setInt(7, exemplaire);//Set the book examplaire
      statement.setInt(8, 0);//Set the book examplaire
      int rowsAffected = statement.executeUpdate();
      if (rowsAffected > 0) {
          System.out.println("Book inserted successfully.");
      } else {
          System.out.println("Failed to insert book.");
      }


//      GetStetment.statement.executeQuery("insert into livre values ("+id_livre+",'"+titre+"','"+description+"','"+couverture+"',"+id_auteur+","+nombre_de_page+","+exemplaire+")");

    ResultSet s = GetStetment.statement.executeQuery("select id_livre from livre where titre='"+titre+"'");

      if (s.next()) {
          System.out.println("retirved");
          return s.getInt(1);
      } else {
          System.out.println("non");
          // Handle the case when no rows are returned
          return 0; // Or any other appropriate value
      }

    
  }
 
    public static int countlivre() throws SQLException {
      
        try {
          
          ResultSet r=GetStetment.statement.executeQuery("select count(*) from livre");

            while (r.next()) {  
                return r.getInt("count(*)");
            }
            return 0;   
          } catch (Exception e) {
            
            return 0;
            
          }}
    public static Vector<Livre> getLivres() throws SQLException{
      
            
            ResultSet r = GetStetment.statement.executeQuery("select * from livre");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getBytes(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          public static Vector<Livre> chercheLivres(String text ) throws SQLException{
      
            
            ResultSet r = GetStetment.statement.executeQuery("SELECT  ID_LIVRE,titre,DESCRIPTION,couverture,nombre_pages,exemplaire, UTL_MATCH.EDIT_DISTANCE(titre, '"+text+"') AS similarity_score FROM livre WHERE UTL_MATCH.EDIT_DISTANCE(titre, '"+text+"') <= 4 ORDER BY similarity_score");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getBytes(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          public static Vector<Livre> getLivresEmpruntee (String cne) throws SQLException{
            ResultSet r  = GetStetment.statement.executeQuery("select * from livre where id_livre in (select id_livre from reserve where CNE ='"+cne+"')");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getBytes(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          
          
    public static boolean deletelivre(String idlivre) throws SQLException{
      GetStetment.statement.executeUpdate("delete from livre  where id_livre = '"+idlivre+"'");
      return true;
    }
    public static int selectMaxId() throws SQLException{
      ResultSet s = GetStetment.statement.executeQuery("select MAX(id_livre) from livre");
      s.next();
   
    return s.getInt(1);
    }

   public static Livre getBook( int Id_livre ) throws SQLException {
    Livre L= null;
    ResultSet s=GetStetment.statement.executeQuery("select * from livre where id_livre='"+Id_livre+"'");
    while(s.next())
     L = new Livre(s.getInt(1), s.getString(2), s.getString(3), s.getBytes(4), s.getInt(5),s.getInt(6),s.getInt(7));
    return L;
    }
    public static int getlikes(int id_livre) throws SQLException{
      ResultSet s = GetStetment.statement.executeQuery("select count(*) from favoris where id_livre = "+id_livre);
      s.next();
   
    return s.getInt(1);

    }

} 
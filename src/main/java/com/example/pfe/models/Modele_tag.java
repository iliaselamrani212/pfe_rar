package com.example.pfe.models;



import com.example.pfe.database.GetStetment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Modele_tag {
    public static int counttag() {
        try {
          ResultSet r=  GetStetment.statement.executeQuery("select count(*) from tag");
            while (r.next()) {
              return r.getInt("count(*)");
            }
            return 0; 
          } catch (SQLException e) {
            return 0;
          }
             
          }
          //retourn the table of id tags for add in avoir table
    public static Vector<Integer> addtags(String tags) throws SQLException{
      int id_tag;
      Vector<Integer> liste_des_id=new Vector<>();
      for (String iterable_element : tags.split(",")) {
        id_tag =Modele_tag.tagExist(iterable_element);
          if(id_tag==-1){
        GetStetment.statement.executeQuery("insert into tag values(1,'"+iterable_element+"')");
        ResultSet s = GetStetment.statement.executeQuery("select id_tag from tag where nom_tag ='"+iterable_element+"'");
        while(s.next()) {
        liste_des_id.add(s.getInt(1));}}
        else{
          liste_des_id.add(id_tag);
        }
      
        

      }
      return liste_des_id;
        
    }
    public static int tagExist(String tag) throws SQLException{
      ResultSet s=GetStetment.statement.executeQuery("select ID_TAG from tag where NOM_TAG ='"+tag+"'");
      if(s.next()==false)return -1;
      
      
      return s.getInt(1);
    
    }
    public static String stringoftags (int id_livre) throws SQLException{
      ResultSet s=GetStetment.statement.executeQuery("select ID_TAG from avoir where id_livre ='"+id_livre+"'");
      String tags=null ;
      while(s.next()) {
        if (tags==null){
          tags = s.getInt(1)+",";
        }
        else{
          tags = tags+s.getInt(1)+",";
        }
        
        }
        
        return tags ;
    }
    public static Vector<String> vectoroftags (int id_livre) throws SQLException{
      ResultSet s=GetStetment.statement.executeQuery("select ID_TAG from avoir where id_livre ='"+id_livre+"'");
      Vector<String> tags = new Vector<>() ;
      while(s.next()) {
       
        tags.add((s.getInt(1)+","));  
       
    }
    return tags;

  }
}

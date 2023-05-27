package com.example.pfe.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;


import com.example.pfe.classes.Etudiant;
import com.example.pfe.database.GetStetment;
import com.example.pfe.classes.Session;
import com.example.pfe.controllers.ListOfBooksStudentController;

public class Modele_reserve {
  public static int id_current_book ;


        public static int addLivre (LocalDate fin) throws SQLException{
            LocalDate currentDate = LocalDate.now();
          GetStetment.statement.executeQuery("insert into reserve values (1,'"+ Session.id_utiliasteur+"','"+ListOfBooksStudentController.id+"',TO_DATE('"+currentDate+"', 'YYYY-MM-DD'),TO_DATE('"+fin+"', 'YYYY-MM-DD'),'yes')");
          
          return 1;
          
        }



        public static List<Map<String, Object>> getReservedBooks(String cne ) throws SQLException {
          
            
          List<Map<String, Object>> reservedBooks = new ArrayList<>();
          // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          try (
               ResultSet r1 = GetStetment.statement.executeQuery("SELECT id_livre, date_Debut, date_fin FROM reserve WHERE cne = '"+cne+"'")) {
      
              while (r1.next()) {
                  int  id = r1.getInt("id_livre");
                
                  // String id=Modele_livre.getBook(r.getInt("id_livre")).getTitre();               
                 String startDate = r1.getString("date_Debut");
                  String endDate = r1.getString("date_fin");
                  
                  // LocalDateTime dateFin = LocalDateTime.parse(endDate , formatter); // Convert "date_fin" string to LocalDateTime object
                  // LocalDateTime now = LocalDateTime.now();
                  // id_current_book= now.isBefore(dateFin) ? id : 0  ;
                 
                  Map<String, Object> reservedBook = new HashMap<>();
                 
                  reservedBook.put("titre",id);
                  reservedBook.put("startDate", startDate);
                  reservedBook.put("endDate", endDate);
                  reservedBooks.add(reservedBook);
                  
              }
             
            
          }

          return reservedBooks;
      }




     // methode pour retourner le titre emprunter pour le momment par l'etudiant 
           public static String getTitle(String cne ) throws SQLException {
        int id=0 ;
      
        String s= "Aucun livre emprunté pour le moment ";
    try ( ResultSet r= GetStetment.statement.executeQuery("SELECT id_livre FROM reserve_now_view WHERE cne = '"+cne+"'")) 
    
       {
    while(r.next()) {
    
   id=r.getInt(1) ;
    }
    }
    
return   id==0 ? s : Modele_livre.getBook(id).getTitre() ;
  }
    
  
  public static void ConfirmerLivreRendu(String cne ) throws SQLException {
    ResultSet r = GetStetment.statement.executeQuery("update reserve set reserve_now='no' where cne='"+cne+"' ");
 

}

//            public static String getTitre(int id ) throws SQLException{ 
//   String titre=" " ;
//
//    try {ResultSet r3 = GetStetment.statement.executeQuery("SELECT titre FROM livre WHERE id_livre = '"+id+"'"); 
//   while(r3.next()){

//      titre=r3.getString(1);
//      
//   } } catch( Exception e ) {
//    
//   }
//   return titre ;
  

// }
public static String getTitre(Object object) throws SQLException {
  String titre = "";
  System.out.println(object);

  try {
    ResultSet r3 = GetStetment.statement.executeQuery("SELECT titre FROM livre WHERE id_livre = '" + object + "'");

    if (r3 != null && !r3.isClosed()) {
      while (r3.next()) {
        titre = r3.getString(1);
      
      }
      r3.close(); // close the result set after retrieving data
    }
  } catch (Exception e) {
   
  }

  return titre;
}



public static Etudiant getProfileEtudiant(String cneEtudiant)  {
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


}
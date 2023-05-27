package com.example.pfe.database;

import java.sql.*;

public class conn {
    public static Statement getStatement() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "pfe", "1234");
            Statement s=c.createStatement();
            return s;
            
        } catch (Exception e) {
          System.out.println("error");
          System.out.println("Error: " + e.getMessage());
          e.printStackTrace();
        }
        return null;
    }
   
    public static Connection Connection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "pfe", "1234");
          
            return c;
            
        } catch (Exception e) {
          System.out.println("error");
        }
        return null;
    }
    public static void closeConnection (Connection conx) throws SQLException{
        conx.close();
    }
   
}

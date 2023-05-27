package com.example.pfe.models;

import com.example.pfe.database.GetStetment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model_livreAvoirTag {
    public static boolean insertIntoAvoir (int id_livre,int id_tag) {
        try{
        ResultSet r = GetStetment.statement.executeQuery("insert into avoir values ("+id_tag+","+id_livre+")");
        return true;
        }catch(SQLException e){
         
            return false;
        }
    }
}

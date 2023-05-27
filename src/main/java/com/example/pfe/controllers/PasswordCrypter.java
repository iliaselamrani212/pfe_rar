package com.example.pfe.controllers;


import java.util.Arrays;


public class PasswordCrypter {
    
    public static String cryptPassword(String password) {
        String cryptedPassword = null;
        
        try {
            byte[] byteArray = password.getBytes();

            cryptedPassword =Arrays.toString(byteArray);
        } catch (Exception e) {
            // handle the exception
        }
        
        return cryptedPassword;
    }
    public static boolean checkPassword(String plainTextPassword, String cryptedPassword) {
        boolean a =true;
     if(Arrays.toString(plainTextPassword.getBytes()).compareTo(cryptedPassword)==0) a=true;
       return a;
   
}

}
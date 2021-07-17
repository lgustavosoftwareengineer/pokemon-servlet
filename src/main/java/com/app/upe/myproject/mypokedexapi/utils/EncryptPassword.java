package com.app.upe.myproject.mypokedexapi.utils;
public class EncryptPassword {
    public static String buildEncryptedPassword(String password) {
       return password;
    }
    public static boolean verifyPasswords(String providedPassword, String securedPassword)
    {
        boolean returnValue = false;
        
        String newSecurePassword = providedPassword;

        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
}
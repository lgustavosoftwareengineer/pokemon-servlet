package com.app.upe.myproject.mypokedexapi.utils;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class EncryptPassword {
    public static String buildEncryptedPassword(String password) {
        String hashPassword = Hashing.sha256()
        .hashString(password, StandardCharsets.UTF_8)
        .toString();
       
        return hashPassword;
    }
    public static boolean verifyPasswords(String providedPassword, String securedPassword)
    {
        boolean returnValue = false;
        
        String newSecurePassword = buildEncryptedPassword(providedPassword);

        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
}
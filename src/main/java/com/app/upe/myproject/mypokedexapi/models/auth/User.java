package com.app.upe.myproject.mypokedexapi.models.auth;

import java.util.*;

import com.app.upe.myproject.mypokedexapi.services.JWTTokenService;
import com.app.upe.myproject.mypokedexapi.utils.Formatter;

public class User {
  private String id = UUID.randomUUID().toString();
  private String username;
  private String email;
  private String password;
  private String confirmPassword;

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return this.confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public static String getIdFromBearerToken(String bearerToken) {
    Map<String, String> payload = Formatter.convertFromStringToMap(JWTTokenService.decryptJWTToken(bearerToken));
    Collection<String> payloadValues = payload.values();
    
    String id = payloadValues.toArray()[1].toString().split("}")[0].replaceAll("^\"+|\"+$", "");

    return id;
  }

}

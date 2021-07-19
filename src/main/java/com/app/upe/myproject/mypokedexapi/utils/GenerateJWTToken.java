package com.app.upe.myproject.mypokedexapi.utils;

import java.util.Map;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;

import io.github.cdimascio.dotenv.Dotenv;

public class GenerateJWTToken {
  static Dotenv dotenv = Dotenv.load();
  static String SECRET = dotenv.get("JWT-SECRET");

  
  public static String buildJWTToken(Map<String, String> payload) throws JWTCreationException {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      String token = JWT.create().withPayload(payload).sign(algorithm);

      return "Bearer " + token;
    } catch (JWTCreationException exception){
      throw new JWTCreationException("Can't generate a JWT token with success.", exception);
    }
  }

  public static String decryptJWTToken (String token) throws JWTDecodeException {
    String onlyToken = token.split(" ")[1];
   
    try {
        String jwt = JWT.decode(onlyToken).getPayload();
        String payload =  Formatter.convertFromBase64ToString(jwt);

        return payload;
    } catch (JWTDecodeException exception){
      throw new JWTDecodeException("Can't generate a JWT token with success.", exception);
    }
  }

}
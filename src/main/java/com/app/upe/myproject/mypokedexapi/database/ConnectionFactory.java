package com.app.upe.myproject.mypokedexapi.database;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {
  String DB_DRIVER = "org.postgresql.Driver";
  Dotenv dotenv = Dotenv.load();
  
  public Connection getConnection() throws ClassNotFoundException {
    String DATABASE_NAME = dotenv.get("DATABASE_NAME");
    String USER_NAME = dotenv.get("USER_NAME");
    String USER_PASSWORD = dotenv.get("USER_PASSWORD");

    try {
      Class.forName(DB_DRIVER);
      System.out.println("----------------------------------------");
      System.out.println("Connection made with success with: " + DATABASE_NAME + " database");
      System.out.println("----------------------------------------");

      return DriverManager.getConnection("jdbc:postgresql:" + DATABASE_NAME, USER_NAME, USER_PASSWORD);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }
}
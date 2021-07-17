package com.app.upe.myproject.mypokedexapi.database;

import java.sql.*;

public class ConnectionFactory {
  String DB_DRIVER = "org.postgresql.Driver";
  String DATABASE_NAME = "pokedex";
  String USER_NAME = "postgres";
  String USER_PASSWORD = "Pokemon123!";

  public Connection getConnection() throws ClassNotFoundException {
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
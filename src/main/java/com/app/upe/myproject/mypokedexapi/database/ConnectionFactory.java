package com.app.upe.myproject.mypokedexapi.database;

import java.sql.*;

public class ConnectionFactory {
  String dbDriver = "org.postgresql.Driver";

  public Connection getConnection() throws ClassNotFoundException {

      try {
        Class.forName(dbDriver);
        System.out.println("----------------------------------------");
        System.out.println("Got Connection");
        System.out.println("----------------------------------------");
        
        return DriverManager.getConnection(
        "jdbc:postgresql:pokedex", "postgres", "Pokemon123!");
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }
}
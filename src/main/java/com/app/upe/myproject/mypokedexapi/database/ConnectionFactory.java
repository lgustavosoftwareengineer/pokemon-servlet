package com.app.upe.myproject.mypokedexapi.database;

import java.sql.*;

public class ConnectionFactory {
  public Connection getConnection() {
      try {
        return DriverManager.getConnection(
        "jdbc:postgresql:pokedex", "postgres", "Pokemon123!");
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }
}
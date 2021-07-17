package com.app.upe.myproject.mypokedexapi.daos;

import java.util.ArrayList;
import java.sql.*;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.database.*;

public class UserDAO extends DAO<User> {
  private Connection connection;
  private static ArrayList<User> users = new ArrayList<User>();

  public UserDAO() {
    try {
      this.connection = new ConnectionFactory().getConnection();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    
  }

  @Override
  public void add(User entity) {
    String SQL = "INSERT INTO users (id, username, password, email) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
      stmt.setString(1, entity.getId());
      stmt.setString(2, entity.getUsername());
      stmt.setString(3, entity.getPassword());
      stmt.setString(4, entity.getEmail());

      stmt.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public User find(String searchParam) {
    String formattedSearchParam = "\'"+searchParam+"\'";
    String SQL = "SELECT * FROM users WHERE email = " + formattedSearchParam + "OR id = " + formattedSearchParam + "OR username = " + formattedSearchParam;
    try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
      ResultSet rs = stmt.executeQuery();
      User user = new User();

      while (rs.next()) {
        user.setId(rs.getString("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));;
        user.setEmail(rs.getString("email"));
      }
      
      return user;
    
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(String id, User element) {
    User user = this.find(id);

    if (user != null) {
      if (element.getEmail() != null) {
        user.setEmail(element.getEmail());
      }
      if (element.getUsername() != null) {
        user.setUsername(element.getUsername());
      }
      if (element.getPassword() != null) {
        user.setPassword(element.getPassword());
      }

      this.delete(id);
      this.add(user);
    }
    
  }

  @Override
  public User delete(String id) {
    User user = this.find(id);

    if (user != null) {
      users.remove(user);
      return user;
    }

    return null;
  }

  @Override
  public ArrayList<User> getAll() {
    return users;
  }
  
}

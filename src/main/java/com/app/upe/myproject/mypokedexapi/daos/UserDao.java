package com.app.upe.myproject.mypokedexapi.daos;

import java.util.ArrayList;
import java.sql.*;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.database.*;

public class UserDAO extends DAO<User> {
  private Connection connection;

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
  public void update(String id, User entity) {
    String SQL = "UPDATE users SET username=?, email=?, password=? WHERE id=?";

    try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
      stmt.setString(1, entity.getUsername());
      stmt.setString(2, entity.getEmail());
      stmt.setString(3, entity.getPassword());
      stmt.setString(4, id);
      stmt.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(String id) {
    String SQL = "DELETE FROM users WHERE " + "id = " + "\'"+id+"\'";
    
    try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
      stmt.execute();      
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public ArrayList<User> getAll() {
    String SQL = "SELECT * FROM users";
    
    try (PreparedStatement stmt = this.connection.prepareStatement(SQL)){
      ArrayList<User> users = new ArrayList<User>();
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setUsername(rs.getString("userName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("setPassword"));
        users.add(user);
      }

      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
}

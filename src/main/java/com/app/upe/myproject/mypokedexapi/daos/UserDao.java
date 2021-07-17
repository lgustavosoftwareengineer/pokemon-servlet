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
    }
    
  }

  @Override
  public void add(User element) {
    String SQL = "INSERT into users " + "(id, "+ "username, " + "password, " + "email) " + "values(?, ?, ?, ?)";

  try {
    // prepared statement para inserção
    PreparedStatement stmt = connection.prepareStatement(SQL); 

    // seta os valores
    stmt.setString(1,element.getId());
    stmt.setString(2,element.getUsername());
    stmt.setString(3,element.getPassword());
    stmt.setString(4,element.getEmail());

    // executa
    stmt.execute();
    stmt.close();
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
  
  }

  @Override
  public User find(String searchParam) {
    if (users.isEmpty()) {
      return null;
    }

    for (User user : users) {
      if (user.getEmail().equals(searchParam) || user.getId().equals(searchParam) || user.getUsername().equals(searchParam) || user.getId().equals(searchParam)) {
        return user;
      } 
      else {
        return null;
      }
    }

    return null;
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

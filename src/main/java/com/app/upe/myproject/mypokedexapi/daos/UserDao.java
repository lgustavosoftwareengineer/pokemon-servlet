package com.app.upe.myproject.mypokedexapi.daos;

import java.util.ArrayList;

import com.app.upe.myproject.mypokedexapi.models.auth.User;

public class UserDAO extends DAO<User> {
  private static ArrayList<User> users = new ArrayList<User>();

  @Override
  public void add(User element) {
    if (users.isEmpty()) {
      users.add(element);
    } 
    for (User user : users) {
      if (user.getEmail().equals(element.getEmail())) {
       return;
      } 
    }

    users.add(element);
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

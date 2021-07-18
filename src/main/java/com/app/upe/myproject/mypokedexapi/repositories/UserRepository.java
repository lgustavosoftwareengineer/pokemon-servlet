package com.app.upe.myproject.mypokedexapi.repositories;

import java.util.ArrayList;

import com.app.upe.myproject.mypokedexapi.daos.UserDAO;
import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.utils.EncryptPassword;

public class UserRepository extends Repository<User> {
  UserDAO userDAO = new UserDAO();

  @Override
  public void add(User entity) throws Exception {
    if (!entity.getPassword().equals(entity.getConfirmPassword())) {
      throw new Exception("The password and confirmPassword must be equals.");
    } else {
      User user = this.find(entity.getEmail());
      
      if (user == null) {
        String encryptedPassword = EncryptPassword.buildEncryptedPassword(entity.getPassword());
        entity.setPassword(encryptedPassword);
  
        userDAO.add(entity);
      }
      else {
        throw new Exception("A user with this email already exist.");
      }
     
    }
  }

  @Override
  public User find(String searchParam) {
    User user = userDAO.find(searchParam);
    
    if (user.getEmail() == null) {
      return null;
    } 
    return user;
  }

  @Override
  public User findById(String id) {
    User user = this.find(id); 
    if (user == null) {
      throw new RuntimeException("Can't find a user with this id.");
    }
    return user;
  }

  @Override
  public void update(String id, User entity) {
    User user = this.findById(id);

    if (user == null) {
      throw new RuntimeException("Can't find a user with this id.");
    } else {
      if (entity.getEmail() != null) {
        user.setEmail(entity.getEmail());
      }
      if (entity.getUsername() != null) {
        user.setUsername(entity.getUsername());
      }
      if (entity.getPassword() != null) {
        user.setPassword(entity.getPassword());
      } 
      userDAO.update(id, user);
    }
  }

  @Override
  public User delete(String id) {
    User user = this.findById(id);

    if (user == null) {
      throw new RuntimeException("Can't find a user with this id.");
    } else {
      userDAO.delete(id);
      return user;
    }
  }

  @Override
  public ArrayList<User> getAll() {
   return userDAO.getAll();
  }
  
}

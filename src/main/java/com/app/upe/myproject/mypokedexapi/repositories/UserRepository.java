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
      String encryptedPassword = EncryptPassword.generateSecurePassword(entity.getPassword());
      entity.setPassword(encryptedPassword);

      userDAO.add(entity);
    }
  }

  @Override
  public User find(String searchParam) {
    return userDAO.find(searchParam);
  }

  @Override
  public User findById(String id) {
    return userDAO.find(id); 
  }

  @Override
  public void update(String id, User entity) {
  }

  @Override
  public User delete(String id) {
   return userDAO.delete(id);
  }

  @Override
  public ArrayList<User> getAll() {
   return userDAO.getAll();
  }
  
}

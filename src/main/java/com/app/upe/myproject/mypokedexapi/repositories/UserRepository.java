package com.app.upe.myproject.mypokedexapi.repositories;

import java.util.ArrayList;

import com.app.upe.myproject.mypokedexapi.daos.UserDAO;
import com.app.upe.myproject.mypokedexapi.models.auth.User;

public class UserRepository extends Repository<User> {
  UserDAO userDAO = new UserDAO();

  @Override
  public void add(User element) {
    userDAO.add(element);
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
  public void update(String id, User element) {
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

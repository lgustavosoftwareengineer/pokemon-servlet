package com.app.upe.myproject.mypokedexapi.repositories;

import java.util.ArrayList;

import com.app.upe.myproject.mypokedexapi.daos.UserDao;
import com.app.upe.myproject.mypokedexapi.models.auth.User;

public class UserRepository extends Repository<User> {
  UserDao userDao = new UserDao();

  @Override
  public void add(User element) {
    userDao.add(element);
  }

  @Override
  public User find(String searchParam) {
    return userDao.find(searchParam);
  }

  @Override
  public User findById(String id) {
    return userDao.find(id); 
  }

  @Override
  public void update(String id, User element) {
  }

  @Override
  public User delete(String id) {
   return userDao.delete(id);
  }

  @Override
  public ArrayList<User> getAll() {
   return userDao.getAll();
  }
  
}

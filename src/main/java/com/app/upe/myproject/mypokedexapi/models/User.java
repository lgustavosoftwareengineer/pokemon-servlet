package com.app.upe.myproject.mypokedexapi.models;

import java.util.ArrayList;

public class User {
  private String name;
  private String email;
  private static ArrayList<User> users = new ArrayList<User>();

  public static ArrayList<User> getUsers() {
    return users;
  }
  public static void setUsers(ArrayList<User> users) {
    User.users = users;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public static void addUser(User user) {
    users.add(user);
  }

}

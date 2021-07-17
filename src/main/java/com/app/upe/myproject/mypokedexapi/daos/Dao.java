package com.app.upe.myproject.mypokedexapi.daos;

import java.util.ArrayList;

public abstract class DAO<T> {
  public abstract void add(T element);
  
  public abstract T find(String searchParam);

  public abstract void update(String id, T element);

  public abstract void delete(String id);

  public abstract ArrayList<T> getAll();
}

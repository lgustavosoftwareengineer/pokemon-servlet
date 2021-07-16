package com.app.upe.myproject.mypokedexapi.repository;

import java.util.ArrayList;

public abstract class Repository<T> {
  public abstract void add(T element);
  
  public abstract T find(String searchParam);

  public abstract T findById(String id);

  public abstract void update(String id, T element);

  public abstract T delete(String id);

  public abstract ArrayList<T> getAll();
}

package com.app.upe.myproject.mypokedexapi.models;

import java.util.List;

public class Pokemon {
  Integer id;
  String name;
  Integer base_experience;
  Integer weight;
  List<Types> types;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getBase_experience() {
    return base_experience;
  }
  public void setBase_experience(Integer base_experience) {
    this.base_experience = base_experience;
  }
  public Integer getWeight() {
    return weight;
  }
  public void setWeight(Integer weight) {
    this.weight = weight;
  }
  public List<Types> getTypes() {
    return types;
  }
  public void setTypes(List<Types> types) {
    this.types = types;
  }
  
}

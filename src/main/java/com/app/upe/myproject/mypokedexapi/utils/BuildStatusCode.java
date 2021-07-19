package com.app.upe.myproject.mypokedexapi.utils;

public enum BuildStatusCode {
  // STATUS 2XX CODES
  OK(200),
  ACCEPTED(201),
  CREATED(202),


  // STATUS 4XX CODES
  BAD_REQUEST(400),
  UNAUTHORIZED(401),
  FORBIDDEN(403);
  
  private int value;

  BuildStatusCode(int value) {
    this.value = value;
  };

  public int getValue() {
    return this.value;
  }
}

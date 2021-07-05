package com.app.upe.myproject.mypokedexapi.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.app.upe.myproject.mypokedexapi.models.User;
import com.google.gson.Gson;

import java.util.stream.Collectors;

@WebServlet("/v1/auth")
public class AuthController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    Gson json = new Gson();
    User user = json.fromJson(reqBody, User.class);
    
    User.addUser(user);
    
    res.sendError(201, "User signed with success!");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Gson json = new Gson();
    String user = json.toJson(User.getUsers());
    

    res.getWriter().write(user);
  }
}

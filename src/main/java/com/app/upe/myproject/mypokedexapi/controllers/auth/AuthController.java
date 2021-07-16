package com.app.upe.myproject.mypokedexapi.controllers.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.repository.UserRepository;
import com.google.gson.Gson;

import java.util.stream.Collectors;

@WebServlet("/v1/auth")
public class AuthController extends HttpServlet {
  UserRepository userRepository = new UserRepository();
  Gson json = new Gson();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    User user = json.fromJson(reqBody, User.class);
    userRepository.add(user);
    
    String jsonUsers = json.toJson(userRepository.getAll());

    System.out.println("------------------------------------------------");
    System.out.println(jsonUsers);
    System.out.println("------------------------------------------------");
    
    res.sendError(201, "User registered with success!");


  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    User user = json.fromJson(reqBody, User.class);
    User foundUser = userRepository.find(user.getEmail());
    
    if (foundUser != null) {
      res.sendError(201, "User logged with success!!");
    } else {
      res.sendError(404, "Please check the email and password and try again");
    }

  }
}

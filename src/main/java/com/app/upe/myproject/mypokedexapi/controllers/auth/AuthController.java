package com.app.upe.myproject.mypokedexapi.controllers.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.repositories.UserRepository;
import com.app.upe.myproject.mypokedexapi.utils.StatusCodeEnum;
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
    try {
      userRepository.add(user);
      res.sendError(StatusCodeEnum.CREATED.getValue(), "User registered with success!");
    } catch (Exception e) {
      res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(), e.getMessage());
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    User user = json.fromJson(reqBody, User.class);
    User foundUser = userRepository.find(user.getEmail());
    
    if (foundUser != null) {
      res.sendError(StatusCodeEnum.ACCEPTED.getValue(), "User logged with success!!");
    } else {
      res.sendError(StatusCodeEnum.UNAUTHORIZED.getValue(), "Please check the email and password and try again");
    }

  }
}

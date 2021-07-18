package com.app.upe.myproject.mypokedexapi.controllers.user;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.repositories.UserRepository;
import com.app.upe.myproject.mypokedexapi.utils.StatusCodeEnum;
import com.google.gson.Gson;


@WebServlet("/v1/users")
public class UserDetailsController extends HttpServlet {
  UserRepository userRepository = new UserRepository();
  Gson json = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String id = req.getParameter("id");

    try {
      User user = userRepository.findById(id);
      String userToJson = json.toJson(user);

      res.getWriter().write(userToJson);
    } catch (Exception e) {
      res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(), e.getMessage());
    }

  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String id = req.getParameter("id");
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    User user = json.fromJson(reqBody, User.class);
    
    try {
      userRepository.update(id, user);

      res.sendError(StatusCodeEnum.CREATED.getValue(), "User infos was updated with success.");
    } catch (Exception e) {
      res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(), e.getMessage());
    }

  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String id = req.getParameter("id");

    try {
      userRepository.delete(id);
      
      res.sendError(StatusCodeEnum.CREATED.getValue(), "User was deleted with success.");
    } catch (Exception e) {
      res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(), e.getMessage());
    }
  }
}

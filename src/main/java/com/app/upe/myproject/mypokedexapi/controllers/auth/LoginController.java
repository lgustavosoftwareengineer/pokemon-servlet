package com.app.upe.myproject.mypokedexapi.controllers.auth;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.upe.myproject.mypokedexapi.models.auth.User;
import com.app.upe.myproject.mypokedexapi.repositories.UserRepository;
import com.app.upe.myproject.mypokedexapi.utils.EncryptPassword;
import com.app.upe.myproject.mypokedexapi.utils.StatusCodeEnum;
import com.google.gson.Gson;

@WebServlet("/v1/auth/login")
public class LoginController extends HttpServlet {
  UserRepository userRepository = new UserRepository();
  Gson json = new Gson();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    User userFromJson = json.fromJson(reqBody, User.class);
    User user = userRepository.find(userFromJson.getEmail());
    String ERROR_STRING = "Please check the email and password and try again";

    if (user == null) {
      res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(),ERROR_STRING);

    } else {
      boolean isPasswordsEquals = EncryptPassword.verifyPasswords(userFromJson.getPassword(), user.getPassword());

      if (!isPasswordsEquals) {
        res.sendError(StatusCodeEnum.BAD_REQUEST.getValue(),ERROR_STRING);
      }
      else {
        res.sendError(StatusCodeEnum.OK.getValue(), "User logged with success");
      }
    }
   
  }
}

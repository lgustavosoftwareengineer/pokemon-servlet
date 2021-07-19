package com.app.upe.myproject.mypokedexapi.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.upe.myproject.mypokedexapi.utils.JWTToken;
import com.app.upe.myproject.mypokedexapi.utils.StatusCodeEnum;


@WebFilter("/*")
public class AuthenticationFilter extends HttpFilter  {

  @Override
  public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    String Authorization = req.getHeader("Authorization");

    String path = req.getRequestURI();
    if (path.startsWith("/v1/auth/login")) {
      chain.doFilter(req, res); 
    } 
    else {
      if (Authorization == null) {
        System.out.println("-------------------------------");
        System.out.println("Authorization: " + Authorization);
        System.out.println("-------------------------------");
        res.sendError(StatusCodeEnum.FORBIDDEN.getValue(), "Please authenticate");
      } else {
        try {
          JWTToken.verifyJWTToken(Authorization);
          res.sendError(StatusCodeEnum.ACCEPTED.getValue(), "Authorization token is valid");
        } catch (Exception e) {
          res.sendError(StatusCodeEnum.FORBIDDEN.getValue(), e.getMessage());
        }
      }
    }
  }
    
}

 
  

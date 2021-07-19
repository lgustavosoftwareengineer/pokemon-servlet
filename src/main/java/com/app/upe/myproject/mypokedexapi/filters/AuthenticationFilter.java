package com.app.upe.myproject.mypokedexapi.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.upe.myproject.mypokedexapi.utils.BuildStatusCode;
import com.app.upe.myproject.mypokedexapi.services.*;


@WebFilter("/*")
public class AuthenticationFilter extends HttpFilter  {

  @Override
  public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    String Authorization = req.getHeader("Authorization");

    String path = req.getRequestURI();
    if (path.startsWith("/v1/auth/login") || path.startsWith("/v1/auth/register")) {
      chain.doFilter(req, res); 
    } 
    else {
      if (Authorization == null) {
        res.sendError(BuildStatusCode.FORBIDDEN.getValue(), "Please authenticate");
      } else {
        try {
          JWTTokenService.verifyJWTToken(Authorization);
          chain.doFilter(req, res);
        } catch (Exception e) {
          res.sendError(BuildStatusCode.FORBIDDEN.getValue(), e.getMessage());
        }
      }
    }
  }
    
}

 
  

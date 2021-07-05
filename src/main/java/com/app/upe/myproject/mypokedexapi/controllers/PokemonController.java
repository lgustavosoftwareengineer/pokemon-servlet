package com.app.upe.myproject.mypokedexapi.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.upe.myproject.mypokedexapi.models.Pokemon;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@WebServlet("/v1/pokemon")
public class PokemonController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    OkHttpClient client = new OkHttpClient();

    res.setContentType("application/json;charset=utf-8");
    String id = req.getParameter("id");
    String uri = "https://pokeapi.co/api/v2/pokemon/" + id;
    
    Request.Builder requestBuilder = new Request.Builder();
    requestBuilder.url(uri);
    requestBuilder.method("GET", null);  
    Request request = requestBuilder.build();

    try (Response response = client.newCall(request).execute()) {
      Gson json = new Gson();
      Pokemon pokemon = json.fromJson(response.body().string(), Pokemon.class);
      
      res.getWriter().write(json.toJson(pokemon));        
    }
  }
}

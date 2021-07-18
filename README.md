<p align="center">
   <img src="./.github/pokemon-logo.png" width="150"/>
</p>

<h1 align="center"> 🅿️ Pokedex-servlet-API</h1>

<p align="center">
	<a href="https://www.linkedin.com/in/luiz-gustavo-56146b1a5/">
      <img alt="Luiz Gustavo" src="https://img.shields.io/badge/-LuizGustavo-f43c2c?style=flat&logo=Linkedin&logoColor=white" />
   </a>
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/tonicprism/pokemon-servlet?color=f43c2c">

  <img src="https://img.shields.io/badge/version-1.0.0-f43c2c.svg?cacheSeconds=2592000" />
  <a href="https://github.com/tonicprism/pokemon-servlet/#readme">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-f43c2c.svg" target="_blank" />
  </a>
   <a href="https://github.com/tonicprism/pokemon-servlet/commits/master">
      <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/tonicprism/pokemon-servlet?color=f43c2c">
  </a>
   <a href="https://github.com/tonicprism/pokemon-servlet/stargazers">
      <img alt="Stargazers" src="https://img.shields.io/github/stars/tonicprism/pokemon-servlet?color=f43c2c&logo=github">
   </a>
</p>

> 🅿️ A servlet-API system made using Java which the purpose is simulate a pokedex system from the pokemon series.

#

# 📕 Endpoints

List of all the endpoints provided by the API.

> _PS: All endpoint with the **build emoji (🏗️)** is a endpoint still in development, therefore still isn't available to be used._

## 🔐 Authentication

### **Register**

Endpoint (POST): `/v1/auth/register`

> _Register the user passing `email`, `password`, `confirmPassword` and `username` in the body from the request._

### **Login**

Endpoint (POST): `/v1/auth/login`

> _Login the user passing `email` and `password` in the body from request. The login creates a user session returning a JWT token to be used in `Authorization` headers in requests._

### **🏗️ Logout**

Endpoint (DELETE): `/v1/auth/logout`

>

## 👱 User

### **Details user**

Endpoint (GET): `/v1/users`

> _Return user details by `id`. The format from the response is in JSON format._

Params:

- id: String

### **Update user infos**

Endpoint (PUT): `/v1/users`

> _Update user infos as `email`, `password` or `username`._

Params:

- id: String

### **Delete account**

Endpoint (DELETE): `/v1/users`

> _Delete the user account._

Params:

- id: String

## 🏗️ Pokedex

### **🏗️ Add a pokemon**

Endpoint (POST): ``

>

### **🏗️ Get all pokemons**

Endpoint (GET): ``

>

### **🏗️ Get all pokemons from wildland**

Endpoint (GET): ``

>

### **🏗️ Search a pokemon from wildland**

Endpoint (GET): ``

>

### 🏗️ Delete a pokemon

Endpoint (DELETE): ``

>

# ✌ Made with ❤️ by [Luiz Gustavo](https://github.com/tonicprism/)

Let one ⭐️ if this project helped you!

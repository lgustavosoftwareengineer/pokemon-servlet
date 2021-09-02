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

# Intruções para rodar o projeto

- Primeiro clone o projeto
- Depois [baixe e adicione o seguinte arquivo na raiz do projeto](https://drive.google.com/file/d/1_qRxeZb9myK3xQd8_OM6wzo9uEzzHt3A/view?usp=sharing)
- Altere o arquivo baixado a cima de acordo com as configurações do seu banco de dados:
  Estrutura do arquivo (`.env`):

  ```
  # Nome do banco de dados
  DATABASE_NAME = "pokedex"

  # Credenciais de acesso do banco de dados
  USER_NAME = "postgres"
  USER_PASSWORD = "Pokemon123!"

  # Tokens necessários para utilizar o bearer token
  # before be transformed using SHA256 algorithm was "pokemon-servelet-api"
  JWT-SECRET = "0531cee4683f3ba20ce71cb431ab3fbc2fefe364413b43a0d94af8035a59e0ee"
  JWT-ISSUER = "Pokemon-servelet-api"

  ```

- Crie o banco de dados e as tabelas (de acordo com o arquivo `models/auth/User.java`)

# 📕 Endpoints

List of all the endpoints provided by the API.

> _PS: All endpoint with the **build emoji (🏗️)** is a endpoint still in development, therefore still isn't available to be used._

## 🔐 Authentication

### **Register**

Endpoint (POST): `/v1/auth/register`

> _Register the user passing `email`, `password`, `confirmPassword` and `username` in the body from the request._

Response:

```json
{
  "timestamp": "2021-07-19T14:55:01.870+00:00",
  "status": 202,
  "error": "Accepted",
  "message": "User registered with success.",
  "path": "/v1/auth/register"
}
```

### **Login**

Endpoint (POST): `/v1/auth/login`

> _Login the user passing `email` and `password` in the body from request. The login creates a user session returning a JWT token to be used in `Authorization` headers in requests._

Response:

```json
{
  "timestamp": "2021-07-19T14:57:18.055+00:00",
  "status": 200,
  "error": "OK",
  "message": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJQb2tlbW9uLLNlcnZlbGV0LWFwaSIsImV4cCI6KVTyNjcwODQzOCwidXNlcklkIjoiNWM0MWRiOTUtOTVlMi00MzQ3LThiZmEtNGExZDFkNzllODAzIn0.Wo12qIJ-qVKIuN0UEZoyyAJ1-ZTuWzdm5nXflKM2cxU",
  "path": "/v1/auth/login"
}
```

## 👱 User

### **Details user**

Endpoint (GET): `/v1/users`

> _Return user details. The format from the response is in JSON format._

Params:

- id: String

Response:

```json
{
  "username": "Tester User",
  "email": "tester@test.com"
}
```

### **Update user infos**

Endpoint (PUT): `/v1/users`

> _Update user infos as `email`, `password` or `username`._

Params:

- id: String

Response:

```json
{
  "timestamp": "2021-07-19T14:51:53.267+00:00",
  "status": 202,
  "error": "Accepted",
  "message": "User infos was updated with success.",
  "path": "/v1/users"
}
```

### **Delete account**

Endpoint (DELETE): `/v1/users`

> _Delete the user account._

Params:

- id: String

Response:

```json
{
  "timestamp": "2021-07-19T14:53:05.483+00:00",
  "status": 202,
  "error": "Accepted",
  "message": "User was deleted with success.",
  "path": "/v1/users"
}
```

## 🏗️ Pokedex

### **🏗️ Add a pokemon**

Endpoint (POST): ``

>

### **🏗️ Get all pokemons**

Endpoint (GET): ``

>

### 🏗️ Delete a pokemon

Endpoint (DELETE): ``

>

### **🏗️ Get all pokemons from wildland**

Endpoint (GET): ``

>

### **🏗️ Search a pokemon from wildland**

Endpoint (GET): ``

>

# ✌ Made with ❤️ by [Luiz Gustavo](https://github.com/tonicprism/)

Let one ⭐️ if this project helped you!

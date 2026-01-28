// src/pages/Login.jsx
import React from "react";
import logo from "../assets/logo.png";
import "./Login.css";

export default function Login() {
  return (
    <div className="login-container">
      <img src={logo} alt="Logo" className="login-logo" />
      <h1>Bem-vindo ao JP Cred</h1>
      <form className="login-form">
        <input type="text" placeholder="Usuário" />
        <input type="password" placeholder="Senha" />
        <button type="submit">Entrar</button>
      </form>
    </div>
  );
}

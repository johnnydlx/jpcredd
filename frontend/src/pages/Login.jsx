import React, { useState } from "react";
import logo from "../assets/logo.png";
import "./Login.css";

export default function Login({ onLoginSuccess }) {
  const [cpf, setCpf] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro(""); // limpa erro antigo

    try {
      const res = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ cpf, senha }),
      });

      const data = await res.json();

      if (!res.ok) {
        setErro(data.error || "Erro desconhecido");
        return;
      }

      // Login bem-sucedido
      onLoginSuccess(data); // salva dados do usuário no App.jsx
    } catch (err) {
      setErro("Erro de conexão com o servidor");
      console.error(err);
    }
  };

  return (
    <div className="login-container">
      <img src={logo} alt="Logo" className="login-logo" />
      <h1>Bem-vindo ao JP Cred</h1>
      <form className="login-form" onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="CPF"
          value={cpf}
          onChange={(e) => setCpf(e.target.value)}
        />
        <input
          type="password"
          placeholder="Senha"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
        />
        <button type="submit">Entrar</button>
      </form>
      {erro && <p className="erro">{erro}</p>}
    </div>
  );
}

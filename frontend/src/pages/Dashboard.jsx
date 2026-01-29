import React from "react";
import "./Dashboard.css";

export default function Dashboard({ user }) {
  return (
    <div className="dashboard-container">
      <h1>Bem-vindo, {user.nome}</h1>
      <p>CPF: {user.cpf}</p>
      <p>ID do usuário: {user.id}</p>
      <p>Este é o seu dashboard!</p>
    </div>
  );
}

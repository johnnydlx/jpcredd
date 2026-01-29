import React, { useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";

function App() {
  const [user, setUser] = useState(null);

  return (
    <Routes>
      {/* Tela de login */}
      {!user && (
        <Route path="/" element={<Login onLoginSuccess={setUser} />} />
      )}

      {/* Dashboard só aparece quando user existe */}
      {user && (
        <Route path="/dashboard" element={<Dashboard user={user} />} />
      )}

      {/* Qualquer outra rota redireciona */}
      <Route path="*" element={<Navigate to={user ? "/dashboard" : "/"} />} />
    </Routes>
  );
}

export default App;

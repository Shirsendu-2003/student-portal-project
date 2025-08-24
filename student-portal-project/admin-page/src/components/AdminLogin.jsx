import React, { useState } from "react";
import axiosInstance from "../services/api";
import { useNavigate } from "react-router-dom";
import "./login.css";

export default function AdminLogin({ onLoginSuccess, onBack }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async () => {
    if (!email || !password) {
      setError("Email and password are required");
      return;
    }
    try {
      const response = await axiosInstance.post("/auth/login", {
        email,
        password,
      });

      const { token, admin } = response.data;

      // ✅ Save token, role, and admin details in localStorage
      localStorage.setItem("token", token);
      localStorage.setItem("role", "ADMIN"); 
      localStorage.setItem("admin", JSON.stringify(admin));

      onLoginSuccess();
      navigate("/admin-dashboard"); // optional: navigate to dashboard
    } catch (err) {
      console.error(err);
      setError(err.response?.data?.message || "Login failed");
    }
  };

  return (
    <div className="container">
      <h2 className="admin-log">🔐 Admin Login</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}

      <div className="input-group">
        <input
          className="input-con"
          type="email"
          placeholder="Admin Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>

      <div className="input-group">
        <input
          className="input-con"
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      <button onClick={handleLogin} className="loging">
        Login
      </button>

      <div>
        <button onClick={onBack} className="back-button">
          ⬅ Back
        </button>
      </div>
    </div>
  );
}

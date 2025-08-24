import React, { useState } from "react";
import axiosInstance from "../services/api";
import "./register.css";

export default function AdminCellRegister({ onRegisterSuccess, onBack }) {
  const [adminCell, setAdminCell] = useState({
    name: "",
    email: "",
    password: "",
  });
  const [error, setError] = useState("");
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setAdminCell({ ...adminCell, [e.target.name]: e.target.value });
  };

  const handleRegister = async () => {
    if (!adminCell.name || !adminCell.email || !adminCell.password) {
      setError("All fields are required");
      return;
    }

    try {
      const response = await axiosInstance.post("/auth/admincell/register", adminCell);
      setMessage(response.data?.message ||"✅ Registration successful! Please login.");
      setError("");
      onRegisterSuccess();
    } catch (err) {
      console.error(err);
      setError(err.response?.data?.message || "Registration failed");
    }
  };

  return (
    <div className="container">
      <h2 className="admin-log">🏫 Admin Cell Register</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {message && <p style={{ color: "green" }}>{message}</p>}

      <div className="input-group">
        <input
          className="input-con"
          type="text"
          name="name"
          placeholder="Full Name"
          value={adminCell.name}
          onChange={handleChange}
        />
      </div>

      <div className="input-group">
        <input
          className="input-con"
          type="email"
          name="email"
          placeholder="Email"
          value={adminCell.email}
          onChange={handleChange}
        />
      </div>

      <div className="input-group">
        <input
          className="input-con"
          type="password"
          name="password"
          placeholder="Password"
          value={adminCell.password}
          onChange={handleChange}
        />
      </div>

      <button onClick={handleRegister} className="loging">
        Register
      </button>

      <div>
        <button onClick={onBack} className="back-button">⬅ Back</button>
      </div>
    </div>
  );
}

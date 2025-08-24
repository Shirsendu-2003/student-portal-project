import { useState } from "react";
import axiosInstance from "../services/api";
import "./register.css";
export default function RegisterForm({ onRegisterSuccess }) {
  const [user, setUser] = useState({ name: "", email: "", password: "" });
  const handleRegister = async () => {
    try {
      await axiosInstance.post("/auth/register", user);
      alert("Registered successfully!");
      onRegisterSuccess();
    } catch {
      alert("Registration failed");
    }
  };
  return (
    <div className="p-4">
      {" "}
      <input
        placeholder="Name"
        onChange={(e) => setUser({ ...user, name: e.target.value })}
      />
      <br />{" "}
      <input
        placeholder="Email"
        onChange={(e) => setUser({ ...user, email: e.target.value })}
      />
      <br />{" "}
      <input
        type="password"
        placeholder="Password"
        onChange={(e) => setUser({ ...user, password: e.target.value })}
      />
      <br /> <button onClick={handleRegister}>Register</button>{" "}
    </div>
  );
}

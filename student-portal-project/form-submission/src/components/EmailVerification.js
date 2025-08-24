// EmailVerification.js
import React from "react";
import { useNavigate } from "react-router-dom";

export default function EmailVerification() {
  const navigate = useNavigate();

  const handleBackClick = () => {
    navigate("/"); // 🔁 replace with your actual route for submission page
  };

  return (
    <div style={{ textAlign: "center", padding: "9rem", }}>
      <h2>Thank You!</h2>
      <p>
        Your form has been submitted successfully. Please check your email to verify your account.
      </p>

      <button
        onClick={handleBackClick}
        style={{
          marginTop: "20px",
          padding: "10px 20px",
          fontSize: "16px",
          backgroundColor: "#4CAF50",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer"
        }}
      >
        Back to Submission Page
      </button>
    </div>
  );
}

import React from "react";

export default function Header() {
  return (
    <header
      style={{
        backgroundColor: "#004080",
        color: "#fff",
        padding: "1.5rem",
        display: "flex",
        alignItems: "center",
        justifyContent: "space-between",
        flexWrap: "wrap",
      }}
    >
      {/* Left: MCET Logo */}
      <div>
        <img
          src="https://www.mcetbhb.net/images/logo.svg"
          alt="MCET Logo"
          style={{ maxHeight: "100px", marginRight: "20px" }}
        />
      </div>

      {/* Center: College Info */}
      <div style={{ flex: 1, textAlign: "center", padding: "0 10px" }}>
        <h1 style={{ margin: "0", fontSize: "1.8rem" }}>
          Murshidabad College of Engineering & Technology
        </h1>
        <h3 style={{ margin: "5px 0", fontWeight: "normal" }}>
          A Center of Technological & Professional Excellence. ESTD : 1998
        </h3>
        <p style={{ margin: "5px 0", fontSize: "0.95rem" }}>
          Approved by AICTE | Affiliated to MAKAUT (WBUT) | Aided by Government of W. B. | Supported by Murshidabad Zilla Parishad (MZP)
        </p>
      </div>

      {/* Right: AICTE and MAKAUT Logos */}
      <div style={{ display: "flex", gap: "10px" }}>
        <img
          src="https://www.mcetbhb.net/images/organization-logo/aicte.png"
          alt="AICTE Logo"
          style={{ maxHeight: "50px" }}
        />
        <img
          src="https://www.mcetbhb.net/images/organization-logo/makaut.png"
          alt="MAKAUT Logo"
          style={{ maxHeight: "50px" }}
        />
      </div>
    </header>
  );
}

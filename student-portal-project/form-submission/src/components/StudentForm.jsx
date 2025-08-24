import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

export default function StudentForm() {
  const navigate = useNavigate();

  const initialState = {
    name: "",
    phone: "",
    email: "",
    courseChoices: {
      first: "",
      second: "",
      third: "",
      fourth: "",
    },
    source: "direct",
  };

  const [student, setStudent] = useState(initialState);
  const [loading, setLoading] = useState(false); // ✅ Track submit state

  // Capture ?src=facebook / whatsapp / instagram / youtube
  useEffect(() => {
    const params = new URLSearchParams(window.location.search);
    const src = params.get("src") || "direct";
    setStudent((prev) => ({ ...prev, source: src }));
  }, []);

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    if (["first", "second", "third", "fourth"].includes(name)) {
      setStudent((prev) => ({
        ...prev,
        courseChoices: {
          ...prev.courseChoices,
          [name]: value,
        },
      }));
    } else {
      setStudent((prev) => ({ ...prev, [name]: value }));
    }
  };

  // Reset form
  const handleReset = () => {
    setStudent(initialState);
  };

  // Submit form
  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true); // ✅ Start loading

    try {
      const response = await fetch("http://localhost:8081/api/students", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(student),
      });

      if (response.ok) {
        alert(`Student data submitted! Source: ${student.source}`);
        setStudent(initialState);
        navigate("/verify-email");
      } else {
        alert("Failed to submit student data.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("Server error occurred.");
    } finally {
      setLoading(false); // ✅ Stop loading
    }
  };

  const styles = {
    container: {
      maxWidth: "600px",
      margin: "2rem auto",
      padding: "20px",
      backgroundColor: "#f9f9f9",
      borderRadius: "10px",
      boxShadow: "0 4px 12px rgba(0,0,0,0.1)",
    },
    label: {
      fontWeight: "bold",
      marginBottom: "5px",
      display: "block",
      color: "#333",
    },
    input: {
      width: "100%",
      padding: "10px",
      borderRadius: "5px",
      border: "1px solid #ccc",
      fontSize: "1rem",
      marginBottom: "15px",
    },
    select: {
      width: "100%",
      padding: "10px",
      borderRadius: "5px",
      border: "1px solid #ccc",
      fontSize: "1rem",
      marginBottom: "15px",
    },
    button: {
      padding: "12px 24px",
      backgroundColor: "#004080",
      color: "white",
      border: "none",
      borderRadius: "5px",
      cursor: "pointer",
      fontSize: "1rem",
      marginRight: "10px",
    },
    resetButton: {
      backgroundColor: "#808080",
    },
  };

  const courseOptions = [
    "Computer Science & Engineering",
    "Electronics & Communication Engineering",
    "Civil Engineering",
    "Electrical Engineering",
  ];

  return (
    <div style={styles.container}>
      <h2 style={{ textAlign: "center", color: "#004080" }}>
        Student Course Preferences
      </h2>
      <form onSubmit={handleSubmit}>
        {/* Name */}
        <label style={styles.label}>Name:</label>
        <input
          type="text"
          name="name"
          value={student.name}
          onChange={handleChange}
          required
          style={{ ...styles.input, textTransform: "uppercase" }}
        />

        {/* Phone */}
        <label style={styles.label}>Phone Number:</label>
        <div style={{ display: "flex", alignItems: "center" }}>
          <span
            style={{
              padding: "9px",
              backgroundColor: "#eee",
              border: "1px solid #ccc",
              borderTopLeftRadius: "5px",
              borderBottomLeftRadius: "5px",
              fontSize: "1rem",
              marginBottom: "15px",
            }}
          >
            +91
          </span>
          <input
            type="tel"
            name="phone"
            value={student.phone}
            onChange={handleChange}
            pattern="[0-9]{10}"
            required
            placeholder="10-digit number"
            style={{
              ...styles.input,
              borderTopLeftRadius: 0,
              borderBottomLeftRadius: 0,
              marginBottom: "15px",
            }}
          />
        </div>

        {/* Email */}
        <label style={styles.label}>Email:</label>
        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          required
          style={{ ...styles.input, textTransform: "lowercase" }}
        />

        {/* Course Selections with unique filtering */}
        {["first", "second", "third", "fourth"].map((choice) => {
          // find all chosen courses
          const selectedCourses = Object.values(student.courseChoices);

          // filter available options for this dropdown
          const availableOptions = courseOptions.filter(
            (course) =>
              !selectedCourses.includes(course) ||
              student.courseChoices[choice] === course
          );

          return (
            <div key={choice}>
              <label style={styles.label}>
                {`${choice.charAt(0).toUpperCase() + choice.slice(1)} Choice`}
              </label>
              <select
                name={choice}
                value={student.courseChoices[choice]}
                onChange={handleChange}
                required
                style={styles.select}
              >
                <option value="">-- Choose a Course --</option>
                {availableOptions.map((course) => (
                  <option key={course} value={course}>
                    {course}
                  </option>
                ))}
              </select>
            </div>
          );
        })}

        {/* Buttons */}
        <div style={{ textAlign: "center", marginTop: "20px" }}>
          <button
            type="submit"
            style={styles.button}
            disabled={loading} // ✅ disable during submit
          >
            {loading ? "Submitting..." : "Submit"}
          </button>
          <button
            type="button"
            style={{ ...styles.button, ...styles.resetButton }}
            onClick={handleReset}
            disabled={loading} // ✅ prevent reset while submitting
          >
            Reset
          </button>
        </div>
      </form>
    </div>
  );
}

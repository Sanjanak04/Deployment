import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import logo from "../assets/anurag.png"; // ✅ import logo

function Login() {

  const [role, setRole] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const handleLogin = () => {

    if (!role) {
      alert("Please select role");
      return;
    }

    // ✅ Faculty Login
    if (role === "faculty") {
      if (username === "admin" && password === "admin123") {

        localStorage.setItem("role", "faculty");
        window.dispatchEvent(new Event("storage"));

        alert("Faculty Login Successful");
        navigate("/");

      } else {
        alert("Invalid Faculty Credentials");
      }
    }

    // ✅ Student Login
    else if (role === "student") {

      if (!username) {
        alert("Please enter Roll Number");
        return;
      }

      localStorage.setItem("role", "student");
      localStorage.setItem("rollNumber", username);
      window.dispatchEvent(new Event("storage"));

      alert("Student Login Successful");
      navigate("/search");
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ height: "100vh" }}>

      <div className="card shadow p-4 text-center" style={{ width: "350px", borderRadius: "15px" }}>

        {/* ✅ Logo */}
        <img
          src={logo}
          alt="Anurag University"
          style={{ width: "120px", margin: "0 auto 10px" }}
        />

        {/* ✅ University Name */}
        <h5 style={{ fontWeight: "bold", color: "#444" }}>
          ANURAG UNIVERSITY
        </h5>

        {/* ✅ Title */}
        <h4 className="mt-2 mb-3">Login</h4>

        {/* Role */}
        <select
          className="form-control mb-3"
          value={role}
          onChange={(e) => setRole(e.target.value)}
        >
          <option value="">Select Role</option>
          <option value="student">Student</option>
          <option value="faculty">Faculty</option>
        </select>

        {/* Username */}
        <input
          type="text"
          placeholder="Enter Username / Roll Number"
          className="form-control mb-3"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />

        {/* Password */}
        {role === "faculty" && (
          <input
            type="password"
            placeholder="Enter Password"
            className="form-control mb-3"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        )}

        {/* Button */}
        <button className="btn btn-primary w-100" onClick={handleLogin}>
          Login
        </button>

      </div>
    </div>
  );
}

export default Login;

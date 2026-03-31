import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

function Navbar() {

  const [role, setRole] = useState(localStorage.getItem("role") || "");
  const navigate = useNavigate();

  // ✅ Update navbar on login/logout
  useEffect(() => {
    const updateRole = () => {
      setRole(localStorage.getItem("role"));
    };

    window.addEventListener("storage", updateRole);

    return () => {
      window.removeEventListener("storage", updateRole);
    };
  }, []);

  // ✅ Logout
  const handleLogout = () => {
    localStorage.clear();
    setRole("");
    navigate("/login");
  };

  return (
    <nav className="navbar navbar-dark bg-dark navbar-expand-lg">
      <div className="container-fluid">

        {/* Logo / Title */}
        <span
          className="navbar-brand"
          style={{ cursor: "pointer" }}
          onClick={() => navigate("/")}
        >
          Exam Seating System
        </span>

        <div>

          {/* Home */}
          <Link className="btn btn-outline-light m-1" to="/">Home</Link>

          {/* FACULTY */}
          {role === "faculty" && (
            <>
              <Link className="btn btn-outline-light m-1" to="/upload">Upload</Link>
              <Link className="btn btn-outline-light m-1" to="/hall">Add Hall</Link>
              <Link className="btn btn-outline-light m-1" to="/allocate">Allocate</Link>
              <Link className="btn btn-outline-light m-1" to="/seating">View Seating</Link>
              <Link className="btn btn-outline-light m-1" to="/search">Search</Link>
            </>
          )}

          {/* STUDENT */}
          {role === "student" && (
            <Link className="btn btn-outline-light m-1" to="/search">Search</Link>
          )}

          {/* LOGIN / LOGOUT SAME STYLE */}
          {!role ? (
            <Link className="btn btn-warning m-1" to="/login">
              Login
            </Link>
          ) : (
            <button className="btn btn-warning m-1" onClick={handleLogout}>
              Logout
            </button>
          )}

        </div>
      </div>
    </nav>
  );
}

export default Navbar;

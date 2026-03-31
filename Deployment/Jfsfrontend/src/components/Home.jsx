import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";
import logo from "../assets/anurag.png";

function Home() {
  const navigate = useNavigate();
  const role = localStorage.getItem("role");

  // ✅ Redirect Faculty to Dashboard
  useEffect(() => {
    if (role === "faculty") {
      navigate("/dashboard");
    }
  }, [role, navigate]);

  return (
    <div className="container text-center mt-4">

      {/* ✅ University Logo */}
      <img src={logo} alt="Anurag University" className="uni-logo" />
      

      {/* ✅ Title */}
      <h1 className="mt-3">🎓 Exam Seating Allocation</h1>
      <p>Manage students, halls and seating easily</p>

      {/* ✅ STUDENT VIEW */}
      {role === "student" && (
        <div className="mt-4">
          <button
            className="btn btn-primary"
            onClick={() => navigate("/search")}
          >
            🔍 Search Your Seat
          </button>
        </div>
      )}

      {/* ✅ NOT LOGGED IN */}
      {!role && (
        <div className="mt-4">
          <button
            className="btn btn-warning"
            onClick={() => navigate("/login")}
          >
            Login to Continue
          </button>
        </div>
      )}

    </div>
  );
}

export default Home;


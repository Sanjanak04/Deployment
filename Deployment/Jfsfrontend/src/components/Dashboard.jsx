import React from "react";
import { useNavigate } from "react-router-dom";
import { FaUpload, FaSchool, FaChair, FaSearch } from "react-icons/fa";

function Dashboard() {
  const navigate = useNavigate();

  return (
    <div className="container mt-4">

      {/* ✅ College Name */}
      <div className="text-center mb-2">
        <h3 style={{ fontWeight: "bold", letterSpacing: "1px", color: "#5b0606" }}>
          ANURAG UNIVERSITY
        </h3>
      </div>

      {/* ✅ Main Title */}
      <div className="text-center mb-4">
        <h1 className="text-primary">
          🎓 Exam Seating Allocation
        </h1>
        <p className="lead">
          Manage students, halls and seating easily
        </p>
      </div>

      {/* ✅ Cards Section */}
      <div className="row g-4">

        {/* Upload Students */}
        <div className="col-md-3">
          <div
            className="card shadow text-center p-4"
            onClick={() => navigate("/upload")}
            style={{
              cursor: "pointer",
              borderRadius: "15px",
              transition: "0.3s"
            }}
          >
            <FaUpload size={45} color="blue" />
            <h5 className="mt-3">Upload Students</h5>
            <p className="text-muted">Import Excel file</p>
          </div>
        </div>

        {/* Add Hall */}
        <div className="col-md-3">
          <div
            className="card shadow text-center p-4"
            onClick={() => navigate("/hall")}
            style={{
              cursor: "pointer",
              borderRadius: "15px",
              transition: "0.3s"
            }}
          >
            <FaSchool size={45} color="green" />
            <h5 className="mt-3">Add Hall</h5>
            <p className="text-muted">Configure exam halls</p>
          </div>
        </div>

        {/* Allocate Seats */}
        <div className="col-md-3">
          <div
            className="card shadow text-center p-4"
            onClick={() => navigate("/allocate")}
            style={{
              cursor: "pointer",
              borderRadius: "15px",
              transition: "0.3s"
            }}
          >
            <FaChair size={45} color="red" />
            <h5 className="mt-3">Allocate Seats</h5>
            <p className="text-muted">Auto seating arrangement</p>
          </div>
        </div>

        {/* Search Student */}
        <div className="col-md-3">
          <div
            className="card shadow text-center p-4"
            onClick={() => navigate("/search")}
            style={{
              cursor: "pointer",
              borderRadius: "15px",
              transition: "0.3s"
            }}
          >
            <FaSearch size={45} color="purple" />
            <h5 className="mt-3">Search Student</h5>
            <p className="text-muted">Find seat by roll number</p>
          </div>
        </div>

      </div>

      {/* ✅ Footer (optional but nice UI) */}
      <div className="text-center mt-5 text-muted">
        <small>© 2026 Anurag University - Exam Seating System</small>
      </div>

    </div>
  );
}

export default Dashboard;

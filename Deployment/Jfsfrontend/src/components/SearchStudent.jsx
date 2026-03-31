import React, { useState } from "react";
import API from "../services/api";

function SearchStudent() {

  const [roll, setRoll] = useState("");
  const [result, setResult] = useState(null);

  const search = async () => {
    if (!roll) {
      alert("Please enter roll number");
      return;
    }

    try {
      const res = await API.get(`/seating/students/${roll}`);
      setResult(res.data);
    } catch (error) {
      console.error(error);
      alert("Student not found");
      setResult(null);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "80vh" }}>
      
      <div style={{ width: "400px" }}>

        {/* 🔍 Title */}
        <h3 className="text-primary text-center mb-3">
          🔍 Search Student Seat
        </h3>

        {/* 🔍 Search Card */}
        <div className="card shadow p-4" style={{ borderRadius: "15px" }}>
          
          <input
            type="text"
            className="form-control mb-3"
            placeholder="Enter Roll Number"
            value={roll}
            onChange={(e) => setRoll(e.target.value)}
          />

          <button className="btn btn-primary w-100" onClick={search}>
            Search
          </button>

        </div>

        {/* ✅ Result Card */}
        {result && (
          <div className="card mt-4 shadow p-3 text-center" style={{ borderRadius: "15px" }}>
            
            <h5 className="text-success mb-2">{result.studentName}</h5>

            <p><strong>Roll:</strong> {result.rollNumber}</p>
            <p><strong>Branch:</strong> {result.branch}</p>
            <p><strong>Hall:</strong> {result.hallName}</p>
            <p><strong>Row:</strong> {result.row}</p>
            <p><strong>Column:</strong> {result.col}</p>

          </div>
        )}

      </div>

    </div>
  );
}

export default SearchStudent;

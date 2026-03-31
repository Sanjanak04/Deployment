import React from "react";
import API from "../services/api";

function AllocateSeats() {

  const allocate = async () => {
    try {
      const res = await API.post("/seating/allocate");
      alert(res.data);
    } catch (error) {
      console.error(error);
      alert("Allocation failed. Please check data.");
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ height: "80vh" }}>
      
      <div className="card shadow p-4 text-center" style={{ width: "400px", borderRadius: "15px" }}>
        
        <h3 className="mb-3">Allocate Seats</h3>

        <p className="text-muted">
          Automatically assign students to available seats
        </p>

        <button className="btn btn-danger mt-3 w-100" onClick={allocate}>
          Allocate Now
        </button>

      </div>

    </div>
  );
}

export default AllocateSeats;


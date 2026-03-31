import React, { useState } from "react";
import API from "../services/api";

function AddHall() {
  const [hall, setHall] = useState({
    hallName: "",
    rows: "",
    columns: "",
    capacity: "",
  });

  const handleChange = (e) => {
    setHall({ ...hall, [e.target.name]: e.target.value });
  };

  const submit = async () => {
    await API.post("/halls", hall);
    alert("Hall Added");
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ height: "80vh" }}>
      
      <div className="card shadow p-4" style={{ width: "400px", borderRadius: "15px" }}>
        
        <h3 className="text-center mb-3">Add Hall</h3>

        <input
          className="form-control mb-2"
          name="hallName"
          placeholder="Hall Name"
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="rows"
          placeholder="Rows"
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          name="columns"
          placeholder="Columns"
          onChange={handleChange}
        />

        <input
          className="form-control mb-3"
          name="capacity"
          placeholder="Capacity"
          onChange={handleChange}
        />

        <button className="btn btn-success w-100" onClick={submit}>
          Add Hall
        </button>

      </div>

    </div>
  );
}

export default AddHall;

import React, { useEffect, useState } from "react";
import API from "../services/api";

function SeatingTable() {

  const [data, setData] = useState([]);

  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    const res = await API.get("/seating");
    setData(res.data);
  };

  return (
    <div>
      <h3>Seating Report</h3>

      <a href="http://localhost:8080/seating/pdf" className="btn btn-danger m-2">Download PDF</a>
      <a href="http://localhost:8080/seating/excel" className="btn btn-success m-2">Download Excel</a>

      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>Roll</th>
            <th>Branch</th>
            <th>Hall</th>
            <th>Row</th>
            <th>Col</th>
          </tr>
        </thead>

        <tbody>
          {data.map((s, i) => (
            <tr key={i}>
              <td>{s.studentName}</td>
              <td>{s.rollNumber}</td>
              <td>{s.branch}</td>
              <td>{s.hallName}</td>
              <td>{s.row}</td>
              <td>{s.col}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SeatingTable;


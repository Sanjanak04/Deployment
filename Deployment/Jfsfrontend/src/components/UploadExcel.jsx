import React, { useState } from "react";
import API from "../services/api";

function UploadExcel() {
  const [file, setFile] = useState(null);

  const upload = async () => {
    const formData = new FormData();
    formData.append("file", file);

    const res = await API.post("/excel/upload", formData);
    alert(res.data);
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ height: "80vh" }}>
      
      <div className="card p-4 shadow text-center" style={{ width: "400px" }}>
        
        <h3 className="mb-3">Upload Students Excel</h3>

        <input
          type="file"
          className="form-control"
          onChange={(e) => setFile(e.target.files[0])}
        />

        <button className="btn btn-primary mt-3" onClick={upload}>
          Upload
        </button>

      </div>

    </div>
  );
}

export default UploadExcel;

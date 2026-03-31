import React from "react";
import { BrowserRouter as Router, Routes, Route, BrowserRouter } from "react-router-dom";

import Home from "./components/Home";
import Login from "./components/Login";
import AddHall from "./components/AddHall";
import AllocateSeats from "./components/AllocateSeats";
import SearchStudent from "./components/SearchStudent";
import SeatingTable from "./components/SeatingTable";
import Navbar from "./components/Navbar";
import Dashboard from "./components/Dashboard";
import UploadExcel from "./components/UploadExcel";

function App() {
  return (
    <Router>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/hall" element={<AddHall />} />
        <Route path="/allocate" element={<AllocateSeats />} />
        <Route path="/search" element={<SearchStudent />} />
        <Route path="/seating" element={<SeatingTable />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/upload" element={<UploadExcel />} />
      </Routes>

    </Router>
  );
}

export default App;
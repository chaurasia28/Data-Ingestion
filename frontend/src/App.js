import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import CsvUpload from './components/CsvUpload';
import DataPreview from './components/DataPreview';
import InsertData from './components/InsertData';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/csv-upload" element={<CsvUpload />} />
        <Route path="/data-preview" element={<DataPreview />} />
        <Route path="/insert-data" element={<InsertData />} />
      </Routes>
    </Router>
  );
}

export default App;

import React from 'react';
import { Link } from 'react-router-dom'; // React Router for page navigation
import '../Styles/Home.css';

function Home() {
  return (
    <div className="home-container">
      <h1>Welcome to the Data Ingestion Tool</h1>
      <p>This tool allows you to upload CSV files, preview data, and insert data into ClickHouse.</p>
      <div className="home-buttons">
        <Link to="/csv-upload">
          <button className="home-button">CSV Upload</button>
        </Link>
        <Link to="/data-preview">
          <button className="home-button">Data Preview</button>
        </Link>
        <Link to="/insert-data">
          <button className="home-button">Insert Data</button>
        </Link>
      </div>
    </div>
  );
}

export default Home;

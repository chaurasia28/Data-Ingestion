import React, { useState } from 'react';
import axios from 'axios';
import '../Styles/DataPreview.css';

function DataPreview() {
  const [data, setData] = useState([]);
  const [message, setMessage] = useState('');

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/dataPreview');
      setData(response.data);
    } catch (error) {
      setMessage('Error fetching preview data');
      console.error(error);
    }
  };

  return (
    <div className="preview-container">
      <h2>Preview CSV Data</h2>
      <button onClick={fetchData}>Fetch Data</button>
      {message && <p>{message}</p>}
      <table>
        <thead>
          <tr>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
          </tr>
        </thead>
        <tbody>
          {data.length > 0 ? (
            data.map((row, index) => (
              <tr key={index}>
                <td>{row.column1}</td>
                <td>{row.column2}</td>
                <td>{row.column3}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="3">No data available</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default DataPreview;

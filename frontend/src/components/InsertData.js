// InsertData.js
import React from 'react';
import axios from 'axios';
import '../Styles/InsertData.css';

function InsertData() {
  const handleInsertData = async () => {
    try {
      const response = await axios.post('http://localhost:8080/insert-to-clickhouse');
      console.log(response.data);
    } catch (error) {
      console.error('Error inserting data:', error);
    }
  };

  return (
    <div className="insert-container">
      <h2>Insert Data into ClickHouse</h2>
      <button onClick={handleInsertData}>Insert Data</button>
    </div>
  );
}

export default InsertData;

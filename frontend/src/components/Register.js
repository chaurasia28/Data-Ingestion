import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../Styles/Register.css';

function Register() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch('http://localhost:8080/auth', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });

      if (res.ok) {
        setMessage('Registration successful! Redirecting to login...');
        setTimeout(() => navigate('/login'), 1500);
      } else {
        const errorText = await res.text();
        setMessage('Registration failed: ' + errorText);
      }
    } catch (err) {
      setMessage('Server error! ' + err.message);
    }
  };

  return (
    <div className="container">
      <h2>Register</h2>
      {message && <div className="alert">{message}</div>}
      <form onSubmit={handleSubmit}>
        <label>Username:</label>
        <input type="text" name="username" required onChange={handleChange} />

        <label>Password:</label>
        <input type="password" name="password" required onChange={handleChange} />

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../Styles/Login.css';

function Login() {
  const [formData, setFormData] = useState({ username: '', password: '' });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });

      if (res.ok) {
        const token = await res.text();
        localStorage.setItem('token', token);
        navigate('/home');
      } else {
        setError('Invalid username or password!');
      }
    } catch (err) {
      setError('Server error!');
    }
  };

  return (
    <div className="container">
      <h2>Login</h2>
      {error && <div className="alert alert-danger">{error}</div>}
      <form onSubmit={handleSubmit}>
        <label>Username:</label>
        <input type="text" name="username" required onChange={handleChange} />

        <label>Password:</label>
        <input type="password" name="password" required onChange={handleChange} />

        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;

import "./index.css";
import React from "react";
import { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import http from "../../Service/httpService";
const apiEndpoint = "http://localhost:8080/";
function Login(props) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  let navigate = useNavigate();

  const handleEmail = (event) => {
    setEmail(event.target.value);
  };
  const handlePassword = (event) => {
    setPassword(event.target.value);
  };
  const handleSubmit = async (event) => {
    event.preventDefault();
    const input = {
      email: email,
      password: password,
    };

    try {
      const { data } = await http.post(apiEndpoint + "login", input, {
        headers: { "Content-Type": "application/json" },
      });
      console.log(data);
    } catch (error) {
      if (error.response && error.response.status <= 400) {
        alert(error.response);
      }
    }

    navigate("/forgetpassword");
  };
  return (
    <div class='grid-container'>
      <div class='grid-item1'></div>
      <div class='grid-item2'>
        <div class='admin_login'>
          <form onSubmit={handleSubmit}>
            <h1>ADMIN LOGIN</h1>Please Sign in to Continue !<br />
            <br />
            <br />
            <div class='admin_login_email'>
              <label htmlFor={email}>Email:</label>
              <input
                value={email}
                type='text'
                id='email'
                onChange={handleEmail}
              />
            </div>
            <div>
              <label htmlFor={password}>Password:</label>
              <input
                value={password}
                type='password'
                id='password'
                onChange={handlePassword}
              />

              <br />
              <br />
              <NavLink to='/forgetpassword'>Forget Password?</NavLink>
              <br />
            </div>
            <button type='submit' id='admin_login_submit'>
              Login
            </button>
            <br />
            <br />
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;

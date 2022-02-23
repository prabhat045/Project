import React from 'react';
import validate from './validateInfo';
import useForm from './useForm';
import './Form.css';
const FormSignup = ({ submitForm }) => {
  const { handleChange, handleSubmit, values, errors } = useForm(
    submitForm,
    validate
  );
  return (
    <div className='form-content-right'>
      <form onSubmit={handleSubmit} className='form' noValidate>
        <h1> FORGET PASSWORD ??</h1>
        <div className='form-inputs'>
          <input className='form-input' type='text' name='username' placeholder='Enter your Email ID' value={values.username} 
          onChange={handleChange}/>
          {errors.username && <p>{errors.username}</p>}
        </div>
        <button className='form-input-btn' type='submit'> Login Again </button>
      </form>
    </div>
  );
};
export default FormSignup;
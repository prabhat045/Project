import http from "../../Service/httpService";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
const apiEndpoint = "http://localhost:8080/";

const useForm = (callback, validate) => {
  let navigate = useNavigate();
  const [values, setValues] = useState({
    username: "",
    email: "",
    // mobileNo: "",
    mobileNo: "",
    password: "",
    password2: "",
  });
  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    console.log(name, value);
    console.log(e);
    setValues({
      ...values,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrors(validate(values));
    setIsSubmitting(true);
    const input = {
      email: values.email,
      password: values.password,
      username: values.username,
      mobileNumber: values.mobileNo,
    };
    console.log(input);
    try {
      const { data } = await http.post(apiEndpoint + "signup", input, {
        headers: { "Content-Type": "application/json" },
      });
      console.log(data);
    } catch (error) {
      if (error.response && error.response.status <= 400) {
        alert(error.response);
      }
    }

    navigate("/adminlogin");
  };

  useEffect(() => {
    if (Object.keys(errors).length === 0 && isSubmitting) {
      callback();
    }
  }, [errors]);

  return { handleChange, handleSubmit, values, errors };
};

export default useForm;

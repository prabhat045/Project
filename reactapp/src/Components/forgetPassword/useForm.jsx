import { useNavigate } from "react-router-dom";
import http from "../../Service/httpService";
import { useState, useEffect } from "react";
const apiEndpoint = "http://localhost:8080/";

const useForm = (callback, validate) => {
  let navigate = useNavigate();
  const [values, setValues] = useState({
    email: "",
  });
  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({
      ...values,
      [name]: value,
    });
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrors(validate(values));
    setIsSubmitting(true);
    console.log(values);
    try {
      const { data } = await http.post(
        apiEndpoint + "forgetpassword?email=" + values.email + "&",
        {
          headers: { "Content-Type": "application/json" },
        }
      );
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

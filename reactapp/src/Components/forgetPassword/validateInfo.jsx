export default function validateInfo(values) {
    let errors = {};
    if (!values.username) {
      errors.email = 'Email required';
    } else if (!/\S+@\S+\.\S+/.test(values.email)) {
      errors.email = 'Email address is invalid';
    }
    return errors;
  }
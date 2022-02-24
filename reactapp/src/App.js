import ForgetPassword from "./Components/forgetPassword/Form";
import { Route, Routes } from "react-router";
import AdminLogin from "./Components/AdminLogin/Login";
import Signup from "./Components/Signup/Form";
function App() {
  return (
    <div className='App'>
      <Routes>
        <Route path='/adminlogin' element={<AdminLogin />}></Route>
        <Route path='/forgetpassword' element={<ForgetPassword />}></Route>
        <Route path='/signup' element={<Signup />}></Route>
      </Routes>
    </div>
  );
}

export default App;

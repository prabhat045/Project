import ForgetPassword from "./Components/forgetPassword/Form";
import { Route, Routes } from "react-router";
import AdminLogin from "./Components/AdminLogin/Login";
function App() {
  return (
    <div className='App'>
      <Routes>
        <Route path='/adminlogin' element={<AdminLogin />}></Route>
        <Route path='/forgetpassword' element={<ForgetPassword />}></Route>
      </Routes>
    </div>
  );
}

export default App;

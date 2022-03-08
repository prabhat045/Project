import ForgetPassword from "./Components/forgetPassword/Form";
import { Route, Routes } from "react-router";
import AdminLogin from "./Components/AdminLogin/Login";
import Signup from "./Components/Signup/Form";
import Cart from "./Components/Cart/Cart";
function App() {
  return (
    <div className='App'>
      <Routes>
        <Route path='/adminlogin' element={<AdminLogin />}></Route>
        <Route path='/forgetpassword' element={<ForgetPassword />}></Route>
        <Route path='/signup' element={<Signup />}></Route>
        <Route path='/cart' element={<Cart />}></Route>
      </Routes>
    </div>
  );
}

export default App;

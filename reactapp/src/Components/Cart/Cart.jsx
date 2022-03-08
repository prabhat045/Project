import React, { createContext, useEffect } from "react";
import { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import "./cart.css";
import Items from "./Items";
import http from "../../Service/httpService";
const apiEndpoint = "http://localhost:8080/";

function Cart() {
  const [incrementquantity, setIncrementquantity] = useState("");
  const [price, setPrice] = useState("");
  const [cartItems, setCartItems] = useState([]);
  let navigate = useNavigate();
  useEffect(() => {
    async function fetchCart() {
      try {
        const { data } = await http.get(apiEndpoint + "cart", {
          headers: { "Content-Type": "application/json" },
        });
        setCartItems([...data]);
      } catch (error) {
        if (error.response && error.response.status <= 400) {
          alert(error.response);
        }
      }
    }
    fetchCart();
  }, []);

  const handlequantity = (event) => {
    setIncrementquantity(event.target.value);
  };
  const handlePrice = (event) => {
    setPrice(event.target.value);
  };
  const handleDelete = async (event) => {
    event.preventDefault();

    try {
      const { cartItems } = await http.delete(apiEndpoint + "cartdelete", {
        headers: { "Content-Type": "application/json" },
      });
      // console.log("deletedata", data1);
    } catch (error) {
      if (error.response && error.response.status <= 400) {
        alert(error.response);
      }
    }
  };
  const handleSubmit = async (event) => {
    event.preventDefault();

    // navigate("/forgetpassword");
  };
  return (
    <div>
      <header>
        <div className='continue-shopping'>
          {console.log(cartItems)}
          <img src='./images/arrow.png' alt='arrow' className='arrow-icon' />
          <h3>continue shopping</h3>
        </div>

        <div className='cart-icon'>
          <img src='./images/cart.png' alt='cart' />
          <p></p>
        </div>
      </header>

      <section className='main-cart-section'>
        <h1>shopping Cart</h1>
        <p className='total-items'>
          you have <span className='total-items-count'> </span> items in
          shopping cart
        </p>

        <div className='cart-items'>
          <div className='cart-items-container'>
            {cartItems.map((item) => (
              <Items
                cartItems={item}
                key={item.id}
                onQuantityChange={handlequantity}
                onDelete={handleDelete}
                onPriceChange={handlePrice}
                onSubmit={handleSubmit}
              />
            ))}
            ;
          </div>
        </div>

        <div className='card-total'>
          <h3>
            Cart Total : <span>₹</span>
          </h3>
          <button>checkout</button>
          <button className='clear-cart'>Clear Cart</button>
        </div>
      </section>
    </div>
  );
}

export default Cart;

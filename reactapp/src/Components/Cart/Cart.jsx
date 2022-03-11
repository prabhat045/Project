import React, { createContext, useEffect } from "react";
import { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import "./cart.css";
import Items from "./Items";
import http from "../../Service/httpService";
const apiEndpoint = "http://localhost:8080/";

function Cart() {
  const [incrementquantity, setIncrementquantity] = useState(1);
  const [price, setPrice] = useState();
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

  var total = 0;

  useEffect(() => {
    cartItems.forEach((e) => {
      total = total + e.price * e.quantity;
    });
    setPrice(total);
  }, [cartItems]);

  // console.log(total);

  const incrementCounter = (item) => {
    const items = [...cartItems];
    const index = items.indexOf(item);
    items[index].quantity = items[index].quantity + 1;
    console.log(items[index].quantity);
    setCartItems(items);
  };
  let decrementCounter = (item) => {
    const items = [...cartItems];
    const index = items.indexOf(item);
    if (items[index].quantity > 1)
      items[index].quantity = items[index].quantity - 1;
    console.log(items[index].quantity);
    setCartItems(items);
  };

  // const handlePrice = (event) => {
  //   setPrice(event.target.value);
  // };
  const handleDelete = async (item) => {
    console.log("Event", item.id);
    // event.preventDefault();
    try {
      const { data } = await http.delete(
        apiEndpoint + "cartdelete/" + item.id,
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
    const items = cartItems.filter((m) => m.id !== item.id);
    console.log(items);
    setCartItems(items);
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
          <p>{cartItems.length}</p>
        </div>
      </header>

      <section className='main-cart-section'>
        <h1>shopping Cart</h1>
        <p className='total-items'>
          you have{" "}
          <span className='total-items-count'> {cartItems.length}</span> items
          in shopping cart
        </p>

        <div className='cart-items'>
          <div className='cart-items-container'>
            {cartItems.map((item) => (
              <Items
                cartItems={item}
                key={item.id}
                onDelete={() => handleDelete(item)}
                // onPriceChange={handlePrice}
                onSubmit={handleSubmit}
                onClickAdd={() => incrementCounter(item)}
                onClickMinus={() => decrementCounter(item)}
                incrementquantity={incrementquantity}
              />
            ))}
            ;
          </div>
        </div>

        <div className='card-total'>
          <h3>
            Cart Total : <span>${price}</span>
          </h3>
          <button>checkout</button>
          <button className='clear-cart'>Clear Cart</button>
        </div>
      </section>
    </div>
  );
}

export default Cart;

import React, { useContext, useEffect } from "react";
import { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";

import http from "../../Service/httpService";
const apiEndpoint = "http://localhost:8080/";
function Items({
  cartItems,

  onDelete,
  onClickAdd,
  incrementquantity,
  onClickMinus,
}) {
  return (
    <>
      <div className='items-info'>
        <div className='product-img'></div>

        <div className='title'>
          <h2>{cartItems.product}</h2>
          <p></p>
        </div>

        <div className='add-minus-quantity'>
          <i className='fas fa-minus minus' onClick={onClickMinus}></i>
          <input type='text' value={cartItems.quantity} />
          <i className='fas fa-plus add' onClick={onClickAdd}></i>
        </div>

        <div className='price'>
          <h3>${cartItems.price}</h3>
        </div>

        <div className='remove-item'>
          <i className='fas fa-trash-alt remove' onClick={onDelete}></i>
        </div>
      </div>

      <hr />
    </>
  );
}

export default Items;

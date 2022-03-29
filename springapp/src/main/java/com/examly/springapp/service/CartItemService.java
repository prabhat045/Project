//package main.java.com.examly.springapp.service;
//
//import main.java.com.examly.springapp.model.CartItem;
//import main.java.com.examly.springapp.model.ShoppingCart;
//import main.java.com.examly.springapp.repository.CartItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CartItemService {
//
//   @Autowired
//   private CartItemRepository cartItemRepository;
//
//  public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart){
//     return cartItemRepository.findByShoppingCart(shoppingCart);
//  }
////  public CartItem updateCartItem(CartItem cartItem)
////  {
////      BigDecimal bigDecimal = new BigDecimal(cartItem.getProduct().getPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
////      bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
////      cartItem.setSubtotal(bigDecimal);
////      cartItemRepository.save(cartItem);
////      return  cartItem;
////
////  }
//
//}

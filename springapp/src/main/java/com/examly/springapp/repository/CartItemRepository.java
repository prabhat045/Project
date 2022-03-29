package main.java.com.examly.springapp.repository;

import main.java.com.examly.springapp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
//    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
//    CartItem updateCartItem(CartItem cartItem);



}

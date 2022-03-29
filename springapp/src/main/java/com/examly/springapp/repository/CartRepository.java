package main.java.com.examly.springapp.repository;

import main.java.com.examly.springapp.model.Cart;
import main.java.com.examly.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository <Cart,Integer> {
List<Cart> findCartByid(Integer id);
public List<Cart> findByUser(User user);
//public Cart findByUserAndProduct(User user, Product  product);
//@Query(value = "insert into Cart (quantity, price, product) VALUES (?1, ?2)", nativeQuery = true)
//public String insert(String quantity, CartItem item);








}

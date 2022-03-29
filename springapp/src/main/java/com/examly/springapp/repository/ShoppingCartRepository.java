package main.java.com.examly.springapp.repository;

import main.java.com.examly.springapp.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
  ShoppingCart findBySessionToken(String sessionToken);

}

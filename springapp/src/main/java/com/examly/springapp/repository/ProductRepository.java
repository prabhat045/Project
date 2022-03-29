package main.java.com.examly.springapp.repository;

import main.java.com.examly.springapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
//  @Query("Select p.price,p.productName FROM Product p where p.id =?1")
//  public Product findBy(Integer id);

public Product getProductById(Long id);


}
//@Query("SELECT u FROM User u WHERE u.email = ?1")
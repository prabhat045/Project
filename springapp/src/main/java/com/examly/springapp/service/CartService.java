package main.java.com.examly.springapp.service;

import main.java.com.examly.springapp.model.Cart;
import main.java.com.examly.springapp.model.User;
import main.java.com.examly.springapp.repository.CartRepository;
import main.java.com.examly.springapp.repository.ProductRepository;
import main.java.com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;






//
//    public Cart add(int id)
//    {
//
//
//   Cart cart =  productService.getProductById(id);
//
////    System.out.println( productService.getProductById(id));
//    return cart;



//        return cartRepository.insert(Quantity,cartItem);

//       }

//    public String addToCart(String Quantity,String id,User user){
//
//        String addedQuantity = Quantity;
//     int id1 = Integer.parseInt(id);
//    Product product = productRepository.findById(id1);
//      cartRepository.findbyUserAndProduct(user,product);
//        return  addedQuantity;
//    }


    public List<Cart> ListCart(User user)
   {
     return cartRepository.findByUser(user);
   }
   public void SaveCart(Cart cart)
    {
        cartRepository.save(cart);
    }

    public boolean doesProductExists(Cart cart) {
        for (Cart x : cartRepository.findAll()) {
            if ((x.getProduct().equals(cart.getProduct()))) {
                System.out.println("Success");
                return true;
            }
        }
        return false;
    }

    public List<Cart> getCart()
    {
       return cartRepository.findAll();
    }

    public List<Cart> showCart (Integer cartId) throws Exception {
        List<Cart> carts = cartRepository.findCartByid(cartId);
        if(carts.isEmpty())
            throw new Exception("Empty cart");
        else
        return carts;
    }

    public List<Cart> listCartItems(User user)
    {
        return cartRepository.findByUser(user);
    }




}

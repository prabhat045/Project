package main.java.com.examly.springapp.controller;

import main.java.com.examly.springapp.model.Cart;
import main.java.com.examly.springapp.service.CartService;
import main.java.com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

//    @GetMapping("/cart")
//    public String showCart(Model model, @AuthenticationPrincipal Authentication authentication){
//
//        return "cart";
//    }
@RequestMapping(value = "/cart", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public ResponseEntity<Object> addToCart(@RequestBody Cart cart ) {
    if (cartService.doesProductExists(cart))
    {
            return new ResponseEntity<>("false", HttpStatus.OK);
    }
    else
    {
        cartService.SaveCart(cart);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
    }
//    @RequestMapping(value= "/addToCart", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public void showCart(@RequestBody int id)
//       {
//
//           cartService.add(id);
//
//
//       }



    @GetMapping("/cart")
     public List<Cart> getProduct()
     {
     List<Cart> carts = cartService.getCart();
     return carts;
     }

    @GetMapping("/cart/{cartId}")
    public List<Cart> getCart(@PathVariable String cartId) throws Exception {
        int cartId1 = Integer.parseInt(cartId);
        return cartService.showCart(cartId1);
    }







}

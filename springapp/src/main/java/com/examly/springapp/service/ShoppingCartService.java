package main.java.com.examly.springapp.service;

import main.java.com.examly.springapp.model.CartItem;
import main.java.com.examly.springapp.model.Product;
import main.java.com.examly.springapp.model.ShoppingCart;
import main.java.com.examly.springapp.repository.CartItemRepository;
import main.java.com.examly.springapp.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
     private CartItemRepository cartItemRepository;


    public ShoppingCart addShoppingCartFirstTime(long id, String sessionToken, int qty) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(qty);
        cartItem.setProduct(productService.getProductById(id));
        shoppingCart.getItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart addToExistingShoppingCart(long id, String sessionToken, int qty) {
        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        Product p = productService.getProductById(id);
        boolean productDoesExistInTheCart = false;
        if (shoppingCart != null) {
            Set<CartItem> items = shoppingCart.getItems();
            for (CartItem item : items) {
                System.out.println(item.getProduct().getId());
                if (item.getProduct().equals(p)) {
                    productDoesExistInTheCart = true;
                    item.setQuantity(item.getQuantity() + qty);
                    shoppingCart.setItems(items);
                    return shoppingCartRepository.saveAndFlush(shoppingCart);
                }

            }
        }
        if(!productDoesExistInTheCart && (shoppingCart != null))
        {
            CartItem cartItem1 = new CartItem();
            cartItem1.setQuantity(qty);
            cartItem1.setProduct(p);
            shoppingCart.getItems().add(cartItem1);
            return shoppingCartRepository.saveAndFlush(shoppingCart);
        }

        return this.addShoppingCartFirstTime(id, sessionToken, qty);

    }

    public ShoppingCart getShoppingCartBySessionTokent(String sessionToken) {

        return  shoppingCartRepository.findBySessionToken(sessionToken);
    }

    public ShoppingCart removeCartIemFromShoppingCart(Long id, String sessionToken) {
        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        Set<CartItem> items = shoppingCart.getItems();
        CartItem cartItem = null;
        for(CartItem item : items) {
            if(item.getId()==id) {
                cartItem = item;
            }
        }
        items.remove(cartItem);
        cartItemRepository.delete(cartItem);
        shoppingCart.setItems(items);
        return shoppingCartRepository.save(shoppingCart);
    }

    public void clearShoppingCart(String sessionToken) {
        ShoppingCart sh = shoppingCartRepository.findBySessionToken(sessionToken);
        shoppingCartRepository.delete(sh);

    }



//        CartItem cartItem = new CartItem();
//        cartItem.setQuantity(qty);
//        cartItem.setProduct(p);
//        shoppingCart.getItems().add(cartItem);
//        return  shoppingCartRepository.save(shoppingCart);

    }


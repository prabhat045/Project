package main.java.com.examly.springapp.controller;

import main.java.com.examly.springapp.model.ShoppingCart;
import main.java.com.examly.springapp.service.ProductService;
import main.java.com.examly.springapp.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class ShoppingCartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/addtocart")
    public String addtoCart(HttpServletRequest request, Model model, @RequestParam("id") Long id, @RequestParam("qty") int qty)
    {
        //session token
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken==null)
        {
            sessionToken= UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken",sessionToken);
            shoppingCartService.addShoppingCartFirstTime(id,sessionToken,qty);
        }
        else
        {
            shoppingCartService.addToExistingShoppingCart(id,sessionToken,qty);
        }
        return "Item added to cart";
    }

    @GetMapping("/shoppingCart")
    public String showShoppingCartView(HttpServletRequest request, Model model) {
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken==null)
        {
            new ShoppingCart();
        }
        else
        {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionTokent(sessionToken);

        }

    }

    @GetMapping("/removeCartItem/{id}")
    public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
        System.out.println("got here ");
        shoppingCartService.removeCartIemFromShoppingCart(id,sessionToken);
        return "redirect:/shoppingCart";
    }

    @GetMapping("/clearShoppingCart")
    public String clearShoopiString(HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
        request.getSession(false).removeAttribute("sessiontToken");
        shoppingCartService.clearShoppingCart(sessionToken);
        return "redirect:/shoppingCart";
    }






    //    @Autowired
//    private UserService userService;

//    @Autowired
//    private CartItemService cartItemService;
//
//    @Autowired
//    private ShoppingCartService shoppingCartService;
//
//    @RequestMapping("/cart")
//    public String shoppingCart(Model model, Principal principal)
//    {
//        User user = userService.findByUsername(principal.getName());
//        ShoppingCart shoppingCart = user.getShoppingCart();
//
//        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
//
//        shoppingCartService.updateShoppingCart(shoppingCart);
//
//        return  "shoppingCart";
//
//    }
}

package main.java.com.examly.springapp.controller;

import main.java.com.examly.springapp.model.Product;
import main.java.com.examly.springapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //api
//add
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/admin/addProduct")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    //view
    @GetMapping("/product/{id}")
    public Product findProductByID(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/home")
    public List<Product> findAllProductsHome(){
        return productService.getProducts();
    }

    @GetMapping("/admin")
    public List<Product> findAllProductsAdmin(){
        return productService.getProducts();
    }

    //delete
    @DeleteMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product Removed";
    }

    @DeleteMapping("/multideleteProduct")
    public String deleteSomeProduct(@RequestBody List<Long> ids){
        for(Long id : ids){
            productService.deleteProduct(id);
        }
        return "Products Removed";
    }

    //update
    @PutMapping("/admin/productEdit/{id}")
    public Product updateProduct(@PathVariable Long id) {
        return productService.updateProduct(id);
    }


}
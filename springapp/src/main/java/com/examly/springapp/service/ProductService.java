package main.java.com.examly.springapp.service;

import main.java.com.examly.springapp.model.Product;
import main.java.com.examly.springapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

//service methods
//add

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //view
    public Product getProductById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    //delete
    public void deleteProduct(Long id){
        repository.deleteById(id);

    }

    //update
    public Product updateProduct(Long id) {
        Product existingProduct = repository.findById(id).orElse(null);
        Product product = repository.findById(id).orElse(null);
        existingProduct.setStatus(product.getStatus());
        existingProduct.setStock(product.getStock());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
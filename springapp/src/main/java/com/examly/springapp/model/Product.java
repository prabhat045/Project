package main.java.com.examly.springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product{


    //tables

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name")
    private String productName;

    @Column(name="image")
    private String image;

    @Column(name="price")
    private double price;

    @Column(name="stock")
    private int stock;

    @Column(name="status")
    private String status;

//     @OneToMany(mappedBy = "product")
//     @JsonIgnore
//     private List<ProductToCartItem> productToCartItemList;
//
//    public List<ProductToCartItem> getProductToCartItemList() {
//        return productToCartItemList;
//    }
//
//    public void setProductToCartItemList(List<ProductToCartItem> productToCartItemList) {
//        this.productToCartItemList = productToCartItemList;
//    }
//Constructor

    public Product(){}
    public Product(String productName,String image,Double price,int stock,String status){
        this.productName = productName;
        this.image=image;
        this.price = price;
        this.stock = stock;
        this.status=status;
    }

    //setter method

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String productName){
        this.productName = productName;
    }

    public void setDate(String image){
        this.image = image;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setStatus(String status){
        this.status = status;
    }


    //getter method


    public Long getId() {
        return   this.id;
    }

    public String getProductName(){
        return this.productName;
    }

    public String getImage(){
        return this.image;
    }

    public int getStock(){
        return this.stock;
    }

    public double getPrice(){
        return this.price;
    }

    public String getStatus(){
        return this.status;
    }

}

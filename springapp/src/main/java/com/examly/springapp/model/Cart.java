package main.java.com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

@Table(name ="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    @OneToOne
    @JoinColumn(name="user_id")
    private  User user;



    //    @ManyToOne
//    @JoinColumn(name="product_id")
//    private Product product;
//    @Column(name="product")
//    private String product;

    @Column(name="price")
    private String price;

    @Column(name="quantity")
    private int quantity;
    public Cart(){}

    public Cart(Product product, User user, String price, int quantity) {
        this.product = product;
        this.user = user;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

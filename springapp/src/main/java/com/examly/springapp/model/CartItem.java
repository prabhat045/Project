package main.java.com.examly.springapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cartitem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //    private BigDecimal subtotal;
//    @OneToOne
//    private Product product;
//    @OneToMany(mappedBy = "cartItem" )
//    @JsonIgnore
//    private List<ProductToCartItem> bookToCartItemList;
//    @ManyToOne
//    @JoinColumn(name = "shopping_cart_id")
//    private ShoppingCart shoppingCart;
//    public int getQuantity() {
//        return quantity;
//    }
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//    public BigDecimal getSubtotal() {
//        return subtotal;
//    }
//    public void setSubtotal(BigDecimal subtotal) {
//        this.subtotal = subtotal;
//    }
//    public Product getProduct() {
//        return product;
//    }
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//    public List<ProductToCartItem> getBookToCartItemList() {
//        return bookToCartItemList;
//    }
//    public void setBookToCartItemList(List<ProductToCartItem> bookToCartItemList) {
//        this.bookToCartItemList = bookToCartItemList;
//    }
//    public ShoppingCart getShoppingCart() {
//        return shoppingCart;
//    }
//    public void setShoppingCart(ShoppingCart shoppingCart) {
//        this.shoppingCart = shoppingCart;
//    }
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }

}
